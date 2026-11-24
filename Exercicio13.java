// Dois catches específicos
public class Exercicio13 {
    public static void main(String[] args) {
        String[] nomes = {"Ana", "Bruno"};
        String[] entradas = {"abc", "5", "1"};
        for (String entrada : entradas) {
            try {
                int indice = Integer.parseInt(entrada);
                System.out.println(nomes[indice]);
            } catch (NumberFormatException e) {
                System.out.println("Digite um índice inteiro.");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Índice fora do array.");
            }
        }
    }
}

