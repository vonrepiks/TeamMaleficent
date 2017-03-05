package sample.Graphics;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sample.GlobalVariables;

import static sample.GlobalVariables.*;

public class GraphicDisplayer {

    public static void displayObjects (){
        //The kitchenDresser object
        Image kitchenDresserImage = new Image(
                "img/kitchenDresser.png", 80, 135, false, false);
        FurnitureObjects.getKitchenDresser().setImage(kitchenDresserImage);
        FurnitureObjects.getKitchenDresser().setPosition(brickSingleVert.getWidth() + 5, 25);

        //The stove object
        Image stoveImage = new Image("img/stove.png", 80, 110, false, false);
        FurnitureObjects.getStove().setImage(stoveImage);
        FurnitureObjects.getStove()
                .setPosition(brickSingleVert.getWidth() + FurnitureObjects.getKitchenDresser().getWidth() + 5, 50);

        //The kitchenSink object
        Image kitchenSinkImage = new Image("img/kitchenSink.png", 80, 120, false, false);
        FurnitureObjects.getKitchenSink().setImage(kitchenSinkImage);
        FurnitureObjects.getKitchenSink()
                .setPosition(FurnitureObjects.getStove().getX() + FurnitureObjects.getStove().getWidth() + 5, 36);

        //The fridge object
        Image fridgeImage = new Image("img/fridge.png", 70, 125, false, false);
        FurnitureObjects.getFridge().setImage(fridgeImage);
        FurnitureObjects.getFridge().setPosition(FurnitureObjects.getKitchenSink().getX()
                + FurnitureObjects.getKitchenSink().getWidth() + (2 * brickSingleHorizontal.getWidth()) + 20, 30);

        //The kitchenTable object
        Image kitchenTableImage = new Image(
                "img/table_burned_burned.png", 267, 151, false, false);
        FurnitureObjects.getKitchenTable().setImage(kitchenTableImage);
        FurnitureObjects.getKitchenTable().setPosition(30, 199);

        //The sofa object
        Image sofaImage = new Image("img/sofa.png", 240, 140, false, false);
        FurnitureObjects.getSofa().setImage(sofaImage);
        FurnitureObjects.getSofa()
                .setPosition(LIVING_ROOM_X + LIVING_ROOM_WIDTH - FurnitureObjects.getSofa().getWidth() + 5, LIVING_ROOM_Y - 80);

        //The coffeeTable object
        Image coffeeTableImage = new Image("img/coffeeTable.png", 150, 100, false, false);
        FurnitureObjects.getCoffeeTable().setImage(coffeeTableImage);
        FurnitureObjects.getCoffeeTable().setPosition(LIVING_ROOM_WIDTH - FurnitureObjects.getCoffeeTable().getWidth() - 70, LIVING_ROOM_Y);

        //The livingRoomChair object
        Image livingRoomChairImage = new Image("img/livingChair.png", 150, 100, false, false);
        FurnitureObjects.getLivingRoomChair().setImage(livingRoomChairImage);
        FurnitureObjects.getLivingRoomChair().setPosition(LIVING_ROOM_WIDTH - FurnitureObjects
                .getLivingRoomChair().getWidth() - 20, LIVING_ROOM_Y + FurnitureObjects.getLivingRoomChair().getHeight());

        //The livingDresser object
        Image livingDresserImage = new Image("img/dresser.png", 150, 100, false, false);
        FurnitureObjects.getLivingDresser().setImage(livingDresserImage);
        FurnitureObjects.getLivingDresser().setPosition(LIVING_ROOM_X + 20, LIVING_ROOM_Y - 60);

        //The rubberPlant object
        Image rubberPlantImage = new Image(
                "img/robber plant_burned.png", 65, 90, false, false);
        FurnitureObjects.getRubberPlant().setImage(rubberPlantImage);
        FurnitureObjects.getRubberPlant()
                .setPosition(LIVING_ROOM_X + FurnitureObjects.getLivingDresser().getWidth() + 25, LIVING_ROOM_Y - 60);

        //The tv object
        Image tvImage = new Image("img/tv.png", 180, 150, false, false);
        FurnitureObjects.getTv().setImage(tvImage);
        FurnitureObjects.getTv().setPosition(LIVING_ROOM_X, LIVING_ROOM_Y + 130);

        //The desk object
        Image deskImage = new Image("img/desk.png", 180, 140, false, false);
        FurnitureObjects.getDesk().setImage(deskImage);
        FurnitureObjects.getDesk().setPosition(BEDROOM_X + 10, GlobalVariables.getCanvas().getHeight() / 2 - 60);

        //The bed object
        Image bedImage = new Image("img/bed.png", 200, 170, false, false);
        FurnitureObjects.getBed().setImage(bedImage);
        FurnitureObjects.getBed().setPosition(GlobalVariables.getCanvas()
                .getWidth() - bedImage.getWidth() - brickSingleVert.getWidth() - 10, 50);

        //The wardrobe object
        Image wardrobeImage = new Image("img/wardrobe_burned.png", 150, 150, false, false);
        FurnitureObjects.getWardrobe().setImage(wardrobeImage);
        FurnitureObjects.getWardrobe().setPosition(FurnitureObjects.getBed().getX() - FurnitureObjects.getWardrobe().getWidth() - 90, 23);

        //The toilet object
        Image toiletImage = new Image("img/toilet.png", 100, 110, false, false);
        FurnitureObjects.getToilet().setImage(toiletImage);
        FurnitureObjects.getToilet().setPosition(GlobalVariables.getCanvas()
                .getWidth() - FurnitureObjects.getToilet().getWidth() - brickSingleVert.getWidth(), BATHROOM_Y - 70);

        //The bathtub object
        Image bathtubImage = new Image("img/bathtub.png", BATHROOM_WIDTH - 50, 170, false, false);
        FurnitureObjects.getBathtub().setImage(bathtubImage);
        FurnitureObjects.getBathtub().setPosition(BATHROOM_X + 30, BATHROOM_Y + 120);

        //The bathroomSink object
        Image sinkImage = new Image("img/sink.png", 110, 130, false, false);
        FurnitureObjects.getBathroomSink().setImage(sinkImage);
        FurnitureObjects.getBathroomSink().setPosition(BATHROOM_X + 10, BATHROOM_Y - 70);
    }

