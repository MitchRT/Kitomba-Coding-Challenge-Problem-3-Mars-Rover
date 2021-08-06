/**
 * A class for each rover. has fields for the position, what direction it is
 * facing and what is the maximum it can go.
 */

public class Rover {
	private Direction direction;
	private int[] position;
	private int maxX;
	private int maxY;

	/**
	 * Constructor.
	 * 
	 * @param x
	 * @param y
	 * @param d
	 * @param maxX
	 * @param maxY
	 */
	public Rover(int x, int y, Direction d, int maxX, int maxY) {
		this.direction = d;
		this.position = new int[2];
		position[0] = x;
		position[1] = y;
		this.maxX = maxX;
		this.maxY = maxY;
	}

	/**
	 * reads the list of instructions to control the rover, and executes them.
	 * 
	 * @param input
	 */
	public void control(String input) {
		char[] instructions = input.toCharArray();
		for (int i = 0; i < instructions.length; i++) {
			char next = instructions[i];
			if (next == 'L') {
				direction = direction.turnLeft();
			} else if (next == 'R') {
				direction = direction.turnRight();
			} else {
				move();
			}
		}
	}

	/**
	 * Moves the rover forward, if possible. Assumes that a terrain with 
	 * max y distance of 3 has43 possible y positions for the rover: 
	 * 0, 1, 2 & 3.
	 */
	public void move() {
		if (direction == Direction.N && position[1] < maxY) {
			position[1] = position[1] + 1;
		} else if (direction == Direction.S && position[1] > 0) {
			position[1] = position[1] - 1;
		} else if (direction == Direction.E && position[0] < maxX) {
			position[0] = position[0] + 1;
		} else if (direction == Direction.W && position[0] > 0) {
			position[0] = position[0] - 1;
		}
	}

	/**
	 * Returns a String representation of the rover.
	 */
	public String toString() {
		return ("" + position[0] + " " + position[1] + " " + direction.toString());
	}

	/*
	 * TestInput: 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM
	 * 
	 * Expected Output: 1 3 N 5 1 E
	 */
}
