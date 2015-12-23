package log4j.hotel.interfaces;

import java.util.UUID;

import log4j.hotel.Log4jFileLogger;

public class HotelbedsImpl implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Log4jFileLogger.logData("<RESPONSE><HotelBeds_RS><RESPONSE>","hotelbeds|Availabiity|Response|"+UUID.randomUUID());
		}
		
	}

}