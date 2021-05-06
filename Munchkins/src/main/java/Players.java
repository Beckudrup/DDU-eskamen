import processing.core.PApplet;
import processing.core.PImage;

import java.util.ArrayList;

public class Players {
    PApplet p;
    int level = 1;
    PImage icon;
    int gender;
    int headpow;
    int bodypow;
    int feetpow;
    int handpow;
    int hand2pow;
    int pow;
    int tempPow;
    int playerClass = 0;
    int race = 0;
    int playernr;
    Card head;
    Card body;
    Card feet;
    Card hand1;
    Card hand2;
    Card Class;
    Card Race;

    ArrayList<Card> hand = new ArrayList();

    Players(PApplet p) {
        this.p = p;
    }

    void selectCard(Deck roomdisc, Deck treasuredisc) {
        for (int i = 0; i < hand.size(); i++) {
            if (hand.get(i).hovering) {
                if (hand.get(i).type.equalsIgnoreCase("Armor") || (hand.get(i).type.equalsIgnoreCase("armor big"))) {
                    if (body != null) {
                        if (body.numb == 0) {
                            roomdisc.addcard(body);
                        } else {
                            if (body.numb == 1)
                                treasuredisc.addcard(body);
                        }
                    }
                    hand.get(i).hovering = false;
                    body = hand.get(i);
                    hand.remove(i);
                } else {
                    if (hand.get(i).type.equalsIgnoreCase("headgear")) {
                        if (head != null) {
                            if (head.numb == 0) {
                                roomdisc.addcard(head);
                            } else {
                                if (head.numb == 1)
                                    treasuredisc.addcard(head);
                            }
                        }
                        hand.get(i).hovering = false;
                        head = hand.get(i);
                        hand.remove(i);
                    } else {
                        if (hand.get(i).type.equalsIgnoreCase("footgear")) {
                            if (feet != null) {
                                if (feet.numb == 0) {
                                    roomdisc.addcard(feet);
                                } else {
                                    if (feet.numb == 1)
                                        treasuredisc.addcard(feet);
                                }
                            }
                            hand.get(i).hovering = false;
                            feet = hand.get(i);
                            hand.remove(i);
                        } else {
                            if ((hand.get(i).type.equalsIgnoreCase("1 hand") || hand.get(i).type.equalsIgnoreCase("1 hand big")) && hand1 == null) {
                                if (hand1 != null) {
                                    if (hand1.numb == 0) {
                                        roomdisc.addcard(hand1);
                                    } else {
                                        if (hand1.numb == 1)
                                            treasuredisc.addcard(hand1);
                                    }
                                }
                                hand.get(i).hovering = false;
                                hand1 = hand.get(i);
                                hand.remove(i);
                            } else {
                                if ((hand.get(i).type.equalsIgnoreCase("1 hand") || hand.get(i).type.equalsIgnoreCase("1 hand big")) && hand1 != null && (!hand1.type.equalsIgnoreCase("2 hands") || !hand1.type.equalsIgnoreCase("2 hands big"))) {
                                    if (hand2 != null) {
                                        if (hand2.numb == 0) {
                                            roomdisc.addcard(hand2);
                                        } else {
                                            if (hand2.numb == 1)
                                                treasuredisc.addcard(hand2);
                                        }
                                    }
                                    hand.get(i).hovering = false;
                                    hand2 = hand.get(i);
                                    hand.remove(i);
                                } else {

                                    if (hand.get(i).numb == 0) {
                                        hand.get(i).hovering = false;
                                        Card card = hand.get(i);
                                        roomdisc.addcard(card);
                                        hand.remove(i);
                                    } else {
                                        if (hand.get(i).numb == 1) {
                                            hand.get(i).hovering = false;
                                            Card card = hand.get(i);
                                            treasuredisc.addcard(card);
                                            hand.remove(i);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /*
    if (hand.get(i).type.equalsIgnoreCase("Class")) {
                            if (Class != null) {
                                if (Class.numb == 0) {
                                    roomdisc.addcard(Class);
                                } else {
                                    if (Class.numb == 1)
                                        treasuredisc.addcard(Class);
                                }
                            }
                            hand.get(i).hovering = false;
                            Class = hand.get(i);
                            hand.remove(i);
                        } else {
                            if (hand.get(i).type.equalsIgnoreCase("Race")) {
                                if (Race != null) {
                                    if (Race.numb == 0) {
                                        roomdisc.addcard(Race);
                                    } else {
                                        if (Race.numb == 1)
                                            treasuredisc.addcard(Race);
                                    }
                                }
                                hand.get(i).hovering = false;
                                Race = hand.get(i);
                                hand.remove(i);
                            }
                        }
     */


    void displayequiped() {
        if (playernr == 0) {
            if (head != null)
                head.display(200, 800, 60, 100, 1);
            if (body != null)
                body.display(280, 800, 60, 100, 1);
            if (feet != null)
                feet.display(360, 800, 60, 100, 1);
            if (hand1 != null)
                hand1.display(200, 920, 60, 100, 1);
            if (hand2 != null)
                hand2.display(280, 920, 60, 100, 1);
            if (Class != null)
                Class.display(360, 800, 60, 100, 1);
            if (Race != null)
                Race.display(440, 800, 60, 100, 1);
        }
        if (playernr == 1) {
            p.pushMatrix();
            p.rotate((float) 1.5708);
            if (head != null)
                head.display(130, -230, 60, 100, 1);
            if (body != null)
                body.display(210, -230, 60, 100, 1);
            if (feet != null)
                feet.display(290, -230, 60, 100, 1);
            if (hand1 != null)
                hand1.display(130, -110, 60, 100, 1);
            if (hand2 != null)
                hand2.display(210, -110, 60, 100, 1);
            if (Class != null)
                Class.display(290, -110, 60, 100, 1);
            if (Race != null)
                Race.display(1720, 160, 60, 100, 1);
            p.popMatrix();
        }
        if (playernr == 2) {
            p.pushMatrix();
            p.rotate((float) 1.5708 * 2);
            if (head != null)
                head.display(-1720, -260, 60, 100, 1);
            if (body != null)
                body.display(-1640, -260, 60, 100, 1);
            if (feet != null)
                feet.display(-1560, -260, 60, 100, 1);
            if (hand1 != null)
                hand1.display(-1720, -140, 60, 100, 1);
            if (hand2 != null)
                hand2.display(-1640, -140, 60, 100, 1);
            if (Class != null)
                Class.display(-1560, -140, 60, 100, 1);
            if (Race != null)
                Race.display(440, 800, 60, 100, 1);
            p.popMatrix();
        }
        if (playernr == 3) {
            p.pushMatrix();
            p.rotate((float) 1.5708 * 3);
            if (head != null)
                head.display(-770, 1660, 60, 100, 1);
            if (body != null)
                body.display(-850, 1660, 60, 100, 1);
            if (feet != null)
                feet.display(-930, 1660, 60, 100, 1);
            if (hand1 != null)
                hand1.display(-770, 1780, 60, 100, 1);
            if (hand2 != null)
                hand2.display(-850, 1780, 60, 100, 1);
            if (Class != null)
                Class.display(-930, 1780, 60, 100, 1);
            if (Race != null)
                Race.display(440, 800, 60, 100, 1);
            p.popMatrix();
        }
    }

    void getPower() {
        if (head != null) {
            headpow = (head.power);
        }
        if (body != null) {
            bodypow = (body.power);
        }
        if (feet != null) {
            feetpow = (feet.power);
        }
        if (hand1 != null) {
            handpow = (hand1.power);
        }
        if (hand2 != null) {
            hand2pow = (hand2.power);
        }
        if (head != null && body != null && feet != null && hand1 != null && hand2 != null) {
            pow = (head.power + head.power2 + body.power + body.power2 + feet.power + hand1.power + hand2.power);
            PApplet.println(pow);
        } else {
            PApplet.println(playernr + ": " + (headpow + bodypow + feetpow + handpow + hand2pow) + " ");
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
            p.text("lvl:" + level, 60, 920);
        }
        if (playernr == 1) {
            p.image(icon, 10, 10, 100, 100);
            p.text("lvl:" + level, 150, 75);

        }
        if (playernr == 2) {
            p.image(icon, 1810, 10, 100, 100);
            p.text("lvl:" + level, 1850, 150);

        }
        if (playernr == 3) {
            p.image(icon, 1810, 950, 100, 100);
            p.text("lvl:" + level, 1750, 1000);

        }
    }
}
