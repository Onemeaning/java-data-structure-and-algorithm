package meituan;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        String time = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        String[] times = time.trim().split(":");
        int hour = 0, minute = 0;
        if (times[0].startsWith("0")){

            hour = Integer.parseInt(times[0].substring(1));

        }else {
            hour = Integer.parseInt(times[0]);
        }

        if (times[1].startsWith("0")){

            minute = Integer.parseInt(times[1].substring(1));

        }else {
            minute = Integer.parseInt(times[1]);
        }


        int _hour = n / 60;
        int _minute = n % 60;


        int remainMinutes = (minute - _minute)%60;
        int hours = (minute - _minute) / 60;

        if (minute - _minute < 0){
            hours += 1;
            remainMinutes += 60;
        }


        int remainHours = (hour - _hour-hours) % 24 ;
        int days = (hour - _hour- hours) / 24;
        if (hour - _hour - hours < 0){
            days += 1;
            remainHours +=24;
        }


        int result1 = x - days;
        int result = 0;

        if (result1 < 0){
            result = x + 7;
        }
        else if (result1 == 0){

            result = 7;
        }
        else {
            result = result1;
        }

        System.out.println(result);

        String reHou = "";
        String reMin = "";
        if (remainHours < 10){
            reHou = "0"+remainHours;
        }else {
            reHou = remainHours+"";
        }

        if (remainMinutes < 10){

            reMin = "0"+remainMinutes;
        }
        else {

            reMin = remainMinutes + "";
        }
        System.out.println(reHou + ":" + reMin);





    }

}
