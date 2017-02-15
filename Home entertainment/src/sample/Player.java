package sample;

public class Player extends Sprite{
    private double health;

    public Player(){
        health =100;
    }

    public double getPlayerHealth(){
        return health;
    }

    public void subtractPlayerHealth(){
        this.health -= 0.05;
    }
}
