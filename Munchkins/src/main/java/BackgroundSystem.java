import processing.core.PApplet;

import java.util.ArrayList;

public class BackgroundSystem {
    int player;
    PApplet p;
    Badstuff badstuff = new Badstuff(p);
    boolean notDoneYet = true;
    boolean removed;
    boolean monsterfasedone;
    boolean battlefase;
    boolean gamestarted;
    boolean startofbattlefase;
    boolean forcestop1 = false;
    boolean forcestop2 = false;
    boolean genderchoose = true;
    int turn;
    int monstermodifire;
    ArrayList<Players> allyList = new ArrayList<>();

    BackgroundSystem(PApplet p) {
        this.p = p;
    }

    void endturn(ArrayList<Button> buttList, Players player, ArrayList<Players> playerList, Deck roomdisc, Deck treasuredisc, Deck room) {
        if (buttList.get(1).tryk && !battlefase) {
            if (turn < 3) {
                turn++;

                for (int i = 0; i < 4; i++) {
                    playerList.get(i).showhand.tryk = false;
                }

                buttList.get(1).tryk = false;
            } else {
                turn = 0;
                for (int i = 0; i < 4; i++) {
                    playerList.get(i).showhand.tryk = false;
                }
                buttList.get(1).tryk = false;


            }

            // buttList.get(1).tryk = false;

            if (player.monster != null) {
                player.monster = null;
            }


            //find spiller med lavest level
            int tmpLevel = player.level;
            Players tmpSpiller = player;
            for (int i = 0; i < 4; i++) {
                if (playerList.get(i).level < tmpLevel) {
                    tmpSpiller = playerList.get(i);
                    tmpLevel = tmpSpiller.level;

                }
            }

            //hvis man er lavest - discard cards
            //ellers giv til lavest level
            try {
                if (player.race == null || player.race.name.equalsIgnoreCase("Elf") || player.race.name.equalsIgnoreCase("Halfling") || player.race.name.equalsIgnoreCase("Elf") && player.race2.name.equalsIgnoreCase("Halfling") || player.race2.name.equalsIgnoreCase("Elf") && player.race.name.equalsIgnoreCase("Halfling")) {
                    while (player.hand.size() > 5) {
                        int random = (int) p.random(player.hand.size());
                        Card card = player.hand.get(random);
                        player.hand.remove(random);
                        if (tmpSpiller != player) {
                            tmpSpiller.hand.add(card);
                        } else {
                            if (card.numb == 0) {
                                roomdisc.addcard(card);
                            } else {
                                if (card.numb == 1) {
                                    treasuredisc.addcard(card);
                                }


                            }
                        }
                    }
                }
            } catch (Exception e) {
                while (player.hand.size() > 6) {
                    int random = (int) p.random(player.hand.size());
                    Card card = player.hand.get(random);
                    player.hand.remove(random);
                    if (tmpSpiller != player) {
                        tmpSpiller.hand.add(card);
                    } else {
                        if (card.numb == 0) {
                            roomdisc.addcard(card);
                        } else {
                            if (card.numb == 1) {
                                treasuredisc.addcard(card);
                            }
                        }
                    }
                }
            }


            room.fix = true;
            room.firstDraw = true;
            monsterfasedone = false;
        }
    }


    void loaddecks(Deck roomList, Deck treasureList, ImageLoader il, ArrayList<Cardinfo> treasureinfoList, ArrayList<Cardinfo> roominfoList) {
        for (int i = 0; i < roominfoList.size(); i++) {

            roomList.addcard(new Card(p, roominfoList.get(i).http, 0, roominfoList.get(i).type, roominfoList.get(i).power, roominfoList.get(i).power2, roominfoList.get(i).name, roominfoList.get(i).RunAway, roominfoList.get(i).gold, roominfoList.get(i).xp, roominfoList.get(i).xp2, roominfoList.get(i).treasures, roominfoList.get(i).badStuff, roominfoList.get(i).level, roominfoList.get(i).lable));

            roomList.cardList.get(i).backside = il.bs1;
        }
        //p.println(roominfoList.size(), roominfoList.get(roominfoList.size() - 1).level, roominfoList.get(roominfoList.size() - 1).name);
        roomList.backside = il.bs1;
        treasureList.backside = il.bs2;
        for (int i = 0; i < treasureinfoList.size(); i++) {

            treasureList.addcard(new Card(p, treasureinfoList.get(i).http, 1, treasureinfoList.get(i).type, treasureinfoList.get(i).power, treasureinfoList.get(i).power2, treasureinfoList.get(i).name, treasureinfoList.get(i).RunAway, treasureinfoList.get(i).gold, treasureinfoList.get(i).xp, treasureinfoList.get(i).xp2, treasureinfoList.get(i).treasures, treasureinfoList.get(i).badStuff, treasureinfoList.get(i).level, treasureinfoList.get(i).lable));

            treasureList.cardList.get(i).backside = il.bs2;
        }
        //p.println(treasureinfoList.size(), treasureinfoList.get(treasureinfoList.size() - 1).level, treasureinfoList.get(treasureinfoList.size() - 1).name);
    }

