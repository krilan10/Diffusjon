/**
 * Created by Kristian on 27.03.2017.
 */
public class main {

    public static void main(String[] args) {
        Act a = new Act(300);
        a.createParticles();
        a.getGrid();
        a.severalSteps(5);




        /*int numberOfSteps = 50;
        int x = a.getBinomial(numberOfSteps, 0.5);
        int placement = numberOfSteps-x;
        int p = placement-25;
        if (p < 0){
            p = p *-1;
        }


        if(placement > 25){
            System.out.println("The particle moved " + p +" steps to the right");
        }
        else if(placement == 25){
            System.out.println("The particle ended up at it's initial position");
        }
        else{
            System.out.println("The particle moved " + p +" steps to the left");
        }*/





    }

}
