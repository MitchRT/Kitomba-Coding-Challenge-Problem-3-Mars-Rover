import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit tests to see if the program works correctly.
 */

public class Tests {

	/**
	 * Tests to see if the terrain is created with the proper max values.
	 */
	@Test
	void test01() {
		String testInput = "1 2";
		Terrain t = Terrain.createTerrain(testInput);
		assertEquals(t.getMaxX(), 1);
		assertEquals(t.getMaxY(), 2);
	}
	
	/**
	 * Tests creating and moving a rover
	 */
	@Test
	void test02() {
		String testInput = "1 2 0 0 N MMLLL";
		Terrain t = Terrain.createTerrain(testInput);
		List<Rover> rovers = t.getRovers();
		assertEquals(rovers.size(), 1);
		assertEquals(rovers.get(0).toString(), "0 2 E");
	}
	
	/**
	 * Tests that the rover cannot move past the maximum distance.
	 */
	@Test
	void test03() {
		String testInput = "1 2 0 0 N MMML";
		Terrain t = Terrain.createTerrain(testInput);
		List<Rover> rovers = t.getRovers();
		assertEquals(rovers.size(), 1);
		assertEquals(rovers.get(0).toString(), "0 2 W");
	}
	
	/**
	 * Checks the given string to see that the result is as expected.
	 */
	@Test
	void test04() {
		String testInput = "5 5\n " + "1 2 N LMLMLMLMM\n " + "3 3 E MMRMMRMRRM";
		Terrain t = Terrain.createTerrain(testInput);
		List<Rover> rovers = t.getRovers();
		assertEquals(rovers.size(), 2);
		assertEquals(rovers.get(0).toString(), "1 3 N");
		assertEquals(rovers.get(1).toString(), "5 1 E");
	}
}
