import processing.core.PApplet;
import processing.core.PImage;
import processing.data.StringList;

import java.util.ArrayList;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    BackgroundSystem backgroundSystem = new BackgroundSystem(this);
    ArrayList<Button> buttList = new ArrayList<>();
    ArrayList<Players> playerList = new ArrayList<>();
    ArrayList<Deck> deckList = new ArrayList<>();
    //ArrayList<PImage> RoomImages = new ArrayList<>();
    //ArrayList<PImage> TreasureImages = new ArrayList<>();
    Deck roomdisc = new Deck(this,700, 270, 90, 150);
    Deck treasiredisc = new Deck(this,1090, 270, 90, 150);
    Deck room = new Deck(this,830, 270, 90, 150);
    Deck treasure = new Deck(this,960, 270, 90, 150);
    StringList RoomList = new StringList();
    StringList TreasureList = new StringList();
    Dice dice = new Dice(this);
    Database database = new Database(this);
    Menus menus = new Menus(this);
    int screenchange = 0;
    ImageLoader imageLoader = new ImageLoader(this);
    Board board;
    Rules rules = new Rules(this);

    @Override
    public void settings() {
        super.settings();
        size(1920, 1080);
        println(dataPath("test.db"));
    }

    @Override
    public void setup() {
        super.setup();
        imageLoader.loadImage();
        database.setups();
        database.LoadCards(RoomList, TreasureList);
        backgroundSystem.loaddecks(room, treasure, RoomList, TreasureList);
    }

    @Override
    public void draw() {
        clear();
        if (screenchange == 0) {
            menus.mainMenu(buttList, imageLoader);
        }
        if (screenchange == 1) {
            if (menus.notdoneyet)
                board = new Board(this, 4);
            menus.ingame(buttList, imageLoader, board);

            backgroundSystem.startOfGame(buttList, playerList, imageLoader, room, treasure);
           // for (int i = 0; i < room.cardList.size(); i++) {
             //  image(room.cardList.get(i).cards, 20 + i * 70, 200, 60, 100);
           // }
          //  System.out.println(treasure.cardList.size());
            //for (int i = 0; i < treasure.cardList.size(); i++) {
                //image(treasure.cardList.get(i).cards, 20 + i * 70, 600, 60, 100);
           // }


            dice.display(200, 200);
            for (int i = 0; i < 4; i++) {
                playerList.get(i).displayHand(backgroundSystem.turn);
                playerList.get(i).displayicon();
            }
            for (int i = 0; i < 2; i++){
                deckList.get(i).displayBackside();
            }
            backgroundSystem.endturn(buttList);
            //println(backgroundSystem.turn);
            room.resuffle(roomdisc);
            treasure.resuffle(treasiredisc);
           System.out.println(playerList.get(0).hand.size() + "  " + playerList.get(1).hand.size() + "  " +playerList.get(2).hand.size() + "  " +playerList.get(3).hand.size() );

        }

        if (screenchange == 2) {
            rules.displayRules();
        }

        for (int i = 0; i < buttList.size(); i++) {
            buttList.get(i).isButtonPressed();
            buttList.get(i).drawButton();
        }
        screenChanger();

    }

    @Override
    public void mouseClicked() {
        for (int i = 0; i < buttList.size(); i++) {
            buttList.get(i).registerClick(mouseX, mouseY);
        }
        if (screenchange == 1) {
            if (mouseX > dice.posX && mouseX < dice.posX + 50 && mouseY > dice.posY && mouseY < dice.posY + 50)
                dice.trowDie(7);

            room.clicktodraw(backgroundSystem.turn, playerList);
            treasure.clicktodraw(backgroundSystem.turn, playerList);
        }
    }

    @Override
    public void mouseReleased() {
        for (int i = 0; i < buttList.size(); i++) {
            buttList.get(i).release();
        }
    }

    void screenChanger() {
        if (screenchange == 0) {
            if (buttList.size() > 0 && buttList.get(0).tryk == true) {
                screenchange = 1;
                menus.notdoneyet = true;
                buttList.clear();
            }
            if (buttList.size() > 0 && buttList.get(1).tryk == true) {
                screenchange = 2;
                menus.notdoneyet = true;
                buttList.clear();
            }
            if (buttList.size() > 0 && buttList.get(2).tryk == true) {
                exit();
            }
        }
        if (screenchange == 1 && screenchange == 2) {
            if (buttList.size() > 0 && buttList.get(0).tryk == true) {
                screenchange = 0;
                menus.notdoneyet = true;
                buttList.clear();
            }
        }
    }
}