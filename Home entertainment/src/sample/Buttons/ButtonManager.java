package sample.Buttons;

import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import sample.GlobalVariables;

public class ButtonManager {
    private static final Image[] imageSound = {new Image("img/soundOn.png", 30, 30, false, false)};
    private static final boolean[] isMainWindow = {true};
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
    private static Rectangle menu;

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

    public static void setButtonsParameters() {
        //Menu params
        double menuWidth = (3 * ButtonManager.getButtonMenu().getPrefWidth()) + (2 * 50);
        double menuHeight = GlobalVariables.getCanvas().getHeight() - (GlobalVariables.getCanvas().getHeight() / 2) + 100;
        double menuX = ButtonManager.getButtonMenu().getLayoutX();
        double menuY = (GlobalVariables.getCanvas().getHeight() - (GlobalVariables.getCanvas().getHeight() / 2)) / 2 - 100;
        menu = new Rectangle(menuX, menuY, menuWidth, menuHeight);
        menu.setFill(Color.SKYBLUE);

        //Menu Title
        Font menuTitleFont = Font.font(java.awt.Font.MONOSPACED, 43);
        ButtonManager.getMenuTitle().setFont(menuTitleFont);
        ButtonManager.getMenuTitle().setFill(Color.MEDIUMVIOLETRED);
        ButtonManager.getMenuTitle().setX(GlobalVariables.getCanvas().getWidth() / 2 - 20);
        ButtonManager.getMenuTitle().setY(menuY + 50);

        //Menu Sound control
        Font menuSound1 = Font.font(java.awt.Font.MONOSPACED, 20);
        ButtonManager.getMenuSoundText1().setFont(menuSound1);
        ButtonManager.getMenuSoundText1().setFill(Color.MEDIUMVIOLETRED);
        ButtonManager.getMenuSoundText1().setX(menuX + 60);
        ButtonManager.getMenuSoundText1().setY(menuY + 100);
        Font menuSound2 = Font.font(java.awt.Font.MONOSPACED, 15);
        ButtonManager.getMenuSoundText2().setFont(menuSound2);
        ButtonManager.getMenuSoundText2().setFill(Color.MEDIUMVIOLETRED);
        ButtonManager.getMenuSoundText2().setX(menuX + 60);
        ButtonManager.getMenuSoundText2().setY(menuY + 120);
        ButtonManager.getKeyboardGuideTitle().setFont(menuSound1);
        ButtonManager.getKeyboardGuideTitle().setFill(Color.MEDIUMVIOLETRED);
        ButtonManager.getKeyboardGuideTitle().setX(menuX + 10);
        ButtonManager.getKeyboardGuideTitle().setY(menuY + 180);
        ButtonManager.getKeyboardGuideTitle().setFont(menuSound2);
        ButtonManager.getKeyboardGuideTitle().setFill(Color.MEDIUMVIOLETRED);
        ButtonManager.getKeyboardGuideTitle().setX(menuX + 10);
        ButtonManager.getKeyboardGuideTitle().setY(menuY + 200);
        ButtonManager.getKeyboardGuideTitle().setWrappingWidth(menu.getWidth() - 20);

        //Button Sound
        ButtonManager.getButtonSound().setGraphic(new ImageView(ButtonManager.getImageSound()[0]));
        ButtonManager.getButtonSound().setLayoutX(menuX + 10);
        ButtonManager.getButtonSound().setLayoutY(menuY + 80);

        //Button Menu close
        Image imageDecline = new Image("img/not1.png", 30, 30, false, false);
        ButtonManager.getButtonClose().setGraphic(new ImageView(imageDecline));
        ButtonManager.getButtonClose().setLayoutX(menuX - ButtonManager.getButtonClose().getWidth() / 2);
        ButtonManager.getButtonClose().setLayoutY(menuY - ButtonManager.getButtonClose().getHeight() / 2);

    }

    static Button getButtonMenu() {
        return buttonMenu;
    }

    static Button getButtonStart() {
        return buttonStart;
    }

    public static Button getButtonQuit() {
        return buttonQuit;
    }

    static Button getButtonClose() {
        return buttonClose;
    }

    static Button getButtonSound() {
        return buttonSound;
    }

    public static Button getButtonStartNewGame() {
        return buttonStartNewGame;
    }

    static Button getButtonResume() {
        return buttonResume;
    }

    public static SequentialTransition getBlinkedButton() {
        return blinkedButton;
    }

    static Text getMenuTitle() {
        return menuTitle;
    }

    static Text getMenuSoundText1() {
        return menuSoundText1;
    }

    static Text getMenuSoundText2() {
        return menuSoundText2;
    }

    static Text getKeyboardGuideTitle() {
        return keyboardGuideTitle;
    }

    static Text getKeyboardGuide() {
        return keyboardGuide;
    }

    static Image[] getImageSound() {
        return imageSound;
    }

    static boolean[] getIsMainWindow() {
        return isMainWindow;
    }

    static Rectangle getMenu() {
        return menu;
    }
}
