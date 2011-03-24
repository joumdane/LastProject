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
	 public Orb_Run orb_run;
	 public int uid;
	 public String successeur;
	 public String successeurPanne;
	 public processusHolder ref;
         public static  boolean  end  = false;    // termine le thread

	 public SubTimer(ORB orb,  Orb_Run orb_run,int uid, String successeur, String successeurPanne, processusHolder ref){
		 this.orb = orb;
		 this.orb_run = orb_run;
		 this.uid = uid;
		 this.successeur = successeur;
		 this.successeurPanne = successeurPanne;
		 this.ref = ref;
	 }
	 public void run(){
		try{
			while(!end){
			    Outil.verifierSuccesseur(orb, orb_run, uid, successeur, successeurPanne, ref);
		 	}if(end){
				end = false;
				this.suspend();		
			}
		
		}catch(Exception e){
				
			}
		
	}
}
