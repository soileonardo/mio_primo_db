import org.example.Database;

import java.sql.SQLException;
import static java.lang.IO.println;
import static java.lang.IO.readln;

void main() {
    Database database = null;
    try {
        database = Database.getInstance();

    } catch (SQLException e) {
        println("Errore nella connessione al database: " + e.getMessage());
        System.exit(-1);
    }

    println("Database connesso");

    database.insertPiatto(
            readln("Inserisci il piatto: "),
            Double.parseDouble(readln("Inserisci il prezzo: ")),
            Integer.parseInt(readln("Inserisci la quantità: "))
    );
}
