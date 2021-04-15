import processing.core.PApplet;
import processing.core.PImage;
import processing.data.StringList;
import java.util.ArrayList;


public class Card {
    PApplet p;
    PImage cards;
    int numb;


    Card(PApplet p, String imglink, int numb) {
        this.p = p;
        cards = p.loadImage(imglink);
        this.numb = numb;
    }
    void display(int x, int y, int w, int h){
        p.image(cards,x,y,w,h);

    }
}
