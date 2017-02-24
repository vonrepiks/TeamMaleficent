package sample.Graphics;

import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import sample.GlobalVariables;

import static sample.Graphics.RoomsParameters.*;
import static sample.Graphics.RoomsParameters.BATHROOM_X;
import static sample.Graphics.RoomsParameters.BATHROOM_Y;

public class GraphicDisplayer {

    public static void displayObjects (){
        //The kitchenDresser object
        Image kitchenDresserImage = new Image("img/kitchenDresser.png", 80, 135, false, false);
        FurnitureObjects.getKitchenDresser().setImage(kitchenDresserImage);
        FurnitureObjects.getKitchenDresser().setPosition(brickSingleVert.getWidth() + 5, 25);

        //The stove object
        Image stoveImage = new Image("img/stove.png", 80, 110, false, false);
        FurnitureObjects.getStove().setImage(stoveImage);
        FurnitureObjects.getStove().setPosition(brickSingleVert.getWidth() + FurnitureObjects.getKitchenDresser().getWidth() + 5, 50);

        //The kitchenSink object
        Image kitchenSinkImage = new Image("img/kitchenSink.png", 80, 120, false, false);
        FurnitureObjects.getKitchenSink().setImage(kitchenSinkImage);
        FurnitureObjects.getKitchenSink().setPosition(FurnitureObjects.getStove().getX() + FurnitureObjects.getStove().getWidth() + 5, 36);

        //The fridge object
        Image fridgeImage = new Image("img/fridge.png", 70, 125, false, false);
        FurnitureObjects.getFridge().setImage(fridgeImage);
        FurnitureObjects.getFridge().setPosition(FurnitureObjects.getKitchenSink().getX() + FurnitureObjects.getKitchenSink().getWidth() + (2 * brickSingleHorizontal.getWidth()) + 20, 30);

        //The kitchenTable object
        Image kitchenTableImage = new Image("img/table_burned_burned.png", 267, 151, false, false);
        FurnitureObjects.getKitchenTable().setImage(kitchenTableImage);
        FurnitureObjects.getKitchenTable().setPosition(30, 199);

        //The sofa object
        Image sofaImage = new Image("img/sofa.png", 240, 140, false, false);
        FurnitureObjects.getSofa().setImage(sofaImage);
        FurnitureObjects.getSofa().setPosition(LIVINGROOM_X + LIVINGROOM_WIDTH - FurnitureObjects.getSofa().getWidth() + 5, LIVINGROOM_Y - 80);

        //The coffeeTable object
        Image coffeeTableImage = new Image("img/coffeeTable.png", 150, 100, false, false);
        FurnitureObjects.getCoffeeTable().setImage(coffeeTableImage);
        FurnitureObjects.getCoffeeTable().setPosition(LIVINGROOM_WIDTH - FurnitureObjects.getCoffeeTable().getWidth() - 70, LIVINGROOM_Y);

        //The livingRoomChair object
        Image livingRoomChairImage = new Image("img/livingChair.png", 150, 100, false, false);
        FurnitureObjects.getLivingRoomChair().setImage(livingRoomChairImage);
        FurnitureObjects.getLivingRoomChair().setPosition(LIVINGROOM_WIDTH - FurnitureObjects.getLivingRoomChair().getWidth() - 20, LIVINGROOM_Y + FurnitureObjects.getLivingRoomChair().getHeight());

        //The livingDresser object
        Image livingDresserImage = new Image("img/dresser.png", 150, 100, false, false);
        FurnitureObjects.getLivingDresser().setImage(livingDresserImage);
        FurnitureObjects.getLivingDresser().setPosition(LIVINGROOM_X + 20, LIVINGROOM_Y - 60);

        //The rubberPlant object
        Image rubberPlantImage = new Image("img/robber plant_burned.png", 65, 90, false, false);
        FurnitureObjects.getRubberPlant().setImage(rubberPlantImage);
        FurnitureObjects.getRubberPlant().setPosition(LIVINGROOM_X + FurnitureObjects.getLivingDresser().getWidth() + 25, LIVINGROOM_Y - 60);

        //The tv object
        Image tvImage = new Image("img/tv.png", 180, 150, false, false);
        FurnitureObjects.getTv().setImage(tvImage);
        FurnitureObjects.getTv().setPosition(LIVINGROOM_X, LIVINGROOM_Y + 130);

        //The desk object
        Image deskImage = new Image("img/desk.png", 180, 140, false, false);
        FurnitureObjects.getDesk().setImage(deskImage);
        FurnitureObjects.getDesk().setPosition(BEDROOM_X + 10, GlobalVariables.getCanvas().getHeight() / 2 - 60);

        //The bed object
        Image bedImage = new Image("img/bed.png", 200, 170, false, false);
        FurnitureObjects.getBed().setImage(bedImage);
        FurnitureObjects.getBed().setPosition(GlobalVariables.getCanvas().getWidth() - bedImage.getWidth() - brickSingleVert.getWidth() - 10, 50);

        //The wardrobe object
        Image wardrobeImage = new Image("img/wardrobe_burned.png", 150, 150, false, false);
        FurnitureObjects.getWardrobe().setImage(wardrobeImage);
        FurnitureObjects.getWardrobe().setPosition(FurnitureObjects.getBed().getX() - FurnitureObjects.getWardrobe().getWidth() - 90, 23);

        //The toilet object
        Image toiletImage = new Image("img/toilet.png", 100, 110, false, false);
        FurnitureObjects.getToilet().setImage(toiletImage);
        FurnitureObjects.getToilet().setPosition(GlobalVariables.getCanvas().getWidth() - FurnitureObjects.getToilet().getWidth() - brickSingleVert.getWidth(), BATHROOM_Y - 70);

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
        Image mainImage = new Image("img/07.jpg", GlobalVariables.getCanvas().getWidth(), GlobalVariables.getCanvas().getHeight(), false, false);
        GlobalVariables.getGraphicContext().drawImage(mainImage, 0, 0);

        //Introduce title
        Font introduce = Font.font(java.awt.Font.DIALOG, 43);
        GlobalVariables.getGraphicContext().setTextAlign(TextAlignment.CENTER);
        GlobalVariables.getGraphicContext().setFont(introduce);
        final Effect glow = new Glow(1.0);
        GlobalVariables.getGraphicContext().setEffect(glow);
        GlobalVariables.getGraphicContext().setFill(Color.CADETBLUE);
        String text = "Team Maleficent introduce Home Entertainment";
        GlobalVariables.getGraphicContext().fillText(text, GlobalVariables.getCanvas().getWidth() / 2, GlobalVariables.getCanvas().getHeight() - 50);
    }
}