    void startOfGame(ArrayList<Button> buttList, ArrayList<Players> playerList, ImageLoader im, Deck roomlist, Deck treasurelist, Deck treasuredisc, Deck roomdisc, Players players) {
        if (notDoneYet) {
            for (int i = 0; i < 4; i++) {
                playerList.add(new Players(p));
                playerList.get(i).playernr = i;
            }
            playerList.get(0).icon = im.p1;
            playerList.get(1).icon = im.p2;
            playerList.get(2).icon = im.p3;
            playerList.get(3).icon = im.p4;
            buttList.add(new Button(p, 700, 400, 200, 100, "Male"));
            buttList.add(new Button(p, 1000, 400, 200, 100, "Woman"));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    treasurelist.drawcard(playerList.get(i).hand, 2, playerList, treasuredisc, roomdisc, players);
                    //p.print(treasurelist.cardList.size());
                    roomlist.drawcard(playerList.get(i).hand, 2, playerList, treasuredisc, roomdisc, players);
                    //p.print(roomlist.cardList.size());

                }
            }
            notDoneYet = false;
        }
        if (genderchoose) {
            if (player > 3 && !removed) {
                buttList.remove(2);
                buttList.remove(2);
                removed = true;
                genderchoose = false;
            }
            if (player < 4) {
                int temp = player + 1;
                p.text("Player: " + temp, 900, 350);
            }
            if (buttList.size() >= 3 && buttList.get(2).tryk) {
                if (player == 3) {
                    playerList.get(3).gender = 1;
                    player++;
                    buttList.get(2).tryk = false;
                    gamestarted = true;
                }
                if (player == 2) {
                    playerList.get(2).gender = 1;
                    player++;
                    buttList.get(2).tryk = false;
                }
                if (player == 1) {
                    playerList.get(1).gender = 1;
                    player++;
                    buttList.get(2).tryk = false;
                }
                if (player == 0) {
                    playerList.get(0).gender = 1;
                    player++;
                    buttList.get(2).tryk = false;
                }
            }
            if (buttList.size() >= 3 && buttList.get(3).tryk) {
                if (player == 3) {
                    playerList.get(3).gender = 2;
                    player++;
                    buttList.get(3).tryk = false;
                    gamestarted = true;
                }
                if (player == 2) {
                    playerList.get(2).gender = 2;
                    player++;
                    buttList.get(3).tryk = false;
                }
                if (player == 1) {
                    playerList.get(1).gender = 2;
                    player++;
                    buttList.get(3).tryk = false;
                }
                if (player == 0) {
                    playerList.get(0).gender = 2;
                    player++;
                    buttList.get(3).tryk = false;
                }
            }
        }

    }


    void displayenemy(ArrayList<Card> monsterList) {
        for (int i = 0; i < monsterList.size(); i++) {
            monsterList.get(i).display(p.width / 2 - 460 / 2 + i * 70, 460, 180, 300, 1);
        }

    }

    void battlefase(ArrayList<Button> buttList, ArrayList<Players> playerList, BackgroundSystem backgroundSystem, ArrayList<Card> monsterList, Deck roomdisc, Deck treasuredisc, Dice die, Deck room, Deck treasure) {
        if (battlefase) {

            if (startofbattlefase) {
                allyList.add(playerList.get(backgroundSystem.turn));

                buttList.add(new Button(p, 300, 300, 50, 30, "p1"));


                buttList.add(new Button(p, 400, 300, 50, 30, "p2"));


                buttList.add(new Button(p, 300, 400, 50, 30, "p3"));


                buttList.add(new Button(p, 400, 400, 50, 30, "p4"));


                buttList.add(new Button(p, 500, 700, 100, 60, "fight/run"));
                startofbattlefase = false;
            }


            for (int i = 0; i < 4; i++) {

                if (buttList.get(i + 2).tryk) {


                    boolean alredyadded = false;
                    for (int j = 0; j < allyList.size(); j++) {
                        if (allyList.get(j) == playerList.get(i)) {
                            alredyadded = true;
                        }
                    }
                    if (!alredyadded) {
                        allyList.add(playerList.get(i));
                    }
                }
            }
            for (int i = 0; i < allyList.size(); i++) {
                int temp = allyList.get(i).playernr + 1;
                p.fill(255);
                p.text("Ally: P" + temp, 500, 300 + i * 30);
            }
            int allypower = 0;
            for (int i = 0; i < allyList.size(); i++) {
                allypower += allyList.get(i).pow;
            }
            int monsterpower = monstermodifire;
            for (int i = 0; i < monsterList.size(); i++) {
                monsterpower += monsterList.get(i).level;
            }
            p.text("ally power: " + allypower, 310, 600);
            p.text("monster power: " + monsterpower, 310, 630);
            p.text("Add allies", 310, 260);
            if (buttList.get(buttList.size() - 1).tryk == true) {
                int monsterPower = monstermodifire;
                int allyPower = 0;
                for (int i = 0; i < monsterList.size(); i++) {
                    monsterPower += monsterList.get(i).level;
                }
                for (int i = 0; i < allyList.size(); i++) {
                    allyPower += allyList.get(i).pow;
                }

                if (((allyPower >= monsterPower && playerList.get(backgroundSystem.turn).playerClass != null && playerList.get(backgroundSystem.turn).playerClass.name.equalsIgnoreCase("warrior")) || (allyPower > monsterPower || forcestop2 == true)) && !forcestop1) {

                    backgroundSystem.treasuredraw(allyList, treasure, playerList, treasuredisc, roomdisc);
                    for (int i = 0; i < allyList.size(); i++) {
                        if (allyList.get(i) != playerList.get(turn) && (allyList.get(i).race != null && allyList.get(i).race.name.equalsIgnoreCase("elf") || allyList.get(i).race2 != null && allyList.get(i).race2.name.equalsIgnoreCase("elf"))) {
                            for (int j = 0; j < monsterList.size(); j++) {
                                allyList.get(i).level += 1;
                            }
                        }
                    }
                    for (int i = 0; i < monsterList.size(); i++) {
                        playerList.get(turn).level += monsterList.get(i).xp;
                    }

                }
                if (((monsterPower >= allyPower && playerList.get(backgroundSystem.turn).playerClass != null && !playerList.get(backgroundSystem.turn).playerClass.name.equalsIgnoreCase("warrior")) || monsterPower > allyPower) && (!forcestop1 || !forcestop2)) {
                    // go gennem bad stuff

                    for (int j = 0; j < allyList.size(); j++) {

                        //runaway
                        boolean iRan = false;

                        int runningaway = (int) p.random(7);
                        if (allyList.get(j).chikenonhed) {
                            runningaway = (int) p.random(7) - 1;
                        }
                        if (runningaway >= 5 - allyList.get(j).runAway) {
                            iRan = true;
                        }
                        if (iRan == false && (allyList.get(j).race != null && playerList.get(j).race.name.equalsIgnoreCase("Halfling") || iRan == false && allyList.get(j).race2 != null && playerList.get(j).race2.name.equalsIgnoreCase("Halfling")) && playerList.get(j).hand.size() > 0) {
                            runningaway = (int) p.random(7);
                            if (allyList.get(j).chikenonhed) {
                                runningaway = (int) p.random(7) - 1;
                            }
                            if (runningaway >= 5 - allyList.get(j).runAway) {
                                iRan = true;
                            }
                            int temp = (int) p.random(allyList.get(j).hand.size());
                            Card tempCard = playerList.get(j).hand.get(temp);
                            playerList.get(j).hand.remove(temp);
                            if (tempCard.numb == 0) {
                                roomdisc.addcard(tempCard);
                            }
                            if (tempCard.numb == 1) {
                                treasuredisc.addcard(tempCard);
                            }
                        }
                        if (!iRan) {
                            for (int i = 0; i < monsterList.size(); i++) {
                                int roll = die.trowDie(7);
       /* if (monsterList.get(i).badStuff.equalsIgnoreCase("NULL")){
            System.out.println("PLANTE");
        }*/
                                if (monsterList.get(i).badStuff.equalsIgnoreCase("- 1 level") || monsterList.get(i).badStuff.equalsIgnoreCase("- 2 level") || monsterList.get(i).badStuff.equalsIgnoreCase("- 3 level") || monsterList.get(i).badStuff.equalsIgnoreCase("- 2 level -3 if elf") || (monsterList.get(i).badStuff.equalsIgnoreCase("- class if no -3lvl") && playerList.get(backgroundSystem.turn).playerClass == null) || monsterList.get(i).badStuff.equalsIgnoreCase("- head and level - 1") || monsterList.get(i).badStuff.equalsIgnoreCase("set level = to lovest player") || (monsterList.get(i).badStuff.equalsIgnoreCase("Roll die of less than 2 death else lose level = die") && roll > 2) || monsterList.get(i).badStuff.equalsIgnoreCase("Player level = 1")) {
                                    badstuff.badstufflevel(playerList.get(j), playerList, roll, monsterList.get(i));
                                }
                                if (monsterList.get(i).badStuff.equalsIgnoreCase("death") || (monsterList.get(i).badStuff.equalsIgnoreCase("death if wizard instead lose class") && (allyList.get(j).playerClass == null || !allyList.get(j).playerClass.name.equalsIgnoreCase("wizard"))) || (monsterList.get(i).badStuff.equalsIgnoreCase("Roll die if less than 2 death else lose level = die") && roll < 3)) {
                                    badstuff.badstuffdeath(playerList.get(backgroundSystem.turn), room, treasure, playerList, backgroundSystem, roomdisc, treasuredisc);
                                }
                                if (monsterList.get(i).badStuff.equalsIgnoreCase("roll die - treasure = number on die") || monsterList.get(i).badStuff.equalsIgnoreCase("- Bigitem") || monsterList.get(i).badStuff.equalsIgnoreCase("All armor") || monsterList.get(i).badStuff.equalsIgnoreCase("Footgear") || monsterList.get(i).badStuff.equalsIgnoreCase("- 2 items, players choose") || monsterList.get(i).badStuff.equalsIgnoreCase("- class and race") || (monsterList.get(i).badStuff.equalsIgnoreCase("- class if no -3lvl") && allyList.get(j).playerClass != null) || monsterList.get(i).badStuff.equalsIgnoreCase("highlvl take item") || monsterList.get(i).badStuff.equalsIgnoreCase("- headgear") || monsterList.get(i).badStuff.equalsIgnoreCase("-1000g of items") || (monsterList.get(i).badStuff.equalsIgnoreCase("death if wizard instead lose class") && (allyList.get(i).playerClass.name.equalsIgnoreCase("wizard") || allyList.get(i).playerClass2.name.equalsIgnoreCase("wizard"))) || monsterList.get(i).badStuff.equalsIgnoreCase("lose all items and discard hand") || monsterList.get(i).badStuff.equalsIgnoreCase("players take 1 treasure from you board or hand")) {
                                    badstuff.badstuffloseitem(monsterList.get(i), allyList.get(j), playerList, die, roomdisc, treasuredisc, roll);
                                }
                                if (monsterList.get(i).badStuff.equalsIgnoreCase("discard hand") || monsterList.get(i).badStuff.equalsIgnoreCase("lose all items and discard hand")) {
                                    badstuff.badstuffhand(allyList.get(j), playerList, roomdisc, treasuredisc);
                                }
                            }
                        }
                    }
                }

                forcestop1 = false;
                forcestop2 = false;
                allyList.clear();
                battlefase = false;
                monsterfasedone = true;
                monstermodifire = 0;
                playerList.get(backgroundSystem.turn).powChange = 0;
                playerList.get(backgroundSystem.turn).mirror = false;
                for (int i = 0; i < 4; i++) {
                    buttList.remove(buttList.size() - 1);
                }
                while (monsterList.size() > 0) {
                    if (monsterList.get(monsterList.size() - 1).numb == 0) {
                        monsterList.get(monsterList.size() - 1).hovering = false;
                        Card card = monsterList.get(monsterList.size() - 1);
                        roomdisc.addcard(card);
                        monsterList.remove(monsterList.size() - 1);
                    } else {
                        if (monsterList.get(monsterList.size() - 1).numb == 1) {
                            monsterList.get(monsterList.size() - 1).hovering = false;
                            Card card = monsterList.get(monsterList.size() - 1);
                            treasuredisc.addcard(card);
                            monsterList.remove(monsterList.size() - 1);
                        }
                    }
                }
            }
        }
    }

    void treasuredraw(ArrayList<Players> allyList, Deck treasure, ArrayList<Players> playerList, Deck treasuredisc, Deck roomDisc) {
        for (int i = 0; i < allyList.size(); i++) {

            treasure.drawcard(allyList.get(i).hand, 2, playerList, treasuredisc, roomDisc, allyList.get(i));

        }
    }
}



