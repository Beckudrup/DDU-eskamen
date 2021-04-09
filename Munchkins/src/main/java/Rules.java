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
    p.text("Charity", 130,680);

    p.text("The start of \nthe game", 400,160);
    p.text("Death", 400,600);

    p.text("Combat", 670,160);
    p.text("Run away", 670,570);
    p.text("Ask for help", 670,770);

    p.text("Class abilities", 940,160);

    p.text("Open door", 1210,160);
    p.text("Loot the room", 1210,660);

    p.text("Curses", 1480,160);

    p.text("How to win", 1750,160);

    //Teksten til boksene
    p.textSize(20);
    p.textAlign(PConstants.LEFT);
    p.text("When your turn starts\n you must Kick Open \nThe Door after that \ndepending on what you \ndraw different things \nwill happen. \nTo end your turn \npress the end turn \nbutton your cards \nwill then be hidden \nand the next player \ncan click start turn \nand then his cards \nwill be shown.", 30, 200);
    p.textSize(18);
    p.text("At the end of your turn, \nif you have more than \n5 cards in hand you \nmust give cards untill \nyou are at 5 cards \nin hand to the player \nwith the lowest level, \nif you are the lowest \nlevel you discard them \ninstead.",30,730);
    p.textSize(20);
    p.text("The games starts out \nwith all players beging \nlevel 1 and drawing \ntwo room cards and \ntwo treassure cards, \nand then there is a \nround where you can \nplay your playable \ncards if you want \nbefore the game \nreally begins.",300,240);
    p.text("If you lose a battle \nwhere the badstuff is \nyou die, then you have \nto start from the \nbegining at level 1 \nand draw your two \nroom cards and two \ntreassure cards.",300, 650);

    p.textSize(16);
    p.text("When you battle a \nmonster it will have \na level and to \nbeat it you must \nhave a higher power \nthan its level. \nYour power is your \nlevel and item \npower combined. \nIf you win you \nget treassure, if \nyou lose you get \nthe badstuff of that \nmonster.", 580,200);
    p.text("If you can not \nbeat the monster\nthen you have the \nchance to run away.\nTo run away you \nmust roll 5 or more\nwith the dice.",580,590);
    p.text("You also have the\nopportunity to call\nfor help, which \nlets another player \nhelp you, but \nyou must split the\ntreassure among you.",580,800);
    p.textSize(20);

    p.text("Different classes have\ndifferent abilities, but\nyou activate them\nby clicking your class\nunder the right \nconditions.\nThe passive abilities\nare always activated.",840,200);

    p.text("The first time\neach turn when you\nKick OpenThe Door\nthen the card you\ndrew is placed\nface-up and if it is\na class, race or spell\ncard you put it in\nyour hand, if it\nis a monster then\nyou battle it and\nif it is a curse\n it activates.",1120,200);
    p.text("If you drew a\ncard in Kick Open \nThe Door then you\ncan draw another\nRoom card face-down\nor play a monster\non yourself.",1120,690);

    p.text("If you have a\ncurse in your\nhand you can play \nit anytime, even\nif it is not\nyour turn.\nIf a curse is\nused in battle, \neven if it is\na curse that says\nnext battle -5 power\nit will count in\nthe present battle\nand be removed after.",1390,200);

    p.text("You win by getting \nto level 10.\nEvery player starts at \nlevel 1, and each \ntime they win a battle \nthey earn 1 level, \nunless the monster \nsays 2 levels. \nYou can also gain \nlevels by selling items, \n1000 gold = 1 level. \nThere are also \ntreassure cards \nthat lets you level up. \nThese two methods \ncannot raise your \nlevel to 10. \nThe only way to get \nlevel 10 is to \nbeat a monster.",1650,200);
    p.fill(255);
    p.textAlign(PConstants.CENTER);
}
}
