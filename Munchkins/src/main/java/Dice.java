import processing.core.PApplet;

public class Dice {
    PApplet p;
    int value = 1;
    int posX,posY;
    Dice(PApplet p){
        this.p=p;
    }
int trowDie(int high ){
    value =(int)p.random(1,high);

   return value;
}


void display(int posX,int posY){
        this.posX=posX;
        this.posY=posY;
        p.fill(255);
    p.rect(posX,posY,50,50);
    p.fill(0);
    p.text(value,posX+27,posY+30);


}
}
