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
    int feetRunAway;
    int handRunAway;
    int pow;
    int runAway;
    int playernr;
    int powChange;
    Card head;
    Card card;
    Card body;
    Card feet;
    Card hand1;
    Card hand2;
    Card utility;
    Card monster;
    Card playable;
    Card usable;
    Card playerClass;
    Card playerClass2;
    Card race;
    Card race2;
    Button showhand;
    boolean big;
    boolean wanderingMonster;
    boolean once;
    boolean mirror;
    boolean chikenonhed;


    ArrayList<Card> hand = new ArrayList();

    Players(PApplet p) {
        this.p = p;
        showhand = new Button(p, 10, 10, 130, 50, "Show hand");
    }

    void selectCard(Deck roomdisc, Deck treasuredisc, BackgroundSystem backgroundSystem, ArrayList<Card> monsterList, Deck treasure, Deck room, ArrayList<Players> playerList, ArrayList<Button> buttList) {
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
                    if (hand.get(i).type.equalsIgnoreCase("armor big")) {
                        big = true;
                        if (race != null && !race.name.equalsIgnoreCase("dwarf") || race2 != null && !race2.name.equalsIgnoreCase("dwarf")) {
                            if (hand1 != null && (hand1.type.equalsIgnoreCase("1 hand big") || hand1.type.equalsIgnoreCase("2 hand big"))) {
                                treasuredisc.addcard(hand1);
                                hand1 = null;
                            }
                            if (hand2 != null && (hand2.type.equalsIgnoreCase("1 hand big") || hand2.type.equalsIgnoreCase("2 hand big"))) {
                                treasuredisc.addcard(hand2);
                                hand2 = null;
                            }
                            if (utility != null && utility.type.equalsIgnoreCase("Utility big")) {
                                treasuredisc.addcard(utility);
                                utility = null;
                            }
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
                            if (((hand.get(i).type.equalsIgnoreCase("1 hand") || hand.get(i).type.equalsIgnoreCase("1 hand big")) && hand1 == null)) {
                                if (hand1 != null) {
                                    if (hand1.numb == 0) {
                                        roomdisc.addcard(hand1);
                                    } else {
                                        if (hand1.numb == 1)
                                            treasuredisc.addcard(hand1);
                                    }
                                }
                                if (hand.get(i).type.equalsIgnoreCase("1 hand big") || hand.get(i).type.equalsIgnoreCase("2 hand big")) {
                                    big = true;
                                    if (race != null && !race.name.equalsIgnoreCase("dwarf") || race2 != null && !race2.name.equalsIgnoreCase("dwarf")) {
                                        if (body != null && body.type.equalsIgnoreCase("armor big")) {
                                            treasuredisc.addcard(body);
                                            body = null;
                                        }
                                        if (hand2 != null && (hand2.type.equalsIgnoreCase("1 hand big") || hand2.type.equalsIgnoreCase("2 hand big"))) {
                                            treasuredisc.addcard(hand2);
                                            hand2 = null;
                                        }
                                        if (utility != null && utility.type.equalsIgnoreCase("Utility big")) {
                                            treasuredisc.addcard(utility);
                                            utility = null;
                                        }
                                    }
                                }
                                hand.get(i).hovering = false;
                                hand1 = hand.get(i);
                                hand.remove(i);
                            } else {
                                if (((hand.get(i).type.equalsIgnoreCase("1 hand") || hand.get(i).type.equalsIgnoreCase("1 hand big")) && hand1 != null && (!hand1.type.equalsIgnoreCase("2 hands") || !hand1.type.equalsIgnoreCase("2 hands big")))) {
                                    if (hand2 != null) {
                                        if (hand2.numb == 0) {
                                            roomdisc.addcard(hand2);
                                        } else {
                                            if (hand2.numb == 1)
                                                treasuredisc.addcard(hand2);
                                        }
                                    }
                                    if (hand.get(i).type.equalsIgnoreCase("1 hand big") || hand.get(i).type.equalsIgnoreCase("2 hand big")) {
                                        big = true;
                                        if (race != null && !race.name.equalsIgnoreCase("dwarf") || race2 != null && !race2.name.equalsIgnoreCase("dwarf")) {
                                            if (body != null && body.type.equalsIgnoreCase("armor big")) {
                                                treasuredisc.addcard(body);
                                                body = null;
                                            }
                                            if (hand1 != null && (hand1.type.equalsIgnoreCase("1 hand big") || hand1.type.equalsIgnoreCase("2 hand big"))) {
                                                treasuredisc.addcard(hand1);
                                                hand1 = null;
                                            }
                                            if (utility != null && utility.type.equalsIgnoreCase("Utility big")) {
                                                treasuredisc.addcard(utility);
                                                utility = null;
                                            }
                                        }
                                    }
                                    hand.get(i).hovering = false;
                                    hand2 = hand.get(i);
                                    hand.remove(i);
                                } else {
                                    if (hand.get(i).type.equalsIgnoreCase("Class")) {
                                        if (playerClass != null) {
                                            if (playerClass.numb == 0) {
                                                roomdisc.addcard(playerClass);
                                            } else {
                                                if (playerClass.numb == 1)
                                                    treasuredisc.addcard(playerClass);
                                            }
                                        }
                                        hand.get(i).hovering = false;
                                        playerClass = hand.get(i);
                                        playerClass.name = hand.get(i).name;
                                        hand.remove(i);
                                    } else {
                                        if (hand.get(i).type.equalsIgnoreCase("Race")) {
                                            if (race != null) {
                                                if (race.numb == 0) {
                                                    roomdisc.addcard(race);
                                                } else {
                                                    if (race.numb == 1)
                                                        treasuredisc.addcard(race);
                                                }
                                            }
                                            hand.get(i).hovering = false;
                                            race = hand.get(i);
                                            hand.remove(i);
                                        } else {
                                            if ((hand.get(i).type.equalsIgnoreCase("Utility") || hand.get(i).type.equalsIgnoreCase("Utility big"))) {
                                                if (utility != null) {
                                                    if (utility.numb == 0) {
                                                        roomdisc.addcard(utility);
                                                    } else {
                                                        if (utility.numb == 1)
                                                            treasuredisc.addcard(utility);
                                                    }
                                                }
                                                if (hand.get(i).type.equalsIgnoreCase("utility big")) {
                                                    big = true;
                                                    if (race != null && !race.name.equalsIgnoreCase("dwarf") || race2 != null && !race2.name.equalsIgnoreCase("dwarf")) {
                                                        if (hand1 != null && (hand1.type.equalsIgnoreCase("1 hand big") || hand1.type.equalsIgnoreCase("2 hand big"))) {
                                                            treasuredisc.addcard(hand1);
                                                            hand1 = null;
                                                        }
                                                        if (hand2 != null && (hand2.type.equalsIgnoreCase("1 hand big") || hand2.type.equalsIgnoreCase("2 hand big"))) {
                                                            treasuredisc.addcard(hand2);
                                                            hand2 = null;
                                                        }
                                                        if (body != null && body.type.equalsIgnoreCase("armor big")) {
                                                            treasuredisc.addcard(body);
                                                            body = null;
                                                        }
                                                    }
                                                }
                                                hand.get(i).hovering = false;
                                                utility = hand.get(i);
                                                hand.remove(i);
                                            } else {

                                                if (hand.get(i).type.equalsIgnoreCase("Monster") && !backgroundSystem.monsterfasedone && (!backgroundSystem.battlefase || wanderingMonster)) {
                                                    hand.get(i).hovering = false;
                                                    Card temp = hand.get(i);
                                                    monsterList.add(temp);
                                                    backgroundSystem.startofbattlefase = true;
                                                    backgroundSystem.battlefase = true;
                                                    hand.remove(i);
                                                    wanderingMonster = false;

                                                } else {
                                                    if (hand.get(i).type.equalsIgnoreCase("Playable")) {

                                                        hand.get(i).hovering = false;
                                                        playable = hand.get(i);
                                                        playable.name = hand.get(i).name;
                                                        once = true;
                                                        hand.remove(i);
                                                        playables(backgroundSystem, treasure, room, treasuredisc, playerList);
                                                        if (playable != null) {
                                                            if (playable.numb == 0) {
                                                                roomdisc.addcard(playable);
                                                            } else {
                                                                if (playable.numb == 1)
                                                                    treasuredisc.addcard(playable);
                                                            }
                                                        }
                                                    } else {
                                                        if (hand.get(i).type.equalsIgnoreCase("Usable")) {

                                                            hand.get(i).hovering = false;
                                                            usable = hand.get(i);
                                                            usable.name = hand.get(i).name;
                                                            once = true;
                                                            hand.remove(i);
                                                            usable(buttList, treasure, treasuredisc, playerList, backgroundSystem);
                                                            if (usable != null) {
                                                                if (usable.numb == 0) {
                                                                    roomdisc.addcard(usable);
                                                                } else {
                                                                    if (usable.numb == 1)
                                                                        treasuredisc.addcard(usable);
                                                                }
                                                            }
                                                        } else {
                                                            if (hand.get(i).type.equalsIgnoreCase("Card")) {

                                                                hand.get(i).hovering = false;
                                                                card = hand.get(i);
                                                                card.name = hand.get(i).name;
                                                                once = true;
                                                                hand.remove(i);
                                                                roombuffs(treasure, backgroundSystem);
                                                                if (card != null) {
                                                                    if (card.numb == 0) {
                                                                        roomdisc.addcard(card);
                                                                    }
                                                                }


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
            }
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
            feetRunAway = (feet.RunAway);
        }
        if (hand1 != null) {
            handpow = (hand1.power);
        }
        if (hand2 != null) {
            hand2pow = (hand2.power);
            handRunAway = (hand2.RunAway);
        }

        runAway = (handRunAway + feetRunAway);
        if (race != null && race.name.equalsIgnoreCase("elf") || race2 != null && race2.name.equalsIgnoreCase("elf"))
            runAway += 1;
        if (mirror) {
            handpow = 0;
            hand2pow = 0;
            headpow = 0;
            feetpow = 0;
        }
        pow = headpow + bodypow + feetpow + handpow + hand2pow + level + powChange;
        // PApplet.println(pow);

    }

    void playables(BackgroundSystem backgroundSystem, Deck treasure, Deck room, Deck treasureDisc, ArrayList<Players> playerList) {
        //if (!backgroundSystem.battlefase) {
        if (playable != null && once) {
            if (level <= 8) {
                if (playable.name.equalsIgnoreCase("Invoke obscure rules")) {
                    level += 1;
                    // PApplet.println(1);
                }
                if (playable.name.equalsIgnoreCase("Whine at the GM")) {
                    int tmpLevel = level;
                    Players tmpSpiller;
                    for (int i = 0; i < 4; i++) {
                        if (playerList.get(i).level > tmpLevel) {
                            tmpSpiller = playerList.get(i);
                            tmpLevel = tmpSpiller.level;
                        }
                    }
                    if (level != tmpLevel) {
                        level += 1;
                    }

                }
                if (playable.name.equalsIgnoreCase("Bribe GM with food")) {
                    PApplet.println(2);
                    level += 1;
                }

                if (playable.name.equalsIgnoreCase("Potion of general studliness")) {
                    level += 1;
                    PApplet.println("James beyleygh");
                }
                if (playable.name.equalsIgnoreCase("1,000 gold peices")) {
                    level += 1;
                    //   PApplet.println(4);
                }
                if (playable.name.equalsIgnoreCase("Boil an anthill")) {
                    PApplet.println(5);
                    level += 1;
                }
                if (playable.name.equalsIgnoreCase("Convenient addition error")) {
                    level += 1;
                    //  PApplet.println(6);
                }
                if (playable.name.equalsIgnoreCase("Mutilate the bodies")  /*&& backgroundSyste.battlefase ;; end of *any* combat */) {
                    level += 1;
                    //    PApplet.println(7);

                }
                //If hireling is on the bord utility.name.equalsIgnoreCase("Hireling")
                if (playable.name.equalsIgnoreCase("Kill the hireling")) {
                    try {
                        for (int i = 0; i < 4; i++) {
                            if (playerList.get(i).utility.name.equalsIgnoreCase("Hireling")) {
                                level += 1;
                                treasureDisc.addcard(playerList.get(i).utility);
                                playerList.get(i).utility = null;
                            }
                        }
                        System.out.println("YAYAYAY??????????????????????????????????");
                    } catch (Exception y) {

                        for (int i = 0; i < 4; i++) {
                            if (playerList.get(i).utility == null || !playerList.get(i).utility.name.equalsIgnoreCase("Hireling")) {

                            }
                        }

                    }
                }
                //     PApplet.println(8);


                if (playable.name.equalsIgnoreCase("Steal a level")) {
                    //Selected person level = level -1;
                    level += 1;
                    int tmpLevel = level;
                    Players tmpSpiller = null;
                    for (int i = 0; i < 4; i++) {
                        if (playerList.get(i).level > tmpLevel) {
                            tmpSpiller = playerList.get(i);
                            tmpLevel = tmpSpiller.level;

                        }
                    }
                    try {
                        tmpSpiller.level--;
                        if (tmpSpiller.level < 1)
                            tmpSpiller.level = 1;
                    } catch (Exception x) {
                        tmpSpiller = playerList.get((int) p.random(4));
                        tmpSpiller.level--;
                        if (tmpSpiller.level < 1)
                            tmpSpiller.level = 1;
                    }

                    //     PApplet.println(9);
                }
            }
            if (playable.name.equalsIgnoreCase("Hoard!")) {
                //Draw three treasures
                //PApplet.println(1);
                if (treasure.cardList.size() < 3) {
                    treasure.resuffle(treasureDisc, 1);
                }
                for (int i = 0; i < 3; i++) {
                    int random = (int) p.random(treasure.cardList.size());
                    Card drawncard = treasure.cardList.get(random);
                    hand.add(drawncard);
                    treasure.cardList.remove(random);
                }

            }
            if (playable.name.equalsIgnoreCase("Wand of dowsing")) {
                //Go through the discards to find any one card you want. Take that card and discard this one.
                if (treasureDisc.cardList.size() > 0) {
                    Card drawncard = treasureDisc.cardList.get(treasureDisc.cardList.size() - 1);
                    hand.add(drawncard);
                    treasureDisc.cardList.remove(treasureDisc.cardList.size() - 1);
                }
            }
            if (playerClass == null || !playerClass.name.equalsIgnoreCase("Cleric")) {
                if (playable.name.equalsIgnoreCase("Kneepads of allure")) {
                    if (level < /*other players level*/ 10) {
                        //Player will always help, they gain no treasure, but you gain no level.
                    }
                }
            }
        }
        once = false;
    }

    void usable(ArrayList<Button> buttList, Deck treasure, Deck treasuredisc, ArrayList<Players> playerList, BackgroundSystem backgroundSystem) {
        if (backgroundSystem.battlefase) {
            if (usable.name.equalsIgnoreCase("Potion of Idiotic Bravery") || usable.name.equalsIgnoreCase("Nasty-tasting sports drink") || usable.name.equalsIgnoreCase("Potion of halitosis") || usable.name.equalsIgnoreCase("Sleep Potion")) {
                //giv plus 2 til spiller siden eller monster siden i en combat
                powChange += 2;
                //monster.level += 2;

            }
            if (usable.name.equalsIgnoreCase("Cotion of Ponfusion") || usable.name.equalsIgnoreCase("Freezing explosive potion") || usable.name.equalsIgnoreCase("Flaming poison potion")) {
                //giv plus 3 til spiller siden eller monster siden i en combat
                powChange += 3;
                // monster.level += 3;

            }
            if (usable.name.equalsIgnoreCase("Magic missile") || usable.name.equalsIgnoreCase("Electric radioactive acid potion") || usable.name.equalsIgnoreCase("Pretty Ballons")) {
                //giv plus 5 til spiller siden eller monster siden i en combat


                powChange += 5;

            }
            if (usable.name.equalsIgnoreCase("Doppelganger")) {
                //double ens power
                powChange = pow * 2;
            }
            if (usable.name.equalsIgnoreCase("Yuppie water")) {
                //+2 til alle elfs
                for (int i = 0; i < 4; i++) {
                    if (playerList.get(i).race.name.equalsIgnoreCase("Elf") || playerList.get(i).race2.name.equalsIgnoreCase("Elf")) {
                        playerList.get(i).powChange += 2;
                    }
                }

            }
            if ((usable.name.equalsIgnoreCase("Instant wall") || usable.name.equalsIgnoreCase("Invisibility Potion") || usable.name.equalsIgnoreCase("Friendship potion")) && backgroundSystem.battlefase) {
                //Fjern monster ingen treasure ingen level

                buttList.get(buttList.size() - 1).tryk = true;
                backgroundSystem.forcestop1 = true;


            }
            if ((usable.name.equalsIgnoreCase("Magic Lamp") || usable.name.equalsIgnoreCase("Pollymorph Potion")) && backgroundSystem.battlefase) {
                //Fjern monster men få treasure INTET LEVEL
                buttList.get(buttList.size() - 1).tryk = true;
                backgroundSystem.forcestop2 = true;
            }

        }
        once = false;

    }

    void roombuffs(Deck treasure, BackgroundSystem backgroundSystem) {
        if (card.name.equalsIgnoreCase("baby")) {
            backgroundSystem.monstermodifire -= 5;
            treasure.allowedTreasure -= 1;
        }
        if (card.name.equalsIgnoreCase("Enraged") || card.name.equalsIgnoreCase("Intelligent")) {
            backgroundSystem.monstermodifire += 5;
            treasure.allowedTreasure += 1;
        }
        if (card.name.equalsIgnoreCase("humongous") || card.name.equalsIgnoreCase("ancient")) {
            backgroundSystem.monstermodifire += 10;
            treasure.allowedTreasure += 2;
        }
        once = false;
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

    void display(int turn) {
        p.fill(255);
        p.textAlign(p.LEFT, p.BOTTOM);
        int temp = playernr + 1;

        if (turn - playernr == 0) {
            if (hand.size() > 0) {
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
            p.image(icon, 10, 950, 100, 100);
            p.text("lvl:" + level, 10, 920);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 10, 940);
            p.text("p" + temp, p.width / 2, 750);
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
            if (playerClass != null)
                playerClass.display(440, 800, 60, 100, 1);
            if (playerClass2 != null)
                playerClass.display(440, 920, 60, 100, 1);
            if (race != null)
                race.display(520, 800, 60, 100, 1);
            if (race2 != null)
                race.display(520, 920, 60, 100, 1);
        }

        if ((playernr == 1 && turn == 0) || (playernr == 2 && turn == 1) || (playernr == 3 && turn == 2) || (playernr == 0 && turn == 3)) {
            if (hand.size() > 0) {
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
            p.image(icon, 10, 10, 100, 100);
            p.text("lvl:" + level, 110, 70);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 110, 95);
            p.text("p" + temp, 150, 550);
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
            if (playerClass != null)
                playerClass.display(370, -230, 60, 100, 1);
            if (playerClass2 != null)
                playerClass.display(370, -110, 60, 100, 1);
            if (race != null)
                race.display(450, -230, 60, 100, 1);
            if (race2 != null)
                race.display(450, -110, 60, 100, 1);
            p.popMatrix();
        }
        if ((playernr == 2 && turn == 0) || (playernr == 3 && turn == 1) || (playernr == 0 && turn == 2) || (playernr == 1 && turn == 3)) {
            if (hand.size() > 0) {
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
            p.image(icon, 1810, 10, 100, 100);
            p.text("lvl:" + level, 1810, 150);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 1810, 170);
            p.text("p" + temp, p.width / 2, 200);
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
            if (playerClass != null)
                playerClass.display(-1480, -260, 60, 100, 1);
            if (playerClass2 != null)
                playerClass.display(-1480, -140, 60, 100, 1);
            if (race != null)
                race.display(-1400, -260, 60, 100, 1);
            if (race2 != null)
                race.display(-1400, -140, 60, 100, 1);
            p.popMatrix();
        }


        if ((playernr == 3 && turn == 0) || (playernr == 0 && turn == 1) || (playernr == 1 && turn == 2) || (playernr == 2 && turn == 3)) {
            if (hand.size() > 0) {
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
            p.image(icon, 1810, 950, 100, 100);
            p.text("lvl:" + level, 1710, 1010);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 1710, 1030);
            p.text("p" + temp, 1750, 500);
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
            if (playerClass != null)
                playerClass.display(-690, 1660, 60, 100, 1);
            if (playerClass2 != null)
                playerClass.display(-690, 1780, 60, 100, 1);
            if (race != null)
                race.display(-610, 1660, 60, 100, 1);
            if (race2 != null)
                race.display(-610, 1780, 60, 100, 1);
            p.popMatrix();
        }
        p.fill(0);

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
}
