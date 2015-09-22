package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * This class provides the possibility to zip files and create a new filecontainer
 *
 */
public class ZipCreator {
	
	private static Logger logService = Logger.getLogger(ZipCreator.class.getName());
	
	private ZipOutputStream out = null;
	private ByteArrayOutputStream bOS = null;
	
	/**
	 * Creates a new Object which provides the needed methods
	 */
	public ZipCreator(){
		logService.debug("creating zipfile");
		
		bOS = new ByteArrayOutputStream();
		out = new ZipOutputStream(bOS);
	}
	
	/**
	 * Adds a file as a ZipItem
	 * @param data
	 * 		Contains the file to compress as a bytearray
	 * @param pathInZipFile
	 * 		Contains the relative path only in that zip file
	 */
	public void addZipItem(byte[] data, String pathInZipFile){
		
		logService.info("Adding to Zip-file: " + pathInZipFile);
		
		try {
			if(data == null){
				out.putNextEntry(new ZipEntry(pathInZipFile));
				out.closeEntry();
			}
			else{
				out.putNextEntry(new ZipEntry(pathInZipFile));
				out.write(data);
				out.closeEntry();
			}
			
		} catch (IOException e) {
			logService.error("An Error occured while adding a ZipItem");
			e.printStackTrace();
		}
	}
	
	/**
	 * Closes the inputstream. It only has to be called when no more entries will be added.
	 */
	public void closeZip(){
		try {
			
			out.close();
			
		} catch (IOException e) {
			logService.error("ZipFile could not be closed");
			e.printStackTrace();
		}
	}
	
	/**
	 * Provides the compressed files
	 * @return the compressed files as bytearray 
	 */
	public byte[] getZippedFiles(){
		return bOS.toByteArray();
	}
}
