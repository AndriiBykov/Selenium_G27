package actionsHW;

public class ExceptionInCatch {

	public static void main(String[] args) {
		
		try {
			throw new ArithmeticException("test");
			
		} catch (Exception e) {
			System.out.println("catch");
			throw e;
		}
	}

}
