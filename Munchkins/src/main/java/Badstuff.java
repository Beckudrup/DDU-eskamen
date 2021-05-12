import processing.core.PApplet;

import java.util.ArrayList;

public class Badstuff {
    PApplet p;
    boolean die = false;

    Badstuff(PApplet p) {
        this.p = p;
    }


    void badstuffhand(Players player, ArrayList<Players> playerList, Deck roomdiscard, Deck treasurediscard) {
        while (player.hand.size() > 0) {
            if (player.hand.get(player.hand.size() - 1).numb == 0) {
                Card card = player.hand.get(player.hand.size() - 1);
                roomdiscard.addcard(card);
                player.hand.remove(player.hand.size() - 1);
            }
            if (player.hand.get(player.hand.size() - 1).numb == 1) {
                Card card = player.hand.get(player.hand.size() - 1);
                treasurediscard.addcard(card);
                player.hand.remove(player.hand.size() - 1);
            }
        }
    }


    void badstufflevel(Players player, ArrayList<Players> playerList, int roll,Card monster) {

        if(monster.badStuff.equalsIgnoreCase("- 1 level")){
            player.level-= 1;
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- 2 level")){
            player.level-= 2;
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- 3 level")){
            player.level-= 3;
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- 2 level -3 if elf")){
            if (!player.Class.name.equalsIgnoreCase("elf")){
                player.level-= 2;}
            if (player.Class.name.equalsIgnoreCase("elf")){
                player.level-= 3;}
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- class if no -3lvl")){
            player.level-= 3;
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- head and level - 1")){
            player.level-= 1;
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("set level = to lovest player")){
            int lovestlvl=9;
            for (int i = 0; i < playerList.size(); i++) {
                if(playerList.get(i).level<lovestlvl){
                    lovestlvl=playerList.get(i).level;
                }
                player.level=lovestlvl;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("roll die of less than 2 death else lose level = die")){
            player.level-= roll;
            if (player.level<1){
                player.level=1;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("player level = 1")){
            player.level = 1;
        }
    }

    void badstuffdeath(Players player, Deck roomlist, Deck treasurelist, ArrayList<Players> playerList, BackgroundSystem backgroundSystem, Deck roomdiscard, Deck treasurediscard) {
        if (die == true) {
            while (player.hand.size() > 0) {
                if (player.hand.get(player.hand.size() - 1).numb == 0) {
                    Card card = player.hand.get(player.hand.size() - 1);
                    roomdiscard.addcard(card);
                    player.hand.remove(player.hand.size() - 1);
                }
                if (player.hand.get(player.hand.size() - 1).numb == 1) {
                    Card card = player.hand.get(player.hand.size() - 1);
                    treasurediscard.addcard(card);
                    player.hand.remove(player.hand.size() - 1);
                }
            }

            if (player.hand.size() == 0) {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        treasurelist.drawcard(playerList.get(i).hand, 0, playerList, treasurediscard, roomdiscard, player);
                        roomlist.drawcard(playerList.get(i).hand, 0, playerList, treasurediscard, roomdiscard, player);

                    }
                }
            }
            player.level = 1;
        }


    }




    void badstuffloseitem(Card monster,Players player,ArrayList<Players> playerList,Dice die,Deck roomdisc,Deck treasuredisc) {
        if(monster.badStuff.equalsIgnoreCase("all armor")){

            if(player.body!=null){
                treasuredisc.addcard(player.body);
                player.body=null;
            }

            if(player.hand1!=null){
                treasuredisc.addcard(player.hand1);
                player.hand1=null;
            }

            if(player.hand2!=null){
                treasuredisc.addcard(player.hand2);
                player.hand2=null;
            }

            if(player.head!=null){
                treasuredisc.addcard(player.head);
                player.head=null;
            }

            if(player.feet!=null){
                treasuredisc.addcard(player.feet);
                player.feet=null;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("foorgear")) {

            if(player.feet!=null){
                treasuredisc.addcard(player.feet);
                player.feet=null;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- class and race")) {
            if(player.Class!=null){
                roomdisc.addcard(player.Class);
                player.Class=null;
            }
            if(player.Class2!=null){
                roomdisc.addcard(player.Class2);
                player.Class2=null;
            }
            if(player.Race!=null){
                roomdisc.addcard(player.Race);
                player.Race=null;
            }
            if(player.Race2!=null){
                roomdisc.addcard(player.Race2);
                player.Race2=null;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- class if no -3lvl")){
            if(player.Class!=null){
                roomdisc.addcard(player.Class);
                player.Class=null;
            }
            if(player.Class2!=null){
                roomdisc.addcard(player.Class2);
                player.Class2=null;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("- headgear")) {

            if(player.head!=null){
                treasuredisc.addcard(player.head);
                player.head=null;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("death if wizard instead lose class")){
            if(player.Class!=null&&player.Class.name.equalsIgnoreCase("wizard")){
                roomdisc.addcard(player.Class);
                player.Class=null;
            }
            if(player.Class2!=null&&player.Class2.name.equalsIgnoreCase("wizard")){
                roomdisc.addcard(player.Class2);
                player.Class2=null;
            }
        }
        if(monster.badStuff.equalsIgnoreCase("lose all items and discard hand")){
            if(player.body!=null){
                treasuredisc.addcard(player.body);
                player.body=null;
            }

            if(player.hand1!=null){
                treasuredisc.addcard(player.hand1);
                player.hand1=null;
            }

            if(player.hand2!=null){
                treasuredisc.addcard(player.hand2);
                player.hand2=null;
            }

            if(player.head!=null){
                treasuredisc.addcard(player.head);
                player.head=null;
            }

            if(player.feet!=null){
                treasuredisc.addcard(player.feet);
                player.feet=null;
            }
            if(player.utility!=null){
                treasuredisc.addcard(player.utility);
                player.utility=null;
            }
        }

/*
Mist 1 item
mist 1000g værd af items
Mist specifikt gear piece
 */


    }





}
