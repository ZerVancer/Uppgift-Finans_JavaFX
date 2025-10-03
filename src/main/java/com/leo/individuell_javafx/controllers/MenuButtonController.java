package com.leo.individuell_javafx.controllers;

import com.leo.individuell_javafx.UserData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuButtonController {

  @FXML
  private AnchorPane scenePane;
  @FXML
  private TextField usernameField;
  @FXML
  private Label usernameErrorText;
  @FXML
  private Label balance;
  @FXML
  private TextField amountField;
  @FXML
  private Label responseLabel;


  public static boolean deposit;

  public void submitUsernameButton(ActionEvent e) throws IOException {
    String username = usernameField.getText();
    char[] invalidChars = {'\\', '/', ':', '*', '?', '"', '<', '>', '|'};
    for (int i = 0; i < username.length(); i++)
      for (char c : invalidChars)
        if (username.charAt(i) == c) {
        usernameErrorText.setText("Invalid character used: '" + c + "'");
        return;
      }
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

  public void goBack(ActionEvent e) throws IOException {
    SceneController.switchToMenu(e);
  }

  public void depositWithdrawAmount(ActionEvent e) {
    try {
      int amount = Integer.parseInt(amountField.getText());
      if (amount > 0) {
        if (deposit) {
          UserData.wallet.createTransaction(amount, 1);
          responseLabel.setText("Deposited: " + amount);
        }
        else {
          UserData.wallet.createTransaction(amount, -1);
          responseLabel.setText("Withdrawn " + amount);
        }
      } else {
        responseLabel.setText("Must be more than zero");
      }
    } catch (Exception ex) {
      responseLabel.setText("Invalid number");
    }
  }

  public void quit(ActionEvent e) {
    Stage stage = (Stage) scenePane.getScene().getWindow();
    stage.close();
    System.exit(0);
  }

}