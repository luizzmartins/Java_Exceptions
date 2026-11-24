// Caixa genérica
public class Exercicio19 {
    public static void main(String[] args) {
        Caixa<String> caixaTexto = new Caixa<>("Java");
        Caixa<Integer> caixaNumero = new Caixa<>(10);
        System.out.println(caixaTexto.getValor());
        System.out.println(caixaNumero.getValor());
    }

    static class Caixa<T> {
        private final T valor;

        Caixa(T valor) {
            this.valor = valor;
        }

        T getValor() {
            return valor;
        }
    }
}

