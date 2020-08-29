package light;

import film.RGBSpectrum;
import math.Normal;
import math.Point;
import raytracer.RayTracer;

public class PointLight implements Light {

	private RGBSpectrum color;
	private double intensity;
	private Point location;

	public PointLight(RGBSpectrum color, double intensity, Point location) {
		this.color = color;
		this.intensity = intensity;
		this.location = location;
	}

	public Normal getDirection(Point hitpoint) {
		return new Normal(
			hitpoint.subtract(location)
		);
	}

	public double getDistance(Point hitpoint) {
		return hitpoint.subtract(location).length();
	}

	public RGBSpectrum getOutputLight() {
		return color.scale(intensity);
	}

	@Override
	public void accept(RayTracer tracer) {
		tracer.visitPointLight(this);
	}
}
