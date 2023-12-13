import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {

    public static void main(String[] args) {
        System.out.print("Introduce el número: ");
        int numPotencias = new java.util.Scanner(System.in).nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(numPotencias);
        List<String> resultados = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < numPotencias; i++) {
            executorService.submit(new CalcularPotencia(i, resultados));
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        Collections.sort(resultados);
        resultados.forEach(System.out::println);
    }
}
