import java.util.ArrayList;
import java.util.List;

// Importador que acumula erros por linha
public class Exercicio41 {
    public static void main(String[] args) {
        List<String> linhas = List.of("10", "abc", "0", "5");
        List<Integer> quantidades = new ArrayList<>();
        List<String> erros = new ArrayList<>();
        for (int i = 0; i < linhas.size(); i++) {
            try {
                quantidades.add(lerQuantidade(linhas.get(i)));
            } catch (IllegalArgumentException e) {
                erros.add("Linha " + (i + 1) + ": " + e.getMessage());
            }
        }
        System.out.println("Importados: " + quantidades);
        for (String erro : erros) {
            System.out.println(erro);
        }
    }

    // A validação lança por linha. O importador coleta a mensagem e continua.
    static int lerQuantidade(String linha) {
        int quantidade;
        try {
            quantidade = Integer.parseInt(linha.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Digite um número inteiro.", e);
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser positiva.");
        }
        return quantidade;
    }
}

