// Conversão de texto para inteiro
public class Exercicio02 {
    public static void main(String[] args) {
        String[] textos = {"123", "abc"};
        for (String texto : textos) {
            try {
                System.out.println(Integer.parseInt(texto));
            } catch (NumberFormatException e) {
                System.out.println("Número inválido: " + texto);
            }
        }
    }
}

