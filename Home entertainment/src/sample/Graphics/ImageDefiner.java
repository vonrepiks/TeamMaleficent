package sample.Graphics;

import javafx.scene.image.Image;
import sample.GlobalVariables;

import static sample.GlobalVariables.BATHROOM_HEIGHT;
import static sample.GlobalVariables.*;

public class ImageDefiner {
    private static Image parquet;
    private static Image tiles;
    private static Image carpet;
    private static Image carpet2;
    private static Image siphon;
    private static Image statsBoard;

    public static void defineImages () {
        parquet = new Image("img/parquet.jpg", KITCHEN_WIDTH, KITCHEN_HEIGHT / 2, false, false);
        tiles = new Image("img/tiles2.jpg", BATHROOM_WIDTH, BATHROOM_HEIGHT / 2, false, false);
        carpet = new Image("img/carpet.jpg", LIVING_ROOM_WIDTH / 2, LIVING_ROOM_HEIGHT / 2, false, false);
        carpet2 = new Image("img/carpet03.jpg", BEDROOM_WIDTH, BEDROOM_HEIGHT / 2, false, false);
        siphon = new Image("img/siphon.png", 40, 40, false, false);
        statsBoard = new Image("img/statsBoard.png");
    }

    static Image getParquet() {
        return parquet;
    }

    static Image getTiles() {
        return tiles;
    }

    public static Image getCarpet() {
        return carpet;
    }

    static Image getCarpet2() {
        return carpet2;
    }

    static Image getSiphon() {
        return siphon;
    }

    static Image getStatsBoard() {
        return statsBoard;
    }
}