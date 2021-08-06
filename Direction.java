/**
 * Enum for Directions containing methods for turning left and
 * right, and a constructor from a strin.
 */
public enum Direction {
	N,
	E,
	S,
	W;
	
	public Direction turnLeft() {
		switch(this) {
		case N: return W;
		case W: return S;
		case S: return E;
		case E: return N;	
		default: throw new Error("\""+this+"\" is not a valid move");
		}
	}
	
	public Direction turnRight() {
		switch(this) {
		case N: return E;
		case E: return S;
		case S: return W;
		case W: return N;	
		default: throw new Error("\""+this+"\" is not a valid move");
		}
	}
	
	public String toString() {
		switch(this) {
		case N: return "N";
		case E: return "E";
		case S: return "S";
		case W: return "W";
		default: return "";
		}
	}
	
	public static Direction fromString(String s) {
		switch(s) {
		case "N": return N;
		case "E": return E;
		case "S": return S;
		case "W": return W;
		default: return null;
		}
	}
}
