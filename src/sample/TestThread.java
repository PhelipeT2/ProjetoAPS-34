package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;

import java.net.URL;
import java.util.*;

import static sample.App.gerarVetor;

public class TestThread implements Initializable {

    List<Thread> listThread;
    List<Sort> listSort;

    @FXML
    private ProgressIndicator pi1;

    @FXML
    private ProgressIndicator pi6;

    @FXML
    private ProgressIndicator pi7;

    @FXML
    private ProgressIndicator pi5;

    @FXML
    private ProgressIndicator pi4;

    @FXML
    private ProgressIndicator pi3;

    @FXML
    private ProgressIndicator pi2;

    @FXML
    private ProgressIndicator pi8;

    @FXML
    private Label l1;//BubbleSort

    @FXML
    private Label l2;//SelectionSort

    @FXML
    private Label l3;//MergeSort

    @FXML
    private Label l4;//QuickSort

    @FXML
    private Label l5;//HeapSort

    @FXML
    private Label l6;//InsertSort

    @FXML
    private Label l7;//BogoSort

    @FXML
    private Label l8;//ShellSort


    @FXML
    void ButtonStart(ActionEvent event) {
        int i = 0;
        int vetor[] = gerarVetor(10000);
        Thread shellSortT, bogoSortT, insertionSortT, heapSortT, bubbleSortT, selectionSortT, mergeSortT, quickSortT;
        Sort shellSort, bogoSort, insertionSort, heapSort, bubbleSort, selectionSort, mergeSort, quickSort;
        shellSort = new Sort(vetor.clone(), sortingAlgorithm.shellSort);
        bogoSort = new Sort(vetor.clone(), sortingAlgorithm.bogoSort);
        insertionSort = new Sort(vetor.clone(), sortingAlgorithm.InsertionSort);
        heapSort = new Sort(vetor.clone(), sortingAlgorithm.HeapSort);
        bubbleSort = new Sort(vetor.clone(), sortingAlgorithm.BubbleSort);
        selectionSort = new Sort(vetor.clone(), sortingAlgorithm.SelectionSort);
        mergeSort = new Sort(vetor.clone(), sortingAlgorithm.MergeSort);
        quickSort = new Sort(vetor.clone(), sortingAlgorithm.QuickSort);
        listSort = new ArrayList<>();
        listSort.add(shellSort);
        //listSort.add(bogoSort);
        listSort.add(insertionSort);
        listSort.add(heapSort);
        listSort.add(bubbleSort);
        listSort.add(selectionSort);
        listSort.add(mergeSort);
        listSort.add(quickSort);


        shellSortT = new Thread(shellSort);
        shellSortT.setName("shellSort");
        bogoSortT = new Thread(bogoSort);
        bogoSortT.setName("bogoSort");
        insertionSortT = new Thread(insertionSort);
        insertionSortT.setName("insertionSort");
        heapSortT = new Thread(heapSort);
        heapSortT.setName("heapSort");
        bubbleSortT = new Thread(bubbleSort);
        bubbleSortT.setName("bubbleSort");
        selectionSortT = new Thread(selectionSort);
        selectionSortT.setName("selectionSort");
        mergeSortT = new Thread(mergeSort);
        mergeSortT.setName("mergeSort");
        quickSortT = new Thread(quickSort);
        quickSortT.setName("quickSort");
        listThread = new ArrayList<Thread>();
        listThread.add(shellSortT);
        //listThread.add(bogoSortT);
        listThread.add(insertionSortT);
        listThread.add(heapSortT);
        listThread.add(bubbleSortT);
        listThread.add(selectionSortT);
        listThread.add(mergeSortT);
        listThread.add(quickSortT);
        for (Thread item: listThread) {
            item.start();
        }
        while (!listThread.isEmpty()){
            Iterator<Thread> ite = listThread.iterator();
            while(ite.hasNext()){
                Thread item = ite.next();
                if(!item.isAlive()){
                    for (Sort sort:listSort) {
                        if(item.getName().equals(sort.getNameSort())){
                            //JOptionPane.showMessageDialog(null, sort.getTempo());
                            System.out.println("|| "+item.getName()+" || seu tempo foi: "+sort.getTempo());
                            ite.remove();
                            switch(item.getName()){
                                case "shellSort":
                                    l8.setText(Objects.toString(sort.getTempo(),null));
                                    pi8.setVisible(false);
                                    break;
                                case "bogoSort":
                                    l7.setText(Objects.toString(sort.getTempo(),null));
                                    pi7.setVisible(false);
                                    break;
                                case "insertionSort":
                                    l6.setText(Objects.toString(sort.getTempo(),null));
                                    pi6.setVisible(false);
                                    break;
                                case "heapSort":
                                    l5.setText(Objects.toString(sort.getTempo(),null));
                                    pi5.setVisible(false);
                                    break;
                                case "bubbleSort":
                                    l1.setText(Objects.toString(sort.getTempo(),null));
                                    pi1.setVisible(false);
                                    break;
                                case "selectionSort":
                                    l2.setText(Objects.toString(sort.getTempo(),null));
                                    pi2.setVisible(false);
                                    break;
                                case "mergeSort":
                                    l3.setText(Objects.toString(sort.getTempo(),null));
                                    pi3.setVisible(false);
                                    break;
                                case "quickSort":
                                    l4.setText(Objects.toString(sort.getTempo(),null));pi8.setVisible(false);
                                    pi4.setVisible(false);
                                    break;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
