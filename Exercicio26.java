import java.util.ArrayDeque;

// Pilha de ações para desfazer
public class Exercicio26 {
    public static void main(String[] args) {
        ArrayDeque<String> historico = new ArrayDeque<>();
        historico.push("Escreveu um título");
        historico.push("Escreveu um parágrafo");
        System.out.println("Desfez: " + historico.pop());
        System.out.println("Última ação restante: " + historico.peek());
    }
}

