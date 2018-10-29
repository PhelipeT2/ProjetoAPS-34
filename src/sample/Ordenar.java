package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXProgressBar;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.App.gerarVetor;

public class Ordenar {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane vbox1;

    @FXML
    private Label lblOrdenandoAguarde;

    @FXML
    private JFXProgressBar pb1;

    @FXML
    private Label lblOrdenandoAguarde1;

    @FXML
    private JFXButton bt1;

    @FXML
    private BarChart<?, ?> eficienciaChart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    void bt1Action(ActionEvent event) {

        int vetor[] = gerarVetor(10);
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.BubbleSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.SelectionSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.MergeSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.QuickSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.HeapSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.InsertionSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.bogoSort)).start();
        new Thread(new Sort(vetor.clone(), sortingAlgorithm.shellSort)).start();

        XYChart.Series set1 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("BubbleSort",200));
        eficienciaChart.getData().addAll(set1);

        XYChart.Series set2 = new XYChart.Series<>();
        set1.getData().add(new XYChart.Data("SelectionSort",100));
        eficienciaChart.getData().addAll(set2);

        Task<BarChart> task = new Task<BarChart>() {
            protected BarChart call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                    }
                    updateProgress(10 * i, 100);
                }
                updateProgress(100, 100);

                return new BarChart(new NumberAxis(), new NumberAxis());

            }
        };
        pb1.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(evt -> {
            // handle successful completion of task on application thread
            vbox1.getChildren().set(vbox1.getChildren().indexOf(pb1), task.getValue());
        });
        new Thread(task).start();
    }

    ;


    public void close(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void min1SetOnMouseClicked(MouseEvent mouseEvent) {
    }


    @FXML
    void initialize() {


        assert lblOrdenandoAguarde1 != null : "fx:id=\"lblOrdenandoAguarde1\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert vbox1 != null : "fx:id=\"vbox1\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert pb1 != null : "fx:id=\"pb1\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert lblOrdenandoAguarde != null : "fx:id=\"lblOrdenandoAguarde\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert bt1 != null : "fx:id=\"bt1\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert eficienciaChart != null : "fx:id=\"eficienciaChart\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert x != null : "fx:id=\"x\" was not injected: check your FXML file 'Ordenar.fxml'.";
        assert y != null : "fx:id=\"y\" was not injected: check your FXML file 'Ordenar.fxml'.";

    }
}



