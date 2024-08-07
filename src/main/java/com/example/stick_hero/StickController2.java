package com.example.stick_hero;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import java.net.URL;
import java.util.ResourceBundle;
// main screen
public class StickController2 extends Menu implements Initializable {
    private Thread death_t;
    private String death = Main.cwd_music + "death.mp3" ;
    private String stick_grow = Main.cwd_music + "stick_grow.mp3";
    MediaPlayer death_media_player , stick_grow_media_player ;// media players for creating the death and stick growing voices
    Random r = new Random();
    int FLAGiNVERT=0;
    @FXML
    private AnchorPane pane;
    private int length, width;
    private int y=300;
    private Image image1 = new Image("run1.png");
    private Image image2 = new Image("run2.png");
    @FXML
    private Rectangle stick;
    private Timeline timeline1, timeline3_1, timeline3_2, timeline3_1I, timeline3_2I, timeline4, timeline5, timeline6;
    private RotateTransition rotateTransition, rotateTransition2;
    @FXML
    private ImageView imageView;
    @FXML
    private Rectangle blockPrevious;
    @FXML
    private Rectangle blockAfter;
    @FXML
    Label curr_score;
    Image inverted_img = new Image( "HeroInverted.png");
    private Rectangle blockNew;
    private Rectangle stickNew;
    private ImageView cherry;
    private int freq1 = 0, freq2 = 0;

    @Override
    public void Mute(MouseEvent event) {
        super.Mute(event);
        if (!isBool_mute()){
            death_media_player.setVolume(1);
            stick_grow_media_player.setVolume(1);
            return;
        }
        death_media_player.setVolume(0);
        stick_grow_media_player.setVolume(0);
    }

    //    private int invertFLAG=0;
    public void play_death_sound() {
        death_media_player = new MediaPlayer(new Media(new File(death).toURI().toString()));
        death_media_player.setAutoPlay(true);
        death_media_player.play();
    }
    public void play_stick_grow_sound() {
        stick_grow_media_player = new MediaPlayer(new Media(new File(stick_grow).toURI().toString()));
        stick_grow_media_player.setAutoPlay(true);
        stick_grow_media_player.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

        width = r.nextInt(10, 100);
        blockPrevious.setFill(Color.DARKGRAY);
        PlatForm platform = new PlatForm(blockPrevious);
        blockAfter = platform.getPlatformCurrent();
        cherry = (new Cherry(blockPrevious, blockAfter)).getImageView();
        blockAfter.setX(1000);
        stick = (new Stick(blockPrevious)).getStick();
        pane.getChildren().add(blockAfter);
        pane.getChildren().add(stick);
        pane.getChildren().add(cherry);
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
                imageView.setImage(image1);

            } else {
                imageView.setImage(image2);
            }
            imageView.setX(imageView.getX()+1);
            System.out.println(FLAGiNVERT);

            if (FLAGiNVERT==1 && imageView.getX()+13==cherry.getX()){
                int a = get_cherries();
                this.get_profile().setCherries(++a);
                this.cherry_count.setText(String.valueOf(a));
                cherry.setOpacity(0);
            }

