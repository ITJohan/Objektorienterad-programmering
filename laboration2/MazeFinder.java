public class MazeFinder { 
	private Robot robot; 
	public static void main(String[] args) { 
		MazeFinder finder = new MazeFinder(); 
		finder.createEnviroment(); 
		finder.findExit(); 
	}//main 

	public void createEnviroment() { 
		RobotWorld world = RobotWorld.load("src/maze.txt"); 
		robot = new Robot(2, 1, Robot.EAST, world);
		robot.setDelay(50);
	}//createEnviroment 

	// The robot finds the way through a simply connected maze
	//before: The maze is simply connected.
	//        The robot is at the entrance of the maze.
	//after:  The robot is at the exit of the maze
	public void findExit() {
		Location goalPos = new Location(7, 20);
		Location currentPos = robot.getLocation();

		while (!currentPos.equals(goalPos)) {
			if (robot.frontIsClear())
				robot.move();
			else
				robot.turnLeft();
				if (!robot.frontIsClear())
					robot.turnLeft();
					if (!robot.frontIsClear()) {
						robot.turnLeft();
						robot.turnLeft();
						if (!robot.frontIsClear())
							robot.turnLeft();
					}
		}
	}// findExit 
}//MazeFinder
