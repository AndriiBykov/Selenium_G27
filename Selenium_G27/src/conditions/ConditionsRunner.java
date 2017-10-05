package conditions;

import oop.Child;

public class ConditionsRunner {

	public static void main(String[] args) {
		
		int a = 5;
		int b = 6;

		if (a == b) {
			System.out.println("true");
			
		} else if (a == 5) {
			System.out.println("false");
			
		} else if (b == 6) {
			System.out.println("false2");
			
		} else {
			
		}
		
		if (a == 4 && b == 6) {
			
			System.out.println("investigate symbol &&");
		}
		
		if (a == 4 || b == 6) {

			System.out.println("investigate symbol ||");
		}

	}

}
