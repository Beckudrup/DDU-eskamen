import processing.core.PApplet;

import java.util.ArrayList;

public class Menus {
    PApplet p;
    boolean notdoneyet = true;

    Menus(PApplet p) {
        this.p = p;
    }

    void mainMenu(ArrayList<Button> buttList, ImageLoader imageLoader) {
        p.image(imageLoader.mainmenu, 0, 0);
        if (notdoneyet = true) {
            buttList.add(new Button(p, 1300, 550, 200, 50, "Start game"));
            buttList.add(new Button(p, 1300, 750, 200, 50, "Rules"));
            buttList.add(new Button(p, 1300, 950, 200, 50, "Quit game"));
            notdoneyet = false;
        }
    }

    void ingame(ArrayList<Button> buttList, ImageLoader imageLoader) {
        if (notdoneyet == true) {
            buttList.add(new Button(p, 20, 120, 50, 50, "Back"));
            buttList.add(new Button(p, 1600, 500, 100, 50, "end turn"));
            notdoneyet = false;
        }
        p.image(imageLoader.table, 0, 0);

    }
}
