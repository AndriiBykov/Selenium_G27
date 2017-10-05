package loopsAndArrays;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Loops {

	public static void main(String[] args) {
		
		boolean condition = true;
		int counter = 0;
		
//		// While
//		while (condition) {
//			
//			if (counter + 1 == 3) {
//				counter++;
//				continue;
//			}
//			System.out.println(counter + 1);
//			counter++;
//			if (counter == 5) {
//				break;
//			}
//		}
		
		condition = false;

		// Do-While
		do {
			System.out.println("Do-While");

		} while (condition);

		int array [] = {4, 35, 67, 1};
		
		// For
//		for (int i = 0; i < array.length; i++) {
//
//			array[i] *= 2;
//		}
		
		for (int item : array) {
			
			item *= 2;
		}
		
		for (int i = 0; i < array.length; i++) {

			System.out.println(array[i]);
		}

	}

}
