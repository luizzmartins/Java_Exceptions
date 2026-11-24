import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

// Índice invertido de palavras
public class Exercicio45 {
    public static void main(String[] args) {
        Map<String, Set<Integer>> indice = new TreeMap<>();
        indexar(indice, 1, "Java e listas");
        indexar(indice, 2, "Java, Java e mapas");
        indexar(indice, 3, "Listas e mapas");
        System.out.println(indice);
    }

    static void indexar(Map<String, Set<Integer>> indice, int id, String documento) {
        String[] palavras = documento.toLowerCase(Locale.ROOT).split("[^\\p{L}\\p{N}]+");
        for (String palavra : palavras) {
            if (!palavra.isEmpty()) {
                indice.computeIfAbsent(palavra, chave -> new TreeSet<>()).add(id);
            }
        }
    }
}

