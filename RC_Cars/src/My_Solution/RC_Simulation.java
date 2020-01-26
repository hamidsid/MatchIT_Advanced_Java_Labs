package My_Solution;

public class RC_Simulation {

    private int[][] room;
    private String commands;
    private RC_Car car;

    /**
     * Constructs and initializes the simulation room
     *
     * @param widthSize  Width size of the room
     * @param heightSize Height of the room
     * @param commands   String of commands entered by the user
     * @param car        Car object from Car class
     */
    public RC_Simulation(int widthSize, int heightSize, String commands, RC_Car car) {
        this.setRoom(new int[widthSize][heightSize]);
        this.commands = commands;
        this.car = car;
    }

    /**
     * Starts the simulation of the radio controlled car within the given room
     *
     * @return The string indicating that whether the simulation was successful or unsuccessful.
     */
    public String startSimulation() {

        boolean isCrashedToTheWall = false;
        char specificCommand = ' ';

        for (int i = 0; i < this.getCommands().length(); i++) {
            specificCommand = this.commands.charAt(i);

            if (specificCommand == 'F' && car.getHeadPosition().equals("N")) {
                isCrashedToTheWall = movingForwardHeadingNorth();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'F' && car.getHeadPosition().equals("E")) {
                isCrashedToTheWall = movingForwardHeadingEast();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'F' && car.getHeadPosition().equals("S")) {
                isCrashedToTheWall = movingForwardHeadingSouth();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'F' && car.getHeadPosition().equals("W")) {
                isCrashedToTheWall = movingForwardHeadingWest();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'B' && car.getHeadPosition().equals("N")) {
                isCrashedToTheWall = movingBackwardsHeadingNorth();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'B' && car.getHeadPosition().equals("E")) {
                isCrashedToTheWall = movingBackwardsHeadingEast();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'B' && car.getHeadPosition().equals("S")) {
                isCrashedToTheWall = movingBackwardsHeadingSouth();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'B' && car.getHeadPosition().equals("W")) {
                isCrashedToTheWall = movingBackwardsHeadingWest();
                if (isCrashedToTheWall) {
                    return printResultSimulation(isCrashedToTheWall, specificCommand);
                }
            } else if (specificCommand == 'L') {
                rotateLeft();
            } else if (specificCommand == 'R') {
                rotateRight();
            }
        }

        return printResultSimulation(isCrashedToTheWall, specificCommand);

    }

    /**
     * Checks whether the car can go forward towards north or not
     *
     * @return true or false based on whether the car moved forward to the asked position or crashed to the wall .
     */
    public boolean movingForwardHeadingNorth() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() + 1);

        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go forward towards east or not
     *
     * @return true or false based on whether the car moved forward to the asked position or crashed to the wall .
     */

    public boolean movingForwardHeadingEast() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() + 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go forward towards south or not
     *
     * @return true or false based on whether the car moved forward to the asked position or crashed to the wall .
     */
    public boolean movingForwardHeadingSouth() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() - 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go forward towards west or not.
     *
     * @return true or false based on whether the car moved forward to the asked position or crashed to the wall .
     */

    public boolean movingForwardHeadingWest() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() - 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go back towards north or not
     *
     * @return true or false based on whether the car moved back to the asked position or crashed to the wall .
     */
    public boolean movingBackwardsHeadingNorth() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() - 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go back towards east or not
     *
     * @return true or false based on whether the car moved back to the asked position or crashed to the wall .
     */
    public boolean movingBackwardsHeadingEast() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() - 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go back towards south or not
     *
     * @return true or false based on whether the car moved back to the asked position or crashed to the wall .
     */
    public boolean movingBackwardsHeadingSouth() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtY(this.car.getCurrentPositionAtY() + 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Checks whether the car can go back towards west or not
     *
     * @return true or false based on whether the car moved back to the asked position or crashed to the wall .
     */
    public boolean movingBackwardsHeadingWest() {
        this.car.setLastPositionAtX(this.car.getCurrentPositionAtX());
        this.car.setLastPositionAtY(this.car.getCurrentPositionAtY());

        this.car.setCurrentPositionAtX(this.car.getCurrentPositionAtX() + 1);
        return checkIfDroveIntoTheWall(this.car.getCurrentPositionAtX(),
                this.car.getCurrentPositionAtY());
    }

    /**
     * Rotates the car's head position 90 degrees to the left
     */
    public void rotateLeft() {
        try {
            int degrees = Integer.parseInt(
                    this.car.getDegreesFromCardinalDirections(this.car.getHeadPosition()));
            degrees -= 90;
            this.car.setHeadPosition(this.car.getCardinalDirections().get(degrees + ""));
        } catch (NumberFormatException numberFormatException) {
            System.out.println("An error occurred");
            numberFormatException.printStackTrace();
        }
    }


    /**
     * Rotates the car's head position 90 degrees to the right
     */
    public void rotateRight() {
        try {
            int degrees = Integer.parseInt(
                    this.car.getDegreesFromCardinalDirections(this.car.getHeadPosition()));
            if (degrees == 360) {
                degrees = 0;
            }
            degrees += 90;
            this.car.setHeadPosition(this.car.getCardinalDirections().get(degrees + ""));
        } catch (NumberFormatException numberFormatException) {
            System.out.println("An error occurred");
            numberFormatException.printStackTrace();
        }
    }

    /**
     * Checks whether the car has crashed to the wall
     *
     * @return true or false based on whether the car has crashed to the wall or not.
     */
    public boolean checkIfDroveIntoTheWall(int positionAfterMoveAtX, int positionAfterMoveAtY) {
        if (positionAfterMoveAtX >= this.getRoom().length || positionAfterMoveAtX < 0) {
            return true;
        }
        if (positionAfterMoveAtY >= this.getRoom()[1].length || positionAfterMoveAtY < 0) {
            return true;
        }

        return false;
    }


    /**
     * Prints out the result to the console whether the car executed all commands successfully or not
     *
     * @param isDrivingIntoTheWall has car crashed to the wall or not.
     * @param lastCommand          The last command that the car tried to execute.
     * @return true or false based on whether the car has crashed to the wall or not.
     */
    public String printResultSimulation(boolean isDrivingIntoTheWall, char lastCommand) {

        String command = "";

        if (lastCommand == 'F') {
            command = "Forward";
        }
        if (lastCommand == 'B') {
            command = "Backwards";
        }

        if (!isDrivingIntoTheWall) {
            return "Successful - The car finished at position: [" +
                    this.car.getCurrentPositionAtX() + "," + this.car.getCurrentPositionAtY() +
                    "] - Heading to the: " + this.car.getHeadPosition();
        } else {
            return "Unsuccessful - The car was at position: [" +
                    this.car.getLastPositionAtX() + "," + this.car.getLastPositionAtY() +
                    "] heading to the " + this.car.getHeadPosition() +
                    " and tried to go " + command + " but crashed to the wall";
        }
    }

    public int[][] getRoom() {
        return room;
    }

    public void setRoom(int[][] room) {
        this.room = room;
    }

    public String getCommands() {
        return commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }

}