package parte3;

public class BusquedaHilo extends Thread {
    private int[] vector;
    private int valorBuscado;
    private int inicio;
    private int fin;
    private boolean encontrado = false;
    private int posicionEncontrada;
    private int numeroHilo;

    public BusquedaHilo(int[] vector, int valorBuscado, int inicio, int fin, int numeroHilo) {
        this.vector = vector;
        this.valorBuscado = valorBuscado;
        this.inicio = inicio;
        this.fin = fin;
        this.numeroHilo = numeroHilo;
    }

    @Override
    public void run() {
        buscar();
    }

    private void buscar() {
        for (int i = inicio; i <= fin; i++) {
            if (vector[i] == valorBuscado) {
                encontrado = true;
                posicionEncontrada = i;
                System.out.println("Hilo " + numeroHilo + " encontró el valor " + valorBuscado + " en la posición " + posicionEncontrada);
                return;
            }
        }
        System.out.println("Hilo " + numeroHilo + " no encontró el valor " + valorBuscado);
    }

    public boolean encontrado() {
        return encontrado;
    }

    public int getPosicionEncontrada() {
        return posicionEncontrada;
    }

    public int getNumeroHilo() {
        return numeroHilo;
    }
}