package com.example.stick_hero;

import javafx.scene.shape.Rectangle;

public class Stick {
    private Rectangle stick;
    private Rectangle platformPrevious;

    public Rectangle getStick() {
        return stick;
    }

    public Stick(Rectangle platformPrevious) {
        this.platformPrevious = platformPrevious;
        stick = new Rectangle();
        stick.setLayoutX(0);
        stick.setLayoutY(0);
        stick.setHeight(0);
        stick.setWidth(3);
        stick.setY(646);
        stick.setX(platformPrevious.getX() + platformPrevious.getWidth());
    }
}
