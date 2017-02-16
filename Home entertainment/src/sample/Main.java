package sample;

import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import static sample.RoomsParameters.*;

public class Main extends Application {

    private static Player player;
    private static ArrayList<String> input;
    private static AudioClip walking, running, wallHit;
    private static AtomicInteger stepCounter;
    private static final boolean[] mute = {false};
    ArrayDeque<String> playerDownImages, playerRightImages, playerLeftImages, playerUpImages;
    public static Canvas canvas = new Canvas(1024, 768);
    public String direction;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage theStage) {

        theStage.setTitle("Home entertainment");
        Group root = new Group();
        Scene theScene = new Scene(root, 1024, 748, Color.WHITESMOKE);
        theStage.setScene(theScene);
        root.getChildren().add(canvas);

        Image parquet = new Image("img/parquet.jpg", KITCHEN_WIDTH, KITCHEN_HEIGHT / 2, false, false);
        Image tiles = new Image("img/tiles2.jpg", BATHROOM_WIDTH, BATHROOM_HEIGHT / 2, false, false);
        Image carpet = new Image("img/carpet.jpg", LIVINGROOM_WIDTH / 2, LIVINGROOM_HEIGHT / 2, false, false);
        Image carpet2 = new Image("img/carpet03.jpg", BEDROOM_WIDTH, BEDROOM_HEIGHT / 2, false, false);
        Image siphon = new Image("img/siphon.png", 40, 40, false, false);
        Image statsBoard = new Image("img/statsBoard.png");

        playerRightImages = new ArrayDeque<>();
        playerRightImages.addLast("img/playerRight0.png");
        playerRightImages.addLast("img/playerRight1.png");
        playerRightImages.addLast("img/playerRight2.png");

        playerLeftImages = new ArrayDeque<>();
        playerLeftImages.addLast("img/playerLeft0.png");
        playerLeftImages.addLast("img/playerLeft1.png");
        playerLeftImages.addLast("img/playerLeft2.png");

        playerDownImages = new ArrayDeque<>();
        playerDownImages.addLast("img/playerFront0.png");
        playerDownImages.addLast("img/playerFront1.png");
        playerDownImages.addLast("img/playerFront2.png");

        playerUpImages = new ArrayDeque<>();
        playerUpImages.addLast("img/playerBack0.png");
        playerUpImages.addLast("img/playerBack1.png");
        playerUpImages.addLast("img/playerBack2.png");

        ArrayDeque<String> monstersImages = new ArrayDeque<>();
        monstersImages.addLast("img/monster.gif");
        monstersImages.addLast("img/monster1.png");
        monstersImages.addLast("img/monster2.png");

        //The player object
        Image playerImage = new Image("img/playerFront0.png", 45, 120, false, false);
        player = new Player();
        player.setImage(playerImage);
        player.setPosition(5 * brickSingleHorizontal.getWidth(), 20);

        //Create different monsters
        ArrayDeque<Sprite> monsterList = new ArrayDeque<>();
        for (int i = 0; i < 15; i++) {
            Sprite monster = new Sprite();
            String tempImage = monstersImages.pop();
            monstersImages.addLast(tempImage);
            Image monsterImage = new Image(tempImage, 50, 44, false, false);
            monster.setImage(monsterImage);
            monsterList.add(monster);
        }
        ArrayList<Sprite> monstersToRender = new ArrayList<>();

        //Take the keys inputs
        input = new ArrayList<>();

        theScene.setOnKeyPressed(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        if (!input.contains(code))
                            input.add(code);
                    }
                });

        theScene.setOnKeyReleased(
                new EventHandler<KeyEvent>() {
                    public void handle(KeyEvent e) {
                        String code = e.getCode().toString();
                        input.remove(code);
                    }
                });

        // Display the graphics and movement
        GraphicsContext gc = canvas.getGraphicsContext2D();

        //The kitchenDresser object
        Image kitchenDresserImage = new Image("img/kitchenDresser.png", 80, 135, false, false);
        Sprite kitchenDresser = new Sprite();
        kitchenDresser.setImage(kitchenDresserImage);
        kitchenDresser.setPosition(brickSingleVert.getWidth() + 5, 25);

        //The stove object
        Image stoveImage = new Image("img/stove.png", 80, 110, false, false);
        Sprite stove = new Sprite();
        stove.setImage(stoveImage);
        stove.setPosition(brickSingleVert.getWidth() + kitchenDresser.getWidth() + 5, 50);

        //The kitchenSink object
        Image kitchenSinkImage = new Image("img/kitchenSink.png", 80, 120, false, false);
        Sprite kitchenSink = new Sprite();
        kitchenSink.setImage(kitchenSinkImage);
        kitchenSink.setPosition(stove.getX() + stove.getWidth() + 5, 36);

        //The fridge object
        Image fridgeImage = new Image("img/fridge.png", 70, 125, false, false);
        Sprite fridge = new Sprite();
        fridge.setImage(fridgeImage);
        fridge.setPosition(kitchenSink.getX() + kitchenSink.getWidth() + (2 * brickSingleHorizontal.getWidth()) + 20, 30);

        //The kitchenTable object
        Image kitchenTableImage = new Image("img/table_burned_burned.png", 267, 151, false, false);
        Sprite kitchenTable = new Sprite();
        kitchenTable.setImage(kitchenTableImage);
        kitchenTable.setPosition(30, 199);

        //The sofa object
        Image sofaImage = new Image("img/sofa.png", 240, 140, false, false);
        Sprite sofa = new Sprite();
        sofa.setImage(sofaImage);
        sofa.setPosition(LIVINGROOM_X + LIVINGROOM_WIDTH - sofa.getWidth() + 5, LIVINGROOM_Y - 80);

        //The coffeeTable object
        Image coffeeTableImage = new Image("img/coffeeTable.png", 150, 100, false, false);
        Sprite coffeeTable = new Sprite();
        coffeeTable.setImage(coffeeTableImage);
        coffeeTable.setPosition(LIVINGROOM_WIDTH - coffeeTable.getWidth() - 70, LIVINGROOM_Y);

        //The livingRoomChair object
        Image livingRoomChairImage = new Image("img/livingChair.png", 150, 100, false, false);
        Sprite livingRoomChair = new Sprite();
        livingRoomChair.setImage(livingRoomChairImage);
        livingRoomChair.setPosition(LIVINGROOM_WIDTH - livingRoomChair.getWidth() - 20, LIVINGROOM_Y + livingRoomChair.getHeight());

        //The livingDresser object
        Image livingDresserImage = new Image("img/dresser.png", 150, 100, false, false);
        Sprite livingDresser = new Sprite();
        livingDresser.setImage(livingDresserImage);
        livingDresser.setPosition(LIVINGROOM_X + 20, LIVINGROOM_Y - 60);

        //The rubberPlant object
        Image rubberPlantImage = new Image("img/robber plant_burned.png", 65, 90, false, false);
        Sprite rubberPlant = new Sprite();
        rubberPlant.setImage(rubberPlantImage);
        rubberPlant.setPosition(LIVINGROOM_X + livingDresser.getWidth() + 25, LIVINGROOM_Y - 60);

        //The tv object
        Image tvImage = new Image("img/tv.png", 180, 150, false, false);
        Sprite tv = new Sprite();
        tv.setImage(tvImage);
        tv.setPosition(LIVINGROOM_X, LIVINGROOM_Y + 130);

        //The desk object
        Image deskImage = new Image("img/desk.png", 180, 140, false, false);
        Sprite desk = new Sprite();
        desk.setImage(deskImage);
        desk.setPosition(BEDROOM_X + 10, canvas.getHeight() / 2 - 60);

        //The bed object
        Image bedImage = new Image("img/bed.png", 200, 170, false, false);
        Sprite bed = new Sprite();
        bed.setImage(bedImage);
        bed.setPosition(canvas.getWidth() - bedImage.getWidth() - brickSingleVert.getWidth() - 10, 50);

        //The wardrobe object
        Image wardrobeImage = new Image("img/wardrobe_burned.png", 150, 150, false, false);
        Sprite wardrobe = new Sprite();
        wardrobe.setImage(wardrobeImage);
        wardrobe.setPosition(bed.getX() - wardrobe.getWidth() - 90, 23);

        //The toilet object
        Image toiletImage = new Image("img/toilet.png", 100, 110, false, false);
        Sprite toilet = new Sprite();
        toilet.setImage(toiletImage);
        toilet.setPosition(canvas.getWidth() - toilet.getWidth() - brickSingleVert.getWidth(), BATHROOM_Y - 70);

        //The bathtub object
        Image bathtubImage = new Image("img/bathtub.png", BATHROOM_WIDTH - 50, 170, false, false);
        Sprite bathtub = new Sprite();
        bathtub.setImage(bathtubImage);
        bathtub.setPosition(BATHROOM_X + 30, BATHROOM_Y + 120);

        //The bathroomSink object
        Image sinkImage = new Image("img/sink.png", 110, 130, false, false);
        Sprite bathroomSink = new Sprite();
        bathroomSink.setImage(sinkImage);
        bathroomSink.setPosition(BATHROOM_X + 10, BATHROOM_Y - 70);


        wallHit = new AudioClip(Paths.get("Home entertainment/src/sounds/wall_hit.wav").toUri().toString());
        AudioClip pickup = new AudioClip(Paths.get("Home entertainment/src/sounds/pickup.wav").toUri().toString());
        walking = new AudioClip(Paths.get("Home entertainment/src/sounds/walking.wav").toUri().toString());
        running = new AudioClip(Paths.get("Home entertainment/src/sounds/running.mp4").toUri().toString());
        AudioClip spraying = new AudioClip(Paths.get("Home entertainment/src/sounds/sprayingSound.mp4").toUri().toString());

        //Display introduce on Main page
        Image mainImage = new Image("img/07.jpg", canvas.getWidth(), canvas.getHeight(), false, false);
        gc.drawImage(mainImage, 0, 0);

        //Introduce title
        Font introduce = Font.font(java.awt.Font.DIALOG, 43);
        gc.setTextAlign(TextAlignment.CENTER);
        gc.setFont(introduce);
        final Effect glow = new Glow(1.0);
        gc.setEffect(glow);
        gc.setFill(Color.CADETBLUE);
        String text = "Team Maleficent introduce you Home Entertainment";
        gc.fillText(text, canvas.getWidth() / 2, canvas.getHeight() - 50);

        //Button menu
        Button buttonMenu = new Button("Menu");
        buttonMenu.setPrefHeight(50);
        buttonMenu.setPrefWidth(150);
        buttonMenu.setLayoutX((canvas.getWidth() - (3 * buttonMenu.getPrefWidth()) - (2 * 50)) / 2 + 15);
        buttonMenu.setLayoutY(canvas.getHeight() - 180);
        buttonMenu.setStyle("-fx-font: 22 arial");
        root.getChildren().add(buttonMenu);


        //Button start
        Button buttonStart = new Button("Start");
        buttonStart.setPrefHeight(50);
        buttonStart.setPrefWidth(150);
        buttonStart.setLayoutX(buttonMenu.getLayoutX() + buttonMenu.getPrefWidth() + 50);
        buttonStart.setLayoutY(canvas.getHeight() - 180);
        buttonStart.setStyle("-fx-font: 22 arial");
        root.getChildren().add(buttonStart);

        //Button quit
        Button buttonQuit = new Button("Quit");
        buttonQuit.setPrefHeight(50);
        buttonQuit.setPrefWidth(150);
        buttonQuit.setLayoutX(buttonStart.getLayoutX() + buttonStart.getPrefWidth() + 50);
        buttonQuit.setLayoutY(canvas.getHeight() - 180);
        buttonQuit.setStyle("-fx-font: 22 arial");
        root.getChildren().add(buttonQuit);

        //Blink option
        Timeline blinker = createBlinker(buttonStart);
        SequentialTransition blinkedButton = new SequentialTransition(buttonStart, blinker);

        final boolean[] isMainWindow = {true};
        final Image[] imageSound = {new Image("img/soundOn.png", 30, 30, false, false)};
        Text menuTitle = new Text("Menu");
        Text menuSoundText1 = new Text("Sound ON");
        Text menuSoundText2 = new Text("Affects all sounds and music");
        Text keyboardGuideTitle = new Text("Keyboard guide:\n");
        Text keyboardGuide = new Text("\t-'P' button - pause;\n\t-'Esc' button - show menu;\n\t-'Left' button - player moving left;\n\t-'Right' button - player moving right;\n\t-'Up' button - player moving up;\n\t-'Down' button - player moving down;\n\t-'Shift' button with combination('Left', 'Right', 'Up', or 'Down' buttons) - player start running;");
        Button buttonClose = new Button();
        Button buttonSound = new Button();
        Button buttonStartNewGame = new Button("New Game");
        Button buttonResume = new Button("Resume");


        //Menu params
        double menuWidth = (3 * buttonMenu.getPrefWidth()) + (2 * 50);
        double menuHeight = canvas.getHeight() - (canvas.getHeight() / 2) + 100;
        double menuX = buttonMenu.getLayoutX();
        double menuY = (canvas.getHeight() - (canvas.getHeight() / 2)) / 2 - 100;
        Rectangle menu = new Rectangle(menuX, menuY, menuWidth, menuHeight);
        menu.setFill(Color.SKYBLUE);

        //Menu Title
        Font menuTitleFont = Font.font(java.awt.Font.MONOSPACED, 43);
        menuTitle.setFont(menuTitleFont);
        menuTitle.setFill(Color.MEDIUMVIOLETRED);
        menuTitle.setX(canvas.getWidth() / 2 - 20);
        menuTitle.setY(menuY + 50);

        //Menu Sound control
        Font menuSound1 = Font.font(java.awt.Font.MONOSPACED, 20);
        menuSoundText1.setFont(menuSound1);
        menuSoundText1.setFill(Color.MEDIUMVIOLETRED);
        menuSoundText1.setX(menuX + 60);
        menuSoundText1.setY(menuY + 100);
        Font menuSound2 = Font.font(java.awt.Font.MONOSPACED, 15);
        menuSoundText2.setFont(menuSound2);
        menuSoundText2.setFill(Color.MEDIUMVIOLETRED);
        menuSoundText2.setX(menuX + 60);
        menuSoundText2.setY(menuY + 120);
        keyboardGuideTitle.setFont(menuSound1);
        keyboardGuideTitle.setFill(Color.MEDIUMVIOLETRED);
        keyboardGuideTitle.setX(menuX + 10);
        keyboardGuideTitle.setY(menuY + 180);
        keyboardGuide.setFont(menuSound2);
        keyboardGuide.setFill(Color.MEDIUMVIOLETRED);
        keyboardGuide.setX(menuX + 10);
        keyboardGuide.setY(menuY + 200);
        keyboardGuide.setWrappingWidth(menu.getWidth() - 20);

        //Button Sound
        buttonSound.setGraphic(new ImageView(imageSound[0]));
        buttonSound.setLayoutX(menuX + 10);
        buttonSound.setLayoutY(menuY + 80);

        //Button Menu close
        Image imageDecline = new Image("img/not1.png", 30, 30, false, false);
        buttonClose.setGraphic(new ImageView(imageDecline));
        buttonClose.setLayoutX(menuX - buttonClose.getWidth() / 2);
        buttonClose.setLayoutY(menuY - buttonClose.getHeight() / 2);

        buttonSound.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (mute[0]) {
                    imageSound[0] = new Image("img/soundOn.png", 30, 30, false, false);
                    buttonSound.setGraphic(new ImageView(imageSound[0]));
                    menuSoundText1.setText("Sound ON");
                    mute[0] = false;
                } else {
                    imageSound[0] = new Image("img/soundOff.png", 30, 30, false, false);
                    buttonSound.setGraphic(new ImageView(imageSound[0]));
                    menuSoundText1.setText("Sound OFF");
                    mute[0] = true;
                }
            }
        });

        buttonClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (isMainWindow[0]) {
                    root.getChildren().add(buttonMenu);
                } else {
                    root.getChildren().remove(buttonQuit);
                }
                root.getChildren().remove(menu);
                root.getChildren().remove(buttonClose);
                root.getChildren().remove(menuTitle);
                root.getChildren().remove(menuSoundText1);
                root.getChildren().remove(menuSoundText2);
                root.getChildren().remove(buttonSound);
                root.getChildren().remove(keyboardGuideTitle);
                root.getChildren().remove(keyboardGuide);
                root.getChildren().remove(buttonStartNewGame);
                root.getChildren().remove(buttonResume);
            }
        });

        buttonMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                root.getChildren().remove(buttonMenu);
                root.getChildren().add(menu);
                root.getChildren().add(menuTitle);
                root.getChildren().add(menuSoundText1);
                root.getChildren().add(menuSoundText2);
                root.getChildren().add(keyboardGuideTitle);
                root.getChildren().add(keyboardGuide);
                root.getChildren().add(buttonSound);
                root.getChildren().add(buttonClose);
            }
        });

        buttonQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                theStage.close();
            }
        });

        buttonStart.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                isMainWindow[0] = false;

                //Prepare the score text
                Font scoreFont = Font.font("Arial", FontWeight.NORMAL, 20);
                gc.setFont(scoreFont);
                gc.setStroke(Color.BLACK);
                gc.setLineWidth(1);
                gc.setTextAlign(TextAlignment.LEFT);

                LongValue lastNanoTime = new LongValue(System.nanoTime());
                stepCounter = new AtomicInteger(0);
                AtomicInteger monsterCounter = new AtomicInteger(0);

                //The animation begins
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {
                        // calculate time since last update.
                        double elapsedTime = (currentNanoTime - lastNanoTime.value) / 1000000000.0;
                        lastNanoTime.value = currentNanoTime;

                        root.getChildren().remove(buttonStart);
                        root.getChildren().remove(buttonMenu);
                        root.getChildren().remove(buttonQuit);
                        root.getChildren().remove(menu);
                        root.getChildren().remove(buttonClose);
                        root.getChildren().remove(menuTitle);
                        root.getChildren().remove(menuSoundText1);
                        root.getChildren().remove(menuSoundText2);
                        root.getChildren().remove(buttonSound);
                        root.getChildren().remove(keyboardGuideTitle);
                        root.getChildren().remove(keyboardGuide);

                        gc.setEffect(null);

                        Rectangle2D sofaBoundary = sofa.getBoundary();
                        Rectangle2D wardrobeBoundary = wardrobe.getBoundary();
                        Rectangle2D stoveBoundary = stove.getBoundary();
                        Rectangle2D kitchenDresserBoundary = kitchenDresser.getBoundary();
                        Rectangle2D kitchenSinkBoundary = kitchenSink.getBoundary();
                        Rectangle2D kitchenTableBoundary = kitchenTable.getBoundary();
                        Rectangle2D fridgeBoundary = fridge.getBoundary();
                        Rectangle2D rubberPlantBoundary = rubberPlant.getBoundary();
                        Rectangle2D livingDresserBoundary = livingDresser.getBoundary();
                        Rectangle2D oldRadioBoundary = livingRoomChair.getBoundary();
                        Rectangle2D tvBoundary = tv.getBoundary();
                        Rectangle2D livingRoomChairBoundary = livingRoomChair.getBoundary();
                        Rectangle2D coffeeTableBoundary = coffeeTable.getBoundary();
                        Rectangle2D bedBoundary = bed.getBoundary();
                        Rectangle2D deskBoundary = desk.getBoundary();
                        Rectangle2D toiletBoundary = toilet.getBoundary();
                        Rectangle2D bathtubBoundary = bathtub.getBoundary();
                        Rectangle2D bathroomSinkBoundary = bathroomSink.getBoundary();


                        //Button start new game
                        buttonStartNewGame.setPrefHeight(50);
                        buttonStartNewGame.setPrefWidth(150);
                        buttonStartNewGame.setLayoutX((canvas.getWidth() - (3 * buttonMenu.getPrefWidth()) - (2 * 50)) / 2 + 15);
                        buttonStartNewGame.setLayoutY(canvas.getHeight() - 180);
                        buttonStartNewGame.setStyle("-fx-font: 22 arial");

                        buttonStartNewGame.setOnAction(__ ->
                        {
                            theStage.close();
                            Platform.runLater(() -> new Main().start(new Stage()));
                        });

                        //Button Resume game
                        buttonResume.setPrefHeight(50);
                        buttonResume.setPrefWidth(150);
                        buttonResume.setLayoutX(buttonMenu.getLayoutX() + buttonMenu.getPrefWidth() + 50);
                        buttonResume.setLayoutY(canvas.getHeight() - 180);
                        buttonResume.setStyle("-fx-font: 22 arial");

                        //Button Pause game
                        Button pause = new Button("Pause");
                        pause.setPrefHeight(50);
                        pause.setPrefWidth(150);
                        pause.setLayoutX(buttonMenu.getLayoutX() + buttonMenu.getPrefWidth() + 50);
                        pause.setLayoutY(buttonResume.getLayoutY() - 20 - buttonResume.getPrefHeight());
                        pause.setStyle("-fx-font: 22 arial");

                        buttonResume.setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                root.getChildren().remove(menu);
                                root.getChildren().remove(buttonClose);
                                root.getChildren().remove(menuTitle);
                                root.getChildren().remove(menuSoundText1);
                                root.getChildren().remove(menuSoundText2);
                                root.getChildren().remove(buttonSound);
                                root.getChildren().remove(keyboardGuideTitle);
                                root.getChildren().remove(keyboardGuide);
                                root.getChildren().remove(buttonResume);
                                root.getChildren().remove(pause);
                                root.getChildren().remove(buttonStartNewGame);

                                start();
                            }
                        });

                        //show menu
                        if (input.contains("ESCAPE")) {
                            root.getChildren().add(menu);
                            root.getChildren().add(menuTitle);
                            root.getChildren().add(menuSoundText1);
                            root.getChildren().add(menuSoundText2);
                            root.getChildren().add(buttonSound);
                            root.getChildren().add(keyboardGuideTitle);
                            root.getChildren().add(keyboardGuide);
                            root.getChildren().add(buttonQuit);
                            root.getChildren().add(buttonResume);
                            root.getChildren().add(buttonStartNewGame);

                            stop();
                        }

                        //Pause control
                        if (input.contains("P")) {
                            root.getChildren().add(pause);
                            root.getChildren().add(buttonResume);
                            stop();
                        }

                        // Player movement
                        player.setVelocity(0, 0);
                        if (input.contains("LEFT") && !input.contains("SPACE")) {
                            if (player.leftBoundary().intersects(kitchenSinkBoundary) ||
                                    player.leftBoundary().intersects(kitchenTableBoundary) ||
                                    player.leftBoundary().intersects(wardrobeBoundary) ||
                                    player.leftBoundary().intersects(livingRoomChairBoundary) ||
                                    player.leftBoundary().intersects(fridgeBoundary) ||
                                    player.leftBoundary().intersects(desk.getX(), desk.getY() + 40, desk.getWidth(), desk.getHeight()) || //desk
                                    player.leftBoundary().intersects(toilet.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), toilet.getWidth(), 50) || //toilet
                                    player.leftBoundary().intersects(bathtub.getX(), bathtub.getY() + 100, bathtub.getWidth(), bathtub.getHeight()) || //bathtub
                                    player.leftBoundary().intersects(bathroomSink.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), bathroomSink.getWidth(), 70) || //bathroom sink
                                    player.leftBoundary().intersects(rubberPlant.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), rubberPlant.getWidth(), carpet.getHeight() / 4 + brickSingleHorizontal.getHeight()) || //rubber plant
                                    player.leftBoundary().intersects(tv.getX(), tv.getY() + 100, tv.getWidth(), tv.getHeight()) || //tv
                                    player.leftBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight())) || // wall between kitchen and bedroom
                                    player.leftBoundary().intersects(0, 0, brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall left from entrance
                                    player.leftBoundary().intersects(0, 0, brickSingleVert.getWidth(), canvas.getHeight() + wallShort.getHeight()) || //left border
                                    player.leftBoundary().intersects(brickSingleVert.getWidth(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between kitchen and living room
                                    player.leftBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                                    player.leftBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert.getWidth(), brickSingleVert.getHeight() * 2) || // wall between kitchen and bedroom(one brick)
                                    player.leftBoundary().intersects(BATHROOM_X - brickSingleVert.getWidth(), BATHROOM_Y, brickSingleVert.getWidth(), BATHROOM_HEIGHT + 40)) { //wall between living room and bathroom

                                checkIfPlayerCollidesUD();

                            } else {
                                direction = "left";
                                playerMove(-180, 0, direction, -90, 0);
                            }
                        }
                        if (input.contains("RIGHT") && !input.contains("SPACE")) {
                            if (player.rightBoundary().intersects(fridgeBoundary) ||
                                    player.rightBoundary().intersects(bedBoundary) ||
                                    player.rightBoundary().intersects(livingRoomChairBoundary) ||
                                    player.rightBoundary().intersects(desk.getX(), desk.getY() + 40, desk.getWidth(), desk.getHeight()) || //desk
                                    player.rightBoundary().intersects(bathtub.getX(), bathtub.getY() + 100, bathtub.getWidth(), bathtub.getHeight()) || //bathtub
                                    player.rightBoundary().intersects(toilet.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), toilet.getWidth(), 50) || //toilet
                                    player.rightBoundary().intersects(coffeeTable.getX(), coffeeTable.getY(), coffeeTable.getWidth(), 3 * (carpet.getHeight() / 4) - 30) || // coffee table
                                    player.rightBoundary().intersects(sofa.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), sofa.getWidth(), carpet.getHeight() / 2 + (2 * brickSingleHorizontal.getHeight())) || // sofa
                                    player.rightBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight())) || // wall between kitchen and bedroom
                                    player.rightBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), 0, 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                                    player.rightBoundary().intersects(canvas.getWidth() - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), canvas.getHeight() + 40) || //right border
                                    player.rightBoundary().intersects(brickSingleVert.getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal.getHeight(), 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between bedroom and bathroom
                                    player.rightBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                                    player.rightBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert.getWidth(), brickSingleVert.getHeight() * 2) || // wall between kitchen and bedroom(one brick)
                                    player.rightBoundary().intersects(BATHROOM_X - brickSingleVert.getWidth(), BATHROOM_Y, brickSingleVert.getWidth(), BATHROOM_HEIGHT + 40)) { //wall between living room and bathroom

                                checkIfPlayerCollidesUD();
                            } else {
                                direction = "right";
                                playerMove(180, 0, direction, 90, 0);
                            }
                        }
                        if (input.contains("UP") && !input.contains("SPACE")) {
                            if (player.upperBoundary().intersects(kitchenDresserBoundary) ||
                                    player.upperBoundary().intersects(kitchenSinkBoundary) ||
                                    player.upperBoundary().intersects(kitchenTableBoundary) ||
                                    player.upperBoundary().intersects(fridgeBoundary) ||
                                    player.upperBoundary().intersects(wardrobeBoundary) ||
                                    player.upperBoundary().intersects(stoveBoundary) ||
                                    player.upperBoundary().intersects(coffeeTableBoundary) ||
                                    player.upperBoundary().intersects(bedBoundary) ||
                                    player.upperBoundary().intersects(livingRoomChairBoundary) ||
                                    player.rightBoundary().intersects(toilet.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), toilet.getWidth(), 50) || //toilet
                                    player.upperBoundary().intersects(bathroomSink.getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), bathroomSink.getWidth(), 70) || //bathroom sink
                                    player.upperBoundary().intersects(sofa.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), sofa.getWidth(), carpet.getHeight() / 2 + (2 * brickSingleHorizontal.getHeight())) || // sofa
                                    player.upperBoundary().intersects(livingDresser.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), livingDresser.getWidth(), carpet.getHeight() / 4 + brickSingleHorizontal.getHeight()) || //living room dresser
                                    player.upperBoundary().intersects(rubberPlant.getX(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), rubberPlant.getWidth(), carpet.getHeight() / 4 + brickSingleHorizontal.getHeight()) || //rubber plant
                                    player.upperBoundary().intersects(0, 0, brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight()) || //upper wall right from entrance
                                    player.upperBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), wallShort.getHeight(), 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //upper wall right from entrance
                                    player.upperBoundary().intersects(brickSingleVert.getWidth(), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between kitchen and living room
                                    player.upperBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                                    player.upperBoundary().intersects(brickSingleVert.getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal.getHeight(), 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between bedroom and bathroom
                                    player.upperBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()))) { //wall between kitchen and bedroom

                                checkIfPlayerCollidesLR();
                            } else {
                                direction = "up";
                                playerMove(0, -180, direction, 0, -90);
                            }
                        }
                        if (input.contains("DOWN") && !input.contains("SPACE")) {
                            if (player.bottomBoundary().intersects(kitchenTableBoundary) ||
                                    player.bottomBoundary().intersects(livingRoomChairBoundary) ||
                                    player.bottomBoundary().intersects(desk.getX(), desk.getY() + 40, desk.getWidth(), desk.getHeight()) || //desk
                                    player.bottomBoundary().intersects(tv.getX(), tv.getY() + 100, tv.getWidth(), tv.getHeight()) || //tv
                                    player.bottomBoundary().intersects(bathtub.getX(), bathtub.getY() + 100, bathtub.getWidth(), bathtub.getHeight()) || //bathtub
                                    player.bottomBoundary().intersects(0, 0, brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                                    player.bottomBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), 0, 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                                    player.bottomBoundary().intersects(brickSingleVert.getWidth(), LIVINGROOM_Y - brickSingleHorizontal.getHeight() - 5, 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between kitchen and living room
                                    player.bottomBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVINGROOM_Y - brickSingleHorizontal.getHeight() - 5, 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between every rooms
                                    player.bottomBoundary().intersects(brickSingleVert.getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal.getHeight() - 5, 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //wall between bedroom and bathroom
                                    player.bottomBoundary().intersects(0, canvas.getHeight() - 10, canvas.getWidth(), brickSingleHorizontal.getHeight()) || //down border
                                    player.bottomBoundary().intersects(0, wallShort.getHeight(), brickSingleVert.getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight()) || //upper wall left from entrance
                                    player.bottomBoundary().intersects(brickSingleVert.getWidth() + (6 * brickSingleHorizontal.getWidth()), wallShort.getHeight(), 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal.getHeight()) || //upper wall right from entrance
                                    player.bottomBoundary().intersects(BEDROOM_X - brickSingleVert.getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon.getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert.getWidth(), brickSingleVert.getHeight() * 2)) { // wall between kitchen and bedroom(one brick)

                                checkIfPlayerCollidesLR();
                            } else {
                                direction = "down";
                                playerMove(0, 180, direction, 0, 90);
                            }
                        }
                        //Stops sound effects while standing in place
                        if ((!input.contains("LEFT") && !input.contains("RIGHT") && !input.contains("UP") && !input.contains("DOWN")) || input.contains("SPACE")) {
                            walking.stop();
                            running.stop();
                        }
                        player.update(elapsedTime);

                        // Render the image objects
                        double doorWidth = 2 * brickSingleHorizontal.getWidth();
                        double wallKitchenLivingRoomWidth = 0;
                        double wallKitchenLivingRoomBedroomBathroomWidth = 0;
                        double wallUpBorder1 = 0;
                        double wallKitchenBedroomHeight = 0;

                        //Draw pavements of different rooms
                        gc.clearRect(0, 0, 1024, 768);
                        gc.drawImage(parquet, KITCHEN_X, KITCHEN_Y);
                        gc.drawImage(parquet, KITCHEN_X, KITCHEN_Y + KITCHEN_HEIGHT / 2);
                        gc.drawImage(carpet2, BEDROOM_X, BEDROOM_Y);
                        gc.drawImage(carpet2, BEDROOM_X, BEDROOM_Y + BEDROOM_HEIGHT / 2);
                        gc.drawImage(tiles, BATHROOM_X, BATHROOM_Y);
                        gc.drawImage(tiles, BATHROOM_X, BATHROOM_Y + BATHROOM_HEIGHT / 2);
                        gc.drawImage(carpet, LIVINGROOM_X, LIVINGROOM_Y);
                        gc.drawImage(carpet, LIVINGROOM_X + LIVINGROOM_WIDTH / 2, LIVINGROOM_Y);
                        gc.drawImage(carpet, LIVINGROOM_X, LIVINGROOM_Y + LIVINGROOM_HEIGHT / 2);
                        gc.drawImage(carpet, LIVINGROOM_X + LIVINGROOM_WIDTH / 2, LIVINGROOM_Y + LIVINGROOM_HEIGHT / 2);

                        //Draw upper walls and bricks
                        //Upper border
                        for (int i = 0; i < 4; i++) {
                            gc.drawImage(wallShort, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight());
                            gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), 0);
                            wallUpBorder1 += brickSingleHorizontal.getWidth();
                        }

                        for (int i = 0; i < canvas.getWidth() / brickSingleHorizontal.getWidth(); i++) {
                            gc.drawImage(wallShort, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (i * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight());
                            //Stats board
                            gc.drawImage(statsBoard, canvas.getWidth() - 240, 3);
                            gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (i * brickSingleHorizontal.getWidth()), 0);
                        }
                        //wall between kitchen and bedroom
                        for (int i = 0; i < 3; i++) {
                            gc.drawImage(brickSingleVert, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), i * brickSingleVert.getHeight());
                            wallKitchenBedroomHeight += brickSingleVert.getHeight();
                        }

                        for (int i = 0; i < 2; i++) {
                            gc.drawImage(wallColon, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), wallKitchenBedroomHeight + (i * wallColon.getHeight()));
                        }

                        kitchenDresser.render(gc);
                        stove.render(gc);
                        kitchenSink.render(gc);
                        fridge.render(gc);
                        kitchenTable.render(gc);
                        wardrobe.render(gc);
                        bed.render(gc);

                        //Draw the player if it`s in the first half of the screen(above the top walls
                        // and behind the middle walls)
                        if (player.bottomBoundary().intersects(0, 0, canvas.getWidth(), brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT)) {
                            player.render(gc);
                        }

                        desk.render(gc);

                        //wall between kitchen and bedroom(single brick)
                        //POSITION MUST BE HERE!!!
                        for (int i = 0; i < 2; i++) {
                            gc.drawImage(brickSingleVert, brickSingleVert.getWidth() + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), wallKitchenBedroomHeight + (2 * wallColon.getHeight()) + brickSingleVert.getHeight());
                        }

                        //render the  middle walls
                        //wall between kitchen and livingRoom(draw 4 bricks)
                        for (int i = 0; i < 4; i++) {
                            gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() / 2);
                            gc.drawImage(wallShort, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), (canvas.getHeight() / 2) + brickSingleHorizontal.getHeight());
                            wallKitchenLivingRoomWidth += brickSingleHorizontal.getWidth();
                        }

                        //wall between kitchen, livingRoom, bedroom and bathroom(draw 6 bricks)
                        for (int i = 0; i < 6; i++) {
                            gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() / 2);
                            gc.drawImage(wallShort, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), (canvas.getHeight() / 2) + brickSingleHorizontal.getHeight());
                            wallKitchenLivingRoomBedroomBathroomWidth += brickSingleHorizontal.getWidth();
                        }

                        //wall between bedroom and bathroom(draw 2 bricks)
                        for (int i = 0; i < 2; i++) {
                            gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() / 2);
                            gc.drawImage(wallShort, brickSingleVert.getWidth() + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth + (i * brickSingleHorizontal.getWidth()), (canvas.getHeight() / 2) + brickSingleHorizontal.getHeight());
                        }

                        //wall between living room and bathroom
                        for (int i = 0; i < canvas.getHeight(); i++) {
                            gc.drawImage(brickSingleVert, 2 * (canvas.getWidth() / 3) - brickSingleHorizontal.getWidth(), canvas.getHeight() / 2 + (i * brickSingleVert.getHeight()));
                        }

                        //Render the bricks
                        //Left border
                        for (int i = 0; i < canvas.getHeight() / brickSingleVert.getHeight(); i++) {
                            gc.drawImage(brickSingleVert, 0, i * brickSingleVert.getHeight());
                        }

                        sofa.render(gc);
                        coffeeTable.render(gc);
                        rubberPlant.render(gc);
                        livingDresser.render(gc);
                        livingRoomChair.render(gc);
                        toilet.render(gc);
                        bathroomSink.render(gc);
                        gc.drawImage(siphon, BATHROOM_X + (BATHROOM_WIDTH / 2) - (siphon.getWidth() / 2), BATHROOM_Y + 100);

                        //Player above the middle wall and the obstacles in the low middle part of the screen
                        if (player.bottomBoundary().intersects(0, brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT, canvas.getWidth(), brickSingleHorizontal.getHeight() + LIVINGROOM_HEIGHT + 40)) {
                            player.render(gc);
                        }

                        bathtub.render(gc);
                        tv.render(gc);

                        //Down border
                        for (int i = 0; i < canvas.getWidth() / brickSingleHorizontal.getWidth(); i++) {
                            gc.drawImage(brickSingleHorizontal, brickSingleVert.getWidth() + (i * brickSingleHorizontal.getWidth()), canvas.getHeight() - 2 * brickSingleHorizontal.getHeight());
                        }

                        //Right border
                        for (int i = 0; i < canvas.getHeight() / brickSingleVert.getHeight(); i++) {
                            gc.drawImage(brickSingleVert, canvas.getWidth() - brickSingleVert.getWidth(), i * brickSingleVert.getHeight());
                        }

                        //Display scores on the stats board
                        String pointsText = "Points: " + player.score;
                        gc.fillText(pointsText, canvas.getWidth() - statsBoard.getWidth() + 5, canvas.getLayoutY() + 40);

                        //Display health on stats board
                        String healthText = "Health " + (int) (player.getPlayerHealth()) + "%";

                        gc.fillText(healthText, canvas.getWidth() - statsBoard.getWidth() + 5, canvas.getLayoutY() + 20);

                        monsterCounter.addAndGet(1);
                        if (monsterCounter.get() == 300) {
                            Sprite tempMonster = monsterList.pop();
                            monsterList.addLast(tempMonster);
                            double px = (player.getX() * Math.random() + 100);
                            double py = (player.getY() * Math.random() + 100);
                            tempMonster.setPosition(px, py);
                            monstersToRender.add(tempMonster);
                            monsterCounter.set(0);
                        }

                        for (Sprite monster : monstersToRender) {
                            monster.render(gc);
                        }

                        //Spraying the monsters
                        if (input.contains("SPACE")) {
                            if(!spraying.isPlaying())
                                spraying.play();

                            if("left".equals(direction))
                                player.setSprayImage("img/SprayLeft.gif");
                            if("right".equals(direction))
                                player.setSprayImage("img/SprayRight.gif");
                            if("up".equals(direction))
                                player.setSprayImage("img/SprayUp.gif");
                            if("down".equals(direction))
                                player.setSprayImage("img/SprayDown.gif");

                            Iterator<Sprite> monstersIter = monstersToRender.iterator();
                            while ( monstersIter.hasNext())
                            {
                                Sprite monster = monstersIter.next();

                                if ( player.sprayBoundary().intersects(monster.sprayBoundary())) {
                                    player.score++;
                                    pickup.play();
                                    for (long i = 0; i < 10000000; i++) {
                                        if ( i == 9999999){
                                            monstersIter.remove();
                                        }
                                    }
                                }
                            }
                        }

                        AchievementManager AM = new AchievementManager(player, gc, root);
                        GameMessage GM = new GameMessage(player, root);

                        //Collision with monsters
                        for (Sprite monster : monstersToRender) {
                            if (player.intersects(monster)) {

                                GM.renderMessage("Ouch!", 1000, Color.RED);

                                if((int)player.getPlayerHealth() <= 0)
                                    GM.renderMessage("Bugs owned the house and ate you, Game Over!", 10000000, Color.RED);

                                player.subtractPlayerHealth();

                                if (player.getPlayerHealth() <= 0){
                                    root.getChildren().remove(buttonQuit);
                                    root.getChildren().add(buttonQuit);
                                    root.getChildren().add(buttonStartNewGame);
                                    stop();
                                }

                                AM.observe();
                            }
                        }
                    }
                }.start();
            }
        });
        theStage.show();

        blinkedButton.play();
    }

    private Timeline createBlinker(Node node) {
        Timeline blink = new Timeline(
                new KeyFrame(
                        Duration.seconds(0),
                        new KeyValue(
                                node.opacityProperty(),
                                1,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(0.5),
                        new KeyValue(
                                node.opacityProperty(),
                                0,
                                Interpolator.DISCRETE
                        )
                ),
                new KeyFrame(
                        Duration.seconds(1),
                        new KeyValue(
                                node.opacityProperty(),
                                1,
                                Interpolator.DISCRETE
                        )
                )
        );
        blink.setCycleCount(1000);

        return blink;
    }


    private void playerMove(int x, int y, String direction, int x1, int y1) {
        stepCounter.addAndGet(1);
        //Running
        if (input.contains("SHIFT")) {
            player.addVelocity(x, y);
            if (stepCounter.get() == 5) {
                if (walking.isPlaying()) {
                    walking.stop();
                }
                if (!running.isPlaying()) {
                    if (!mute[0]) {
                        running.play(1, 0, 1.0, 0.0, -5);
                    }
                }
                changeImage(direction);
                stepCounter.set(0);
            }
            //Walking
        }
        player.addVelocity(x1, y1);

        if (stepCounter.get() == 10) {
            if (running.isPlaying()) {
                running.stop();
            }
            if (!walking.isPlaying()) {
                if (!mute[0]) {
                    walking.play(1, 0, 1.2, 0.0, -5);
                }
            }
            changeImage(direction);
            stepCounter.set(0);
        }
        player.hasAlreadyHit = false;
    }

    private void changeImage(String direction) {
        switch (direction) {
            case "down":
                String tempImage = playerDownImages.pop();
                playerDownImages.addLast(tempImage);
                player.setImage(tempImage);
                break;
            case "up":
                String tempImageUp = playerUpImages.pop();
                playerUpImages.addLast(tempImageUp);
                player.setImage(tempImageUp);
                break;
            case "right":
                String tempImageRight = playerRightImages.pop();
                playerRightImages.addLast(tempImageRight);
                player.setImage(tempImageRight);
                break;
            case "left":
                String tempImageLeft = playerLeftImages.pop();
                playerLeftImages.addLast(tempImageLeft);
                player.setImage(tempImageLeft);
                break;
            default:
                break;
        }
    }

    private void checkIfPlayerCollidesUD() {
        //checks if UP or DOWN is already pressed; prevents sound spam
        if (input.contains("UP") || input.contains("DOWN")) {
            player.hasAlreadyHit = true;
        }
        if (!player.hasAlreadyHit) {
            walking.stop();
            running.stop();
            if (!mute[0]) {
                wallHit.play(1);
            }
        }
        player.hasAlreadyHit = true;
        player.addVelocity(0, 0);
    }

    private void checkIfPlayerCollidesLR() {
        //checks if LEFT or RIGHT is already pressed; prevents sound spam
        if (input.contains("LEFT") || input.contains("RIGHT")) {
            player.hasAlreadyHit = true;
        }
        if (!player.hasAlreadyHit) {
            walking.stop();
            running.stop();
            if (!mute[0]) {
                wallHit.play(1);
            }
        }
        player.hasAlreadyHit = true;
        player.addVelocity(0, 0);
    }
}