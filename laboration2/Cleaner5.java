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
    /* KOMMENTAR har inte riktigt jämnfört dem jättenoga men tror eventuellt jag skippar lite kod men är osäker, vi får nog gå igenom 
    sista tillsammans
    
    void cleanCorridorsUpToPosition() {
        Location start = robot.getLocation(); //decides the start location

        boolean home = false;

        while (home == false) {  //checks if the robot is home

            if (robot.frontIsClear()) {  // the robot will move if no obstacle in front of it
                robot.move();
                if (robot.onDark()) {  // the robot will change the square it´s on if the square is dark.
                    robot.makeLight();
                }
                Location currentLocation = robot.getLocation(); //after moving the new location will be recorded
                if (currentLocation.equals(start)) {   //the robot will tell the function that it´s home and stop moving
                    home = true;                        //if it´s current location matches the starting location
                }
            }
            else {
                    robot.turnLeft(); //the robot will turn left if hindered by an obstacle
                    if (robot.frontIsClear() != true) { //the robot will turn 180 degrees if an obstacle still is in front of it
                        robot.turnLeft();
                        robot.turnLeft();
                    } //the robot does not necessery point in the right direction compared to "start" but that was not in the assignment
                      //but i think it should´ve been since it is on the same difficulty level

*/
}//Cleaner5
