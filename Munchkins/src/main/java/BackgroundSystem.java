import processing.core.PApplet;
import processing.data.StringList;

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

    void endturn(ArrayList<Button> buttList) {
        if (buttList.get(1).tryk) {
            if (turn < 3) {
                turn++;
                buttList.get(1).tryk = false;
            } else {
                turn = 0;
                buttList.get(1).tryk = false;
            }
        }
    }

    void loaddecks(Deck roomList, Deck tresureList, StringList roomlinklsit, StringList treasurelinkList) {
        for (int i = 0; i < roomlinklsit.size(); i++) {
            roomList.addcard(new Card(p, roomlinklsit.get(i), 0));
        }
        for (int i = 0; i < treasurelinkList.size(); i++) {
            tresureList.addcard(new Card(p, treasurelinkList.get(i), 1));
        }
    }

    void startOfGame(ArrayList<Button> buttList, ArrayList<Players> playerList, ArrayList<Deck> deckList, ImageLoader im, Deck roomlist, Deck treasurelist) {
        if (notDoneYet == true) {
            for (int i = 0; i < 4; i++) {
                playerList.add(new Players(p));
                playerList.get(i).playernr = i;
            }
            for (int i = 0; i < 2; i++) {
                deckList.add(new Deck(p));
                deckList.get(i).decknr = i;
            }
            playerList.get(0).icon = im.p1;
            playerList.get(1).icon = im.p2;
            playerList.get(2).icon = im.p3;
            playerList.get(3).icon = im.p4;
            buttList.add(new Button(p, 400, 400, 200, 100, "Male"));
            buttList.add(new Button(p, 700, 400, 200, 100, "Woman"));
            deckList.get(0).backside = im.bs1;
            deckList.get(1).backside = im.bs2;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 2; j++) {
                    treasurelist.drawcard(playerList.get(i).hand);
                    roomlist.drawcard(playerList.get(i).hand);
                }
            }
            notDoneYet = false;
        }
        if (player > 3 && removed == false) {
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


