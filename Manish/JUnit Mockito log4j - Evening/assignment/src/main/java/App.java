import org.apache.log4j.BasicConfigurator;

public class App {
    public static void main(String[] args) {
        BasicConfigurator.configure();
        Calculator calculator = new Calculator();
        calculator.add(1, 2);
        calculator.subtract(2,1);
        calculator.multiply(2,2);
        calculator.divide(3,2);
    }
}
