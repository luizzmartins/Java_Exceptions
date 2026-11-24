// Exceção de estoque insuficiente
public class Exercicio21 {
    public static void main(String[] args) {
        try {
            System.out.println("Estoque restante: " + retirar(3, 5));
        } catch (EstoqueInsuficienteException e) {
            System.out.println(e.getMessage());
        }
    }

    static int retirar(int estoque, int quantidade) throws EstoqueInsuficienteException {
        if (quantidade > estoque) {
            throw new EstoqueInsuficienteException("Unidades disponíveis: " + estoque);
        }
        return estoque - quantidade;
    }

    static class EstoqueInsuficienteException extends Exception {
        EstoqueInsuficienteException(String mensagem) {
            super(mensagem);
        }
    }
}

