package com.vsc;

import java.util.Scanner;

public class Main {

    public static void changeHour(int[][] mFinalsHours, String[][] mNames, String[][] mComments, String[][] mPlaces, int date, int hour) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new hour for this meeting: ");
        int newHour = input.nextInt();

        mFinalsHours[date][newHour - 8] = mFinalsHours[date][hour - 8];
        mFinalsHours[date][hour - 8] = 0;
        mNames[date][newHour - 8] = mNames[date][hour - 8];
        mNames[date][hour - 8] = null;
        mComments[date][newHour - 8] = mComments[date][hour - 8];
        mComments[date][hour - 8] = null;
        mPlaces[date][newHour - 8] = mPlaces[date][hour - 8];
        mPlaces[date][hour] = null;
    }

    public static String changePlace() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new place for this meeting: ");
        return input.nextLine();
    }

    public static void printMeeting(int mFinalsHours, String mNames, String mComments, String mPlaces, int hour) {
        if (mFinalsHours == 0) System.out.println("Don`t have meeting to print!");
        else
            System.out.println((hour + 8) + ":00h - " + mFinalsHours + ":00h : " + mNames + ", " + mPlaces + " Comment: " + mComments);
    }

    public static int[] searchMeetings(String[][] mNames) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of meeting: ");
        String meeting = input.nextLine();
        for (int i = 0; i < mNames.length; i++) {
            for (int j = 0; j < mNames[0].length; j++) {
                if (meeting.equals(mNames[i][j])) {
                    return new int[]{i, j};
                }
            }

        }
        return new int[]{0, 0};
    }


    public static void searchFreeTimeToMeeting(int[][] mFinalsHours) {
        Scanner input = new Scanner(System.in);


        int date;
        do {
            System.out.print("Enter date do you want your meeting: ");
            date = input.nextInt() - 1;
        } while (date < 1 || date > 31);
        System.out.print("Enter duration of the meeting in hours: ");
        int duration = input.nextInt();
        int dayOfWeek;
        do {
            System.out.print("Which day of week is 1st date of this month (1=Monday,..,7=Sunday)? ");
            dayOfWeek = input.nextInt();
        } while (dayOfWeek < 0 || dayOfWeek > 7);
        int monthLength;
        do {
            System.out.print("How many days have in this month? ");
            monthLength = input.nextInt();
        } while (monthLength < 28 || monthLength > 31);


        int freeTime = 0;
        for (int i = date; i < monthLength; i++) {
            for (int j = 0; j < mFinalsHours[0].length; j++) {
                if (mFinalsHours[i][j] == 0 && dayOfWeek != 6 && dayOfWeek != 7) {
                    freeTime++;
                    if (freeTime == duration) {
                        System.out.println("Date: " + i + "and hour: " + (j + 8) + ":00h is free.");
                    }
                }
                freeTime = 0;
                if (dayOfWeek == 7) dayOfWeek = 1;
                else dayOfWeek++;
            }
        }
    }


    public static void addMeeting(int[][] mFinalsHours, String[][] mNames, String[][] mComments, String[][] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date do you want your meeting: ");
        int date;
        do {
            date = input.nextInt();
        } while (date < 1 || date > 31);
        input.nextLine();
        int hour;
        do {
            System.out.print("Enter hour do you want your meeting (between 8-16): ");
            hour = input.nextInt() - 8;
        } while (hour < 0 || hour > 8);
        mFinalsHours[date][hour] = -1;
        while (mFinalsHours[date][hour] > 17 || mFinalsHours[date][hour] < 9) {
            System.out.print("Enter final hour of meeting (between 9-17): ");
            mFinalsHours[date][hour] = input.nextInt();
        }
        input.nextLine();
        System.out.print("Enter name of meeting: ");
        mNames[date][hour] = input.nextLine();
        System.out.print("Enter meeting  place: ");
        mPlaces[date][hour] = input.nextLine();
        System.out.print("Enter meeting comment: ");
        mComments[date][hour] = input.nextLine();


    }

    public static void removeMeeting(int[][] mFinalsHours, String[][] mNames, String[][] mComments, String[][] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date do you want your meeting: ");
        int date;
        do {
            date = input.nextInt();
        } while (date < 1 || date > 31);
        printMeetings(mFinalsHours[date], mNames[date], mComments[date], mPlaces[date]);
        input.nextLine();
        System.out.print("Enter which meeting do you want to cancel: ");
        String meet = input.nextLine();
        int hour = 0;
        for (int i = 0; i < mNames[0].length; i++) {
            if (meet.equals(mNames[date][i])) {
                mNames[date][i] = null;
                hour = i;
            }
        }
        mFinalsHours[date][hour] = 0;
        mComments[date][hour] = null;
        mPlaces[date][hour] = null;
    }


    public static void printMeetings(int[] mFinalsHours, String[] mNames, String[] mComments, String[] mPlaces) {
        System.out.println("Start - Final :  Meeting,  Place\n------------------------------------\n");
        for (int i = 0; i < mFinalsHours.length; i++) {
            if (mFinalsHours[i] != 0) {
                System.out.println((i + 8) + ":00h - " + mFinalsHours[i] + ":00h : " + mNames[i] + ", " + mPlaces[i] + " Comment: " + mComments[i]);
            }
        }
    }

    public static void menu(int[][] mFinalsHours, String[][] mNames, String[][] mComments, String[][] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.print("Menu:\n----------------------------------------\n 1.Add or cancel a meeting.\n 2.Print meetings of a day.\n" +
                " 3.Change meeting time or meeting place.\n 4.Search meeting.\n 5.Search free time for meeting.\n----------------------------------------\n" +
                "Enter your choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1:
                System.out.print("Do you want to add a meeting ( true = add / false = remove ) ? ");
                boolean add = input.nextBoolean();
                if (add) addMeeting(mFinalsHours, mNames, mComments, mPlaces);
                else removeMeeting(mFinalsHours, mNames, mComments, mPlaces);
                break;
            case 2:
                System.out.print("Enter date the meetings which you want to see: ");
                int date = input.nextInt();
                printMeetings(mFinalsHours[date], mNames[date], mComments[date], mPlaces[date]);
                break;
            case 3:
                System.out.print("What you want to change - the meeting hour or the meeting place(true = meeting hour / false = meeting place)?  ");
                boolean change = input.nextBoolean();
                int[] changeThis = searchMeetings(mNames);
                if (change) {
                    changeHour(mFinalsHours, mNames, mComments, mPlaces, changeThis[0], changeThis[1]);
                    break;
                } else mPlaces[changeThis[0]][changeThis[1]] = changePlace();
                break;
            case 4:
                int[] m = searchMeetings(mNames);
                printMeeting(mFinalsHours[m[0]][m[1]], mNames[m[0]][m[1]], mComments[m[0]][m[1]], mPlaces[m[0]][m[1]], m[1]);
                break;
            case 5:
                searchFreeTimeToMeeting(mFinalsHours);
        }
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[][] meetingsFinalsHours = new int[31][8];
        String[][] meetingsNames = new String[31][8];
        String[][] meetingsComments = new String[31][8];
        String[][] meetingsPlaces = new String[31][8];
        boolean repeat;
        do {
            menu(meetingsFinalsHours, meetingsNames, meetingsComments, meetingsPlaces);
            System.out.println("Do you want to continue(true = yes / false = no)? ");
            repeat = input.nextBoolean();
        } while (repeat);
    }
}