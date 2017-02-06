package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayDeque;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create Image and ImageView objects
        Image parquet = new Image("img/parquete.jpg");
        ImageView imageViewParquet = new ImageView();
        imageViewParquet.setImage(parquet);
        imageViewParquet.setFitHeight(210);
        imageViewParquet.setFitWidth(290);

        Image tiles = new Image("img/tiles.jpg");
        ImageView imageViewTiles = new ImageView();
        imageViewTiles.setImage(tiles);
        imageViewTiles.setFitHeight(170);
        imageViewTiles.setFitWidth(198);

        Image carpet = new Image("./img/carpet.jpg");
        ImageView imageViewCarpet = new ImageView();
        imageViewCarpet.setImage(carpet);
        imageViewCarpet.setFitHeight(170);
        imageViewCarpet.setFitWidth(380);

        Image carpet2 = new Image("img/carpet03.jpg");
        ImageView imageViewCarpet2 = new ImageView();
        imageViewCarpet2.setImage(carpet2);
        imageViewCarpet2.setFitHeight(210);
        imageViewCarpet2.setFitWidth(306);

        Image sofa = new Image("./img/sofa.png");
        ImageView imageViewSofa = new ImageView();
        imageViewSofa.setImage(sofa);
        imageViewSofa.setFitHeight(80);
        imageViewSofa.setFitWidth(120);

        Image toilet = new Image("./img/toilet.png");
        ImageView imageViewToilet = new ImageView();
        imageViewToilet.setImage(toilet);
        imageViewToilet.setFitHeight(50);
        imageViewToilet.setFitWidth(50);

        Image bed = new Image("./img/bed_burned.png");
        ImageView imageViewBed = new ImageView();
        imageViewBed.setImage(bed);
        imageViewBed.setFitHeight(120);
        imageViewBed.setFitWidth(120);

        Image painting = new Image("./img/painting.jpg");
        ImageView imageViewPainting = new ImageView();
        imageViewPainting.setImage(painting);
        imageViewPainting.setFitHeight(36);
        imageViewPainting.setFitWidth(80);

        Image wardrobe = new Image("./img/wardrobe_burned1.png");
        ImageView imageViewWardrobe = new ImageView();
        imageViewWardrobe.setImage(wardrobe);
        imageViewWardrobe.setFitHeight(80);
        imageViewWardrobe.setFitWidth(60);

        Image sink = new Image("./img/sink_burned.png");
        ImageView imageViewSink = new ImageView();
        imageViewSink.setImage(sink);
        imageViewSink.setFitHeight(65);
        imageViewSink.setFitWidth(55);

        Image bathtub = new Image("./img/bathtub_burned.png");
        ImageView imageViewBathtub = new ImageView();
        imageViewBathtub.setImage(bathtub);
        imageViewBathtub.setFitHeight(50);
        imageViewBathtub.setFitWidth(150);

        Image studentTable = new Image("./img/studentTable_burned.png");
        ImageView imageViewStudentTable = new ImageView();
        imageViewStudentTable.setImage(studentTable);
        imageViewStudentTable.setFitHeight(180);
        imageViewStudentTable.setFitWidth(160);

        Image chair = new Image("./img/chair_burned.png");
        ImageView imageViewChair = new ImageView();
        imageViewChair.setImage(chair);
        imageViewChair.setFitHeight(120);
        imageViewChair.setFitWidth(80);

        Image siphon = new Image("./img/siphon_burned.png");
        ImageView imageViewSiphon = new ImageView();
        imageViewSiphon.setImage(siphon);
        imageViewSiphon.setFitHeight(25);
        imageViewSiphon.setFitWidth(25);

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

        // Display image on screen
        Group root = new Group();
        root.getChildren().add(imageViewParquet);
        root.getChildren().get(0).setLayoutX(22);
        root.getChildren().get(0).setLayoutY(62);

        root.getChildren().add(imageViewCarpet2);
        root.getChildren().get(1).setLayoutX(312);
        root.getChildren().get(1).setLayoutY(62);

        root.getChildren().add(imageViewChair);
        root.getChildren().get(2).setLayoutX(382);
        root.getChildren().get(2).setLayoutY(172);

        root.getChildren().add(imageViewStudentTable);
        root.getChildren().get(3).setLayoutX(330);
        root.getChildren().get(3).setLayoutY(160);

        root.getChildren().add(imageViewTiles);
        root.getChildren().get(4).setLayoutX(422);
        root.getChildren().get(4).setLayoutY(292);

        root.getChildren().add(imageViewCarpet);
        root.getChildren().get(5).setLayoutX(22);
        root.getChildren().get(5).setLayoutY(292);

        Scene scene = new Scene(root, 640, 480, Color.WHITESMOKE);

        Rectangle rUp = new Rectangle(2, 2, 100, 20);
        Rectangle rUp1 = new Rectangle(162, 2, 476, 20);
        Rectangle rDown = new Rectangle(2, 458, 636, 20);
        Rectangle rLeft = new Rectangle(2, 22, 20, 436);
        Rectangle rRight = new Rectangle(618, 22, 20, 436);
        Rectangle wall2 = new Rectangle(2, 232, 100, 20);
        Rectangle wall3 = new Rectangle(162, 232, 100, 20);
        Rectangle wall4 = new Rectangle(262, 232, 240, 20);
        Rectangle wall5 = new Rectangle(562, 232, 56, 20);
        Rectangle wall6 = new Rectangle(402, 232, 20, 226);

        Rectangle wallHeight1 = new Rectangle(22, 22, 80, 40);
        Rectangle wallHeight2 = new Rectangle(162, 22, 160, 40);
        Rectangle wallHeight3 = new Rectangle(322, 22, 296, 40);
        Rectangle wallHeight4 = new Rectangle(22, 252, 80, 40);
        Rectangle wallHeight5 = new Rectangle(162, 252, 240, 40);
        Rectangle wallHeight6 = new Rectangle(422, 252, 80, 40);
        Rectangle wallHeight7 = new Rectangle(562, 252, 56, 40);

        Rectangle threshold1 = new Rectangle(102, 42, 60, 20);
        Rectangle threshold2 = new Rectangle(102, 272, 60, 20);
        Rectangle threshold3 = new Rectangle(502, 272, 60, 20);

        Rectangle[] obstacles = {
                rUp , rUp1 ,rDown, rLeft, rRight, wall2, wall3, wall4, wall5, wall6, wallHeight1,
                wallHeight2, wallHeight3, wallHeight4, wallHeight5, wallHeight6, wallHeight7
        };

        rUp.setFill(Color.ROSYBROWN);
        root.getChildren().add(rUp);
        rUp1.setFill(Color.ROSYBROWN);
        root.getChildren().add(rUp1);
        rDown.setFill(Color.ROSYBROWN);
        root.getChildren().add(rDown);
        rLeft.setFill(Color.ROSYBROWN);
        root.getChildren().add(rLeft);
        rRight.setFill(Color.ROSYBROWN);
        root.getChildren().add(rRight);
        wall4.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall4);
        wall2.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall2);
        wall3.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall3);
        wall5.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall5);
        wall6.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall6);

        wallHeight1.setFill(Color.WHITE);
        root.getChildren().add(wallHeight1);
        wallHeight2.setFill(Color.WHITE);
        root.getChildren().add(wallHeight2);
        wallHeight3.setFill(Color.WHITE);
        root.getChildren().add(wallHeight3);
        wallHeight4.setFill(Color.WHITE);
        root.getChildren().add(wallHeight4);
        wallHeight5.setFill(Color.WHITE);
        root.getChildren().add(wallHeight5);
        wallHeight6.setFill(Color.WHITE);
        root.getChildren().add(wallHeight6);
        wallHeight7.setFill(Color.WHITE);
        root.getChildren().add(wallHeight7);

        threshold1.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold1);
        threshold2.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold2);
        threshold3.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold3);

        root.getChildren().add(imageViewSofa);
        root.getChildren().get(26).setLayoutX(280);
        root.getChildren().get(26).setLayoutY(242);

        root.getChildren().add(imageViewToilet);
        root.getChildren().get(27).setLayoutX(430);
        root.getChildren().get(27).setLayoutY(262);

        root.getChildren().add(imageViewBed);
        root.getChildren().get(28).setLayoutX(500);
        root.getChildren().get(28).setLayoutY(25);

        root.getChildren().add(imageViewPainting);
        root.getChildren().get(29).setLayoutX(410);
        root.getChildren().get(29).setLayoutY(24);

        root.getChildren().add(imageViewWardrobe);
        root.getChildren().get(30).setLayoutX(330);
        root.getChildren().get(30).setLayoutY(26);

        root.getChildren().add(imageViewSink);
        root.getChildren().get(31).setLayoutX(558);
        root.getChildren().get(31).setLayoutY(252);

        root.getChildren().add(imageViewBathtub);
        root.getChildren().get(32).setLayoutX(450);
        root.getChildren().get(32).setLayoutY(400);

        root.getChildren().add(imageViewSiphon);
        root.getChildren().get(33).setLayoutX(510);
        root.getChildren().get(33).setLayoutY(345);

        root.getChildren().add(imageViewPlayerDown);
        root.getChildren().get(34).setLayoutX(115);
        root.getChildren().get(34).setLayoutY(5);

        primaryStage.setTitle("Game of Maleficent");
        primaryStage.setScene(scene);
        primaryStage.show();

        final boolean[] intersection = {false};
        final int[] counter = {0};

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                if(counter[0] % 6 == 0) {
                    Image tempImage = playerRightImages.pop();
                    playerRightImages.addLast(tempImage);
                    imageViewPlayerRight.setImage(tempImage);
                }
                intersection[0] = intersect(obstacles, root, KeyCode.RIGHT);
                counter[0]++;
                if(root.getChildren().get(34).getLayoutX() < 585 && !intersection[0]) {
                    double x = root.getChildren().get(34).getLayoutX();
                    double y = root.getChildren().get(34).getLayoutY();
                    root.getChildren().set(34,imageViewPlayerRight);
                    root.getChildren().get(34).setLayoutX(x + 2.5);
                    root.getChildren().get(34).setLayoutY(y);
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
                if(root.getChildren().get(34).getLayoutX() > 20  && !intersection[0]) {
                    double x = root.getChildren().get(34).getLayoutX();
                    double y = root.getChildren().get(34).getLayoutY();
                    root.getChildren().set(34,imageViewPlayerLeft);
                    root.getChildren().get(34).setLayoutX(x - 2.5);
                    root.getChildren().get(34).setLayoutY(y);
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
                if(root.getChildren().get(34).getLayoutY() < 400 && !intersection[0]) {
                    double x = root.getChildren().get(34).getLayoutX();
                    double y = root.getChildren().get(34).getLayoutY();
                    root.getChildren().set(34,imageViewPlayerDown);
                    root.getChildren().get(34).setLayoutY(y + 2.5);
                    root.getChildren().get(34).setLayoutX(x);
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
                if(root.getChildren().get(34).getLayoutY() > 10 && !intersection[0]) {
                    double x = root.getChildren().get(34).getLayoutX();
                    double y = root.getChildren().get(34).getLayoutY();
                    root.getChildren().set(34,imageViewPlayerUp);
                    root.getChildren().get(34).setLayoutY(y - 2.5);
                    root.getChildren().get(34).setLayoutX(x);
                } else {
                    intersection[0] = false;
                }
            }
        });
    }

    private boolean intersect(Rectangle[] obstacles, Group root, KeyCode key) {
        for (Rectangle obstacle : obstacles) {

            if(obstacle.intersects(root.getChildren().get(34).getLayoutX() + 2.5,
                    root.getChildren().get(34).getLayoutY(),30,80) && key.equals(KeyCode.RIGHT)) {
                return !(  obstacle.getY() == 2 || obstacle.getY() == 22 || obstacle.getY() == 252);
            }
            if(obstacle.intersects(root.getChildren().get(34).getLayoutX() - 2.5,
                    root.getChildren().get(34).getLayoutY(),30,80) && key.equals(KeyCode.LEFT)) {
                return !( obstacle.getY() == 2 || obstacle.getY() == 22 || obstacle.getY() == 252);
            }
            if(obstacle.intersects(root.getChildren().get(34).getLayoutX(),
                    root.getChildren().get(34).getLayoutY() + 2.5,30,80) && key.equals(KeyCode.DOWN)) {
                return !( obstacle.getY() == 2 || obstacle.getY() == 22 || obstacle.getY() == 252);
            }
            if(obstacle.intersects(root.getChildren().get(34).getLayoutX(),
                    root.getChildren().get(34).getLayoutY() - 2.5,30,80) && key.equals(KeyCode.UP)) {
                return !( obstacle.getY() == 2 || obstacle.getY() == 22 || obstacle.getY() == 252);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
