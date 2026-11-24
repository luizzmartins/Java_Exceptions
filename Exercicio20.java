import java.util.function.Predicate;

// Predicate para números positivos
public class Exercicio20 {
    public static void main(String[] args) {
        Predicate<Integer> positivo = numero -> numero > 0;
        System.out.println(positivo.test(5));
        System.out.println(positivo.test(0));
        System.out.println(positivo.test(-3));
    }
}

