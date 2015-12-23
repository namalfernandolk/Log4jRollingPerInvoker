package log4j.hotel;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import org.apache.log4j.xml.DOMConfigurator;

public class Log4jFileLogger {
	
	public static synchronized void logData(String data, String mDCStr) {
		
		MDC.put("ridelogid", mDCStr);
		
		DOMConfigurator.configure("log4j.xml");
		logger.info(data);
		
		MDC.remove("ridelogid");
	}
	
	private static Logger logger = Logger.getLogger(Log4jFileLogger.class);
}
