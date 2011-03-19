package projetcorba.election;


/**
 *	Generated from IDL interface "gestionprocessus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class _gestionprocessusStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements projetcorba.election.gestionprocessus
{
	private String[] ids = {"IDL:projetcorba/election/gestionprocessus:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = projetcorba.election.gestionprocessusOperations.class;
	public void creation_processus(int uid, int successeur, projetcorba.election.processusHolder ref)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "creation_processus", true);
				_os.write_long(uid);
				_os.write_long(successeur);
				projetcorba.election.processusHelper.write(_os,ref.value);
				_is = _invoke(_os);
				ref.value = projetcorba.election.processusHelper.read(_is);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "creation_processus", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			gestionprocessusOperations _localServant = (gestionprocessusOperations)_so.servant;
			try
			{
			_localServant.creation_processus(uid,successeur,ref);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public projetcorba.election.processus[] anneau_processus()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_get_anneau_processus",true);
				_is = _invoke(_os);
				return projetcorba.election.anneauHelper.read(_is);
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}

		else
		{
		org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_get_anneau_processus", _opsClass);
		if( _so == null )
			throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			gestionprocessusOperations _localServant = (gestionprocessusOperations)_so.servant;
			projetcorba.election.processus[] _result;
		try
		{
			_result = _localServant.anneau_processus();
		}
		finally
		{
			_servant_postinvoke(_so);
		}
		return _result;
		}
		}

	}

	public void arreter_processus(int uid)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "arreter_processus", true);
				_os.write_long(uid);
				_is = _invoke(_os);
				return;
			}
			catch( org.omg.CORBA.portable.RemarshalException _rx ){}
			catch( org.omg.CORBA.portable.ApplicationException _ax )
			{
				String _id = _ax.getId();
				throw new RuntimeException("Unexpected exception " + _id );
			}
			finally
			{
				this._releaseReply(_is);
			}
		}
		else
		{
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "arreter_processus", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			gestionprocessusOperations _localServant = (gestionprocessusOperations)_so.servant;
			try
			{
			_localServant.arreter_processus(uid);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

}
