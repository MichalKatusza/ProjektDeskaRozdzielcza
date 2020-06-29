package dao;

import model.Counters;
import model.OnBoardComputer;
import model.Speedometer;

import java.sql.*;

/***
 *  Klasa Jdbc jest g��wn� klas� warstwy danych. Zajmuje si� ��czeniem z serwerem SQL.
 *  Tworzy i uzupe�nia tabel� w bazie danych oraz sprawdza poprawno�� jej utworzenia.
 *  Udost�pnia mo�liwo�� zapisu i odczytu danych z bazy.
 */

public class Jdbc {

    /***
     * Funkcja tworz�ca tabel� w bazie danych z odpowiednimi polami.
     * @param connection Po��czenie z baz�.
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
     * Funckcja sprawdzaj�ca czy tabela danych zosta�a utworzona.
     * @param connection Po��czenie z baz�.
     * @return Zwraca ,,true" je�eli tabela zosta�a utworzona, w przeciwnym wypadku ,,false".
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
     * Funkcja zapisuj�ca aktualny stan przyrzad�w deski rozdzielczej w bazie danych.
     * @param counters Objekt licznik�w.
     * @param onBoardComputer Objekt komputera pok�adowego.
     * @param speedometer Objekt pr�dko�ciomierza.
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
     * Funkcja odczytuj�ca stan przyrzad�w deski rozdzielczej z bazy danych.
     * @param counters Objekt licznik�w.
     * @param onBoardComputer Objekt komputera pok�adowego.
     * @param speedometer Objekt pr�dko�ciomierza.
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
            ResultSet resultSet = statement.executeQuery("SELECT * \n" + ///Wybieram rekord o nawi�kszym id
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





