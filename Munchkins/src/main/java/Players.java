import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Players {
    PApplet p;
    int level = 1;
    PImage icon;
    int gender;
    int playerClass = 0;
    int race = 0;
    int playernr;
    ArrayList<Card> hand = new ArrayList();

    Players(PApplet p) {
        this.p = p;
    }

    void selectCard(Deck roomdisc, Deck treasuredisc) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).hovering) {
                if (hand.get(i).numb == 0) {
                    Card card = hand.get(i);
                    roomdisc.addcard(card);
                    hand.remove(i);
                } else {
                    if (hand.get(i).numb == 1) {
                    }
                    Card card = hand.get(i);
                    treasuredisc.addcard(card);
                    hand.remove(i);
                }
            }
        }
    }

    void displayHand(int turn) {
        if (hand.size() > 0) {
            if (turn - playernr == 0) {

                for (int i = 0; i < hand.size(); i++) {
                    hand.get(i).display(700 + i * 180, 800, 160, 200, 1);
                }
            }

            if ((playernr == 1 && turn == 0) || (playernr == 2 && turn == 1) || (playernr == 3 && turn == 2) || (playernr == 0 && turn == 3)) {
                for (int i = 0; i < hand.size(); i++) {
                    p.pushMatrix();

                    p.rotate((float) 1.5708);

                    hand.get(i).display(370 + i * 90, -100, 160 / 2, 200 / 2, 2);
                    p.popMatrix();
                }
            }
            if ((playernr == 2 && turn == 0) || (playernr == 3 && turn == 1) || (playernr == 0 && turn == 2) || (playernr == 1 && turn == 3)) {
                for (int i = 0; i < hand.size(); i++) {
                    p.pushMatrix();

                    p.rotate((float) 1.5708 * 2);
                    hand.get(i).display(-870 - i * 90, -100, 160 / 2, 200 / 2, 2);
                    p.popMatrix();
                }
            }
            if ((playernr == 3 && turn == 0) || (playernr == 0 && turn == 1) || (playernr == 1 && turn == 2) || (playernr == 2 && turn == 3)) {
                for (int i = 0; i < hand.size(); i++) {
                    p.pushMatrix();

                    p.rotate((float) 1.5708 * 3);

                    hand.get(i).display(-370 - i * 90, 1800, 160 / 2, 200 / 2, 2);
                    p.popMatrix();
                }
            }

        }
    }

    void hoverCard(BackgroundSystem backgroundSystem) {
        for (int i = 0; i < hand.size(); i++) {


            hand.get(i).hovering = p.mouseX > 700 + i * 180 && p.mouseX < 860 + i * 180 && p.mouseY > 800 && p.mouseY < 1000 && backgroundSystem.turn == playernr;
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
