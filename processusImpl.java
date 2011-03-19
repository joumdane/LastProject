package projetcorba.election;

import org.omg.CORBA.*;
import java.util.ArrayList; 
import org.omg.PortableServer.*;

public class processusImpl extends processusPOA{
	
	//Attributs	
	private int uid;
	private String successeur;
	private boolean elu;
	private int max_uid;
	

	//Constructeurs
	public processusImpl(){
	}	
	
	public processusImpl(int uid, String successeur, boolean elu){
		this.uid = uid;
		this.successeur = successeur;
		this.elu = elu;
		this.max_uid = uid;
	}
	
	//Setters
	public void uid(int uid){
		this.uid = uid;	
	}

	public void max_uid(int max_uid){
		this.max_uid = max_uid;	
	}

	public void successeur(String successeur){
		this.successeur = successeur;	
	}

	public void elu(boolean elu){
		this.elu = elu;	
	}
	
	//Getters
	public int uid(){
		return uid;	
	}

	public int max_uid(){
		return max_uid;	
	}

	public String successeur(){
		return successeur;	
	}

	public boolean elu(){
		return elu;	
	}

	public int recevoir(int uid){
		if(uid > this.max_uid ){
			max_uid = uid; 
		}
		else if(this.max_uid==uid){
			elu(true);
			System.out.println("L'elu est le processus p"+uid);
		}
		return max_uid;
	}

}

