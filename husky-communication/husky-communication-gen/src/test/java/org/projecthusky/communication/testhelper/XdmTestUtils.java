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
package org.projecthusky.communication.testhelper;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.enums.ConfidentialityCode;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.xd.xdm.XdmContents;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.DocumentEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class XdmTestUtils extends XdsTestUtils {

	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	/** The SLF4J logger instance. */
	protected static Logger log = LoggerFactory.getLogger(XdmTestUtils.class);

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
		final Document doc1 = importContents.getDocumentList().get(0);
		final Document doc2 = importContents.getDocumentList().get(1);
		final DocumentEntry doc1Metadata = importContents.getXdmContentsAsIpfSubmitTransactionData().get(0)
				.getDocuments().stream()
				.filter(d -> d != null && d.getDocumentEntry() != null
						&& d.getDocumentEntry().getEntryUuid().equals(doc1.getDocumentEntry().getEntryUuid()))
				.collect(Collectors.toList()).get(0).getDocumentEntry();
		final DocumentEntry doc2Metadata = importContents.getXdmContentsAsIpfSubmitTransactionData().get(0)
				.getDocuments().stream()
				.filter(d -> d != null && d.getDocumentEntry() != null
						&& d.getDocumentEntry().getEntryUuid().equals(doc2.getDocumentEntry().getEntryUuid()))
				.collect(Collectors.toList()).get(0).getDocumentEntry();

		// Calculate integrity values of the imported documents
		try (var is = doc1.getDataHandler().getInputStream()) {
			byte[] doc1Bytes = IOUtils.toByteArray(is);
			// Hash
			final String doc1Hash = DigestUtils.sha1Hex(doc1Bytes);

			// Size
			final long doc1Size = doc1Bytes.length;

			// Compare Hash
			if (!doc1Hash.equals(doc1Metadata.getHash()))
				return false;
			// Compare Size
			if (doc1Size != doc1Metadata.getSize())
				return false;
		} catch (final IOException e) {
			e.printStackTrace();
			return false;
		}

		// Calculate integrity values of the imported documents
		try (var is = doc2.getDataHandler().getInputStream()) {
			byte[] doc2Bytes = IOUtils.toByteArray(is);
			// Hash
			final String doc2Hash = DigestUtils.sha1Hex(doc2Bytes);
			// Size
			final long doc2Size = doc2Bytes.length;

			// Compare Hash
			if (!doc2Hash.equals(doc2Metadata.getHash()))
				return false;
			// Compare Size
			if (doc2Size != doc2Metadata.getSize())
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
			String sourceFile2) throws IOException {
		InputStream cdaOriginalIs = getClass().getResourceAsStream(sourceFile1);
		InputStream pdfOriginalIs = getClass().getResourceAsStream(sourceFile2);

		// hash
		if (!isEqualHash(cdaOriginalIs, xdmContents.getDocumentList().get(0).getDataHandler().getInputStream()))
			return false;
		if (!isEqualHash(pdfOriginalIs, xdmContents.getDocumentList().get(1).getDataHandler().getInputStream()))
			return false;

		cdaOriginalIs = getClass().getResourceAsStream(sourceFile1);
		pdfOriginalIs = getClass().getResourceAsStream(sourceFile2);

		// size
		if (!isEqualSize(cdaOriginalIs, xdmContents.getDocumentList().get(0).getDataHandler().getInputStream()))
			return false;
		if (!isEqualSize(pdfOriginalIs, xdmContents.getDocumentList().get(1).getDataHandler().getInputStream()))
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
		metaData.addConfidentialityCode(ConfidentialityCode.NORMAL);
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
		metaData.addConfidentialityCode(ConfidentialityCode.NORMAL);
	}
}
