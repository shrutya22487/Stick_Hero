package com.example.stick_hero;

import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.Test;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.io.NotActiveException;

import static org.junit.Assert.*;
public class testing {
    //to check
    @Test
    public void check_null_profile() {
        assertNotNull(BeginScreen.getInstance(new Profile()).get_profile());
    }
    //checking if the profile has been created properly

    @Test
    public void check_fresh_game() {
        //checks if no profiles exist in the game
        File file1 = new File("game_1.txt");
        assertFalse(file1.exists());
        File file2 = new File("game_2.txt");
        assertFalse(file2.exists());
        File file3 = new File("game_3.txt");
        assertFalse(file3.exists());
    }

    @Test
    public void check_Serialization() {// check if the serialization has been done properly
        Profile real = new Profile();
        real.setCherries(3);
        real.setCurr_score(123);
        Profile.serializeProfile(real, "game_4.txt");
        assertEquals(real, Profile.deserializeProfile("game_4.txt"));
    }

    @Test
    public void checkPlatformHeight() {// check if the height of the rectangle created is created or not
        Rectangle r = new Rectangle();
        r.setHeight(200);
        r.setWidth(100);
        Rectangle r1 = (new PlatForm(r)).getPlatformCurrent();
        assertEquals(200, (int) r1.getHeight());
    }



}
