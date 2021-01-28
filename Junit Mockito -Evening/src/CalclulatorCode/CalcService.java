package CalclulatorCode;

public class CalcService {
	
	private calculator calc;
	
	public CalcService(calculator calc) {
		this.calc = calc;
	}

	public int calcAdd(int input1, int input2) {
		return calc.addition(input1, input2);
	}
   
	public int calcSub(int input1, int input2) {
		return calc.subtraction(input1, input2);
	}
	
	public int calcMul(int input1, int input2) {
		return calc.multiplication(input1, input2);
	}
	
	public int calcDiv(int input1, int input2) {
		return calc.division(input1, input2);
	}
}