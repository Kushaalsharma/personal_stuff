package javaBasic;

public class Tester {

	public static void main(String[] args) {
		A aobj = new A();
		System.out.println(aobj.x);
		aobj.function();
		A bobj = new B();
		System.out.println(bobj.x);
		bobj .function();
		System.out.println(((B)bobj).x);

	}
}
class A
	{
		int x =10;
		char y = 'a';
		
		void function ()
		{
			System.out.println("A class x"+x+" ,y : "+y);
		}
	}
	
	class B extends A
	{
		int x =20;
		char y = 'b';
		
		void function ()
		{
			System.out.println("B class x"+x+" ,y : "+y);
			System.out.println("super "+super.x);
		}
	}

