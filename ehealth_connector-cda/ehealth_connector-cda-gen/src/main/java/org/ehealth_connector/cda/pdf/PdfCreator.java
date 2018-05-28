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

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang3.SystemUtils;
import org.ehealth_connector.cda.utils.Xml2Html;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfAConformanceLevel;
import com.itextpdf.kernel.pdf.PdfDocumentInfo;
import com.itextpdf.kernel.pdf.PdfOutputIntent;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfViewerPreferences;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.WriterProperties;
import com.itextpdf.layout.font.FontProvider;
import com.itextpdf.pdfa.PdfADocument;

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

			FileOutputStream outputStream = new FileOutputStream(output_file);

			WriterProperties writerProperties = new WriterProperties();
			// Add metadata
			writerProperties.addXmpMetadata();

			PdfWriter pdfWriter = new PdfWriter(outputStream, writerProperties);
			PdfADocument pdfDoc = new PdfADocument(pdfWriter, PdfAConformanceLevel.PDF_A_1A,
					new PdfOutputIntent("Custom", "", "http://www.color.org", "sRGB IEC61966-2.1",
							PdfCreator.class.getClassLoader()
									.getResourceAsStream("sRGB_CS_profile.icm")));
			// TODO grab this from the input file
			pdfDoc.getCatalog().setLang(new PdfString("en-US"));
			// Set the document to be tagged
			pdfDoc.setTagged();
			pdfDoc.getCatalog()
					.setViewerPreferences(new PdfViewerPreferences().setDisplayDocTitle(true));

			// Set meta tags
			PdfDocumentInfo pdfMetaData = pdfDoc.getDocumentInfo();

			// TODO grab this from the input file
			pdfMetaData.setAuthor("eHealth Connector");
			// TODO grab this from the input file
			pdfMetaData.addCreationDate();
			pdfMetaData.getProducer();
			pdfMetaData.setCreator("iText Software");
			pdfMetaData.setKeywords("cda, document");
			pdfMetaData.setSubject("PDF representation of a CDA document");
			// Title is derived from html

			// pdf conversion
			ConverterProperties props = new ConverterProperties();
			// TODO grab this from the input file
			props.setBaseUri("C:\\xsl");
			FontProvider fp = new FontProvider();
			fp.addStandardPdfFonts();
			// TODO implement other OS fonts dir

			for (String fPath : getSystemFontsPaths()) {
				fp.addDirectory(fPath);
			}
			props.setFontProvider(fp);

			HtmlConverter.convertToPdf(
					new ByteArrayInputStream(
							html.getWriter().toString().getBytes(StandardCharsets.UTF_8)),
					pdfDoc, props);
			pdfDoc.close();
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

	//
	// private static String createPath(String cda_file) {
	// File pathfile = new File(cda_file);
	// String path = pathfile.getParentFile().getAbsolutePath();
	// path = "file:///" + path;
	// path = path.replace("\\", "/");
	// path = path + "/";
	//
	// return path;
	// }
	//
}
