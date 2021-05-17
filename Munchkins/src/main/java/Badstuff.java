import processing.core.PApplet;

import java.util.ArrayList;

public class Badstuff {
    PApplet p;


    Badstuff(PApplet p) {
        this.p = p;
    }


    void badstuffhand(Players player, ArrayList<Players> playerList, Deck roomdiscard, Deck treasurediscard) {
        while (player.hand.size() > 0) {
            if (player.hand.get(player.hand.size() - 1).numb == 0) {
                Card card = player.hand.get(player.hand.size() - 1);
                roomdiscard.addcard(card);
                player.hand.remove(player.hand.size() - 1);
            } else {
                if (player.hand.get(player.hand.size() - 1).numb == 1) {
                    Card card = player.hand.get(player.hand.size() - 1);
                    treasurediscard.addcard(card);
                    player.hand.remove(player.hand.size() - 1);
                }
            }
        }
        //System.out.println("badstuffhand");
    }


    void badstufflevel(Players player, ArrayList<Players> playerList, int roll, Card monster) {

        if (monster.badStuff.equalsIgnoreCase("- 1 level")) {
            player.level -= 1;
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- 2 level")) {
            player.level -= 2;
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- 3 level")) {
            player.level -= 3;
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- 2 level -3 if elf")) {
            if (!player.playerClass.name.equalsIgnoreCase("elf")) {
                player.level -= 2;
            }
            if (player.playerClass.name.equalsIgnoreCase("elf")) {
                player.level -= 3;
            }
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- class if no -3lvl")) {
            player.level -= 3;
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- head and level - 1")) {
            player.level -= 1;
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("set level = to lovest player")) {
            int lovestlvl = 9;
            for (int i = 0; i < playerList.size(); i++) {
                if (playerList.get(i).level < lovestlvl) {
                    lovestlvl = playerList.get(i).level;
                }
                player.level = lovestlvl;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("roll die of less than 2 death else lose level = die")) {
            player.level -= roll;
            if (player.level < 1) {
                player.level = 1;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("player level = 1")) {
            player.level = 1;
        }
        System.out.println("badstuffloselevel");
    }

    void badstuffdeath(Players player, Deck roomlist, Deck treasurelist, ArrayList<Players> playerList, BackgroundSystem backgroundSystem, Deck roomdiscard, Deck treasurediscard,ArrayList<Card> monsterList) {

        while (player.hand.size() > 0) {
            if (player.hand.get(player.hand.size() - 1).numb == 0) {
                Card card = player.hand.get(player.hand.size() - 1);
                roomdiscard.addcard(card);
                player.hand.remove(player.hand.size() - 1);
            } else {
                if (player.hand.get(player.hand.size() - 1).numb == 1) {
                    Card card = player.hand.get(player.hand.size() - 1);
                    treasurediscard.addcard(card);
                    player.hand.remove(player.hand.size() - 1);
                }
            }

            if (player.hand.size() == 0) {

                for (int j = 0; j < 2; j++) {
                    treasurelist.drawcard(player.hand, 2, playerList, treasurediscard, roomdiscard, player, monsterList, backgroundSystem);
                    roomlist.drawcard(player.hand, 2, playerList, treasurediscard, roomdiscard, player, monsterList, backgroundSystem);

                }


            }
            player.level = 1;
            if (player.race != null) {
                roomdiscard.addcard(player.race);
                player.race = null;
            }
            if (player.playerClass != null) {
                roomdiscard.addcard(player.playerClass);
                player.playerClass = null;
            }
            if (player.race2 != null) {
                roomdiscard.addcard(player.race2);
                player.race2 = null;
            }
            if (player.playerClass2 != null) {
                roomdiscard.addcard(player.playerClass2);
                player.playerClass2 = null;
            }


            //System.out.println("badstufflosedeath");
        }
    }


    void badstuffloseitem(Card monster, Players player, ArrayList<Players> playerList, Dice die, Deck roomdisc, Deck treasuredisc, int roll) {
        if (monster.badStuff.equalsIgnoreCase("all armor")) {


            if (player.body != null) {
                treasuredisc.addcard(player.body);
                player.body = null;
            }

            if (player.hand1 != null) {
                treasuredisc.addcard(player.hand1);
                player.hand1 = null;
            }

            if (player.hand2 != null) {
                treasuredisc.addcard(player.hand2);
                player.hand2 = null;
            }

            if (player.head != null) {
                treasuredisc.addcard(player.head);
                player.head = null;
            }

            if (player.feet != null) {
                treasuredisc.addcard(player.feet);
                player.feet = null;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("foorgear")) {

            if (player.feet != null) {
                treasuredisc.addcard(player.feet);
                player.feet = null;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- class and race")) {
            if (player.playerClass != null) {
                roomdisc.addcard(player.playerClass);
                player.playerClass = null;
            }
            if (player.playerClass2 != null) {
                roomdisc.addcard(player.playerClass2);
                player.playerClass2 = null;
            }
            if (player.race != null) {
                roomdisc.addcard(player.race);
                player.race = null;
            }
            if (player.race2 != null) {
                roomdisc.addcard(player.race2);
                player.race2 = null;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- class if no -3lvl")) {
            if (player.playerClass != null) {
                roomdisc.addcard(player.playerClass);
                player.playerClass = null;
            }
            if (player.playerClass2 != null) {
                roomdisc.addcard(player.playerClass2);
                player.playerClass2 = null;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("- headgear")) {

            if (player.head != null) {
                treasuredisc.addcard(player.head);
                player.head = null;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("death if wizard instead lose class")) {
            if (player.playerClass != null && player.playerClass.name.equalsIgnoreCase("wizard")) {
                roomdisc.addcard(player.playerClass);
                player.playerClass = null;
            }
            if (player.playerClass2 != null && player.playerClass2.name.equalsIgnoreCase("wizard")) {
                roomdisc.addcard(player.playerClass2);
                player.playerClass2 = null;
            }
        }
        if (monster.badStuff.equalsIgnoreCase("lose all items and discard hand")) {
            if (player.body != null) {
                treasuredisc.addcard(player.body);
                player.body = null;
            }

            if (player.hand1 != null) {
                treasuredisc.addcard(player.hand1);
                player.hand1 = null;
            }

            if (player.hand2 != null) {
                treasuredisc.addcard(player.hand2);
                player.hand2 = null;
            }

            if (player.head != null) {
                treasuredisc.addcard(player.head);
                player.head = null;
            }

            if (player.feet != null) {
                treasuredisc.addcard(player.feet);
                player.feet = null;
            }
            if (player.utility != null) {
                treasuredisc.addcard(player.utility);
                player.utility = null;

            }
        }
        if (monster.badStuff.equalsIgnoreCase("roll die - treasure = number on die") || monster.badStuff.equalsIgnoreCase("- 2 items, players choose") || monster.badStuff.equalsIgnoreCase("-1000g of items")) {
            ArrayList<Card> treasuresList = new ArrayList<>();
            if (player.body != null) {
                treasuresList.add(player.body);
                player.body = null;
            }

            if (player.hand1 != null) {
                treasuresList.add(player.hand1);
                player.hand1 = null;
            }

            if (player.hand2 != null) {
                treasuresList.add(player.hand2);
                player.hand2 = null;
            }

            if (player.head != null) {
                treasuresList.add(player.head);
                player.head = null;
            }

            if (player.feet != null) {
                treasuresList.add(player.feet);
                player.feet = null;
            }
            if (player.utility != null) {
                treasuresList.add(player.utility);
                player.utility = null;
            }
            if (monster.badStuff.equalsIgnoreCase("roll die - treasure = number on die")) {
                for (int i = 0; i < roll; i++) {
                    if (treasuresList.size() > 0) {
                        int rando = (int) p.random(treasuresList.size());
                        Card temp = treasuresList.get(rando);
                        treasuredisc.addcard(temp);
                        treasuresList.remove(rando);
                    }
                }
            }
            if (monster.badStuff.equalsIgnoreCase("- 2 items, players choose")) {
                for (int i = 0; i < 2; i++) {
                    if (treasuresList.size() > 0) {
                        int rando = (int) p.random(treasuresList.size());
                        Card temp = treasuresList.get(rando);
                        treasuredisc.addcard(temp);
                        treasuresList.remove(rando);
                    }
                }
            }
            if (monster.badStuff.equalsIgnoreCase("highlvl take item") && treasuresList.size() > 0) {
                int highestlvl = 0;
                int playernr = 0;
                for (int i = 0; i < playerList.size(); i++) {
                    if (playerList.get(i).level > highestlvl && player != playerList.get(i)) {
                        highestlvl = playerList.get(i).level;
                        playernr = playerList.get(i).playernr;
                    }
                }
                playerList.get(playernr).hand.add(treasuresList.get((int) p.random(treasuresList.size())));
            }
            if (monster.badStuff.equalsIgnoreCase("-1000g of items")) {
                int value = 0;
                for (int i = 0; i < treasuresList.size(); i++) {
                    value += treasuresList.get(i).gold;
                }
                if (value <= 1000) {
                    for (int i = 0; i < treasuresList.size(); i++) {
                        Card temp = treasuresList.get(i);
                        roomdisc.addcard(temp);
                        treasuresList.remove(i);
                    }
                }
                if (value > 1000) {
                    ArrayList<Card> temp2 = new ArrayList<>();
                    while (value > 1000) {
                        value = 0;
                        int rando = (int) p.random(treasuresList.size());
                        Card temp = treasuresList.get(rando);
                        temp2.add(temp);
                        treasuresList.remove(rando);
                        for (int i = 0; i < treasuresList.size(); i++) {
                            value += treasuresList.get(i).gold;
                        }
                    }
                    for (int i = 0; i < treasuresList.size(); i++) {
                        Card temp = treasuresList.get(i);
                        roomdisc.addcard(temp);
                        treasuresList.remove(i);
                    }
                    for (int i = 0; i < temp2.size(); i++) {
                        Card temp = temp2.get(i);
                        treasuresList.add(temp);
                        temp2.remove(i);
                    }
                }
            }
            for (int i = 0; i < treasuresList.size(); i++) {
                if (treasuresList.get(i).type.equalsIgnoreCase("Armor") || (treasuresList.get(i).type.equalsIgnoreCase("armor big"))) {
                    if (player.body != null) {
                        if (player.body.numb == 0) {
                            roomdisc.addcard(player.body);
                        } else {
                            if (player.body.numb == 1)
                                treasuredisc.addcard(player.body);
                        }
                    }
                    treasuresList.get(i).hovering = false;
                    player.body = treasuresList.get(i);
                    treasuresList.remove(i);
                } else {
                    if (treasuresList.get(i).type.equalsIgnoreCase("headgear")) {
                        if (treasuresList != null) {
                            if (player.head.numb == 0) {
                                roomdisc.addcard(player.head);
                            } else {
                                if (player.head.numb == 1)
                                    treasuredisc.addcard(player.head);
                            }
                        }
                        player.hand.get(i).hovering = false;
                        player.head = treasuresList.get(i);
                        treasuresList.remove(i);
                    } else {
                        if (treasuresList.get(i).type.equalsIgnoreCase("footgear")) {
                            if (player.feet != null) {
                                if (player.feet.numb == 0) {
                                    roomdisc.addcard(player.feet);
                                } else {
                                    if (player.feet.numb == 1)
                                        treasuredisc.addcard(player.feet);
                                }
                            }
                            treasuresList.get(i).hovering = false;
                            player.feet = treasuresList.get(i);
                            treasuresList.remove(i);
                        } else {
                            if ((treasuresList.get(i).type.equalsIgnoreCase("1 hand") || treasuresList.get(i).type.equalsIgnoreCase("1 hand big")) && player.hand1 == null) {
                                if (player.hand1 != null) {
                                    if (player.hand1.numb == 0) {
                                        roomdisc.addcard(player.hand1);
                                    } else {
                                        if (player.hand1.numb == 1)
                                            treasuredisc.addcard(player.hand1);
                                    }
                                }
                                treasuresList.get(i).hovering = false;
                                player.hand1 = treasuresList.get(i);
                                treasuresList.remove(i);
                            } else {
                                if ((treasuresList.get(i).type.equalsIgnoreCase("1 hand") || treasuresList.get(i).type.equalsIgnoreCase("1 hand big")) && player.hand1 != null && (!player.hand1.type.equalsIgnoreCase("2 hands") || !player.hand1.type.equalsIgnoreCase("2 hands big"))) {
                                    if (player.hand2 != null) {
                                        if (player.hand2.numb == 0) {
                                            roomdisc.addcard(player.hand2);
                                        } else {
                                            if (player.hand2.numb == 1)
                                                treasuredisc.addcard(player.hand2);
                                        }
                                    }
                                    treasuresList.get(i).hovering = false;
                                    player.hand2 = treasuresList.get(i);
                                    treasuresList.remove(i);
                                } else {
                                    if (treasuresList.get(i).type.equalsIgnoreCase("Utility") || treasuresList.get(i).type.equalsIgnoreCase("Utility big")) {
                                        if (player.utility != null) {
                                            if (player.utility.numb == 0) {
                                                roomdisc.addcard(player.utility);
                                            } else {
                                                if (player.utility.numb == 1)
                                                    treasuredisc.addcard(player.utility);
                                            }
                                        }
                                        treasuresList.get(i).hovering = false;
                                        player.utility = treasuresList.get(i);
                                        treasuresList.remove(i);
                                    }
                                }
                            }
                        }
                    }
                }

            }
        }



        //System.out.println("badstuffloseitem");
    }


}
