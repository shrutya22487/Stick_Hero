package com.example.stick_hero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class StickController2 extends Menu implements Initializable {
    Thread death_t, walk_t, grow_t;
    MediaPlayer game_media_player;
    String death = "src\\main\\resources\\com\\example\\stick_hero\\death.mp3";
    String stick_grow = "src\\main\\resources\\com\\example\\stick_hero\\stick_grow.mp3";
    String walk = "src\\main\\resources\\com\\example\\stick_hero\\walk.mp3";
    Random r = new Random();
    @FXML
    private AnchorPane pane;
    private int length;
    private int width;
    private int y=646;
//    private int blockAfterTravel=1000;
    private Image image1 = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\run1.png");
    private Image image2 = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\run2.png");
    @FXML
    private Rectangle stick;
    private Timeline timeline1, timeline3_1, timeline3_2, timeline4, timeline5, timeline6;
    private RotateTransition rotateTransition, rotateTransition2;
    @FXML
    private ImageView imageView;
    @FXML
    private Rectangle blockPrevious;
    @FXML
    private Rectangle blockAfter;
    @FXML
    private ImageView cherry;
    @FXML
    private Text cherryCountText = new Text();
    private Rectangle blockNew;
    private Rectangle stickNew;
    private int freq1=0;
    private int freq2=0;
//    private int invertFLAG=0;
    public void play_sound_effects(String sound_effect) {
        Media media = new Media(new File(sound_effect).toURI().toString());
        game_media_player = new MediaPlayer(media);
        game_media_player.setAutoPlay(true);
        game_media_player.setVolume(1);
        game_media_player.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        width = r.nextInt(10, 100);
        blockPrevious.setFill(Color.DARKGRAY);
        PlatForm platform = new PlatForm(blockPrevious);
        blockAfter = platform.getPlatformCurrent();
//        cherry = (new Cherry(blockPrevious, blockAfter)).getImageView();
        blockAfter.setX(1000);
        stick = (new Stick(blockPrevious)).getStick();
        pane.getChildren().add(blockAfter);
        pane.getChildren().add(stick);
//        cherryCountText.setText(String.valueOf(cherryCount));

        timeline1 = new Timeline(new KeyFrame(Duration.millis(5), e->{
            this.y-=1;
            stick.setHeight(stick.getHeight()+1);
            stick.setY(y);
        }));

        timeline1.setCycleCount(Animation.INDEFINITE);

        timeline3_1 = new Timeline(new KeyFrame(Duration.millis(5), e->{
            if (imageView.getX()%4==0)
            {
                imageView.setImage(image2);
            } else {
                imageView.setImage(image1);
            }
            imageView.setX(imageView.getX()+1);

//            if (invertFLAG==1 && imageView.getX()==cherry.getX()){
//                cherryCount++;
//                cherryCountText.setText(String.valueOf(cherryCount));
//            }
        }));

        timeline3_2 = new Timeline(new KeyFrame(Duration.millis(5), e->{
            if (imageView.getX()%4==0)
            {
                imageView.setImage(image2);
            } else {
                imageView.setImage(image1);
            }
            imageView.setX(imageView.getX()+1);

//            if (invertFLAG==1 && imageView.getX()==cherry.getX()){
//                cherryCount++;
//                cherryCountText.setText(String.valueOf(cherryCount));
//            }
        }));

        timeline4 = new Timeline(new KeyFrame(Duration.millis(10), e->{
            imageView.setY(imageView.getY()+1);
        }));

        timeline4.setCycleCount(204);

        timeline5 = new Timeline(new KeyFrame(Duration.millis(10), e->{
            blockAfter.setX(blockAfter.getX()-10);
        }));

        timeline5.setCycleCount((1000-platform.getDistanceFromPrev())/10);
        timeline5.play();

        timeline6 = new Timeline(new KeyFrame(Duration.millis(1), e->{
            blockAfter.setX(blockAfter.getX()-1);
            blockPrevious.setX(blockPrevious.getX()-1);
            stick.setX(stick.getX()-1);
            imageView.setX(imageView.getX()-1);
            blockNew.setX(blockNew.getX()-1);
            stickNew.setX(stickNew.getX()-1);
//            cherry.setX(cherry.getX()-1);
        }));

//        rotateTransition2 = new RotateTransition(Duration.seconds(0), cherry);
//        moveCenterPlayer(0, -31);
//        rotateTransition2.setCycleCount(1);
//        rotateTransition2.setByAngle(180);
    }

    public void runWin(){
        int a = (int) (blockAfter.getX()+blockAfter.getWidth()-blockPrevious.getWidth());
        timeline3_1.setCycleCount(a);
        timeline3_1.play();
        timeline3_1.setOnFinished(e->{
            levelChange();
        });
    }
    public void runLoose() {
        int a = (int) stick.getHeight() + 5;
        timeline3_2.setCycleCount(a);
        timeline3_2.play();
        timeline3_2.setOnFinished(e->{
            if (!bool_mute) {
                death_t = new Thread(() -> play_sound_effects(death));
                death_t.start();
            }
            timeline4.play();
            timeline4.setOnFinished(t-> {
                try {
                    if (!bool_mute) game_media_player.dispose();

                    load_fxml("Game_over.fxml");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
        });

    }

    public void stickGrow(MouseEvent event){
        if (freq1==0)
        {
            Thread new_t = new Thread(() -> play_sound_effects(stick_grow));
            new_t.start();
            System.out.println("GETX OF BLOCKAFTER BEFORE STICK GROW: " + blockAfter.getX());
            timeline1.play();
            freq1++;
            timeline1.setOnFinished(event1 -> game_media_player.dispose());

        }
    }

    public void moveCenter(double x, double y){
        this.stick.getTransforms().add(new Translate(-x, -y));
        this.stick.setTranslateX(x);
        this.stick.setTranslateY(y);
    }

//    public void moveCenterPlayer(double x, double y){
//        this.imageView.getTransforms().add(new Translate(-x, -y));
//        this.imageView.setTranslateX(x);
//        this.imageView.setTranslateY(y);
//    }

    public void levelChange(){

        blockNew = new PlatForm(blockAfter).getPlatformCurrent();
        stickNew = (new Stick(blockAfter)).getStick();
        pane.getChildren().add(blockNew);
        pane.getChildren().add(stickNew);
        freq1=0;
        freq2=0;
        System.out.println("GETX OF BLOCK AFTER: " + blockAfter.getX());
        timeline6.setCycleCount((int) blockAfter.getX());
        timeline6.play();
        timeline6.setOnFinished(e->{
            blockPrevious = blockAfter;
            blockAfter = blockNew;
            stick = stickNew;
            y=646;
        });
    }


    public void stickStop(MouseEvent event) throws IOException, InterruptedException {
        if (freq2 == 0) {
            timeline1.stop();
            Point3D point = new Point3D(0, 0, stick.getHeight());
            rotateTransition = new RotateTransition(Duration.seconds(1), stick);
            rotateTransition.setAxis(point);
            rotateTransition.setByAngle(90);
            rotateTransition.setCycleCount(1);
            moveCenter(0, stick.getHeight() / 2);
            rotateTransition.play();
            System.out.println("HEIGHT OF STICK GENRATED: " + stick.getHeight());
            if (stick.getHeight() > blockAfter.getX() - blockPrevious.getWidth() && stick.getHeight() < blockAfter.getX() - blockPrevious.getWidth() + blockAfter.getWidth()) {
                System.out.println("You Win");
                rotateTransition.setOnFinished(e -> runWin());

            } else {
                System.out.println("You loose");
                rotateTransition.setOnFinished(e -> runLoose());
                freq2++;
            }
        }
    }
    public void screenClick(MouseEvent event){
//        if (freq1>0 && freq2>0)
//        {
//            rotateTransition2.play();
//        }
        if (freq1%2==0 && freq2%2==0)
        {
            imageView.setRotate(0);
        } else if ((freq1%2!=0 && freq2%2!=0) && (freq1>1 && freq2>1)){
            imageView.setRotate(180);
        }
        freq1++;
        freq2++;
    }

    @FXML
    public void pause(ActionEvent event) throws IOException {
        load_fxml("Pause_Menu.fxml");
    }
}