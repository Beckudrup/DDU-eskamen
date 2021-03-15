import processing.core.PApplet;

public class Board {
    PApplet p;
    int playernr;
    Board(PApplet p, int nr){
        this.p = p;
        playernr=nr;
    }


    void display(){
    if(playernr>0){
     p.rect(10,950,100,100);
     p.rect(200,800,60,100);
     p.rect(280,800,60,100);
     p.rect(360,800,60,100);
     p.rect(200,920,60,100);
     p.rect(280,920,60,100);
     p.rect(360,920,60,100);

    }
    if(playernr>1){
        p.rect(10,10,100,100);


    }
    if(playernr>2){
        p.rect(1810,10,100,100);


    }
    if(playernr>3){
        p.rect(1810,950 ,100,100);


    }

    }
}
