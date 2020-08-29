package raytracer;

import math.Ray;
import shape.PrimitiveShape;
import film.RGBSpectrum;

import java.util.NoSuchElementException;

public class DistanceTracer extends AbstractRayTracer {

	private Double maxDistance;
	private DistanceTraceInfo currentBest;
	private DistanceTraceInfo info;

	/*
	Constructor
	 */
	public DistanceTracer(double maxDistance) {
		this.maxDistance = maxDistance;
		this.currentBest = null;
		this.info = null;
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
		info = new DistanceTraceInfo(originalRay);
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
	Shapes
	 */
	@Override
	public void visitPrimitiveShape(PrimitiveShape shape) {
		try {
			double nDist = shape.getDistance(
				getCurrentRay()
			).get();
			if (nDist < getCurrentBestDistance()) {
				info.setDistance(nDist);
				currentBest = info;
			}
		} catch (NoSuchElementException e) {}
	}

	@Override
	protected void processShapeVisits() {
		if (currentBest != null) {
			double relative =
				Math.min(
					getCurrentBestDistance()/maxDistance, 1.0
				);
			finalColor = new RGBSpectrum(
				relative, 0, 1-relative
			);
		}
	}
}
