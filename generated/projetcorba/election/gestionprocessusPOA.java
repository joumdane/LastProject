package projetcorba.election;

/**
 *	Generated from IDL interface "gestionprocessus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */


public abstract class gestionprocessusPOA
	extends org.omg.PortableServer.Servant
	implements org.omg.CORBA.portable.InvokeHandler, projetcorba.election.gestionprocessusOperations
{
	static private final java.util.Hashtable m_opsHash = new java.util.Hashtable();
	static
	{
		m_opsHash.put ( "creation_processus", new java.lang.Integer(0));
		m_opsHash.put ( "_get_anneau_processus", new java.lang.Integer(1));
		m_opsHash.put ( "arreter_processus", new java.lang.Integer(2));
	}
	private String[] ids = {"IDL:projetcorba/election/gestionprocessus:1.0"};
	public projetcorba.election.gestionprocessus _this()
	{
		return projetcorba.election.gestionprocessusHelper.narrow(_this_object());
	}
	public projetcorba.election.gestionprocessus _this(org.omg.CORBA.ORB orb)
	{
		return projetcorba.election.gestionprocessusHelper.narrow(_this_object(orb));
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
			case 0: // creation_processus
			{
				int _arg0=_input.read_long();
				int _arg1=_input.read_long();
				projetcorba.election.processusHolder _arg2= new projetcorba.election.processusHolder();
				_arg2._read (_input);
				_out = handler.createReply();
				creation_processus(_arg0,_arg1,_arg2);
				projetcorba.election.processusHelper.write(_out,_arg2.value);
				break;
			}
			case 1: // _get_anneau_processus
			{
			_out = handler.createReply();
			projetcorba.election.anneauHelper.write(_out,anneau_processus());
				break;
			}
			case 2: // arreter_processus
			{
				int _arg0=_input.read_long();
				_out = handler.createReply();
				arreter_processus(_arg0);
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
