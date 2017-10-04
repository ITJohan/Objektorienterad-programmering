public class Escaper { 
	private Robot robot;

	// booleans for checking walls, true if wall, false if no wall
	private boolean frontSide, rightSide, backSide, leftSide;

	public static void main(String[] args) { 
		Escaper escaper = new Escaper(); 
		escaper.createEnviroment(); 
		escaper.moveToEntrance (); 
	}//main 

	public void createEnviroment() { 
		RobotWorld  world = RobotWorld.load("src/room.txt"); 
		robot = new Robot(4, 5, Robot.WEST, world);
		robot.setDelay(250);
	}//createEnviroment 
 
	//before: robot is inside the room
	//after:  robot is in the cell representing the the dorrjamb
	public void moveToEntrance() {
		// initialize position variables
		Location goalPos = new Location(4, 6);
		Location currentPos = robot.getLocation();

		// move forward until wall or goal position
		while (robot.frontIsClear() && !currentPos.equals(goalPos)) {
			robot.move();
			currentPos = robot.getLocation();
		}

		// then follow wall principle
		while (!currentPos.equals(goalPos)) {

			scanPaths();

			// makes move according to wall setup
			if ((frontSide && !rightSide && backSide && !leftSide) ||
					(frontSide && rightSide && backSide && !leftSide)) {

				robot.move();
			} else if ((!frontSide && !rightSide && backSide && leftSide) ||
					(frontSide && !rightSide && backSide && leftSide) ||
					(frontSide && rightSide && backSide && leftSide)) {

				robot.turnLeft();
				robot.move();
			} else if ((!frontSide && rightSide && backSide && !leftSide) ||
					(!frontSide && rightSide && backSide && leftSide)) {

				turnRight();
				robot.move();
			}

			// update corrent position
			currentPos = robot.getLocation();
		}
	}// moveToEntrance

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
}//Escaper
