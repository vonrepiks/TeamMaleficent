package sample.Enemy;

import javafx.animation.AnimationTimer;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.Achievments.AchievementManager;
import sample.Achievments.GameMessage;
import sample.Buttons.ButtonManager;
import sample.GlobalVariables;
import sample.Player.Sprite;

import java.util.ArrayDeque;

public class Monsters {

    private static ArrayDeque<String> monstersImages;

    public static void setMonsterImages() {
        monstersImages = new ArrayDeque<>();
        monstersImages.addLast("img/monster.gif");
        monstersImages.addLast("img/monster1.png");
        monstersImages.addLast("img/monster2.png");
    }

    public static void createMonsters() {
        GlobalVariables.setMonsterList(new ArrayDeque<>());
        for (int i = 0; i < 15; i++) {
            Sprite monster = new Sprite();
            String tempImage = monstersImages.pop();
            monstersImages.addLast(tempImage);
            Image monsterImage = new Image(tempImage, 50, 44, false, false);
            monster.setImage(monsterImage);
            GlobalVariables.getMonsterList().add(monster);
        }
    }

    public static void checkCollision(AnimationTimer animationTimer) {
        AchievementManager AM = new AchievementManager(GlobalVariables.getPlayer(), GlobalVariables.getGraphicContext(), GlobalVariables.getRoot());
        GameMessage GM = new GameMessage(GlobalVariables.getPlayer(), GlobalVariables.getRoot());

        for (Sprite monster : GlobalVariables.getMonstersToRender()) {
            if (GlobalVariables.getPlayer().intersects(monster)) {

                GM.renderMessage("Ouch!", 1000, Color.RED);

                if((int)GlobalVariables.getPlayer().getPlayerHealth() <= 0)
                    GM.renderMessage("Bugs owned the house and ate you, Game Over!", 10000000, Color.RED);

                GlobalVariables.getPlayer().subtractPlayerHealth();

                if (GlobalVariables.getPlayer().getPlayerHealth() <= 0){
                    GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonQuit());
                    GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonQuit());
                    GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonStartNewGame());
                    GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonStartNewGame());
                    animationTimer.stop();
                }

                AM.observe();
            }
        }
    }

    public static ArrayDeque<String> getMonstersImages() {
        return monstersImages;
    }
}