package org.example.seat;

import org.example.Container;
import org.example.db.DBConnection;

public class SeatRepository {
    private DBConnection dbConnection;

    public SeatRepository () {
        dbConnection = Container.getDBconnection();
    }

    public static void seat(int seatX, int seatY,boolean reserved) {

    }
}
