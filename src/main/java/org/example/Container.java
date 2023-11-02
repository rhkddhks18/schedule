package org.example;

import org.example.db.DBConnection;

import java.util.Scanner;

public class Container {

    private static DBConnection dbConnection;

    public static DBConnection getDBconnection() {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
