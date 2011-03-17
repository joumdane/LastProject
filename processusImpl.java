package projetcorba.election;

import org.omg.CORBA.*;
import java.util.ArrayList; 
import org.omg.PortableServer.*;

public class processusImpl extends processusPOA{
	
	//Attributs	
	private int uid;
	private String successeur;
	private String successeurPanne;
	

	//Constructeurs
	public processusImpl(){
	}	
	
	public processusImpl(int uid, String successeur,String successeurPanne){
		this.uid = uid;
		this.successeur = successeur;
		this.successeurPanne=this.successeurPanne;
	}
	
	//Setters
	public void uid(int uid){
		this.uid = uid;	
	}


	public void successeur(String successeur){
		this.successeur = successeur;	
	}

	public void successeurPanne(String successeurPanne){
		this.successeurPanne = successeurPanne;	
	}

	//Getters
	public int uid(){
		return uid;	
	}

	public String successeur(){
		return successeur;	
	}

	public String successeurPanne(){
		return successeurPanne;	
	}

	public void recevoir(IntHolder max){
		if(uid > max.value){
			max.value = uid; 
		System.out.println("Le processus p"+uid()+" trouve qu'il a un plus grand uid : "+uid);				
		}
/*
		else if(max==uid){
			elu(true);
		}
*/
		System.out.println("L'elu est le processus p"+max.value);

	}

}

