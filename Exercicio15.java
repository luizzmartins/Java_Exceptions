import java.util.HashMap;

// Frequência de palavras
public class Exercicio15 {
    public static void main(String[] args) {
        String[] palavras = {"java", "lista", "java", "mapa", "java"};
        HashMap<String, Integer> frequencias = new HashMap<>();
        for (String palavra : palavras) {
            frequencias.merge(palavra, 1, Integer::sum);
        }
        System.out.println(frequencias);
    }
}

