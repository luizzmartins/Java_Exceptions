import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// Alunos agrupados por turma
public class Exercicio35 {
    public static void main(String[] args) {
        Map<String, List<String>> turmas = new LinkedHashMap<>();
        adicionar(turmas, "A", "Ana");
        adicionar(turmas, "B", "Bruno");
        adicionar(turmas, "A", "Carla");
        System.out.println(turmas);
    }

    static void adicionar(Map<String, List<String>> turmas, String turma, String aluno) {
        turmas.computeIfAbsent(turma, chave -> new ArrayList<>()).add(aluno);
    }
}

