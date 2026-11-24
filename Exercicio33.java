import java.util.ArrayList;
import java.util.List;

// Cópia não modificável de uma lista
public class Exercicio33 {
    public static void main(String[] args) {
        Servico servico = new Servico();
        servico.adicionar("Ana");
        List<String> nomes = servico.listar();
        try {
            nomes.add("Bruno");
        } catch (UnsupportedOperationException e) {
            System.out.println("List.copyOf devolve uma lista que não aceita alterações.");
        }
        System.out.println(servico.listar());
    }

    static class Servico {
        private final List<String> nomes = new ArrayList<>();

        void adicionar(String nome) {
            nomes.add(nome);
        }

        List<String> listar() {
            return List.copyOf(nomes);
        }
    }
}

