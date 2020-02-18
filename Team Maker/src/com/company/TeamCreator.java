package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

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



    public static void createTeams(ArrayList<String> attendeesList, Scanner scanner, List<List<String>> teamContainer){

        int i=0;
        int numberOfTeams;

        System.out.println("How many teams would you like to create? ("+attendeesList.size()+" MAX)");
        numberOfTeams = scanner.nextInt();

        if (numberOfTeams>attendeesList.size()){
            System.out.println("Not enough attendees to create" + numberOfTeams + "Teams");
        }
        else {
            Collections.shuffle(attendeesList);
            while (numberOfTeams > 0) {
                teamContainer.add(new ArrayList<>());
                numberOfTeams--;
            }
            while(i<attendeesList.size()) {
                for (int x=0; x<teamContainer.size(); x++){
                    if (i<attendeesList.size()) {
                        String temp = attendeesList.get(i);
                        teamContainer.get(x).add(temp);
                        i++;
                    }
                }

            }
        }
        System.out.println(tString(teamContainer));
    }


    public static String tString(List<List<String>> teamContainer) {

        String team = "";
        for (int i = 0; i < teamContainer.size(); i++) {
            String members = "";
             for (int j = 0; j < teamContainer.get(i).size(); j++) {
                members += teamContainer.get(i).get(j)+" ";
            }
            team += "Team "+(i+1)+": "+members+"\n";
        }
        return  team;
    }

}
