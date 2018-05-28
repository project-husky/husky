/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.cda.pdf;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.SystemUtils;
import org.ehealth_connector.cda.utils.Xml2Html;

/**
 *
 * @author Mathias Aschhoff ZTG 2016 m.aschhoff@ztg-nrw.de
 */
public class PdfCreator {

	/**
	 * This method converts a xml with xslt stylesheet to PDF As Params you have
	 * 3 Strings the CDA filepath, the stylesheet path and the filename for the
	 * output file.
	 *
	 * @param cda_file
	 *            CDA filepath
	 * @param stylesheet
	 *            XSLT filepath
	 * @param output_file
	 *            filename for outputfile
	 */
	public static void convertToPDF(String cda_file, String output_file) {
		try {

			// First, convert the XML to HTML like it was rendered on the screen
			StreamResult html = Xml2Html.convertXMLToHTML(new StreamSource(cda_file));
			// This is for debugging purposes, only:
			// FileUtils.write(new File("C:\\temp\\test.html"),
			// html.getWriter().toString(), "UTF-8");

			// TODO HTML TO PDF

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<String> getSystemFontsPaths() {
		List<String> result = new ArrayList<String>();
		if (SystemUtils.IS_OS_WINDOWS) {
			String path = System.getenv("WINDIR");
			result.add(path + "\\" + "Fonts");
			return result;
		} else if (SystemUtils.IS_OS_MAC_OSX || SystemUtils.IS_OS_MAC) {
			result.add(System.getProperty("user.home") + File.separator + "Library/Fonts");
			result.add("/Library/Fonts");
			result.add("/System/Library/Fonts");
			return result;
		} else if (SystemUtils.IS_OS_LINUX) {
			String[] pathsToCheck = { System.getProperty("user.home") + File.separator + ".fonts",
					"/usr/share/fonts/truetype", "/usr/share/fonts/TTF" };
			ArrayList<String> resultList = new ArrayList<>();

			for (int i = pathsToCheck.length - 1; i >= 0; i--) {
				String path = pathsToCheck[i];
				File tmp = new File(path);
				if (tmp.exists() && tmp.isDirectory() && tmp.canRead()) {
					resultList.add(path);
				}
			}
		}
		return result;
	}

}
