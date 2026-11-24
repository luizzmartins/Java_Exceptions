import java.util.Comparator;
import java.util.List;

// Stream de produtos em estoque
public class Exercicio40 {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(new Produto("Mouse", 80, 5),
                new Produto("Cabo", 20, 3), new Produto("Teclado", 120, 0));
        List<String> nomes = produtos.stream()
                .filter(produto -> produto.estoque() > 0)
                .sorted(Comparator.comparingDouble(Produto::preco))
                .map(Produto::nome)
                .toList();
        System.out.println(nomes);
    }

    record Produto(String nome, double preco, int estoque) {}
}

