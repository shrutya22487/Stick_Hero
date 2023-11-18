package com.example.stick_hero;

import javafx.scene.image.Image;

public abstract class Menu {
    private int Cherries;
    private Image Background;

    public Menu(int cherries, Image background) {
        Cherries = cherries;
        Background = background;
    }

    public int getCherries() {
        return Cherries;
    }

    public Image getBackground() {
        return Background;
    }

}
