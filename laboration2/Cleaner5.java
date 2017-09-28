public class Cleaner5 {
    private Robot robot;
    public static void main(String[] args) {
        Cleaner5 cleaner = new Cleaner5();
        cleaner.createEnviroment();
        cleaner.cleanCorridors();
    } //main

    private void createEnviroment() {
        RobotWorld world = RobotWorld.load("src/square3.txt");
        robot = new Robot(1, world.getNumCols() - 4, Robot.SOUTH, world);
        robot.setDelay(250);
    }//createEnviroment

    //before: The room has four corridors, forming a square.
    //after:  All cells in the corridors are light.
    //        The robot has the same location and facing the same direction
    private void cleanCorridors() {
        // get start position and direction
        Location startPosition = robot.getLocation();
        int startDirection = robot.getDirection();

        // initialize current pos
        Location currentPosition = new Location(0, 0);

        // handle first moves to get out of start pos
        if (!robot.frontIsClear()) {
            turn(1);
        }
        turnDarkToLight();
        robot.move();

        // do until start position
        while (!(startPosition.equals(currentPosition))) {

            // move until wall and start pos
            while (robot.frontIsClear() && !startPosition.equals(currentPosition)) {
                turnDarkToLight();

                robot.move();
                currentPosition = robot.getLocation();
            }

            turn(2);

            // update current pos
            currentPosition = robot.getLocation();
        }

        // turn robot to start direction
        while (startDirection != robot.getDirection()) {
            robot.turnLeft();
        }
    }//cleanCorridors

    // turn dark into light
    private void turnDarkToLight() {
        if (robot.onDark()) {
            robot.makeLight();
        }
    }

    // handle walls and corners
    private void turn(int j) {
        robot.turnLeft();
        if (!robot.frontIsClear()) {
            for (int i = 0; i < j; i++)
                robot.turnLeft();
        }
    }
}//Cleaner5
