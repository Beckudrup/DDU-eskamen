import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {
    PImage mainmenu;
    PImage table;
    PImage p1;
    PImage p2;
    PImage p3;
    PImage p4;
    PImage bs1;
    PImage bs2;
    PApplet p;

    ImageLoader(PApplet p) {
        this.p = p;
    }

    void loadImage() {
        table = p.loadImage("bord.png");
        mainmenu = p.loadImage("munchkin.png");
        p1 = p.loadImage("munchkinmanp1.png");
        p2 = p.loadImage("munchkinwomanp2.png");
        p3 = p.loadImage("muchkinmanp3.png");
        p4 = p.loadImage("munchkintreep4.jpg");
        bs1 = p.loadImage("roomBackside.jpg");
        bs2 = p.loadImage("treassureroomBackside.jpg");
    }
}
