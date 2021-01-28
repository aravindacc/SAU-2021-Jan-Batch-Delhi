package calcTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import CalclulatorCode.CalcService;
import CalclulatorCode.calculator;

public class CalcServiceTest {

	CalcService calcService;

	@Mock
	private calculator calculator;

	@BeforeEach
	public void setup() {
		System.out.println("BeforeEach CalcServiceTest setup executed");
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCalcAdd() {
		System.out.println("Test testCalcAdd executed");
		calcService = new CalcService(calculator);
		int real, expected = 23;
		when(calculator.add(11, 12)).thenReturn(expected);
		real = calcService.calcAdd(11, 12);
		assertEquals(expected, real);
	}
	
	@Test
	public void testCalcSub() {
		System.out.println("Test testCalcSub executed");
		calcService = new CalcService(calculator);
		int expected = 5;
		when(calculator.sub(10, 5)).thenReturn(expected);
		int real = calcService.calcSub(10, 5);
		assertEquals(expected, real);
	}
	
	@Test
	public void testCalcMul() {
		System.out.println("Test testCalcMul executed");
		calcService = new CalcService(calculator);
		int real, expected = 200;
		when(calculator.multiply(10, 20)).thenReturn(expected);
		real = calcService.calcMul(10, 20);
		assertEquals(expected, real);
	}
	
	@Test
	public void testCalcDiv() {
		System.out.println("Test testCalcDiv executed ");
		calcService = new CalcService(calculator);
		int real ,expected = 3;
		when(calculator.divide(15, 5)).thenReturn(expected);
		real = calcService.calcDiv(15, 5);
		assertEquals(expected, real);
	}
}
