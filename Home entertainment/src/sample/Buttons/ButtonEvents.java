package sample.Buttons;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import sample.Enemy.Monsters;
import sample.GlobalVariables;
import sample.Graphics.FurnitureObjects;
import sample.Graphics.GraphicDisplayer;
import sample.Graphics.ImageDefiner;
import sample.Main;
import sample.Player.Player;
import sample.Player.Sprite;
import java.util.concurrent.atomic.AtomicInteger;

import static sample.GlobalVariables.*;

public class ButtonEvents {

    public static void attachSoundButtonEvent() {
        ButtonManager.getButtonSound().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (GlobalVariables.getMute()[0]) {
                    ButtonManager.getImageSound()[0] = new Image(
                            "img/soundOn.png", 30, 30, false, false);
                    ButtonManager.getButtonSound().setGraphic(new ImageView(ButtonManager.getImageSound()[0]));
                    ButtonManager.getMenuSoundText1().setText("Sound ON");
                    GlobalVariables.setMute(false);
                } else {
                    ButtonManager.getImageSound()[0] = new Image(
                            "img/soundOff.png", 30, 30, false, false);
                    ButtonManager.getButtonSound().setGraphic(new ImageView(ButtonManager.getImageSound()[0]));
                    ButtonManager.getMenuSoundText1().setText("Sound OFF");
                    GlobalVariables.setMute(true);
                }
            }
        });
    }

    public static void attachCloseButtonEvent() {
        ButtonManager.getButtonClose().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (ButtonManager.getIsMainWindow()[0]) {
                    GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonMenu());
                } else {
                    GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonQuit());
                }
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenu());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonClose());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuTitle());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuSoundText1());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuSoundText2());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonSound());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getKeyboardGuideTitle());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getKeyboardGuide());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonStartNewGame());
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonResume());
            }
        });
    }

    public static void attachButtonMenuAction() {
        ButtonManager.getButtonMenu().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonMenu());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenu());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenuTitle());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenuSoundText1());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenuSoundText2());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getKeyboardGuideTitle());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getKeyboardGuide());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonSound());
                GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonClose());
            }
        });
    }

    public static void attachButtonQuitAction(Stage theStage) {
        ButtonManager.getButtonQuit().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                theStage.close();
            }
        });
    }

    public static void attachButtonStartAction(Stage theStage) {
        ButtonManager.getButtonStart().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ButtonManager.getIsMainWindow()[0] = false;

                //Prepare the score text
                Font scoreFont = Font.font("Arial", FontWeight.NORMAL, 20);
                GlobalVariables.getGraphicContext().setFont(scoreFont);
                GlobalVariables.getGraphicContext().setStroke(Color.BLACK);
                GlobalVariables.getGraphicContext().setLineWidth(1);
                GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.LEFT);

                final Long[] lastNanoTime = {System.nanoTime()};
                GlobalVariables.setStepCounter(new AtomicInteger(0));
                AtomicInteger monsterCounter = new AtomicInteger(0);

                //The animation begins
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {
                        // calculate time since last update.
                        double elapsedTime = (currentNanoTime - lastNanoTime[0]) / 1000000000.0;
                        lastNanoTime[0] = currentNanoTime;

                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonStart());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonMenu());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonQuit());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenu());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonClose());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuTitle());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuSoundText1());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuSoundText2());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonSound());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getKeyboardGuideTitle());
                        GlobalVariables.getRoot().getChildren().remove(ButtonManager.getKeyboardGuide());

                        GlobalVariables.getGraphicContext().setEffect(null);

                        Rectangle2D wardrobeBoundary = FurnitureObjects.getWardrobe().getBoundary();
                        Rectangle2D stoveBoundary = FurnitureObjects.getStove().getBoundary();
                        Rectangle2D kitchenDresserBoundary = FurnitureObjects.getKitchenDresser().getBoundary();
                        Rectangle2D kitchenSinkBoundary = FurnitureObjects.getKitchenSink().getBoundary();
                        Rectangle2D kitchenTableBoundary = FurnitureObjects.getKitchenTable().getBoundary();
                        Rectangle2D fridgeBoundary = FurnitureObjects.getFridge().getBoundary();
                        Rectangle2D livingRoomChairBoundary = FurnitureObjects.getLivingRoomChair().getBoundary();
                        Rectangle2D coffeeTableBoundary = FurnitureObjects.getCoffeeTable().getBoundary();
                        Rectangle2D bedBoundary = FurnitureObjects.getBed().getBoundary();

                        //Button start new game
                        ButtonManager.getButtonStartNewGame().setPrefHeight(50);
                        ButtonManager.getButtonStartNewGame().setPrefWidth(150);
                        ButtonManager.getButtonStartNewGame().setLayoutX((GlobalVariables.getCanvas().getWidth()
                                - (3 * ButtonManager.getButtonMenu().getPrefWidth()) - (2 * 50)) / 2 + 15);
                        ButtonManager.getButtonStartNewGame().setLayoutY(GlobalVariables.getCanvas().getHeight() - 180);
                        ButtonManager.getButtonStartNewGame().setStyle("-fx-font: 22 arial");

                        ButtonManager.getButtonStartNewGame().setOnAction(__ ->
                        {
                            theStage.close();
                            Platform.runLater(() -> new Main().start(new Stage()));
                        });

                        //Button Resume game
                        ButtonManager.getButtonResume().setPrefHeight(50);
                        ButtonManager.getButtonResume().setPrefWidth(150);
                        ButtonManager.getButtonResume().setLayoutX(ButtonManager.getButtonMenu().getLayoutX()
                                + ButtonManager.getButtonMenu().getPrefWidth() + 50);
                        ButtonManager.getButtonResume().setLayoutY(GlobalVariables.getCanvas().getHeight() - 180);
                        ButtonManager.getButtonResume().setStyle("-fx-font: 22 arial");

                        //Button Pause game
                        Button pause = new Button("Pause");
                        pause.setPrefHeight(50);
                        pause.setPrefWidth(150);
                        pause.setLayoutX(ButtonManager.getButtonMenu().getLayoutX() + ButtonManager.getButtonMenu().getPrefWidth() + 50);
                        pause.setLayoutY(ButtonManager.getButtonResume().getLayoutY() - 20 - ButtonManager.getButtonResume().getPrefHeight());
                        pause.setStyle("-fx-font: 22 arial");

                        ButtonManager.getButtonResume().setOnAction(new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenu());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonClose());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuTitle());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuSoundText1());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getMenuSoundText2());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonSound());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getKeyboardGuideTitle());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getKeyboardGuide());
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonResume());
                                GlobalVariables.getRoot().getChildren().remove(pause);
                                GlobalVariables.getRoot().getChildren().remove(ButtonManager.getButtonStartNewGame());

                                start();
                            }
                        });

                        //show menu
                        if (GlobalVariables.getInput().contains("ESCAPE")) {
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenu());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenuTitle());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenuSoundText1());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getMenuSoundText2());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonSound());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getKeyboardGuideTitle());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getKeyboardGuide());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonQuit());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonResume());
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonStartNewGame());

                            stop();
                        }

                        //Pause control
                        if (GlobalVariables.getInput().contains("P")) {
                            GlobalVariables.getRoot().getChildren().add(pause);
                            GlobalVariables.getRoot().getChildren().add(ButtonManager.getButtonResume());
                            stop();
                        }

                        // Player movement
                        GlobalVariables.getPlayer().setVelocity(0, 0);
                        if (GlobalVariables.getInput().contains("LEFT") && !GlobalVariables.getInput().contains("SPACE")) {
                            if (GlobalVariables.getPlayer().leftBoundary().intersects(kitchenSinkBoundary) ||
                                    GlobalVariables.getPlayer().leftBoundary().intersects(kitchenTableBoundary) ||
                                    GlobalVariables.getPlayer().leftBoundary().intersects(wardrobeBoundary) ||
                                    GlobalVariables.getPlayer().leftBoundary().intersects(livingRoomChairBoundary) ||
                                    GlobalVariables.getPlayer().leftBoundary().intersects(fridgeBoundary) ||
                                    GlobalVariables.getPlayer().leftBoundary().intersects(FurnitureObjects.getDesk()
                                            .getX(), FurnitureObjects.getDesk().getY() + 40, FurnitureObjects.getDesk()
                                            .getWidth(), FurnitureObjects.getDesk().getHeight()) || //desk
                                    GlobalVariables.getPlayer().leftBoundary().intersects(FurnitureObjects.getToilet()
                                            .getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getToilet().getWidth(), 50) || //toilet
                                    GlobalVariables.getPlayer().leftBoundary().intersects(FurnitureObjects.getBathtub()
                                            .getX(), FurnitureObjects.getBathtub().getY() + 100, FurnitureObjects
                                            .getBathtub().getWidth(), FurnitureObjects.getBathtub().getHeight()) || //bathtub
                                    GlobalVariables.getPlayer().leftBoundary().intersects(FurnitureObjects.getBathroomSink()
                                            .getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getBathroomSink().getWidth(), 70) || //bathroom sink
                                    GlobalVariables.getPlayer().leftBoundary().intersects(FurnitureObjects.getRubberPlant()
                                            .getX(), LIVING_ROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getRubberPlant().getWidth(), ImageDefiner.getCarpet()
                                            .getHeight() / 4 + brickSingleHorizontal.getHeight()) || //rubber plant
                                    GlobalVariables.getPlayer().leftBoundary().intersects(FurnitureObjects.getTv()
                                            .getX(), FurnitureObjects.getTv().getY() + 100, FurnitureObjects
                                            .getTv().getWidth(), FurnitureObjects.getTv().getHeight()) || //tv
                                    GlobalVariables.getPlayer().leftBoundary().intersects(BEDROOM_X - brickSingleVert
                                            .getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert
                                            .getHeight()) + (2 * wallColon.getHeight())) || // wall between kitchen and bedroom
                                    GlobalVariables.getPlayer().leftBoundary().intersects(0, 0, brickSingleVert
                                            .getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal
                                            .getHeight() + wallShort.getHeight()) || //upper wall left from entrance
                                    GlobalVariables.getPlayer().leftBoundary().intersects(0, 0, brickSingleVert
                                            .getWidth(), GlobalVariables.getCanvas().getHeight() + wallShort.getHeight()) || //left border
                                    GlobalVariables.getPlayer().leftBoundary().intersects(brickSingleVert
                                            .getWidth(), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight(), 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between kitchen and living room
                                    GlobalVariables.getPlayer().leftBoundary().intersects(brickSingleVert
                                            .getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between every rooms
                                    GlobalVariables.getPlayer().leftBoundary().intersects(BEDROOM_X - brickSingleVert
                                            .getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon
                                            .getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert
                                            .getWidth(), brickSingleVert.getHeight() * 2) || // wall between kitchen and bedroom(one brick)
                                    GlobalVariables.getPlayer().leftBoundary().intersects(BATHROOM_X - brickSingleVert
                                            .getWidth(), BATHROOM_Y, brickSingleVert
                                            .getWidth(), BATHROOM_HEIGHT + 40)) { //wall between living room and bathroom

                                Player.checkIfPlayerCollidesUD();

                            } else {
                                GlobalVariables.setDirection("left");
                                Player.move(-180, 0, GlobalVariables.getDirection(), -90, 0);
                            }
                        }
                        if (GlobalVariables.getInput().contains("RIGHT") && !GlobalVariables.getInput().contains("SPACE")) {
                            if (GlobalVariables.getPlayer().rightBoundary().intersects(fridgeBoundary) ||
                                    GlobalVariables.getPlayer().rightBoundary().intersects(bedBoundary) ||
                                    GlobalVariables.getPlayer().rightBoundary().intersects(livingRoomChairBoundary) ||
                                    GlobalVariables.getPlayer().rightBoundary().intersects(FurnitureObjects.getDesk()
                                            .getX(), FurnitureObjects.getDesk().getY() + 40, FurnitureObjects.getDesk()
                                            .getWidth(), FurnitureObjects.getDesk().getHeight()) || //desk
                                    GlobalVariables.getPlayer().rightBoundary().intersects(FurnitureObjects.getBathtub()
                                            .getX(), FurnitureObjects.getBathtub().getY() + 100, FurnitureObjects.getBathtub()
                                            .getWidth(), FurnitureObjects.getBathtub().getHeight()) || //bathtub
                                    GlobalVariables.getPlayer().rightBoundary().intersects(FurnitureObjects.getToilet()
                                            .getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getToilet().getWidth(), 50) || //toilet
                                    GlobalVariables.getPlayer().rightBoundary().intersects(FurnitureObjects.getCoffeeTable()
                                            .getX(), FurnitureObjects.getCoffeeTable().getY(), FurnitureObjects.getCoffeeTable()
                                            .getWidth(), 3 * (ImageDefiner.getCarpet().getHeight() / 4) - 30) || // coffee table
                                    GlobalVariables.getPlayer().rightBoundary().intersects(FurnitureObjects.getSofa()
                                            .getX(), LIVING_ROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getSofa().getWidth(), ImageDefiner.getCarpet()
                                            .getHeight() / 2 + (2 * brickSingleHorizontal.getHeight())) || // sofa
                                    GlobalVariables.getPlayer().rightBoundary().intersects(BEDROOM_X - brickSingleVert
                                            .getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert
                                            .getHeight()) + (2 * wallColon.getHeight())) || // wall between kitchen and bedroom
                                    GlobalVariables.getPlayer().rightBoundary().intersects(brickSingleVert.getWidth()
                                            + (6 * brickSingleHorizontal.getWidth()), 0, 10 * brickSingleHorizontal
                                            .getWidth(), brickSingleHorizontal.getHeight()
                                            + wallShort.getHeight()) || //upper wall right from entrance
                                    GlobalVariables.getPlayer().rightBoundary().intersects(GlobalVariables.getCanvas()
                                            .getWidth() - brickSingleVert.getWidth(), 0, brickSingleVert
                                            .getWidth(), GlobalVariables.getCanvas().getHeight() + 40) || //right border
                                    GlobalVariables.getPlayer().rightBoundary().intersects(brickSingleVert.getWidth()
                                            + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal
                                            .getHeight(), 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between bedroom and bathroom
                                    GlobalVariables.getPlayer().rightBoundary().intersects(brickSingleVert.getWidth()
                                            + (6 * brickSingleHorizontal.getWidth()), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between every rooms
                                    GlobalVariables.getPlayer().rightBoundary().intersects(BEDROOM_X - brickSingleVert
                                            .getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon
                                            .getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert
                                            .getWidth(), brickSingleVert.getHeight() * 2) || // wall between kitchen and bedroom(one brick)
                                    GlobalVariables.getPlayer().rightBoundary().intersects(BATHROOM_X - brickSingleVert
                                            .getWidth(), BATHROOM_Y, brickSingleVert
                                            .getWidth(), BATHROOM_HEIGHT + 40)) { //wall between living room and bathroom

                                Player.checkIfPlayerCollidesUD();
                            } else {
                                GlobalVariables.setDirection("right");
                                Player.move(180, 0, GlobalVariables.getDirection(), 90, 0);
                            }
                        }
                        if (GlobalVariables.getInput().contains("UP") && !GlobalVariables.getInput().contains("SPACE")) {
                            if (GlobalVariables.getPlayer().upperBoundary().intersects(kitchenDresserBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(kitchenSinkBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(kitchenTableBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(fridgeBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(wardrobeBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(stoveBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(coffeeTableBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(bedBoundary) ||
                                    GlobalVariables.getPlayer().upperBoundary().intersects(livingRoomChairBoundary) ||
                                    GlobalVariables.getPlayer().rightBoundary().intersects(FurnitureObjects.getToilet()
                                            .getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getToilet().getWidth(), 50) || //toilet
                                    GlobalVariables.getPlayer().upperBoundary().intersects(FurnitureObjects.getBathroomSink()
                                            .getX(), BATHROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getBathroomSink().getWidth(), 70) || //bathroom sink
                                    GlobalVariables.getPlayer().upperBoundary().intersects(FurnitureObjects.getSofa()
                                            .getX(), LIVING_ROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getSofa().getWidth(), ImageDefiner.getCarpet().getHeight() / 2
                                            + (2 * brickSingleHorizontal.getHeight())) || // sofa
                                    GlobalVariables.getPlayer().upperBoundary().intersects(FurnitureObjects.getLivingDresser()
                                            .getX(), LIVING_ROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getLivingDresser().getWidth(), ImageDefiner.getCarpet().getHeight() / 4
                                            + brickSingleHorizontal.getHeight()) || //living room dresser
                                    GlobalVariables.getPlayer().upperBoundary().intersects(FurnitureObjects.getRubberPlant()
                                            .getX(), LIVING_ROOM_Y - brickSingleHorizontal.getHeight(), FurnitureObjects
                                            .getRubberPlant().getWidth(), ImageDefiner.getCarpet().getHeight() / 4
                                            + brickSingleHorizontal.getHeight()) || //rubber plant
                                    GlobalVariables.getPlayer().upperBoundary().intersects(0, 0, brickSingleVert
                                            .getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal
                                            .getHeight()) || //upper wall right from entrance
                                    GlobalVariables.getPlayer().upperBoundary().intersects(brickSingleVert
                                            .getWidth() + (6 * brickSingleHorizontal.getWidth()), wallShort
                                            .getHeight(), 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //upper wall right from entrance
                                    GlobalVariables.getPlayer().upperBoundary().intersects(brickSingleVert
                                            .getWidth(), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight(), 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between kitchen and living room
                                    GlobalVariables.getPlayer().upperBoundary().intersects(brickSingleVert
                                            .getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight(), 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between every rooms
                                    GlobalVariables.getPlayer().upperBoundary().intersects(brickSingleVert
                                            .getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal
                                            .getHeight(), 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between bedroom and bathroom
                                    GlobalVariables.getPlayer().upperBoundary().intersects(BEDROOM_X - brickSingleVert
                                            .getWidth(), 0, brickSingleVert.getWidth(), (3 * brickSingleVert
                                            .getHeight()) + (2 * wallColon.getHeight()))) { //wall between kitchen and bedroom

                                Player.checkIfPlayerCollidesLR();
                            } else {
                                GlobalVariables.setDirection("up");
                                Player.move(0, -180, GlobalVariables.getDirection(), 0, -90);
                            }
                        }
                        if (GlobalVariables.getInput().contains("DOWN") && !GlobalVariables.getInput().contains("SPACE")) {
                            if (GlobalVariables.getPlayer().bottomBoundary().intersects(kitchenTableBoundary) ||
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(livingRoomChairBoundary) ||
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(FurnitureObjects.getDesk()
                                            .getX(), FurnitureObjects.getDesk().getY() + 40, FurnitureObjects.getDesk()
                                            .getWidth(), FurnitureObjects.getDesk().getHeight()) || //desk
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(FurnitureObjects.getTv()
                                            .getX(), FurnitureObjects.getTv().getY() + 100, FurnitureObjects.getTv()
                                            .getWidth(), FurnitureObjects.getTv().getHeight()) || //tv
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(FurnitureObjects.getBathtub()
                                            .getX(), FurnitureObjects.getBathtub().getY() + 100, FurnitureObjects.getBathtub()
                                            .getWidth(), FurnitureObjects.getBathtub().getHeight()) || //bathtub
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(0, 0, brickSingleVert
                                            .getWidth() + (4 * brickSingleHorizontal.getWidth()), brickSingleHorizontal
                                            .getHeight() + wallShort.getHeight()) || //upper wall right from entrance
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(brickSingleVert
                                            .getWidth() + (6 * brickSingleHorizontal.getWidth()), 0, 10 * brickSingleHorizontal
                                            .getWidth(), brickSingleHorizontal.getHeight() + wallShort
                                            .getHeight()) || //upper wall right from entrance
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(brickSingleVert
                                            .getWidth(), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight() - 5, 4 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between kitchen and living room
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(brickSingleVert
                                            .getWidth() + (6 * brickSingleHorizontal.getWidth()), LIVING_ROOM_Y - brickSingleHorizontal
                                            .getHeight() - 5, 6 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between every rooms
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(brickSingleVert
                                            .getWidth() + (14 * brickSingleHorizontal.getWidth()), BATHROOM_Y - brickSingleHorizontal
                                            .getHeight() - 5, 2 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //wall between bedroom and bathroom
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(0, GlobalVariables.getCanvas()
                                            .getHeight() - 10, GlobalVariables.getCanvas().getWidth(), brickSingleHorizontal
                                            .getHeight()) || //down border
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(0, wallShort
                                            .getHeight(), brickSingleVert.getWidth() + (4 * brickSingleHorizontal
                                            .getWidth()), brickSingleHorizontal.getHeight()) || //upper wall left from entrance
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(brickSingleVert
                                            .getWidth() + (6 * brickSingleHorizontal.getWidth()), wallShort
                                            .getHeight(), 10 * brickSingleHorizontal.getWidth(), brickSingleHorizontal
                                            .getHeight()) || //upper wall right from entrance
                                    GlobalVariables.getPlayer().bottomBoundary().intersects(BEDROOM_X - brickSingleVert
                                            .getWidth(), (3 * brickSingleVert.getHeight()) + (2 * wallColon
                                            .getHeight()) + brickSingleVert.getHeight() + 40, brickSingleVert
                                            .getWidth(), brickSingleVert.getHeight() * 2)) { // wall between kitchen and bedroom(one brick)

                                Player.checkIfPlayerCollidesLR();
                            } else {
                                GlobalVariables.setDirection("down");
                                Player.move(0, 180, GlobalVariables.getDirection(), 0, 90);
                            }
                        }
                        //Stops sound effects while standing in place
                        if ((!GlobalVariables.getInput().contains("LEFT") && !GlobalVariables.getInput()
                                .contains("RIGHT") && !GlobalVariables.getInput().contains("UP") && !GlobalVariables.getInput()
                                .contains("DOWN")) || GlobalVariables.getInput().contains("SPACE")) {
                            GlobalVariables.getWalking().stop();
                            GlobalVariables.getRunning().stop();
                        }
                        GlobalVariables.getPlayer().update(elapsedTime);

                        // draw obstacles
                        GraphicDisplayer.drawWalls();

                        // show monsters
                        monsterCounter.addAndGet(1);
                        if (monsterCounter.get() == 300) {
                            Sprite tempMonster = GlobalVariables.getMonsterList().pop();
                            GlobalVariables.getMonsterList().addLast(tempMonster);
                            double px = (GlobalVariables.getPlayer().getX() * Math.random() + 100);
                            double py = (GlobalVariables.getPlayer().getY() * Math.random() + 100);
                            tempMonster.setPosition(px, py);
                            GlobalVariables.getMonstersToRender().add(tempMonster);
                            monsterCounter.set(0);
                        }

                        for (Sprite monster : GlobalVariables.getMonstersToRender()) {
                            monster.render(GlobalVariables.getGraphicContext());
                        }

                        //Spraying the monsters
                        Player.sprayMonsters();

                        // Check collision with monsters
                        Monsters.checkCollision(this);

                    }
                }.start();
            }
        });
    }
}