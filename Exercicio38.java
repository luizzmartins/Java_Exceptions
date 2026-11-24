import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Comparator anônimo, lambda e comparing
public class Exercicio38 {
    public static void main(String[] args) {
        List<String> nomes = List.of("Carla", "Ana", "Bruno");
        Comparator<String> anonimo = new Comparator<String>() {
            @Override
            public int compare(String primeiro, String segundo) {
                return primeiro.compareTo(segundo);
            }
        };
        Comparator<String> lambda = (primeiro, segundo) -> primeiro.compareTo(segundo);
        Comparator<String> comparing = Comparator.comparing(nome -> nome);
        mostrarOrdenacao(nomes, anonimo);
        mostrarOrdenacao(nomes, lambda);
        mostrarOrdenacao(nomes, comparing);
    }

    static void mostrarOrdenacao(List<String> nomes, Comparator<String> comparador) {
        List<String> copia = new ArrayList<>(nomes);
        copia.sort(comparador);
        System.out.println(copia);
    }
}

