package com.example.stick_hero;

import javafx.scene.image.Image;

public class Avatar {
    private Image standing1, standing2, run1, run2, run3;
    private int cherries, best_score;

    public Avatar(String standing1, String standing2, String run1, String run2, String run3) {
        this.standing1 = new Image(getClass().getResourceAsStream(standing1));
        this.standing2 = new Image(getClass().getResourceAsStream(standing2));
        this.run1 = new Image(getClass().getResourceAsStream(run1));
        this.run2 = new Image(getClass().getResourceAsStream(run2));
        this.run3 = new Image(getClass().getResourceAsStream(run3));
        this.cherries = 0;
        this.best_score = 0;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    public void setBest_score(int best_score) {
        this.best_score = best_score;
    }

    public Image getStanding1() {
        return standing1;
    }

    public Image getStanding2() {
        return standing2;
    }

    public Image getRun1() {
        return run1;
    }

    public Image getRun2() {
        return run2;
    }

    public Image getRun3() {
        return run3;
    }

    public int getCherries() {
        return cherries;
    }

    public int getBest_score() {
        return best_score;
    }
}
