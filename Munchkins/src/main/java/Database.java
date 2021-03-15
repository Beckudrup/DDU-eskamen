import processing.core.PApplet;
import de.bezier.data.sql.*;
import processing.data.StringList;

public class Database {
    Card cards = new Card();
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
        while (db.next()) {
            list.append(db.getString("man"));
        }
    }
}

