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
        Location startPosition = robot.getLocation();               // get start position
        int startDirection = robot.getDirection();                  // get start direction

        Location currentPosition = new Location(0, 0);                                   // initialize current position
        int currentDirection = 0;                                       // initialize current direction

        // do until startposition
        do {
            while (robot.frontIsClear()) {                          // move until wall
                if (robot.onDark()) {                               // make dark squares light
                    robot.makeLight();
                }
                robot.move();
            }
            robot.turnLeft();                                       // turn if wall
            if (!robot.frontIsClear()) {                            // if facing wall again, turn clockwise
                robot.turnLeft();
                robot.turnLeft();
            }
            if (robot.onDark()) {                               // make dark squares light
                robot.makeLight();
            }
            robot.move();
            if (startPosition.equals(currentPosition)) {
                do {
                    robot.turnLeft();
                } while (!(currentDirection == startDirection));
            }
            currentPosition = robot.getLocation();                  // save current position
            currentDirection = robot.getDirection();                // save current direction
        } while (!(startPosition.equals(currentPosition)) || !(startDirection == currentDirection));
    }//cleanCorridors
}//Cleaner5
