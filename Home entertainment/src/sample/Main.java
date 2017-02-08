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
        theStage.setTitle( "Home entertainment" );

        Group root = new Group();

        Scene theScene = new Scene(root, 520, 480, Color.WHITESMOKE);
        theStage.setScene( theScene );

        Canvas canvas = new Canvas( 520, 480 );
        root.getChildren().add( canvas );

        // Create Image and ImageView objects
        Image parquet = new Image("img/parquete.jpg");
        Image tiles = new Image("img/tiles.jpg");
        Image carpet = new Image("img/carpet.jpg");
        Image carpet2 = new Image("img/carpet03.jpg");
        Image siphon = new Image("img/siphon_burned.png");
        Image brickVertical = new Image("img/brickVertical.png");
        Image brickHorizontal = new Image("img/brickHorizontal.png");
        Image brickSingleHorizontal = new Image("img/brickSingleHorizontal.png");
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
        player.setPosition(160, 0);

        //The sofa object
        Sprite sofa = new Sprite();
        sofa.setImage("img/sofa.png");
        sofa.setPosition(17,263);

        //The wardrobe object
        Sprite wardrobe = new Sprite();
        wardrobe.setImage("img/wardrobe_burned (2).png");
        wardrobe.setPosition(280, 23);

        //The stove object
        Sprite stove = new Sprite();
        stove.setImage("img/stove_burned.png");
        stove.setPosition(57, 25);

        //The kitchenDresser object
        Sprite kitchenDresser = new Sprite();
        kitchenDresser.setImage("img/kitchen dresser_burned.png");
        kitchenDresser.setPosition(18, 25);

        //The kitchenSink object
        Sprite kitchenSink = new Sprite();
        kitchenSink.setImage("img/kitchen sink_burned.png");
        kitchenSink.setPosition(202, 11);

        //The fridge object
        Sprite fridge = new Sprite();
        fridge.setImage("img/fridge.png");
        fridge.setPosition(85, 11);

        //The kitchenTable object
        Sprite kitchenTable = new Sprite();
        kitchenTable.setImage("img/table_burned.png");
        kitchenTable.setPosition(37, 119);

        //The coffeeTable object
        Sprite coffeeTable = new Sprite();
        coffeeTable.setImage("img/coffee table_burned.png");
        coffeeTable.setPosition(30, 310);

        //The rubberPlant object
        Sprite rubberPlant = new Sprite();
        rubberPlant.setImage("img/robber plant_burned.png");
        rubberPlant.setPosition(23, 391);

        //The livingDresser object
        Sprite livingDresser = new Sprite();
        livingDresser.setImage("img/dresser_burned.png");
        livingDresser.setPosition(223, 275);

        //The oldRadio object
        Sprite oldRadio = new Sprite();
        oldRadio.setImage("img/vef_burned.png");
        oldRadio.setPosition(232, 259);

        //The tv object
        Sprite tv = new Sprite();
        tv.setImage("img/living room_burned_burned.png");
        tv.setPosition(190, 398);

        //The desk object
        Sprite desk = new Sprite();
        desk.setImage("img/studentTable_burned.png");
        desk.setPosition(284, 180);

        //The deskChair object
        Sprite deskChair = new Sprite();
        deskChair.setImage("img/chair_burned.png");
        deskChair.setPosition(323, 177);

        //The bed object
        Sprite bed = new Sprite();
        bed.setImage("img/bed_burned.png");
        bed.setPosition(375, 45);

        //The toilet object
        Sprite toilet = new Sprite();
        toilet.setImage("img/toilet_burned.png");
        toilet.setPosition(334, 258);

        //The bathtub object
        Sprite bathtub = new Sprite();
        bathtub.setImage("img/bathtub_burned1.png");
        bathtub.setPosition(350, 392);

        //The bathroomSink object
        Sprite bathroomSink = new Sprite();
        bathroomSink.setImage("img/sink_burned.png");
        bathroomSink.setPosition(448, 253);

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
                Rectangle2D wardrobeBoundary = wardrobe.getBoundary();
                Rectangle2D stoveBoundary = stove.getBoundary();
                Rectangle2D kitchenDresserBoundary = kitchenDresser.getBoundary();
                Rectangle2D kitchenSinkBoundary = kitchenSink.getBoundary();
                Rectangle2D kitchenTableBoundary = kitchenTable.getBoundary();
                Rectangle2D fridgeBoundary = fridge.getBoundary();
                Rectangle2D rubberPlantBoundary = rubberPlant.getBoundary();
                Rectangle2D livingDresserBoundary = livingDresser.getBoundary();
                Rectangle2D oldRadioBoundary = oldRadio.getBoundary();
                Rectangle2D tvBoundary = tv.getBoundary();
                Rectangle2D coffeeTableBoundary = coffeeTable.getBoundary();
                Rectangle2D bedBoundary = bed.getBoundary();
                Rectangle2D deskBoundary = desk.getBoundary();
                Rectangle2D deskChairBoundary = deskChair.getBoundary();
                Rectangle2D toiletBoundary = toilet.getBoundary();
                Rectangle2D bathtubBoundary = bathtub.getBoundary();
                Rectangle2D bathroomSinkBoundary = bathroomSink.getBoundary();

                // Player movement

                player.setVelocity(0, 0);
                if (input.contains("LEFT")){
                    if (player.leftBoundary().intersects(so)||
                            player.leftBoundary().intersects(fridgeBoundary)||
                            player.leftBoundary().intersects(kitchenTableBoundary)||
                            player.leftBoundary().intersects(wardrobeBoundary)||
                            player.leftBoundary().intersects(coffeeTableBoundary)||
                            player.leftBoundary().intersects(190,458,102,77)|| //tv
                            player.leftBoundary().intersects(40,468,30,40)|| //rubbery plant
                            player.leftBoundary().intersects(330,482,176,77)|| //bathtub
                            player.leftBoundary().intersects(toiletBoundary)||
                            player.leftBoundary().intersects(parquet.getWidth() + 40,240,98,65)||
                            player.leftBoundary().intersects(0,0,140,60)||
                            player.leftBoundary().intersects(0,0,20,480)||
                            player.leftBoundary().intersects(0,270,240,8)||
                            player.leftBoundary().intersects(480,270,20,8)||
                            player.leftBoundary().intersects(brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth(),263,brickShort.getWidth() + brickSingleHorizontal.getWidth(),20)||
                            player.leftBoundary().intersects(brickVertical.getWidth() + parquet.getWidth(),0,20,brickShortVert.getHeight() + wallColon.getHeight() + 20)||
                            player.leftBoundary().intersects(brickVertical.getWidth() + parquet.getWidth(),brickShortVert.getHeight() + 90,brickSingleVert.getWidth(), 60)
                            || player.rightBoundary().intersects((2*carpet.getWidth() + 50),263,20,brickVertical.getHeight())) {

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
                    if (player.rightBoundary().intersects(kitchenSinkBoundary)||
                            player.rightBoundary().intersects(kitchenTableBoundary)||
                            player.rightBoundary().intersects(oldRadioBoundary)||
                            player.rightBoundary().intersects(livingDresserBoundary)||
                            player.rightBoundary().intersects(coffeeTableBoundary)||
                            player.rightBoundary().intersects(bedBoundary)||
                            player.rightBoundary().intersects(40,468,20,40)|| // rubbery plant
                            player.rightBoundary().intersects(178,448,102,77)|| //tv
                            player.rightBoundary().intersects(330,482,176,77)|| //bathtub
                            player.rightBoundary().intersects(bathroomSinkBoundary)||
                            player.rightBoundary().intersects(parquet.getWidth() + 35,240,98,65)||
                            player.rightBoundary().intersects(203,0,300,60)||
                            player.rightBoundary().intersects(brickVertical.getWidth() + parquet.getWidth(),0,20,brickShortVert.getHeight() + wallColon.getHeight() + 20)||
                            player.rightBoundary().intersects(canvas.getWidth() - brickVertical.getWidth(),0,brickVertical.getWidth(),canvas.getHeight())||
                            player.rightBoundary().intersects(canvas.getWidth() - brickVertical.getWidth() - brickSingleHorizontal.getWidth(),263,brickSingleHorizontal.getWidth(),brickSingleHorizontal.getHeight())||
                            player.rightBoundary().intersects(brickVertical.getWidth() + parquet.getWidth(),brickShortVert.getHeight() + 90,brickSingleVert.getWidth(), 60)||
                            player.rightBoundary().intersects(brickVertical.getWidth() + brickShort.getWidth() + 62,263,140,8)||
                            player.rightBoundary().intersects((2*carpet.getWidth() + 20),263,20,brickVertical.getHeight())){

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
                            player.upperBoundary().intersects(kitchenDresserBoundary)||
                            player.upperBoundary().intersects(kitchenSinkBoundary)||
                            player.upperBoundary().intersects(kitchenTableBoundary)||
                            player.upperBoundary().intersects(fridgeBoundary)||
                            player.upperBoundary().intersects(wardrobeBoundary)||
                            player.upperBoundary().intersects(stoveBoundary)||
                            player.upperBoundary().intersects(coffeeTableBoundary)||
                            player.upperBoundary().intersects(livingDresserBoundary)||
                            player.upperBoundary().intersects(oldRadioBoundary)||
                            player.upperBoundary().intersects(bedBoundary)||
                            player.upperBoundary().intersects(toiletBoundary)||
                            player.upperBoundary().intersects(bathroomSinkBoundary)||
                            player.upperBoundary().intersects(0,0,140,60)||
                            player.upperBoundary().intersects(203,0,420,60)||
                            player.upperBoundary().intersects(brickVertical.getWidth() + parquet.getWidth(),0,20,brickShortVert.getHeight() + wallColon.getHeight() + 20) ||
                            player.upperBoundary().intersects(0,260,140,20)||
                            //player.upperBoundary().intersects(220,260,280,20)||
                            //player.upperBoundary().intersects(560,260,60,20) ||
                            player.bottomBoundary().intersects(20 + brickShort.getWidth() + 62,290,brickShort.getWidth() + 60,20) ||
                            player.bottomBoundary().intersects(canvas.getWidth() - 20 - 60,290,60,20)){

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
                    if (player.bottomBoundary().intersects(kitchenTableBoundary)||
                            player.bottomBoundary().intersects(190,438,102,77)|| //tv
                            player.bottomBoundary().intersects(coffeeTableBoundary)||
                            player.bottomBoundary().intersects(40,450,35,40)|| //rubbery plant
                            player.bottomBoundary().intersects(330,432,176,77)|| //bathtub
                            player.bottomBoundary().intersects(parquet.getWidth() + 40,230,98,100)||
                            player.bottomBoundary().intersects(brickVertical.getWidth() + parquet.getWidth(),brickShortVert.getHeight() + 90,brickSingleVert.getWidth(), 60) ||
                            player.bottomBoundary().intersects(20 + brickShort.getWidth() + 62,263,brickShort.getWidth() + 60,20)||
                            player.bottomBoundary().intersects(canvas.getWidth() - 20 - 60,263,60,20)||
                            player.bottomBoundary().intersects(0,canvas.getHeight() + 10,canvas.getWidth(),20)){

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

                double startCarpetY = brickHorizontal.getHeight() + wallShort.getHeight() + (2 * parquet.getHeight()) + brickHorizontal.getHeight();
                double tilesStartX = (2 * brickVertical.getWidth()) + (2 * carpet.getWidth());

                //Draw pavements of different rooms
                gc.clearRect(0, 0, 520, 480);
                gc.drawImage(parquet,brickVertical.getWidth(),brickHorizontal.getHeight() + wallShort.getHeight());
                gc.drawImage(parquet,brickVertical.getWidth(),brickHorizontal.getHeight() + wallShort.getHeight() + parquet.getHeight());
                gc.drawImage(carpet2,brickVertical.getWidth() + parquet.getWidth() + brickShortVert.getWidth(),brickHorizontal.getHeight() + wallShort.getHeight());
                gc.drawImage(carpet2,brickVertical.getWidth() + parquet.getWidth() + brickShortVert.getWidth(),brickHorizontal.getHeight() + wallShort.getHeight() + carpet2.getHeight());
                gc.drawImage(tiles,tilesStartX,290);
                gc.drawImage(tiles,tilesStartX,startCarpetY + tiles.getHeight());
                gc.drawImage(carpet,brickVertical.getWidth(),startCarpetY);
                gc.drawImage(carpet,brickVertical.getWidth() + carpet.getWidth(),startCarpetY);
                gc.drawImage(carpet,brickVertical.getWidth(),startCarpetY + carpet.getHeight());
                gc.drawImage(carpet,brickVertical.getWidth() + carpet.getWidth(),startCarpetY + carpet.getHeight());

                //Draw upper walls and bricks

                //Upper border
                gc.drawImage(brickShort,brickVertical.getWidth(),0);
                gc.drawImage(brickHorizontal,brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth(),0);
                gc.drawImage(brickSingleHorizontal, canvas.getWidth() - 20 - brickSingleHorizontal.getWidth(), 0);

                //Upper part walls
                gc.drawImage(wallShort,0,brickHorizontal.getHeight());
                gc.drawImage(wall,brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth(),brickHorizontal.getHeight());

                //Middle wall in Upper part
                gc.drawImage(brickShortVert,brickVertical.getWidth() + parquet.getWidth(),0);
                gc.drawImage(wallColon,brickVertical.getWidth() + parquet.getWidth(),brickShortVert.getHeight());

                kitchenDresser.render(gc);
                stove.render(gc);
                kitchenSink.render(gc);
                fridge.render(gc);
                kitchenTable.render(gc);
                wardrobe.render(gc);
                bed.render(gc);

                //Draw the player if it`s in the first half of the screen(above the top walls
                // and behind the middle walls)
                if (player.bottomBoundary().intersects(0,0,canvas.getWidth(),270)){
                    player.render(gc);
                }

                deskChair.render(gc);
                desk.render(gc);

                //Upper part middle wall(single brick)
                //POSITION MUST BE HERE!!!
                gc.drawImage(brickSingleVert,brickVertical.getWidth() + parquet.getWidth(),180);

                //render the  middle walls
                gc.drawImage(wallShort,0,startCarpetY - wallShort.getHeight());
                gc.drawImage(wallShort,brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth(),startCarpetY - wallShort.getHeight());

                //walls between upper and down parts
                gc.drawImage(brickShort,brickVertical.getWidth(),startCarpetY - brickHorizontal.getHeight() - wallShort.getHeight());
                gc.drawImage(brickShort,brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth(),startCarpetY - brickHorizontal.getHeight() - wallShort.getHeight());
                gc.drawImage(brickSingleHorizontal,brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth() + brickShort.getWidth(),startCarpetY - brickHorizontal.getHeight() - wallShort.getHeight());
                gc.drawImage(brickSingleHorizontal,canvas.getWidth() - 20 - brickSingleHorizontal.getWidth(),startCarpetY - brickHorizontal.getHeight() - wallShort.getHeight());
                gc.drawImage(wallShort, canvas.getWidth() - 20 - brickSingleHorizontal.getWidth(),startCarpetY - wallShort.getHeight());
                gc.drawImage(wallShort, brickVertical.getWidth() + brickShort.getWidth() + brickSingleHorizontal.getWidth() + 41,startCarpetY - wallShort.getHeight());

                //wall between living room and bathroom
                gc.drawImage(brickVertical,brickVertical.getWidth() + (2 * carpet.getWidth()),230);

                //Render the bricks

                //Left border
                gc.drawImage(brickVertical,0,0);
                gc.drawImage(brickVertical,0,brickVertical.getHeight());

                //Right border
                gc.drawImage(brickVertical,canvas.getWidth() - brickVertical.getWidth(), 0);
                gc.drawImage(brickVertical,canvas.getWidth() - brickVertical.getWidth(), brickVertical.getHeight());

                sofa.render(gc);
                coffeeTable.render(gc);
                rubberPlant.render(gc);
                livingDresser.render(gc);
                oldRadio.render(gc);
                toilet.render(gc);
                bathroomSink.render(gc);
                gc.drawImage(siphon, 411, 366);

                //Player above the middle wall and the obstacles in the low middle part of the screen
                if (player.bottomBoundary().intersects(0,270,520,250)){
                    player.render(gc);
                }

                bathtub.render(gc);
                tv.render(gc);
                rubberPlant.render(gc);

                //Down border
                gc.drawImage(brickHorizontal,brickVertical.getWidth(),canvas.getHeight() - brickHorizontal.getHeight());
                gc.drawImage(brickHorizontal,brickVertical.getWidth() + brickHorizontal.getWidth(),canvas.getHeight() - brickHorizontal.getHeight());

            }
        }.start();

        theStage.show();
    }
}