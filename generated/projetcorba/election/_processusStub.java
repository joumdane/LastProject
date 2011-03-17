package projetcorba.election;


/**
 *	Generated from IDL interface "processus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public class _processusStub
	extends org.omg.CORBA.portable.ObjectImpl
	implements projetcorba.election.processus
{
	private String[] ids = {"IDL:projetcorba/election/processus:1.0"};
	public String[] _ids()
	{
		return ids;
	}

	public final static java.lang.Class _opsClass = projetcorba.election.processusOperations.class;
	public java.lang.String successeurPanne()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_get_successeurPanne",true);
				_is = _invoke(_os);
				return _is.read_string();
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
		org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_get_successeurPanne", _opsClass);
		if( _so == null )
			throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
			java.lang.String _result;
		try
		{
			_result = _localServant.successeurPanne();
		}
		finally
		{
			_servant_postinvoke(_so);
		}
		return _result;
		}
		}

	}

	public void recevoir(org.omg.CORBA.IntHolder max)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request( "recevoir", true);
				_os.write_long(max.value);
				_is = _invoke(_os);
				max.value = _is.read_long();
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "recevoir", _opsClass );
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
			try
			{
			_localServant.recevoir(max);
			}
			finally
			{
				_servant_postinvoke(_so);
			}
			return;
		}

		}

	}

	public int uid()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_get_uid",true);
				_is = _invoke(_os);
				return _is.read_long();
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
		org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_get_uid", _opsClass);
		if( _so == null )
			throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
			int _result;
		try
		{
			_result = _localServant.uid();
		}
		finally
		{
			_servant_postinvoke(_so);
		}
		return _result;
		}
		}

	}

	public void successeurPanne(java.lang.String a)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_set_successeurPanne",true);
				_os.write_string(a);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_set_successeurPanne", _opsClass);
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
				try
				{
					_localServant.successeurPanne(a);
				}
				finally
				{
					_servant_postinvoke(_so);
				}
				return;
			}
		}

	}

	public void uid(int a)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_set_uid",true);
				_os.write_long(a);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_set_uid", _opsClass);
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
				try
				{
					_localServant.uid(a);
				}
				finally
				{
					_servant_postinvoke(_so);
				}
				return;
			}
		}

	}

	public java.lang.String successeur()
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_get_successeur",true);
				_is = _invoke(_os);
				return _is.read_string();
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
		org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_get_successeur", _opsClass);
		if( _so == null )
			throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
			java.lang.String _result;
		try
		{
			_result = _localServant.successeur();
		}
		finally
		{
			_servant_postinvoke(_so);
		}
		return _result;
		}
		}

	}

	public void successeur(java.lang.String a)
	{
		while(true)
		{
		if(! this._is_local())
		{
			org.omg.CORBA.portable.InputStream _is = null;
			try
			{
				org.omg.CORBA.portable.OutputStream _os = _request("_set_successeur",true);
				_os.write_string(a);
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
			org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke( "_set_successeur", _opsClass);
			if( _so == null )
				throw new org.omg.CORBA.UNKNOWN("local invocations not supported!");
			processusOperations _localServant = (processusOperations)_so.servant;
				try
				{
					_localServant.successeur(a);
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
