package oca.ch01;

public class Increment001 {
	
	static	boolean b;
	static	byte by;//8bit
	static	short s;//16bit
	static	int i;//32bit
	static	long l;//64bit
	static	char c;//16bit
	static	float f;
	static	double d;

	static	Boolean bobj;
	static	Byte byobj = by;
	static	Short sobj = s;
	static	Integer iobj = i;
	static	Long lobj = l;
	static	Character cobj = c;
	static	Float fobj = f;
	static	Double dobj = d;
	
	
	
	public static void main(String...args) {
//		b++;//NOT
		System.out.println(++by);
		System.out.println(++s);
		System.out.println(++i);
		System.out.println(++l);
		System.out.println(++c);
		System.out.println(++f);
		System.out.println(++d);

//		System.out.println(++bobj);//NOT
		System.out.println(++byobj);
		System.out.println(++sobj);
		System.out.println(++iobj);
		System.out.println(++lobj);
		System.out.println(++cobj);
		System.out.println(++fobj);
		System.out.println(++dobj);
	}

}
