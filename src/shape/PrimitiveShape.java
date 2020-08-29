package shape;

import math.Normal;
import math.Ray;
import math.Transformation;
import raytracer.RayTracer;
import raytracer.TraceInfo;

import java.util.Optional;

/**
 * Interface which should be implemented by all shapes.
 * 
 * @author 	CGRG
 * @version 4.0.0
 */
public interface PrimitiveShape extends Shape {

	/*
	Returns a boolean that reflects whether are not the given ray intersects
		with this primitive shape.
	 */
	boolean intersect(Ray ray);

	/*
	Returns a optional double that gives the distance from the ray's origin to
		this primitive shape. The method returns an empty optional object when
		the ray does not intersect this primitive shape.
	 */
	Optional<Double> getDistance(Ray ray);

	/*
	Returns the optional normal of the point on this primitive shape where the
		given ray intersects with this primitive shape. The method returns an
		empty optional object when the ray does not intersect this primitive
		shape.
	 */
	Optional<Normal> getNormal(Ray ray);

	/*
	Returns the transformed shape that results from transforming this primitive
		shape according to the given transformation.s
	 */
	TransformedShape transformShape(Transformation transformation);
}
