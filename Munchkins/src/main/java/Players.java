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
    Card utility;
    Card monster;
    Card Class;
    Card Class2;
    Card Race;
    Card Race2;
    Button showhand;


    ArrayList<Card> hand = new ArrayList();

    Players(PApplet p) {
        this.p = p;
        showhand = new Button(p, 10, 10, 130, 50, "Show hand");
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
                                        Class.name = hand.get(i).name;
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
                                        } else {
                                            if (hand.get(i).type.equalsIgnoreCase("Utility") || hand.get(i).type.equalsIgnoreCase("Utility big")) {
                                                if (utility != null) {
                                                    if (utility.numb == 0) {
                                                        roomdisc.addcard(utility);
                                                    } else {
                                                        if (utility.numb == 1)
                                                            treasuredisc.addcard(utility);
                                                    }
                                                }
                                                hand.get(i).hovering = false;
                                                utility = hand.get(i);
                                                hand.remove(i);
                                            } else {
                                                if (hand.get(i).type.equalsIgnoreCase("Monster")) {
                                                    if (monster != null) {
                                                        if (monster.numb == 0) {
                                                            roomdisc.addcard(monster);
                                                        } else {
                                                            if (monster.numb == 1)
                                                                treasuredisc.addcard(monster);
                                                        }
                                                    }
                                                    hand.get(i).hovering = false;
                                                    monster = hand.get(i);
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
                }
            }
        }
    }


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
            if (utility != null)
                utility.display(360, 920, 60, 100, 1);
            if (Class != null)
                Class.display(440, 800, 60, 100, 1);
            if (Class2 != null)
                Class.display(440, 920, 60, 100, 1);
            if (Race != null)
                Race.display(520, 800, 60, 100, 1);
            if (Race2 != null)
                Race.display(520, 920, 60, 100, 1);
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
            if (utility != null)
                utility.display(290, -110, 60, 100, 1);
            if (Class != null)
                Class.display(370, -230, 60, 100, 1);
            if (Class2 != null)
                Class.display(370, -110, 60, 100, 1);
            if (Race != null)
                Race.display(450, -230, 60, 100, 1);
            if (Race2 != null)
                Race.display(450, -110, 60, 100, 1);
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
            if (utility != null)
                utility.display(-1560, -140, 60, 100, 1);
            if (Class != null)
                Class.display(-1480, -260, 60, 100, 1);
            if (Class2 != null)
                Class.display(-1480, -140, 60, 100, 1);
            if (Race != null)
                Race.display(-1400, -260, 60, 100, 1);
            if (Race2 != null)
                Race.display(-1400, -140, 60, 100, 1);
            p.popMatrix();
        }
        if (playernr == 3) {
            p.pushMatrix();
            p.rotate((float) 1.5708 * 3);
            if (head != null)
                head.display(-930, 1660, 60, 100, 1);
            if (body != null)
                body.display(-850, 1660, 60, 100, 1);
            if (feet != null)
                feet.display(-770, 1660, 60, 100, 1);
            if (hand1 != null)
                hand1.display(-930, 1780, 60, 100, 1);
            if (hand2 != null)
                hand2.display(-850, 1780, 60, 100, 1);
            if (utility != null)
                utility.display(-770, 1780, 60, 100, 1);
            if (Class != null)
                Class.display(-690, 1660, 60, 100, 1);
            if (Class2 != null)
                Class.display(-690, 1780, 60, 100, 1);
            if (Race != null)
                Race.display(-610, 1660, 60, 100, 1);
            if (Race2 != null)
                Race.display(-610, 1780, 60, 100, 1);
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
            pow = (head.power + head.power2 + body.power + body.power2 + feet.power + hand1.power + hand2.power + level);
            // PApplet.println(pow);
        } else {
            // PApplet.println(playernr + ": " + (headpow + bodypow + feetpow + handpow + hand2pow+level) + " ");
        }
    }

    void displayMonster() {
        if (monster != null)
            monster.display(p.width / 2 - 60, p.height / 2 - 100, 120, 200, 1);
    }

    void raceFunction() {
        if (Race != null) {
            if (Race.name.equalsIgnoreCase("Elf")) {
                //runAway+1;
                p.println("Run Away = 1");
                //If you help kill a monster +1 level, for each killed;
            }
            if (Race.name.equalsIgnoreCase("Dwarf")) {
                //Carry any number of big weapons;
                //Have 6 cards in hand (instead og 5);
            }
            if (Race.name.equalsIgnoreCase("Wizard")) {
                //Either
                //Discard up to 3 card. ;
            }
        }
    }

    void classFunction() {
        if (Class != null) {
            if (p.mouseX > 440 && p.mouseX < 440 + 60 && p.mouseY > 800 && p.mouseY < 800 + 100) {
                if (Class.name.equalsIgnoreCase("Thief")) {
                    p.println((int) p.random(1, 7));
                }
            }
        }
    }

    void changeButtonPos(BackgroundSystem backgroundSystem) {
        if (showhand.tryk == true) {
            showhand.text = "Hide hand";
        }
        if (showhand.tryk == false) {
            showhand.text = "Show hand";
        }
        if (playernr == 0) {
            if (backgroundSystem.turn == 0) {
                showhand.xPos = 30;
                showhand.yPos = 820;
            }
            if (backgroundSystem.turn == 1) {
                showhand.xPos = 1550;
                showhand.yPos = 950;
            }
            if (backgroundSystem.turn == 2) {
                showhand.xPos = 1750;
                showhand.yPos = 170;
            }
            if (backgroundSystem.turn == 3) {
                showhand.xPos = 200;
                showhand.yPos = 30;
            }
        }
        if (playernr == 1) {
            if (backgroundSystem.turn == 1) {
                showhand.xPos = 30;
                showhand.yPos = 820;
            }
            if (backgroundSystem.turn == 2) {
                showhand.xPos = 1550;
                showhand.yPos = 950;
            }
            if (backgroundSystem.turn == 3) {
                showhand.xPos = 1750;
                showhand.yPos = 170;
            }
            if (backgroundSystem.turn == 0) {
                showhand.xPos = 200;
                showhand.yPos = 30;
            }
        }
        if (playernr == 2) {
            if (backgroundSystem.turn == 2) {
                showhand.xPos = 30;
                showhand.yPos = 820;
            }
            if (backgroundSystem.turn == 3) {
                showhand.xPos = 1550;
                showhand.yPos = 950;
            }
            if (backgroundSystem.turn == 0) {
                showhand.xPos = 1750;
                showhand.yPos = 170;
            }
            if (backgroundSystem.turn == 1) {
                showhand.xPos = 200;
                showhand.yPos = 30;
            }
        }
        if (playernr == 3) {
            if (backgroundSystem.turn == 3) {
                showhand.xPos = 30;
                showhand.yPos = 820;
            }
            if (backgroundSystem.turn == 0) {
                showhand.xPos = 1550;
                showhand.yPos = 950;
            }
            if (backgroundSystem.turn == 1) {
                showhand.xPos = 1750;
                showhand.yPos = 170;
            }
            if (backgroundSystem.turn == 2) {
                showhand.xPos = 200;
                showhand.yPos = 30;
            }
        }
    }

    void displayHand(int turn) {
        if (hand.size() > 0) {
            if (turn - playernr == 0) {
                if (showhand.tryk == true) {
                    for (int i = 0; i < hand.size(); i++) {
                        hand.get(i).display(700 + i * 180, 800, 160, 200, 1);
                    }
                }
                if (showhand.tryk == false) {
                    for (int i = 0; i < hand.size(); i++) {
                        hand.get(i).display(700 + i * 180, 800, 160, 200, 2);
                    }

                }
            }

            if ((playernr == 1 && turn == 0) || (playernr == 2 && turn == 1) || (playernr == 3 && turn == 2) || (playernr == 0 && turn == 3)) {
                if (showhand.tryk == true) {
                    for (int i = 0; i < hand.size(); i++) {
                        p.pushMatrix();

                        p.rotate((float) 1.5708);

                        hand.get(i).display(370 + i * 90, -100, 160 / 2, 200 / 2, 1);
                        p.popMatrix();
                    }
                }
                if (showhand.tryk == false) {
                    for (int i = 0; i < hand.size(); i++) {
                        p.pushMatrix();

                        p.rotate((float) 1.5708);

                        hand.get(i).display(370 + i * 90, -100, 160 / 2, 200 / 2, 2);
                        p.popMatrix();
                    }
                }
            }
            if ((playernr == 2 && turn == 0) || (playernr == 3 && turn == 1) || (playernr == 0 && turn == 2) || (playernr == 1 && turn == 3)) {
                if (showhand.tryk == true) {
                    for (int i = 0; i < hand.size(); i++) {
                        p.pushMatrix();

                        p.rotate((float) 1.5708 * 2);
                        hand.get(i).display(-870 - i * 90, -100, 160 / 2, 200 / 2, 1);
                        p.popMatrix();
                    }
                }
                if (showhand.tryk == false) {
                    for (int i = 0; i < hand.size(); i++) {
                        p.pushMatrix();

                        p.rotate((float) 1.5708 * 2);
                        hand.get(i).display(-870 - i * 90, -100, 160 / 2, 200 / 2, 2);
                        p.popMatrix();
                    }
                }
            }


            if ((playernr == 3 && turn == 0) || (playernr == 0 && turn == 1) || (playernr == 1 && turn == 2) || (playernr == 2 && turn == 3)) {
                if (showhand.tryk == true) {
                    for (int i = 0; i < hand.size(); i++) {
                        p.pushMatrix();

                        p.rotate((float) 1.5708 * 3);

                        hand.get(i).display(-370 - i * 90, 1800, 160 / 2, 200 / 2, 1);
                        p.popMatrix();
                    }
                }
                if (showhand.tryk == false) {
                    for (int i = 0; i < hand.size(); i++) {
                        p.pushMatrix();

                        p.rotate((float) 1.5708 * 3);

                        hand.get(i).display(-370 - i * 90, 1800, 160 / 2, 200 / 2, 2);
                        p.popMatrix();
                    }
                }
            }
        }
    }

    void hoverCard(BackgroundSystem backgroundSystem) {
        if (backgroundSystem.turn - playernr == 0 && showhand.tryk == true) {
            for (int i = 0; i < hand.size(); i++) {
                hand.get(i).hovering = p.mouseX > 700 + i * 180 && p.mouseX < 860 + i * 180 && p.mouseY > 800 && p.mouseY < 1000;
            }
        }
        if (((playernr == 1 && backgroundSystem.turn == 0) || (playernr == 2 && backgroundSystem.turn == 1) || (playernr == 3 && backgroundSystem.turn == 2) || (playernr == 0 && backgroundSystem.turn == 3)) && showhand.tryk == true) {
            for (int i = 0; i < hand.size(); i++) {

                hand.get(i).hovering = p.mouseX > 0 && p.mouseX < 100 && p.mouseY > 370 + i * 90 && p.mouseY < 450 + i * 90;

            }

        }
        if (((playernr == 2 && backgroundSystem.turn == 0) || (playernr == 3 && backgroundSystem.turn == 1) || (playernr == 0 && backgroundSystem.turn == 2) || (playernr == 1 && backgroundSystem.turn == 3)) && showhand.tryk == true) {
            for (int i = 0; i < hand.size(); i++) {

                hand.get(i).hovering = p.mouseX > 790 + i * 90 && p.mouseX < 870 + i * 90 && p.mouseY > 0 && p.mouseY < 100;

            }
        }
        if (((playernr == 3 && backgroundSystem.turn == 0) || (playernr == 0 && backgroundSystem.turn == 1) || (playernr == 1 && backgroundSystem.turn == 2) || (playernr == 2 && backgroundSystem.turn == 3)) && showhand.tryk == true) {
            for (int i = 0; i < hand.size(); i++) {

                hand.get(i).hovering = p.mouseX > 1800 && p.mouseX < 1900 && p.mouseY > 290 + i * 90 && p.mouseY < 370 + i * 90;
            }
        }
    }

    void displayicon() {
        p.fill(255);
        if (playernr == 0) {
            p.image(icon, 10, 950, 100, 100);
            p.text("lvl:" + level, 40, 920);
            p.text("p1", p.width / 2, 750);
        }
        if (playernr == 1) {
            p.image(icon, 10, 10, 100, 100);
            p.text("lvl:" + level, 150, 70);
            p.text("p2", 150, 550);

        }
        if (playernr == 2) {
            p.image(icon, 1810, 10, 100, 100);
            p.text("lvl:" + level, 1840, 150);
            p.text("p3", p.width / 2, 200);
        }
        if (playernr == 3) {
            p.image(icon, 1810, 950, 100, 100);
            p.text("lvl:" + level, 1750, 1010);
            p.text("p4", 1750, 500);
        }
        p.fill(0);
    }
}
