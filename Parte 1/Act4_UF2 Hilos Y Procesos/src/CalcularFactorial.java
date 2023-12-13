public class CalcularFactorial extends Thread {
    private int num;
    private int resultado;

    public CalcularFactorial(int numFactorizar) {
        this.num = numFactorizar;
    }

    @Override
    public void run() {
        resultado = calcularFactorial(num);
    }
    
    private int calcularFactorial(int numFactorizar) {
        if (numFactorizar == 0 || numFactorizar == 1) {
            return 1;
        } else {
            return numFactorizar * calcularFactorial(numFactorizar - 1);
        }
    }

    public int getResultado() {
        return resultado;
    }
}