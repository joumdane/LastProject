package projetcorba.election;

import org.omg.CORBA.*;

import org.omg.PortableServer.*;

import java.io.*;
import java.lang.*;
import java.util.*;
import projetcorba.utils.*; //Orb_Run.java
import java.util.Timer;
import java.util.TimerTask;

/**
 * La classe Machibe présente à la fois un Serveur & un Client vu la
 * particularité exigée par l'algorithme Chang & Robert
 */
public class Machine {
	public static void main(String[] args) throws IOException {
		try {
			processusHolder ref = new processusHolder();
			// init ORB
			ORB orb = ORB.init(args, null);
			Orb_Run orb_run = new Orb_Run(orb);
			// init POA
			POA poa = POAHelper.narrow(orb
					.resolve_initial_references("RootPOA"));
			poa.the_POAManager().activate();

			Outil.preparationObjetCoteServeur(Integer.parseInt(args[0]),
					args[1], args[2], orb, poa);

			// start() afin de garder la main pour pouvoir lancer l'élection ou
			// arrêter le processus
			orb_run.start();

			// //////////////////////////////////////////////////
			// Invocation du serveur
			// //////////////////////////////////////////////////

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String operation;
			String successeur;
			processus currentPs = null;
			File f1 = new File("p" + args[1] + ".ref");
			File f2 = new File("p" + args[2] + ".ref");

			// Le menu ne serait afficher qu'après la création effective des
			// deux fichiers qui correspondent aux fichier .ref du successeur &
			// successeurPanne du processus en cours
			while ((!f1.exists()) || (!f2.exists())) {
			}

			// Lors de la création des deux fichiers le processus en cours
			// commence une vérification periodique de son successeur, au cas
			// son processus est en panne, le processus en cours va déclancher
			// une alerte afin de reconsituer l'annneau & faire ainsi une
			// élection automatique. 
			Outil.periodiqueVerification(orb, orb_run,
					Integer.parseInt(args[0]), args[1], args[2], ref);
			while (true) {
				try {
					// options
					System.out.println("\n\n      .:::MENU:::.      ");
					System.out.println("1- Démarrer l'élection");
					System.out.println("2- Arrêter brutalement la machine ");

					/*
					 * Pour déboguer le fonctionnement du programme
					 * 
					 * System.out.println("3- Arrêter la machine ");
					 * System.out.println
					 * ("4- Vérifier l'existence des successeurs");
					 * System.out.println
					 * ("5- Déclancher la vérification périodique du successeur"
					 * ); System.out.println(
					 * "6- Arrêter la vérification périodique du successeur");
					 */
					System.out.println(" Que voulez vous faire: ");
					successeur = "";
					operation = br.readLine();

					//Lancement d'une élection
					if (operation.equals("1")) {
						Outil.election(orb, orb_run, Integer.parseInt(args[0]));
					
					//Arrêt brutalement du processus cible
					} else if (operation.equals("2")) {

						try {

							// byte [] ObjID = poa.reference_to_id(ref);

							//poa.the_POAManager().deactivate(false, false);
							System.exit(1);
							// deactivate_object(ObjID);
						}

						catch (Exception e) {

							System.out.println("POA Exception " + e);

						}

						System.exit(1);
					//Arrêt de la machine d'une façon normale
					} else if (operation.equals("3")) {
						currentPs = Outil.lookupRef("" + args[0], orb);
						Outil.reconstituerAnneau(currentPs.uid(),
								currentPs.successeur(), orb, ref);

						System.exit(1);
					//Lancement manuel de la vérification périodique du successeur cible
					} else if (operation.equals("4")) {
						try {
							System.out.println("\n\nVérification en cours...");
							if (ref.value == null) {
								Outil.verifierSuccesseur(orb, orb_run,
										Integer.parseInt(args[0]), args[1],
										args[2], ref);
							} else {
								processus ps = ref.value;
								Outil.verifierSuccesseur(orb, orb_run,
										ps.uid(), ps.successeur(),
										ps.successeurPanne(), ref);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					//Arrêt de la vérification périodique
					} else if (operation.equals("5")) {
						if (ref.value == null) {
							System.out.println("\n\nVérification en cours...");
							Outil.periodiqueVerification(orb, orb_run,
									Integer.parseInt(args[0]), args[1],
									args[2], ref);
						} else {

							processus ps = ref.value;
							Outil.periodiqueVerification(orb, orb_run,
									ps.uid(), ps.successeur(),
									ps.successeurPanne(), ref);
						}

					} else if (operation.equals("6")) {
						Outil.arreterVerificationPeriodique();
					}

				} catch (Exception ex) {
					System.out.println("Erreur lecture");
					System.exit(1);
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	class SubTimer extends TimerTask {
		public int i = 0;

		public void run() {
			System.out.println("" + ++i);
		}

	}

}
