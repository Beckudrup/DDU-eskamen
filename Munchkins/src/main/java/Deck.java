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

    void clicktodraw(int turn, ArrayList<Players> playerList) {
        if (p.mouseX > x && p.mouseX < x + w && p.mouseY > y && p.mouseY < y + h) {
            drawcard(playerList.get(turn).hand);
        }
    }

    void drawcard(ArrayList<Card> hand) {
        if (cardList.size() > 0) {
            int random = (int) p.random(cardList.size());
            Card drawncard = cardList.get(random);
            cardList.remove(random);
            hand.add(drawncard);
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
}
