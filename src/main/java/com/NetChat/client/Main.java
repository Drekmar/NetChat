package com.NetChat.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = (Controller) loader.getController();

        primaryStage.setTitle("JavaFX Client");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();

       primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
           @Override
          public void handle(WindowEvent event) {

               try {
                   controller.closeconnect();

               } catch (Exception e) {
                   e.printStackTrace();
               }


           }
        });

    }

    public static void main(String[] args) {
        launch(args);
    }
}
