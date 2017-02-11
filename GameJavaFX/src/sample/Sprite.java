package sample;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;

public class Sprite {

    private Image image;
    private double positionX;
    private double positionY;
    private double velocityX;
    private double velocityY;
    private double width;
    private double height;
    public ArrayList items = new ArrayList();

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
        Image i = new Image(filename);
        setImage(i);
    }

    public void setPosition(double x, double y) {
        positionX = x;
        positionY = y;
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

    public boolean collidesWith(Sprite s) {
        
        return s.getBoundary().intersects(this.getBoundary());
    }

    public String toString() {
        return " Position: [" + positionX + "," + positionY + "]"
                + " Velocity: [" + velocityX + "," + velocityY + "]";
    }

    public Rectangle2D bottomBoundary() {
        return new Rectangle2D(positionX + 2, positionY + height, width - 4, 0);
    }

    public Rectangle2D upperBoundary() {
        return new Rectangle2D(positionX + 2, positionY + height - 20, width - 4, 0);
    }

    public Rectangle2D leftBoundary() {
        return new Rectangle2D(positionX, positionY + height - 18, 0, 14);
    }

    public Rectangle2D rightBoundary() {
        return new Rectangle2D(positionX + width, positionY + height - 18, 0, 14);
    }

    public boolean hasItem() {

        return this.items.size() > 0;
    }

    public Node findNearestNode(ObservableList<Node> nodes) {

        double x = this.getBoundary().getMinX();
        double y = this.getBoundary().getMinX();

        Point2D pClick = new Point2D(x, y);
        Node nearestNode = null;
        double closestDistance = Double.POSITIVE_INFINITY;

        for (Node node : nodes) {
            Bounds bounds = node.getBoundsInParent();
            Point2D[] corners = new Point2D[]{
                new Point2D(bounds.getMinX(), bounds.getMinY()),
                new Point2D(bounds.getMaxX(), bounds.getMinY()),
                new Point2D(bounds.getMaxX(), bounds.getMaxY()),
                new Point2D(bounds.getMinX(), bounds.getMaxY()),};

            for (Point2D pCompare : corners) {
                double nextDist = pClick.distance(pCompare);
                if (nextDist < closestDistance) {
                    closestDistance = nextDist;
                    nearestNode = node;
                }
            }
        }

        return nearestNode;
    }
}
