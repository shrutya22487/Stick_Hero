package com.example.stick_hero;

import java.io.*;
public class Profile implements Serializable {
    private String username;
    private String password;
    private int berries;
    private Avatar av1;
    private int highScore;
    public Profile(String username, String password, int berries, Avatar av1, int highScore) {
        this.username = username;
        this.password = password;
        this.berries = berries;
        this.av1 = av1;
        this.highScore = highScore;
    }
    public int getBerries() {
        return berries;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Avatar getAv1() {
        return av1;
    }
    public int getHighScore() {
        return highScore;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBerries(int berries) {
        this.berries = berries;
    }
    public void setAv1(Avatar av1) {
        this.av1 = av1;
    }
    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public void serializeProfile(Profile p)
    {
        try{
            FileOutputStream newFileOutput = new FileOutputStream("Profile.txt");
            ObjectOutputStream o = new ObjectOutputStream(newFileOutput);
            o.writeObject(p);
            o.close();
            newFileOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Profile deserializeProfile(){
        Profile p = null;
        try{
            FileInputStream newFileInput = new FileInputStream("Profile.txt");
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
