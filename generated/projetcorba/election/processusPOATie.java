package projetcorba.election;

import org.omg.PortableServer.POA;

/**
 *	Generated from IDL interface "processus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class processusPOATie
	extends processusPOA
{
	private processusOperations _delegate;

	private POA _poa;
	public processusPOATie(processusOperations delegate)
	{
		_delegate = delegate;
	}
	public processusPOATie(processusOperations delegate, POA poa)
	{
		_delegate = delegate;
		_poa = poa;
	}
	public projetcorba.election.processus _this()
	{
		return projetcorba.election.processusHelper.narrow(_this_object());
	}
	public projetcorba.election.processus _this(org.omg.CORBA.ORB orb)
	{
		return projetcorba.election.processusHelper.narrow(_this_object(orb));
	}
	public processusOperations _delegate()
	{
		return _delegate;
	}
	public void _delegate(processusOperations delegate)
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
	public java.lang.String successeurPanne()
	{
		return _delegate.successeurPanne();
	}

	public void recevoir(org.omg.CORBA.IntHolder max)
	{
_delegate.recevoir(max);
	}

	public int uid()
	{
		return _delegate.uid();
	}

	public void successeurPanne(java.lang.String a)
	{
		_delegate.successeurPanne(a);
	}

	public void uid(int a)
	{
		_delegate.uid(a);
	}

	public java.lang.String successeur()
	{
		return _delegate.successeur();
	}

	public void successeur(java.lang.String a)
	{
		_delegate.successeur(a);
	}

}
