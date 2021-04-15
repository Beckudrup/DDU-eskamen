import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Deck {
    PApplet p;
    int decknr;
    PImage backside;
    ArrayList<Card> cardList = new ArrayList<>();

    Deck(PApplet p) {
        this.p = p;
    }

    void displayBackside() {
        if (decknr == 0) {
            p.image(backside, 700, 270, 90, 150);
        }
        if (decknr == 1) {
            p.image(backside, 960, 270, 90, 150);
        }
    }

    void addcard(Card card) {
        cardList.add(card);
    }

    void drawcard(ArrayList<Card> hand) {
        int random = (int) p.random(cardList.size());
        Card drawncard = cardList.get(random);
        cardList.remove(random);
        hand.add(drawncard);
    }
}
