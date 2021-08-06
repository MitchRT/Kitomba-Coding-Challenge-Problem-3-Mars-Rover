import java.util.Scanner;

/**
 * The main class for control of the system.
 * 
 */
public class Main {
	
	/**
	 * Input is taken through the console, with all the instructions delivered
	 * at the same time. Output is printed to the commend line when finished.
	 * 
	 * @param args
	 */
	public static void main(String... args) {
		System.out.println("Please enter the full instructions for the rovers.");
		Scanner sc = new Scanner(System.in);
		Terrain b = Terrain.createTerrain(sc.nextLine());	
		for (Rover r : b.getRovers()) {
			System.out.println(r.toString());
		}
		sc.close();
	}

	/* TestInput: 5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM
	 * 
	 * Expected Output: 1 3 N
	 * 5 1 E
	 */
}
