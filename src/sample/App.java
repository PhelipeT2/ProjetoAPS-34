package sample;

import java.util.Random;

public class App {
    public static void main(String args[]) {

        //System.out.println("Thread 1 Start");
        //Thread t1 = new Thread(new Task("Thread-A"));
        //t1.start();
        //System.out.println("Thread 2 Start");
        //Thread t2 = new Thread(new Task("Thread-B"));
        //t2.start();

        int vetor[] = gerarVetor(100000);
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.BubbleSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.SelectionSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.MergeSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.QuickSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.HeapSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.InsertionSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.bogoSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.shellSort)).start();

        Sort sort = new Sort(vetor.clone(),sortingAlgorithm.bogoSort);
        new Thread(sort).start();
        long value = sort.getTempo();
        /// Exemplo implementado aqui



    }

    public static int[] gerarVetor(int n) {
        int[] v = new int[n];
        Random gerador = new Random();
        for (int i = 0; i < n; i++) {
            v[i] = gerador.nextInt(100000);
        }
        return v;
    }

}

class Sort implements Runnable {

    int[] vetor;
    sortingAlgorithm sortingAlgorithm;
    long tempo;

    public Sort(int[] vetor, sortingAlgorithm ag) {
        this.vetor = vetor;
        this.sortingAlgorithm = ag;
    }
    public long getTempo(){
        return this.tempo;
    }

    @Override
    public void run() {
        try {
            Sorts.Sort sort = new Sorts.Sort();
            long startTime = System.nanoTime();
            switch (sortingAlgorithm) {
                case BubbleSort:
                    System.out.println("\nExecutando BubbleSort...");
                    Exibe(sort.BubbleSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " BubbleSort");
                    tempo = (startTime / 1000000);
                    break;
                case QuickSort:
                    System.out.println("\nExecutando QuickSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.QuickSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " QuickSort");
                    break;
                case SelectionSort:
                    System.out.println("\nExecutando SelectionSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.SelectionSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " SelectionSort");
                    break;
                case MergeSort:
                    System.out.println("\nExecutando MergeSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.MergeSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " MergeSort");
                    break;
                case HeapSort:
                    System.out.println("\nExecutando HeapSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.HeapSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " HeapSort");
                    break;
                case InsertionSort:
                    System.out.println("\nExecutando InsertionSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.InserionSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " InsertionSort");
                    break;
                case bogoSort:
                    System.out.println("\nExecutando BogoSort...");
                    System.out.println("bug");
                    startTime = System.nanoTime();
                    Exibe(sort.bogoSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " BogoSort");
                    break;
                case shellSort:
                    System.out.println("\nExecutando ShellSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.shellSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " ShellSort");
                    break;
                default:
                    throw new Exception("\nMetodo não implementado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Exibe(int[] vetor) {
        for (int i = 0; i < vetor.length - 1; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}

class Task implements Runnable {

    String name;

    public Task(String name) {
        this.name = name;
    }

    public void run() {
        Thread.currentThread().setName(this.name);
        for (int i = 0; i < 200; i++) {
            System.out.println("number: " + i + " - " + Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
