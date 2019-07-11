package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager.Log4jMarker;

public class Log4jDemo {

	public static void main(String[] args) {

		Logger logger = LogManager.getLogger(Log4jDemo.class);

		System.out.println("\n  Hellow World....!  \n");

		logger.trace("This is a trace message");
		logger.info("This is a Information message");
		logger.error("This is a error message");
		logger.warn("This is an Warrning message");
		logger.fatal("This is an fatal message");

		System.out.println("\n completed ");


	}

}
