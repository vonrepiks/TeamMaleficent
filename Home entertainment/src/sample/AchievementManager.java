package sample;

import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Created by cvetan on 2/15/2017.
 */
public class AchievementManager {

    private final GraphicsContext gc;
    private final int achievementY;
    private final int achievementX;
    public Player player;
    private Group root;

    public AchievementManager(Player player, GraphicsContext gc, Group root) {

        this.player = player;
        this.gc = gc;
        this.achievementX = 200;
        this.achievementY = 100;
        this.root = root;
    }

    public void observe() {

        switch ((int) this.player.score) {

            case 200:

                Achievement assassin = new Achievement("assassin", "Congrats! You unlocked the begginer assassin achievement.");
                this.player.achievements.add(assassin);
                this.renderAchievement(assassin);
                break;

            case 500:

                Achievement maniac = new Achievement("maniac", "Congrats! You unlocked the maniac behaviour achievement.");
                this.player.achievements.add(maniac);
                this.renderAchievement(maniac);
                break;
        }
    }

    public void renderAchievement(Achievement ach) {

        Text t = new Text(this.achievementX, this.achievementY, ach.unlockingText);
        t.setFont(Font.font ("Verdana", 25));
        t.setFill(Color.DARKRED);
        root.getChildren().add(t);

        FadeTransition ft = new FadeTransition(Duration.millis(2000), t);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.play();
    }
}
