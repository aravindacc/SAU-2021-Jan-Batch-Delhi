package junit_mockito;

import static org.mockito.Mockito.lenient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

	@InjectMocks
	MathApplication mathApplication= new MathApplication();
	
	@Mock
	CalculatorService calcService;
	
	@Test
	public void testAdd() {
		lenient().when(calcService.add(27.0, 3.0)).thenReturn(30.0);
	    Assert.assertEquals(mathApplication.add(27.0, 3.0),30.0,0);
	}
	   
	@Test
	public void testSubstract(){
		lenient().when(calcService.subtract(27.0, 3.0)).thenReturn(24.0);
		Assert.assertEquals(mathApplication.subtract(27.0, 3.0),24.0,0);
	}
	@Test
	public void testMultiply(){
		lenient().when(calcService.multiply(27.0, 3.0)).thenReturn(81.0);
		Assert.assertEquals(mathApplication.multiply(27.0, 3.0),81.0,0);
	}
	
	@Test
	public void testDivide(){
		lenient().when(calcService.divide(27.0, 3.0)).thenReturn(9.0);
		Assert.assertEquals(mathApplication.divide(27.0, 3.0),9.0,0);
	}
}
