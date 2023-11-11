package com.example.stick_hero;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class game_over {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void show_game_over() throws IOException{
        root = FXMLLoader.load(getClass().getResource("Game_over.fxml"));
        stage = new Stage();
        Scene scene = new Scene(root);
        Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stick Hero");
        stage.setScene(scene);
        stage.show();
    }
    public void go_to_home(ActionEvent event) throws IOException{
        new GameStart().show_game_start();
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.close();
    }
}
