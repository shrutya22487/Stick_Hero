package com.example.stick_hero;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class profile_select {
    Profile profile;
    @FXML
    Button button_profile_1;
    @FXML
    Button button_profile_2;
    @FXML
    Button button_profile_3;
    @FXML
    public  void open_profile_1(ActionEvent event) throws IOException {
        File file = new File("game-" + 1 + ".dat");
        if (file.exists()) {
            ObjectInputStream in;
            try {
                in = new ObjectInputStream(Files.newInputStream(Paths.get("game1.dat")));
                profile = (Profile) in.readObject();
                in.close();
                Stage stage = Main.stage;
                FXMLLoader fxml_loader =  new FXMLLoader(getClass().getResource("Game_screen.fxml"));
                Scene scene = new Scene( fxml_loader.load() );
                Image icon = new Image("file:src\\main\\resources\\com\\example\\stick_hero\\hero.png");
                Game_screen game = fxml_loader.getController();
                game.setProfile(profile);
                stage.getIcons().add(icon);
                stage.setTitle("Stick Hero");
                stage.setFullScreen(true);
                stage.setScene(scene);
                //pass to game screen here
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void check_files(){
        File file = new File("game-" + 1 + ".dat");
        if (file.exists()) button_profile_1.setText("Game_1");
        else button_profile_1.setText("New Game");
        file = new File("game-" + 2 + ".dat");
        if (file.exists()) button_profile_2.setText("Game_1");
        else button_profile_2.setText("New Game");
        file = new File("game-" + 3 + ".dat");
        if (file.exists()) button_profile_3.setText("Game_1");
        else button_profile_3.setText("New Game");
    }
}
