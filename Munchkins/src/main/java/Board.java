import processing.core.PApplet;

public class Board {
    PApplet p;
    int playernr;
    Board(PApplet p, int nr){
        this.p = p;
        playernr=nr;
    }


    void display(){
        p.rect(700,270,90,150);
        p.rect(830,270,90,150);
        p.rect(960,270,90,150);
        p.rect(1090,270,90,150);
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
        p.rect(1660,40,60,100);
        p.rect(1580,40,60,100);
        p.rect(1500,40,60,100);
        p.rect(1660,160,60,100);
        p.rect(1580,160,60,100);
        p.rect(1500,160,60,100);

    }
    if(playernr>2){
        p.rect(1810,10,100,100);
        p.rect(1780,870,100,60);
        p.rect(1780,790,100,60);
        p.rect(1780,710,100,60);
        p.rect(1660,870,100,60);
        p.rect(1660,790,100,60);
        p.rect(1660,710,100,60);
    }
    if(playernr>3){
        p.rect(1810,950 ,100,100);
        p.rect(10,130,100,60);
        p.rect(10,210,100,60);
        p.rect(10,290,100,60);
        p.rect(130,130,100,60);
        p.rect(130,210,100,60);
        p.rect(130,290,100,60);

    }

    }
}
