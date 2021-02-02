import org.apache.log4j.Logger;

public class Calculator {

    Logger logger = Logger.getLogger(Calculator.class);

    public int add(int a, int b) {
        logger.info("Adding " + a + " and " + b+" :]");
        return a + b;
    }

    public int subtract(int a, int b) {
        logger.info("Subtracting " + a + " from " + b +" :}");
        return a - b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            logger.fatal("Cannot divide by zero :(");
            throw new ArithmeticException("b cannot be 0");
        }
        logger.info("Dividing " + a + " by " + b + " :L");
        return a / b;
    }

    public int multiply(int a, int b) {
        logger.info("Multiplying " + a + " and " + b +" :)");
        return a * b;
    }
}
