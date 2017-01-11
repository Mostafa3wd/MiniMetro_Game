/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
 */
package javafxTest;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends Application {
    static Stage stage;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application.launch(Main.class, (String[])null);
    }

    @Override
    public void start(Stage primaryStage) {
        try {


            Group page = (Group) FXMLLoader.load(Main.class.getResource("mainPage.fxml"));

            Color colorScene = new Color((double)240/255, (double)240/255,(double)240/255,0.5);
            Scene scene = new Scene(page,1200,600, colorScene);
            stage = primaryStage;
            primaryStage.setScene(scene);
            primaryStage.setTitle("MiniMetro - UTBM");
            primaryStage.show();
            primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    System.exit(0);
                    Platform.exit();
                }
            });
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void restart(){

        stage.close();

        Platform.runLater( () -> new Main().start( new Stage() ) );

    }

    public static void end(){

        Platform.exit();

    }





}