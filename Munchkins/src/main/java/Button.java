import processing.core.PApplet;

public class Button {

    boolean tryk;
    float xPos, yPos;
    float w, h;
    String text;
    PApplet p;

    Button(PApplet p, float x, float y, float b, float h, String t) {
        this.p = p;
        this.w = b;
        this.h = h;
        this.xPos = x;
        this.yPos = y;
        this.text = t;
    }

    public void drawButton() {
        p.textSize(24);
        p.fill(0);
        p.rect(xPos, yPos, w, h);
        p.fill(255);
        p.textAlign(p.CENTER);
        p.text(text, xPos + w / 2, yPos + h / 2);
    }

    boolean isButtonPressed() {
        return tryk;
    }

    void registerClick(float xin, float yin) {

        if (xin > xPos && xin < xPos + w && yin < yPos + h && yin > yPos) {
            tryk = true;
        }
    }

    void registerClick2(float xin, float yin) {

        if (xin > xPos && xin < xPos + w && yin < yPos + h && yin > yPos) {
            tryk = !tryk;
        }
    }



    void release() {
        tryk = false;
    }
}
