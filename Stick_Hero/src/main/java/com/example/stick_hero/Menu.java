package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public abstract class Menu {
    int save_slot;
    private Profile p;
    @FXML
    ImageView bg;
    @FXML
    ImageView mute_image;
    @FXML
    Button mute;
    @FXML
    Label cherry_count;
    boolean bool_mute;
    MediaPlayer mediaPlayer;
    public Profile get_profile() {
        return p;
    }
    public void increase_currscore(){
        int currscore = p.getCurr_score();
        p.setCurr_score(++currscore);
    }

    //Thread music_thread;
    public void set_profile(Profile p){
        this.p = p;
    }

    public void set_save_slot(int save_slot) {
        this.save_slot = save_slot;
    }
    public int get_cherries(){
        return p.getCherries();
    }

    public void get_m_thread_reference(MediaPlayer mediaPlayer, boolean bool_mute){
//        music_thread = t;
        this.mediaPlayer = mediaPlayer;
        this.bool_mute = bool_mute;
        if( bool_mute)mute_image.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\mute.png"));
        else mute_image.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\unmute.png"));
    }
    @FXML
    public void Mute(MouseEvent event){
        if (bool_mute) {//unmute here
            mute_image.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\unmute.png"));
            mediaPlayer.setVolume(0.1);
            bool_mute = false;
            return;
        }
        mute_image.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\mute.png"));
        mediaPlayer.setVolume(0);
        bool_mute = true;
    }
    public void random_background(){
        Random random = new Random();
        int r = random.nextInt(0,3);
        switch (r) {
            case 0:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg1.png"));
                break;
            case 1:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg2.png"));
                break;
            case 2:
                bg.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\bg3.png"));
                break;
        }
    }

    public Menu load_fxml(String fxml_name) throws IOException {
        try {
            Stage stage = Main.stage;
            FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource(fxml_name));
            Scene scene = new Scene( fxml_loader.load() );

            if( bool_mute)mute_image.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\unmute.png"));
            else mute_image.setImage(new Image("file:src\\main\\resources\\com\\example\\stick_hero\\mute.png"));

            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
            Menu ss = fxml_loader.getController();
            ss.set_save_slot(save_slot);
            ss.set_profile(p);
            ss.get_m_thread_reference(mediaPlayer, bool_mute);
            ss.random_background();
            ss.cherry_count.setText(String.valueOf(get_cherries()));

            stage.setResizable(false);
            stage.getIcons().add(icon);
            stage.setTitle("Stick Hero");
            stage.setScene(scene);
            stage.show();
            return ss;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @FXML
    public void go_back(ActionEvent event) throws IOException{
        //
    }

}
