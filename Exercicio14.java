import java.util.HashSet;
import java.util.List;

// Remoção de IDs duplicados
public class Exercicio14 {
    public static void main(String[] args) {
        List<Integer> ids = List.of(1, 2, 1, 3, 2);
        HashSet<Integer> idsUnicos = new HashSet<>(ids);
        System.out.println(idsUnicos);
    }
}

