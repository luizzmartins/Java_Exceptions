import java.util.ArrayDeque;
import java.util.Queue;

// Fila de chamados
public class Exercicio07 {
    public static void main(String[] args) {
        Queue<String> chamados = new ArrayDeque<>();
        chamados.offer("Chamado 1");
        chamados.offer("Chamado 2");
        chamados.offer("Chamado 3");
        System.out.println("Atendido: " + chamados.poll());
        System.out.println("Fila: " + chamados);
    }
}

