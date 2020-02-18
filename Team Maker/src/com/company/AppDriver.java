package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


//TODO: Documentation
public class AppDriver {

    public static void main(String[] args) throws IOException {

        int option = 0;
        int teamNo=0;

        String fileLocation="res/attendees.txt";

        ArrayList<String> attendeesList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        TeamCreator.loadAttendees(attendeesList, fileLocation);

        while (option != 4) {
            option = TeamCreator.displayMenu(scanner);
            scanner.nextLine();
            if (option == 1) {
                TeamCreator.addAttendees(scanner, fileLocation);
                }
            if (option == 2) {
                TeamCreator.createTeams(attendeesList, scanner);
            }

        }

    }

}

