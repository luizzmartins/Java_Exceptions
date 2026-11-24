import java.util.List;
import java.util.function.Predicate;

// Filtros combináveis
public class Exercicio47 {
    public static void main(String[] args) {
        List<Integer> numeros = List.of(-4, -3, 0, 2, 5);
        Predicate<Integer> positivo = numero -> numero > 0;
        Predicate<Integer> par = numero -> numero % 2 == 0;
        System.out.println("Positivo e par: " + Filtragem.aplicar(numeros, positivo.and(par)));
        System.out.println("Positivo ou par: " + Filtragem.aplicar(numeros, positivo.or(par)));
        System.out.println("Ímpar: " + Filtragem.aplicar(numeros, par.negate()));
    }

    static class Filtragem {
        static <T> List<T> aplicar(List<T> valores, Predicate<T> filtro) {
            return valores.stream().filter(filtro).toList();
        }
    }
}

