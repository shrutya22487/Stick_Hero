package com.example.stick_hero;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;

import java.io.IOException;

import static javafx.application.Application.launch;

public class GameStart{
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void show_game_start() throws IOException{
        root = FXMLLoader.load(getClass().getResource("GameStart.fxml"));
        stage = new Stage();
        Scene scene = new Scene(root);
        Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.show();
    }
    public void show_Runner(ActionEvent event) throws IOException{
        new Runner().show_Runner();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }

//    public void tutorial() throws IOException{
//        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("TutorialPopup.fxml"))));
//        stage.show();
//    }

//    public void berriesBuy() throws IOException{
//        Scene scene1 =
//    }


}
