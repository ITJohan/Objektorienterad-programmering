public class MazeFinder {
	private Robot robot;

	// booleans for checking walls, true if wall, false if no wall
	private boolean frontSide, rightSide, leftSide;

	public static void main(String[] args) {
		MazeFinder finder = new MazeFinder();
		finder.createEnviroment();
		finder.findExit();
	}//main

	public void createEnviroment() {
		RobotWorld world = RobotWorld.load("src/maze.txt");
		robot = new Robot(2, 0, Robot.WEST, world);
		robot.setDelay(10);
	}//createEnviroment

	// The robot finds the way through a simply connected maze
	//before: The maze is simply connected.
	//        The robot is at the entrance of the maze.
	//after:  The robot is at the exit of the maze
	public void findExit() {
		boolean goal = false;

		// do until goal position
		while (!goal) {

			scanPaths();

			// makes move according to wall setup
			if (leftSide) {
				robot.turnLeft();
				robot.move();
			} else if (frontSide) {
				robot.move();
			} else if (rightSide) {
				turnRight();
				robot.move();
			} else {
				uTurn();
				robot.move();
			}

			// if about to exit world, set goal to true
			if (robot.atEndOfWorld()) {
				goal = true;
			}
		}
	}// findExit

	// scans all directions for walls
	private void scanPaths() {
		frontSide = robot.frontIsClear();
		robot.turnLeft();
		leftSide = robot.frontIsClear();
		robot.turnLeft();
		robot.turnLeft();
		rightSide = robot.frontIsClear();
		robot.turnLeft();
	} // scanPaths

	// makes a right turn
	private void turnRight() {
		robot.turnLeft();
		robot.turnLeft();
		robot.turnLeft();
	}

	// makes a u-turn
	private void uTurn() {
		robot.turnLeft();
		robot.turnLeft();
	}
}// MazeFinder
