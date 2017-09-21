public class Escaper { 
	private Robot robot; 
	public static void main(String[] args) { 
		Escaper escaper = new Escaper(); 
		escaper.createEnviroment(); 
		escaper.moveToEntrance (); 
	}//main 

	public void createEnviroment() { 
		RobotWorld  world = RobotWorld.load("src/room.txt"); 
		robot = new Robot(3, 3, Robot.WEST, world); 
		robot.setDelay(250); 
	}//createEnviroment 
 
	//before: robot is inside the room
	//after:  robot is in the cell representing the the dorrjamb
	public void moveToEntrance() { 
		//The implementation is your work to do!
	}// moveToEntrance 
}//Escaper
