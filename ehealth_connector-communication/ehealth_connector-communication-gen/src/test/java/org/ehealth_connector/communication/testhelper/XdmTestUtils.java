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
package org.ehealth_connector.communication.testhelper;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.Confidentiality;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.communication.ConvenienceCommunication;
import org.ehealth_connector.communication.DocumentMetadata;
import org.ehealth_connector.communication.xd.xdm.XdmContents;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XdmTestUtils extends TestUtils {

	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	/** The SLF4J logger instance. */
	protected static Logger log = LoggerFactory.getLogger(XdmTestUtils.class);;

	public static String getTempFilePath() {
		String tmpPath = "";
		if (System.getProperty("java.io.tmpdir") != null) {
			tmpPath = System.getProperty("java.io.tmpdir");
		} else if (System.getenv("TMP") != null) {
			tmpPath = System.getenv("TMP");
		} else if (System.getenv("TEMP") != null) {
			tmpPath = System.getenv("TEMP");
		}
		// tmpPath += File.separator + aFileName;
		return tmpPath;
	}

	public XdmContents exportSamples(ConvenienceCommunication conCom, File targetFile,
			String sourceFile1, String sourceFile2) {
		conCom.clearDocuments();

		// Assemble files and create OutputStream
		final InputStream inputStream = getClass().getResourceAsStream(sourceFile1);
		final DocumentMetadata metaData = conCom.addDocument(DocumentDescriptor.CDA_R2,
				inputStream);
		setNistMetadata(metaData);

		final InputStream inputStream2 = getClass().getResourceAsStream(sourceFile2);
		final DocumentMetadata metaData2 = conCom.addDocument(DocumentDescriptor.PDF, inputStream2);
		setNistMetadata2(metaData2);

		FileOutputStream outputStream;
		XdmContents xdmContents = null;
		try {
			outputStream = new FileOutputStream(targetFile);

			// create and store zip. Close the OutputStream.
			xdmContents = conCom.createXdmContents(outputStream);
			outputStream.close();

			log.debug(dateFormat.format(new Date()) + ": done. Stored to: "
					+ targetFile.getCanonicalPath() + "\n");
		} catch (final FileNotFoundException e) {
			log.error("FileNotFound.", e);
		} catch (final IOException e) {
			log.error("IOException.", e);
		}
		return xdmContents;
	}

	public boolean importIntegrityCheck(String filepath, ConvenienceCommunication conCom) {
		// Extract the sample zip from the resources folder to the temp dir and
		// initialize as new file
		final String path = prepareFile(filepath);
		final File sourceFile = new File(path);

		// Deserialize XDM contents
		final XdmContents importContents = importSamples(conCom, sourceFile);
		assertNotNull(importContents);

		// Extract Docs from the first submissionSet
		final XDSDocument doc1 = importContents.getDocumentList().get(0);
		final XDSDocument doc2 = importContents.getDocumentList().get(1);
		final DocumentEntryType doc1Metadata = importContents
				.getXdmContentsAsOhtSubmitTransactionData()[0]
						.getDocumentEntry(doc1.getDocumentEntryUUID());
		final DocumentEntryType doc2Metadata = importContents
				.getXdmContentsAsOhtSubmitTransactionData()[0]
						.getDocumentEntry(doc2.getDocumentEntryUUID());

		// Calculate integrity values of the imported documents
		try {
			// Hash
			final String doc1Hash = DigestUtils.sha1Hex(doc1.getStream());
			final String doc2Hash = DigestUtils.sha1Hex(doc2.getStream());
			// Size
			final long doc1Size = IOUtils.toByteArray(doc1.getStream()).length;
			final long doc2Size = IOUtils.toByteArray(doc2.getStream()).length;

			// Compare Hash
			if (!doc1Hash.equals(doc1Metadata.getHash()))
				return false;
			if (!doc2Hash.equals(doc2Metadata.getHash()))
				return false;
			// Compare Size
			if (!Long.toString(doc1Size).equals(doc1Metadata.getSize()))
				return false;
			if (!Long.toString(doc2Size).equals(doc2Metadata.getSize()))
				return false;
		} catch (final IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public XdmContents importSamples(ConvenienceCommunication conCom, File targetFile) {
		conCom.clearDocuments();

		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(targetFile);
		} catch (final ZipException e) {
			log.error("ZipException.", e);
		} catch (final IOException e) {
			log.error("IOException.", e);
		}
		return conCom.getXdmContents(zipFile);
	}

	public boolean isEqualHash(InputStream is1, InputStream is2) {
		try {
			if (!DigestUtils.sha1Hex(is1).equals(DigestUtils.sha1Hex(is2)))
				return false;
			else
				return true;
		} catch (final IOException e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean isEqualSize(InputStream is1, InputStream is2) {

		try {
			if (IOUtils.toByteArray(is1).length != IOUtils.toByteArray(is2).length)
				return false;
			else
				return true;
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean isSamplesHashAndSizeEqual(XdmContents xdmContents, String sourceFile1,
			String sourceFile2) {
		InputStream cdaOriginalIs = getClass().getResourceAsStream(sourceFile1);
		InputStream pdfOriginalIs = getClass().getResourceAsStream(sourceFile2);

		// hash
		if (!isEqualHash(cdaOriginalIs, xdmContents.getDocumentList().get(0).getStream()))
			return false;
		if (!isEqualHash(pdfOriginalIs, xdmContents.getDocumentList().get(1).getStream()))
			return false;

		cdaOriginalIs = getClass().getResourceAsStream(sourceFile1);
		pdfOriginalIs = getClass().getResourceAsStream(sourceFile2);

		// size
		if (!isEqualSize(cdaOriginalIs, xdmContents.getDocumentList().get(0).getStream()))
			return false;
		if (!isEqualSize(pdfOriginalIs, xdmContents.getDocumentList().get(1).getStream()))
			return false;

		return true;
	}

	/**
	 * Creates the keystore as temporary file on the local filesystem OHT does
	 * not support keystores from within the JAR...
	 *
	 * @return Full path and file name of the temporary file containing the
	 *         keystore
	 */
	protected String prepareFile(String resourcePath) {
		final String filename = FilenameUtils.getName(resourcePath);
		String targetPath = null;
		try {
			targetPath = File.createTempFile(filename, "").getAbsolutePath();
			final InputStream input = getClass().getResourceAsStream(resourcePath);
			final OutputStream output = new FileOutputStream(targetPath);
			final byte[] buffer = new byte[2048];
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			input.close();
			output.close();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

		return targetPath;
	}

	protected void setNistMetadata(DocumentMetadata metaData) {
		metaData.setDestinationPatientId(
				new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000", "b8a9a9ad17b5429"));
		metaData.setSourcePatientId(new Identificator("1.2.3.4", "2342134localid"));
		metaData.setCodedLanguage(LanguageCode.FRENCH_CODE);
		metaData.setTypeCode(new Code("2.16.840.1.113883.6.1", "34817-7",
				"Otorhinolaryngology Evaluation and Management Note"));
		metaData.setFormatCode(
				new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:rad:TEXT", "urn:ihe:rad:TEXT"));

		metaData.setClassCode(new Code("1.3.6.1.4.1.21367.100.1", "DEMO-Procedure", "Procedure"));

		metaData.setHealthcareFacilityTypeCode(
				new Code("2.16.840.1.113883.5.11", "AMB", "Ambulance"));
		metaData.setPracticeSettingCode(
				new Code("2.16.840.1.113883.6.96", "408478003", "Critical Care Medicine"));
		metaData.addConfidentialityCode(Confidentiality.NORMAL);
	}

	protected void setNistMetadata2(DocumentMetadata metaData) {
		metaData.setDestinationPatientId(
				new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000", "b8a9a9ad17b5429"));
		metaData.setSourcePatientId(new Identificator("1.2.3.4", "2342134localid"));

		metaData.setCodedLanguage(LanguageCode.GERMAN_CODE);
		metaData.setTypeCode(
				new Code("2.16.840.1.113883.6.1", "34133-9", "Summarization of Episode Note"));
		metaData.setFormatCode(new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:iti:xds-sd:pdf:2008",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)"));

		metaData.setClassCode(new Code("1.3.6.1.4.1.21367.100.1", "DEMO-Consult", "Consultation"));

		metaData.setHealthcareFacilityTypeCode(
				new Code("2.16.840.1.113883.5.11", "AMB", "Ambulance"));
		metaData.setPracticeSettingCode(
				new Code("2.16.840.1.113883.6.96", "394802001", "General Medicine"));
		metaData.addConfidentialityCode(Confidentiality.NORMAL);
	}
}
