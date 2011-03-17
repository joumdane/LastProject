package projetcorba.election;

/**
 *	Generated from IDL definition of alias "anneau"
 *	@author JacORB IDL compiler 
 */

public final class anneauHelper
{
	private static org.omg.CORBA.TypeCode _type = null;

	public static void insert (org.omg.CORBA.Any any, projetcorba.election.processus[] s)
	{
		any.type (type ());
		write (any.create_output_stream (), s);
	}

	public static projetcorba.election.processus[] extract (final org.omg.CORBA.Any any)
	{
		return read (any.create_input_stream ());
	}

	public static org.omg.CORBA.TypeCode type ()
	{
		if (_type == null)
		{
			_type = org.omg.CORBA.ORB.init().create_alias_tc(projetcorba.election.anneauHelper.id(), "anneau",org.omg.CORBA.ORB.init().create_sequence_tc(0, org.omg.CORBA.ORB.init().create_interface_tc("IDL:projetcorba/election/processus:1.0", "processus")));
		}
		return _type;
	}

	public static String id()
	{
		return "IDL:projetcorba/election/anneau:1.0";
	}
	public static projetcorba.election.processus[] read (final org.omg.CORBA.portable.InputStream _in)
	{
		projetcorba.election.processus[] _result;
		int _l_result0 = _in.read_long();
		_result = new projetcorba.election.processus[_l_result0];
		for (int i=0;i<_result.length;i++)
		{
			_result[i]=projetcorba.election.processusHelper.read(_in);
		}

		return _result;
	}

	public static void write (final org.omg.CORBA.portable.OutputStream _out, projetcorba.election.processus[] _s)
	{
		
		_out.write_long(_s.length);
		for (int i=0; i<_s.length;i++)
		{
			projetcorba.election.processusHelper.write(_out,_s[i]);
		}

	}
}
