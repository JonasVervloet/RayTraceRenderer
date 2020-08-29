package light;

import film.RGBSpectrum;
import raytracer.RayTracer;

public class AmbientLight implements Light {

	private RGBSpectrum color;
	private double intensity;

	public AmbientLight(RGBSpectrum color, double intensity) {
		this.color = color;
		this.intensity = intensity;
	}

	public RGBSpectrum getOutputLight() {
		return color.scale(intensity);
	}


	@Override
	public void accept(RayTracer tracer) {
		tracer.visitAmbientLight(this);
	}
}
