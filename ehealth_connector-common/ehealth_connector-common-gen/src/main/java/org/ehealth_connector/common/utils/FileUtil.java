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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Random;

/**
 * File handling utilities
 *
 */
public class FileUtil {

	/**
	 * Returns a random File from within the given path
	 *
	 * @param path
	 *            The path where a random file will be selected
	 * @return A random File from within the given path
	 */
	public static File getRandomFileFromPath(String path) {
		File retVal = null;
		File dir = new File(path);
		File[] files = dir.listFiles();
		Random rand = new Random();
		retVal = files[rand.nextInt(files.length)];
		return retVal;
	}

	/**
	 * Saves the given String to the given File (plain text). The file will be
	 * overwritten by this method.
	 *
	 * @param outputString
	 *            This string will be saved into the given file
	 * @param outputFileName
	 *            The given string will be saved to this file
	 */
	public static void saveString2File(String outputString, String outputFileName) {
		Writer out = null;
		try {
			File outputFile = new File(outputFileName);
			outputFile.delete();
			out = new BufferedWriter(
					new OutputStreamWriter(new FileOutputStream(outputFileName), "UTF-8"));
			out.write(outputString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
			}
		}
	}
}
