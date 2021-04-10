import processing.core.PApplet;
import processing.core.PImage;
import processing.data.StringList;
import java.util.ArrayList;


public class Card {
    PApplet p;
    int x = 469, y = 300;
    PImage cards;
    int numb = 1;
    ArrayList<Database> Deck = new ArrayList<>();

    Card(PApplet p){
        this.p = p;
    }

    void Skinke(StringList RoomList, StringList TreasureList, ArrayList RoomImages, ArrayList TreasureImages) {
        for (int i = 0; i < RoomList.size(); i++) {
            cards = p.loadImage(RoomList.get(i), "png");
            RoomImages.add(cards);
        }
        for (int j = 0; j < TreasureList.size(); j++) {
            cards = p.loadImage(TreasureList.get(j), "png");
            TreasureImages.add(cards);
        }
    }


    void display() {
        p.image(cards, x, y);
    }

}
