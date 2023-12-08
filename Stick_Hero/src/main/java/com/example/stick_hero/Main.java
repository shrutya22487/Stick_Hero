package com.example.stick_hero;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Main extends Application{
    public static Stage stage;
    MediaPlayer mediaPlayer;
    public void music_player(){
        Media media = new Media(new File("src\\main\\resources\\com\\example\\stick_hero\\music.mp3").toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setVolume(0.1);
        mediaPlayer.play();
    }
    @Override
    public void start(Stage _stage) throws IOException {
        try {
            Thread t = new Thread(this::music_player);
            t.start();
            stage = _stage;
            FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource("BeginScreen.fxml"));
            Scene scene = new Scene( fxml_loader.load() );
            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            BeginScreen bs = fxml_loader.getController();
            bs.random_background();
            bs.get_m_thread_reference(mediaPlayer, false);
            stage.setResizable(false);
            stage.getIcons().add(icon);
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void stop() throws Exception {
        // Release resources when the application is stopped
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
        super.stop();
    }

    public static void main(String[] args) {
        launch();
    }
}