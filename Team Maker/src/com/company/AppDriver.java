package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//TODO: Documentation
public class AppDriver {

    public static void main(String[] args) throws IOException {

        int option = 0;

        String fileLocation="C:\\temp\\Attendees.txt";

        List<List<String>> teamContainer = new ArrayList<>();
        ArrayList<String> attendeesList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);


        while (option != 4) {
            option = TeamCreator.displayMenu(scanner);
            scanner.nextLine();
            if (option == 1) {
                TeamCreator.addAttendees(scanner, fileLocation);
                }
            if (option == 2) {
                TeamCreator.loadAttendees(attendeesList, fileLocation);
                TeamCreator.createTeams(attendeesList, scanner, teamContainer);
            }

        }

    }
//TODO Add people to teams?
//      save the teams?,
//      fix file location
}

