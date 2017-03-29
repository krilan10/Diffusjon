import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by Kristian on 27.03.2017.
 */
public class Act {
    private int direction;
    private Random random;
    private int col;
    private int row;
    private HashMap<Integer, Integer> randoms;
    private ArrayList<Particle> particles;
    private ArrayList<Field> fields;
    private int numberOfTimes;
    private  int particle;

    public Act(int numberOfTimes){
        this.random = new Random();
        this.randoms = new HashMap<>();
        this.numberOfTimes = numberOfTimes;
        this.particles = new ArrayList<>();
        this.fields = new ArrayList<>();
        particle = 0;
    }

   /* public static  int	getBinomial(int	n,	double	p)	{
        int	x	=	0;
        for(int	i	=	0;	i	<	n;	i++)	{
            if(Math.random()	<	p)
                x++;
        }
        return	x;
    }*/
    public void getRandom(){
        for(int i=0; i<= numberOfTimes; i++ ) {
            int r = random.nextInt(4)+1;
            randoms.put(i, r);
        }
    }

    public void createParticles(){
        for(int i=0; i<= numberOfTimes; i++){
            particles.add(new Particle(0, 0));
        }
    }

    public void printAll(){
        int i = 0;

        for(Particle p : particles){
            System.out.println("index: "+ i+" Col: " + p.getCol() + " Row: " + p.getRow());
            i++;
        }
    }

    public void getGrid(){
        for(int i = -5; i<=5 ; i++){
            for(int n = -5; n<=5; n++){
                Field f = new Field(i, n);
                fields.add(f);
            }
        }
    }

    public void getGridData(){
        for(Field f : fields){
            int h = f.getNumberOf();
            for(Particle p : particles){
                if(p.getCol() == f.getCol() && p.getRow() == f.getRow()){
                    f.setNumberOf(h + 1);

                }
            }
        }
    }

    public void severalSteps(int steps){
        for(int i=0; i<= steps; i++){
            getRandom();
            newPosition();
            getGridData();
            for(Field f: fields) {
                if ( f.getNumberOf() != 0){
                    System.out.println("Col: " + f.getCol() + " Row: " + f.getRow() + " Number: " + f.getNumberOf());
                    f.setNumberOf(0);
                }
            }


        }

    }



    public void newPosition(){
        for(int i=0; i <= numberOfTimes; i++) {
            Particle p = particles.get(i);
            int c = p.getCol();
            int r = p.getRow();
             if (randoms.get(i) == 1) {
                 p.setCol(c+1);
             } else if (randoms.get(i) == 2) {
                 p.setRow(r+1);
             } else if (randoms.get(i) == 3) {
                 p.setCol(c-1);
             } else if (randoms.get(i) == 4) {
                 p.setRow(r-1);
             }

        }
    }
}
