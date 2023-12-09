package com.example.stick_hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.net.BindException;
import java.util.Random;

public class Cherry {
    private int disPreviousPlatform;
    private ImageView imageView;
    private Image cherry;
    private int imageWidth;
    private Rectangle prev;
    private Rectangle after;
    private final Random r = new Random();
    public ImageView getImageView() {
        return imageView;
    }
    public Cherry(Rectangle prev, Rectangle after) {
        this.prev = prev;
        this.after = after;
        cherry = new Image("cherry.png");
        imageView = new ImageView();
        imageView.setImage(cherry);
        imageView.setFitWidth(25);
        imageView.setFitHeight(25);
        imageWidth = (int)imageView.getFitWidth();
        System.out.println("GETX OF AFTER:" + after.getX());
        System.out.println("GETX OF BEFORE:" + prev.getX());
        System.out.println("prev getWidth:" + prev.getWidth());
        System.out.println();
        this.disPreviousPlatform = r.nextInt(5, (int) (after.getX() - prev.getX() - prev.getWidth()));
        imageView.setX(prev.getWidth() + disPreviousPlatform);
        imageView.setY(310);
    }
}
