package projetcorba.utils;
import org.omg.CORBA.*;

import org.omg.PortableServer.*;

import java.io.*;
import java.lang.*;
import java.util.*;
import projetcorba.utils.*;
import projetcorba.election.*;

public class Outil{

	
	public Outil(){
	};

	//Procédure de l'élection
	public static void election(ORB orb,Orb_Run orb_run, int uid){
		System.out.println("- Démarrage de l'élection");
	        processus currentPs = Outil.lookupRef("" + uid, orb);
		boolean found = false;
		String successeur=currentPs.successeur();
		//int uid=Integer.parseInt(uid);
		processus p = null;
		while(!successeur.equals("" + uid))
		{
			System.out.println(successeur+"|"+uid);			
			File fichier = new File("p"+successeur+".ref");
			if(!fichier.exists())
			{
				System.out.println("fff");
				break;						
			}
			p = Outil.lookupRef(successeur,orb);
			successeur=p.successeur();
			
			if(successeur.equals(uid)){
				System.out.println("TROUVE!!!");						
				found=true;
				break;
			}
			
		}//fin while
		if(found){
			 //lancer algorithme;
			boolean fin_algo=false;
			System.out.println("lancement algo");
			p = Outil.lookupRef(successeur,orb);
			successeur=p.successeur();
			
			while(!fin_algo){

				p = Outil.lookupRef(successeur,orb);
				System.out.println("le sucesseur : "+successeur);
				System.out.println("uid envoye : "+uid);
				uid=p.recevoir(uid);
				System.out.println("uid reçu : "+uid);
				successeur=p.successeur();
				if(p.elu()){
					fin_algo=true;
					}
				System.out.println("Elu courant : "+uid);
			try{
				orb_run.sleep(2000);
			}catch(Exception e){
			}
				
		
			
			}//fin while
			System.out.println("Le gagnant est : "+uid);
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
    	    processusImpl machine = new processusImpl(uid, successeur,successeurPanne, false);
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
				           	System.exit(1);
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
