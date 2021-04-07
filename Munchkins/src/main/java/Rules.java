import processing.core.PApplet;
import processing.core.PConstants;

public class Rules {
PApplet p;

Rules(PApplet p){
    this.p = p;
}

void displayRules(){
    p.textSize(32);
    p.text("Rules", p.width/2,50);
    p.rect(20,120,240,850); // Turns
    p.rect(290,120,240,850); // Start of game and death
    p.rect(560,120,240,850); // Combat Run away ask for help
    p.rect(830,120,240,850); // Class abilities
    p.rect(1100,120,240,850); // Open the door Loot the room
    p.rect(1370,120,240,850); // Curses
    p.rect(1640,120,240,850); // How to win
    p.fill(0);
    p.textSize(26);

    //Overskrifter
    p.text("Turns", 130,160);

    p.text("The start of \nthe game", 400,160);
    p.text("Death", 400,600);

    p.text("Combat", 670,160);
    p.text("Run away", 670,600);
    p.text("Ask for help", 670,800);

    p.text("Class abilities", 940,160);

    p.text("Open door", 1210,160);
    p.text("Loot the room", 1210,600);

    p.text("Curses", 1480,160);

    p.text("How to win", 1750,160);

    //Teksten til boksene
    p.textSize(20);
    p.textAlign(PConstants.LEFT);
    p.text("The games starts out \nwith all players beging \nlevel 1 and drawing \ntwo room cards and \ntwo treassure cards, \nand then there is a \nround where you can \nplay your playable \ncards if you want \nbefore the game \nreally begins.",300,240);
    p.text("If you lose a battle \nwhere the badstuff is \nyou die, then you have \nto start from the \nbegining at level 1 \nand draw your two \nroom cards and two \ntreassure cards",300, 650);

    p.fill(255);
    p.textAlign(PConstants.CENTER);
}
}
