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
            Outil.preparationObjetCoteServeur(Integer.parseInt(args[0]), args[1], orb, poa);
	    
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
			successeur="";
			operation = br.readLine(); 
			//
			if (operation.equals("1")){
				System.out.println("- Démarrage de l'élection");
				//il faut récuperer de nouveau l'objet current parce que, il se peut que son successeur a était modifié	
			        currentPs = Outil.lookupRef("" +args[0], orb);
				boolean found = false;
				successeur=currentPs.successeur();
				int uid=Integer.parseInt(args[0]);
				processus p = null;
				while(!successeur.equals(args[0]))
				{
					System.out.println(successeur+"|"+args[0]);			
					File fichier = new File("p"+successeur+".ref");
					if(!fichier.exists())
					{
						System.out.println("fff");
						break;						
					}
					p = Outil.lookupRef(successeur,orb);
					successeur=p.successeur();
					
					if(successeur.equals(args[0])){
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
						orb_run.sleep(2000);
				
					
					}//fin while
					System.out.println("Le gagnant est : "+uid);
				}//fin if
				else{
					 System.out.println("ANNEAU NON FORME");
				}				
			


			}else if(operation.equals("2")){
				currentPs = Outil.lookupRef("" + args[0], orb);
				Outil.reconstituerAnneau(currentPs.uid(),currentPs.successeur(),orb, ref);
				
				System.exit(1);
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
