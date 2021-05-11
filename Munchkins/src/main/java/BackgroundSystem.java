import processing.core.PApplet;

import java.util.ArrayList;

public class BackgroundSystem {
    int player;
    PApplet p;
    boolean notDoneYet = true;
    boolean removed;
    boolean monsterfasedone;
    boolean battlefase;
    boolean gamestarted;
    boolean startofbattlefase;
    int turn;
    ArrayList<Players> allyList = new ArrayList<>();

    BackgroundSystem(PApplet p) {
        this.p = p;
    }

    void endturn(ArrayList<Button> buttList, Players player, ArrayList<Players> playerList, Deck roomdisc, Deck treasuredisc) {
        if (buttList.get(1).tryk) {
            if (turn < 3) {
                turn++;

                for (int i = 0; i < 4 ; i++) {
                    playerList.get(i).showhand.tryk = false;
                }
                buttList.get(1).tryk = false;
            } else {
                turn = 0;
                for (int i = 0; i < 4 ; i++) {
                    playerList.get(i).showhand.tryk=false;
                }
                buttList.get(1).tryk = false;


           }

            // buttList.get(1).tryk = false;
            /*
            roomdisc.allowedTreasure=1;
            roomdisc.firstDraw=true;
            treasuredisc.allowedTreasure=1;
            treasuredisc.firstDraw=true;

             */
            if (player.monster != null){
                player.monster = null;
            }


            if (player.hand.size() >= 6 /* && !harfling er ikke en Harfling*/) {

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
                    while (player.hand.size() > 5) {
                        int random = (int) p.random(player.hand.size());
                        Card card = player.hand.get(random);
                        player.hand.remove(random);
                        if (tmpSpiller != player){
                            tmpSpiller.hand.add(card);
                        }else{
                         if (card.numb==0){
                             roomdisc.addcard(card);
                         }else {
                             if (card.numb==1){
                                 treasuredisc.addcard(card);
                             }

                         }
                        }
                    }
                }
            }
        }



    void loaddecks(Deck roomList, Deck treasureList, ImageLoader il, ArrayList<Cardinfo> treasureinfoList, ArrayList<Cardinfo> roominfoList) {
        for (int i = 0; i < roominfoList.size(); i++) {
            roomList.addcard(new Card(p, roominfoList.get(i).http, 0, roominfoList.get(i).type, roominfoList.get(i).power, roominfoList.get(i).power2, roominfoList.get(i).name, roominfoList.get(i).RunAway));
            roomList.cardList.get(i).backside = il.bs1;
        }
        //p.println(roominfoList.size(), roominfoList.get(roominfoList.size() - 1).level, roominfoList.get(roominfoList.size() - 1).name);
        roomList.backside = il.bs1;
        treasureList.backside = il.bs2;
        for (int i = 0; i < treasureinfoList.size(); i++) {
            treasureList.addcard(new Card(p, treasureinfoList.get(i).http, 1, treasureinfoList.get(i).type, treasureinfoList.get(i).power, treasureinfoList.get(i).power2, treasureinfoList.get(i).name, treasureinfoList.get(i).RunAway));
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
                    treasurelist.drawcard(playerList.get(i).hand, 2,playerList, treasuredisc, roomdisc, players);
                    //p.print(treasurelist.cardList.size());
                    roomlist.drawcard(playerList.get(i).hand, 2, playerList,treasuredisc, roomdisc, players);
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
        if(player<4){
            int temp = player +1;
            p.text("Player: " + temp,900,350);
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

void displayenemy(ArrayList<Card> monsterList){
    for (int i = 0; i < monsterList.size(); i++) {
        monsterList.get(i).display(600+i*70,500,60,100,1);
    }

}
    void battlefase(ArrayList<Button> buttList,ArrayList<Players> playerList,BackgroundSystem backgroundSystem, ArrayList<Card> monsterList,Deck roomdisc,Deck treasuredisc){
if(battlefase) {

    if(startofbattlefase) {
        allyList.add(playerList.get(backgroundSystem.turn));
        if(backgroundSystem.turn!=0)
        buttList.add(new Button(p,200,300,50,30,"p1"));
        if(backgroundSystem.turn!=1)
        buttList.add(new Button(p,260,300,50,30,"p2"));
        if(backgroundSystem.turn!=2)
        buttList.add(new Button(p,300,300,50,30,"p3"));
        if(backgroundSystem.turn!=3)
        buttList.add(new Button(p,360,300,50,30,"p4"));
        buttList.add(new Button(p,500,700,100,60,"fight/run"));
        startofbattlefase=false;
    }
    for (int i = 0; i < 3 ; i++) {
        if(buttList.get(i+2).tryk){
            allyList.add(playerList.get(i));
        }
    }

    if(buttList.get(buttList.size()-1).tryk==true){
        int monsterPower = 0;
        int allyPower = 0;
        for (int i = 0; i < monsterList.size(); i++) {
            monsterPower += monsterList.get(i).power;
        }
        for (int i = 0; i < allyList.size(); i++) {
            allyPower += allyList.get(i).pow;
        }
if(allyPower>monsterPower) {
//treasure draw
}
if(monsterPower>allyPower){
    // go gennem bad stuff
}
allyList.clear();
battlefase=false;
        for (int i = 0; i < 4 ; i++) {
            buttList.remove(buttList.size()-1);
        }
        for (int i = 0; i < monsterList.size(); i++) {
            if (monsterList.get(i).numb == 0) {
                monsterList.get(i).hovering = false;
                Card card = monsterList.get(i);
                roomdisc.addcard(card);
                monsterList.remove(i);
            } else {
                if (monsterList.get(i).numb == 1) {
                    monsterList.get(i).hovering = false;
                    Card card = monsterList.get(i);
                    treasuredisc.addcard(card);
                    monsterList.remove(i);
                }
        }

    }

}

    }


}}



