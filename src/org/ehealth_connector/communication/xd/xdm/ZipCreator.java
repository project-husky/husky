package org.ehealth_connector.communication.xd.xdm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.Logger;

/**
 * This class provides the functions to create zip files
 *
 */
public class ZipCreator {

	private static Logger logService = Logger.getLogger(ZipCreator.class.getName());
	byte[] buffer = new byte[1024];

	private ZipOutputStream out = null;

	/**
	 * Creates a new Object which provides the needed methods
	 */
	public ZipCreator(OutputStream outputStream) {
		logService.debug("creating zipfile");

		out = new ZipOutputStream(outputStream);
	}

	/**
	 * Adds an InputStream as ZipEntry to the ZipFile
	 * 
	 * @param data
	 *            Contains the file to compress as a bytearray
	 * @param pathInZipFile
	 *            Contains the relative path only in that zip file
	 */
	public void addZipItem(InputStream data, String pathInZipFile) {

		logService.debug("Adding to Zip-file: " + pathInZipFile);

		try {
			if (data == null) {
				out.putNextEntry(new ZipEntry(pathInZipFile));
				out.closeEntry();
			} else {
				out.putNextEntry(new ZipEntry(pathInZipFile));

				int length;
				while ((length = data.read(buffer)) > 0) {
					out.write(buffer, 0, length);
				}

				out.closeEntry();
			}

		} catch (IOException e) {
			logService.error("An Error occured while adding the ZipItem");
			e.printStackTrace();
		}
	}

	/**
	 * Closes the stream. It only has to be called when no more entries will be
	 * added.
	 */
	public void closeZip() {
		try {
			out.close();

		} catch (IOException e) {
			logService.error("ZipFile could not be closed");
			e.printStackTrace();
		}
	}
}
