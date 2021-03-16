import processing.core.PApplet;
import processing.data.StringList;
import java.util.ArrayList;
public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    ArrayList<Button> buttList= new ArrayList<>();
    StringList list = new StringList();
    Database database = new Database(this);
    Card cards = new Card(this);
    Menus menus = new Menus(this);
    int screenchange = 0;
    ImageLoader imageLoader = new ImageLoader(this);
    Board board;
    @Override
    public void settings() {
        super.settings();
        size(1920,1080);
        println(dataPath("test.db"));
    }

    @Override
    public void setup() {
        super.setup();
        imageLoader.loadImage();
        database.setups();
        database.LoadCards(list);
        cards.numb = 1;
    }

    @Override
    public void draw() {
    clear();
    if(screenchange==0){
    menus.mainMenu(buttList,imageLoader);
    }
        if(screenchange==1){
            if(menus.notdoneyet)
            board = new Board(this,4);
            menus.ingame(buttList,imageLoader,board);
            cards.Skinke(list);
            cards.display();
        }

         if(screenchange==2){
           }
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).isButtonPressed();
            buttList.get(i).drawButton();

        }
        screenChanger();
    }

    @Override
    public void mouseClicked() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).registerClick(mouseX,mouseY);
            
        }
    }

    @Override
    public void mouseReleased() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).release();
        }
    }
    void screenChanger(){
        if(screenchange==0) {
            if (buttList.size()>0&&buttList.get(0).tryk==true) {
                screenchange = 1;
                menus.notdoneyet = true;
                buttList.clear();
            }
            if (buttList.size()>0&&buttList.get(2).tryk==true) {
                exit();
            }
        }
        if(screenchange==1){
            if(buttList.size()>0&&buttList.get(0).tryk==true) {
                screenchange = 0;
                menus.notdoneyet = true;
                buttList.clear();
            }

        }
    }

}
