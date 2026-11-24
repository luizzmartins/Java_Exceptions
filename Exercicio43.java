import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

// Cache genérico
public class Exercicio43 {
    public static void main(String[] args) {
        Cache<String, Integer> cache = new Cache<>();
        Function<String, Integer> calcular = texto -> {
            System.out.println("Calculando para " + texto);
            return texto.length();
        };
        System.out.println(cache.getOrCompute("Java", calcular));
        System.out.println(cache.getOrCompute("Java", calcular));
    }

    static class Cache<K, V> {
        private final Map<K, V> valores = new HashMap<>();

        V getOrCompute(K chave, Function<K, V> calcular) {
            return valores.computeIfAbsent(chave, calcular);
        }
    }
}

