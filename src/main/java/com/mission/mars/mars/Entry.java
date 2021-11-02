package com.mission.mars.mars;

import java.util.ArrayList;

public class Entry {

    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;


    public static void main(String[] args) {
        Integer roverCount = 1;
        ArrayList<Rover> rovers = new ArrayList<>();

        Rover rover1 = new Rover();
        rover1.setPosition(1, 2, N);
        rover1.setCommands("LMLMLMLMM");
        rovers.add(rover1);

        Rover rover2 = new Rover();
        rover2.setPosition(3, 3, E);
        rover2.setCommands("MMRMMRMRRM");
        rovers.add(rover2);

        Rover rover3 = new Rover();
        rover3.setPosition(-5, 4, E);
        rover3.setCommands("MMMMMMRMMMM");
        rovers.add(rover3);

        for (Rover rover:rovers) {
            System.out.println(">>>>> Rover " + roverCount++ + " <<<<<");
            System.out.println();

            rover.displayPosition();
            System.out.println("Commands: " + rover.getCommands());
            rover.travel();

            System.out.println();

            rover.displayPosition();

            System.out.println();
            System.out.println();
            System.out.println();
        }
    }
}