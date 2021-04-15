import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Players {
    PApplet p;
    int level = 0;
    PImage icon;
    int gender;
    int playerClass = 0;
    int race = 0;
    int playernr;
    ArrayList<Card> hand = new ArrayList();

    Players(PApplet p) {
        this.p = p;
    }

    void displayHand() {
        if (hand.size() > 0) {
            for (int i = 0; i < hand.size(); i++) {
                //hand.get(i).display();
            }
        }
    }

    void displayicon() {
        if (playernr == 0) {
            p.image(icon, 10, 950, 100, 100);
        }
        if (playernr == 1) {
            p.image(icon, 10, 10, 100, 100);
        }
        if (playernr == 2) {
            p.image(icon, 1810, 10, 100, 100);
        }
        if (playernr == 3) {
            p.image(icon, 1810, 950, 100, 100);
        }
    }
}
