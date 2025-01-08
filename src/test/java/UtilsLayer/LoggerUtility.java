package UtilsLayer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtility {
	private static final Logger logger = LogManager.getLogger(LoggerUtility.class); // Log4j Logger

	// This method is for logging any information you want to log
	public static void logProperty(String propertyName, String propertyValue) {
		logger.info("Property: " + propertyName + " | Value: " + propertyValue);
	}

	// If you need to log messages in other classes, simply call the logProperty
	// method
	public static void logInfo(String message) {
		logger.info(message);
	}

	public static void logError(String message) {
		logger.error(message);
	}
}
