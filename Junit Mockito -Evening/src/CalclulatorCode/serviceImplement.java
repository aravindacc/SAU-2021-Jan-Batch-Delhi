package CalclulatorCode;
public class serviceImplement implements calculator {
	@Override
	public int add(int input1, int input2) {
		
		return input1 + input2;
	}

	@Override
	public int sub(int input1, int input2) {
		// TODO Auto-generated method stub
		return input1-input2;
	}

	@Override
	public int multiply(int input1, int input2) {
		// TODO Auto-generated method stub
		return input1 * input2;
	}

	@Override
	public int divide(int input1, int input2) {
		// TODO Auto-generated method stub
		return input1/input2;
	}
}