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

import java.util.LinkedList;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create Image and ImageView objects
        Image parquet = new Image("img/parquete.jpg");
        ImageView imageViewParquet = new ImageView();
        imageViewParquet.setImage(parquet);
        imageViewParquet.setFitHeight(210);
        imageViewParquet.setFitWidth(280);

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
        imageViewCarpet2.setFitWidth(296);

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

        Image playerRight = new Image("img/rightPlayer01.png");
        ImageView imageViewPlayerRight = new ImageView();
        imageViewPlayerRight.setImage(playerRight);

        Image playerLeft = new Image("img/leftPlayer01.png");
        ImageView imageViewPlayerLeft = new ImageView();
        imageViewPlayerLeft.setImage(playerLeft);

        Image playerDown = new Image("img/downPlayer01.png");
        ImageView imageViewPlayerDown = new ImageView();
        imageViewPlayerDown.setImage(playerDown);


        Image playerUp = new Image("img/upPlayer01.png");
        ImageView imageViewPlayerUp = new ImageView();
        imageViewPlayerUp.setImage(playerUp);



        // Display image on screen
        Group root = new Group();
        root.getChildren().add(imageViewParquet);
        root.getChildren().add(imageViewCarpet2);
        root.getChildren().add(imageViewChair);
        root.getChildren().add(imageViewStudentTable);
        root.getChildren().add(imageViewTiles);
        root.getChildren().add(imageViewCarpet);
        root.getChildren().get(0).setLayoutX(22);
        root.getChildren().get(0).setLayoutY(62);
        root.getChildren().get(1).setLayoutX(322);
        root.getChildren().get(1).setLayoutY(62);
        root.getChildren().get(2).setLayoutX(382);
        root.getChildren().get(2).setLayoutY(172);
        root.getChildren().get(3).setLayoutX(330);
        root.getChildren().get(3).setLayoutY(160);
        root.getChildren().get(4).setLayoutX(422);
        root.getChildren().get(4).setLayoutY(292);
        root.getChildren().get(5).setLayoutX(22);
        root.getChildren().get(5).setLayoutY(292);

        Scene scene = new Scene(root, 640, 480, Color.WHITESMOKE);

        Rectangle rUp = new Rectangle(2, 2, 100, 20);
        Rectangle rUp1 = new Rectangle(162, 2, 476, 20);
        Rectangle rDown = new Rectangle(2, 458, 636, 20);
        Rectangle rLeft = new Rectangle(2, 22, 20, 436);
        Rectangle rRight = new Rectangle(618, 22, 20, 436);
        Rectangle wall = new Rectangle(302, 22, 20, 100);
        Rectangle wall2 = new Rectangle(2, 232, 100, 20);
        Rectangle wall3 = new Rectangle(162, 232, 100, 20);
        Rectangle wall4 = new Rectangle(262, 232, 240, 20);
        Rectangle wall5 = new Rectangle(562, 232, 56, 20);
        Rectangle wall6 = new Rectangle(402, 232, 20, 226);
        Rectangle wall7 = new Rectangle(302, 200, 20, 52);

        Rectangle wallHeight1 = new Rectangle(22, 22, 80, 40);
        Rectangle wallHeight2 = new Rectangle(162, 22, 140, 40);
        Rectangle wallHeight3 = new Rectangle(322, 22, 296, 40);
        Rectangle wallHeight4 = new Rectangle(22, 252, 80, 40);
        Rectangle wallHeight5 = new Rectangle(162, 252, 240, 40);
        Rectangle wallHeight6 = new Rectangle(422, 252, 80, 40);
        Rectangle wallHeight7 = new Rectangle(562, 252, 56, 40);
        Rectangle wallHeight8 = new Rectangle(302, 122, 20, 60);

        Rectangle threshold1 = new Rectangle(102, 42, 60, 20);
        Rectangle threshold2 = new Rectangle(102, 272, 60, 20);
        Rectangle threshold3 = new Rectangle(502, 272, 60, 20);
        Rectangle threshold4 = new Rectangle(302, 180, 20, 20);

        Rectangle[] obstacles = {
                rUp , rUp1 ,rDown, rLeft, rRight, wall, wall2, wall3, wall4, wall5, wall6, wall7, wallHeight1,
                wallHeight2, wallHeight3, wallHeight4, wallHeight5, wallHeight6, wallHeight7, wallHeight8
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
        wall.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall);
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
        wall7.setFill(Color.ROSYBROWN);
        root.getChildren().add(wall7);

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
        wallHeight8.setFill(Color.WHITE);
        root.getChildren().add(wallHeight8);

        threshold1.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold1);
        threshold2.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold2);
        threshold3.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold3);
        threshold4.setFill(Color.DARKSALMON);
        root.getChildren().add(threshold4);

        root.getChildren().add(imageViewSofa);
        root.getChildren().get(30).setLayoutX(280);
        root.getChildren().get(30).setLayoutY(242);

        root.getChildren().add(imageViewToilet);
        root.getChildren().get(31).setLayoutX(430);
        root.getChildren().get(31).setLayoutY(262);

        root.getChildren().add(imageViewBed);
        root.getChildren().get(32).setLayoutX(500);
        root.getChildren().get(32).setLayoutY(25);

        root.getChildren().add(imageViewPainting);
        root.getChildren().get(33).setLayoutX(410);
        root.getChildren().get(33).setLayoutY(24);

        root.getChildren().add(imageViewWardrobe);
        root.getChildren().get(34).setLayoutX(330);
        root.getChildren().get(34).setLayoutY(26);

        root.getChildren().add(imageViewSink);
        root.getChildren().get(35).setLayoutX(558);
        root.getChildren().get(35).setLayoutY(252);

        root.getChildren().add(imageViewBathtub);
        root.getChildren().get(36).setLayoutX(450);
        root.getChildren().get(36).setLayoutY(400);

        root.getChildren().add(imageViewSiphon);
        root.getChildren().get(37).setLayoutX(510);
        root.getChildren().get(37).setLayoutY(345);

        root.getChildren().add(imageViewPlayerDown);
        root.getChildren().get(38).setLayoutX(115);
        root.getChildren().get(38).setLayoutY(5);

        primaryStage.setTitle("Game of Maleficent");
        primaryStage.setScene(scene);
        primaryStage.show();

        final boolean[] right = {true};
        final boolean[] left = {true};
        final boolean[] down = {true};
        final boolean[] up = {true};
        final boolean[] intersection = {false};

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                intersection[0] = intersect(obstacles, root, KeyCode.RIGHT);
                if(root.getChildren().get(38).getLayoutX() < 585 && right[0] && !intersection[0]) {
                    left[0] = true;
                    up[0] = true;
                    down[0] = true;
                    double x = root.getChildren().get(38).getLayoutX();
                    double y = root.getChildren().get(38).getLayoutY();
                    root.getChildren().set(38,imageViewPlayerRight);
                    root.getChildren().get(38).setLayoutX(x + 3);
                    root.getChildren().get(38).setLayoutY(y);
                } else {
                    root.getChildren().get(38).setLayoutX(root.getChildren().get(38).getLayoutX() - 0.5);
                    intersection[0] = false;
                    right[0] = false;
                }
            } else if (event.getCode() == KeyCode.LEFT) {
                intersection[0] = intersect(obstacles, root, KeyCode.LEFT);
                if(root.getChildren().get(38).getLayoutX() > 20 && left[0] && !intersection[0]) {
                    right[0] = true;
                    up[0] = true;
                    down[0] = true;
                    double x = root.getChildren().get(38).getLayoutX();
                    double y = root.getChildren().get(38).getLayoutY();
                    root.getChildren().set(38,imageViewPlayerLeft);
                    root.getChildren().get(38).setLayoutX(x - 3);
                    root.getChildren().get(38).setLayoutY(y);
                } else {
                    root.getChildren().get(38).setLayoutX(root.getChildren().get(38).getLayoutX() + 0.5);
                    intersection[0] = false;
                    left[0] = false;
                }
            } else if (event.getCode() == KeyCode.DOWN) {
                intersection[0] = intersect(obstacles, root, KeyCode.DOWN);
                if(root.getChildren().get(38).getLayoutY() < 400 && down[0] && !intersection[0]) {
                    left[0] = true;
                    up[0] = true;
                    right[0] = true;
                    double x = root.getChildren().get(38).getLayoutX();
                    double y = root.getChildren().get(38).getLayoutY();
                    root.getChildren().set(38,imageViewPlayerDown);
                    root.getChildren().get(38).setLayoutY(y + 3);
                    root.getChildren().get(38).setLayoutX(x);

                } else {
                    root.getChildren().get(38).setLayoutY(root.getChildren().get(38).getLayoutY() - 0.5);
                    intersection[0] = false;
                    down[0] = false;
                }
            } else if (event.getCode() == KeyCode.UP) {
                intersection[0] = intersect(obstacles, root, KeyCode.UP);
                if(root.getChildren().get(38).getLayoutY() > 10  && up[0] && !intersection[0]) {
                    left[0] = true;
                    right[0] = true;
                    down[0] = true;
                    double x = root.getChildren().get(38).getLayoutX();
                    double y = root.getChildren().get(38).getLayoutY();
                    root.getChildren().set(38,imageViewPlayerUp);
                    root.getChildren().get(38).setLayoutY(y - 3);
                    root.getChildren().get(38).setLayoutX(x);
                } else {
                    root.getChildren().get(38).setLayoutY(root.getChildren().get(38).getLayoutY() + 0.5);
                    intersection[0] = false;
                    up[0] = false;
                }
            }
        });
    }

    private boolean intersect(Rectangle[] obstacles, Group root, KeyCode key) {
        for (Rectangle obstacle : obstacles) {
            if((obstacle.getX() == 302 || obstacle.getX() == 22 || obstacle.getX() == 2) && (obstacle.getY() == 22 || obstacle.getY() == 122 ||
                    obstacle.getY() == 252 || obstacle.getY() == 200 || obstacle.getY() == 232) && key.equals(KeyCode.LEFT)) {
                if(obstacle.intersects(root.getChildren().get(38).getLayoutX(),
                        root.getChildren().get(38).getLayoutY() + 50,2,8)) {
                    return true;
                }
            }
            if(obstacle.getX() == 402 && obstacle.getY() == 232 && key.equals(KeyCode.LEFT)) {
                if(obstacle.intersects(root.getChildren().get(38).getLayoutX(),
                        root.getChildren().get(38).getLayoutY() + 50,2,8)) {
                    return true;
                }
            }
            if(obstacle.intersects(root.getChildren().get(38).getLayoutX() + 25,
                    root.getChildren().get(38).getLayoutY() + 50,2,8)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
