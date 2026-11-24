// Parser com exceção de domínio e causa original
public class Exercicio32 {
    public static void main(String[] args) {
        try {
            System.out.println(lerQuantidade("12x"));
        } catch (QuantidadeInvalidaException e) {
            System.out.println(e.getMessage());
            System.out.println("Causa: " + e.getCause());
        }
    }

    static int lerQuantidade(String texto) throws QuantidadeInvalidaException {
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            throw new QuantidadeInvalidaException("A quantidade deve ser inteira.", e);
        }
    }

    static class QuantidadeInvalidaException extends Exception {
        QuantidadeInvalidaException(String mensagem, Throwable causa) {
            super(mensagem, causa);
        }
    }
}

