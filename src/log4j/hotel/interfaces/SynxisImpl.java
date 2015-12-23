package log4j.hotel.interfaces;

import java.util.UUID;

import log4j.hotel.Log4jFileLogger;

public class SynxisImpl implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Log4jFileLogger.logData("<RESPONSE><SYNXIS_RS><RESPONSE>","synxis|Availabiity|Response|"+UUID.randomUUID());
		}
		
	}

}