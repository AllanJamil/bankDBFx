package View;

import Model.Facade;
import Model.Pojo.History;
import ModelView.AccountView;
import ModelView.CustomerView;
import ModelView.HistoryView;
import ModelView.LoanView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class HomeController implements Initializable {

    private static CustomerView customerView;
    List<CustomerView> customerViewList;
    private static AccountView selectedAccountView;
    private static String buttonName;
    private static CustomerView selectedCustomerView;
    private static LoanView selectedLoanView;

    @FXML
    private TableView<CustomerView> cCustomerTable;
    @FXML
    private TableColumn<CustomerView, String> cFirstnameCol;
    @FXML
    private TableColumn<CustomerView, String> cLastnameCol;
    @FXML
    private TableView<CustomerView> aCustomerTable;
    @FXML
    private TableColumn<CustomerView, String> aFirstnameCol;
    @FXML
    private TableColumn<CustomerView, String> aLastnameCol;
    @FXML
    private TableView<AccountView> aAccountTable;
    @FXML
    private TableColumn<AccountView, Double> aBalanceCol;
    @FXML
    private TableColumn<AccountView, Double> aInterestRateCol;
    @FXML
    private TableView<CustomerView> hCustomerTable;
    @FXML
    private TableColumn<CustomerView, String> hFirstnameCol;
    @FXML
    private TableColumn<CustomerView, String> hLastnameCol;
    @FXML
    private TableView<LoanView> loanTable;
    @FXML
    private TableColumn<LoanView, Double> loanBalanceCol;
    @FXML
    private TableColumn<LoanView, Integer> loanPaymentIntervalCol;
    @FXML
    private TableColumn<LoanView, Double> loanInterestRateCol;
    @FXML
    private TableColumn<AccountView, Double> hBalanceCol;
    @FXML
    private TableColumn<AccountView, Double> hInterestRateCol;
    @FXML
    private TableView<AccountView> hAccountTable;
    @FXML
    private TextField dateFromTextField;
    @FXML
    private TextField dateToTextField;


    static ObservableList<CustomerView> observableList = FXCollections.observableArrayList();
    static ObservableList<AccountView> accountViewObservable = FXCollections.observableArrayList();
    static ObservableList<LoanView> loanViewObservable = FXCollections.observableArrayList();
    private CustomerView selectedCustomer;
    List<AccountView> accountsById;
    private static HistoryData historyDate;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cFirstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        cLastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        aFirstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        aLastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        hFirstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstname"));
        hLastnameCol.setCellValueFactory(new PropertyValueFactory<>("lastname"));
        aBalanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        aInterestRateCol.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
        loanBalanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        loanInterestRateCol.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
        loanPaymentIntervalCol.setCellValueFactory(new PropertyValueFactory<>("paymentInterval"));
        hBalanceCol.setCellValueFactory(new PropertyValueFactory<>("balance"));
        hInterestRateCol.setCellValueFactory(new PropertyValueFactory<>("interestRate"));
        this.cCustomerTable.setItems(observableList);
        cCustomerTable.requestFocus();
        cCustomerTable.getSelectionModel().select(0);
        cCustomerTable.getFocusModel().focus(0);
        new Thread(this::initiateList).start();

    }

    public void onAccountClicked() {
        this.aCustomerTable.setItems(observableList);
        aCustomerTable.requestFocus();
        aCustomerTable.getSelectionModel().select(0);
        aCustomerTable.getFocusModel().focus(0);

    }

    public void onHistoryClicked() {
        this.hCustomerTable.setItems(observableList);
        hCustomerTable.requestFocus();
        hCustomerTable.getSelectionModel().select(0);
        hCustomerTable.getFocusModel().focus(0);
    }


    public void addAccountsToAccountTable() {
        accountViewObservable.removeAll();
        aAccountTable.getItems().clear();
        accountsById = aCustomerTable.getSelectionModel().getSelectedItem().getAccounts();
        accountViewObservable.addAll(accountsById);
        this.aAccountTable.setItems(accountViewObservable);
        aAccountTable.requestFocus();
        aAccountTable.getSelectionModel().select(0);
        aAccountTable.getFocusModel().focus(0);
    }

    public void addAccountsTohAccountTable() {
        accountViewObservable.removeAll();
        hAccountTable.getItems().clear();
        accountsById = hCustomerTable.getSelectionModel().getSelectedItem().getAccounts();
        accountViewObservable.addAll(accountsById);
        this.hAccountTable.setItems(accountViewObservable);
        hAccountTable.requestFocus();
        hAccountTable.getSelectionModel().select(0);
        hAccountTable.getFocusModel().focus(0);
    }

    public void addLoansToLoanTable() {
        loanViewObservable.removeAll();
        loanTable.getItems().clear();
        AccountView selectedItem = aAccountTable.getSelectionModel().getSelectedItem();

        if (selectedItem.getLoan().getBalance() != 0){
            loanViewObservable.add(selectedItem.getLoan());
            loanTable.setItems(loanViewObservable);
            loanTable.requestFocus();
            loanTable.getSelectionModel().select(0);
            loanTable.getFocusModel().focus(0);
        }

    }

    public void initiateList() {
        customerViewList = new LogInController().getFacade().getCustomerViewList();
        observableList.addAll(customerViewList);
    }

    public CustomerView getSelectedCustomer() {
        return customerView;
    }

    public void setSelectedCustomerAcc(CustomerView customerAcc) {
        this.selectedCustomerView = customerAcc;
    }

    public void setSelectedAccount() {
        this.selectedAccountView = aAccountTable.getSelectionModel().getSelectedItem();
    }

    public void setSelectedhAccount() {
        this.selectedAccountView = hAccountTable.getSelectionModel().getSelectedItem();
    }

    public void setSelectedLoanView() {
        this.selectedLoanView = loanTable.getSelectionModel().getSelectedItem();
    }

    public LoanView getSelectedLoanView() {
        return selectedLoanView;
    }

    public static void setButtonName(String buttonName) {
        HomeController.buttonName = buttonName;
    }

    public static String getButtonName() {
        return buttonName;
    }

    public void addNewCustomerToTable(CustomerView customerView) {
        observableList.add(customerView);
    }

    public void addNewAccountToTable(AccountView accountView) {
        accountViewObservable.add(accountView);
    }

    public void addNewLoanToLoanTable(LoanView loanView) {

        loanViewObservable.add(loanView);
    }

    public void setCustomerView(CustomerView customerView) {

        try {
            cCustomerTable.getItems().forEach(cw -> {
                if (cw.getId() == customerView.getId()) {
                    cw.setFirstname(HomeController.customerView.getFirstname());
                    cw.setLastname(HomeController.customerView.getLastname());
                    cw.setPin(HomeController.customerView.getPin());
                }
            });
        } catch (Exception e) {

        }
    }

    public void openNewWindow(String fxmlFile, String title) {
        try {
            Parent root1 = FXMLLoader.load(getClass().getResource(fxmlFile));
            Stage newWindow = new Stage();
            newWindow.initModality(Modality.WINDOW_MODAL);
            newWindow.initOwner(Window.getWindows().get(0));
            newWindow.setTitle(title);
            newWindow.setScene(new Scene(root1));
            newWindow.setResizable(false);
            newWindow.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addCustomerButtonAction() {
        openNewWindow("addCustomer.fxml", "Add Customer");
    }

    public void editCustomerButtonAction() {
        this.customerView = cCustomerTable.getSelectionModel().getSelectedItem();
        openNewWindow("editCustomer.fxml", "Edit Customer");
    }

    public void deleteCustomerButtonAction() {
        CustomerView customerView = cCustomerTable.getSelectionModel().getSelectedItem();
        cCustomerTable.getItems().remove(customerView);
        new Facade().getAdministratorRepository().deleteCustomerByFullName(customerView.getFirstname(), customerView.getLastname());
    }

    public void addAccountButtonAction() {
        CustomerView selectedItem = aCustomerTable.getSelectionModel().getSelectedItem();
        setSelectedCustomerAcc(selectedItem);
        System.out.println(selectedCustomerView.getFirstname());
        setButtonName("Add");
        setSelectedAccount();
        openNewWindow("editAddAccount.fxml", "Add Account");
    }

    public void deleteAccountAction() {
        AccountView selectedItem = aAccountTable.getSelectionModel().getSelectedItem();
        observableList.forEach(e -> e.getAccounts().remove(selectedItem));
        aAccountTable.getItems().remove(selectedItem);
        new Facade().getAdministratorRepository().deleteAccountById(selectedItem.getId());
    }

    public void editAccountButtonAction() {
        setSelectedAccount();
        setButtonName("Update");
        openNewWindow("editAddAccount.fxml", "Edit Account");
    }

    public void WithdrawButtonAction() {
        setSelectedAccount();
        setButtonName("Withdraw");
        openNewWindow("withdrawDeposit.fxml", "Withdraw");
    }

    public void depositButtonAction() {
        setButtonName("Deposit");
        setSelectedAccount();
        openNewWindow("withdrawDeposit.fxml", "Deposit");

    }

    public void addLoanButtonAction() {
        setButtonName("Add");
        setSelectedAccount();
        openNewWindow("editAddLoan.fxml", "Add Loan");
    }

    public void editLoanButtonAction() {
        setButtonName("Edit");
        setSelectedLoanView();
        setSelectedAccount();
        openNewWindow("editAddLoan.fxml", "Edit Loan");

    }

    public void showPaymentPlanButtonAction() {

        setSelectedLoanView();
        openNewWindow("paymentPlan.fxml", "Payment Plan");

    }

    public void showHistoryButtonAction() {
        String start = dateFromTextField.getText();
        String end = dateToTextField.getText();
        setSelectedhAccount();
        List<History> allHistoryBetweenDate = new Facade().getHistoryRepository().getAllHistoryBetweenDate(getAccountView().getId(), start, end);
        List<HistoryView> collect = allHistoryBetweenDate.stream().map(e -> new HistoryView(e)).collect(Collectors.toList());
        historyDate=new HistoryData(start,end,collect);
        openNewWindow("history.fxml", "History");
    }

    public static HistoryData getHistoryDate() {
        return historyDate;
    }

    public static AccountView getAccountView() {
        return selectedAccountView;
    }

    public static CustomerView getSelectedCustomerView() {
        return selectedCustomerView;
    }
}
