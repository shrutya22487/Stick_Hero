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
    @FXML
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Circle c;
    private double x;
    private double y;
    @FXML
    private ImageView imageView;
    private Image image;
//    @FXML
//    private Button b1;
    public void show_game_over(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Game_over.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void up(ActionEvent e){
        c.setCenterY(y-=10);
    }
    public void switch_to_start_screen(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("start_screen.fxml"));
    }
    public static void main(String[] args) {
        launch(args);
    }
}
