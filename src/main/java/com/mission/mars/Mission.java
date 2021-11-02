package com.mission.mars;

import com.mission.mars.utils.CardinalPoints;

import java.util.ArrayList;

public class Mission {

    public static void main(String[] args) {
        Integer roverCount = 1;
        ArrayList<Rover> rovers = new ArrayList<>();

        Rover rover1 = new Rover();
        rover1.setPosition(1, 2, CardinalPoints.N);
        rover1.setCommands("LMLMLMLMM");
        rovers.add(rover1);

        Rover rover2 = new Rover();
        rover2.setPosition(3, 3, CardinalPoints.E);
        rover2.setCommands("MMRMMRMRRM");
        rovers.add(rover2);

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