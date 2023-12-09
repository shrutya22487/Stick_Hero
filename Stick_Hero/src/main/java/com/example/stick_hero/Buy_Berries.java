package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Buy_Berries extends Menu{
    @FXML
    public void buy_10_berries(ActionEvent event) throws IOException {
        int cherries = get_profile().getCherries();
        cherries += 10;
        get_profile().setCherries(cherries);
        load_fxml("Start_screen.fxml");
    }@FXML
    public void buy_20_berries(ActionEvent event) throws IOException {
        int cherries = get_profile().getCherries();
        cherries += 20;
        get_profile().setCherries(cherries);
        load_fxml("Start_screen.fxml");
    }@FXML
    public void buy_30_berries(ActionEvent event) throws IOException {
        int cherries = get_profile().getCherries();
        cherries += 30;
        get_profile().setCherries(cherries);
        load_fxml("Start_screen.fxml");
    }
}
