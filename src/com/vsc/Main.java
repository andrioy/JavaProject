package com.vsc;

import java.util.Scanner;

public class Main {

    public static void changeHour(int[] mFinalsHours, String[] mNames, String[] mComments, String[] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter meeting hour which you want to change: ");
        int oldHour = input.nextInt();
        System.out.print("Enter new hour for this meeting: ");
        int newHour = input.nextInt();

        mFinalsHours[newHour - 8] = mFinalsHours[oldHour - 8];
        mFinalsHours[oldHour - 8] = 0;
        mNames[newHour - 8] = mNames[oldHour - 8];
        mNames[oldHour - 8] = null;
        mComments[newHour - 8] = mComments[oldHour - 8];
        mComments[oldHour - 8] = null;
        mPlaces[newHour - 8] = mPlaces[oldHour - 8];
        mPlaces[oldHour] = null;
    }

    public static void changePlace(String[] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter meeting place which you want to change: ");
        String oldPlace = input.nextLine();
        System.out.print("Enter new place for this meeting: ");
        String newPlace = input.nextLine();
        for (int i = 0; i < mPlaces.length; i++) {
            if (newPlace.equals(mPlaces[i])) mPlaces[i] = newPlace;
        }

    }

    public static void searchMeeting(int[][] mFinalsHours, String[][] mNames, String[][] mComments, String[][] mPlaces) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter name of meeting: ");
        String meeting = input.nextLine();
        for (int i = 0; i < mNames.length; i++) {
            for (int j = 0; j < mNames[0].length; j++) {
                if (meeting.equals(mNames[i][j])) {
                    System.out.println(i + 9 + ":00h - " + mFinalsHours[i][j] + ":00h : " + mNames[i][j] + ", " + mPlaces[i][j] + " Comment: " + mComments[i][j]);
                }
            }

        }

    }


    public static void addMeeting(int fHour, String name, String comm) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter final hour of meeting: ");
        int finHour = input.nextInt();
        fHour = finHour;

        System.out.println("Enter meeting name: ");
        String mName = input.nextLine();

        System.out.println("Enter meeting comment: ");
        String mComm = input.nextLine();

    }


    public static void printMeetings(int[] mFinalsHours, String[] mNames, String[] mComments, String[] mPlaces) {

        System.out.println("Start - Final : Meeting,  Place\n------------------\n");
        for (int i = 0; i < 9; i++) {
            System.out.println(i + 9 + ":00h - " + mFinalsHours[i] + ":00h : " + mNames[i] + ", " + mPlaces[i] + " Comment: " + mComments[i]);

        }

    }

   

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[][] meetingsNames = new String[31][9];
        String[][] meetingsComments = new String[31][9];
        String[][] meetingsPlaces = new String[31][9];
        int[][] finalsHours = new int[31][9];

        int[] calendar = new int[31];

        System.out.println(finalsHours[0][0] + " x ");

        //  System.out.println("Enter date of month: ");
        //   int date = input.nextInt();
        //  System.out.println("Enter start hour of meeting: ");
        //   int startHour = input.nextInt();
        // addMeeting(finalsHours[date][startHour-9],meetingsNames[date][startHour-9],meetingsComments[date][startHour-9]);

    }
}