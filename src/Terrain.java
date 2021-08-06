import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Creates a terrain which contains the rovers and has the
 *  max distance.
 */
public class Terrain {
	private int maxX;
	private int maxY;
	private List<Rover> rovers;
	
	/**
	 * Constructor
	 * 
	 * @param maxX
	 * @param maxY
	 */
	public Terrain(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
		rovers = new ArrayList<Rover>();
	}
	
	/**
	 * Creates a terrain and rovers from a given string, including moving the rovers
	 *  to their final positions.
	 * 
	 * @param instructions
	 * @return terrain created
	 */
	public static Terrain createTerrain(String instructions) {
		Scanner sc = new Scanner(instructions);
		int mX = sc.nextInt();
		int mY = sc.nextInt();
		Terrain t = new Terrain(mX, mY);
		while(sc.hasNext()) {
			int x = sc.nextInt(); 
			int y = sc.nextInt();
			Direction dir = Direction.fromString(sc.next());
			Rover rover = new Rover(x, y, dir, t.maxX, t.maxY);
			t.rovers.add(rover);
			rover.control(sc.next());
		}
		sc.close();
		return t;
	}
	
	/**
	 * @return the list of rovers
	 */
	public List<Rover> getRovers(){
		return new ArrayList<Rover>(rovers);
	}
	
	/**
	 * @return the max x coordinate
	 */
	public int getMaxX() {
		return maxX;
	}
	
	/**
	 * @return the max y coordinate
	 */
	public int getMaxY() {
		return maxY;
	}

}
