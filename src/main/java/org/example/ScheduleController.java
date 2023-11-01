package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleController {

    public void choice() {
        Scanner sc = new Scanner(System.in);
        List<Schedule> schedules = new ArrayList<>();
        schedules.add(new Schedule(1, "1:00 PM"));
        schedules.add(new Schedule(2, "4:00 PM"));
        schedules.add(new Schedule(3, "7:00 PM"));
        schedules.add(new Schedule(4, "10:00 PM"));

        System.out.println("영화 상영 시간표:");

        for (Schedule schedule : schedules) {
            System.out.println(schedule.getId() + ". " + schedule.getMovieTime());
        }
        while (true) {
            System.out.print("영화 시간을 선택하세요 (1, 2, 3, 4): ");
            int selectedTimeId = sc.nextInt();

            Schedule selectedSchedule = null;
            for (Schedule schedule : schedules) {
                if (schedule.getId() == selectedTimeId) {
                    selectedSchedule = schedule;
                    break;
                }
            }
            if (selectedSchedule != null) {
                String selectedTime = selectedSchedule.getMovieTime();
                System.out.println(selectedTime + "을 선택 하셨습니다. ");
                break;
            } else {
                System.out.println("올바른 선택이 아닙니다.");
            }
        }
        new SeatController().seat();
    }
}
