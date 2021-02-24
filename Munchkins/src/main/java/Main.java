import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }
ArrayList<Button> buttList= new ArrayList<>();
    @Override
    public void settings() {
        super.settings();
        size(1920,1080);
    }

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void draw() {

    }

    @Override
    public void mouseClicked() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).registerClick(mouseX,mouseY);
        }
    }

    @Override
    public void mouseReleased() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).release();
        }
    }
}
