package hw;

public class LampsAndFrogs {
	
	private static boolean[] lampsState = new boolean[100];
	private static int [] frogNumbers;
	static {
		frogNumbers = new int[100];
		for (int i = 0; i < frogNumbers.length; i++) {
			frogNumbers[i] = i + 1;
		}
	}
	
	/**
	 * 
	 * @param expectedJumpingFrogsNumber - number of frogs that will jump
	 */
	public static void press(int expectedJumpingFrogsNumber) {
		
		for (int frogNumber : frogNumbers) {
			
			if(frogNumber > expectedJumpingFrogsNumber) {
				break;
			}
			
			if (frogNumber == 100) {

				if (lampsState[frogNumber - 1] == false) {
					lampsState[frogNumber - 1] = true;
				} else {
					lampsState[frogNumber - 1] = false;
				}
				
			} else {
				
				for(int i = frogNumber; i <= 100; i += frogNumber) {

					if (lampsState[i - 1] == false) {
						lampsState[i - 1] = true;
					} else {
						lampsState[i - 1] = false;
					}
				}
				
			}			
		}	
	}

	public static void main(String[] args) {
		
		press(3);
		
		for (int i = 0; i < lampsState.length; i++) {

			System.out.println((i+1) + " " + lampsState[i]);
		}
		
	}

}
