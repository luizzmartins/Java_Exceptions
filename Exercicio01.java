// Divisão inteira por zero
public class Exercicio01 {
    public static void main(String[] args) {
        int divisor = 0;
        try {
            System.out.println(10 / divisor);
        } catch (ArithmeticException e) {
            System.out.println("Não é possível dividir por zero.");
        }
    }
}

