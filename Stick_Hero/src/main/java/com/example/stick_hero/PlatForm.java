package com.example.stick_hero;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PlatForm {
    private int height;
    private int width;
    private int distanceFromPrev;
    private Rectangle previousPlatform;
    private final Random random = new Random();
    private Rectangle platformCurrent;

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
    public Rectangle getPlatformCurrent() {
        return platformCurrent;
    }
    public int getDistanceFromPrev() {
        return distanceFromPrev;
    }

    public PlatForm(Rectangle previousPlatform) {
        this.height = 204;
        this.previousPlatform = previousPlatform;
        this.width = random.nextInt(50, 200);
        this.distanceFromPrev = random.nextInt(10, 500-(int)previousPlatform.getWidth()-width);
        platformCurrent = new Rectangle();
        platformCurrent.setLayoutX(0);
        platformCurrent.setLayoutY(0);
        platformCurrent.setHeight(height);
        platformCurrent.setWidth(width);
        platformCurrent.setX(previousPlatform.getX()+previousPlatform.getWidth()+10+this.distanceFromPrev);
        platformCurrent.setY(646);
        platformCurrent.setFill(Color.DARKGRAY);
    }
}
