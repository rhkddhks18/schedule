package org.example;

public class MovieReservation {
    private String id;
    private String isComplete;

    public MovieReservation(String id, String isComplete) {
        this.id = id;
        this.isComplete = isComplete;
    }

    public void completeReservation() {
        isComplete = "Y";
    }

    public void cancelReservation() {
        isComplete = "N";
    }
}
