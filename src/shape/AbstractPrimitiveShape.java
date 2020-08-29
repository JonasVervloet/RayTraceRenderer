package shape;

import math.Ray;
import math.Transformation;
import raytracer.RayTracer;

import javax.xml.crypto.dsig.Transform;
import java.util.NoSuchElementException;

public abstract  class AbstractPrimitiveShape implements  PrimitiveShape {

	@Override
	public void accept(RayTracer tracer) {
		tracer.visitPrimitiveShape(this);
	}

	@Override
	public boolean intersect(Ray ray) {
		try {
			getDistance(ray).get();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@Override
	public TransformedShape transformShape(Transformation transformation) {
		return new TransformedShape(this, transformation);
	}
}
