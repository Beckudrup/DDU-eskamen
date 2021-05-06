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
    Players player;
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

    void clicktodraw(int turn, ArrayList<Players> playerList, int type) {
        if (p.mouseX > x && p.mouseX < x + w && p.mouseY > y && p.mouseY < y + h) {
            drawcard(playerList.get(turn).hand, type);
            System.out.println(firstDraw);

        }
    }

    void drawcard(ArrayList<Card> hand, int type) {
        //træk fra ikke discarded decks
        if (cardList.size() > 0 && type == 0||type==2) {
            int random = (int) p.random(cardList.size());
            Card drawncard = cardList.get(random);
            cardList.remove(random);
            //Første room draw
            if (drawncard.numb == 0 && !firstDraw || type==2 ) {
                hand.add(drawncard);
            } else {
                //Andet room draw
                if (drawncard.numb == 0 && firstDraw && type != 2) {
                    //hvis man trækker en curse
                    if (drawncard.type.equalsIgnoreCase("Curse")) {
                        //Cursen skal komme ud på bordet og blive brugt
                       // curses(drawncard, player); //kig på senere måske bad
                        hand.add(drawncard);

                    }
                    //Hvis man trækker et monster
                    if (drawncard.type.equalsIgnoreCase("Monster")) {
                        //Monster kommer ud på bordet og engager i combat
                        //monsters(drawncard);
                        hand.add(drawncard);

                    }
                    //hvis man trækker andet (class,race,"spellkort")
                    if (drawncard.type.equalsIgnoreCase("Card") || drawncard.type.equalsIgnoreCase("Cheat")) {
                        hand.add(drawncard);
                    }


                } else {
                    //Treasure draw
                    if (drawncard.numb == 1 && allowedTreasure > 0) {
                        hand.add(drawncard);
                        allowedTreasure--;
                    }
                }
            }
        } else {
            //træk fra discarded decks
                if (cardList.size() > 0 && type == 1 ||type==2) {
                    Card drawncard = cardList.get(cardList.size() - 1);
                    hand.add(drawncard);
                    cardList.remove(cardList.size() - 1);
                }else{
                    if(cardList.size() > 0 && type == 2){
                        int rando = (int)p.random(cardList.size());
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

    void resuffle(Deck disc) {
        if (cardList.size() == 0)
            while (disc.cardList.size() > 0) {
                Card card = disc.cardList.get(disc.cardList.size() - 1);
                addcard(card);
                disc.cardList.remove(disc.cardList.size() - 1);
            }

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
    void showBoardDeck(){
        if (boardDeck.size() > 0){
            for (int i = 0; i < boardDeck.size(); i++) {
                boardDeck.get(i).display(p.width/2+i*90,550,90,150,1);
            }
        }
    }
    void curses(Card drawncard, Players player){
        if (drawncard.name.equalsIgnoreCase("Curse! Lose a level")){
            boardDeck.add(drawncard);
            player.level--;
        }
    }
    void monsters(Card drawncard){
        boardDeck.add(drawncard);

    }
}
