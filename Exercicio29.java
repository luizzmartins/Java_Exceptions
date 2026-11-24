// Último elemento de um array genérico
public class Exercicio29 {
    public static void main(String[] args) {
        String[] nomes = {"Ana", "Bruno"};
        Integer[] numeros = {10, 20, 30};
        System.out.println(ultimo(nomes));
        System.out.println(ultimo(numeros));
    }

    static <T> T ultimo(T[] valores) {
        if (valores.length == 0) {
            throw new IllegalArgumentException("O array está vazio.");
        }
        return valores[valores.length - 1];
    }
}

