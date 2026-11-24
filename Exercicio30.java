import java.util.List;

// Soma de listas de números
public class Exercicio30 {
    public static void main(String[] args) {
        System.out.println(somar(List.of(1, 2, 3)));
        System.out.println(somar(List.of(1.5, 2.5)));
    }

    static double somar(List<? extends Number> valores) {
        double soma = 0;
        for (Number valor : valores) {
            soma += valor.doubleValue();
        }
        return soma;
    }
}

