package dao;

import model.Counters;
import model.OnBoardComputer;
import model.Speedometer;

import java.sql.*;

/***
 *  Klasa Jdbc jest g³ówn¹ klas¹ warstwy danych. Zajmuje siê ³¹czeniem z serwerem SQL.
 *  Tworzy i uzupe³nia tabelê w bazie danych oraz sprawdza poprawnoœæ jej utworzenia.
 *  Udostêpnia mo¿liwoœæ zapisu i odczytu danych z bazy.
 */

public class Jdbc {

    /***
     * Funkcja tworz¹ca tabelê w bazie danych z odpowiednimi polami.
     * @param connection Po³¹czenie z baz¹.
     */
    private void createTable(Connection connection) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "CREATE TABLE BOARD " +
                    "(ID                INTEGER PRIMARY KEY     NOT NULL," +
                    " TOTAL_MILEAGE     DOUBLE              NOT NULL, " +
                    " DAILY_MILEAGE     DOUBLE              NOT NULL, " +
                    " SPEED             DOUBLE              NOT NULL, " +
                    " AVERAGE_SPEED     DOUBLE              NOT NULL, " +
                    " MAX_SPEED         DOUBLE              NOT NULL, " +
                    " AVERAGE_FUEL      FLOAT               NOT NULL, " +
                    " DISTANCE          DOUBLE              NOT NULL, " +
                    " TRAVEL_START      INT                 NOT NULL, " +
                    " TRAVEL_STOP       INT                 NOT NULL )";
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Table created successfully");
    }

    /***
     * Funckcja sprawdzaj¹ca czy tabela danych zosta³a utworzona.
     * @param connection Po³¹czenie z baz¹.
     * @return Zwraca ,,true" je¿eli tabela zosta³a utworzona, w przeciwnym wypadku ,,false".
     */
    private boolean checkIfTableExists(Connection connection) throws SQLException {
        DatabaseMetaData dbm = connection.getMetaData();
        ResultSet tables = dbm.getTables(null, null, "BOARD", null);
        if (tables.next()) {
            System.out.println("Table exists");
            return true;
        } else {
            System.out.println("Table does not exist");
            return false;
        }
    }

    /***
     * Funkcja zapisuj¹ca aktualny stan przyrzadów deski rozdzielczej w bazie danych.
     * @param counters Objekt liczników.
     * @param onBoardComputer Objekt komputera pok³adowego.
     * @param speedometer Objekt prêdkoœciomierza.
     */
    public void write(Counters counters, OnBoardComputer onBoardComputer, Speedometer speedometer) {
        Connection connection = null;
        Statement statement = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:data.db");
            System.out.println("Opened database successfully");
            connection.setAutoCommit(false);

            if (!checkIfTableExists(connection)) createTable(connection);
            
            
            System.out.println("Saving...");
            statement = connection.createStatement();
            String sql = "INSERT INTO BOARD (TOTAL_MILEAGE,DAILY_MILEAGE,SPEED,AVERAGE_SPEED,MAX_SPEED,AVERAGE_FUEL,DISTANCE,TRAVEL_START,TRAVEL_STOP) " +
                    "VALUES (" +
                    counters.getTotalMileage() + ", " +
                    counters.getDailyMileage() + ", " +
                    speedometer.getSpeed() + ", " +
                    onBoardComputer.getAverageSpeed() + ", " +
                    onBoardComputer.getMaxSpeed() + ", " +
                    onBoardComputer.getAverageFuelConsumption() + ", " +
                    onBoardComputer.getDistance() + ", " +
                    onBoardComputer.getTravelStart() + ", " +
                    onBoardComputer.getTravelStop() + " );";

            statement.executeUpdate(sql);


            statement.close();
            connection.commit();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Records created successfully");
    }

    /***
     * Funkcja odczytuj¹ca stan przyrzadów deski rozdzielczej z bazy danych.
     * @param counters Objekt liczników.
     * @param onBoardComputer Objekt komputera pok³adowego.
     * @param speedometer Objekt prêdkoœciomierza.
     */
    public void read(Counters counters, OnBoardComputer onBoardComputer, Speedometer speedometer) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:data.db");
            System.out.println("Opened database successfully");
            connection.setAutoCommit(false);

            if (!checkIfTableExists(connection)) createTable(connection);

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * \n" + ///Wybieram rekord o nawiêkszym id
                    "    FROM    BOARD " +
                    "    WHERE   ID = (SELECT MAX(ID)  FROM BOARD);");

            if (resultSet != null) {
                counters.setTotalMileage(resultSet.getDouble("TOTAL_MILEAGE"));
                counters.setDailyMileage(resultSet.getDouble("DAILY_MILEAGE"));
                speedometer.setSpeed(resultSet.getFloat("SPEED"));
                onBoardComputer.setAverageSpeed(resultSet.getDouble("AVERAGE_SPEED"));
                onBoardComputer.setMaxSpeed(resultSet.getDouble("MAX_SPEED"));
                onBoardComputer.setAverageFuelConsumption(resultSet.getFloat("AVERAGE_FUEL"));
                onBoardComputer.setDistance(resultSet.getDouble("DISTANCE"));
                onBoardComputer.setTravelStart(resultSet.getLong("TRAVEL_START"));
                onBoardComputer.setTravelStop(resultSet.getLong("TRAVEL_STOP"));
            }
            else{
                System.out.println("Nothing to read");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Operation done successfully");
    }
}





