import java.util.ArrayList;
import java.util.LinkedList;

// Operações no início e no fim das listas
public class Exercicio25 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        array.add("Meio");
        array.add(0, "Início");
        array.add("Fim");
        System.out.println("ArrayList: " + array);
        array.remove(0);
        array.remove(array.size() - 1);

        LinkedList<String> ligada = new LinkedList<>();
        ligada.add("Meio");
        ligada.addFirst("Início");
        ligada.addLast("Fim");
        System.out.println("LinkedList: " + ligada);
        ligada.removeFirst();
        ligada.removeLast();

        System.out.println("Depois das remoções: " + array + " e " + ligada);
        System.out.println("LinkedList é adequada para alterações frequentes nas duas pontas.");
        System.out.println("ArrayList é adequada para acesso por índice e alterações no final.");
    }
}

