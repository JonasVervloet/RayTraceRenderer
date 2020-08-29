package raytracer;

import math.Ray;

public class DistanceTraceInfo extends GeneralTraceInfo{

	double distance;

	public DistanceTraceInfo(Ray ray) throws NullPointerException {
		super(ray);
	}

	public double getDistance()	{
		return this.distance;
	}

	public void setDistance(double newDistance)
		throws IllegalArgumentException {
		if (newDistance <= 0) {
			throw new IllegalArgumentException("The given distance is equal to are below zero! NOT POSSIBLE");
		}
		distance = newDistance;
	}
}
