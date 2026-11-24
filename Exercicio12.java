// Mensagem com finally
public class Exercicio12 {
    public static void main(String[] args) {
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (NumberFormatException e) {
            System.out.println("Número inválido.");
        } finally {
            System.out.println("Tentativa de conversão encerrada.");
        }
    }
}

