package com.hemantMathServiceTest.au.Logging;

import com.hemantMathsService.au.service.MathsOperationsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingTester {
    private static final Logger LOGGER = LogManager.getLogger(MathsOperationsService.class);
    public static void main(String args[]){
        LOGGER.info("Info Message");
        LOGGER.debug("Debug Message");
        LOGGER.warn("Warning Message");
        LOGGER.fatal("Fatal Message");
    }
}
