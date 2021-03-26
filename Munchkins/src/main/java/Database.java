import processing.core.PApplet;
import de.bezier.data.sql.*;
import processing.data.StringList;

import static processing.core.PApplet.println;

public class Database {
    SQLite db;
    PApplet p;

    Database(PApplet p) {
        this.p = p;
    }

    void setups()
    {
        db = new SQLite(p, "test.db" );  // open database file
        if (db.connect()) {
        }
    }

    void LoadCards(StringList list) {
        db.query("SELECT * FROM Cards");
        int i = 0;
        while (db.next()) {
            list.append(db.getString("HTTP"));
            println(list.get(i++));
        }
    }
}

