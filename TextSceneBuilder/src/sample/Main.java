package sample;

import com.sun.javafx.font.directwrite.RECT;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayDeque;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Parent rootSceneBuilder = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene = new Scene(rootSceneBuilder);

        Rectangle borderUp1 = (Rectangle) scene.lookup("#borderUp1");
        Rectangle borderUp2 = (Rectangle) scene.lookup("#borderUp2");
        Rectangle borderRight = (Rectangle) scene.lookup("#borderRight");
        Rectangle borderDown = (Rectangle) scene.lookup("#borderDown");
        Rectangle borderLeft = (Rectangle) scene.lookup("#borderLeft");
        Rectangle borderInsideKitchenLiving = (Rectangle) scene.lookup("#borderInsideKitchenLiving");
        Rectangle borderInsideKitchenBedroom1 = (Rectangle) scene.lookup("#borderInsideKitchenBedroom1");
        Rectangle borderInsideKitchenBedroom2 = (Rectangle) scene.lookup("#borderInsideKitchenBedroom2");
        Rectangle borderInsideBedroomBathroomKitchenLiving = (Rectangle) scene.lookup("#borderInsideBedroomBathroomKitchenLiving");
        Rectangle borderInsideBedroomBathroom = (Rectangle) scene.lookup("#borderInsideBedroomBathroom");
        Rectangle borderInsideLivingBathroom = (Rectangle) scene.lookup("#borderInsideLivingBathroom");
        Rectangle wallKitchen1 = (Rectangle) scene.lookup("#wallKitchen1");
        Rectangle wallKitchen2 = (Rectangle) scene.lookup("#wallKitchen2");
        Rectangle wallBedroom = (Rectangle) scene.lookup("#wallBedroom");
        Rectangle wallLiving1 = (Rectangle) scene.lookup("#wallLiving1");
        Rectangle wallLiving2 = (Rectangle) scene.lookup("#wallLiving2");
        Rectangle wallBathroom1 = (Rectangle) scene.lookup("#wallBathroom1");
        Rectangle wallBathroom2 = (Rectangle) scene.lookup("#wallBathroom2");
        Rectangle wallKitchenBedroom = (Rectangle) scene.lookup("#wallKitchenBedroom");
        Rectangle thresholdEntrance = (Rectangle) scene.lookup("#thresholdEntrance");
        ImageView parquet1 = (ImageView) scene.lookup("#parquet1");
        ImageView parquet2 = (ImageView) scene.lookup("#parquet2");
        Rectangle thresholdBedroom = (Rectangle) scene.lookup("#thresholdBedroom");
        ImageView carpetBedroom1 = (ImageView) scene.lookup("#carpetBedroom1");
        ImageView carpetBedroom2 = (ImageView) scene.lookup("#carpetBedroom2");
        Rectangle thresholdLivingRoom = (Rectangle) scene.lookup("#thresholdLivingRoom");
        ImageView carpetLivingRoom1 = (ImageView) scene.lookup("#carpetLivingRoom1");
        ImageView carpetLivingRoom2 = (ImageView) scene.lookup("#carpetLivingRoom2");
        ImageView carpetLivingRoom3 = (ImageView) scene.lookup("#carpetLivingRoom3");
        ImageView carpetLivingRoom4 = (ImageView) scene.lookup("#carpetLivingRoom4");
        Rectangle thresholdBathroom = (Rectangle) scene.lookup("#thresholdBathroom");
        ImageView tiles1 = (ImageView) scene.lookup("#tiles1");
        ImageView tiles2 = (ImageView) scene.lookup("#tiles2");
        ImageView kitchenDresser = (ImageView) scene.lookup("#kitchenDresser");
        ImageView stove = (ImageView) scene.lookup("#stove");
        ImageView kitchenSink = (ImageView) scene.lookup("#kitchenSink");
        ImageView fridge = (ImageView) scene.lookup("#fridge");
        ImageView kitchenTable = (ImageView) scene.lookup("#kitchenTable");
        ImageView sofa = (ImageView) scene.lookup("#sofa");
        ImageView coffeeTable = (ImageView) scene.lookup("#coffeeTable");
        ImageView oldRadio = (ImageView) scene.lookup("#oldRadio");
        ImageView livingDresser = (ImageView) scene.lookup("#livingDresser");
        ImageView rubberPlant = (ImageView) scene.lookup("#rubberPlant");
        ImageView tv = (ImageView) scene.lookup("#tv");
        ImageView wardrobe = (ImageView) scene.lookup("#wardrobe");
        ImageView painting = (ImageView) scene.lookup("#painting");
        ImageView bed = (ImageView) scene.lookup("#bed");
        ImageView desk = (ImageView) scene.lookup("#desk");
        ImageView officeChair = (ImageView) scene.lookup("#officeChair");
        ImageView toilet = (ImageView) scene.lookup("#toilet");
        ImageView sink = (ImageView) scene.lookup("#sink");
        ImageView siphon = (ImageView) scene.lookup("#siphon");
        ImageView bathtub = (ImageView) scene.lookup("#bathtub");

        Image playerRight0 = new Image("img/playerRight0.png");
        Image playerRight1 = new Image("img/playerRight1.png");
        Image playerRight2 = new Image("img/playerRight2.png");
        ArrayDeque<Image> playerRightImages = new ArrayDeque<>();
        playerRightImages.addLast(playerRight0);
        playerRightImages.addLast(playerRight1);
        playerRightImages.addLast(playerRight2);
        ImageView imageViewPlayerRight = new ImageView();
        imageViewPlayerRight.setImage(playerRight0);
        imageViewPlayerRight.setFitHeight(80);
        imageViewPlayerRight.setFitWidth(30);

        Image playerLeft0 = new Image("img/playerLeft0.png");
        Image playerLeft1 = new Image("img/playerLeft1.png");
        Image playerLeft2 = new Image("img/playerLeft2.png");
        ArrayDeque<Image> playerLeftImages = new ArrayDeque<>();
        playerLeftImages.addLast(playerLeft0);
        playerLeftImages.addLast(playerLeft1);
        playerLeftImages.addLast(playerLeft2);
        ImageView imageViewPlayerLeft = new ImageView();
        imageViewPlayerLeft.setImage(playerLeft0);
        imageViewPlayerLeft.setFitHeight(80);
        imageViewPlayerLeft.setFitWidth(30);

        Image playerDown0 = new Image("img/playerFront0.png");
        Image playerDown1 = new Image("img/playerFront1.png");
        Image playerDown2 = new Image("img/playerFront2.png");
        ArrayDeque<Image> playerDownImages = new ArrayDeque<>();
        playerDownImages.addLast(playerDown0);
        playerDownImages.addLast(playerDown1);
        playerDownImages.addLast(playerDown2);
        ImageView imageViewPlayerDown = new ImageView();
        imageViewPlayerDown.setImage(playerDown0);
        imageViewPlayerDown.setFitHeight(80);
        imageViewPlayerDown.setFitWidth(30);

        Image playerUp0 = new Image("img/playerBack0.png");
        Image playerUp1 = new Image("img/playerBack1.png");
        Image playerUp2 = new Image("img/playerBack2.png");
        ArrayDeque<Image> playerUpImages = new ArrayDeque<>();
        playerUpImages.addLast(playerUp0);
        playerUpImages.addLast(playerUp1);
        playerUpImages.addLast(playerUp2);
        ImageView imageViewPlayerUp = new ImageView();
        imageViewPlayerUp.setImage(playerUp0);
        imageViewPlayerUp.setFitHeight(80);
        imageViewPlayerUp.setFitWidth(30);

        root.getChildren().addAll( borderUp1, borderUp2, borderDown, borderLeft, borderRight, borderInsideKitchenBedroom1, parquet2, borderInsideKitchenLiving, carpetBedroom2, officeChair, desk, borderInsideBedroomBathroomKitchenLiving, borderInsideBedroomBathroom, borderInsideLivingBathroom, borderInsideKitchenBedroom2, wallKitchen1, wallKitchen2, wallBedroom, wallLiving1, wallLiving2, wallBathroom1, wallBathroom2, wallKitchenBedroom, parquet1, kitchenDresser, stove, kitchenSink, fridge, kitchenTable, carpetLivingRoom1, carpetLivingRoom2, carpetLivingRoom3, carpetLivingRoom4, sofa, coffeeTable, rubberPlant, oldRadio, livingDresser, tv, carpetBedroom1, wardrobe, painting, bed, tiles1, tiles2, toilet, sink, siphon, bathtub, thresholdBathroom, thresholdBedroom, thresholdEntrance, thresholdLivingRoom, imageViewPlayerDown);

        root.getChildren().get(53).setLayoutX(180);
        root.getChildren().get(53).setLayoutY(0);

        Rectangle borderInsideKitchenBedroom1Intersect = new Rectangle(borderInsideKitchenBedroom1.getLayoutX(), borderInsideKitchenBedroom1.getLayoutY(), borderInsideKitchenBedroom1.getWidth(), borderInsideKitchenBedroom1.getHeight());
        Rectangle borderInsideKitchenLivingIntersect = new Rectangle(borderInsideKitchenLiving.getLayoutX(), borderInsideKitchenLiving.getLayoutY(), borderInsideKitchenLiving.getWidth(), borderInsideKitchenLiving.getHeight());
        Rectangle borderInsideBedroomBathroomKitchenLivingIntersect = new Rectangle(borderInsideBedroomBathroomKitchenLiving.getLayoutX(), borderInsideBedroomBathroomKitchenLiving.getLayoutY(), borderInsideBedroomBathroomKitchenLiving.getWidth(), borderInsideBedroomBathroomKitchenLiving.getHeight());
        Rectangle borderInsideBedroomBathroomIntersect = new Rectangle(borderInsideBedroomBathroom.getLayoutX(), borderInsideBedroomBathroom.getLayoutY(), borderInsideBedroomBathroom.getWidth(), borderInsideBedroomBathroom.getHeight());
        Rectangle borderInsideLivingBathroomIntersect = new Rectangle(borderInsideLivingBathroom.getLayoutX(), borderInsideLivingBathroom.getLayoutY(), borderInsideLivingBathroom.getWidth(), borderInsideLivingBathroom.getHeight());
        Rectangle borderInsideKitchenBedroom2Intersect = new Rectangle(borderInsideKitchenBedroom2.getLayoutX(), borderInsideKitchenBedroom2.getLayoutY(), borderInsideKitchenBedroom2.getWidth(), borderInsideKitchenBedroom2.getHeight());

        Rectangle[] obstacles = {
                borderInsideKitchenBedroom1Intersect, borderInsideKitchenLivingIntersect, borderInsideBedroomBathroomKitchenLivingIntersect, borderInsideBedroomBathroomIntersect, borderInsideLivingBathroomIntersect, borderInsideKitchenBedroom2Intersect
        };

        //borderUp1, borderUp2, borderDown, borderLeft, borderRight,

        primaryStage.setTitle("Maleficent");
        Scene scene1 = new Scene(root, 523, 500);
        primaryStage.setScene(scene1);
        primaryStage.show();

        final boolean[] intersection = {false};
        final int[] counter = {0};

        scene1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                if(counter[0] % 6 == 0) {
                    Image tempImage = playerRightImages.pop();
                    playerRightImages.addLast(tempImage);
                    imageViewPlayerRight.setImage(tempImage);
                }
                intersection[0] = intersect(obstacles, root, KeyCode.RIGHT);
                counter[0]++;
                if(root.getChildren().get(53).getLayoutX() < scene1.getWidth() - borderRight.getWidth() - playerRight0.getWidth() && !intersection[0]) {
                    double x = root.getChildren().get(53).getLayoutX();
                    double y = root.getChildren().get(53).getLayoutY();
                    root.getChildren().set(53,imageViewPlayerRight);
                    root.getChildren().get(53).setLayoutX(x + 2.5);
                    root.getChildren().get(53).setLayoutY(y);
                } else {
                    intersection[0] = false;
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                if(counter[0] % 6 == 0) {
                    Image tempImage = playerLeftImages.pop();
                    playerLeftImages.addLast(tempImage);
                    imageViewPlayerLeft.setImage(tempImage);
                }
                intersection[0] = intersect(obstacles, root, KeyCode.LEFT);
                counter[0]++;
                if(root.getChildren().get(53).getLayoutX() > borderLeft.getWidth() && !intersection[0]) {
                    double x = root.getChildren().get(53).getLayoutX();
                    double y = root.getChildren().get(53).getLayoutY();
                    root.getChildren().set(53,imageViewPlayerLeft);
                    root.getChildren().get(53).setLayoutX(x - 2.5);
                    root.getChildren().get(53).setLayoutY(y);
                } else {
                    intersection[0] = false;
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                if(counter[0] % 6 == 0) {
                    Image tempImage = playerDownImages.pop();
                    playerDownImages.addLast(tempImage);
                    imageViewPlayerDown.setImage(tempImage);
                }
                intersection[0] = intersect(obstacles, root, KeyCode.DOWN);
                counter[0]++;
                if(root.getChildren().get(53).getLayoutY() < scene1.getHeight() - playerDown0.getHeight() && !intersection[0]) {
                    double x = root.getChildren().get(53).getLayoutX();
                    double y = root.getChildren().get(53).getLayoutY();
                    root.getChildren().set(53,imageViewPlayerDown);
                    root.getChildren().get(53).setLayoutY(y + 2.5);
                    root.getChildren().get(53).setLayoutX(x);
                } else {
                    intersection[0] = false;
                }
            } else if (event.getCode() == KeyCode.UP) {
                if(counter[0] % 6 == 0) {
                    Image tempImage = playerUpImages.pop();
                    playerUpImages.addLast(tempImage);
                    imageViewPlayerUp.setImage(tempImage);
                }
                intersection[0] = intersect(obstacles, root, KeyCode.UP);
                counter[0]++;
                if(root.getChildren().get(53).getLayoutY() > borderUp1.getLayoutY() && !intersection[0]) {
                    double x = root.getChildren().get(53).getLayoutX();
                    double y = root.getChildren().get(53).getLayoutY();
                    root.getChildren().set(53,imageViewPlayerUp);
                    root.getChildren().get(53).setLayoutY(y - 2.5);
                    root.getChildren().get(53).setLayoutX(x);
                } else {
                    intersection[0] = false;
                }
            }
        });
    }

    private boolean intersect(Rectangle[] obstacles, Group root, KeyCode key) {
        for (Rectangle obstacle : obstacles) {

            if(obstacle.intersects(root.getChildren().get(53).getLayoutX() + 2.5,
                    root.getChildren().get(53).getLayoutY(),30,80) && key.equals(KeyCode.RIGHT)) {
                return !( obstacle.getY() == 2 || obstacle.getY() == 18 || obstacle.getY() == 259);
            }
            if(obstacle.intersects(root.getChildren().get(53).getLayoutX() - 2.5,
                    root.getChildren().get(53).getLayoutY(),30,80) && key.equals(KeyCode.LEFT)) {
                return !( obstacle.getY() == 2 || obstacle.getY() == 18 || obstacle.getY() == 259);
            }
            if(obstacle.intersects(root.getChildren().get(53).getLayoutX(),
                    root.getChildren().get(53).getLayoutY() + 2.5,30,80) && key.equals(KeyCode.DOWN)) {
                return !(obstacle.getY() == 2 || obstacle.getY() == 18 || obstacle.getY() == 259);
            }
            if(obstacle.intersects(root.getChildren().get(53).getLayoutX(),
                    root.getChildren().get(53).getLayoutY() - 2.5,30,80) && key.equals(KeyCode.UP)) {
                return !( obstacle.getY() == 2 || obstacle.getY() == 18 || obstacle.getY() == 259);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
