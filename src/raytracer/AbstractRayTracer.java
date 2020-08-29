package raytracer;

import light.AmbientLight;
import light.DirectionalLight;
import light.PointLight;
import math.Transformation;
import shape.Shape;
import shape.TransformedShape;
import world.World;
import film.RGBSpectrum;
import math.Ray;

public abstract class AbstractRayTracer implements RayTracer {

	protected RGBSpectrum finalColor;
	protected Ray originalRay;


	/*
	Get methods
	 */
	protected abstract GeneralTraceInfo getInfo();

	protected Ray getCurrentRay() {
		return getInfo().getRay();
	}

	/*
	General approach
	 */
	@Override
	public RGBSpectrum trace(World world, Ray ray) throws NullPointerException {
		this.reset();

		if (ray == null) {
			throw new NullPointerException("The given ray to trace is null!");
		}
		this.originalRay = ray;

		world.visitShapes(this);
		processShapeVisits();
		world.visitLights(this);

		return finalColor;
	}

	@Override
	public void visitNewShape() {
		resetInfo(originalRay);
	}

	protected abstract void resetInfo(Ray originalRay);

	protected void reset() {
		finalColor = RGBSpectrum.BLACK;
		originalRay = null;
	};

	protected void processShapeVisits() {}

	/*
	SHAPES
	 */
	@Override
	public void visitTransformedShape(TransformedShape shape) {
		Ray newRay = shape.transformRay(
			getCurrentRay()
		);
		getInfo().updateRay(newRay);
		shape.getShape().accept(this);
	}

	/*
	LIGHTS
	 */
	@Override
	public void visitDirectionalLight(DirectionalLight light) {}

	@Override
	public void visitAmbientLight(AmbientLight light) {}

	@Override
	public void visitPointLight(PointLight light) {}
}
