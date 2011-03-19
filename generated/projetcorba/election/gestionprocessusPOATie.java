package projetcorba.election;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "gestionprocessus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class gestionprocessusPOATie
	extends gestionprocessusPOA
{
	private gestionprocessusOperations _delegate;

	private POA _poa;
	public gestionprocessusPOATie(gestionprocessusOperations delegate)
	{
		_delegate = delegate;
	}
	public gestionprocessusPOATie(gestionprocessusOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public projetcorba.election.gestionprocessus _this()
	{
		return projetcorba.election.gestionprocessusHelper.narrow(_this_object());
	}
	public projetcorba.election.gestionprocessus _this(org.omg.CORBA.ORB orb)
	{
		return projetcorba.election.gestionprocessusHelper.narrow(_this_object(orb));
	}
	public gestionprocessusOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(gestionprocessusOperations delegate)
	{
		_delegate = delegate;
	}
	public POA _default_POA()
	{
		if (_poa != null)
		{
			return _poa;
		}
		else
		{
			return super._default_POA();
		}
	}
	public void creation_processus(int uid, int successeur, projetcorba.election.processusHolder ref)
	{
_delegate.creation_processus(uid,successeur,ref);
	}

	public projetcorba.election.processus[] anneau_processus()
	{
		return _delegate.anneau_processus();
	}

	public void arreter_processus(int uid)
	{
_delegate.arreter_processus(uid);
	}

}
