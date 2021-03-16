import processing.core.PApplet;
import processing.core.PImage;
import processing.data.StringList;

public class Card {
    PApplet p;
    int x = 469, y = 300;
    PImage cards;
    int numb = 1;

    Card(PApplet p){
        this.p = p;
    }

    void Skinke(StringList list) {
        for (int i = 0; i < numb; i++) {
            cards = p.loadImage(list.get(i), "png");
        }
        if (p.keyPressed) {
            numb++;
        }

        if (numb > list.size()) {
            numb = 1;
        }
        //println(numb + " " + list.size());
    }


    void display() {
        p.image(cards, x, y);
    }
}
