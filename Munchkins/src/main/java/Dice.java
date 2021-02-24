import processing.core.PApplet;

public class Dice {
    PApplet p;
    Dice(PApplet p){
        this.p=p;
    }
int trowDie(int high){


   return (int)p.random(0,high);
}
}
