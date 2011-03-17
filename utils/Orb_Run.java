
package utils;

import org.omg.CORBA.*;
import java.lang.*;
import org.omg.PortableServer.*;


// Demarre une POA CORBA sans bloquer le thread du serveur
//
public class Orb_Run extends Thread {

    public ORB  orb_;

    public Orb_Run(ORB  o) {
        orb_=o;
    }                                             

    public void run() {
        System.out.println("Le serveur est pret");
        orb_.run();

    }
}
      
