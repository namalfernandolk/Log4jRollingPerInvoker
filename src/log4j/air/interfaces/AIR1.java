package log4j.air.interfaces;

import java.util.UUID;

import log4j.air.Log4jAirAppender;

public class AIR1 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Log4jAirAppender.logAirData("<RESPONSE><AIR1_RS-"+UUID.randomUUID()+"><RESPONSE>");
		}
		
	}
}
