package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.media.AudioClip;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class GlobalVariables {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final boolean[] _mute = {false};

    private static Player _player;
    private static ArrayList<String> _input;
    private static AudioClip _walking, _running, _wallHit;
    private static AtomicInteger _stepCounter;
    private static ArrayDeque<String> _playerDownImages, _playerRightImages, _playerLeftImages, _playerUpImages;
    private static Canvas _canvas = new Canvas(1024, 768);
    private static String _direction;

    public static Player getPlayer() {
        return _player;
    }

    public static void setPlayer(Player player) {
        _player = player;
    }

    public static ArrayList<String> getInput() {
        return _input;
    }

    public static void setInput(ArrayList<String> input) {
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

    public static void setPlayerDownImages(ArrayDeque<String> playerDownImages) {
        _playerDownImages = playerDownImages;
    }

    public static ArrayDeque<String> getPlayerRightImages() {
        return _playerRightImages;
    }

    public static void setPlayerRightImages(ArrayDeque<String> playerRightImages) {
        _playerRightImages = playerRightImages;
    }

    public static ArrayDeque<String> getPlayerLeftImages() {
        return _playerLeftImages;
    }

    public static void setPlayerLeftImages(ArrayDeque<String> playerLeftImages) {
        _playerLeftImages = playerLeftImages;
    }

    public static ArrayDeque<String> getPlayerUpImages() {
        return _playerUpImages;
    }

    public static void setPlayerUpImages(ArrayDeque<String> playerUpImages) {
        _playerUpImages = playerUpImages;
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
}
