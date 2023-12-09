package com.example.stick_hero;

import javafx.scene.media.MediaPlayer;
import org.junit.Test;

import java.io.File;
import java.io.NotActiveException;

import static org.junit.Assert.*;
public class testing {
    //to check
    @Test
    public void check_null_profile() {
        assertNotNull(BeginScreen.getInstance(new Profile()).get_profile());
    }

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
    public void check_Serialization() {
        Profile real = new Profile();
        real.setCherries(3);
        real.setCurr_score(123);
        Profile.serializeProfile(real, "game_4.txt");
        assertEquals(real, Profile.deserializeProfile("game_4.txt"));
    }



}