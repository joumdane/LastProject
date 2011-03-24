package projetcorba.utils;
import org.omg.CORBA.*;

import org.omg.PortableServer.*;

import java.io.*;
import java.lang.*;
import java.util.*;
import projetcorba.utils.*;
import projetcorba.election.*;
import org.omg.CORBA.*;

public class Outil{

	
	public Outil(){
	};

	//Arrêter la vérification du successeur
        public static void arreterVerificationPeriodique(){
		SubTimer.end = true;
        }
	
	//Périodique vérification du successeur
	public static void periodiqueVerification(ORB orb,  Orb_Run orb_run,int uid, String successeur,String successeurPanne, processusHolder ref){		
	SubTimer sbTimer = new SubTimer(orb, orb_run, uid, successeur, successeurPanne, ref);
	sbTimer.setName("thread" + uid);
	sbTimer.start();
	}
	
	//Vérification de l'existance d'un processus cible
	public static boolean verifierExistanceProcessus(String uid, ORB orb){
		boolean exists = false;
		File f = new File("p" + uid+ ".ref");
	    	if (!f.exists()){

	    	}else{ 
			
			try{
				processus tmp = Outil.lookupRef(uid, orb);
				int frake = tmp.uid();
				if(tmp != null){
					exists = true;			
				}	
			}catch(Exception e){ //TRANSIENT
				f.delete();
			}			
			
			
		}
		return exists;	
	}
	//Vérification du successeur
	public static void verifierSuccesseur(ORB orb, Orb_Run orb_run, int uid, String successeur, String successeurPanne, processusHolder ref){
		boolean exists = false;
		String processusEnPanne = "";
		String id = ""+uid;
		processus tmp = Outil.lookupRef(id, orb);
		processus nxtPs = null;	
		
		if(!Outil.verifierExistanceProcessus(successeur, orb)){
			System.out.println("le processus " + successeur + " n'existe plus");
			System.out.println("Reconstitution de l'anneau en cours ...");    	
			processusEnPanne = successeur;
			tmp.successeur(successeurPanne);
			nxtPs = Outil.lookupRef(successeurPanne, orb);
			tmp.successeurPanne(nxtPs.successeur());

			while(!nxtPs.successeurPanne().equals(processusEnPanne)){		
				nxtPs = Outil.lookupRef(nxtPs.successeur(), orb);
			}
			if(nxtPs.successeurPanne().equals(processusEnPanne)){
				nxtPs.successeurPanne(tmp.successeur());
					
			}
		
			ref.value = tmp;
			Outil.election(orb, orb_run, tmp.uid());
				
		}
		
		//System.out.println("Successeur: " + tmp.successeur());
		//System.out.println("SuccesseurPanne: " + tmp.successeurPanne());
		
	}

	//Procédure de l'élection
	public static void election(ORB orb,Orb_Run orb_run, int uid){
		System.out.println("- Démarrage de l'élection");
	        processus currentPs = Outil.lookupRef("" + uid, orb);
		boolean found = false;
		boolean fin_algo=false;
		IntHolder max = new IntHolder();
		max.value=uid;
		String successeur=currentPs.successeur();
		//int uid=Integer.parseInt(uid);
		processus p = null;
		while(!successeur.equals("" + uid))
		{
			System.out.println(successeur+"|"+uid);			
			File fichier = new File("p"+successeur+".ref");
			if(!fichier.exists())
			{
				System.out.println("Le processus p"+successeur+" est inexistant!!");
				break;						
			}
			p = Outil.lookupRef(successeur,orb);
			successeur=p.successeur();
			
			if(successeur.equals((""+uid))){
				System.out.println("Anneau bien Forme");
				//On retourne à l'uid courant
				p = Outil.lookupRef(successeur,orb);						
				found=true;
				break;
			}
			
		}//fin while
		if(found){
			 //lancer algorithme;

			System.out.println("Debut algorithme Chang et Robert");
			successeur=p.successeur();
			//On se positionne sur l'element qui suit celui qui a déclenché l'election afin d'invoquer
			//la méthode recevoir
			p = Outil.lookupRef(successeur,orb);
			

			while(!fin_algo){
				

				System.out.println("Le processus p"+p.uid()+" recoit l'uid "+max.value);
				p.recevoir(max);
				successeur=p.successeur();
				p = Outil.lookupRef(successeur,orb);
				if(p.uid()==max.value){
					fin_algo=true;
					}
				System.out.println("---------Elu courant : "+max.value);
			try{
				orb_run.sleep(2000);
			}catch(Exception e){
			}
				
		
			
			}//fin while
			System.out.println("-----------------------Le gagnant est : "+max.value);
		}//fin if
		else{
			 System.out.println("ANNEAU NON FORME");
		}				
				
	}
	
	//Préparation de l'Objet côté serveur
	public static void preparationObjetCoteServeur(int uid, String successeur, String successeurPanne, ORB orb, POA poa){
	try{
	    poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();	
    	    processusImpl machine = new processusImpl(uid, successeur,successeurPanne);
	    org.omg.CORBA.Object tmp = poa.servant_to_reference(machine);	
	    try {
		String processus_ref = orb.object_to_string(tmp);
		String refFile = "p" + uid + ".ref";
		PrintWriter out = new PrintWriter(new FileOutputStream(refFile));
		out.println(processus_ref);
		out.close();
	    } catch (IOException ex) {
		System.err.println(
		    "Impossible d'écrire la reference dans p" + uid  + ".ref");
		System.exit(1);
	    }
	}catch(Exception e){
	}
	    
	}
	
	//Reconstitution de l'anneau
	public static void reconstituerAnneau(int id, String successeur,ORB orb, processusHolder ref){
	   processus p = lookupRef(successeur, orb);
	   System.out.print("Anneau: " + successeur + "> ");
	   processus tmp = null;
	   while(p.uid() != id){
		tmp = p;
		System.out.print(tmp.successeur() + "> ");
		p = lookupRef(tmp.successeur(), orb);
	   }
	   tmp.successeur(successeur);
           System.out.println(tmp.successeur());
	   ref.value = tmp;
 	   //preparationObjetCoteServeur(tmp.uid(),tmp.successeur(),orb, poa);
	}
	
	//Récupération de la machine(processus) suivant(e)
	public static processus lookupRef(String successeur,ORB orb){
		String ior="";
		try {
					    String ref = "p"+successeur+".ref";
					    FileInputStream file = new FileInputStream(ref);
					    BufferedReader in = new BufferedReader(new InputStreamReader(file));
					    ior = in.readLine();
					    file.close();
				    	    } catch (IOException ex) {
				    	   	System.err.println("Impossible de lire fichier : `" +
					   	ex.getMessage() + "'");
				           	
						}

				////////////////////////////////////////////////////
				// Construction d'une reference d'objet, non typee d'abord,
				// puis "cast" en une reference sur l'interface 
				// "processus"  avec narrow ("cast" dynamique)
				////////////////////////////////////////////////////
				org.omg.CORBA.Object obj = orb.string_to_object(ior);

				if (obj == null) {
				    System.err.println("Erreur sur string_to_object() ");
				    throw new RuntimeException();
				}

				processus p = processusHelper.narrow(obj);

				if (p== null) {
				    System.err.println("Erreur sur narrow() ");
				    throw new RuntimeException();
				}
			return p;

	}
}
