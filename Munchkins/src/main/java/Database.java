import processing.core.PApplet;
import de.bezier.data.sql.*;
import processing.data.StringList;
import java.util.ArrayList;
import java.util.List;

import static processing.core.PApplet.println;

public class Database {
    SQLite db;
    PApplet p;

    Database(PApplet p) {
        this.p = p;
    }

    void setups() {
        db = new SQLite(p, "test.db");  // open database file
        if (db.connect()) {
        }
    }

    void LoadCards(ArrayList<Cardinfo> treasureinfoList, ArrayList<Cardinfo> roominfoList ) {
        db.query("SELECT * FROM Cards WHERE Deck = 'Room cards'");
        int i = 0;
        while (db.next()) {
            Cardinfo room = new Cardinfo();
            //RoomList.append(db.getString("HTTP"));
            //TreasureList.append(db.getString("HTTP"));
            room.http = (db.getString("HTTP"));
            room.type = (db.getString("Type"));
            room.name = (db.getString("Name"));
            room.level = (db.getInt("Level"));
            roominfoList.add(room);
            //collected.type = (db.getString("Type"));
            //collected.name = (db.getString("Name"));
            //collected.level = (db.getInt("Level"));
            //cardinfoList.add(collected);
            // println(RoomList.get(i++));
        }
        db.query("SELECT * FROM Cards WHERE Deck = 'Treasure cards'");
        // db.query("SELECT * FROM Cards WHERE Deck = 'Treasure cards' AND Type = 'Monster'");
        {
            while (db.next()) {
                Cardinfo treasure = new Cardinfo();
                //TreasureList.append(db.getString("HTTP"));
                treasure.http  = (db.getString("HTTP"));
                treasure.type = (db.getString("Type"));
                treasure.name = (db.getString("Name"));
                treasure.level = (db.getInt("Level"));
                treasureinfoList.add(treasure);
                //p.println(cardinfoList.size(),cardinfoList.get(cardinfoList.size()-1).level, cardinfoList.get(cardinfoList.size()-1).name, " i = " + i++ + "   At 0:" ,cardinfoList.get(0).level, cardinfoList.get(0).name);
                //println(TreasureList.get(i++));
            }
            //p.println("Check [0] and ["+cardinfoList.size()+"]:",cardinfoList.size(),cardinfoList.get(cardinfoList.size()-1).level, cardinfoList.get(cardinfoList.size()-1).name, " i = " + i++ + "  At 0:" ,cardinfoList.get(0).level, cardinfoList.get(0).name);
        }
    }
}

