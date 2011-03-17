package projetcorba.election;

import org.omg.CORBA.*;
import java.util.ArrayList; 
import org.omg.PortableServer.*;

public class gestionprocessusImpl extends gestionprocessusPOA{
	public ArrayList anneau_processus = new ArrayList();
	
	// Reference sur la POA
	//
	protected  POA poa_;

	public gestionprocessusImpl(POA poa){		
				poa_=poa;	
	}
	

	//Création du processus
	public void creation_processus(int uid, int successeur, processusHolder ref){
		processusImpl machine = new processusImpl(uid, successeur, false);
		org.omg.CORBA.Object tmp = poa_.servant_to_reference(machine);
		processus ps = abonneHelper.narrow(tmp);
		ref.value = ps;
		anneau_processus.add(ps);

	}	
	

	//Suppression du processus(en panne)
	public void arreter_processus(int uid){
		for(int i = 0; i < anneau_processus.size(); i++){
			if(anneau_processus.get(i).uid() == uid){
				anneau_processus.remove(i);
				break;
			}		
		}
	}
}

