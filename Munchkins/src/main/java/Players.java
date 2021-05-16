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
    int RunAway;
    int playernr;
    int powChange;
    Card head;
    Card body;
    Card feet;
    Card hand1;
    Card hand2;
    Card utility;
    Card monster;
    Card playable;
    Card playerClass;
    Card playerClass2;
    Card race;
    Card race2;
    Card curse;
    Button showhand;
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
                                                        playables(backgroundSystem, treasure,room,treasuredisc, playerList, buttList);
                                                        if (playable != null) {
                                                            if (playable.numb == 0) {
                                                                roomdisc.addcard(playable);
                                                            } else {
                                                                if (playable.numb == 1)
                                                                    treasuredisc.addcard(playable);
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


    void displayequiped(int turn) {
        if (turn - playernr == 0) {
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
        if (feet != null && hand2 != null)
            RunAway = (handRunAway + feetRunAway);
        if(mirror){
            handpow=0;
            hand2pow=0;
            headpow=0;
            feetpow=0;
        }
            pow = headpow + bodypow + feetpow + handpow + hand2pow + level + powChange;
            // PApplet.println(pow);

    }

    void playables(BackgroundSystem backgroundSystem, Deck treasure, Deck room, Deck treasureDisc, ArrayList<Players> playerList, ArrayList<Button> buttList) {
        //if (!backgroundSystem.battlefase) {
        if (playable != null && once) {
            if (level <= 9) {
                if (playable.name.equalsIgnoreCase("Hoard!")) {
                    //Draw three treasures
                    //PApplet.println(1);
                    for (int i = 0; i < 3; i++) {
                        int random = (int) p.random(treasure.cardList.size());
                        Card drawncard = treasure.cardList.get(random);
                        hand.add(drawncard);
                        treasure.cardList.remove(random);
                    }

                }
                if (playable.name.equalsIgnoreCase("Invoke obscure rules")) {
                    level = level + 1;
                    // PApplet.println(1);
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
                                treasureDisc.addcard(utility);
                                utility = null;
                            }
                        }

                    }
                    catch (Exception y){
                        for (int i = 0; i <4 ; i++) {
                            if (playerList.get(i).utility==null|| !playerList.get(i).utility.name.equalsIgnoreCase("Hireling")){

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
                    for (int i = 0; i <4 ; i++) {
                        if (playerList.get(i).level >tmpLevel){
                            tmpSpiller = playerList.get(i);
                            tmpLevel=tmpSpiller.level;

                        }
                    }
                    try {
                        tmpSpiller.level--;
                        if (tmpSpiller.level<1)
                            tmpSpiller.level=1;
                    }
                    catch (Exception x){
                        tmpSpiller=playerList.get((int)p.random(4));
                        tmpSpiller.level--;
                        if (tmpSpiller.level<1)
                            tmpSpiller.level=1;
                    }

               //     PApplet.println(9);
                }
            }
            if (playable.name.equalsIgnoreCase("Wand of dowsing")) {
                //Go through the discards to find any one card you want. Take that card and discard this one.

                Card drawncard = treasureDisc.cardList.get(treasureDisc.cardList.size()-1);
                hand.add(drawncard);
                treasureDisc.cardList.remove(treasureDisc.cardList.size()-1);
            }
            if (playerClass == null || !playerClass.name.equalsIgnoreCase("Cleric")) {
                if (playable.name.equalsIgnoreCase("Kneepads of allure")) {
                    if (level < /*other players level*/ 10) {
                        //Player will always help, they gain no treasure, but you gain no level.
                    }
                }

            }
            if (backgroundSystem.battlefase){
                if (playable.name.equalsIgnoreCase("Freezing Explosive Potion")){
                    buttList.add(new Button(p, 200, 500, 75, 30, "Player"));
                    buttList.add(new Button(p, 200, 600, 100, 30, "Monster"));
                    System.out.println("Jeg er fan af Jamal");


                }
            }
        }
        once = false;
    }

    void raceFunction() {
        if (race != null) {
            if (race.name.equalsIgnoreCase("Elf")) {
                //runAway + 1;
                //p.println("Run Away = 1");
                //If you help kill a monster +1 level, for each killed;
            }
            if (race.name.equalsIgnoreCase("Dwarf")) {
                //Carry any number of big weapons;
                //Have 6 cards in hand (instead og 5); (er lavet i end turn)
            }
            if (race.name.equalsIgnoreCase("Halfling")) {
                //You may sell one item each turn for double price;
                //If you fail your initial Run Away roll, you may discard a card and try once more;
            }
        }
    }

    void classFunction() {
        if (playerClass != null) {
            //This if statement is only for player one;
            if (p.mouseX > 440 && p.mouseX < 440 + 60 && p.mouseY > 800 && p.mouseY < 800 + 100) {
                if (playerClass.name.equalsIgnoreCase("Thief")) {
                    //You may discard a card to backstab another player (-2 in combat). You may do this only once per victim per combat, but if two or more players are fighting a monster together, you may backstab each of them;
                    //You may discard a card to try to steal a small item carried by another player. Roll a die; 4 or more succeeds. Otherwise, you get whacked and lose a level;
                    //p.println((int) p.random(1, 7));
                }
                if (playerClass.name.equalsIgnoreCase("Cleric")) {
                    //In draw-face, you may instead take some or all top of the appropriate discard pile. You must discard one card from your hand for each card drawn;
                    //Against undead creatures
                }
                if (playerClass.name.equalsIgnoreCase("Wizard")) {
                    //Either
                    //Discard up to 3 cards after rolling a Run Away die. Each discard give +1 to Run Away;
                    //You may discard you whole hand (minimum 3) to charm a single monster instead of fighting it. Discard the monster and take its treasure, but don't gain levels. If there are other monsters in the combat fight them normally.
                }
                if (playerClass.name.equalsIgnoreCase("Warrior")) {
                    //You may discard up to 3 cards in combat; each one gives you a +1 bonus;
                    //You win ties in combat.
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
        p.textAlign(p.LEFT, p.BOTTOM);
        if (playernr == 0) {
            p.image(icon, 10, 950, 100, 100);
            p.text("lvl:" + level, 10, 920);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 10, 940);
            p.text("p1", p.width / 2, 750);
        }
        if (playernr == 1) {
            p.image(icon, 10, 10, 100, 100);
            p.text("lvl:" + level, 110, 70);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 110, 95);
            p.text("p2", 150, 550);

        }
        if (playernr == 2) {
            p.image(icon, 1810, 10, 100, 100);
            p.text("lvl:" + level, 1810, 150);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 1810, 170);
            p.text("p3", p.width / 2, 200);
        }
        if (playernr == 3) {
            p.image(icon, 1810, 950, 100, 100);
            p.text("lvl:" + level, 1710, 1010);
            p.text("power:" + (headpow + bodypow + feetpow + handpow + hand2pow + level), 1710, 1030);
            p.text("p4", 1750, 500);
        }
        p.fill(0);
    }
}
