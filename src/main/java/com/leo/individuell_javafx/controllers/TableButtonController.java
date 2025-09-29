package com.leo.individuell_javafx.controllers;

import com.leo.individuell_javafx.Period;
import com.leo.individuell_javafx.UserData;
import com.leo.individuell_javafx.data.PeriodicExpensesAndIncome;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class TableButtonController {

  @FXML
  private TableView<PeriodicExpensesAndIncome> tableView;
  @FXML
  private TableColumn<PeriodicExpensesAndIncome, Integer> yearColumn;
  @FXML
  private TableColumn<PeriodicExpensesAndIncome, Integer> amountColumn;
  @FXML
  private TableColumn<PeriodicExpensesAndIncome, Integer> periodColumn;

  public static Period period;

  public void writeTable() {
    yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
    amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

    ObservableList<PeriodicExpensesAndIncome> list;
    if (period != Period.YEARLY) periodColumn.setCellValueFactory(new PropertyValueFactory<>("period"));
    list = switch (period) {
      case YEARLY -> UserData.wallet.getIncomeOrExpenses(Period.YEARLY, ButtonController.deposit);
      case MONTHLY -> {
        periodColumn.setText("Month");
        yield UserData.wallet.getIncomeOrExpenses(Period.MONTHLY, ButtonController.deposit);
      }
      case WEEKLY -> {
        periodColumn.setText("Week");
        yield UserData.wallet.getIncomeOrExpenses(Period.WEEKLY, ButtonController.deposit);
      }
      case DAILY -> {
        periodColumn.setText("Day");
        yield UserData.wallet.getIncomeOrExpenses(Period.DAILY, ButtonController.deposit);
      }
    };
    tableView.setItems(list);
  }

  public void goBack(ActionEvent e) throws IOException {
    SceneController.switchToMenu(e);
  }

  @FXML
  public void initialize() {
    writeTable();
  }
}
