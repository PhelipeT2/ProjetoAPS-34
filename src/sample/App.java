package sample;

import javax.swing.*;
import java.util.Random;

public class App {
    public static void main(String args[]) {

        //System.out.println("Thread 1 Start");
        //Thread t1 = new Thread(new Task("Thread-A"));
        //t1.start();
        //System.out.println("Thread 2 Start");
        //Thread t2 = new Thread(new Task("Thread-B"));
        //t2.start();

        int vetor[] = gerarVetor(900000);

//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.BubbleSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.SelectionSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.MergeSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.QuickSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.HeapSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.InsertionSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.bogoSort)).start();
//        new Thread(new Sort(vetor.clone(), sortingAlgorithm.shellSort)).start();

        try {
            Sort sort = new Sort(vetor.clone(), sortingAlgorithm.shellSort);
            Thread t = new Thread(sort);
            t.start();
            t.join();
            t.interrupt();

            long value = sort.getTempo();
            System.out.println(value);
            /// Exemplo implementado aqui
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }


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
    private String nameSort;
    private long tempo;

    public Sort(int[] vetor, sortingAlgorithm ag) {
        this.vetor = vetor;
        this.sortingAlgorithm = ag;
    }
    public long getTempo(){
        return this.tempo;
    }
    public String getNameSort(){
        return this.nameSort;
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
                    nameSort =  "bubbleSort";
                    break;
                case QuickSort:
                    System.out.println("\nExecutando QuickSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.QuickSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " QuickSort");
                    nameSort =  "quickSort";
                    break;
                case SelectionSort:
                    System.out.println("\nExecutando SelectionSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.SelectionSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " SelectionSort");
                    nameSort =  "selectionSort";
                    break;
                case MergeSort:
                    System.out.println("\nExecutando MergeSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.MergeSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " MergeSort");
                    nameSort =  "mergeSort";
                    break;
                case HeapSort:
                    System.out.println("\nExecutando HeapSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.HeapSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " HeapSort");
                    nameSort =  "heapSort";
                    break;
                case InsertionSort:
                    System.out.println("\nExecutando InsertionSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.InserionSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " InsertionSort");
                    nameSort =  "insertionSort";
                    break;
                case bogoSort:
                    System.out.println("\nExecutando BogoSort...");
                    System.out.println("bug");
                    startTime = System.nanoTime();
                    Exibe(sort.bogoSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " BogoSort");
                    nameSort =  "bogoSort";
                    break;
                case shellSort:
                    System.out.println("\nExecutando ShellSort...");
                    startTime = System.nanoTime();
                    Exibe(sort.shellSort(this.vetor.clone()));
                    startTime = (System.nanoTime() - startTime);
                    System.out.println("\nTempo percorrido: " + (startTime / 1000000) + "ms" + " ShellSort");
                    nameSort =  "shellSort";
                    break;
                default:
                    throw new Exception("\nMetodo não implementado");
            }
            tempo = (startTime / 1000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Exibe(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}

