import java.util.HashSet;

// Nomes repetidos em HashSet
public class Exercicio05 {
    public static void main(String[] args) {
        HashSet<String> nomes = new HashSet<>();
        nomes.add("Ana");
        System.out.println("Antes: " + nomes.size());
        nomes.add("Ana");
        System.out.println("Depois: " + nomes.size());
    }
}

