package com.example.stick_hero;

import java.io.*;
public class Profile implements Serializable {
    private int cherries = 0;
    private int highScore = 0, curr_score = 0;

    public int getCurr_score() {
        return curr_score;
    }


    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void setCurr_score(int curr_score) {
        this.curr_score = curr_score;
    }

    public int getHighScore() {
        return highScore;
    }

    public static void serializeProfile(Profile p, String filename)
    {
        try{
            System.out.println(p.getCurr_score());
            FileOutputStream newFileOutput = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(newFileOutput);
            o.writeObject(p);
            o.close();
            newFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Profile deserializeProfile( String filename){
        Profile p = null;
        try{
            FileInputStream newFileInput = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(newFileInput);
            p = (Profile) in.readObject();
            in.close();
            newFileInput.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return p;
    }

}
