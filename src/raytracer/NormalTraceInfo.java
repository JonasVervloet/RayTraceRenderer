package raytracer;

import math.Normal;
import math.Ray;
import shape.PrimitiveShape;

import java.util.NoSuchElementException;

public class NormalTraceInfo extends DistanceTraceInfo{

	PrimitiveShape shape;
	Normal normal;

	public NormalTraceInfo(Ray ray) throws NullPointerException {
		super(ray);
	}

	public void setShape(PrimitiveShape newShape)
		throws NullPointerException{
		if (newShape == null) {
			throw new NullPointerException("The given shape is null!");
		}
		shape = newShape;
	}

	public Normal getNormal() {
		if (normal == null) {
			normal = shape.getNormal(
				getRay()
			).get();
		}
		return normal;
	}
}
