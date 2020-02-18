package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TeamCreator {



    public static void addAttendees(Scanner scanner, String fileLocation) throws IOException {

        String name = "";

        FileWriter fW = new FileWriter(fileLocation, false);
        PrintWriter pW = new PrintWriter(fW);

        while (!name.equals("x")) {

            System.out.print("Enter Full Name or x to quit: ");
            name = scanner.nextLine();
            pW.print(name+"\n");

        }

        pW.close();
        fW.close();

    }

    public static int displayMenu(Scanner scanner) {
        int number;
        System.out.println("Team Creator");

        System.out.println("1. Add Attendees");
        System.out.println("2. Create Teams");
        System.out.println("4. Exit");
        System.out.print("Enter an option: ");

        number = scanner.nextInt();
        return number;
    }

    public static void loadAttendees(ArrayList<String> attendeesList, String fileLocation) throws IOException {
        File file = new File(fileLocation);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) {
            attendeesList.add(inputFile.nextLine());
        }
    }



    public static void createTeams(ArrayList<String> attendeesList, Scanner scanner){
        ArrayList<ArrayList> teamContainer = new ArrayList<>();
        Random rand = new Random();

        int numberOfTeams = 0;
        int size = attendeesList.size();

        System.out.println("How many teams would you like to create? ("+size+" MAX)");
        numberOfTeams = scanner.nextInt();

        if (numberOfTeams>size){
            System.out.println("Not enough attendees to create" + numberOfTeams + "Teams");
        }
        else {
            while (numberOfTeams > 0) {
                ArrayList<String> team = new ArrayList<>();
                teamContainer.add(team);
                numberOfTeams--;
            }
            for (int i = 0; i < size; i++) {


                String temp = attendeesList.get(i);
                //TODO: Figure out how to add randomly to the arraylists

            }
        }




    }
}
