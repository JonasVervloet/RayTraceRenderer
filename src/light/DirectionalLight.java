package light;

import film.RGBSpectrum;
import math.Normal;
import math.Vector;
import raytracer.RayTracer;

public class DirectionalLight implements Light {

	private Normal direction;
	private RGBSpectrum color;
	private double intensity;

	public DirectionalLight(Vector vec, RGBSpectrum color, double intensity) {
		this.direction = new Normal(vec);
		this.color = color;
		this.intensity = intensity;
	}

	public Normal getDirection() {
		return this.direction;
	}

	public RGBSpectrum getOutputLight() {
		return color.scale(intensity);
	}

	@Override
	public void accept(RayTracer tracer) {
		tracer.visitDirectionalLight(this);
	}
}
