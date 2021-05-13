import processing.core.PApplet;
import processing.core.PImage;


public class Card {
    PApplet p;
    PImage cards;
    PImage backside;
    boolean hovering;
    String name;
    String type;
    String badStuff;
    String imglink;
    int RunAway;
    int level;
    int numb;
    int power;
    int power2;
    int gold;
    int xp;
    int xp2;
    int treasures;


    Card(PApplet p, String imglink, int numb, String type, int power, int power2, String name, int RunAway, int gold, int xp, int xp2, int treasures,String badStuff,int level) {


        this.p = p;
        cards = p.loadImage(imglink);
        this.RunAway = RunAway;
        this.numb = numb;
        this.type = type;
        this.name = name;
        this.power = power;
        this.gold = gold;
        this.badStuff=badStuff;
        this.xp = xp;
        this.xp2 = xp2;
        this.treasures = treasures;
        this.level=level;
    }

    void display(int x, int y, int w, int h, int frontOrBack) {
        if (frontOrBack == 1 && !hovering)
            p.image(cards, x, y, w, h);
        if (frontOrBack == 1 && hovering)
            p.image(cards, x, y - 50, w, h);
        if (frontOrBack == 2)
            p.image(backside, x, y, w, h);
    }


}
