package com.leo.individuell_javafx.controllers;

import com.leo.individuell_javafx.Period;
import com.leo.individuell_javafx.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ButtonController {

  @FXML
  private AnchorPane scenePane;
  @FXML
  private TextField usernameField;
  @FXML
  private Label balance;
  @FXML
  private TextField amountField;


  public static boolean deposit;

  public void submitUsernameButton(ActionEvent e) throws IOException {
    String username = usernameField.getText();
    UserData.initialiseUser(username);
    UserData.setWallet(username);
    SceneController.switchToMenu(e);
  }

  public void balance(ActionEvent e) {
    balance.setText("Balance: " + UserData.wallet.getBalance());
  }

  public void deposit(ActionEvent e) throws IOException {
    deposit = true;
    SceneController.switchToDeposit(e);
  }

  public void withdraw(ActionEvent e) throws IOException {
    deposit = false;
    SceneController.switchToDeposit(e);
  }

  public void income(ActionEvent e) throws IOException {
    deposit = true;
    SceneController.switchToIncome(e);
  }

  public void expenses(ActionEvent e) throws IOException {
    deposit = false;
    SceneController.switchToIncome(e);
  }

  public void yearly(ActionEvent e) throws IOException {
    TableButtonController.period = Period.YEARLY;
    SceneController.switchToYearly(e);
  }

  public void monthly(ActionEvent e) throws IOException {
    TableButtonController.period = Period.MONTHLY;
    SceneController.switchToPeriodic(e);
  }

  public void weekly(ActionEvent e) throws IOException {
    TableButtonController.period = Period.WEEKLY;
    SceneController.switchToPeriodic(e);
  }

  public void daily(ActionEvent e) throws IOException {
    TableButtonController.period = Period.DAILY;
    SceneController.switchToPeriodic(e);
  }

  public void goBack(ActionEvent e) throws IOException {
    SceneController.switchToMenu(e);
  }

  public void depositAmount(ActionEvent e) {
    try {
      int amount = Integer.parseInt(amountField.getText());
      if (amount > 0) {
        if (deposit) UserData.wallet.createTransaction(amount, 1);
        else UserData.wallet.createTransaction(amount, -1);
      } else {
        System.out.println("Requires a number over 0");
      }
    } catch (Exception ex) {
      System.out.println("Invalid number");
    }
  }

  public void quit(ActionEvent e) {
    Stage stage = (Stage) scenePane.getScene().getWindow();
    stage.close();
    System.exit(0);
  }

}