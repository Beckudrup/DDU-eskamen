import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {
PImage mainmenu;
PImage table;
    PApplet p;
    ImageLoader(PApplet p){
this.p=p;
    }

    void loadImage(){
        table = p.loadImage("bord.png");
        mainmenu = p.loadImage("munchkin.png");
    }
}
