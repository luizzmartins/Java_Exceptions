import java.util.HashMap;
import java.util.Map;

// Catálogo de produtos
public class Exercicio24 {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        catalogo.cadastrar(new Produto(1, "Mouse"));
        System.out.println(catalogo.buscar(1));
        catalogo.remover(1);
        System.out.println("Depois de remover: " + catalogo.buscar(1));
    }

    record Produto(int id, String nome) {}

    static class Catalogo {
        private final Map<Integer, Produto> produtos = new HashMap<>();

        void cadastrar(Produto produto) {
            produtos.put(produto.id(), produto);
        }

        Produto buscar(int id) {
            return produtos.get(id);
        }

        void remover(int id) {
            produtos.remove(id);
        }
    }
}

