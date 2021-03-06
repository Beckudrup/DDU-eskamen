import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    BackgroundSystem backgroundSystem = new BackgroundSystem(this);
    ArrayList<Button> buttList = new ArrayList<>();
    ArrayList<Players> playerList = new ArrayList<>();
    ArrayList<Deck> deckList = new ArrayList<>();
    ArrayList<Cardinfo> treasureinfoList = new ArrayList<>();
    ArrayList<Cardinfo> roominfoList = new ArrayList<>();
    Deck roomdisc = new Deck(this, 700, 270, 90, 150);
    Deck treasiredisc = new Deck(this, 1090, 270, 90, 150);
    Deck room = new Deck(this, 830, 270, 90, 150);
    Deck treasure = new Deck(this, 960, 270, 90, 150);
    Deck boardDeck = new Deck(this, width / 2, 600, 90, 150);
    Dice dice = new Dice(this);
    Database database = new Database(this);
    Menus menus = new Menus(this);
    int screenchange = 0;
    ImageLoader imageLoader = new ImageLoader(this);

    Rules rules = new Rules(this);
    Badstuff badstuff = new Badstuff(this);
    Players players = new Players(this);
    boolean loadingDone;
    int counter;
    ArrayList<Card> monsterlist = new ArrayList<>();

    @Override
    public void settings() {
        super.settings();
        size(1920, 1080);
        //println(dataPath("test.db"));
    }

    @Override
    public void setup() {
        super.setup();
        thread("thread");
    }

    public void thread() {
        imageLoader.loadImage();
        database.setups();
        database.LoadCards(treasureinfoList, roominfoList);
        backgroundSystem.loaddecks(room, treasure, imageLoader, treasureinfoList, roominfoList);
        loadingDone = true;
    }

    @Override
    public void draw() {
        clear();
        textAlign(CENTER);
        if (!loadingDone) {
            if (counter >= 0 && counter < 100) {
                textSize(30);
                text("Loading.", width / 2, height / 2);
            }
            if (counter >= 100 && counter < 200) {
                textSize(30);
                text("Loading..", width / 2, height / 2);
            }
            if (counter >= 200 && counter < 300) {
                textSize(30);
                text("Loading...", width / 2, height / 2);
            }
            if (counter < 300) {
                counter++;
            }
            if (counter == 300) {
                counter = 0;
            }

        }
        textAlign(LEFT);
        if (loadingDone) {
            if (screenchange == 0) {
                menus.mainMenu(buttList, imageLoader);
            }
            if (screenchange == 1) {

                menus.ingame(buttList, imageLoader);

                backgroundSystem.startOfGame(buttList, playerList, imageLoader, room, treasure, treasiredisc, roomdisc, players,monsterlist,backgroundSystem);
                // for (int i = 0; i < room.cardList.size(); i++) {
                //  image(room.cardList.get(i).cards, 20 + i * 70, 200, 60, 100);
                // }
                //  System.out.println(treasure.cardList.size());
                //for (int i = 0; i < treasure.cardList.size(); i++) {
                //image(treasure.cardList.get(i).cards, 20 + i * 70, 600, 60, 100);
                // }
                if (backgroundSystem.gamestarted) {
                    //badstuff.badstuffdeath(playerList.get(backgroundSystem.turn), room, treasure, playerList, backgroundSystem, roomdisc, treasiredisc);

                    roomdisc.showDisc(roomdisc);
                    treasiredisc.showDisc(treasiredisc);
                    //boardDeck.showBoardDeck();
                    // dice.display(200, 200);
                    for (int i = 0; i < 4; i++) {
                        playerList.get(i).hoverCard(backgroundSystem);
                        playerList.get(i).display(backgroundSystem.turn);
                        playerList.get(i).changeButtonPos(backgroundSystem);
                        playerList.get(i).showhand.drawButton();
                        playerList.get(i).getPower();
                    }
                   /* for (int i = 0; i < room.cardList.size() ; i++) {
                        if(room.cardList.get(i).badStuff!=null){
                            System.out.println(room.cardList.get(i).badStuff);
                        }
                    }*/
                    /*for (int i = 0; i < treasure.cardList.size() ; i++) {
                        System.out.println(treasure.cardList.get(i).lable);
                    }*/

                    room.displayBackside();
                    treasure.displayBackside();
                    backgroundSystem.displayenemy(monsterlist);
                    backgroundSystem.battlefase(buttList, playerList, backgroundSystem, monsterlist, roomdisc, treasiredisc, dice, room, treasure);
                    backgroundSystem.endturn(buttList, playerList.get(backgroundSystem.turn), playerList, roomdisc, treasiredisc, room);
                    //println(backgroundSystem.turn);
                    room.resuffle(roomdisc, 0);
                    treasure.resuffle(treasiredisc, 0);
                    for (int i = 0; i < playerList.size(); i++) {
                        for (int j = 0; j < playerList.get(i).hand.size(); j++) {
                            if (playerList.get(i).hand.get(j).hovering == true) {
                            }
                        }
                    }
                    for (int i = 0; i < playerList.size(); i++) {
                        if (playerList.get(i).level == 10) {
                            textSize(50);
                            textAlign(CENTER);
                            text("Player " + (backgroundSystem.turn + 1) + " wins good game!", 1000, 650);
                        }
                    }
                }
                //System.out.println(playerList.get(0).hand.size() + "  " + playerList.get(1).hand.size() + "  " + playerList.get(2).hand.size() + "  " + playerList.get(3).hand.size());

            }

            if (screenchange == 2) {
                rules.displayRules(buttList);
            }
            if (screenchange == 3) {
                rules.rStartOfGame(buttList);
            }
            if (screenchange == 4) {
                rules.rTurns(buttList);
            }
            if (screenchange == 5) {
                rules.rKickOpenTheDoor(buttList);
            }
            if (screenchange == 6) {
                rules.rCombat(buttList);
            }
            if (screenchange == 7) {
                rules.rDeath(buttList);
            }
            if (screenchange == 8) {
                rules.rRunAway(buttList);
            }
            if (screenchange == 9) {
                rules.rAskForHelp(buttList);
            }
            if (screenchange == 10) {
                rules.rLootTheRoom(buttList);
            }
            if (screenchange == 11) {
                rules.rCurses(buttList);
            }
            if (screenchange == 12) {
                rules.rClassAbilities(buttList);
            }
            if (screenchange == 13) {
                rules.rCharity(buttList);
            }
            if (screenchange == 14) {
                rules.rHowToWin(buttList);
            }
            if (screenchange == 15) {
                rules.rGameControls(buttList);
            }
            if (screenchange < 1 || screenchange > 1 || (screenchange == 1 && backgroundSystem.gamestarted))
                for (int i = 0; i < buttList.size(); i++) {
                    buttList.get(i).isButtonPressed();
                    buttList.get(i).drawButton();
                }
            if (!backgroundSystem.gamestarted && screenchange == 1) {
                for (int i = 0; i < buttList.size(); i++) {
                    if (i == 1)
                        i++;
                    buttList.get(i).isButtonPressed();
                    buttList.get(i).drawButton();
                }
            }
            screenChanger();

        }
    }


    @Override
    public void mouseClicked() {

        for (int i = 0; i < buttList.size(); i++) {
            buttList.get(i).registerClick(mouseX, mouseY);
        }
        if (screenchange == 1) {
            if (backgroundSystem.gamestarted) {
                if (mouseX > dice.posX && mouseX < dice.posX + 50 && mouseY > dice.posY && mouseY < dice.posY + 50)
                    dice.trowDie(7);

                room.clicktodraw(backgroundSystem.turn, playerList, 0, treasiredisc, roomdisc, players,monsterlist,backgroundSystem);

                for (int i = 0; i < playerList.size(); i++) {
                    playerList.get(i).selectCard(roomdisc, treasiredisc, backgroundSystem, monsterlist, treasure, room, playerList, buttList);
                    playerList.get(i).showhand.registerClick2(mouseX, mouseY);
                }
            }
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
        if (screenchange == 2) {
            //Start of game
            if (buttList.size() > 0 && buttList.get(1).tryk == true) {
                screenchange = 3;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Turns
            if (buttList.size() > 0 && buttList.get(2).tryk == true) {
                screenchange = 4;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Kick Open The Door
            if (buttList.size() > 0 && buttList.get(3).tryk == true) {
                screenchange = 5;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Combat
            if (buttList.size() > 0 && buttList.get(4).tryk == true) {
                screenchange = 6;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Death
            if (buttList.size() > 0 && buttList.get(5).tryk == true) {
                screenchange = 7;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Run away
            if (buttList.size() > 0 && buttList.get(6).tryk == true) {
                screenchange = 8;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Ask for help
            if (buttList.size() > 0 && buttList.get(7).tryk == true) {
                screenchange = 9;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Loot the Room
            if (buttList.size() > 0 && buttList.get(8).tryk == true) {
                screenchange = 10;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Curses
            if (buttList.size() > 0 && buttList.get(9).tryk == true) {
                screenchange = 11;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Class Abilities
            if (buttList.size() > 0 && buttList.get(10).tryk == true) {
                screenchange = 12;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Charity
            if (buttList.size() > 0 && buttList.get(11).tryk == true) {
                screenchange = 13;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //How to win
            if (buttList.size() > 0 && buttList.get(12).tryk == true) {
                screenchange = 14;
                menus.notdoneyet = true;
                buttList.clear();
            }
            //Game controls
            if (buttList.size() > 0 && buttList.get(13).tryk == true) {
                screenchange = 15;
                menus.notdoneyet = true;
                buttList.clear();
            }
        }
        if (screenchange == 3 || screenchange == 4 || screenchange == 5 || screenchange == 6 || screenchange == 7 || screenchange == 8 || screenchange == 9 || screenchange == 10 || screenchange == 11 || screenchange == 12 || screenchange == 13 || screenchange == 14 || screenchange == 15) {
            if (buttList.size() > 0 && buttList.get(0).tryk == true) {
                screenchange = 2;
                buttList.get(0).tryk = false;
                buttList.clear();
                menus.notdoneyet = true;

            }
            if (buttList.size() > 0 && buttList.get(1).tryk == true) {
                if (screenchange == 3) {
                    screenchange = 15;
                    buttList.get(1).tryk = false;

                } else {
                    if (screenchange != 3) {
                        buttList.get(1).tryk = false;
                        screenchange--;

                    }
                }
            }
            if (buttList.size() > 0 && buttList.get(2).tryk == true) {
                if (screenchange == 15) {
                    screenchange = 3;
                    buttList.get(2).tryk = false;

                } else {
                    if (screenchange != 15) {
                        buttList.get(2).tryk = false;
                        screenchange++;
                    }

                }
            }
        }
        if (screenchange == 1 || screenchange == 2) {
            if (buttList.size() > 0 && buttList.get(0).tryk == true) {
                screenchange = 0;
                menus.notdoneyet = true;
                buttList.clear();
            }
        }
    }
}



