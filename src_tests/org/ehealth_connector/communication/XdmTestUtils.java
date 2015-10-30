package org.ehealth_connector.communication;

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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.enums.Confidentiality;
import org.ehealth_connector.cda.tests.TestUtils;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.communication.xd.xdm.XdmContents;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;

public class XdmTestUtils extends TestUtils {

	private static final Log log = LogFactory.getLog(XdmTestUtils.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");;

	public XdmContents exportSamples(ConvenienceCommunication conCom, File targetFile,
			String sourceFile1, String sourceFile2) {
		conCom.clearDocuments();

		// Assemble files and create OutputStream
		InputStream inputStream = getClass().getResourceAsStream(sourceFile1);
		DocumentMetadata metaData = conCom.addDocument(DocumentDescriptor.CDA_R2, inputStream);
		setNistMetadata(metaData);

		InputStream inputStream2 = getClass().getResourceAsStream(sourceFile2);
		DocumentMetadata metaData2 = conCom.addDocument(DocumentDescriptor.PDF, inputStream2);
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
		} catch (FileNotFoundException e) {
			log.error("FileNotFound.", e);
		} catch (IOException e) {
			log.error("IOException.", e);
		}
		return xdmContents;
	}

	public boolean importIntegrityCheck(String filepath, ConvenienceCommunication conCom) {
		// Extract the sample zip from the resources folder to the temp dir and
		// initialize as new file
		String path = prepareFile(filepath);
		File sourceFile = new File(path);

		// Deserialize XDM contents
		XdmContents importContents = importSamples(conCom, sourceFile);
		assertNotNull(importContents);

		// Extract Docs from the first submissionSet
		XDSDocument doc1 = importContents.getDocumentList().get(0);
		XDSDocument doc2 = importContents.getDocumentList().get(1);
		DocumentEntryType doc1Metadata = importContents.getXdmContentsAsOhtSubmitTransactionData()[0]
				.getDocumentEntry(doc1.getDocumentEntryUUID());
		DocumentEntryType doc2Metadata = importContents.getXdmContentsAsOhtSubmitTransactionData()[0]
				.getDocumentEntry(doc2.getDocumentEntryUUID());

		// Calculate integrity values of the imported documents
		try {
			// Hash
			String doc1Hash = DigestUtils.sha1Hex(doc1.getStream());
			String doc2Hash = DigestUtils.sha1Hex(doc2.getStream());
			// Size
			long doc1Size = IOUtils.toByteArray(doc1.getStream()).length;
			long doc2Size = IOUtils.toByteArray(doc2.getStream()).length;

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
		} catch (IOException e) {
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
		} catch (ZipException e) {
			log.error("ZipException.", e);
		} catch (IOException e) {
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
		} catch (IOException e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean isEqualSize(InputStream is1, InputStream is2) {

		try {
			log.debug(IOUtils.toByteArray(is1).length);
			log.debug(IOUtils.toByteArray(is2).length);
			if (IOUtils.toByteArray(is1).length != IOUtils.toByteArray(is2).length)
				return false;
			else
				return true;
		} catch (IOException e) {
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
		String filename = FilenameUtils.getName(resourcePath);
		String targetPath = null;
		try {
			targetPath = File.createTempFile(filename, "").getAbsolutePath();
			InputStream input = getClass().getResourceAsStream(resourcePath);
			OutputStream output = new FileOutputStream(targetPath);
			byte[] buffer = new byte[2048];
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			input.close();
			output.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		return targetPath;
	}

	protected void setNistMetadata(DocumentMetadata metaData) {
		metaData.setDestinationPatientId(new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000",
				"b8a9a9ad17b5429"));
		metaData.setSourcePatientId(new Identificator("1.2.3.4", "2342134localid"));
		metaData.setCodedLanguage(LanguageCode.FRENCH_CODE);
		metaData.setTypeCode(new Code("2.16.840.1.113883.6.1", "34817-7",
				"Otorhinolaryngology Evaluation and Management Note"));
		metaData.setFormatCode(new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:rad:TEXT",
				"urn:ihe:rad:TEXT"));

		metaData.setClassCode(new Code("1.3.6.1.4.1.21367.100.1", "DEMO-Procedure", "Procedure"));

		metaData.setHealthcareFacilityTypeCode(new Code("2.16.840.1.113883.5.11", "AMB",
				"Ambulance"));
		metaData.setPracticeSettingCode(new Code("2.16.840.1.113883.6.96", "408478003",
				"Critical Care Medicine"));
		metaData.addConfidentialityCode(Confidentiality.NORMAL);
	}

	protected void setNistMetadata2(DocumentMetadata metaData) {
		metaData.setDestinationPatientId(new Identificator("1.3.6.1.4.1.21367.2005.13.20.3000",
				"b8a9a9ad17b5429"));
		metaData.setSourcePatientId(new Identificator("1.2.3.4", "2342134localid"));

		metaData.setCodedLanguage(LanguageCode.GERMAN_CODE);
		metaData.setTypeCode(new Code("2.16.840.1.113883.6.1", "34133-9",
				"Summarization of Episode Note"));
		metaData.setFormatCode(new Code("1.3.6.1.4.1.19376.1.2.3", "urn:ihe:iti:xds-sd:pdf:2008",
				"1.3.6.1.4.1.19376.1.2.20 (Scanned Document)"));

		metaData.setClassCode(new Code("1.3.6.1.4.1.21367.100.1", "DEMO-Consult", "Consultation"));

		metaData.setHealthcareFacilityTypeCode(new Code("2.16.840.1.113883.5.11", "AMB",
				"Ambulance"));
		metaData.setPracticeSettingCode(new Code("2.16.840.1.113883.6.96", "394802001",
				"General Medicine"));
		metaData.addConfidentialityCode(Confidentiality.NORMAL);
	}
}
