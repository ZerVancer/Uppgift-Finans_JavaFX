module com.leo.individuell_javafx {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.leo.individuell_javafx to javafx.fxml;
  exports com.leo.individuell_javafx;
  exports com.leo.individuell_javafx.data;
  exports com.leo.individuell_javafx.controllers;
  opens com.leo.individuell_javafx.controllers to javafx.fxml;
}