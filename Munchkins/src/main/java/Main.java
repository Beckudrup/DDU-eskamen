import processing.core.PApplet;
import processing.core.PImage;
import processing.data.StringList;
import java.util.ArrayList;
public class Main extends PApplet {

    public static void main(String[] args) {
        PApplet.main("Main");
    }
    BackgroundSystem backgroundSystem = new BackgroundSystem(this);
    ArrayList<Button> buttList= new ArrayList<>();
    ArrayList<Players> playerList = new ArrayList<>();
    ArrayList<PImage> RoomImages = new ArrayList<>();
    ArrayList<PImage> TreasureImages = new ArrayList<>();
    StringList RoomList = new StringList();
    StringList TreasureList = new StringList();
    Dice dice = new Dice(this);
    Database database = new Database(this);
    Card cards = new Card(this);
    Menus menus = new Menus(this);
    int screenchange = 0;
    ImageLoader imageLoader = new ImageLoader(this);
    Board board;
    Rules rules = new Rules(this);
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
        database.LoadCards(RoomList, TreasureList);
        cards.Skinke(RoomList, TreasureList, RoomImages, TreasureImages);
        cards.numb = 0;

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
            backgroundSystem.startOfGame(buttList,playerList,imageLoader);
            image(RoomImages.get(cards.numb), 0, 0);
            image(TreasureImages.get(cards.numb), 300, 0);
            dice.display(200,200);
            for (int i = 0; i < 4; i++) {
                playerList.get(i).displayicon();
            }
            backgroundSystem.endturn( buttList);
            //println(backgroundSystem.turn);
        }

         if(screenchange==2){
             rules.displayRules();
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
        if(screenchange==1){
            if(mouseX>dice.posX&&mouseX<dice.posX+50&&mouseY>dice.posY&&mouseY<dice.posY+50)
            dice.trowDie(7);

        }
    }

    @Override
    public void mouseReleased() {
        for (int i = 0; i < buttList.size() ; i++) {
            buttList.get(i).release();
        }
    }

    @Override
    public void keyPressed() {
        if (key == CODED) {
            if (keyCode == UP && cards.numb < TreasureImages.size()-1) {
                if (cards.numb >= RoomImages.size()) {
                    cards.numb = (0);
                }
                cards.numb+=1;
            } else if (keyCode == DOWN) {
                if (cards.numb <= 0) {
                    cards.numb = (RoomImages.size());
                }
                cards.numb-=1;
            }
        }
    }

    void screenChanger(){
        if(screenchange==0) {
            if (buttList.size()>0&&buttList.get(0).tryk==true) {
                screenchange = 1;
                menus.notdoneyet = true;
                buttList.clear();
            }
            if (buttList.size()>0&&buttList.get(1).tryk==true){
                screenchange =2;
                menus.notdoneyet = true;
                buttList.clear();
            }
            if (buttList.size()>0&&buttList.get(2).tryk==true) {
                exit();
            }
        }
        if(screenchange==1&& screenchange==2){
            if(buttList.size()>0&&buttList.get(0).tryk==true) {
                screenchange = 0;
                menus.notdoneyet = true;
                buttList.clear();
            }
            }

        }
    }


