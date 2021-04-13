import processing.core.PApplet;

import java.util.ArrayList;

public class Deck {
    PApplet p;
    ArrayList<Card> cardList = new ArrayList<>();
    Deck(PApplet p){
        this.p=p;
    }
    void addcard(Card card){
        cardList.add(card);
    }
    void drawcard(ArrayList<Card> hand){
        int random = (int) p.random(cardList.size());
        Card drawncard = cardList.get(random);
        cardList.remove(random);
        hand.add(drawncard);
    }
}
