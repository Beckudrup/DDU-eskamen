import processing.core.PApplet;

import java.util.ArrayList;

public class BackgroundSystem {
    int player;
    PApplet p;
    boolean notDoneYet = true;
    boolean removed;
    int turn;
    BackgroundSystem(PApplet p){
        this.p=p;
    }

    void endturn(ArrayList<Button> buttList){
        if(buttList.get(1).tryk){
            if (turn<3){
                turn++;
                buttList.get(1).tryk=false;
            }else{
                turn=0;
                buttList.get(1).tryk=false;
            }

        }

    }
    void startOfGame(ArrayList<Button> buttList, ArrayList<Players> playerList,ImageLoader im){

        if (notDoneYet==true) {
            for (int i = 0; i < 4 ; i++) {
                playerList.add(new Players(p));
                playerList.get(i).playernr=i;
            }
            playerList.get(0).icon = im.p1;
            playerList.get(1).icon = im.p2;
            playerList.get(2).icon = im.p3;
            playerList.get(3).icon = im.p4;
            buttList.add(new Button(p, 400, 400, 200, 100, "Male"));
            buttList.add(new Button(p, 700, 400, 200, 100, "Woman"));
            notDoneYet=false;
        }
        if (player>3&&removed==false){
            buttList.remove(2);
            buttList.remove(1);
            removed=true;
        }
        if(buttList.size()>=3&&buttList.get(2).tryk){
            if(player ==3){
                playerList.get(3).gender=1;
                player++;
                buttList.get(2).tryk=false;
            }
            if(player ==2){
                playerList.get(2).gender=1;
                player++;
                buttList.get(2).tryk=false;
            }
            if(player ==1){
                playerList.get(1).gender=1;
                player++;
                buttList.get(2).tryk=false;
            }
            if(player ==0){
                playerList.get(0).gender=1;
                player++;
                buttList.get(2).tryk=false;
            }
        }
        if(buttList.size()>=3&&buttList.get(3).tryk){
            if(player ==3){
                playerList.get(3).gender=2;
                player++;
                buttList.get(3).tryk=false;
            }
            if(player ==2){
                playerList.get(2).gender=2;
                player++;
                buttList.get(3).tryk=false;
            }
            if(player ==1){
                playerList.get(1).gender=2;
                player++;
                buttList.get(3).tryk=false;
            }
            if(player ==0){
                playerList.get(0).gender=2;
                player++;
                buttList.get(3).tryk=false;
            }



        }

    }

}
