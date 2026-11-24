// Serviço com mensagens diferentes para cada falha
public class Exercicio42 {
    public static void main(String[] args) {
        Servico servico = new Servico();
        int[] tentativas = {0, 10, 2};
        for (int quantidade : tentativas) {
            try {
                servico.comprar(quantidade);
                System.out.println("Compra realizada.");
            } catch (QuantidadeInvalidaException e) {
                System.out.println("Informe pelo menos uma unidade.");
            } catch (EstoqueInsuficienteException e) {
                System.out.println("Reduza a quantidade. Estoque atual: " + e.getMessage());
            }
        }
    }

    static class Servico {
        private int estoque = 5;

        void comprar(int quantidade) throws QuantidadeInvalidaException, EstoqueInsuficienteException {
            if (quantidade <= 0) {
                throw new QuantidadeInvalidaException();
            }
            if (quantidade > estoque) {
                throw new EstoqueInsuficienteException(estoque);
            }
            estoque -= quantidade;
        }
    }

    static class QuantidadeInvalidaException extends Exception {
        QuantidadeInvalidaException() {
            super("Quantidade menor que 1.");
        }
    }

    static class EstoqueInsuficienteException extends Exception {
        EstoqueInsuficienteException(int estoque) {
            super(String.valueOf(estoque));
        }
    }
}

