package com.mission.mars;

import java.util.ArrayList;

public class Mission {

    public static void main(String[] args) {
        Integer roverCount = 1;
        ArrayList<Rover> rovers = new ArrayList<>();
        Grid grid = new Grid(4, 4);
        System.out.println();

        Rover rover1 = new Rover(grid);
        rover1.setPosition("1 2 N");
        rover1.setCommands("LMLMLMLMM");
        rovers.add(rover1);

        Rover rover2 = new Rover(grid);
        rover2.setPosition("3 3 E");
        rover2.setCommands("MMRMMRMRRM");
        rovers.add(rover2);

        Rover rover3 = new Rover(grid);
        rover3.setPosition("0 0 S");
        rover3.setCommands("MM");
        rovers.add(rover3);

        Rover rover4 = new Rover(grid);
        rover4.setPosition("0 0 S");
        rover4.setCommands("RMM");
        rovers.add(rover4);

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