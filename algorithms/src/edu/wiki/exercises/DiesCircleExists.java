package edu.wiki.exercises;

public class DiesCircleExists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static String[] doesCircleExist(String[] commands) {
		/*
		 * Validatations:
		 * commands null.
		 * This will return only the string YES or NO in the array.
		 * 
		 * Possible values for commands are G R and L no more. Any other string will be discarded.
		 * 
		 * The commands can be executed in an infinite loop and it can be in a circle
		 * But maybe the sequence of commands is not complete. This means that aI need to itereate n timmes
		 * to verify if the command close the loop.
		 * 
		 * Create a structure to keep track of the positions x,y and how those change with any movement
		 * Robot has to 4 options to face up, down, left and right
		 * Two direction to turn 
		 * 
		 * 
		 * 
		 */
		if(commands == null) return null;
		
		
		String[] results = new String[commands.length];
		
		for(int i = 0; i < commands.length; i++){
			char[] command = commands[i].toCharArray();
            Robot.xPos = 0;
            Robot.yPos = 0;
            Robot.direction = 0;
			
			for(int step = 0; step < command.length; step++){
                switch(command[step]){
				case 'L': Robot.turnLeft(); break;
				case 'R': Robot.turnRight(); break;
				case 'G': Robot.walk(); break;
				default: System.out.println("Invalid commands sequence.");
				}
			}
			
			if(Robot.xPos == 0 && Robot.yPos == 0) {
				results[i] = "YES";
			} else if(!Robot.getDirection().equals(FaceDirection.EAST)) {
				results[i] = "YES";
			} else {
				results[i] = "NO";
			}
			
		}
		
		return results;
	}

	
	static enum FaceDirection{
		NORTH(0,1),
		SOUTH(0,-1),
		EAST(1,0),
		WEST(-1,0);
		
		public int xMovement;
		public int yMovement;
		
		FaceDirection(int x, int y){
			this.xMovement = x;
			this.yMovement = y;
		}
	}
	
	static class Robot{
		private static FaceDirection[] directionOrder = new FaceDirection[]{FaceDirection.EAST, FaceDirection.NORTH,
				FaceDirection.WEST, FaceDirection.SOUTH};
		
		public static int direction = 0;
		
		public static int xPos = 0;
		public static int yPos = 0;
		
		public static void turnRight(){
			direction = (direction + 1) % directionOrder.length;
		}
		
		public static void turnLeft(){
			direction = (direction + 3) % directionOrder.length;
		}
		
		public static void walk(){
			FaceDirection facingStep = directionOrder[direction];
			xPos += facingStep.xMovement;
			yPos += facingStep.yMovement;
		}
		
		public static FaceDirection getDirection(){
			return directionOrder[direction];
		}
		
	}

}


