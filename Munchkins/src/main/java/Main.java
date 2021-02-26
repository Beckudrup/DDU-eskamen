import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }
ArrayList<Button> buttList= new ArrayList<>();
    Menus menus = new Menus(this);
    int screenchange = 0;
    ImageLoader imageLoader = new ImageLoader(this);
    @Override
    public void settings() {
        super.settings();
        size(1920,1080);
    }

    @Override
    public void setup() {
        super.setup();
        imageLoader.loadImage();
    }

    @Override
    public void draw() {
clear();
    if(screenchange==0){
    menus.mainMenu(buttList,imageLoader);}
        if(screenchange==1){
            menus.ingame(imageLoader);}
        if(screenchange==2){
           }
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).isButtonPressed();
            buttList.get(i).drawButton();

        }
        screenChanger();
    }

    @Override
    public void mouseClicked() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).registerClick(mouseX,mouseY);
            println("hello");
        }
    }

    @Override
    public void mouseReleased() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).release();
        }
    }
    void screenChanger(){
        if(screenchange==0) {
            if (buttList.size()>0&&buttList.get(0).tryk==true) {
                screenchange = 1;
                menus.notdoneyet = true;
                buttList.clear();
            }
            if (buttList.size()>0&&buttList.get(2).tryk==true) {
                exit();
            }
        }
    }
}
