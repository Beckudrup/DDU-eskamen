import processing.core.PApplet;
import processing.core.PImage;


public class Card {
    PApplet p;
    PImage cards;
    PImage backside;
    boolean hovering;
    String name;
    String type;
    int level;
    String imglink;
    int numb;
    int power;
    int power2;


    Card(PApplet p, String imglink, int numb,String type, int power, int power2) {
        this.p = p;
        cards = p.loadImage(imglink);
        this.numb = numb;
        this.type = type;
        this.power = power;

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
