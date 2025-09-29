package com.leo.individuell_javafx.controllers;

import com.leo.individuell_javafx.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
  private static Stage stage;
  private static Scene scene;
  private static Parent root;

  public static void switchToMenu(ActionEvent event) throws IOException {
    switchTo("Menu", event);
  }

  public static void switchToDeposit(ActionEvent event) throws IOException {
    switchTo("DepositWithdraw", event);
  }

  public static void switchToIncome(ActionEvent event) throws IOException {
    switchTo("IncomeExpenses", event);
  }

  public static void switchToYearly(ActionEvent event) throws IOException {
    switchTo("Yearly", event);
  }

  public static void switchToPeriodic(ActionEvent event) throws IOException {
    switchTo("Periodic", event);
  }

  private static void switchTo(String destination, ActionEvent event) throws IOException {
    root = FXMLLoader.load(Main.class.getResource(destination + ".fxml"));;
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
