package sample.Buttons;

import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import sample.GlobalVariables;

public class ButtonManager {
    private static Button buttonMenu;
    private static Button buttonStart;
    private static Button buttonQuit;
    private static Button buttonClose;
    private static Button buttonSound;
    private static Button buttonStartNewGame;
    private static Button buttonResume;
    private static SequentialTransition blinkedButton;
    private static Text menuTitle;
    private static Text menuSoundText1;
    private static Text menuSoundText2;
    private static Text keyboardGuideTitle;
    private static Text keyboardGuide;
    private static final Image[] imageSound = {new Image("img/soundOn.png", 30, 30, false, false)};
    private static final boolean[] isMainWindow = {true};

    public static void createButtons() {
        //Button menu
        buttonMenu = new Button("Menu");
        buttonMenu.setPrefHeight(50);
        buttonMenu.setPrefWidth(150);
        buttonMenu.setLayoutX((GlobalVariables.getCanvas().getWidth() - (3 * buttonMenu.getPrefWidth()) - (2 * 50)) / 2 + 15);
        buttonMenu.setLayoutY(GlobalVariables.getCanvas().getHeight() - 180);
        buttonMenu.setStyle("-fx-font: 22 arial");
        GlobalVariables.getRoot().getChildren().add(buttonMenu);

        //Button start
        buttonStart = new Button("Start");
        buttonStart.setPrefHeight(50);
        buttonStart.setPrefWidth(150);
        buttonStart.setLayoutX(buttonMenu.getLayoutX() + buttonMenu.getPrefWidth() + 50);
        buttonStart.setLayoutY(GlobalVariables.getCanvas().getHeight() - 180);
        buttonStart.setStyle("-fx-font: 22 arial");
        GlobalVariables.getRoot().getChildren().add(buttonStart);

        //Button quit
        buttonQuit = new Button("Quit");
        buttonQuit.setPrefHeight(50);
        buttonQuit.setPrefWidth(150);
        buttonQuit.setLayoutX(buttonStart.getLayoutX() + buttonStart.getPrefWidth() + 50);
        buttonQuit.setLayoutY(GlobalVariables.getCanvas().getHeight() - 180);
        buttonQuit.setStyle("-fx-font: 22 arial");
        GlobalVariables.getRoot().getChildren().add(buttonQuit);

        //Blink option
        Timeline blinker = Blinker.createBlinker(buttonStart);
        blinkedButton = new SequentialTransition(buttonStart, blinker);

        menuTitle = new Text("Menu");
        menuSoundText1 = new Text("Sound ON");
        menuSoundText2 = new Text("Affects all sounds and music");
        keyboardGuideTitle = new Text("Keyboard guide:\n");
        keyboardGuide = new Text("\t-'P' button - pause;\n\t-'Esc' button - show menu;\n\t-'Left' button - player moving left;\n\t-'Right' button - player moving right;\n\t-'Up' button - player moving up;\n\t-'Down' button - player moving down;\n\t-'Shift' button with combination('Left', 'Right', 'Up', or 'Down' buttons) - player start running;");
        buttonClose = new Button();
        buttonSound = new Button();
        buttonStartNewGame = new Button("New Game");
        buttonResume = new Button("Resume");
    }

    public static Button getButtonMenu() {
        return buttonMenu;
    }

    public static Button getButtonStart() {
        return buttonStart;
    }

    public static Button getButtonQuit() {
        return buttonQuit;
    }

    public static Button getButtonClose() {
        return buttonClose;
    }

    public static Button getButtonSound() {
        return buttonSound;
    }

    public static Button getButtonStartNewGame() {
        return buttonStartNewGame;
    }

    public static Button getButtonResume() {
        return buttonResume;
    }

    public static SequentialTransition getBlinkedButton() {
        return blinkedButton;
    }

    public static Text getMenuTitle() {
        return menuTitle;
    }

    public static Text getMenuSoundText1() {
        return menuSoundText1;
    }

    public static Text getMenuSoundText2() {
        return menuSoundText2;
    }

    public static Text getKeyboardGuideTitle() {
        return keyboardGuideTitle;
    }

    public static Text getKeyboardGuide() {
        return keyboardGuide;
    }

    public static Image[] getImageSound() {
        return imageSound;
    }

    public static boolean[] getIsMainWindow() {
        return isMainWindow;
    }
}
