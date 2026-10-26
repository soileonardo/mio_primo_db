package org.example;

import java.sql.*;

import static java.lang.IO.println;
import static java.lang.IO.print;

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:/Users/leona/IdeaProjects/mio_primo_db/database.db");
    }

    public static Database getInstance() throws SQLException {
        if(instance == null) {
            instance = new Database();
        }

        return instance;
    }

    public boolean insertPiatto(String piatto, double prezzo, int quantità) {
        try {
            if (!connection.isValid(5)) {
                throw new RuntimeException("Connessione persa");
            }
        } catch (SQLException e) {
            return false;
        }

        String query = "INSERT INTO sushi_menu (PIATTO, QUANTITA, PREZZO) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, piatto);
            statement.setDouble(2, prezzo);
            statement.setInt(3, quantità);
            statement.execute();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public boolean selectAll() {
        try {
            if (!connection.isValid(5)) {
                throw new RuntimeException("Connessione persa");
            }
        } catch (SQLException e) {
            return false;
        }

        String query = "SELECT * FROM sushi_menu";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            print("piatto: " + "\t");
            print("prezzo" + "\t");
            print("quantità: " + "\t");
            println();

            while (result.next()) {

            }
        } catch (SQLException e) {
            return false;
        }

        return true;
    }

    public boolean select(String nome) {
        try {
            if (!connection.isValid(5)) {
                throw new RuntimeException("Connessione persa");
            }
        } catch (SQLException e) {
            return false;
        }

        String query = "SELECT * FROM sushi_menu WHERE PIATTO = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, nome);
            statement.execute();
        } catch (SQLException e) {
            return false;
        }

        return true;
    }
}