            if (FLAGiNVERT==1 && imageView.getX()+13==blockAfter.getX()){
                timeline3_2.stop();
                timeline4.play();
                timeline4.setOnFinished(t-> {
                    GameOver gameOver = null;
                    try {
                        gameOver = (GameOver) load_fxml("Game_over.fxml");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    gameOver.displayScore(get_profile().getCurr_score(), get_profile().getHighScore());

                });
            }
        }));

        timeline3_2 = new Timeline(new KeyFrame(Duration.millis(5), e->{
            if (imageView.getX()%4==0)
            {
                imageView.setImage(image1);
            } else {
                imageView.setImage(image2);
            }
            imageView.setX(imageView.getX()+1);
            System.out.println(FLAGiNVERT);

            if (FLAGiNVERT==1 && imageView.getX()+26==cherry.getX()){
                int a = get_cherries();
                this.get_profile().setCherries(++a);
                this.cherry_count.setText(String.valueOf(a));
                cherry.setOpacity(0);
            }

            if (FLAGiNVERT==1 && imageView.getX()+26==blockAfter.getX()){
                timeline3_2.stop();
                timeline4.play();
                timeline4.setOnFinished(t-> {
                    GameOver gameOver = null;
                    try {
                        gameOver = (GameOver) load_fxml("Game_over.fxml");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    gameOver.displayScore(get_profile().getCurr_score(), get_profile().getHighScore());
                });
            }
        }));

        timeline4 = new Timeline(new KeyFrame(Duration.millis(5), e->{
            imageView.setY(imageView.getY()+1);
        }));

        timeline4.setCycleCount(204);

        timeline5 = new Timeline(new KeyFrame(Duration.millis(1), e->{
            blockAfter.setX(blockAfter.getX()-1);
        }));

        timeline5.setCycleCount((1000-platform.getDistanceFromPrev()-platform.getWidth()));
        System.out.println("----------------PLAY-----------------");
        timeline5.play();

        timeline6 = new Timeline(new KeyFrame(Duration.millis(1), e->{
            blockAfter.setX(blockAfter.getX()-1);
            blockPrevious.setX(blockPrevious.getX()-1);
            stick.setX(stick.getX()-1);
            imageView.setX(imageView.getX()-1);
            blockNew.setX(blockNew.getX()-1);
            stickNew.setX(stickNew.getX()-1);
        }));
    }

    public void runWin(){// if the player has successfully created the stick of the sufficient length and the player can move forward
        increase_currscore();
        curr_score.setText(String.valueOf(get_profile().getCurr_score()));
        if (get_profile().getHighScore() < get_profile().getCurr_score()) get_profile().setHighScore(get_profile().getCurr_score());

        int a = (int) (blockAfter.getX()+blockAfter.getWidth()-blockPrevious.getWidth());
        timeline3_1.setCycleCount(a);
        timeline3_1.play();
        timeline3_1.setOnFinished(e->{
            levelChange();
        });
    }
    public void runLoose() {// if the player has lost will initiate the death sequence
        int copy_of_curr_score = get_profile().getCurr_score();
        get_profile().setCurr_score(0);
        int a = (int) stick.getHeight() + 5;
        timeline3_2.setCycleCount(a);
        timeline3_2.play();
        timeline3_2.setOnFinished(e->{
            if (!isBool_mute()) {
                death_t = new Thread(this::play_death_sound);
                death_t.start();
                try {
                    death_t.join();
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
            timeline4.play();
            timeline4.setOnFinished(t-> {
                GameOver gameOver = null;
                try {
                    gameOver = (GameOver) load_fxml("Game_over.fxml");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                gameOver.displayScore(copy_of_curr_score, get_profile().getHighScore());

            });
        });

    }

    public void stickGrow(MouseEvent event) throws InterruptedException {// for growing the stick
        if (freq1==0)
        {   if (!isBool_mute()) {
            Thread new_t = new Thread(this::play_stick_grow_sound);
            new_t.start();
            new_t.join();
        }
//            System.out.println("GETX OF BLOCKAFTER BEFORE STICK GROW: " + blockAfter.getX());
            timeline1.play();
            freq1++;
        }
    }

    public void moveCenter(double x, double y){
        this.stick.getTransforms().add(new Translate(-x, -y));
        this.stick.setTranslateX(x);
        this.stick.setTranslateY(y);
    }

    public void moveCenterPlayer(double x, double y){
        this.imageView.getTransforms().add(new Translate(-x, -y));
        this.imageView.setTranslateX(x);
        this.imageView.setTranslateY(y);
    }

    public void levelChange(){// for bringing in a new block
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
            y=300;
            cherry.setOpacity(0);
            cherry = (new Cherry(blockPrevious, blockAfter)).getImageView();
            pane.getChildren().add(cherry);
        });
    }

    //The function is activated when we release the mouse. The stick stops growing when we realease the mouse and with pivot at the stick base, it rotates
    //and executes a full 90degree rotation. When we loose we die and when we win we move to the next function
    public void stickStop(MouseEvent event) throws IOException, InterruptedException {// for stopping the growth of the stick once it has
                                                                                      // reached the sufficient length
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
            }
            freq2++;
        }
    }
    public void screenClick(MouseEvent event){// for inverting the character after the mouse is pressed twice
//        if (freq1>0 && freq2>0)
//        {
//            rotateTransition2 = new RotateTransition(Duration.millis(1), cherry);
//            rotateTransition2.setCycleCount(1);
//            rotateTransition2.setByAngle(-180);
////            rotateTransition2.play();
//        }
        if (freq1%2==0 && freq2%2==0)
        {
            imageView.setY(imageView.getY()+31);
            imageView.setScaleY(-1);
            FLAGiNVERT=1;
//            imageView.setScaleX(1);
        } else if ((freq1%2!=0 && freq2%2!=0) && (freq1>1 && freq2>1)){
            FLAGiNVERT=0;
            imageView.setY(imageView.getY()-31);
            imageView.setScaleY(1);
//            imageView.setScaleX(-1);
        }
        freq1++;
        freq2++;
        System.out.println(" " + freq1 + " " + freq2);
    }

    @FXML
    public void pause(ActionEvent event) throws IOException {
        load_fxml("Pause_Menu.fxml");
    }
}