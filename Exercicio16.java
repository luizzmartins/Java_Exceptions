import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Remoção de pares com Iterator
public class Exercicio16 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        Iterator<Integer> iterator = numeros.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(numeros);
    }
}

