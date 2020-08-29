package math;

public class Normal extends Vector {

	public Normal(double x, double y, double z) {
		super(x/getLength(x, y, z), y/getLength(x, y, z), z/getLength(x, y, z));
	}

	public Normal(Vector vec) {
		this(vec.x, vec.y, vec.z);
	}

	public static double getLength(double x, double y, double z) {
		return Math.sqrt(x * x + y * y + z * z);
	}
}
