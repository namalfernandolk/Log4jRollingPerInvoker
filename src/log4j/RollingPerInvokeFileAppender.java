package log4j;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author namal
 * 
 */

public class RollingPerInvokeFileAppender extends FileAppender {
	
	@Override
	public void append(LoggingEvent event) {
		
		String 		mDCString = (String) event.getMDC("ridelogid");
		
		modifyLogFileName(mDCString);
		
		super.append(event);
		
	}
	
	public void modifyLogFileName(String mDCString) {
		
		if (fileName != null) {
		
			try {
				
				final 	File 		logFile 			= new File(fileName);
				
				if(mDCString == null) throw new Exception("MDC value for key \"ridelogid\" is not found. Please check!");
				
				String[] 			fileProps 			= mDCString.split("\\|");
				
				String 				vendorId 			= null;
				String 				traceId 			= null;
				String 				flow 				= null;
				String 				type 				= null;
				
				try {				vendorId 			= fileProps[0];} catch (Exception e) {}
				try {				flow 				= fileProps[1];} catch (Exception e) {}
				try {				type 				= fileProps[2];} catch (Exception e) {}
				try {				traceId 			= fileProps[3];} catch (Exception e) {}
				
//				System.out.println("getNewLogFileName().vendorId : " + vendorId);
//				System.out.println("getNewLogFileName().flow : " + flow);
//				System.out.println("getNewLogFileName().type : " + type);
//				System.out.println("getNewLogFileName().traceId : " + traceId);
				
				String 				newfolderPath 		= logFile.getParent() + File.separator + vendorId + File.separator + flow;

				File 				file 				= new File(newfolderPath);			

				if(! file.isDirectory()) 	file.mkdirs(); 
				
				String		 		newfileName 		= newfolderPath + File.separator + mDCString.replaceAll("\\|", "-") + "_" + System.currentTimeMillis() + ".log";
				
				setFile(newfileName, fileAppend, bufferedIO, bufferSize);
			
			} catch (Exception e) {
				
				errorHandler.error("Error while modifying File Name", e,ErrorCode.FILE_OPEN_FAILURE);
			
			}
		
		}
	
	}

}