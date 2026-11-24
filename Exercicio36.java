import java.util.HashMap;
import java.util.Map;

// Repositório genérico por ID
public class Exercicio36 {
    public static void main(String[] args) {
        Repositorio<String, Integer> nomes = new Repositorio<>();
        nomes.salvar(1, "Ana");
        System.out.println(nomes.buscarPorId(1));
    }

    static class Repositorio<T, ID> {
        private final Map<ID, T> dados = new HashMap<>();

        void salvar(ID id, T item) {
            dados.put(id, item);
        }

        T buscarPorId(ID id) {
            return dados.get(id);
        }
    }
}

