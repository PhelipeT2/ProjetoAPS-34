package sample;

import Banco.Conexao;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

import static javax.swing.JOptionPane.YES_OPTION;
import static sample.App.gerarVetor;

public class TestThread implements Initializable {

    List<Thread> listThread;
    List<Sort> listSort;
    Thread th;
    TestandoSort ts;

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
    private PieChart pieChart1;

    @FXML
    private JFXButton btnLimpar;

    @FXML
    private TableView<TabelaCliente> tabelaCliente;

    @FXML
    private TableColumn<TabelaCliente, String> colCpf;

    @FXML
    private TableColumn<TabelaCliente, String> colNome;

    @FXML
    private TableColumn<TabelaCliente, String> colTelefone;

    Stage stage = null;

    Conexao conexao = new Conexao();

    @FXML
    void ButtonCancel(ActionEvent event) {
        if (th != null) {
            ts.stopThread();
            th.stop();
        } else {
            System.out.println("Inicie o processo antes!");
        }
    }

    @FXML
    void botaoLimpar(MouseEvent event) {
        int opcao = JOptionPane.showConfirmDialog(null,
                "Deseja realmente limpar os dados ?",
                "Limpar Dados",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (opcao == YES_OPTION) {
            /*l1.clear()//BubbleSort
            l2.clear();//SelectionSort
            l3.clear();//MergeSort
            l4.clear();//QuickSort
            l5.clear();//HeapSort
            l6.clear();//InsertSort
            l7.clear();//BogoSort
            l8.clear();//ShellSort*/

            //Name.clear(); variaveis que preciso limpar  < exemplo.
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("cadastro.fxml"));
        }
    }

    @FXML
    void ButtonStart(ActionEvent event) {

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
        listSort.add(bogoSort);
        listSort.add(insertionSort);
        listSort.add(heapSort);
        listSort.add(bubbleSort);
        listSort.add(selectionSort);
        listSort.add(mergeSort);
        listSort.add(quickSort);


        shellSortT = new Thread(shellSort);
        shellSortT.setName("shellSort");
        //bogoSortT = new Thread(bogoSort);
        //bogoSortT.setName("bogoSort");
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

        ts = new TestandoSort(vetor, listThread, listSort, l1, l2, l3, l4, l5, l6, l7, l8, pieChart1);
        th = new Thread(ts);
        th.setDaemon(true);
        th.start();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        assert tabelaCliente != null : "fx:id=\"tableview\" was not injected: check your FXML file 'UserMaster.fxml'.";
        colCpf.setCellValueFactory(
                new PropertyValueFactory<TabelaCliente, String>("clienteCpf"));
        colNome.setCellValueFactory(
                new PropertyValueFactory<TabelaCliente, String>("clienteNome"));
        colTelefone.setCellValueFactory(
                new PropertyValueFactory<TabelaCliente, String>("clienteTelefone"));
    }

    private ObservableList<TabelaCliente> data;

