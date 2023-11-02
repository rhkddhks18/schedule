package org.example;

import org.example.db.DBConnection;
import org.example.scedule.ScheduleController;
import org.example.seat.SeatController;

public class App {
    public App (){
        DBConnection.DB_NAME = "testS";
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "";
        DBConnection.DB_PORT = 3306;

        Container.getDBconnection().connect();
    }

    void run() {
        ScheduleController scheduleController = new ScheduleController();
        SeatController seatController = new SeatController();
        MovieReservationController movieReservationController = new MovieReservationController();
        while (true) {
            scheduleController.choice();
            seatController.seat();
            movieReservationController.complete();
        }
    }
}
