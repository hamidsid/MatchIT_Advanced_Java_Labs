package My_Solution;

import java.util.Scanner;

public class RC_Application {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int roomWidth;
        int roomHeight;
        String commands;

        //Sort all inputs regarding room size
        int[] roomWidthAndHeight = new int[2];
        roomWidthAndHeight = sortRoomWidthAndHeightInputs();
        roomWidth = roomWidthAndHeight[0];
        roomHeight = roomWidthAndHeight[1];

        //Sort all inputs regarding RC car
        RC_Car car = sortCarInputs();

        //Sort all inputs regarding commands
        commands = sortCommandInputs();


        RC_Simulation simulation = new RC_Simulation(roomWidth, roomHeight, commands, car);
        String simulationExecuted = simulation.startSimulation();
        System.out.println(simulationExecuted);

        scanner.close();


    }

    private static String sortCommandInputs() {

        String commands = "";
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("Enter the commands to execute: ");
            commands = scanner.nextLine().toUpperCase();
            if (commands.length() > 0) {
                for (int i = 0; i < commands.length(); i++) {
                    char letter = commands.charAt(i);
                    if (letter != 'F' && letter != 'B' && letter != 'R' && letter != 'L') {
                        System.out.println("Please enter only commands containing letters:  FRLB");
                        correctInput = false;
                        break;
                    } else {
                        correctInput = true;
                    }
                }
            } else {
                System.out.println("An unexpected error occurred!");
            }
        }
        return commands;
    }


    private static RC_Car sortCarInputs() {

        int startingPositionAtX;
        int startingPositionAtY;
        String headPosition;
        RC_Car car = null;
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("Enter the starting position and head position of the car:");
            String[] carInputs = scanner.nextLine().split(" ");

            if (carInputs.length == 3) {
                try {
                    startingPositionAtX = Integer.parseInt(carInputs[0]);
                    startingPositionAtY = Integer.parseInt(carInputs[1]);
                    headPosition = carInputs[2].toUpperCase();

                    if (headPosition.length() == 1) {
                        if (headPosition.equals("N") || headPosition.equals("S") ||
                                headPosition.equals("E") || headPosition.equals("W")) {

                            car = new RC_Car("Monster Trucks", headPosition,
                                    startingPositionAtX, startingPositionAtY);
                            correctInput = true;
                        } else {
                            System.out.println("Please enter heading position only as N,S,E,W");
                        }
                    } else {
                        System.out.println("The heading must have a maximum 1 character");
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Incorrect parameters. Try again. Example: 2 3 W");
                }
            } else {
                System.out.println("An unexpected error occurred!");
            }
        }
        return car;
    }


    private static int[] sortRoomWidthAndHeightInputs() {

        int roomWidth = 0;
        int roomHeight = 0;
        int[] roomWidthAndHeight = new int[2];
        boolean correctInput = false;

        while (!correctInput) {
            System.out.println("Enter room size: ");
            String[] roomSizeFromInput = scanner.nextLine().split(" ");

            if (roomSizeFromInput.length == 2) {
                try {
                    roomWidth = Integer.parseInt(roomSizeFromInput[0]);
                    roomHeight = Integer.parseInt(roomSizeFromInput[1]);
                    if (roomWidth > 0 && roomHeight > 0) {
                        roomWidthAndHeight[0] = roomWidth;
                        roomWidthAndHeight[1] = roomHeight;
                        correctInput = true;
                    } else {
                        System.out.println("The size of the room needs to be greater than 0");
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Parameters need to be only integer numbers");
                }
            } else {
                System.out.println("An unexpected error occurred!");
            }
        }
        return roomWidthAndHeight;
    }

}