    @FXML
    void acaoBuscar(ActionEvent event) {
        data = FXCollections.observableArrayList();
        try {
            Conexao conexao = new Conexao();
            ResultSet rs = null;
            Statement statement = null;
            conexao.connect();
            statement = conexao.createStatement();
            rs = statement.executeQuery("SELECT CPF, Nome ,telefone FROM Pessoa");

            /////
            //String SQL = "Select * from usermaster Order By UserName";
            //Conexao con = null;
            //ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                data.add(new TabelaCliente(rs.getLong("CPF"),rs.getString("Nome"),rs.getLong("Telefone")));
            }
            tabelaCliente.setItems(data);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

//    public ObjectProperty<EventHandler<SortEvent<TableView<TabelaCliente>>>> onSortProperty(){
//        return sortingAlgorithm.QuickSort;
//    }

    @FXML
    void acaoLimpar(ActionEvent event) {
    }

    @FXML
    void close(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void min(MouseEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

}

class TestandoSort implements Runnable {


    int[] vetor;

    List<Thread> listThread;
    List<Sort> listSort;


//private ProgressIndicator pi1;
//private ProgressIndicator pi6;
//private ProgressIndicator pi7;
//private ProgressIndicator pi5;
//private ProgressIndicator pi4;
//private ProgressIndicator pi3;
//private ProgressIndicator pi2;
//private ProgressIndicator pi8;

    private PieChart pieChart1;

    private Label l1;//BubbleSort
    private Label l2;//SelectionSort
    private Label l3;//MergeSort
    private Label l4;//QuickSort
    private Label l5;//HeapSort
    private Label l6;//InsertSort
    private Label l7;//BogoSort
    private Label l8;//ShellSort


    public void stopThread() {
        if (listThread.size() > 0)
            for (Thread item : listThread) {
                item.stop();
            }
    }

    public TestandoSort(int[] vetor, List<Thread> listThread, List<Sort> listSort, Label l1, Label l2, Label l3, Label l4, Label l5, Label l6, Label l7, Label l8, PieChart pieChart1) {
        this.vetor = vetor;
        this.listThread = listThread;
        this.listSort = listSort;
//        this.pi1 = pi1;
//        this.pi6 = pi6;
//        this.pi7 = pi7;
//        this.pi5 = pi5;
//        this.pi4 = pi4;
//        this.pi3 = pi3;
//        this.pi2 = pi2;
//        this.pi8 = pi8;
        this.l1 = l1;
        this.l2 = l2;
        this.l3 = l3;
        this.l4 = l4;
        this.l5 = l5;
        this.l6 = l6;
        this.l7 = l7;
        this.l8 = l8;
        this.pieChart1 = pieChart1;
    }

    @Override
    public void run() {

        ObservableList<PieChart.Data> list = FXCollections.observableArrayList();

        for (Thread item : listThread) {
            item.start();
        }
        while (!listThread.isEmpty()) {
            Iterator<Thread> ite = listThread.iterator();
            while (ite.hasNext()) {
                Thread item = ite.next();
                if (!item.isAlive()) {
                    for (Sort sort : listSort) {
                        if (item.getName().equals(sort.getNameSort())) {
                            System.out.println("|| " + item.getName() + " || seu tempo foi: " + sort.getTempo());
                            ite.remove();
                            switch (item.getName()) {
                                case "shellSort":
                                    Platform.runLater(() -> {
                                        l8.setText(Objects.toString(sort.getTempo(), null));
                                        //pi8.setVisible(false);
                                        list.add(new PieChart.Data("shellSort", sort.getTempo()));

                                    });
                                    break;
                                case "bogoSort":
                                    Platform.runLater(() -> {
                                        l7.setText(Objects.toString(sort.getTempo(), null));
                                        //pi7.setVisible(false);
                                        list.add(new PieChart.Data("bogoSort", sort.getTempo()));

                                    });
                                    break;
                                case "insertionSort":
                                    Platform.runLater(() -> {
                                        l6.setText(Objects.toString(sort.getTempo(), null));
                                        //pi6.setVisible(false);
                                        list.add(new PieChart.Data("insertionSort", sort.getTempo()));

                                    });
                                    break;
                                case "heapSort":
                                    Platform.runLater(() -> {
                                        l5.setText(Objects.toString(sort.getTempo(), null));
                                        //pi5.setVisible(false);
                                        list.add(new PieChart.Data("heapSort", sort.getTempo()));

                                    });
                                    break;
                                case "bubbleSort":
                                    Platform.runLater(() -> {
                                        l1.setText(Objects.toString(sort.getTempo(), null));
                                        //pi1.setVisible(false);
                                        list.add(new PieChart.Data("bubbleSort", sort.getTempo()));

                                    });
                                    break;
                                case "selectionSort":
                                    Platform.runLater(() -> {
                                        l2.setText(Objects.toString(sort.getTempo(), null));
                                        //pi2.setVisible(false);
                                        list.add(new PieChart.Data("selectionSort", sort.getTempo()));

                                    });
                                    break;
                                case "mergeSort":
                                    Platform.runLater(() -> {
                                        l3.setText(Objects.toString(sort.getTempo(), null));
                                        //pi3.setVisible(false);
                                        list.add(new PieChart.Data("mergeSort", sort.getTempo()));

                                    });
                                    break;
                                case "quickSort":
                                    Platform.runLater(() -> {
                                        l4.setText(Objects.toString(sort.getTempo(), null));
                                        //pi4.setVisible(false);
                                        list.add(new PieChart.Data("quickSort", sort.getTempo()));
                                    });
                                    break;
                            }
                        }

                        pieChart1.setData(list);
                    }
                }
            }
        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //ObservableList<PieChart.Data> list2 = FXCollections.observableArrayList();
                //pieChart1.setData(list);

                /*pieChart1.forEach(data ->
                        data.nameProperty().bind(
                                Bindings.concat(
                                        data.getName(), " ", data.pieValueProperty(), " Tons"
                                )
                        )
                );*/

                //list.forEach();

            }
        });
    }
}
