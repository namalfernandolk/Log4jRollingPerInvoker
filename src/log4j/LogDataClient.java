package log4j;

import java.util.UUID;

import log4j.air.interfaces.AIR1;
import log4j.air.interfaces.AIR2;
import log4j.air.interfaces.AIR3;
import log4j.air.interfaces.AIR4;
import log4j.hotel.Log4jFileLogger;
import log4j.hotel.interfaces.DerbySoftImpl;
import log4j.hotel.interfaces.HBSIImpl;
import log4j.hotel.interfaces.HotelbedsImpl;
import log4j.hotel.interfaces.SynxisImpl;

public class LogDataClient {
	
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i++) {
			
			Thread air1thread 		= new Thread(new AIR1());
			Thread air2thread 		= new Thread(new AIR2());
			Thread air3thread 		= new Thread(new AIR3());
			Thread air4thread 		= new Thread(new AIR4());
			
			air1thread.start();
			air2thread.start();
			air3thread.start();
			air4thread.start();

		}
		
		for (int i = 0; i < 10; i++) {
			
			Thread dbthread 		= new Thread(new DerbySoftImpl());
			Thread hbthread 		= new Thread(new HotelbedsImpl());
			Thread hbsithread 		= new Thread(new HBSIImpl());
			Thread synxisthread 	= new Thread(new SynxisImpl());
				
			dbthread.start();
			hbthread.start();
			hbsithread.start();
			synxisthread.start();
		}

	}
	
}
