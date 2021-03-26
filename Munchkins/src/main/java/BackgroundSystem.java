import processing.core.PApplet;

import java.util.ArrayList;

public class BackgroundSystem {
    int player;
    PApplet p;
    boolean notDoneYet = true;
    boolean removed;
    BackgroundSystem(PApplet p){
        this.p=p;
    }
    void startOfGame(ArrayList<Button> buttList, ArrayList<Players> playerList){

        if (notDoneYet==true) {
            for (int i = 0; i < 4 ; i++) {
                playerList.add(new Players(p));
            }

            buttList.add(new Button(p, 400, 400, 200, 100, "Male"));
            buttList.add(new Button(p, 700, 400, 200, 100, "Woman"));
            notDoneYet=false;
        }
        if (player>3&&removed==false){
            buttList.remove(2);
            buttList.remove(1);
            removed=true;
        }
        if(buttList.size()>=3&&buttList.get(1).tryk){
            if(player ==3){
                playerList.get(3).gender=1;
                player++;
            }
            if(player ==2){
                playerList.get(2).gender=1;
                player++;
            }
            if(player ==1){
                playerList.get(1).gender=1;
                player++;
            }
            if(player ==0){
                playerList.get(0).gender=1;
                player++;
            }
        }
        if(buttList.size()>=3&&buttList.get(2).tryk){
            if(player ==3){
                playerList.get(3).gender=2;
                player++;
            }
            if(player ==2){
                playerList.get(2).gender=2;
                player++;
            }
            if(player ==1){
                playerList.get(1).gender=2;
                player++;
            }
            if(player ==0){
                playerList.get(0).gender=2;
                player++;
            }



        }

    }

}
