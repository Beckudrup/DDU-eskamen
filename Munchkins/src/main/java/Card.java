import processing.core.PApplet;
import processing.core.PImage;
import processing.data.StringList;

public class Card {
    PApplet p;
    int x, y;
    PImage Card;
    int numb;
    
    void Skinke(StringList list) {
        for (int i = 0; i < numb; i++) {
            Card = p.loadImage(list.get(i), "png");
            p.println(list.get(i));
        }
        if (p.keyPressed) {
            numb++;
        }

        if (numb > list.size()) {
            numb = 1;
        }
        p.println(numb + " " + list.size());
    }

    void display() {
        p.image(Card, x, y);
    }
}
