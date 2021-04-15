import processing.core.PApplet;
import processing.core.PImage;


public class Card {
    PApplet p;
    PImage cards;
    String name;
    String type;
    int level;
    String imglink;
    int numb;


    Card(PApplet p, String imglink/*, String name, String type, int level*/, int numb) {
        this.p = p;
        cards = p.loadImage(imglink);
        this.numb = numb;

    }


}
