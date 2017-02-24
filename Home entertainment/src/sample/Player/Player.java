package sample.Player;

import sample.Achievments.Achievement;

import java.util.ArrayList;

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

}
