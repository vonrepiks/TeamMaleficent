package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {

        // Create Image and ImageView objects
        Image parket = new Image("./img/parket.jpg");
        ImageView imageViewParket = new ImageView();
        imageViewParket.setImage(parket);
        imageViewParket.setFitHeight(210);
        imageViewParket.setFitWidth(280);

        Image plochki = new Image("./img/plochki.jpg");
        ImageView imageViewPlochki = new ImageView();
        imageViewPlochki.setImage(plochki);
        imageViewPlochki.setFitHeight(170);
        imageViewPlochki.setFitWidth(198);

        Image carpet = new Image("./img/carpet.jpg");
        ImageView imageViewCarpet = new ImageView();
        imageViewCarpet.setImage(carpet);
        imageViewCarpet.setFitHeight(170);
        imageViewCarpet.setFitWidth(380);

        Image moket = new Image("./img/moket1.jpg");
        ImageView imageViewMoket = new ImageView();
        imageViewMoket.setImage(moket);
        imageViewMoket.setFitHeight(210);
        imageViewMoket.setFitWidth(296);

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

        // Display image on screen
        Group root = new Group();
        root.getChildren().add(imageViewParket);
        root.getChildren().add(imageViewMoket);
        root.getChildren().add(imageViewChair);
        root.getChildren().add(imageViewStudentTable);
        root.getChildren().add(imageViewPlochki);
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

        primaryStage.setTitle("Game of Maleficent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
