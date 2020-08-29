package raytracer;

import film.RGBSpectrum;
import math.Ray;

public class TraceInfo {

	private Ray ray;
	private RGBSpectrum color;
	private Double minDist;

	public TraceInfo(Ray ray) {
		this.ray = ray;
		color = RGBSpectrum.BLACK;
		this.minDist = Double.MAX_VALUE;
	}

	public Ray getRay() {
		return ray;
	}


	public RGBSpectrum getColor() {
		return this.color;
	}

	public void setColor(RGBSpectrum nColor) {
		this.color = nColor;
	}

	public Double getMinDist() {
		return minDist;
	}

	public void setMinDist(Double nDist) {
		this.minDist = nDist;
	}
}
