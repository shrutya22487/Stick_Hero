package com.example.stick_hero;

import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.animation.Timeline;
import java.io.IOException;
import javafx.util.Duration;
public class Runner {
    private Stage stage;
    private Scene scene;
    private Parent root = FXMLLoader.load(getClass().getResource("Game_screen.fxml"));
    Image hero1 = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
    @FXML
    private Rectangle rectangle = new Rectangle(2, 2, Color.BLACK);
    private int y;
    @FXML
    ImageView avatar_holder;
    public void show_Runner() throws IOException {
        avatar_holder.setImage(hero1);
        stage = new Stage();
        Scene scene = new Scene(root);
        Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
        stage.getIcons().add(icon);
        stage.setTitle("Stick Hero");
        //show_avatar();
        stage.setScene(scene);
        stage.show();
    }

    public void stick_grow(EventHandler event){
    }
}