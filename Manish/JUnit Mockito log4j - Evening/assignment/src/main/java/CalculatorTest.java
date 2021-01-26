import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CalculatorTest {

    // mocking calculator  service
    CalculatorService calculatorService = Mockito.mock(CalculatorService.class);

    // actual object to test
    Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        Mockito.when(calculatorService.add(5, 5)).thenReturn(10);
        int actual = calculatorService.add(5, 5);
        Assert.assertEquals(calculator.add(5, 5), actual);
    }

    @Test
    public void testSubtract() {
        Mockito.when(calculatorService.subtract(5, 5)).thenReturn(0);
        int actual = calculatorService.subtract(5, 5);
        Assert.assertEquals(calculator.subtract(5, 5), actual);
    }

    @Test
    public void testMultiply() {
        Mockito.when(calculatorService.multiply(5, 5)).thenReturn(25);
        int actual = calculatorService.multiply(5, 5);
        Assert.assertEquals(calculator.multiply(5, 5), actual);
    }

    @Test
    public void testDivide() {
        Mockito.when(calculatorService.divide(5, 5)).thenReturn(1);
        int actual = calculatorService.divide(5, 5);
        Assert.assertEquals(calculator.divide(5, 5), actual);
    }

}
