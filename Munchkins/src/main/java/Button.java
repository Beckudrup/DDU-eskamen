import processing.core.PApplet;

public class Button {

    boolean Tryk;
    float xPos, yPos;
    float w, h;
    String text;
PApplet p;
    Button(PApplet p, float x, float y, float b, float h, String t) {
        this.p=p;
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
        p.text(text, xPos + w/2, yPos + h/2);
    }
    boolean isButtonPressed() {
        return Tryk;
    }
    void registerClick(float xin, float yin) {

        if (xin > xPos && xin < xPos + w && yin < yPos + h && yin > yPos) {
            Tryk = true;
        }
    }
    void valgt() {
        p.triangle(xPos + w/2, yPos + h + 10, xPos + w/2 - w/4, yPos + h + 30, xPos + w/2 + w/4, yPos + h + 30);
    }
    void release() {
        Tryk = false;
    }
}
