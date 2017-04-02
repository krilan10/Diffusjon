package diffusjon;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Simulator {

    private Field field;

    // The default width for the grid.
    // The default width for the grid.
    private static final int DEFAULT_WIDTH = 120;
    // The default depth of the grid.
    private static final int DEFAULT_DEPTH = 120;
    private ArrayList<Particle> particles;
    // A graphical view of the simulation.
    private SimulatorView view;
    private Particle p;
    private int step;
    private int dimension;

    public Simulator(int dimension) {
        this(dimension,DEFAULT_DEPTH, DEFAULT_WIDTH);

    }

    public Simulator(int dimension,int width, int depth) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
        } else {
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
            field = new Field(depth, width);
            view = new SimulatorView(depth, width);
            view.setColor(Particle.class, Color.RED);
            this.dimension=dimension;
        }

        particles = new ArrayList<Particle>();

        reset();

    }

    public void simulateStep() {
        step++;
        

        for (Particle p : particles) {
            field.clear(p.getLocation());
            p.move(dimension);
               System.out.println("X: " + p.getLocation().getRow() + "   Y: " + p.getLocation().getCol());
        }

        view.showStatus(step, field);

    }

    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps; /*&& view.isViable(field);*/ step++) {
            simulateStep();
        }
    }

    public void populate() {
        p = new Particle(this.field, new Location(60, 60));
        particles.add(p);
    }

    public void reset() {
        step = 0;
        particles.clear();
        populate();
        // Show the starting state in the view.
        view.showStatus(step, field);
    }

}
