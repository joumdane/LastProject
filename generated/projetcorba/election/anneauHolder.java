package projetcorba.election;

/**
 *	Generated from IDL definition of alias "anneau"
 *	@author JacORB IDL compiler 
 */

public final class anneauHolder
	implements org.omg.CORBA.portable.Streamable
{
	public projetcorba.election.processus[] value;

	public anneauHolder ()
	{
	}
	public anneauHolder (final projetcorba.election.processus[] initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type ()
	{
		return anneauHelper.type ();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = anneauHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream out)
	{
		anneauHelper.write (out,value);
	}
}
