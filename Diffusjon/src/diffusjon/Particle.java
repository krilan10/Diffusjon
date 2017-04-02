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
    public void move1D(){
        setLocation(get1D());
    }

    // Moves particle along the x-axis if true he moves to the right, if false moves left
    public Location get1D() {

        Random number = new Random();
        Location oldLoc=loc;
        int nr = number.nextInt(2);
       
        if (nr > 0) {
            loc.moveX(true);
        } else {
            loc.moveX(false);
        }
        Location newLoc;
        newLoc = new Location(loc.getRow(), loc.getCol());
   
        if (newLoc.getRow() < 0 ||newLoc.getCol()<0 || newLoc.getRow()>120||newLoc.getRow()>80){
            newLoc=oldLoc;
            System.out.println("Used old location");
        }
        return newLoc;

    }

    public void setLocation(Location newLocation) {
        if (loc != null) {
            field.clear(loc);
        }
        loc = newLocation;
        field.place(this, newLocation);
    }

}
