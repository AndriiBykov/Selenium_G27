package oop;

public class Parent {
	
	public Parent() {
		System.out.println("Parent constructor");
	}
	
    public Parent(int var) {
    	
		privateInt = var;
	}
	
	private int privateInt;	
	public int publicInt = 7;
	protected int protectedInt = 10;
	
	public static class Inner {
		
		private int privateInner = 70;
		
//		public void printOuterInt() {
//			System.out.println(privateInt);
//		}
	}
	
	public void printClassName() {
		
		System.out.println("Parent");
//		
//		test();
//		test(15, "C");
//		test("B", 1);
		
		//System.out.println(privateInner);
	}
	
	private void test() {
		
		System.out.println("private method 1");
	}
	
	private void test(int a, String b) {
		
		System.out.println("private method 2" + a + b);
	}
	
	private void test(String a, int b) {
		
		System.out.println("private method 3" + a + b);
	}
	
}
