package com.example.stick_hero;
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

import java.io.IOException;

public class game_over {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    Button start_screen, restart;

    public void show_game_over(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("Game_over.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void switch_to_start_screen(ActionEvent event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("start_screen.fxml"));
    }
}
