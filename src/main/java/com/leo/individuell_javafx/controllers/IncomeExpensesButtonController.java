package com.leo.individuell_javafx.controllers;

import com.leo.individuell_javafx.Period;
import javafx.event.ActionEvent;

import java.io.IOException;

public class IncomeExpensesButtonController {
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
}
