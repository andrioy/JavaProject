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

    public static void changePlace(String mPlace) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter new place for this meeting: ");
        mPlace = input.nextLine();

    }

    public static void printMeeting(int mFinalsHours, String mNames, String mComments, String mPlaces, int hour) {

        System.out.println((hour + 8) + ":00h - " + mFinalsHours + ":00h : " + mNames + ", " + mPlaces + " Comment: " + mComments);
    }

    public static int[] searchMeetings(String[][] mNames) {
        int date = -1, hour = -1;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of meeting: ");
        String meeting = input.nextLine();
        for (int i = 0; i < mNames.length; i++) {
            for (int j = 0; j < mNames[0].length; j++) {
                if (meeting.equals(mNames[i][j])) {
                    date = i;
                    hour = j + 8;
                }
            }

        }
        return new int[]{date, hour};
    }


    public static void searchFreeTimeToMeeting(int[][] mFinalsHours) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date do you want your meeting: ");
        int date = input.nextInt() - 1;
        System.out.print("Enter duration of the meeting in hours: ");
        int duration = input.nextInt();
        System.out.print("Which day of week is 1st date of this month?(1=Monday,..,7=Sunday)");
        int dayOfWeek = input.nextInt();
        System.out.print("How many days have in this month? ");
        int monthLength = input.nextInt();

        int freeTime = 0;
        for (int i = date; i < monthLength; i++) {
            for (int j = 0; j < mFinalsHours[0].length; j++) {
                if (mFinalsHours[i][j] == 0 && dayOfWeek != 6 && dayOfWeek != 7) {
                    freeTime++;
                    if (freeTime == duration) {
                        System.out.println("Date: " + i + ", Hour: " + (j + 8) + ":00h");
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
        int date = input.nextInt();
        System.out.print("Enter hour do you want your meeting: ");
        int hour = input.nextInt();
        System.out.print("Enter final hour of meeting: ");
        mFinalsHours[date][hour] = input.nextInt();
        System.out.print("Enter name of meeting: ");
        mNames[date][hour] = input.nextLine();
        System.out.print("Enter meeting meeting place: ");
        mPlaces[date][hour] = input.nextLine();
        System.out.print("Enter meeting comment: ");
        mComments[date][hour] = input.nextLine();


    }

    public static void removeMeeting(int[][] mFinalsHours, String[][] mNames, String[][] mComments, String[][] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter date do you want your meeting: ");
        int date = input.nextInt();
        System.out.print("Enter meeting hour which do you want to cancel: ");
        int hour = input.nextInt();
        mFinalsHours[date][hour] = 0;
        mNames[date][hour] = null;
        mComments[date][hour] = null;
        mPlaces[date][hour] = null;
    }


    public static void printMeetings(int[] mFinalsHours, String[] mNames, String[] mComments, String[] mPlaces) {
        System.out.println("Start - Final :  Meeting,  Place\n------------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println(i + 9 + ":00h - " + mFinalsHours[i] + ":00h : " + mNames[i] + ", " + mPlaces[i] + " Comment: " + mComments[i]);
        }

    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] meetingsNames = new String[31][9];
        String[][] meetingsComments = new String[31][9];
        String[][] meetingsPlaces = new String[31][9];


        
        //  System.out.println("Enter date of month: ");
        //   int date = input.nextInt();
        //  System.out.println("Enter start hour of meeting: ");
        //   int startHour = input.nextInt();
        // addMeeting(finalsHours[date][startHour-9],meetingsNames[date][startHour-9],meetingsComments[date][startHour-9]);

    }
}