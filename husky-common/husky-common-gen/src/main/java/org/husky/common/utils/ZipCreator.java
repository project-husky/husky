/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.husky.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class provides the functions to create zip files
 *
 */
public class ZipCreator {

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

	private final byte[] buffer = new byte[1024];
	private ZipOutputStream out = null;

	/**
	 * Creates a new Object which provides the needed methods
	 *
	 * @param outputStream
	 *            the outputStream, which is used to write the contents to
	 */
	public ZipCreator(OutputStream outputStream) {
		out = new ZipOutputStream(outputStream);
	}

	/**
	 * Creates a new Object which provides the needed methods
	 *
	 * @param filePath
	 *            the path to the file, which is used to write the contents to
	 */
	public ZipCreator(String filePath) {
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(filePath));
			out = new ZipOutputStream(outputStream);
		} catch (final FileNotFoundException e) {
			log.error("Failed to create target file for zip outputstream.", e);
		}
	}

	/**
	 * Adds an InputStream as ZipEntry to the ZipFile
	 *
	 * @param data
	 *            Contains the file to compress as InputStream
	 * @param pathInZipFile
	 *            Contains the relative path only in that zip file
	 * @throws IOException
	 *             if the file could not be read
	 */
	public void addZipItem(InputStream data, String pathInZipFile) throws IOException {

		log.debug("Adding to Zip-file: {}", pathInZipFile);

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
	 * Adds a directory as ZipEntry to the ZipFile
	 *
	 * @param pathInZipFile
	 *            Contains the relative path only in that zip file
	 * @throws IOException
	 *             if the file could not be read
	 */
	public void addZipItem(String pathInZipFile) throws IOException {
		out.putNextEntry(new ZipEntry(pathInZipFile));
		out.closeEntry();
	}

	/**
	 * Adds an InputStream as ZipEntry to the ZipFile
	 *
	 * @param filePath
	 *            Contains the path to the file to add as zip item
	 * @param pathInZipFile
	 *            Contains the relative path only in that zip file
	 * @throws IOException
	 *             if the file could not be read
	 */
	public void addZipItem(String filePath, String pathInZipFile) throws IOException {
		final InputStream inputStream = new FileInputStream(filePath);
		this.addZipItem(inputStream, pathInZipFile);
	}

	/**
	 * Closes the stream. It only has to be called when no more entries will be
	 * added.
	 *
	 * @throws IOException
	 *             if the file could not be read
	 */
	public void closeZip() throws IOException {
		out.close();
	}
}
