import java.util.List;

public class CalcularPotencia implements Runnable {
    private int exponente;
    private List<String> resultados;

    public CalcularPotencia(int exponente, List<String> resultados) {
        this.exponente = exponente;
        this.resultados = resultados;
    }

    @Override
    public void run() {
        long resultado = (long) Math.pow(2, exponente);
        String operacion = "2^" + exponente;

        synchronized (resultados) {
            resultados.add(operacion + " = " + resultado);
        }
    }
}
