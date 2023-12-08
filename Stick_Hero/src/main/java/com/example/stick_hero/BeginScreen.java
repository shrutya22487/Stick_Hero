package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class BeginScreen extends Menu {


    @FXML
    public void new_game(ActionEvent event) throws IOException{
        Profile new_profile = new Profile();
        this.set_profile(new_profile);
        Start_screen ss = (Start_screen) load_fxml("Start_screen.fxml");
    }

    @FXML
    public void choose_profile(ActionEvent event){
//        try{
//            Stage stage = Main.stage;
//            FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource("profile_select.fxml"));
//            Scene scene = new Scene( fxml_loader.load() );
//            Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
//            profile_select profileSelect = fxml_loader.getController();
//            profileSelect.check_files();
//            stage.getIcons().add(icon);
//            stage.setTitle("Stick Hero");
//            stage.setFullScreen(true);
//            stage.setScene(scene);
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }
    @FXML
    public void exit(ActionEvent event) {
        Main.stage.close();
    }
}
