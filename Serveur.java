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
            //init ORB
            ORB orb = ORB.init(args, null);
	    Orb_Run orb_run = new Orb_Run(orb);
            //init POA
            POA poa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            poa.the_POAManager().activate();

            ////////////////////////////////////////////////////////////////
	    processusImpl machine = new processusImpl(Integer.parseInt(args[0]), args[1],false);
	    org.omg.CORBA.Object tmp = poa.servant_to_reference(machine);	
            try {
                String processus_ref = orb.object_to_string(tmp);
                String refFile = "p" + args[0]  + ".ref";
                PrintWriter out = new PrintWriter(new FileOutputStream(refFile));
                out.println(processus_ref);
                out.close();
            } catch (IOException ex) {
                System.err.println(
                    "Impossible d'ecrire la reference dans p" + args[0]  + ".ref");
                System.exit(1);
            }
	    //start() afin de garder la main pour pouvoir lancer l'élection ou arrêter le processus
      	    orb_run.start();
	    ////////////////////////////////////////////////////
            // Invocation du serveur
            ////////////////////////////////////////////////////
            //System.out.println("Menu: " +"p" + args[0]);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	    String operation;
	   String successeur;
		String ior="";
	    while(true){	
		try{
			//options
			System.out.println("\n\n Que faire : 1- Démarrer l'élection");
			System.out.println("             2- Arrêter la machine ");
	       	 	System.out.println("             3- Quitter");
			successeur="";
			operation = br.readLine(); 
			//
			if (operation.equals("1")){
				//System.out.println("- Démarrage de l'élection");
			
				boolean found = false;
				successeur=args[1];
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
				System.out.println("- Arrêt de la machine");
				System.exit(1);
			      }else if(operation.equals("3")){
					System.out.println("- Arrêt de la machine");
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
