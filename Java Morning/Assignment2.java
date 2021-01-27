
public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Assignment2 obj = new Assignment2();
		try {
			obj.exceptionExample();
		}catch(ArithmeticException e) {
			System.out.println(e);
		}
		
	}
	
	void exceptionExample()throws ArithmeticException {
		throw new ArithmeticException("ArithmeticException Encountered Using throw and throws");
	}

}
