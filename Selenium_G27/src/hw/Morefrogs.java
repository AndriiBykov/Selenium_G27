package hw;

import java.util.Arrays;

public class Morefrogs {
	
boolean lamps [];
	
	
	public void press(int frogNumber){
		
		for (int i=frogNumber; i<100; i=i+frogNumber+1){
			if (lamps[i]){
				lamps [i] = false;
			} else {
				lamps [i] = true;
			}
				
		}
	}
		public static void main(String[] args) {
			
			Morefrogs b = new Morefrogs();
			b.lamps = new boolean [100];
			for (int i=0; i<100; i++) {
				b.lamps [i] = false;
			}
			
			 System.out.println("Before Frog Jumping:" + Arrays.toString(b.lamps));
			
			 //Frog Jumping
			 b.press(0);
			 System.out.println("After Frog Jumping:" + Arrays.toString(b.lamps));
			
		}

}
