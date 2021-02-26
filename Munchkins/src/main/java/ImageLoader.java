import processing.core.PApplet;
import processing.core.PImage;

public class ImageLoader {
PImage mainmenu;
    PApplet p;
    ImageLoader(PApplet p){
this.p=p;
    }

    void loadImage(){

        mainmenu = p.loadImage("munchkin.png");
    }
}
