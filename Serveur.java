package projetcorba.election;
import org.omg.CORBA.*;

import org.omg.PortableServer.*;

import java.io.*;
import java.lang.*;
import java.util.*;
import projetcorba.utils.*; //Orb_Run.java


public class Serveur {
    public static void main(String[] args) throws IOException {
        
        try {
	    processusHolder ref= new processusHolder();
		
            //init ORB
            ORB orb = ORB.init(args, null);
	    Orb_Run orb_run = new Orb_Run(orb);
            //init POA
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();

            ////////////////////////////////////////////////////////////////
            Outil.preparationObjetCoteServeur(Integer.parseInt(args[0]), args[1], args[2], orb, poa);
	    
	    //start() afin de garder la main pour pouvoir lancer l'élection ou arrêter le processus
      	    orb_run.start();
	    ////////////////////////////////////////////////////
            // Invocation du serveur
            ////////////////////////////////////////////////////
            //System.out.println("Menu: " +"p" + args[0]);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String operation;
	    String successeur;
	    //String ior="";
	    processus currentPs = null;
	    while(true){	
		try{
			//options
			System.out.println("\n\n Que faire : 1- Démarrer l'élection");
			System.out.println("             2- Arrêter la machine ");
			System.out.println("             3- Arrêter brutale la machine ");
			System.out.println("             4- Vérifier l'existence des successeurs");
			successeur="";
			operation = br.readLine(); 
			//
			if (operation.equals("1")){
				Outil.election(orb, orb_run, Integer.parseInt(args[0]));


			}else if(operation.equals("2")){
				currentPs = Outil.lookupRef("" + args[0], orb);
				Outil.reconstituerAnneau(currentPs.uid(),currentPs.successeur(),orb, ref);
				
				System.exit(1);
		        }else if(operation.equals("3")){
			 /*	
		          //Objet File qui représente le chemin du fichier cible
			    File f = new File("p" + args[0] + ".ref");

			    //Suppression du fichier .ref associé au processus en cours
			    if (f.exists()){
				f.delete();			    
			    }*/
					// Desactive l'objet CORBA

		//

		try {

		   //byte [] ObjID = poa.reference_to_id(ref);
			
		   poa.the_POAManager().deactivate(false,false);
		   //deactivate_object(ObjID);
		   }

		catch (Exception e) {

		    System.out.println("POA Exception " + e);

		}
					
				System.exit(1);
		        }else if(operation.equals("4")){
				Outil.verifierSuccesseur(orb,Integer.parseInt(args[0]), args[1], args[2], ref);
		        }
		}catch(Exception ex){
			System.out.println("Erreur lecture");
			System.exit(1);
		}
	    }

        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
