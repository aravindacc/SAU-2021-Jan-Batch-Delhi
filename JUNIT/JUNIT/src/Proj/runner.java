
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;




import org.junit.runner.JUnitCore;


import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


import java.net.MalformedURLException;
import org.junit.Test;

public class runner {
	private static Logger log= Logger.getLogger(runner.class);
   public static void main(String[] args) {
	  Layout layout=new PatternLayout("%p %d %C %M %n");
	  Appender app=new ConsoleAppender(layout);
     log.addAppender(app);
     //log info
     log.info(" info");
     //debug
     log.debug("debug");
     //fatal
	  log.fatal(" fatal");
      Result answer = JUnitCore.runClasses(tester.class);
      for (Failure failure : answer.getFailures()) {
         System.out.println(failure.toString());
      }
      //Output
      System.out.println(answer.wasSuccessful());
   }
}  