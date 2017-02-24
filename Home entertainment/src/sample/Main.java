package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import sample.Buttons.ButtonEvents;
import sample.Buttons.ButtonManager;
import sample.Enemy.Monsters;
import sample.Graphics.GraphicDisplayer;
import sample.Graphics.ImageDefiner;
import sample.Player.Player;
import sample.Sounds.SoundManager;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {

        //Set stage properties
        theStage.setTitle("Home entertainment");
        GlobalVariables.setRoot(new Group());
        Scene theScene = new Scene(GlobalVariables.getRoot(), 1024, 748, Color.WHITESMOKE);
        theStage.setScene(theScene);
        GlobalVariables.getRoot().getChildren().add(GlobalVariables.getCanvas());

        // Define object images
        ImageDefiner.defineImages();

        //Set player images for all directions
        GlobalVariables.setPlayerRightImages(new ArrayDeque<>());
        GlobalVariables.setPlayerLeftImages(new ArrayDeque<>());
        GlobalVariables.setPlayerDownImages(new ArrayDeque<>());
        GlobalVariables.setPlayerUpImages(new ArrayDeque<>());

        //Create the player object
        Player.createPlayerObject();

        //Set monster images
        Monsters.setMonsterImages();

        //Start create different monsters
        Monsters.createMonsters();
        GlobalVariables.setMonstersToRender(new ArrayList<>());

        //Take the keys inputs
        GlobalVariables.setInput(new ArrayList<>());

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!GlobalVariables.getInput().contains(code))
                            GlobalVariables.getInput().add(code);
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        GlobalVariables.getInput().remove(code);
                    }
                });

        //Display introduce on Main page
        GraphicDisplayer.displayIntroduce();

        //Display all objects in the house.
        GraphicDisplayer.displayObjects();

        // Load sounds
        SoundManager.loadSounds();

       //CreateButtons
        ButtonManager.createButtons();

        //Set all buttons parameters
        ButtonManager.setButtonsParameters();

        //Set all buttons events
        ButtonEvents.attachSoundButtonEvent();
        ButtonEvents.attachCloseButtonEvent();
        ButtonEvents.attachButtonMenuAction();
        ButtonEvents.attachButtonQuitAction(theStage);
        ButtonEvents.attachButtonStartAction(theStage);
        theStage.show();
        ButtonManager.getBlinkedButton().play();
    }
}