package org.example;

import java.util.Scanner;

public class MovieReservationController {
    public void complete() {
        Scanner sc = new Scanner(System.in);
        
        String reservationId = null;

        MovieReservation reservation = new MovieReservation(reservationId, "N");

        System.out.print("예매를 완료하려면 'Y', 취소하려면 'N'을 입력하세요: ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("Y")) {
            reservation.completeReservation();
            System.out.println("예매가 완료되었습니다.");
            sc.close();
        } else if (choice.equalsIgnoreCase("N")) {
            reservation.cancelReservation();
            System.out.println("예매가 취소되었습니다.");
            new ScheduleController().choice();
        }

    }
}