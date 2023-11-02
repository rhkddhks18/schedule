package org.example.scedule;

import org.example.Container;
import org.example.db.DBConnection;

public class ScheduleRepository {
    private DBConnection dbConnection;

    public ScheduleRepository () {
        dbConnection = Container.getDBconnection();
    }
}
