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
    
    //Setter dimensjonen for simulering til 1D
        static int dimension=2;
        
        
       public static void main(String[] args) {
       
           
           
        Simulator s=new Simulator(dimension);
        
        
        // Simulerer (antall Steg, Antall dimesjoner)
        // NB! bare implementert 1D
        s.simulate(4000,1);
    }
}
