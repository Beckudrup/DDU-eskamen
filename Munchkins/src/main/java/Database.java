import processing.core.PApplet;
import de.bezier.data.sql.*;
import processing.data.StringList;

import java.util.ArrayList;

import static processing.core.PApplet.println;

public class Database {
    SQLite db;
    PApplet p;
    Cardinfo collected = new Cardinfo();

    Database(PApplet p) {
        this.p = p;
    }

    void setups() {
        db = new SQLite(p, "test.db");  // open database file
        if (db.connect()) {
        }
    }

    void LoadCards(StringList RoomList, StringList TreasureList) {
        db.query("SELECT * FROM Cards WHERE Deck = 'Room cards'");
        int i = 0;
        while (db.next()) {
            RoomList.append(db.getString("HTTP"));
            // println(RoomList.get(i++));
        }
        db.query("SELECT * FROM Cards WHERE Deck = 'Treasure cards'");
        // db.query("SELECT * FROM Cards WHERE Deck = 'Treasure cards' AND type = 'Monster'");
        {
            while (db.next()) {
                TreasureList.append(db.getString("HTTP"));
                //println(TreasureList.get(i++));
            }
        }
    }
}

