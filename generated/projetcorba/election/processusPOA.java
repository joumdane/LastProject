package projetcorba.election;

/**
 *	Generated from IDL interface "processus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */


public abstract class processusPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, projetcorba.election.processusOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "_get_successeurPanne", new java.lang.Integer(0));
		m_opsHash.put ( "recevoir", new java.lang.Integer(1));
		m_opsHash.put ( "_get_uid", new java.lang.Integer(2));
		m_opsHash.put ( "_set_successeurPanne", new java.lang.Integer(3));
		m_opsHash.put ( "_set_uid", new java.lang.Integer(4));
		m_opsHash.put ( "_get_successeur", new java.lang.Integer(5));
		m_opsHash.put ( "_set_successeur", new java.lang.Integer(6));
	}
	private String[] ids = {"IDL:projetcorba/election/processus:1.0"};
	public projetcorba.election.processus _this()
	{
		return projetcorba.election.processusHelper.narrow(_this_object());
	}
	public projetcorba.election.processus _this(org.omg.CORBA.ORB orb)
	{
		return projetcorba.election.processusHelper.narrow(_this_object(orb));
	}
	public org.omg.CORBA.portable.OutputStream _invoke(String method, org.omg.CORBA.portable.InputStream _input, org.omg.CORBA.portable.ResponseHandler handler)
		throws org.omg.CORBA.SystemException
	{
		org.omg.CORBA.portable.OutputStream _out = null;
		// do something
		// quick lookup of operation
		java.lang.Integer opsIndex = (java.lang.Integer)m_opsHash.get ( method );
		if ( null == opsIndex )
			throw new org.omg.CORBA.BAD_OPERATION(method + " not found");
		switch ( opsIndex.intValue() )
		{
			case 0: // _get_successeurPanne
			{
			_out = handler.createReply();
			_out.write_string(successeurPanne());
				break;
			}
			case 1: // recevoir
			{
				org.omg.CORBA.IntHolder _arg0= new org.omg.CORBA.IntHolder();
				_arg0._read (_input);
				_out = handler.createReply();
				recevoir(_arg0);
				_out.write_long(_arg0.value);
				break;
			}
			case 2: // _get_uid
			{
			_out = handler.createReply();
			_out.write_long(uid());
				break;
			}
			case 3: // _set_successeurPanne
			{
			_out = handler.createReply();
			successeurPanne(_input.read_string());
				break;
			}
			case 4: // _set_uid
			{
			_out = handler.createReply();
			uid(_input.read_long());
				break;
			}
			case 5: // _get_successeur
			{
			_out = handler.createReply();
			_out.write_string(successeur());
				break;
			}
			case 6: // _set_successeur
			{
			_out = handler.createReply();
			successeur(_input.read_string());
				break;
			}
		}
		return _out;
	}

	public String[] _all_interfaces(org.omg.PortableServer.POA poa, byte[] obj_id)
	{
		return ids;
	}
}
