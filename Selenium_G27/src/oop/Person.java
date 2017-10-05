package oop;

public class Person {

	private String name = "Andrey";
	private String Surname = "Bykov";
	private int age = 36;
	
	public void printPersonInfo() {
		
		System.out.println("My age is " + age + ", my name is " + name + " " + Surname);
	}
	
	public static void printSqrtOfBiggerNumber(int firstNumber, int secondNumber) {
		
		if (firstNumber < 0 && secondNumber < 0) {			
			System.out.println("Both numbers can't be less than zero.");
			
		} else if (firstNumber == secondNumber) {			
			System.out.println("Numbers are equal");
	
		} else {
			double biggerNumber = Math.max(firstNumber, secondNumber);
			System.out.println(Math.sqrt(biggerNumber));
		}
	}
}
