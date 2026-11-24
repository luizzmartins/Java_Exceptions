import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Ordenação de alunos por nome e nota
public class Exercicio28 {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno("Carla", 8));
        alunos.add(new Aluno("Ana", 9));
        alunos.add(new Aluno("Bruno", 7));
        Comparator<Aluno> porNome = Comparator.comparing(Aluno::nome);
        Comparator<Aluno> porNota = Comparator.comparingDouble(Aluno::nota);
        alunos.sort(porNome);
        System.out.println("Por nome: " + alunos);
        alunos.sort(porNota);
        System.out.println("Por nota: " + alunos);
    }

    record Aluno(String nome, double nota) {}
}

