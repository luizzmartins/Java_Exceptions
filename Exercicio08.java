import java.util.Iterator;
import java.util.List;

// Percorrendo uma lista com Iterator
public class Exercicio08 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(10, 20, 30);
        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

