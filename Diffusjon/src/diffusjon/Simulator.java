package diffusjon;

import java.awt.Color;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;

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
    private static int amount;

    ArrayList<LoggInfo> loggInfo;

    private int step;
    private int dimension;

    public Simulator(int dimension,int amount) {
        this(dimension,amount, DEFAULT_DEPTH, DEFAULT_WIDTH);


    }

    public Simulator(int dimension, int amount, int width, int depth) {
        if (width <= 0 || depth <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
        } else {
            depth = DEFAULT_DEPTH;
            width = DEFAULT_WIDTH;
            field = new Field(depth, width);
            view = new SimulatorView(depth, width);
            view.setColor(Particle.class, Color.RED);
            this.dimension = dimension;
            this.amount=amount;
        }

        loggInfo=new ArrayList<>();

        particles = new ArrayList<Particle>();

        reset();

    }

    public void simulateStep() {
        step++;

        for (Particle p : particles) {
            field.clear(p.getLocation());
            p.move(dimension);
            //System.out.println("X: " + p.getLocation().getRow() + "   Y: " + p.getLocation().getCol());

            loggInfo.add(new LoggInfo(step,p.getLocation().getRow(),p.getLocation().getCol()));
        }

        view.showStatus(step, field);
    }



    public void logg(){
        try{
            PrintWriter writer = new PrintWriter("Diffusjon.txt", "UTF-8");
            writer.println("Step\tX\tY");
            for(LoggInfo l:loggInfo){
                writer.println(l.getStep() +"\t" + l.getxCoordinate()+"\t"+l.getyCoordinate());
            }
            writer.close();
        }catch (IOException ex){

        }


    }




    public void simulate(int numSteps) {
        for (int step = 1; step <= numSteps; /*&& view.isViable(field);*/ step++) {
            simulateStep();

        }
    }

    public void populate(int amount) {
        
        for (int i = 1; i < amount; i++) {
            p = new Particle(this.field, new Location(60, 60));

            particles.add(p);
        }
    }


    public void reset() {
        step = 0;
        particles.clear();
        loggInfo.clear();
        populate(amount);
        // Show the starting state in the view.
        view.showStatus(step, field);
    }

}
