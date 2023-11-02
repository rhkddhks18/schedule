package org.example.seat;

import org.example.MovieReservationController;
import org.example.seat.Seat;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SeatController {
    public void seat() {
        Scanner sc = new Scanner(System.in);
        int seat_x = 0;
        int seat_y = 0;
        boolean reserved = false;
        int seatX = 7;   // 행 (알파벳)
        int seatY = 10;  // 열

        Seat[][] seats = new Seat[seatX][seatY];
        int seatId = 1;
        for (int i = 0; i < seatX; i++) {
            for (int j = 0; j < seatY; j++) {
                String seatXList = String.valueOf((char) ('A' + i));
                String seatYList = String.valueOf(j + 1);
                seats[i][j] = new Seat(seatId, seatXList, seatYList, false);
                seatId++;
            }
        }

        System.out.println("좌석 선택을 시작합니다.");

        while (true) {
            System.out.println("현재 좌석 상태:");
            displaySeat(seats);

            int seatYChoice;
            String seatXChoice;

            try {
                System.out.print("열 번호를 선택하세요 (1-" + seatY + ") 또는 '0'을 입력하여 종료: ");
                seatYChoice = sc.nextInt();
                if (seatYChoice == 0) {
                    System.out.println("좌석 선택을 취소합니다.");
                    break;
                }

                System.out.print("행 번호를 선택하세요 (A-" + (char) ('A' + seatX - 1) + "): ");
                seatXChoice = sc.next();

                if (seatYChoice < 1 || seatYChoice > seatY || seatXChoice.length() != 1 || seatXChoice.charAt(0) < 'A' || seatXChoice.charAt(0) > (char) ('A' + seatX - 1)) {
                    System.out.println("잘못된 좌석을 선택하셨습니다. 다시 선택하세요.");
                    continue;
                }

                int rowIndex = seatXChoice.charAt(0) - 'A';
                if (seats[rowIndex][seatYChoice - 1].isReserved()) {
                    System.out.println("이미 예매된 좌석입니다. 다른 좌석을 선택하세요.");
                    continue;
                }

                reserved = seats[rowIndex][seatYChoice - 1].reserve();
                displaySeat(seats);
                System.out.printf("%s%d 좌석을 선택하셨습니다.\n", seatXChoice, seatYChoice);


                seat_x = rowIndex;
                seat_y = seatYChoice - 1;
//                new MovieReservationController().complete();
                SeatRepository.seat(seat_x, seat_y, reserved);

                break;
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
                sc.nextLine();
            }
        }



    }

    public static void displaySeat(Seat[][] seats) {
        for (int i = 1; i <= seats[0].length; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print((char) ('A' + i) + " ");

            for (Seat seat : seats[i]) {
                if (seat.isReserved()) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
            }
            System.out.println();
        }
    }
}