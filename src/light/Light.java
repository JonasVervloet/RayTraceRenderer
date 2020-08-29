package light;

import raytracer.RayTracer;

public interface Light {

	void accept(RayTracer tracer);
}
