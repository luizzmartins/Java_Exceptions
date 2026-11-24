import java.util.ArrayList;

// Tamanho e índice do ArrayList
public class Exercicio03 {
    public static void main(String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Ana");
        nomes.add("Bruno");
        nomes.add("Carla");
        System.out.println("Tamanho: " + nomes.size());
        System.out.println("Índice 1: " + nomes.get(1));
    }
}

