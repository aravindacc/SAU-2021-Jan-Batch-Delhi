package Niket;

import java.util.logging.Logger;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.net.MalformedURLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
public class runner {
    private static Logger log= Logger.getLogger(runner.class);
    public static void main(String[] args) {
        Layout layout=new PatternLayout("%p %d %C %M %n");
        Appender app=new ConsoleAppender(layout);
        log.addAppender(app);
        log.info("from info");
        log.debug("from debug");
        log.fatal("from fatal");
        Result result = JUnitCore.runClasses(tester.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}