// Validação de idade
public class Exercicio11 {
    public static void main(String[] args) {
        try {
            validarIdade(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void validarIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("A idade não pode ser negativa.");
        }
    }
}

