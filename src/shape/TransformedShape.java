package shape;

import math.Ray;
import math.Transformation;
import raytracer.RayTracer;


public class TransformedShape implements Shape {

	/*
	The base shape of this transformed shape.
	 */
	private final Shape shape;

	/*
	The transformation of this transformed shape.
	 */
	private final Transformation transform;


	/*
	Constructor
	 */
	public TransformedShape(Shape shape, Transformation transform) {
		this.shape = shape;
		this.transform = transform;
	}


	/*
	Shape
	 */
	public Shape getShape() {
		return shape;
	}

	/*
	Transformation
	 */
	private Transformation getTransform() {
		return this.transform;
	}

	public Ray transformRay(Ray ray) {
		return getTransform().transformInverse(ray);
	}

	/*
	General methods
	 */
	public TransformedShape transformShape(Transformation newTransform) {
		return new TransformedShape(
			getShape(), getTransform().append(newTransform)
		);
	}

	@Override
	public void accept(RayTracer tracer) {
		tracer.visitTransformedShape(this);
	}
}
