import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduzca la cantidad de números a factorizar: ");
        int cantidadFactorizar = scanner.nextInt();

        if (cantidadFactorizar <= 0) {
            System.out.println("Introduzca un número válido.");
            return;
        }

        List<Integer> numerosAFactorizar = new ArrayList<>();
        List<Integer> resultadosFactoriales = new ArrayList<>();

        for (int i = 0; i < cantidadFactorizar; i++) {
            System.out.print((i + 1) + "- Introduzca qué número desea factorizar: ");
            int numFactorizar = scanner.nextInt();

            CalcularFactorial hilo = new CalcularFactorial(numFactorizar);
            hilo.start();

            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            numerosAFactorizar.add(numFactorizar);
            resultadosFactoriales.add(hilo.getResultado());
        }
        
        Collections.sort(numerosAFactorizar, Collections.reverseOrder());
        Collections.sort(resultadosFactoriales, Collections.reverseOrder());

        for (int i = 0; i < cantidadFactorizar; i++) {
            System.out.println("Número: " + numerosAFactorizar.get(i) + ", Resultado: " + resultadosFactoriales.get(i));
        }
    }
}