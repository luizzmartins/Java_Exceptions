import java.io.IOException;

// IOException declarada e tratada no main
public class Exercicio22 {
    public static void main(String[] args) {
        try {
            carregarArquivo();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void carregarArquivo() throws IOException {
        throw new IOException("Falha simulada ao carregar o arquivo.");
    }
}

