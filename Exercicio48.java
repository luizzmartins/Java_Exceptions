import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Faturamento por vendedor, do maior para o menor
public class Exercicio48 {
    public static void main(String[] args) {
        List<Venda> vendas = List.of(new Venda("Ana", 100), new Venda("Bruno", 80),
                new Venda("Ana", 50), new Venda("Carla", 200));
        Map<String, Double> totais = vendas.stream()
                .collect(Collectors.groupingBy(Venda::vendedor, Collectors.summingDouble(Venda::valor)));
        totais.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entrada -> System.out.println(entrada.getKey() + " - R$ " + entrada.getValue()));
    }

    record Venda(String vendedor, double valor) {}
}

