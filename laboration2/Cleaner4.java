public class Cleaner4 {
    private Robot robot;
    public static void main(String[] args) {
        Cleaner4 cleaner = new Cleaner4();
        cleaner.createEnviroment();
        cleaner.cleanCorridors();
    } //main

    private void createEnviroment() {
        RobotWorld world = RobotWorld.load("src/square3.txt");
        robot = new Robot(1, world.getNumCols() - 2, Robot.WEST, world);
        robot.setDelay(250);
    }//createEnviroment

    //before: The room has four corridors, forming a square
    //        The robot is located in beginning of one of the corridors.
    //after:  All cells in the corridors are light.
    //        The robot has the same location and facing the same direction
    private void cleanCorridors() {
        for (int i = 0; i < 4; i++) {           // for each corridor
            while (robot.frontIsClear()) {      // move until wall
                if (robot.onDark()) {           // make dark squares light
                    robot.makeLight();
                }
                robot.move();
            }
            robot.turnLeft();                   // turn if wall
            if (!robot.frontIsClear()) {        // if facing wall again, turn clockwise
                robot.turnLeft();
                robot.turnLeft();
            }
        }
    }//cleanCorridors
}//Cleaner4
