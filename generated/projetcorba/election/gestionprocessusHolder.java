package projetcorba.election;

/**
 *	Generated from IDL interface "gestionprocessus"
 *	@author JacORB IDL compiler V 2.2.2, 1-Jun-2005
 */

public final class gestionprocessusHolder	implements org.omg.CORBA.portable.Streamable{
	 public gestionprocessus value;
	public gestionprocessusHolder()
	{
	}
	public gestionprocessusHolder (final gestionprocessus initial)
	{
		value = initial;
	}
	public org.omg.CORBA.TypeCode _type()
	{
		return gestionprocessusHelper.type();
	}
	public void _read (final org.omg.CORBA.portable.InputStream in)
	{
		value = gestionprocessusHelper.read (in);
	}
	public void _write (final org.omg.CORBA.portable.OutputStream _out)
	{
		gestionprocessusHelper.write (_out,value);
	}
}
