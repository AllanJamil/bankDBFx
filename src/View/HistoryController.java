package View;

import Model.Pojo.History;
import ModelView.HistoryView;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class HistoryController implements Initializable {

    ObservableList<HistoryView> historyViewObservable = FXCollections.observableArrayList();

    @FXML
    private TableView<HistoryView> historyTable;

    @FXML
    private TableColumn<HistoryView, String> dateCol;

    @FXML
    private TableColumn<HistoryView, Double> balanceCol;

    @FXML
    private TableColumn<HistoryView, Integer> transactionCol;

    @FXML
    private Button okButton;

    public void close() {
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        balanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("transactionD"));
        transactionCol.setCellValueFactory(new PropertyValueFactory<>("transactionAmount"));
        HistoryData historyDate = HomeController.getHistoryDate();
        historyViewObservable.addAll(historyDate.getHistoryViews());
        historyTable.setItems(historyViewObservable);
    }
}
