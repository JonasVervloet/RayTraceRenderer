package raytracer;

import film.RGBSpectrum;
import math.Ray;
import shape.PrimitiveShape;

public class HitTracer extends AbstractRayTracer {

	RGBSpectrum hitColor;
	GeneralTraceInfo info;

	/*
	Constructors
	 */
	public HitTracer() {
		hitColor = new RGBSpectrum(1.0);
	}

	public HitTracer(double r, double g, double b) {
		hitColor = new RGBSpectrum(r, g, b);
	}

	/*
	General methods
	 */
	@Override
	protected GeneralTraceInfo getInfo() {
		return info;
	}

	@Override
	protected void resetInfo(Ray originalRay) {
		info = new GeneralTraceInfo(originalRay);
	}

	/*
	Shapes
	 */
	@Override
	public void visitPrimitiveShape(PrimitiveShape shape) {
		if (shape.intersect(getCurrentRay())) {
			finalColor = hitColor;
		}
	}
}
