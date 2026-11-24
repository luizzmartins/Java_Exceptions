// Fechamento automático de recurso
public class Exercicio23 {
    public static void main(String[] args) {
        try (Recurso recurso = new Recurso()) {
            recurso.usar();
        }
        System.out.println("Fim do programa.");
    }

    static class Recurso implements AutoCloseable {
        void usar() {
            System.out.println("Usando o recurso.");
        }

        @Override
        public void close() {
            System.out.println("Recurso fechado.");
        }
    }
}

