/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.valueset.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

/**
 * 
 */
public class VsUtils {

	/**
	 * Method to download as a string
	 * 
	 * @param url
	 *            the url to download form
	 * @return the string of the downloaded content
	 * @throws IOException
	 *             occures on errors during download
	 */
	public static String downloadAsString(URL url) throws IOException {
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("User-Agent", "Mozilla/5.0 Gecko/20100316 Firefox/3.6.2");
		InputStream is = connection.getInputStream();
		String downloadedString = IOUtils.toString(is, StandardCharsets.UTF_8);
		return downloadedString;
	}

	/**
	 * Method to download as a byte array
	 * 
	 * @param url
	 *            the url to download form
	 * @return the byte array of the downloaded content
	 * @throws IOException
	 *             occures on errors during download
	 */
	public static byte[] downloadAsByteArray(URL url) throws IOException {
		URLConnection connection = url.openConnection();
		connection.setRequestProperty("User-Agent",
				"Mozilla/5.0 Gecko/20100316 Firefox/3.6.2");
		InputStream is = connection.getInputStream();
		byte[] downloadedBytes = IOUtils.toByteArray(is, is.available());
		return downloadedBytes;
	}

}