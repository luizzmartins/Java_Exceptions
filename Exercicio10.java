// Saudação com lambda
public class Exercicio10 {
    public static void main(String[] args) {
        Saudacao saudacao = nome -> System.out.println("Olá, " + nome + "!");
        saudacao.cumprimentar("Ana");
    }

    @FunctionalInterface
    interface Saudacao {
        void cumprimentar(String nome);
    }
}

