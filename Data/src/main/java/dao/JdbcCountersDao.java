package dao;

import model.Counters;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Arrays;

public class JdbcCountersDao implements Dao<Counters> {


    @Override
    public Counters read() throws IOException {
        return null;
    }

    @Override
    public void write(Counters obj) throws IOException {

    }
}
