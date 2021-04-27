import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Deck {
    PApplet p;
    PImage backside;
    ArrayList<Card> cardList = new ArrayList<>();
    int x, y, w, h;

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
        }
    }

    void drawcard(ArrayList<Card> hand, int type) {
        if (cardList.size() > 0 && type==0) {

            int random = (int) p.random(cardList.size());
            Card drawncard = cardList.get(random);
            cardList.remove(random);
            hand.add(drawncard);
        }else {
            if (cardList.size() > 0 && type==1){
                int onTop = cardList.size()-1;
                hand.get(onTop).hovering= false;
                Card drawncard = cardList.get(onTop);
                hand.add(drawncard);
                cardList.remove(onTop);
                System.out.println("Du er doarlig");
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
    void showDisc(Deck disc){
        if (disc.cardList.size() > 0){
            for (int i = 0; i < disc.cardList.size(); i++) {
                if (disc.cardList.get(i).numb==1) {
                    disc.cardList.get(i).display(1090, 320, 90, 150, 1);
                }else{
                    disc.cardList.get(i).display(700, 320, 90, 150, 1);

                }
            }
        }
    }
}
