package world;

import film.RGBSpectrum;
import light.AmbientLight;
import light.DirectionalLight;
import light.Light;
import light.PointLight;
import math.Point;
import math.Transformation;
import math.Vector;
import shape.PrimitiveShape;
import shape.Sphere;
import shape.TransformedShape;

public class WorldConstructor {

	public static World fiveSphereWorld() {
		Transformation t1 = Transformation.translate(0, 0, -10).append(
			Transformation.scale(5, 5, 5));
		Transformation t2 = Transformation.translate(4, -4, -12).append(
			Transformation.scale(4, 4, 4));
		Transformation t3 = Transformation.translate(-4, -4, -12).append(
			Transformation.scale(4, 4, 4));
		Transformation t4 = Transformation.translate(4, 4, -12).append(
			Transformation.scale(4, 4, 4));
		Transformation t5 = Transformation.translate(-4, 4, -12).append(
			Transformation.scale(4, 4, 4));

		World world = new World();
		Sphere sphere = Sphere.getSphere();
		world.addShape(sphere.transformShape(t1));
		world.addShape(sphere.transformShape(t2));
		world.addShape(sphere.transformShape(t3));
		world.addShape(sphere.transformShape(t4));
		world.addShape(sphere.transformShape(t5));

		return world;
	}

	public static World oneSphereWorld() {
		Transformation t1 = Transformation.translate(0, 0, -10).append(
			Transformation.scale(5, 5, 5)
		);
		Sphere sphere = Sphere.getSphere();
		TransformedShape transform = sphere.transformShape(t1);
		Light light = new DirectionalLight(
			new Vector(2, -1, 0),
			new RGBSpectrum(1, 1, 1), 0.5
		);
		Light light1 = new PointLight(
			new RGBSpectrum(1,1, 1), 50,
			new Point(-6, 6, -10)
		);
		Light light2 = new AmbientLight(
			new RGBSpectrum(1,1, 1), 0.1
		);

		World world = new World();
		world.addShape(transform);
		world.addLight(light);
		world.addLight(light1);
		world.addLight(light2);

		return world;
	}
}
