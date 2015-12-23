package log4j.hotel.interfaces;

import java.util.UUID;

import log4j.hotel.Log4jFileLogger;

public class DerbySoftImpl implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Log4jFileLogger.logData("<RESPONSE><DERBY_RS><RESPONSE>","derbysoft|Availabiity|Response|"+UUID.randomUUID());
		}
		
	}

}
