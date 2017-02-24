package sample.Enemy;

import javafx.scene.image.Image;
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

    public static ArrayDeque<String> getMonstersImages() {
        return monstersImages;
    }
}
