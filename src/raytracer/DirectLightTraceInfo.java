package raytracer;

import film.RGBSpectrum;
import math.Point;
import math.Ray;

public class DirectLightTraceInfo extends NormalTraceInfo {

	private Point hitpoint;
	private RGBSpectrum color;

	public DirectLightTraceInfo(Ray ray) throws NullPointerException {
		super(ray);
	}

	public Point getHitpoint() {
		if (hitpoint == null) {
			hitpoint = getRay().applyTvalue(
				getDistance()
			);
		}
		return hitpoint;
	}

	public RGBSpectrum getColor() {
		if (color == null) {
			color = new RGBSpectrum(1);
		}

		return color;
	}
}
