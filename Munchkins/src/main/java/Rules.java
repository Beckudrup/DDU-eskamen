import processing.core.PApplet;
import processing.core.PConstants;

import java.util.ArrayList;

public class Rules {
    PApplet p;

    Rules(PApplet p) {
        this.p = p;
    }

    void displayRules(ArrayList<Button> buttList) {
        p.textSize(32);
        p.background(230);
        p.fill(0);
        p.textSize(26);
        p.text("Rules", p.width / 2, 50);

        //Overskrifter
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 5, 120, 280, 100, "Start of game"));
        buttList.add(new Button(p, 315, 120, 280, 100, "Turns"));
        buttList.add(new Button(p, 635, 120, 280, 100, "Kick Open The Door"));
        buttList.add(new Button(p, 965, 120, 280, 100, "Combat"));
        buttList.add(new Button(p, 1295, 120, 280, 100, "Death"));
        buttList.add(new Button(p, 1625, 120, 280, 100, "Run away"));
        buttList.add(new Button(p, 5, 300, 280, 100, "Ask for help"));
        buttList.add(new Button(p, 315, 300, 280, 100, "Loot the room"));
        buttList.add(new Button(p, 635, 300, 280, 100, "Curses"));
        buttList.add(new Button(p, 965, 300, 280, 100, "Class abilities"));
        buttList.add(new Button(p, 1295, 300, 280, 100, "Charity"));
        buttList.add(new Button(p, 1625, 300, 280, 100, "How to win"));
        buttList.add(new Button(p, 5, 480, 280, 100, "Game controls"));
        p.fill(0);
    }

    void rStartOfGame(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.textAlign(PConstants.CENTER);
        p.fill(0);
        p.text("Start of game", p.width / 2, 100);
        p.textSize(30);
        p.text("The games starts out with all players being level 1 and drawing two room cards and \ntwo treassure cards, and then there is a round where you can play your playable \ncards if you want before the game really begins.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);
    }

    void rTurns(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Turns", p.width / 2, 100);
        p.textSize(30);
        p.text("When your turn starts you must Kick Open The Door, after that depending on what you \ndrew different things will happen. Explained in Open Door. To end your turn \npress the end turn button, your cards will then be hidden \nand the next player can click start turn \nand then his cards will be shown.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rKickOpenTheDoor(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Kick Open The Door", p.width / 2, 100);
        p.textSize(30);
        p.text("The first time each turn when you Kick Open The Door then the card you\ndrew is placed face-up and if it is a class, race or spell card you put it in your hand, if it \nis a monster then you battle it and if it is a curse  it activates.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rCombat(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Combat", p.width / 2, 100);
        p.textSize(30);
        p.text("When you battle a monster it will have a level and to beat it you must \nhave a higher power than its level. Your power is your level and item power combined. \nIf you win you get treassure(s) and level(s), if you lose you get the Badstuff of that monster.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rDeath(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Death", p.width / 2, 100);
        p.textSize(30);
        p.text("If you lose a battle where the badstuff is you die, then you have to start \nfrom the begining discarding all of your items and go down to level 1 and draw  \ntwo room cards and two treassure cards.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rRunAway(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Run Away", p.width / 2, 100);
        p.textSize(30);
        p.text("If you can not beat the monster then you have the chance to run away.\nTo run away you must roll 5 or more with the dice. If you succed, then you don't get the Badstuff.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rAskForHelp(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Ask For Help", p.width / 2, 100);
        p.textSize(30);
        p.text("You also have the opportunity to call for help, which lets another player \nhelp you, but you must split the treassure among you.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rLootTheRoom(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Loot The Room", p.width / 2, 100);
        p.textSize(30);
        p.text("If you drew a card in Kick Open The Door then you can draw another Room card face-down\nor play a monster on yourself.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rCurses(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Curses", p.width / 2, 100);
        p.textSize(30);
        p.text("If you have a curse in your hand you can play it anytime, \neven if it is not your turn.\nIf a curse is used in battle, even if it is a curse that says next battle -5 power it will count \nin the present battle and be removed after.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rClassAbilities(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Class Abilities", p.width / 2, 100);
        p.textSize(30);
        p.text("Different classes have different abilities, but you activate them by clicking your class under the right conditions.\nThe passive abilities are always activated.", p.width / 2, 200);

        p.textAlign(PConstants.LEFT);
    }

    void rCharity(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Charity", p.width / 2, 100);
        p.textSize(30);
        p.text("At the end of your turn, if you have more than 5 cards in hand you must give cards untill \nyou have 5 cards in hand, to the player with the lowest level, \nif you are the lowest level you discard them instead.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);

    }

    void rHowToWin(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("How To Win", p.width / 2, 100);
        p.textSize(30);
        p.text("You win by getting to level 10. Every player starts at level 1, and each \ntime they win a battle they earn 1 level, unless the monster says 2 levels. \nYou can also gain levels by selling items, 1000 gold = 1 level. There are also treassure cards that lets you level up. \nThese two methods cannot raise your level to 10. The only way to get level 10 is to beat a monster.", p.width / 2, 200);
        p.textAlign(PConstants.LEFT);
    }

    void rGameControls(ArrayList<Button> buttList) {
        p.background(230);
        p.fill(0);
        buttList.add(new Button(p, 5, 25, 150, 50, "Back"));
        buttList.add(new Button(p, 100, 700, 300, 300, "<-"));
        buttList.add(new Button(p, 1500, 700, 300, 300, "->"));
        p.textSize(40);
        p.fill(0);
        p.textAlign(PConstants.CENTER);
        p.text("Game Controls", p.width / 2, 100);
        p.text("Equip item", 200, 200);
        p.text("Use ability", 700, 200);
        p.text("Hide and show hand", 1200, 200);
        p.text("Run away", 1700, 200);
        p.textSize(30);
        p.textAlign(PConstants.LEFT);
        p.text("To equip an item left \nclick on it, \nand if you have an \nopen slot for \nthat item then it will \nbe placed in that slot. \nbut you can only \nhave 1 big item \nat a time.", 50, 250);
        p.text("Ability goes here", 575, 250);
        p.text("Hide and show hand goes here", 975, 250);
        p.text("Run goes here", 1600, 250);

    }
}






