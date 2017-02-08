package sample;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage theStage)
    {
        theStage.setTitle( "Team Maleficent" );

        Group root = new Group();

        Scene theScene = new Scene(root, 640, 480, Color.WHITESMOKE);
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 640, 480 );
        root.getChildren().add( canvas );

        // Create Image and ImageView objects
        Image parquet = new Image("img/parquete.jpg");
        Image tiles = new Image("img/tiles.jpg");
        Image carpet = new Image("img/carpet.png");
        Image carpet2 = new Image("img/parquete.jpg");
        Image bed = new Image("img/bed_burned.png");
        Image painting = new Image("img/painting.jpg");
        Image wardrobe = new Image("img/wardrobe_burned1.png");
        Image studentTable = new Image("img/studentTable_burned.png");
        Image chair = new Image("img/chair_burned.png");
        Image siphon = new Image("img/siphon_burned.png");
        Image brickVertical = new Image("img/brickVertical.png");
        Image brickHorizontal = new Image("img/brickHorizontal.png");
        Image brickShort = new Image("img/brickShort.png");
        Image brickShortVert = new Image("img/brickShortVert.png");
        Image brickSingleVert = new Image("img/brickSingleVert.png");
        Image wallShort = new Image("img/wallShort.png");
        Image wall = new Image("img/wall.png");
        Image wallColon = new Image("img/wallColon.png");

        ArrayDeque<String> playerRightImages = new ArrayDeque<>();
        playerRightImages.addLast("img/playerRight0.png");
        playerRightImages.addLast("img/playerRight1.png");
        playerRightImages.addLast("img/playerRight2.png");

        ArrayDeque<String> playerLeftImages = new ArrayDeque<>();
        playerLeftImages.addLast("img/playerLeft0.png");
        playerLeftImages.addLast("img/playerLeft1.png");
        playerLeftImages.addLast("img/playerLeft2.png");

        ArrayDeque<String> playerDownImages = new ArrayDeque<>();
        playerDownImages.addLast("img/playerFront0.png");
        playerDownImages.addLast("img/playerFront1.png");
        playerDownImages.addLast("img/playerFront2.png");

        ArrayDeque<String> playerUpImages = new ArrayDeque<>();
        playerUpImages.addLast("img/playerBack0.png");
        playerUpImages.addLast("img/playerBack1.png");
        playerUpImages.addLast("img/playerBack2.png");


        //Take the keys inputs
        ArrayList<String> input = new ArrayList<String>();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        if ( !input.contains(code) )
                            input.add( code );
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>()
                {
                    public void handle(KeyEvent e)
                    {
                        String code = e.getCode().toString();
                        input.remove( code );
                    }
                });

        // Display the graphics and movement
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //The player object
        Sprite player = new Sprite();
        player.setImage("img/playerFront0.png");
        player.setPosition(500, 150);

        //Sets the image for the forniture objects
        Sprite sofa = new Sprite();
        sofa.setImage("img/sofa.png");
        sofa.setPosition(230,260);

        Sprite toilet = new Sprite();
        toilet.setImage("img/toilet.png");
        toilet.setPosition(430, 250);

        Sprite sink = new Sprite();
        sink.setImage("img/sink_burned.png");
        sink.setPosition(570, 250);

        Sprite bathtub = new Sprite();
        bathtub.setImage("img/bathtub_burned.png");
        bathtub.setPosition(415, 385);

        Sprite dirtyClothes = new Sprite();
        dirtyClothes.setImage("img/dirtyClothes.png");
        dirtyClothes.setPosition(580, 415);

        Sprite plunger = new Sprite();
        plunger.setImage("img/plunger.png");
        plunger.setPosition(565, 430);

        Sprite drawers = new Sprite();
        drawers.setImage("img/drawers.png");
        drawers.setPosition(20,255);

        Sprite tableLiving = new Sprite();
        tableLiving.setImage("img/LivingRoomTable.png");
        tableLiving.setPosition(245, 330);

        Sprite plantA = new Sprite();
        plantA.setImage("img/plantA.png");
        plantA.setPosition(350, 285);

        //All furniture present in the top of the house need fixing
        Sprite kitchen = new Sprite();
        kitchen.setImage("img/kitchen.jpg");
        kitchen.setPosition(20, 20);

        Sprite kitchenTable = new Sprite();
        kitchenTable.setImage("img/kitchenTable.png");
        kitchenTable.setPosition(20,100);

        Sprite plantB = new Sprite();
        plantB.setImage("img/plantB.png");
        plantB.setPosition(230,10);

        Sprite bedCabinet = new Sprite();
        bedCabinet.setImage("img/bedCabinet.png");
        bedCabinet.setPosition(565, 20);



        LongValue lastNanoTime = new LongValue( System.nanoTime() );
        IntValue score = new IntValue(0);
        AtomicInteger stepCounter = new AtomicInteger(0);

        //The animation begins
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                // calculate time since last update.
                double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                lastNanoTime.value = currentNanoTime;

                Rectangle2D so = sofa.getBoundary();
                Rectangle2D wc = toilet.getBoundary();
                Rectangle2D snk = sink.getBoundary();
                Rectangle2D bath = bathtub.getBoundary();
                Rectangle2D draw = drawers.getBoundary();
                Rectangle2D tabLiving = tableLiving.getBoundary();
                Rectangle2D plant1 = plantA.getBoundary();
                Rectangle2D clothes = dirtyClothes.getBoundary();

                //All furniture present in the top of the house need fixing
                Rectangle2D kit = kitchen.getBoundary();
                Rectangle2D tabkitchen = kitchenTable.getBoundary();
                Rectangle2D plant2 = plantB.getBoundary();
                Rectangle2D bedCab = bedCabinet.getBoundary();

                // Player movement

                player.setVelocity(0, 0);
                if (input.contains("LEFT")){
                    if (player.leftBoundary().intersects(so)||
                            player.leftBoundary().intersects(wc)||
                            player.leftBoundary().intersects(bath)||
                            player.leftBoundary().intersects(draw)||
                            player.leftBoundary().intersects(tabLiving)||
                            player.leftBoundary().intersects(tabkitchen)||
                            player.leftBoundary().intersects(plant1)||
                            player.leftBoundary().intersects(plant2)||
                            player.leftBoundary().intersects(0,0,140,40)||
                            player.leftBoundary().intersects(0,0,20,480)||
                            player.leftBoundary().intersects(0,270,140,8)||
                            player.leftBoundary().intersects(402,270,20,240)||
                            player.leftBoundary().intersects(480,270,20,8)||
                            player.leftBoundary().intersects(302,200,20,80)||
                            player.leftBoundary().intersects(302,0,20,144)) {

                        player.addVelocity(0, 0);
                    }else {
                        player.addVelocity(-90, 0);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10){
                            String tempImage = playerLeftImages.pop();
                            playerLeftImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                    }
                }
                if (input.contains("RIGHT")){
                    if (player.rightBoundary().intersects(so)||
                            player.rightBoundary().intersects(snk)||
                            player.rightBoundary().intersects(tabLiving)||
                            player.rightBoundary().intersects(plant1)||
                            player.rightBoundary().intersects(plant2)||
                            player.rightBoundary().intersects(220,0,20,40)||
                            player.rightBoundary().intersects(302,0,20,144)||
                            player.rightBoundary().intersects(620,0,20,480)||
                            player.rightBoundary().intersects(402,270,20,220)||
                            player.rightBoundary().intersects(220,270,20,8)||
                            player.rightBoundary().intersects(302,200,20,80)||
                            player.rightBoundary().intersects(560,270,20,8)){

                        player.addVelocity(0, 0);
                    }else {
                        player.addVelocity(90, 0);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10){
                            String tempImage = playerRightImages.pop();
                            playerRightImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                    }
                }
                if (input.contains("UP")){
                    if (player.upperBoundary().intersects(so)||
                            player.upperBoundary().intersects(wc)||
                            player.upperBoundary().intersects(snk)||
                            player.upperBoundary().intersects(draw)||
                            player.upperBoundary().intersects(tabLiving)||
                            player.upperBoundary().intersects(plant1)||
                            player.upperBoundary().intersects(tabkitchen)||
                            player.upperBoundary().intersects(plant2)||
                            player.upperBoundary().intersects(bedCab)||
                            player.upperBoundary().intersects(0,0,140,50)||
                            player.upperBoundary().intersects(220,0,420,50)||
                            player.upperBoundary().intersects(302,140,20,4)||
                            player.upperBoundary().intersects(0,260,140,20)||
                            player.upperBoundary().intersects(220,260,280,20)||
                            player.upperBoundary().intersects(560,260,60,20)){

                        player.addVelocity(0, 0);
                    }else{
                        player.addVelocity(0, -90);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10){
                            String tempImage = playerUpImages.pop();
                            playerUpImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                    }
                }
                if (input.contains("DOWN")){
                    if (player.bottomBoundary().intersects(so)||
                            player.bottomBoundary().intersects(bath)||
                            player.bottomBoundary().intersects(clothes)||
                            player.bottomBoundary().intersects(tabLiving)||
                            player.bottomBoundary().intersects(plant1)||
                            player.bottomBoundary().intersects(tabkitchen)||
                            player.bottomBoundary().intersects(302,200,20,20)||
                            player.bottomBoundary().intersects(0,270,140,20)||
                            player.bottomBoundary().intersects(220,270,280,20)||
                            player.bottomBoundary().intersects(560,270,60,20)||
                            player.bottomBoundary().intersects(0,460,640,20)){

                        player.addVelocity(0, 0);
                    }else {
                        player.addVelocity(0, 90);
                        stepCounter.addAndGet(1);
                        if (stepCounter.get() == 10){
                            String tempImage = playerDownImages.pop();
                            playerDownImages.addLast(tempImage);
                            player.setImage(tempImage);
                            stepCounter.set(0);
                        }
                    }
                }
                player.update(elapsedTime);

                // Render the image objects

                gc.clearRect(0, 0, 640, 480);
                gc.drawImage(parquet,20,40,302,250);
                gc.drawImage(carpet2,320,62,300,230);
                gc.drawImage(chair,382,172);
                gc.drawImage(studentTable,320,180);
                gc.drawImage(tiles,422,290,198,172);
                gc.drawImage(carpet,20,290,382,170);

                //Draw upper walls and bricks
                gc.drawImage(brickHorizontal,220,0);
                gc.drawImage(brickHorizontal,460,0);
                gc.drawImage(wall,220,20);
                gc.drawImage(brickShortVert,302,0);
                gc.drawImage(brickShort,20,0);
                gc.drawImage(wallShort,0,20);
                gc.drawImage(wallColon,302,120);
                gc.drawImage(bed,440,30);
                gc.drawImage(wardrobe,330,20);

                //Draw the player if it`s in the first half of the screen(above the top walls
                // and behind the middle walls)
                if (player.bottomBoundary().intersects(0,0,640,290)){
                    player.render(gc);
                }

                //render the  middle walls
                gc.drawImage(wallShort,0,250);
                gc.drawImage(wallShort,220,250);

                gc.drawImage(wallShort,320,250);
                gc.drawImage(wallShort,360,250);
                gc.drawImage(wallShort,560,250);


                //Render the bricks
                gc.drawImage(brickVertical,0,0);
                gc.drawImage(brickVertical,0,240);

                gc.drawImage(brickSingleVert,302,180);
                gc.drawImage(brickVertical,402,230);

                gc.drawImage(brickHorizontal,0,480);
                gc.drawImage(brickShort,20,230);
                gc.drawImage(brickHorizontal,220,230);
                gc.drawImage(brickShort,380,230);

                gc.drawImage(brickShort,560,230);
                gc.drawImage(brickHorizontal,20,460);
                gc.drawImage(brickHorizontal,260,460);
                gc.drawImage(brickHorizontal,500,460);
                gc.drawImage(brickVertical,620,0);
                gc.drawImage(brickVertical,620,240);

                //Player above the middle wall and the obstacles in the low middle part of the screen
                sofa.render(gc);
                sofa.render(gc);
                toilet.render(gc);
                sink.render(gc);
                bathtub.render(gc);
                drawers.render(gc);
                tableLiving.render(gc);
                plantA.render(gc);
                dirtyClothes.render(gc);
                plunger.render(gc);

                //those are not working properly
                kitchen.render(gc);
                kitchenTable.render(gc);
                plantB.render(gc);
                bedCabinet.render(gc);


                if (player.bottomBoundary().intersects(0,280,640,210)){
                    player.render(gc);
                }
            }
        }.start();

        theStage.show();
    }
}