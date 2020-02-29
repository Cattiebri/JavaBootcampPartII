package lv.accenture.bootcamp.enums;

import java.util.Scanner;

public class DateValidator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter date: ");
        int date = scanner.nextInt();

        System.out.println("Enter month: ");
        int month = scanner.nextInt();

        System.out.println("Enter year: ");
        int year = scanner.nextInt();

        if (date > 0 && month > 0) {

            Month[] allMonths = Month.values();

            if(allMonths.length >= month) {
                Month monthEnum = allMonths[month - 1];
                int maxDays = monthEnum.getDays(year);
                String monthName = monthEnum.name().substring(0,1) +
                        monthEnum.name().substring(1).toLowerCase();

                if (date <= maxDays) {
                    if (year < 0) {
                        year = year * -1;
                        System.out.println(date + ". " + monthName + ", " + year + " BC");
                    } else {
                        System.out.println(date + ". " + monthName + ", " + year);
                    }
                } else {
                    System.out.println("Invalid day");
                }
            } else {
                System.out.println("Invalid month!");
            }
        } else {
            System.out.println("Invalid request");
        }

    }

}