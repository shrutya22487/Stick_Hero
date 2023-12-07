package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Random;

public class Start_screen{
    private Image volume;
    private Image cherry;
    private Image dummy_avatar;
    private Avatar avatar;
    @FXML
    ImageView bg;
    public void random_background(){
        Random random = new Random();
        int r = random.nextInt(0,3);
        switch (r) {
            case 1:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg1.png"));
                break;
            case 2:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg2.png"));
                break;
            case 3:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg3.png"));
                break;
        }
    }
    @FXML
    public void run_game(ActionEvent event){
        try {
            Stage stage = Main.stage;
            FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource("Game_screen2.fxml"));
            Scene scene = new Scene( fxml_loader.load() );
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
//            Start_screen ss = fxml_loader.getController();
//            ss.random_background();
            stage.setResizable(false);
            stage.getIcons().add(icon);
            stage.setTitle("Stick Hero");
//            stage.setFullScreen(true);
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void show_tutorial(ActionEvent event){
        // the labels for tutorials that are going to pop up
    }
    public void buy_cherries(ActionEvent event){
        //is going to show dummy menu for buying cherries
    }
    public void buy_avatar(ActionEvent event){
        // to buy avatar with cherries
    }
    public void mute(ActionEvent event){
        // is going to mute sound
    }

}
