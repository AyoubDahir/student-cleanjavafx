package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.utilities.*;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        url obj=new url();
        obj.show("Student Register", "/main/viewer/student.fxml");


    }


    public static void main(String[] args) {
        launch(args);
    }
}
