package projetcorba.utils;
import org.omg.CORBA.*;

import org.omg.PortableServer.*;

import java.io.*;
import java.lang.*;
import java.util.*;
import projetcorba.utils.*;
import projetcorba.election.*;

public class Outil{

	public Outil(){};

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
				// "abonne"  avec narrow ("cast" dynamique)
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
