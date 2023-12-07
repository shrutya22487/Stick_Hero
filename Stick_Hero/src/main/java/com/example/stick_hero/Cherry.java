package com.example.stick_hero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

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
//        cherry = new Image("C:\\Users\\ASUS\\Desktop\\AP_Project\\Stick_Hero\\src\\main\\resources\\com\\example\\stick_hero\\cherry.png");
//        imageView = new ImageView();
//        imageView.setImage(cherry);
//        imageWidth = (int)imageView.getFitWidth();
//        this.disPreviousPlatform = r.nextInt(5, (int) (after.getX() - prev.getX() - prev.getWidth()));
//        imageView.setX(prev.getWidth() + disPreviousPlatform);
    }
}
