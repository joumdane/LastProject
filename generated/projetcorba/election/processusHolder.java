package projetcorba.election;

/**
 *	Generated from IDL interface "processus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class processusHolder	implements org.omg.CORBA.portable.Streamable{
	 public processus value;
	public processusHolder()
	{
	}
	public processusHolder (final processus initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return processusHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = processusHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		processusHelper.write (_out,value);
	}
}
