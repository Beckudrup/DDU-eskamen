import processing.core.PApplet;

import java.util.ArrayList;

public class Badstuff {
    PApplet p;
    boolean die = false;

    Badstuff(PApplet p) {
        this.p = p;
    }


    void badstuffhand(Players players, ArrayList<Players> playerList, Deck roomdiscard, Deck treasurediscard) {

    }

    void badstufflevel(Players players, ArrayList<Players> playerList) {


    }

    void badstuffdeath(Players players, Deck roomlist, Deck treasurelist, ArrayList<Players> playerList, BackgroundSystem backgroundSystem, Deck roomdiscard, Deck treasurediscard) {
        if (die == true) {
            while (players.hand.size() > 0) {
                if (players.hand.get(players.hand.size() - 1).numb == 0) {
                    Card card = players.hand.get(players.hand.size() - 1);
                    roomdiscard.addcard(card);
                    players.hand.remove(players.hand.size() - 1);
                }
                if (players.hand.get(players.hand.size() - 1).numb == 1) {
                    Card card = players.hand.get(players.hand.size() - 1);
                    treasurediscard.addcard(card);
                    players.hand.remove(players.hand.size() - 1);
                }
            }

            if (players.hand.size() == 0) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        treasurelist.drawcard(playerList.get(i).hand);
                        roomlist.drawcard(playerList.get(i).hand);

                    }
                }
            }
            playerList.get(backgroundSystem.turn).level = 1;
        }


    }


    void badstuffClassRace(Players players, ArrayList<Players> playerList) {

    }

    void badstuffloseitem() {

    }

    void badstuffdice(Dice dice, Players players, ArrayList<Players> playerList) {


    }


}