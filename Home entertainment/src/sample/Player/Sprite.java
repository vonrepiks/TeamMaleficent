package sample.Player;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    public boolean hasAlreadyHit = false;

    public Sprite() {
        positionX = 0;
        positionY = 0;
        velocityX = 0;
        velocityY = 0;
    }

    public void setImage(Image i) {
        image = i;
        width = i.getWidth();
        height = i.getHeight();
    }

    public void setImage(String filename) {
        Image i = new Image(filename, 45, 120, false, false);
        setImage(i);
    }

    public void setSprayImage(String filename) {
        Image i = new Image(filename, 70, 120, false, false);
        setImage(i);
    }

    public Rectangle2D sprayBoundary() {
        return new Rectangle2D(positionX, positionY, width+50, height+50);
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
    }

    public double getX(){
        return positionX;
    }

    public double getY(){
        return positionY;
    }

    public double getWidth(){
        return width;
    }

    public double getHeight(){
        return height;
    }

    public void setVelocity(double x, double y) {
        velocityX = x;
        velocityY = y;
    }

    public void addVelocity(double x, double y) {
        velocityX += x;
        velocityY += y;
    }

    public void update(double time) {
        positionX += velocityX * time;
        positionY += velocityY * time;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(image, positionX, positionY);
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(positionX, positionY, width, height);
    }

    public boolean intersects(Sprite s) {
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }
    public Rectangle2D bottomBoundary(){
        return new Rectangle2D(positionX+2, positionY+height,width-4,0);
    }

    public Rectangle2D upperBoundary(){
        return new Rectangle2D(positionX+2,positionY+height-20,width-4,0);
    }

    public Rectangle2D leftBoundary(){
        return new Rectangle2D(positionX,positionY+height-18,0,14);
    }

    public Rectangle2D rightBoundary(){
        return new Rectangle2D(positionX+width,positionY+height-18,0,14);
    }

}