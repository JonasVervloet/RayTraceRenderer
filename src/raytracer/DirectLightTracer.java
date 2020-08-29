package raytracer;

import film.RGBSpectrum;
import light.AmbientLight;
import light.DirectionalLight;
import light.PointLight;
import math.Normal;
import math.Point;
import math.Ray;
import math.Vector;
import shape.PrimitiveShape;

import java.util.NoSuchElementException;
import java.util.Optional;

public class DirectLightTracer extends AbstractRayTracer {

	private DirectLightTraceInfo currentBest;
	private DirectLightTraceInfo info;

	/*
	Constructor
	 */
	public DirectLightTracer() {
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
		info = new DirectLightTraceInfo(originalRay);
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

	private boolean hasHadHit() {
		return currentBest != null;
	}

	/*
	SHAPES
	 */
	@Override
	public void visitPrimitiveShape(PrimitiveShape shape) {
		try {
			double nDist = shape.getDistance(
				getCurrentRay()
			).get();
			if (nDist < getCurrentBestDistance()) {
				info.setDistance(nDist);
				info.setShape(shape);
				currentBest = info;
			}
		} catch (NoSuchElementException e) {}
	}

	/*
	LIGHTS
	 */
	@Override
	public void visitAmbientLight(AmbientLight light) {
		try {
			if (hasHadHit()) {
				finalColor = finalColor.add(
					currentBest.getColor().multiply(light.getOutputLight())
				);
			}
		} catch (NoSuchElementException e) {}
	}

	@Override
	public void visitDirectionalLight(DirectionalLight light) {
		try {
			if (hasHadHit()) {
				Vector direction = light.getDirection().scale(-1);
				double cosine = currentBest.getNormal().dot(direction);
				if (cosine >= 0) {
					finalColor = finalColor.add(
						currentBest.getColor().multiply(light.getOutputLight().scale(cosine))
					);
				}
			}
		} catch (NoSuchElementException e) {}
	}

	@Override
	public void visitPointLight(PointLight light) {
		try {
			if (hasHadHit()) {
				Vector direction = light.getDirection(currentBest.getHitpoint()).scale(-1);
				double cosine = currentBest.getNormal().dot(direction);
				double invDistSquared = 1 / Math.pow(light.getDistance(currentBest.getHitpoint()), 2);
				if (cosine >= 0) {
					finalColor = finalColor.add(
						currentBest.getColor().multiply(light.getOutputLight().scale(cosine * invDistSquared))
					);
				}
			}
		} catch (NoSuchElementException e) {}
	}
}
