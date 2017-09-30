public class MazeFinder { 
	private Robot robot;

	// booleans for checking walls, true if wall, false if no wall
	private boolean frontSide, rightSide, backSide, leftSide;

	public static void main(String[] args) { 
		MazeFinder finder = new MazeFinder(); 
		finder.createEnviroment(); 
		finder.findExit(); 
	}//main 

	public void createEnviroment() { 
		RobotWorld world = RobotWorld.load("src/maze.txt"); 
		robot = new Robot(2, 0, Robot.EAST, world);
		robot.setDelay(50);
	}//createEnviroment 

	// The robot finds the way through a simply connected maze
	//before: The maze is simply connected.
	//        The robot is at the entrance of the maze.
	//after:  The robot is at the exit of the maze
	public void findExit() {
		// initialize position variables
		Location goalPos = new Location(7, 20);
		Location currentPos = robot.getLocation();

		// do until goal position
		while (!currentPos.equals(goalPos)) {

			scanPaths();

			// makes move according to wall setup
			if ((frontSide && !rightSide && backSide && !leftSide) ||
				(frontSide && !rightSide && !backSide && !leftSide) ||
				(frontSide && rightSide && backSide && !leftSide)) {

				robot.move();
			} else if ((frontSide && rightSide && backSide && leftSide) ||
					(!frontSide && rightSide && backSide && leftSide) ||
					(!frontSide && !rightSide && backSide && leftSide) ||
					(frontSide && !rightSide && backSide && leftSide)) {

				robot.turnLeft();
				robot.move();
			} else if (!frontSide && !rightSide && backSide && !leftSide) {

				uTurn();
				robot.move();
			} else if ((!frontSide && rightSide && backSide && !leftSide)) {

				turnRight();
				robot.move();
			}

			// update corrent position
			currentPos = robot.getLocation();
		}
	}// findExit

	// scans all directions for walls
	private void scanPaths() {
		frontSide = robot.frontIsClear();
		robot.turnLeft();
		leftSide = robot.frontIsClear();
		robot.turnLeft();
		backSide = robot.frontIsClear();
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
