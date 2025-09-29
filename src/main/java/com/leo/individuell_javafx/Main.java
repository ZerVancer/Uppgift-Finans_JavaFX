package com.leo.individuell_javafx;

import com.leo.individuell_javafx.data.Transaction;
import com.leo.individuell_javafx.data.Wallet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class Main extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    Parent root;
    try {
      root = FXMLLoader.load(Main.class.getResource("Login.fxml"));

      Scene scene = new Scene(root);
      stage.setResizable(false);
      stage.setX(100);
      stage.setY(100);
      stage.setTitle("Wallet");

      stage.setScene(scene);
      stage.show();

    } catch (NullPointerException e) { System.out.println("missing fxml file"); }

//    wallet.addTransaction(new Transaction(999, LocalDateTime.now().minusYears(1)));
//    wallet.addTransaction(new Transaction(999, LocalDateTime.now().minusYears(1)));
//    wallet.addTransaction(new Transaction(-999, LocalDateTime.now().minusYears(1)));
//    wallet.addTransaction(new Transaction(999, LocalDateTime.now().minusYears(2)));
//    wallet.addTransaction(new Transaction(999, LocalDateTime.now().minusYears(3)));
//    wallet.addTransaction(new Transaction(999, LocalDateTime.now().minusYears(4)));
//    wallet.addTransaction(new Transaction(999, LocalDateTime.now().minusYears(4).plusWeeks(2)));
  }

  public static void main(String[] args) { launch(); }
}