package world;

import light.Light;
import math.Ray;
import raytracer.RayTracer;
import shape.PrimitiveShape;
import shape.Shape;

import java.util.ArrayList;
import java.util.List;

public class World {

	/*
	List of shapes that are present in this world.
	 */
	private ArrayList<Shape> shapes;

	/*
	List of lights that are present in this world.
	 */
	private ArrayList<Light> lights;



	/*
	Constructor
	 */
	public World() {
		shapes = new ArrayList<>();
		lights = new ArrayList<>();
	}


	/*
	Shapes
	 */
	private List<Shape> getShapes() {
		return this.shapes;
	}

	public void addShape(Shape shape) {
		getShapes().add(shape);
	}

	public void visitShapes(RayTracer tracer) {
		for (Shape shape: getShapes()) {
			tracer.visitNewShape();
			shape.accept(tracer);
		}
	}

	/*
	Lights
	 */
	private List<Light> getLights() {
		return this.lights;
	}

	public void addLight(Light light) {
		getLights().add(light);
	}

	public void visitLights(RayTracer tracer) {
		for (Light light: getLights()) {
			light.accept(tracer);
		}
	}
}
