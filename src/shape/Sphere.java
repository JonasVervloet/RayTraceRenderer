package shape;

import main.Renderer;
import math.*;
import raytracer.RayTracer;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Represents a three-dimensional sphere with radius one, centered at the
 * origin, which is transformed by a transformation.
 * 
 * @author 	CGRG
 * @version 4.0.0
 */
public class Sphere extends AbstractPrimitiveShape {

	/*
	Singleton sphere object.
	 */
	private static Sphere sphere = null;


	/*
	Constructor
	 */
	private Sphere() {}


	/*
	Sphere
	 */
	public static Sphere getSphere() {
		if (sphere == null) {
			sphere = new Sphere();
		}
		return sphere;
	}

	/*
	Override PrimitiveShape methods
	 */
	@Override
	public Optional<Double> getDistance(Ray ray) {
		if (ray == null)
			return Optional.empty();

		Vector o = ray.origin.toVector();

		double a = ray.direction.lengthSquared();
		double b = 2.0 * (ray.direction.dot(o));
		double c = o.dot(o) - 1.0;
		double d = b * b - 4.0 * a * c;

		if (d < 0)
			return Optional.empty();

		double dr = Math.sqrt(d);
		// numerically solve the equation a*t^2 + b * t + c = 0
		double q = -0.5 * (b < 0 ? (b - dr) : (b + dr));
		double t0 = q / a;
		double t1 = c / q;

		if (t0 >= Renderer.eps) {
			return Optional.of(t0);
		} else  if (t0 >= Renderer.eps) {
			return Optional.of(t1);
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Normal> getNormal(Ray ray) {
		try {
			Point hp = ray.applyTvalue(
				getDistance(ray).get()
			);
			return Optional.of(
				new Normal(hp.x, hp.y, hp.z)
			);
		} catch (NoSuchElementException e) {
			return Optional.empty();
		}
	}
}
