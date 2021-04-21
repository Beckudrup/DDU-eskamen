import processing.core.PApplet;

import java.util.ArrayList;

public class BackgroundSystem {
    int player;
    PApplet p;
    boolean notDoneYet = true;
    boolean removed;
    int turn;

    BackgroundSystem(PApplet p) {
        this.p = p;
    }

    void endturn(ArrayList<Button> buttList,Players players, ArrayList <Players> playerList) {
        if (buttList.get(1).tryk) {
            if (turn < 3) {
                turn++;
                buttList.get(1).tryk = false;
            } else {
                turn = 0;
                buttList.get(1).tryk = false;
            }
            if (players.hand.size()>5 /* && !harfling er ikke en Harfling*/){

                for (int i = 0; i < 4; i++) {
                    int random = (int) p.random(players.hand.size());
                    Card card = players.hand.get(random);
                    int lowestLvL = 10;
                    int found = 0;
                    for (int j = 0; j <4 ; j++) {
                        if (playerList.get(j).level<lowestLvL&&playerList.get(j)!=players){
                            lowestLvL = players.level;
                            j=found;
                        }

                    }
                    playerList.get(found).hand.add(card);
                    players.hand.remove(random);

                }


            }
        }
    }

    void loaddecks(Deck roomList, Deck treasureList, ImageLoader il, ArrayList<Cardinfo> treasureinfoList, ArrayList<Cardinfo> roominfoList) {
        for (int i = 0; i < roominfoList.size(); i++) {
            roomList.addcard(new Card(p, roominfoList.get(i).http, 0));
            roomList.cardList.get(i).backside = il.bs1;
        }
        p.println(roominfoList.size(), roominfoList.get(roominfoList.size() - 1).level, roominfoList.get(roominfoList.size() - 1).name);
        roomList.backside = il.bs1;
        treasureList.backside = il.bs2;
        for (int i = 0; i < treasureinfoList.size(); i++) {
            treasureList.addcard(new Card(p, treasureinfoList.get(i).http, 1));
            treasureList.cardList.get(i).backside = il.bs2;
        }
        p.println(treasureinfoList.size(), treasureinfoList.get(treasureinfoList.size() - 1).level, treasureinfoList.get(treasureinfoList.size() - 1).name);
    }

    void startOfGame(ArrayList<Button> buttList, ArrayList<Players> playerList, ImageLoader im, Deck roomlist, Deck treasurelist) {
        if (notDoneYet) {
            for (int i = 0; i < 4; i++) {
                playerList.add(new Players(p));
                playerList.get(i).playernr = i;
            }
            playerList.get(0).icon = im.p1;
            playerList.get(1).icon = im.p2;
            playerList.get(2).icon = im.p3;
            playerList.get(3).icon = im.p4;
            buttList.add(new Button(p, 400, 400, 200, 100, "Male"));
            buttList.add(new Button(p, 700, 400, 200, 100, "Woman"));
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    treasurelist.drawcard(playerList.get(i).hand);
                    //p.print(treasurelist.cardList.size());
                    roomlist.drawcard(playerList.get(i).hand);
                    //p.print(roomlist.cardList.size());
                }
            }
            notDoneYet = false;
        }
        if (player > 3 && !removed) {
            buttList.remove(2);
            buttList.remove(2);
            removed = true;
        }
        if (buttList.size() >= 3 && buttList.get(2).tryk) {
            if (player == 3) {
                playerList.get(3).gender = 1;
                player++;
                buttList.get(2).tryk = false;
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



