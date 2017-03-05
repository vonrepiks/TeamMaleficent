package sample;

import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import sample.Player.Player;
import sample.Player.Sprite;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalVariables {

    private static final String PROJECT_PATH = System.getProperty("user.dir") + "/Home entertainment";
    private static final int CANVAS_HEIGHT = 768;
    private static final int CANVAS_WIDTH = 1024;

    //borders Kitchen
    public static final double KITCHEN_X = 20;
    public static final double KITCHEN_Y = 100;
    public static final double KITCHEN_WIDTH = 496;
    public static final double KITCHEN_HEIGHT = 364;

    //borders Living room
    public static final double LIVING_ROOM_X = 20;
    public static final double LIVING_ROOM_Y = 484;
    public static final double LIVING_ROOM_WIDTH = 600;
    public static final double LIVING_ROOM_HEIGHT = 244;

    //borders Bedroom
    public static final double BEDROOM_X = 536;
    public static final double BEDROOM_Y = 100;
    public static final double BEDROOM_WIDTH = 468;
    public static final double BEDROOM_HEIGHT = 364;

    //borders Bathroom
    public static final double BATHROOM_X = 640;
    public static final double BATHROOM_Y = 484;
    public static final double BATHROOM_WIDTH = 364;
    public static final double BATHROOM_HEIGHT = 244;

    // Create Image and ImageView objects
    public static Image brickSingleHorizontal = new Image("img/brickSingleHorizontal.png");
    public static Image brickSingleVert = new Image("img/brickSingleVert.png");
    public static Image wallShort = new Image("img/wallShort.png");
    public static Image wallColon = new Image("img/wallColon.png");

    private static final boolean[] _mute = {false};
    private static Group root = new Group();
    private static Player _player;
    private static ArrayList<String> _input;
    private static AudioClip _walking, _running, _wallHit;
    private static AtomicInteger _stepCounter;
    private static ArrayDeque<String> _playerDownImages, _playerRightImages, _playerLeftImages, _playerUpImages;
    private static Canvas _canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
    private static String _direction;
    private static GraphicsContext gc = _canvas.getGraphicsContext2D();
    private static ArrayList<Sprite> monstersToRender;
    private static ArrayDeque<Sprite> monsterList;

    public static Player getPlayer() {
        return _player;
    }

    public static void setPlayer(Player player) {
        _player = player;
    }

    public static ArrayList<String> getInput() {
        return _input;
    }

    static void setInput(ArrayList<String> input) {
        _input = input;
    }

    public static AudioClip getWalking() {
        return _walking;
    }

    public static void setWalking(AudioClip walking) {
        _walking = walking;
    }

    public static AudioClip getRunning() {
        return _running;
    }

    public static void setRunning(AudioClip running) {
        _running = running;
    }

    public static AudioClip getWallHit() {
        return _wallHit;
    }

    public static void setWallHit(AudioClip wallHit) {
        _wallHit = wallHit;
    }

    public static AtomicInteger getStepCounter() {
        return _stepCounter;
    }

    public static void setStepCounter(AtomicInteger stepCounter) {
        _stepCounter = stepCounter;
    }

    public static boolean[] getMute() {
        return _mute;
    }

    public static void setMute(boolean mute) {
         _mute[0] = mute;
    }

    public static ArrayDeque<String> getPlayerDownImages() {
        return _playerDownImages;
    }

    static void setPlayerDownImages(ArrayDeque<String> playerDownImages) {
        _playerDownImages = playerDownImages;
        GlobalVariables.getPlayerDownImages().addLast("img/playerFront0.png");
        GlobalVariables.getPlayerDownImages().addLast("img/playerFront1.png");
        GlobalVariables.getPlayerDownImages().addLast("img/playerFront2.png");
    }

    public static ArrayDeque<String> getPlayerRightImages() {
        return _playerRightImages;
    }

    static void setPlayerRightImages(ArrayDeque<String> playerRightImages) {
        _playerRightImages = playerRightImages;
        GlobalVariables.getPlayerRightImages().addLast("img/playerRight0.png");
        GlobalVariables.getPlayerRightImages().addLast("img/playerRight1.png");
        GlobalVariables.getPlayerRightImages().addLast("img/playerRight2.png");
    }

    public static ArrayDeque<String> getPlayerLeftImages() {
        return _playerLeftImages;
    }

    static void setPlayerLeftImages(ArrayDeque<String> playerLeftImages) {
        _playerLeftImages = playerLeftImages;
        GlobalVariables.getPlayerLeftImages().addLast("img/playerLeft0.png");
        GlobalVariables.getPlayerLeftImages().addLast("img/playerLeft1.png");
        GlobalVariables.getPlayerLeftImages().addLast("img/playerLeft2.png");
    }

    public static ArrayDeque<String> getPlayerUpImages() {
        return _playerUpImages;
    }

    static void setPlayerUpImages(ArrayDeque<String> playerUpImages) {
        _playerUpImages = playerUpImages;
        GlobalVariables.getPlayerUpImages().addLast("img/playerBack0.png");
        GlobalVariables.getPlayerUpImages().addLast("img/playerBack1.png");
        GlobalVariables.getPlayerUpImages().addLast("img/playerBack2.png");
    }

    public static Canvas getCanvas() {
        return _canvas;
    }

    public static void setCanvas(Canvas canvas) {
        _canvas = canvas;
    }

    public static String getDirection() {
        return _direction;
    }

    public static void setDirection(String direction) {
        _direction = direction;
    }

    public static String getProjectPath() {
        return PROJECT_PATH;
    }

    public static GraphicsContext getGraphicContext () {
        return gc;
    }

    public static Group getRoot() {
        return root;
    }

    static void setRoot(Group root) {
        GlobalVariables.root = root;
    }

    public static ArrayList<Sprite> getMonstersToRender() {
        return monstersToRender;
    }

    static void setMonstersToRender(ArrayList<Sprite> monstersToRender) {
        GlobalVariables.monstersToRender = monstersToRender;
    }

    public static ArrayDeque<Sprite> getMonsterList() {
        return monsterList;
    }

    public static void setMonsterList(ArrayDeque<Sprite> monsterList) {
        GlobalVariables.monsterList = monsterList;
    }
}