    public static void displayIntroduce() {
        Image mainImage = new Image("img/07.jpg", GlobalVariables.getCanvas()
                .getWidth(), GlobalVariables.getCanvas().getHeight(), false, false);
        GlobalVariables.getGraphicContext().drawImage(mainImage, 0, 0);

        //Introduce title
        Font introduce = Font.font(java.awt.Font.DIALOG, 43);
        GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.CENTER);
        GlobalVariables.getGraphicContext().setFont(introduce);
        final Effect glow = new Glow(1.0);
        GlobalVariables.getGraphicContext().setEffect(glow);
        GlobalVariables.getGraphicContext().setFill(Color.CADETBLUE);
        String text = "Team Maleficent introduce Home Entertainment";
        GlobalVariables.getGraphicContext()
                .fillText(text, GlobalVariables.getCanvas().getWidth() / 2, GlobalVariables.getCanvas().getHeight() - 50);
    }

    public static void drawWalls() {
        // Render the image objects
        double doorWidth = 2 * brickSingleHorizontal.getWidth();
        double wallKitchenLivingRoomWidth = 0;
        double wallKitchenLivingRoomBedroomBathroomWidth = 0;
        double wallUpBorder1 = 0;
        double wallKitchenBedroomHeight = 0;

        //Draw pavements of different rooms
        GlobalVariables.getGraphicContext().clearRect(0, 0, 1024, 768);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getParquet(), KITCHEN_X, KITCHEN_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getParquet(), KITCHEN_X, KITCHEN_Y + KITCHEN_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getCarpet2(), BEDROOM_X, BEDROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getCarpet2(), BEDROOM_X, BEDROOM_Y + BEDROOM_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getTiles(), BATHROOM_X, BATHROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getTiles(), BATHROOM_X, BATHROOM_Y + BATHROOM_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getCarpet(), LIVING_ROOM_X, LIVING_ROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getCarpet(), LIVING_ROOM_X + LIVING_ROOM_WIDTH / 2, LIVING_ROOM_Y);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getCarpet(), LIVING_ROOM_X, LIVING_ROOM_Y + LIVING_ROOM_HEIGHT / 2);
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getCarpet(),
                LIVING_ROOM_X + LIVING_ROOM_WIDTH / 2, LIVING_ROOM_Y + LIVING_ROOM_HEIGHT / 2);

        //Draw upper walls and bricks
        //Upper border
        for (int i = 0; i < 4; i++) {
            GlobalVariables.getGraphicContext().drawImage(wallShort, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight());
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), 0);
            wallUpBorder1 += brickSingleHorizontal.getWidth();
        }

        for (int i = 0; i < GlobalVariables.getCanvas().getWidth() / brickSingleHorizontal.getWidth(); i++) {
            GlobalVariables.getGraphicContext().drawImage(wallShort, brickSingleVert.getWidth()
                    + wallUpBorder1 + doorWidth + (i * brickSingleHorizontal.getWidth()), brickSingleHorizontal.getHeight());
            //Stats board
            GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getStatsBoard(), GlobalVariables.getCanvas().getWidth() - 240, 3);
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + wallUpBorder1 + doorWidth + (i * brickSingleHorizontal.getWidth()), 0);
        }
        //wall between kitchen and bedroom
        for (int i = 0; i < 3; i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleVert, brickSingleVert.getWidth()
                    + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), i * brickSingleVert.getHeight());
            wallKitchenBedroomHeight += brickSingleVert.getHeight();
        }

        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(wallColon, brickSingleVert.getWidth() + wallUpBorder1
                    + doorWidth + (2 * brickSingleHorizontal.getWidth()), wallKitchenBedroomHeight + (i * wallColon.getHeight()));
        }

        FurnitureObjects.getKitchenDresser().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getStove().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getKitchenSink().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getFridge().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getKitchenTable().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getWardrobe().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getBed().render(GlobalVariables.getGraphicContext());

        //Draw the player if it`s in the first half of the screen(above the top walls and behind the middle walls)
        if (GlobalVariables.getPlayer().bottomBoundary().intersects(0, 0, GlobalVariables.getCanvas().getWidth(),
                brickSingleHorizontal.getHeight() + wallShort.getHeight() + KITCHEN_HEIGHT)) {
            GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
        }

        FurnitureObjects.getDesk().render(GlobalVariables.getGraphicContext());

        //wall between kitchen and bedroom(single brick)
        //POSITION MUST BE HERE!!!
        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleVert, brickSingleVert.getWidth()
                    + wallUpBorder1 + doorWidth + (2 * brickSingleHorizontal.getWidth()), wallKitchenBedroomHeight
                    + (2 * wallColon.getHeight()) + brickSingleVert.getHeight());
        }

        //render the  middle walls
        //wall between kitchen and livingRoom(draw 4 bricks)
        for (int i = 0; i < 4; i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), GlobalVariables.getCanvas().getHeight() / 2);
            GlobalVariables.getGraphicContext().drawImage(wallShort, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), (GlobalVariables.getCanvas().getHeight() / 2)
                    + brickSingleHorizontal.getHeight());
            wallKitchenLivingRoomWidth += brickSingleHorizontal.getWidth();
        }

        //wall between kitchen, livingRoom, bedroom and bathroom(draw 6 bricks)
        for (int i = 0; i < 6; i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth
                    + (i * brickSingleHorizontal.getWidth()), GlobalVariables.getCanvas().getHeight() / 2);
            GlobalVariables.getGraphicContext().drawImage(wallShort, brickSingleVert.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth
                    + (i * brickSingleHorizontal.getWidth()), (GlobalVariables.getCanvas().getHeight() / 2)
                    + brickSingleHorizontal.getHeight());
            wallKitchenLivingRoomBedroomBathroomWidth += brickSingleHorizontal.getWidth();
        }

        //wall between bedroom and bathroom(draw 2 bricks)
        for (int i = 0; i < 2; i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth + doorWidth
                    + (i * brickSingleHorizontal.getWidth()), GlobalVariables.getCanvas().getHeight() / 2);
            GlobalVariables.getGraphicContext().drawImage(wallShort, brickSingleVert.getWidth()
                    + wallKitchenLivingRoomWidth + doorWidth + wallKitchenLivingRoomBedroomBathroomWidth
                    + doorWidth + (i * brickSingleHorizontal.getWidth()), (GlobalVariables.getCanvas().getHeight() / 2)
                    + brickSingleHorizontal.getHeight());
        }

        //wall between living room and bathroom
        for (int i = 0; i < GlobalVariables.getCanvas().getHeight(); i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleVert, 2 * (GlobalVariables.getCanvas().getWidth() / 3)
                    - brickSingleHorizontal.getWidth(), GlobalVariables.getCanvas().getHeight() / 2 + (i * brickSingleVert.getHeight()));
        }

        //Render the bricks
        //Left border
        for (int i = 0; i < GlobalVariables.getCanvas().getHeight() / brickSingleVert.getHeight(); i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleVert, 0, i * brickSingleVert.getHeight());
        }

        FurnitureObjects.getSofa().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getCoffeeTable().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getRubberPlant().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getLivingDresser().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getLivingRoomChair().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getToilet().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getBathroomSink().render(GlobalVariables.getGraphicContext());
        GlobalVariables.getGraphicContext().drawImage(ImageDefiner.getSiphon(), BATHROOM_X + (BATHROOM_WIDTH / 2)
                - (ImageDefiner.getSiphon().getWidth() / 2), BATHROOM_Y + 100);

        //Player above the middle wall and the obstacles in the low middle part of the screen
        if (GlobalVariables.getPlayer().bottomBoundary().intersects(0, brickSingleHorizontal.getHeight() + wallShort.getHeight()
                + KITCHEN_HEIGHT, GlobalVariables.getCanvas().getWidth(), brickSingleHorizontal.getHeight() + LIVING_ROOM_HEIGHT + 40)) {
            GlobalVariables.getPlayer().render(GlobalVariables.getGraphicContext());
        }

        FurnitureObjects.getBathtub().render(GlobalVariables.getGraphicContext());
        FurnitureObjects.getTv().render(GlobalVariables.getGraphicContext());

        //Down border
        for (int i = 0; i < GlobalVariables.getCanvas().getWidth() / brickSingleHorizontal.getWidth(); i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), GlobalVariables.getCanvas().getHeight()
                    - 2 * brickSingleHorizontal.getHeight());
        }

        /*for (int i = 0; i < 4; i++) {
            GlobalVariables.getGraphicContext().drawImage(wallShort, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), (GlobalVariables.getCanvas().getHeight())
                    - 2 * brickSingleHorizontal.getHeight());
            GlobalVariables.getGraphicContext().drawImage(brickSingleHorizontal, brickSingleVert.getWidth()
                    + (i * brickSingleHorizontal.getWidth()), GlobalVariables.getCanvas().getHeight()
                    - 2 * brickSingleHorizontal.getHeight());
            //wallKitchenLivingRoomWidth += brickSingleHorizontal.getWidth();
        }*/

        //Right border
        for (int i = 0; i < GlobalVariables.getCanvas().getHeight() / brickSingleVert.getHeight(); i++) {
            GlobalVariables.getGraphicContext().drawImage(brickSingleVert, GlobalVariables.getCanvas().getWidth()
                    - brickSingleVert.getWidth(), i * brickSingleVert.getHeight());
        }

        //Display scores on the stats board
        String pointsText = "Points: " + GlobalVariables.getPlayer().score;
        GlobalVariables.getGraphicContext().fillText(pointsText, GlobalVariables.getCanvas().getWidth()
                - ImageDefiner.getStatsBoard().getWidth() + 5, GlobalVariables.getCanvas().getLayoutY() + 40);

        //Display health on stats board
        String healthText = "Health " + (int) (GlobalVariables.getPlayer().getPlayerHealth()) + "%";

        GlobalVariables.getGraphicContext().fillText(healthText, GlobalVariables.getCanvas().getWidth()
                - ImageDefiner.getStatsBoard().getWidth() + 5, GlobalVariables.getCanvas().getLayoutY() + 20);
    }
}