package shape;

import raytracer.RayTracer;

public interface Shape {

	/*
	Accept a ray tracer that will visit the shape to perform some
		computations.
	 */
	void accept(RayTracer tracer);
}
