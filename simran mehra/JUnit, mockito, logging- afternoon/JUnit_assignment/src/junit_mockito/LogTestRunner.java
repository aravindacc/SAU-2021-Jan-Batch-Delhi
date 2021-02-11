package junit_mockito;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

public class LogTestRunner {

	private static final Logger logger=LogManager.getLogger(LogTestRunner.class);

	private static MathApplication mathApp= new MathApplication();
	
	private static void calc(double input1,double input2)
	{
		logger.info("Adding "+input1 + "and "+input2+"= " + mathApp.add(input1,input2) );
		logger.info("Subtracting "+input1 + "and "+input2+"= " + mathApp.subtract(input1,input2) );
		logger.info("Multiplying "+input1 + "and "+input2+"= " + mathApp.multiply(input1,input2) );
		try {
			logger.info("Dividing " + input1 + " and " + input2 + "= " + mathApp.divide(input1, input2));
		}catch (Exception e)
		{
			logger.error("Divide by Zero Exception  " + e);
		}
	}
	
	
	public static void main(String args[]){
		BasicConfigurator.configure();
		calc(27.0,0.0);
		
	}
}
