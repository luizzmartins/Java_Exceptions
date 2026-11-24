import java.util.HashMap;

// Consulta de estoque
public class Exercicio06 {
    public static void main(String[] args) {
        HashMap<String, Integer> estoque = new HashMap<>();
        estoque.put("Arroz", 10);
        estoque.put("Feijão", 8);
        estoque.put("Leite", 5);
        System.out.println("Estoque de arroz: " + estoque.get("Arroz"));
    }
}

