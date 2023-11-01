package org.example;

public class Seat {
    private int id;
    private String seatX;  // 행 (알파벳)
    private String seatY;  // 열
    private boolean reserved; // 좌석 예약 상태

    public Seat(int id, String seatX, String seatY, boolean reserved) {
        this.id = id;
        this.seatX = seatX;
        this.seatY = seatY;
        this.reserved = reserved;
    }


    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        reserved = true;
    }

}
