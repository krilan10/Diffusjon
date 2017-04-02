package diffusjon;

import static java.lang.Math.random;
import java.util.List;
import java.util.Random;

/**
 * Created by Kristian on 29.03.2017.
 */
public class Particle {

    private int row;
    private int col;
    private int particleNumber;
    private Field field;
    private Location loc;

    public Particle(Field field, Location loc) {
        this.field = field;
        this.loc = loc;
        setLocation(loc);
    }

    public Location getLocation() {
        return loc;
    }

    public void move(int dimension) {
        setLocation(get1D(dimension));
    }

    /*
        Beveger Partikler basert på dimensjoner
        1 = 1 dimensjon
        2= 2 dimensjon
        
        Visst True beveger de seg til en høyere verdi, Visst False beveger de seg til en lavere verdi
     */
    public Location get1D(int dimension) {
        Random number = new Random();
        Location oldLoc = loc;
        int nr = number.nextInt(dimension * 2);
        if (loc.getRow() < 0 || loc.getCol() < 0 || loc.getRow() > 120 || loc.getRow() > 120) {
            System.out.println("Out of bounds . Used old location");
            return oldLoc;
        } else {

            if (nr == 0) {
                loc.moveX(true);
            } else if (nr == 1) {
                loc.moveX(false);
            } else if (nr == 2) {
                loc.moveY(true);
            } else if (nr == 3) {
                loc.moveY(false);
            }
            Location newLoc;
            newLoc=new Location(loc.getRow(),loc.getCol());
            return newLoc;
        }

   

    }

    public void setLocation(Location newLocation) {
        if (loc != null) {
            field.clear(loc);
        }
        loc = newLocation;
        field.place(this, newLocation);
    }

}
