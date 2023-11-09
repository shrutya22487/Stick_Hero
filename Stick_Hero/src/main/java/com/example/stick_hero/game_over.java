package com.example.stick_hero;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class game_over {
    private Stage stage;

    private Scene scene;
    private Parent root;

//    public void show_game_over(ActionEvent event) throws IOException{
//        root = FXMLLoader.load(getClass().getResource("Game_over.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//
//    }
    public void switch_to_start_screen(MouseEvent event) throws IOException{
            root = FXMLLoader.load(getClass().getResource("GameStart.fxml"));
//            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
//            stage.getIcons().add(icon);
//            stage.setWidth(500);
//            stage.setHeight(800);
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();

    }
}
