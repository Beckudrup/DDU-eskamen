import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Deck {
    PApplet p;
    PImage backside;
    ArrayList<Card> cardList = new ArrayList<>();
    ArrayList<Card> boardDeck = new ArrayList<>();
    int x, y, w, h;
    int allowedTreasure = 0;
    boolean firstDraw = false;
    boolean fix = true;

    Deck(PApplet p, int x, int y, int w, int h) {
        this.p = p;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    void addcard(Card card) {
        cardList.add(card);
    }

    void clicktodraw(int turn, ArrayList<Players> playerList, int type, Deck treasuredisc, Deck roomdisc, Players players) {
        if (p.mouseX > x && p.mouseX < x + w && p.mouseY > y && p.mouseY < y + h) {
            drawcard(playerList.get(turn).hand, type, playerList, treasuredisc, roomdisc, players);

        }
    }

    void drawcard(ArrayList<Card> hand, int type, ArrayList<Players> playerList, Deck treasuredisc, Deck roomdisc, Players player) {
        //træk fra ikke discarded decks
        if (cardList.size() > 0 && type == 0 || type == 2) {
            int random = (int) p.random(cardList.size());
            Card drawncard = cardList.get(random);
            cardList.remove(random);
            if (drawncard.numb == 0 && type == 2)
                hand.add(drawncard);

            //Andet og start game room draw
            if (drawncard.numb == 0 && !firstDraw && type != 2 && fix == true) {
                hand.add(drawncard);
                System.out.println("andet draw");
                //fix = false;    //TÆND IGEN! når spillet er ved at være done
            } else {
                //Første room draw
                if (drawncard.numb == 0 && firstDraw && type != 2) {
                    //hvis man trækker en curse
                    if (drawncard.type.equalsIgnoreCase("Curse")) {
                        System.out.println("Henrik");
                        //Cursen skal komme ud på bordet og blive brugt

                        curses(drawncard, player, playerList, treasuredisc, roomdisc); //kig på senere måske bad

                       // hand.add(drawncard);
                        System.out.println("Henrik");
                    }
                    //Hvis man trækker et monster
                    if (drawncard.type.equalsIgnoreCase("Monster")) {
                        //Monster kommer ud på bordet og engager i combat
                        //monsters(drawncard);
                        hand.add(drawncard);
                        System.out.println("kål");
                    }
                    //hvis man trækker andet (class,race,"spellkort")
                    if (drawncard.type.equalsIgnoreCase("Card") || drawncard.type.equalsIgnoreCase("Cheat")||drawncard.type.equalsIgnoreCase("Class") || drawncard.type.equalsIgnoreCase("Race")) {
                        hand.add(drawncard);
                        System.out.println("hapini");

                    }

                    firstDraw = false;
                } else {
                    //Treasure draw
                    if (drawncard.numb == 1 /*&& allowedTreasure > 0*/) {
                        hand.add(drawncard);
                        allowedTreasure--;
                    }
                }
            }
        } else {
            //træk fra discarded decks
            if (cardList.size() > 0 && type == 1 /*||type==2*/) {
                Card drawncard = cardList.get(cardList.size() - 1);
                hand.add(drawncard);
                cardList.remove(cardList.size() - 1);
            } else {
                if (cardList.size() > 0 /*&& type == 2*/) {
                    int rando = (int) p.random(cardList.size());
                    Card drawncard = cardList.get(rando);
                    hand.add(drawncard);
                    cardList.remove(cardList.size() - 1);

                }
            }

        }
    }


    void displayBackside() {
        p.image(backside, x, y, w, h);
    }

    void resuffle(Deck disc,int type) {

        if (cardList.size() == 0&&type==0){
            while (disc.cardList.size() > 0) {
                Card card = disc.cardList.get(disc.cardList.size() - 1);
                addcard(card);
                disc.cardList.remove(disc.cardList.size() - 1);
            }}
        if (type==1){
            while (disc.cardList.size() > 0) {
                Card card = disc.cardList.get(disc.cardList.size() - 1);
                addcard(card);
                disc.cardList.remove(disc.cardList.size() - 1);
            }}

    }

    void showDisc(Deck disc) {
        if (disc.cardList.size() > 0) {
            for (int i = 0; i < disc.cardList.size(); i++) {
                if (disc.cardList.get(i).numb == 1) {
                    disc.cardList.get(i).display(1090, 270, 90, 150, 1);
                } else {
                    disc.cardList.get(i).display(700, 270, 90, 150, 1);

                }
            }
        }
    }


    void curses(Card drawncard, Players player, ArrayList<Players> playerList, Deck treasuredisc, Deck roomdisc) {

        boardDeck.add(drawncard);


        if (player.feet != null && player.feet.name.equalsIgnoreCase("Sandals of protection")) {
            roomdisc.addcard(drawncard);
            boardDeck.remove(0);
        } else {
            for (int i = 0; i < player.hand.size(); i++) {

                if (player.hand.get(i).name.equalsIgnoreCase("Wishing ring")) {
                    roomdisc.addcard(player.hand.get(i));
                    player.hand.remove(i);
                    boardDeck.remove(0);

                }
            }
            if (boardDeck.size() > 0) {
                if (drawncard.name.equalsIgnoreCase("Curse! Lose a level")) {
                    if (player.level != 1)
                        player.level--;

                }


                if (drawncard.name.equalsIgnoreCase("Truly obnoxious curse!")) {
//kig iggennem alle kort og fjern største bonus
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose 1 big item")) {

                }
                if (drawncard.name.equalsIgnoreCase("Curse! Income tax")) {
// discard 1  item at random other people discard 1
                }

                if (drawncard.name.equalsIgnoreCase("Curse! Chiken on your head")) {
                    player.chikenonhed = true;
                    player.curse=drawncard;

                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose your footgear")) {
                    if(player.feet!=null){
                    treasuredisc.addcard(player.feet);
                    player.feet = null;
                    }
                }

                if (drawncard.name.equalsIgnoreCase("Curse! Lose 1 small item")) {
// 1 item der ikke er big
                }


                if (drawncard.name.equalsIgnoreCase("Curse! Change race")) {
                    // Skal hente en anden race
                    if (player.race != null && roomdisc.cardList.size() > 0) {
                        boolean raceFound = false;
                        for (int j = 0; j < roomdisc.cardList.size()  && !raceFound; j++) {
                            if (roomdisc.cardList.get(j).type.equalsIgnoreCase("Race")) {
                               roomdisc.addcard(player.race);
                               roomdisc.addcard(player.race2);
                                player.race2 =null;
                                Card raceDraw = roomdisc.cardList.get(j);
                                roomdisc.cardList.remove(j);
                                player.race = raceDraw;
                                raceFound = true;
                            }

                        }
                        if(!raceFound){
                            roomdisc.addcard(player.race);
                            roomdisc.addcard(player.race2);
                            player.race =null;
                            player.race2 =null;
                        }
                    }
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Duck of Doom")) {
                    player.level -= 2;
                    if(player.level<1){
                        player.level=1;
                    }
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose your race")) {
                    if(player.race !=null) {
                        roomdisc.addcard(player.race);
                        player.race = null;
                        if(player.race2!=null){
                            roomdisc.addcard(player.race2);
                            player.race2 = null;
                        }

                    }
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose your class")) {
                    if (player.playerClass2!=null){
                        roomdisc.addcard(player.playerClass);
                        player.playerClass = null;
                    }else{
                    if(player.playerClass!=null) {
                        roomdisc.addcard(player.playerClass);
                        player.playerClass = null;

                    }}
                    if(player.level>1)
                        player.level-=1;
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose two cards")) {
                    //rewrite this @batman
                    ArrayList<Card> treasuresList = new ArrayList<>();
                    if (player.body != null) {
                        treasuresList.add(player.body);
                        player.body = null;
                    }

                    if (player.hand1 != null) {
                        treasuresList.add(player.hand1);
                        player.hand1 = null;
                    }

                    if (player.hand2 != null) {
                        treasuresList.add(player.hand2);
                        player.hand2 = null;
                    }

                    if (player.head != null) {
                        treasuresList.add(player.head);
                        player.head = null;
                    }

                    if (player.feet != null) {
                        treasuresList.add(player.feet);
                        player.feet = null;
                    }
                    if (player.utility != null) {
                        treasuresList.add(player.utility);
                        player.utility = null;
                    }

                        if (treasuresList.size() > 0) {
                            boolean secondtime = false;

                            for (int i = 0; i < 2 ; i++) {

                            if (treasuresList.size()>0){
                            int rando = (int) p.random(treasuresList.size());
                            Card temp = treasuresList.get(rando);

                            if(player.playernr>0&&secondtime==false){
                                playerList.get(player.playernr-1).hand.add(temp);
                                treasuresList.remove(rando);
                                secondtime=true;
                            }else{
                                if (secondtime==false){
                                playerList.get(3).hand.add(temp);
                                treasuresList.remove(rando);}
                            }
                            if(player.playernr<3&&secondtime==true){
                                playerList.get(player.playernr+1).hand.add(temp);
                                treasuresList.remove(rando);
                            }else{
                                if(secondtime==true) {
                                    playerList.get(0).hand.add(temp);
                                    treasuresList.remove(rando);
                                }
                            }
                        }}}




                }
                if (drawncard.name.equalsIgnoreCase("Curse! Change class")) {
                    // Skal hente en anden race roomdisc.cardList.get(1);
                    if (player.playerClass != null ) {
                        boolean classFound = false;
                        if(roomdisc.cardList.size() > 0){
                        for (int j = 0; j < roomdisc.cardList.size()  && !classFound; j++) {
                            if (roomdisc.cardList.get(j).type.equalsIgnoreCase("Class")) {
                                roomdisc.addcard(player.playerClass);
                                roomdisc.addcard(player.playerClass2);
                                player.playerClass2 =null;
                                Card classDraw = roomdisc.cardList.get(j);
                                roomdisc.cardList.remove(j);
                                player.playerClass = classDraw;
                                classFound = true;
                            }}

                        }
                        if(!classFound){
                            roomdisc.addcard(player.playerClass);
                            roomdisc.addcard(player.playerClass2);
                            player.playerClass=null;
                            player.playerClass2 =null;
                        }
                    }


                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose your armor")) {
                    if (player.body!=null) {
                        treasuredisc.addcard(player.body);
                        player.body = null;
                    }
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Change your sex")) {
                    player.powChange -= 5;
                    if (player.gender == 1) { //Burde også miste 5 power i en kamp
                        player.gender = 2;
                    } else {
                        if (player.gender == 2) {
                            player.gender = 1;
                        }
                    }
                }
                if (drawncard.name.equalsIgnoreCase("Curse! Malign mirror")) {
                    //alle powers fra alle items ud over armor = 0 i en kamp
                    player.mirror=true;

                }
                if (drawncard.name.equalsIgnoreCase("Curse! Lose your headgear")) {
                    if (player.head!=null) {
                        treasuredisc.addcard(player.head);
                        player.head = null;
                        if(player.chikenonhed){
                            player.chikenonhed=false;
                        }
                    }
                }
            }
            if(!player.chikenonhed)
            roomdisc.addcard(drawncard);
            boardDeck.remove(0);
        }

    }
    void monsters(Card drawncard) {
        boardDeck.add(drawncard);

    }

    void showBoardDeck() {
        if (boardDeck.size() > 0) {
            for (int i = 0; i < boardDeck.size(); i++) {
                boardDeck.get(i).display(p.width / 2 + i * 90, 550, 90, 150, 1);
            }
        }
    }
}
