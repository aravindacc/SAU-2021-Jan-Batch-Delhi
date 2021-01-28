package CalclulatorCode;
import java.util.logging.LogManager;
import java.util.logging.Logger;
public class logging {
	
	private static final Logger logger=LogManager.getLogger(Logger.class);

	private static serviceImplement si= new serviceImplement();
	
	private static void calc(int input1,int input2)
	{
		logger.info("Addition of "+input1 + " and "+input2+" is " + si.add(input1,input2) );

		logger.info("subtraction of "+input1 + " and "+input2+" is " + si.sub(input1,input2) );

		logger.info("Multiplication of "+input1 + " and "+input2+" is " + si.multiply(input1,input2) );

		try {
			logger.info("Division of " + input1+ " and " + input2 + " is " + si.divide(input1,input2));
		}
		catch (Exception e)
		{
			((Object) logger).error("Exception  " + e);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicConfigurator.configure();
		calc(30,40);
	}
	}