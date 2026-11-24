import java.util.HashSet;
import java.util.Set;

// Unicidade de produtos pelo ID
public class Exercicio34 {
    public static void main(String[] args) {
        Set<Produto> produtos = new HashSet<>();
        System.out.println(produtos.add(new Produto(1, "Mouse")));
        System.out.println(produtos.add(new Produto(1, "Teclado")));
        System.out.println("Tamanho: " + produtos.size());
        System.out.println(produtos);
    }

    static class Produto {
        private final int id;
        private final String nome;

        Produto(int id, String nome) {
            this.id = id;
            this.nome = nome;
        }

        @Override
        public boolean equals(Object objeto) {
            if (!(objeto instanceof Produto)) {
                return false;
            }
            Produto outro = (Produto) objeto;
            return id == outro.id;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(id);
        }

        @Override
        public String toString() {
            return nome;
        }
    }
}

