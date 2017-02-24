package sample.Player;

import javafx.scene.image.Image;
import sample.Achievments.Achievement;
import sample.GlobalVariables;

import java.util.ArrayList;

import static sample.Graphics.RoomsParameters.brickSingleHorizontal;

public class Player extends Sprite {
    private double health;

    public Player(){
        health = 100;
    }

    public double getPlayerHealth(){
        return health;
    }

    public void subtractPlayerHealth(){
        this.health -= 0.10;
    }

    public int score = 0;

    public ArrayList<Achievement> achievements = new ArrayList<>();

    public static void changeImage(String direction) {
        switch (direction) {
            case "down":
                String tempImage = GlobalVariables.getPlayerDownImages().pop();
                GlobalVariables.getPlayerDownImages().addLast(tempImage);
                GlobalVariables.getPlayer().setImage(tempImage);
                break;
            case "up":
                String tempImageUp = GlobalVariables.getPlayerUpImages().pop();
                GlobalVariables.getPlayerUpImages().addLast(tempImageUp);
                GlobalVariables.getPlayer().setImage(tempImageUp);
                break;
            case "right":
                String tempImageRight = GlobalVariables.getPlayerRightImages().pop();
                GlobalVariables.getPlayerRightImages().addLast(tempImageRight);
                GlobalVariables.getPlayer().setImage(tempImageRight);
                break;
            case "left":
                String tempImageLeft = GlobalVariables.getPlayerLeftImages().pop();
                GlobalVariables.getPlayerLeftImages().addLast(tempImageLeft);
                GlobalVariables.getPlayer().setImage(tempImageLeft);
                break;
            default:
                break;
        }
    }

    public static void move(int x, int y, String direction, int x1, int y1) {
        GlobalVariables.getStepCounter().addAndGet(1);
        //Running
        if (GlobalVariables.getInput().contains("SHIFT")) {
            GlobalVariables.getPlayer().addVelocity(x, y);
            if (GlobalVariables.getStepCounter().get() == 5) {
                if (GlobalVariables.getWalking().isPlaying()) {
                    GlobalVariables.getWalking().stop();
                }
                if (!GlobalVariables.getRunning().isPlaying()) {
                    if (!GlobalVariables.getMute()[0]) {
                        GlobalVariables.getRunning().play(1, 0, 1.0, 0.0, -5);
                    }
                }
                Player.changeImage(direction);
                GlobalVariables.getStepCounter().set(0);
            }
            //Walking
        }
        GlobalVariables.getPlayer().addVelocity(x1, y1);

        if (GlobalVariables.getStepCounter().get() == 10) {
            if (GlobalVariables.getRunning().isPlaying()) {
                GlobalVariables.getRunning().stop();
            }
            if (!GlobalVariables.getWalking().isPlaying()) {
                if (!GlobalVariables.getMute()[0]) {
                    GlobalVariables.getWalking().play(1, 0, 1.2, 0.0, -5);
                }
            }
            Player.changeImage(direction);
            GlobalVariables.getStepCounter().set(0);
        }
        GlobalVariables.getPlayer().hasAlreadyHit = false;
    }

    public static void checkIfPlayerCollidesLR() {
        //checks if LEFT or RIGHT is already pressed; prevents sound spam
        if (GlobalVariables.getInput().contains("LEFT") || GlobalVariables.getInput().contains("RIGHT")) {
            GlobalVariables.getPlayer().hasAlreadyHit = true;
        }
        if (!GlobalVariables.getPlayer().hasAlreadyHit) {
            GlobalVariables.getWalking().stop();
            GlobalVariables.getRunning().stop();
            if (!GlobalVariables.getMute()[0]) {
                GlobalVariables.getWallHit().play(1);
            }
        }
        GlobalVariables.getPlayer().hasAlreadyHit = true;
        GlobalVariables.getPlayer().addVelocity(0, 0);
    }

    public static void checkIfPlayerCollidesUD() {
        //checks if UP or DOWN is already pressed; prevents sound spam
        if (GlobalVariables.getInput().contains("UP") || GlobalVariables.getInput().contains("DOWN")) {
            GlobalVariables.getPlayer().hasAlreadyHit = true;
        }
        if (!GlobalVariables.getPlayer().hasAlreadyHit) {
            GlobalVariables.getWalking().stop();
            GlobalVariables.getRunning().stop();
            if (!GlobalVariables.getMute()[0]) {
                GlobalVariables.getWallHit().play(1);
            }
        }
        GlobalVariables.getPlayer().hasAlreadyHit = true;
        GlobalVariables.getPlayer().addVelocity(0, 0);
    }

    public static void createPlayerObject() {
        Image playerImage = new Image("img/playerFront0.png", 45, 120, false, false);
        GlobalVariables.setPlayer(new Player());
        GlobalVariables.getPlayer().setImage(playerImage);
        GlobalVariables.getPlayer().setPosition(5 * brickSingleHorizontal.getWidth(), 20);
    }
}
