import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

// Projeto integrador refatorado
public class Exercicio50 {
    public static void main(String[] args) {
        Servico servico = new Servico();
        servico.catalogo.salvar(1, new Produto("Mouse", 80, 5));
        servico.catalogo.salvar(2, new Produto("Teclado", 120, 3));
        Cliente ana = new Cliente("Ana");
        Cliente bruno = new Cliente("Bruno");

        Pedido primeiro = new Pedido(ana, List.of(new ItemPedido(1, 2)), "BEMVINDO");
        servico.fila.offer(primeiro);
        servico.fila.offer(new Pedido(bruno, List.of(new ItemPedido(2, 1)), ""));
        servico.processarFila();

        System.out.println("\nTestes de falha");
        servico.fila.offer(new Pedido(ana, List.of(new ItemPedido(1, 0)), ""));
        servico.fila.offer(new Pedido(ana, List.of(new ItemPedido(99, 1)), ""));
        servico.fila.offer(new Pedido(ana, List.of(new ItemPedido(1, 2), new ItemPedido(1, 2)), ""));
        servico.fila.offer(primeiro);
        servico.fila.offer(new Pedido(bruno, List.of(new ItemPedido(2, 1)), "BEMVINDO"));
        servico.processarFila();

        System.out.println("\nCatálogo por preço: " + servico.listarProdutos(POR_PRECO));
        System.out.println("Catálogo por estoque: " + servico.listarProdutos(POR_ESTOQUE));
        servico.mostrarRelatorio();
    }

    record Cliente(String nome) {}
    record ItemPedido(int produtoId, int quantidade) {}
    record Produto(String nome, double preco, int estoque) {}
    record Venda(Cliente cliente, double valor) {}

    enum Status {
        PENDENTE, CONCLUIDO
    }

    static class Pedido {
        final Cliente cliente;
        final List<ItemPedido> itens;
        final String cupom;
        Status status = Status.PENDENTE;

        Pedido(Cliente cliente, List<ItemPedido> itens, String cupom) {
            this.cliente = cliente;
            this.itens = List.copyOf(itens);
            this.cupom = cupom;
        }
    }

    static class Repositorio<T> {
        private final Map<Integer, T> dados = new HashMap<>();

        void salvar(int id, T item) {
            dados.put(id, item);
        }

        T buscar(int id) {
            return dados.get(id);
        }

        List<T> listar() {
            return new ArrayList<>(dados.values());
        }
    }

    static class PedidoInvalidoException extends Exception {
        PedidoInvalidoException(String mensagem) {
            super(mensagem);
        }
    }

    static class EstoqueInsuficienteException extends Exception {
        EstoqueInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }

    static final Comparator<Produto> POR_PRECO = Comparator.comparingDouble(Produto::preco);
    static final Comparator<Produto> POR_ESTOQUE = Comparator.comparingInt(Produto::estoque);
    static final Predicate<Produto> EM_ESTOQUE = produto -> produto.estoque() > 0;

    static class Servico {
        final Repositorio<Produto> catalogo = new Repositorio<>();
        final Queue<Pedido> fila = new ArrayDeque<>();
        private final Set<String> cuponsUsados = new HashSet<>();
        private final List<Venda> vendas = new ArrayList<>();

        void processarFila() {
            while (!fila.isEmpty()) {
                Pedido pedido = fila.poll();
                try {
                    double total = processar(pedido);
                    System.out.println("Venda de " + pedido.cliente.nome() + ": R$ " + total);
                } catch (PedidoInvalidoException e) {
                    System.out.println("Pedido inválido: " + e.getMessage());
                } catch (EstoqueInsuficienteException e) {
                    System.out.println("Estoque insuficiente: " + e.getMessage());
                }
            }
        }

        double processar(Pedido pedido) throws PedidoInvalidoException, EstoqueInsuficienteException {
            if (pedido.status != Status.PENDENTE) {
                throw new PedidoInvalidoException("O pedido já foi concluído.");
            }
            if (pedido.itens.isEmpty()) {
                throw new PedidoInvalidoException("O pedido está vazio.");
            }
            if (cuponsUsados.contains(pedido.cupom)) {
                throw new PedidoInvalidoException("Cupom já utilizado.");
            }

            Map<Integer, Produto> estoqueAtualizado = new HashMap<>();
            double total = 0;
            // O loop mantém a ordem das validações, pode lançar exceções e
            // usa o saldo já calculado quando o mesmo produto aparece novamente.
            for (ItemPedido item : pedido.itens) {
                if (item.quantidade() <= 0) {
                    throw new PedidoInvalidoException("A quantidade deve ser positiva.");
                }

                int id = item.produtoId();
                Produto produto = estoqueAtualizado.get(id);
                if (produto == null) {
                    produto = catalogo.buscar(id);
                }
                if (produto == null) {
                    throw new PedidoInvalidoException("Produto " + id + " não encontrado.");
                }
                if (item.quantidade() > produto.estoque()) {
                    throw new EstoqueInsuficienteException(produto.nome()
                            + " tem " + produto.estoque() + " unidade(s) disponível(is) neste pedido.");
                }

                int restante = produto.estoque() - item.quantidade();
                estoqueAtualizado.put(id, new Produto(produto.nome(), produto.preco(), restante));
                total += produto.preco() * item.quantidade();
            }

            // Só registra as alterações depois de validar todos os itens.
            for (Map.Entry<Integer, Produto> entrada : estoqueAtualizado.entrySet()) {
                catalogo.salvar(entrada.getKey(), entrada.getValue());
            }
            if (!pedido.cupom.isEmpty()) {
                cuponsUsados.add(pedido.cupom);
            }
            pedido.status = Status.CONCLUIDO;
            vendas.add(new Venda(pedido.cliente, total));
            return total;
        }

        List<Produto> listarProdutos(Comparator<Produto> ordem) {
            return catalogo.listar().stream()
                    .filter(EM_ESTOQUE)
                    .sorted(ordem)
                    .toList();
        }

        void mostrarRelatorio() {
            DoubleSummaryStatistics resumo = vendas.stream()
                    .mapToDouble(Venda::valor)
                    .summaryStatistics();

            // O relatório apenas agrupa e soma vendas já concluídas.
            // O Stream expressa a agregação sem alterar o estoque ou os pedidos.
            Map<String, Double> porCliente = vendas.stream()
                    .collect(Collectors.groupingBy(venda -> venda.cliente().nome(),
                            TreeMap::new, Collectors.summingDouble(Venda::valor)));

            System.out.println("\nFaturamento total: R$ " + resumo.getSum());
            System.out.println("Ticket médio: R$ " + resumo.getAverage());
            System.out.println("Vendas por cliente: " + porCliente);
        }
    }
}

