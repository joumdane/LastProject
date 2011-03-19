package projetcorba.election;

/**
 *	Generated from IDL interface "processus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */


public interface processusOperations
{
	/* constants */
	/* operations  */
	int uid();
	void uid(int arg);
	java.lang.String successeur();
	void successeur(java.lang.String arg);
	java.lang.String successeurPanne();
	void successeurPanne(java.lang.String arg);
	boolean elu();
	void elu(boolean arg);
	int max_uid();
	void max_uid(int arg);
	int recevoir(int uid);
}
