/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
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
	public void addZipItem(InputStream data, String pathInZipFile) throws IOException {

		logService.debug("Adding to Zip-file: " + pathInZipFile);

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
	}

	/**
	 * Closes the stream. It only has to be called when no more entries will be
	 * added.
	 */
	public void closeZip() throws IOException {
		out.close();
	}
}
