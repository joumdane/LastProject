package projetcorba.election;

import org.omg.CORBA.*;

import org.omg.PortableServer.*;

import java.io.*;
import java.lang.*;
import java.util.*;
import projetcorba.utils.*;
import projetcorba.election.*;
import org.omg.CORBA.*;

public class SubTimer extends Thread{
	 public ORB orb;
	 public int uid;
	 public String successeur;
	 public String successeurPanne;
	 public processusHolder ref;
		

	 public SubTimer(ORB orb, int uid, String successeur, String successeurPanne, processusHolder ref){
		 this.orb = orb;
		 this.uid = uid;
		 this.successeur = successeur;
		 this.successeurPanne = successeurPanne;
		 this.ref = ref;
	 }
	 public void run(){
		while(true){
			System.out.println("uid" + uid);
			System.out.println("successeur" + successeur);
			System.out.println("successeurPanne" + successeurPanne);
			Outil.verifierSuccesseur(orb,uid, successeur, successeurPanne, ref);
			   try {
			       Thread.sleep(1000);
			   } catch (Exception ex){
			   }				
	 	}
	}
}
