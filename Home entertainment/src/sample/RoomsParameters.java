package sample;

import javafx.scene.image.Image;

import static sample.Main.canvas;

public class RoomsParameters {

    // Create Image and ImageView objects
    public static Image brickSingleHorizontal = new Image("img/brickSingleHorizontal.png");
    public static Image brickSingleVert = new Image("img/brickSingleVert.png");
    public static Image wallShort = new Image("img/wallShort.png");
    public static Image wallColon = new Image("img/wallColon.png");

    //borders Kitchen
    public static double KITCHEN_X = brickSingleVert.getWidth();
    public static double KITCHEN_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight();
    public static double KITCHEN_WIDTH = brickSingleHorizontal.getWidth() * 8;
    public static double KITCHEN_HEIGHT = canvas.getHeight() / 2 - brickSingleHorizontal.getHeight();

    //borders Living room
    public static double LIVINGROOM_X = brickSingleVert.getWidth();
    public static double LIVINGROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT + brickSingleHorizontal.getHeight();
    public static double LIVINGROOM_WIDTH = brickSingleHorizontal.getWidth() * 10 - brickSingleVert.getWidth();
    public static double LIVINGROOM_HEIGHT = canvas.getHeight() - LIVINGROOM_Y - (2 * brickSingleHorizontal.getHeight());

    //borders Bedroom
    public static double BEDROOM_X = brickSingleVert.getWidth() + KITCHEN_WIDTH + brickSingleVert.getWidth();
    public static double BEDROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight();
    public static double BEDROOM_WIDTH = canvas.getWidth() - KITCHEN_WIDTH - (3 * brickSingleVert.getWidth());
    public static double BEDROOM_HEIGHT = canvas.getHeight() / 2 - brickSingleHorizontal.getHeight();

    //borders Bathroom
    public static double BATHROOM_X = brickSingleVert.getWidth() + LIVINGROOM_WIDTH + brickSingleVert.getWidth();
    public static double BATHROOM_Y = brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT + brickSingleHorizontal.getHeight();
    public static double BATHROOM_WIDTH = canvas.getWidth() - (3 * brickSingleVert.getWidth()) - LIVINGROOM_WIDTH;
    public static double BATHROOM_HEIGHT = canvas.getHeight() - LIVINGROOM_Y - (2 * brickSingleHorizontal.getHeight());
}
