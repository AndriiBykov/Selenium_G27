package oop;

public class Child extends Parent {
	
	public Child() {
		super();
		System.out.println("Child constructor");
		
	}

	
	public Child(int var) {
		super(var);
		
	}

	@Override
	public void printClassName() {
		
		System.out.println("Child");
		System.out.println(protectedInt);
	}
}
