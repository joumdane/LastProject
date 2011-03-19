package projetcorba.election;


/**
 *	Generated from IDL interface "processus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class processusHelper
{
	public static void insert (final org.omg.CORBA.Any any, final projetcorba.election.processus s)
	{
			any.insert_Object(s);
	}
	public static projetcorba.election.processus extract(final org.omg.CORBA.Any any)
	{
		return narrow(any.extract_Object()) ;
	}
	public static org.omg.CORBA.TypeCode type()
	{
		return org.omg.CORBA.ORB.init().create_interface_tc("IDL:projetcorba/election/processus:1.0", "processus");
	}
	public static String id()
	{
		return "IDL:projetcorba/election/processus:1.0";
	}
	public static processus read(final org.omg.CORBA.portable.InputStream in)
	{
		return narrow(in.read_Object());
	}
	public static void write(final org.omg.CORBA.portable.OutputStream _out, final projetcorba.election.processus s)
	{
		_out.write_Object(s);
	}
	public static projetcorba.election.processus narrow(final java.lang.Object obj)
	{
		if (obj instanceof projetcorba.election.processus)
		{
			return (projetcorba.election.processus)obj;
		}
		else if (obj instanceof org.omg.CORBA.Object)
		{
			return narrow((org.omg.CORBA.Object)obj);
		}
		throw new org.omg.CORBA.BAD_PARAM("Failed to narrow in helper");
	}
	public static projetcorba.election.processus narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (projetcorba.election.processus)obj;
		}
		catch (ClassCastException c)
		{
			if (obj._is_a("IDL:projetcorba/election/processus:1.0"))
			{
				projetcorba.election._processusStub stub;
				stub = new projetcorba.election._processusStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
			}
		}
		throw new org.omg.CORBA.BAD_PARAM("Narrow failed");
	}
	public static projetcorba.election.processus unchecked_narrow(final org.omg.CORBA.Object obj)
	{
		if (obj == null)
			return null;
		try
		{
			return (projetcorba.election.processus)obj;
		}
		catch (ClassCastException c)
		{
				projetcorba.election._processusStub stub;
				stub = new projetcorba.election._processusStub();
				stub._set_delegate(((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate());
				return stub;
		}
	}
}
