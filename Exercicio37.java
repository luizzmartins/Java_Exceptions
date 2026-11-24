import java.util.ArrayList;
import java.util.List;

// PECS com ? super Integer
public class Exercicio37 {
    public static void main(String[] args) {
        List<Number> numeros = new ArrayList<>();
        numeros.add(1.5);
        preencher(numeros);
        System.out.println(numeros);
    }

    // PECS: extends para ler valores do tipo esperado e super para inserir.
    // A lista recebe Integer, mas uma leitura pelo wildcard só garante Object.
    static void preencher(List<? super Integer> numeros) {
        numeros.add(10);
        numeros.add(20);
    }
}

