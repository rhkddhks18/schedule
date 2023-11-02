package org.example;

import org.example.scedule.ScheduleController;

import java.util.Scanner;

public class MovieReservationController {
    public void complete() {
        Exit exit = new Exit();
        Scanner sc = new Scanner(System.in);
        
        String reservationId = null;

        MovieReservation reservation = new MovieReservation(reservationId, "N");

        System.out.print("예매를 완료하려면 'Y', 취소하려면 'N'을 입력하세요: ");
        String choice = sc.next();


        if(choice.equals("Y") || choice.equals("y")){
            System.out.println("예매가 완료되었습니다.");
            exit.exit();
        } else if (choice.equals("N") || choice.equals("n")) {
            System.out.println("예매가 취소되었습니다.");
        }
    }
}