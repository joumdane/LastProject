package projetcorba.election;

/**
 *	Generated from IDL interface "gestionprocessus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */


public interface gestionprocessusOperations
{
	/* constants */
	/* operations  */
	projetcorba.election.processus[] anneau_processus();
	void creation_processus(int uid, int successeur, projetcorba.election.processusHolder ref);
	void arreter_processus(int uid);
}
