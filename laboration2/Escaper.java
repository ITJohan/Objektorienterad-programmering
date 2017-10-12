public class Escaper {
	private Robot robot;

	public static void main(String[] args) {
		Escaper escaper = new Escaper();
		escaper.createEnviroment();
		escaper.moveToEntrance ();
	}//main

	public void createEnviroment() {
		RobotWorld  world = RobotWorld.load("src/room.txt");
		robot = new Robot(2, 4, Robot.EAST, world);
		robot.setDelay(250);
	}//createEnviroment

	//before: robot is inside the room
	//after:  robot is in the cell representing the the doorjam
	public void moveToEntrance() {
		// initialize positions
		Location goalPos = new Location(4, 6);
		Location entrancePos = new Location(4, 5);
		Location currentPos = robot.getLocation();

		while (!currentPos.equals(goalPos)) {
			// move forward until wall
			while (robot.frontIsClear() && !currentPos.equals(entrancePos)) {
				robot.move();
				currentPos = robot.getLocation();
			}
			robot.turnLeft();

			// execute if standing on entrance position
			if (currentPos.equals(entrancePos)) {
				robot.turnLeft();
				robot.turnLeft();
				robot.move();
				currentPos = robot.getLocation();
			}
		}
	}// moveToEntrance
}//Escaper
