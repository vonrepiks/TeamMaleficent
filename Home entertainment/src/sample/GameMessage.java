package sample;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 * Created by cvetan on 2/16/2017.
 */
public class GameMessage {

    private final Group root;
    private final Player player;
    private final int achievementX;
    private final int achievementY;

    public GameMessage(Player player, Group root) {
        
        this.root = root;
        this.player = player;
        this.achievementX = 200;
        this.achievementY = 100;
    }

    public void watch() {

        // Game over
        if (player.getPlayerHealth() <= 0){
            this.renderMessage("Bugs owned the house and ate you, Game Over!", 10000000, Color.RED);
        }

        // Headshot

        // Multi kill

        // Rampage

        // Killingspree

        // Unstoppable

        // Holy shit

    }

    public void renderMessage(String text, int duration, Color color) {

        Text t = new Text(this.achievementX, this.achievementY, text);
        FadeTransition ft = new FadeTransition(Duration.millis(duration), t);
        t.setFont(Font.font ("Verdana", 25));
        t.setFill(color);
        root.getChildren().add(t);
        ft.setFromValue(1);
        ft.setToValue(0);
        ft.setCycleCount(1);
        ft.play();
    }
}