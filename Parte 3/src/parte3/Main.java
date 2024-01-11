package parte3;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del vector: ");
        int tamanoVector = scanner.nextInt();

        System.out.print("Ingrese el valor a buscar: ");
        int valorBuscado = scanner.nextInt();

        System.out.print("Ingrese el número de hilos: ");
        int numHilos = scanner.nextInt();

        if (tamanoVector <= 0 || numHilos <= 0) {
            System.out.println("Por favor, ingrese valores positivos para el tamaño del vector y el número de hilos.");
            return;
        }

        int[] vector = generarVector(tamanoVector);
        BusquedaHilo[] hilos = new BusquedaHilo[numHilos];

        int elementosPorHilo = tamanoVector / numHilos;
        int inicio = 0;

        for (int i = 0; i < numHilos - 1; i++) {
            hilos[i] = new BusquedaHilo(vector, valorBuscado, inicio, inicio + elementosPorHilo - 1, i + 1);
            hilos[i].start();
            inicio += elementosPorHilo;
        }

        hilos[numHilos - 1] = new BusquedaHilo(vector, valorBuscado, inicio, tamanoVector - 1, numHilos);
        hilos[numHilos - 1].start();

        for (int i = 0; i < numHilos; i++) {
            try {
                hilos[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < numHilos; i++) {
            if (hilos[i].encontrado()) {
                System.out.println("El valor " + valorBuscado + " se encontró en la posición " + hilos[i].getPosicionEncontrada() + " (Hilo " + hilos[i].getNumeroHilo() + ")");
                return;
            }
        }

        System.out.println("El valor " + valorBuscado + " no se encontró en el vector.");
    }

    private static int[] generarVector(int tamano) {
        int[] vector = new int[tamano];
        Random rand = new Random();

        for (int i = 0; i < tamano; i++) {
            vector[i] = rand.nextInt(tamano);
        }

        return vector;
    }
}