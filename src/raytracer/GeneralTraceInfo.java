package raytracer;

import math.Ray;

public class GeneralTraceInfo {
	private Ray ray;

	public GeneralTraceInfo(Ray ray)
		throws NullPointerException {
		if (ray == null) {
			throw new NullPointerException("The given ray to store is null ");
		}
		this.ray = ray;
	}

	public Ray getRay() {
		return this.ray;
	}

	public void updateRay(Ray ray) {
		this.ray = ray;
	}
}
