import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Ordenação crescente e decrescente
public class Exercicio17 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>(List.of(7, 2, 5, 1));
        Collections.sort(numeros);
        System.out.println("Crescente: " + numeros);
        numeros.sort(Collections.reverseOrder());
        System.out.println("Decrescente: " + numeros);
    }
}

