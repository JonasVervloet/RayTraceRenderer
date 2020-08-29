package raytracer;

import light.AmbientLight;
import light.DirectionalLight;
import light.PointLight;
import shape.PrimitiveShape;
import shape.TransformedShape;
import world.World;
import film.RGBSpectrum;
import math.Ray;

public interface RayTracer {

	RGBSpectrum trace(World world, Ray ray);

	void visitNewShape();

	void visitPrimitiveShape(PrimitiveShape shape);

	void visitTransformedShape(TransformedShape shape);

	void visitAmbientLight(AmbientLight light);

	void visitDirectionalLight(DirectionalLight light);

	void visitPointLight(PointLight light);
}
