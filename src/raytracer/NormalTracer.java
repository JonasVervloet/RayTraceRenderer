package raytracer;

import math.Ray;
import shape.PrimitiveShape;
import film.RGBSpectrum;

import java.util.NoSuchElementException;
import java.util.Optional;

public class NormalTracer extends AbstractRayTracer {

	private NormalTraceInfo currentBest;
	private NormalTraceInfo info;

	/*
	General methods
	 */
	@Override
	protected GeneralTraceInfo getInfo() {
		return info;
	}

	@Override
	protected void resetInfo(Ray originalRay) {
		info = new NormalTraceInfo(originalRay);
	}

	@Override
	public void reset() {
		super.reset();
		currentBest = null;
	}

	private double getCurrentBestDistance() {
		try {
			return currentBest.getDistance();
		} catch (NullPointerException e) {
			return Double.MAX_VALUE;
		}
	}

	/*
	SHAPES
	 */
	@Override
	public void visitPrimitiveShape(PrimitiveShape shape) {
		try {
			double nDist =
				shape.getDistance(
					getCurrentRay()
				).get();
			if (nDist < getCurrentBestDistance()) {
				info.setDistance(nDist);
				info.setShape(shape);
				currentBest = info;
			}
		} catch (NoSuchElementException e) {}
	}

	@Override
	protected void processShapeVisits() {
		try {
			finalColor = new RGBSpectrum(
				currentBest.getNormal()
			);
		} catch (NullPointerException e) {}
	}
}
