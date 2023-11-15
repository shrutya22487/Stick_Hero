package com.example.stick_hero;

import javafx.scene.image.Image;

public class Avatar {
    private Image standing1, standing2, run1, run2, run3;
    private int cost;
    private boolean bought;

    public Avatar(Image standing1, Image standing2, Image run1, Image run2, Image run3, int cost, boolean bought) {
        this.standing1 = standing1;
        this.standing2 = standing2;
        this.run1 = run1;
        this.run2 = run2;
        this.run3 = run3;
        this.cost = cost;
        this.bought = bought;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBought(boolean bought) {
        this.bought = bought;
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

    public int getCost() {
        return cost;
    }

    public boolean isBought() {
        return bought;
    }
}
