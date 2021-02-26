import processing.core.PApplet;
import de.bezier.data.sql.*;

public class Database {
    Cards cards = new Cards();
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

    void LoadCards() {
        db.query("SELECT * FROM Cards");
        while (db.next()) {
            list.append(db.getString("man"));
        }
    }
}

}
