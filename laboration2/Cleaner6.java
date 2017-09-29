import java.util.Scanner;

public class Cleaner6 {
    private Robot robot;
    public static void main(String[] args) {
        Cleaner6 cleaner = new Cleaner6();
        cleaner.createEnviroment();
        cleaner.cleanCorridors();
    } //main

    private void createEnviroment() {
        RobotWorld world = RobotWorld.load("src/loop.txt");
        robot = new Robot(1, world.getNumCols() - 4, Robot.NORTH, world);
        robot.setDelay(50);
    }//createEnviroment

    //before: The corridors form a closed loop.
    //after:  All cells in the corridors are light.
    //        The robot has the same location and facing the same direction
    private void cleanCorridors() {
        // get goal coordinates
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter x goal coordinate: ");
        int xGoal = sc.nextInt();
        System.out.print("Enter y goal coordinate: ");
        int yGoal = sc.nextInt();

        // parse goal coordinates to Location
        Location goalPos = new Location(yGoal, xGoal);

        // get start pos and dir
        Location startPos = robot.getLocation();
        int startDir = robot.getDirection();

        // initialize current pos
        Location currPos = new Location(0, 0);

        // handle first moves to get out of start pos
        if (!robot.frontIsClear()) {
            turn(1);
        }
        turnDarkToLight();
        robot.move();

        // do until start pos or goal pos
        while (!startPos.equals(currPos) && !goalPos.equals(currPos)) {

            // move until wall and start pos or goal pos
            while (robot.frontIsClear() && (!startPos.equals(currPos) && !goalPos.equals(currPos))) {
                turnDarkToLight();
                robot.move();
                currPos = robot.getLocation();
            }
            turn(2);

            // update current pos
            currPos = robot.getLocation();
        }

        // turn robot to start dir
        while (startDir != robot.getDirection()) {
            robot.turnLeft();
        }
        
        // output end position
        if (currPos == goalPos) {
            System.out.println("Goal position reached!");
        } else {
            System.out.println("Start position reached!");
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
}//Cleaner6