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

package org.husky.common.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * File handling utilities
 *
 */
public class FileUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileUtil.class.getName());
	
	private static Random rand;

	private FileUtil() {
		throw new IllegalStateException("This is a utility class!");
	}

	/**
	 * Returns a combined Path of path1 and path2.
	 *
	 * @param path1 the first part (head) of the combined path.
	 * @param path2 the second part (tail) of the combined path.
	 * @return the combined Path of path1 and path2.
	 * 
	 * @deprecated (at next version)
	 */
	@Deprecated(forRemoval = true) // Use File or Path
	public static String combinePath(String path1, String path2) {
		if (!(path1.endsWith("/") || path1.endsWith("\\")))
			return path1 + "/" + path2;
		else
			return path1 + path2;
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
		var outputFile = new File(outputFileName);
		try {
			Files.deleteIfExists(outputFile.toPath());
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		try (Writer out = new BufferedWriter(
				new OutputStreamWriter(new FileOutputStream(outputFileName), StandardCharsets.UTF_8))) {
			out.write(outputString);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
}
