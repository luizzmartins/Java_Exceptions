import java.util.Locale;
import java.util.function.Function;

// Linha de relatório com Function
public class Exercicio39 {
    public static void main(String[] args) {
        Produto produto = new Produto("Mouse", 80);
        Function<Produto, String> formatar = p -> String.format(Locale.forLanguageTag("pt-BR"),
                "%s - R$ %.2f", p.nome(), p.preco());
        System.out.println(formatar.apply(produto));
    }

    record Produto(String nome, double preco) {}
}

