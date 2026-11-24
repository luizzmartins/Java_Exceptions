import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Multimap genérico
public class Exercicio44 {
    public static void main(String[] args) {
        Multimap<String, String> cursos = new Multimap<>();
        cursos.adicionar("Java", "Ana");
        cursos.adicionar("Java", "Bruno");
        cursos.adicionar("SQL", "Carla");
        System.out.println(cursos.buscar("Java"));
        System.out.println(cursos.buscar("Python"));
    }

    static class Multimap<K, V> {
        private final Map<K, List<V>> dados = new HashMap<>();

        void adicionar(K chave, V valor) {
            dados.computeIfAbsent(chave, item -> new ArrayList<>()).add(valor);
        }

        List<V> buscar(K chave) {
            return List.copyOf(dados.getOrDefault(chave, List.of()));
        }
    }
}

