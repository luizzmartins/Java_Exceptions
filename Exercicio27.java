import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Comparable por matrícula
public class Exercicio27 {
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        alunos.add(new Aluno(30, "Ana"));
        alunos.add(new Aluno(10, "Bruno"));
        alunos.add(new Aluno(20, "Carla"));
        Collections.sort(alunos);
        for (Aluno aluno : alunos) {
            System.out.println(aluno.matricula + " - " + aluno.nome);
        }
    }

    static class Aluno implements Comparable<Aluno> {
        private final int matricula;
        private final String nome;

        Aluno(int matricula, String nome) {
            this.matricula = matricula;
            this.nome = nome;
        }

        @Override
        public int compareTo(Aluno outro) {
            return Integer.compare(matricula, outro.matricula);
        }
    }
}

