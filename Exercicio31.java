// Exceção com limite de crédito disponível
public class Exercicio31 {
    public static void main(String[] args) {
        try {
            comprar(150, 100);
        } catch (LimiteCreditoException e) {
            System.out.println(e.getMessage());
            System.out.println("Limite disponível: R$ " + e.getDisponivel());
        }
    }

    static void comprar(double valor, double limite) throws LimiteCreditoException {
        if (valor > limite) {
            throw new LimiteCreditoException("Limite de crédito insuficiente.", limite);
        }
        System.out.println("Compra aprovada.");
    }

    static class LimiteCreditoException extends Exception {
        private final double disponivel;

        LimiteCreditoException(String mensagem, double disponivel) {
            super(mensagem);
            this.disponivel = disponivel;
        }

        double getDisponivel() {
            return disponivel;
        }
    }
}

