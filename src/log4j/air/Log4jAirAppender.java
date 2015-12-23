package log4j.air;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jAirAppender {
	
	public static void logAirData(String data) {
		DOMConfigurator.configure("log4j.xml");
		logger.warn(" !!! logAirData(). : " + data);
	}
	
	private static Logger logger = Logger.getLogger(Log4jAirAppender.class);
	
}
