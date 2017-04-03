/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mikael
 */
package diffusjon;

public class main {
    
    //Velg dimensjon til simuleringen 1D eller 2D
    //Antall Steg
    //antall parikler som skal være i simuleringen
    
        static int dimension=2;
        static int steps=1000;
        static int amountOfParticles=300;
        
        
       public static void main(String[] args) {
       
           
           
        Simulator s=new Simulator(dimension,amountOfParticles);

        
        
        // Simulerer (antall Steg, Antall dimesjoner)
        // NB! bare implementert 1D og 2D
        s.simulate(steps);
        s.logg();
    }
}
