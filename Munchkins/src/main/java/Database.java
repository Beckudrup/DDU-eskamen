import processing.core.PApplet;
import de.bezier.data.sql.*;

import java.util.ArrayList;

import static processing.core.PApplet.println;

public class Database {
    SQLite db;
    PApplet p;

    Database(PApplet p) {
        this.p = p;
    }

    void setups() {
        db = new SQLite(p, "data/test.db");  // open database file
        if (db.connect()) {
            println(p.dataPath("test.db"));
        }
    }

    void LoadCards(ArrayList<Cardinfo> treasureinfoList, ArrayList<Cardinfo> roominfoList) {
        db.query("SELECT * FROM Cards WHERE Deck = 'Room cards'");
        while (db.next()) {
            Cardinfo room = new Cardinfo();
            room.http = (db.getString("HTTP"));
            room.type = (db.getString("Type"));
            room.name = (db.getString("Name"));
            room.level = (db.getInt("Level"));
            room.power = (db.getInt("Power"));
            room.power2 = (db.getInt("Power2"));
            roominfoList.add(room);
            //collected.type = (db.getString("Type"));
            //collected.name = (db.getString("Name"));
            //collected.level = (db.getInt("Level"));
            //cardinfoList.add(collected);
            // println(RoomList.get(i++));
        }
        db.query("SELECT * FROM Cards WHERE Deck = 'Treasure cards'");
        {
            while (db.next()) {
                Cardinfo treasure = new Cardinfo();
                treasure.http = (db.getString("HTTP"));
                treasure.type = (db.getString("Type"));
                treasure.name = (db.getString("Name"));
                treasure.level = (db.getInt("Level"));
                treasure.power = (db.getInt("Power"));
                treasure.power2 = (db.getInt("Power2"));
                treasureinfoList.add(treasure);
                //p.println(cardinfoList.size(),cardinfoList.get(cardinfoList.size()-1).level, cardinfoList.get(cardinfoList.size()-1).name, " i = " + i++ + "   At 0:" ,cardinfoList.get(0).level, cardinfoList.get(0).name);
                //println(TreasureList.get(i++));
            }
            //p.println("Check [0] and ["+cardinfoList.size()+"]:",cardinfoList.size(),cardinfoList.get(cardinfoList.size()-1).level, cardinfoList.get(cardinfoList.size()-1).name, " i = " + i++ + "  At 0:" ,cardinfoList.get(0).level, cardinfoList.get(0).name);
        }
    }
}

