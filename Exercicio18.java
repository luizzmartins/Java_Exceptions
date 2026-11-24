import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Produtos ordenados por preço
public class Exercicio18 {
    public static void main(String[] args) {
        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto("Mouse", 80));
        produtos.add(new Produto("Cabo", 20));
        produtos.add(new Produto("Teclado", 120));
        produtos.sort(Comparator.comparingDouble(Produto::preco));
        System.out.println(produtos);
    }

    record Produto(String nome, double preco) {}
}

