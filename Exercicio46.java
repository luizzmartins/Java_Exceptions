import java.util.DoubleSummaryStatistics;
import java.util.List;

// Estatísticas de números
public class Exercicio46 {
    public static void main(String[] args) {
        System.out.println(calcular(List.of(2, 4, 6)));
        System.out.println(calcular(List.of(1.5, 2.5, 3.5)));
    }

    static DoubleSummaryStatistics calcular(List<? extends Number> valores) {
        if (valores.isEmpty()) {
            throw new IllegalArgumentException("Informe pelo menos um número.");
        }
        DoubleSummaryStatistics estatisticas = new DoubleSummaryStatistics();
        for (Number valor : valores) {
            estatisticas.accept(valor.doubleValue());
        }
        return estatisticas;
    }
}

