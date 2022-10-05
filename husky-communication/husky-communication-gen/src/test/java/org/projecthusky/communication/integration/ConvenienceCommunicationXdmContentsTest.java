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
package org.projecthusky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.projecthusky.common.communication.DocumentMetadata;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.common.enums.DocumentDescriptor;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.communication.ConvenienceCommunication;
import org.projecthusky.communication.testhelper.TestApplication;
import org.projecthusky.communication.testhelper.XdmTestUtils;
import org.projecthusky.communication.xd.xdm.XdmContents;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * The purpose of this test class is to check whether the import and export of
 * documents via standard storage media such as a USB stick (XDM ITI-32) works.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
class ConvenienceCommunicationXdmContentsTest extends XdmTestUtils {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(ConvenienceCommunicationXdmContentsTest.class.getName());
	public static final String XDM_FILE_PATH = "/docConsumer/xdm.zip";
	public static final String XDM_CORRUPT_FILE_PATH = "/docConsumer/xdmCorrupt.zip";
	public static final String PDF_FILE_PATH = "/docConsumer/patientconsent.pdf";
	public static final String CDA_FILE_PATH = "/docConsumer/CDA-CH-VACD_Impfausweis.xml";
	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	@Autowired
	private ConvenienceCommunication convenienceCommunication;

	private String filePath = getTempFilePath();

	/**
	 * This method checks if initialization of {@link ConvenienceCommunication} was
	 * correct.
	 */
	@Test
	void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#createXdmContents(SubmissionSetMetadata, java.io.OutputStream)}
	 * when two documents (CDA and PDF) are exported to a ZIP file
	 * 
	 * @throws Exception
	 */
	@Test
	void createXdmContentsTest() throws Exception {
		// add two files for the XDM Zip
		// add CDA document with metadata
		DocumentMetadata metaData = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda(),
				getDocCda());
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metaData, patientId);

		// add PDF document with metadata
		metaData = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		setMetadataForPdf(metaData, patientId);

		// create metadata for the submission set
		SubmissionSetMetadata subSet = new SubmissionSetMetadata();
		setSubmissionMetadata(subSet, patientId);

		// create a FileOutputStream to store the zip file
		final File targetFile = new File("src/test/resources/xdmTest_Java.zip");
		try (final FileOutputStream outputStream = new FileOutputStream(targetFile)) {
			// create and store zip.
			convenienceCommunication.createXdmContents(subSet, outputStream);
		}

		checkZipContent(targetFile);
	}

	/**
	 * This method checks the content of passed ZIP file.
	 * 
	 * @param targetFile ZIP file to check
	 * 
	 * @throws Exception
	 */
	private void checkZipContent(File targetFile) throws Exception {

		String readmeFile = null;
		String indexHtmFile = null;
		Path iheXdmFolder = null;
		File targetUnzip = new File("src/test/resources/xdmTest_Java");

		// iterate each entry of the zip file and check if README.TXT, INDEX.HTM and
		// subdirectory for XDM contents exists
		try (ZipFile zipFile = new ZipFile(targetFile)) {
			Iterator<? extends ZipEntry> entryIt = zipFile.entries().asIterator();

			while (entryIt.hasNext()) {
				ZipEntry zipEntry = entryIt.next();

				Path resolvedPath = targetUnzip.toPath().resolve(zipEntry.getName()).normalize();
				try (InputStream is = zipFile.getInputStream(zipEntry)) {
					if ("README.TXT".equals(zipEntry.getName())) {
						readmeFile = new String(is.readAllBytes());
					} else if ("INDEX.HTM".equals(zipEntry.getName())) {
						indexHtmFile = new String(is.readAllBytes());
					} else if (zipEntry.getName().contains("IHE_XDM/")) {
						if (zipEntry.isDirectory()) {
							if (zipEntry.getName().equals("IHE_XDM/")) {
								iheXdmFolder = Files.createDirectories(resolvedPath);
							} else {
								Files.createDirectories(resolvedPath);
							}

						} else {
							Files.createDirectories(resolvedPath.getParent());
							Files.copy(is, resolvedPath, StandardCopyOption.REPLACE_EXISTING);
						}
					}
				}
			}

			// check if README.TXT exists and the content meets the minimum requirements
			assertNotNull(readmeFile);
			testReadMeFile(readmeFile);

			// check if INDEX.HTM exists and the content meets the minimum requirements
			assertNotNull(indexHtmFile);
			testIndexHtmFile(indexHtmFile);

			// check if subdirectory IHE_XDM exists
			assertNotNull(iheXdmFolder);
		}

		// check if the content of IHE_XDM/SUBSET01 subdirectory meets the minimum
		// requirements
		checkSubsetDirContent(String.format("%s/SUBSET01", iheXdmFolder.toString()));
	}

	/**
	 * check if readme contains
	 * 
	 * <ul>
	 * <li>contact information regarding the institution that created the media
	 * (default values)</li>
	 * <li>information regarding the application like name of the product or
	 * software version</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param readmeContent content of README.TXT file
	 * @see <a href="https://profiles.ihe.net/ITI/TF/Volume2/ITI-32.html">ITI-32</a>
	 */
	private void testReadMeFile(String readmeContent) {
		assertTrue(readmeContent.contains("Husky - https://github.com/project-husky/husky"));
		assertTrue(readmeContent.contains("Open Source"));
		assertTrue(readmeContent.contains("Convenience API"));
		assertTrue(readmeContent.contains("https://github.com/project-husky/husky"));
	}

	/**
	 * check if INDEX.HTM contains
	 * 
	 * <ul>
	 * <li>identification of the institution that created the interchange media</li>
	 * <li>a link to an entry point for accessing the web content of the IHE_PDI
	 * directory</li>
	 * <li>a link to the README.TXT file</li>
	 * <li>a manifest which lists the data that can be imported by a Portable Media
	 * Importer</li>
	 * <li>a manifest which lists any patient-related data contained on the CD that
	 * cannot be imported</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param indexHtmContent content of INDEX.HTM file
	 * @see <a href="https://profiles.ihe.net/ITI/TF/Volume2/ITI-32.html">ITI-32</a>
	 */
	private void testIndexHtmFile(String indexHtmContent) {
		assertTrue(indexHtmContent.contains("Husky XDM Cross-Enterprise Document Media Interchange"));

		// check patient details
		assertTrue(indexHtmContent.contains("Patient ID: IHEBLUE-1043 (1.3.6.1.4.1.21367.13.20.3000)"));

		// check references to other documents in folder
		assertTrue(indexHtmContent.contains("<a target=\"_blank\" href=\"README.TXT\">"));
		assertTrue(indexHtmContent.contains("IHE_XDM/SUBSET01/DOC00002.PDF"));
		assertTrue(indexHtmContent.contains("IHE_XDM/SUBSET01/DOC00001.XML"));
	}

	/**
	 * check if subdirectory e.g. IHE_XDM/SUBSET01 contains
	 * 
	 * <ul>
	 * <li>a file called METADATA.XML with valid document metadata</li>
	 * <li>the CDA document</li>
	 * <li>the PDF document</li>
	 * 
	 * </ul>
	 * 
	 * 
	 * @param path to subdirectory
	 * @see <a href="https://profiles.ihe.net/ITI/TF/Volume2/ITI-32.html">ITI-32</a>
	 */
	private void checkSubsetDirContent(String dir) throws Exception {

		String metadataXml = null;
		String doc1 = null;
		String doc2 = null;

		File directory = new File(dir);
		File[] files = directory.listFiles();

		// check if there are files in the directory
		assertNotNull(files);

		// iterate files of directory and cache the contents for further checks
		for (File file : files) {
			try (InputStream is = new FileInputStream(file)) {
				if ("METADATA.XML".equals(file.getName())) {
					metadataXml = new String(is.readAllBytes());
				} else if (file.getName().contains("DOC00002.PDF")) {
					doc1 = new String(is.readAllBytes());
				} else if (file.getName().contains("DOC00001.XML")) {
					doc2 = new String(is.readAllBytes());
				}
			}
		}

		// check if METADATA.XML exists and if it is a valid document
		assertNotNull(metadataXml);
		validateMetadata(metadataXml);

		// check if CDA document exist in directory
		assertNotNull(doc1);

		// check if PDF document exist in directory
		assertNotNull(doc2);

	}

	/**
	 * In this method, the generated metadata for the submission set is checked
	 * using the validation service. (<a href=
	 * "https://ehealthsuisse.ihe-europe.net/gazelle-documentation/EVS-Client/wsvalidation.html">Validation
	 * Services</a>)
	 * 
	 * @param documentContent content of METADATA.XML document
	 * @throws Exception
	 */
	private void validateMetadata(String documentContent)
			throws Exception {

		// send SOAP request to gazelle validation service
		CloseableHttpClient httpClient = HttpClients.custom().build();
		final var post = new HttpPost("https://gazelle.ihe.net/XDStarClient-ejb/ModelBasedValidationWSService/ModelBasedValidationWS");
		post.setEntity(new ByteArrayEntity(createSOAPRequest(documentContent)));
		CloseableHttpResponse response = httpClient.execute(post);

		// extract response of validation request
		String contentResponse = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8);
		
		// checks if metadata are valid
		assertFalse(contentResponse.contains("FAILED"));
	}

	/**
	 * In this method the SOAP message for validate IHE XDM ITI-32 Distribute
	 * Document Set on Media with validation service is implemented.
	 * 
	 * @param documentContent content of METADATA.XML file
	 * 
	 * @return generated SOAP message as byte array
	 * 
	 * @throws Exception
	 */
	private byte[] createSOAPRequest(String documentContent) throws Exception {
		MessageFactory messageFactory = MessageFactory.newInstance();
		SOAPMessage soapMessage = messageFactory.createMessage();
		SOAPPart soapPart = soapMessage.getSOAPPart();

		// SOAP Envelope
		SOAPEnvelope envelope = soapPart.getEnvelope();
		envelope.addNamespaceDeclaration("ws", "http://ws.mb.validator.gazelle.ihe.net");

		SOAPBody soapBody = envelope.getBody();
		SOAPElement soapBodyElem = soapBody.addChildElement("validateBase64Document", "ws");
		SOAPElement soapBodyElemBase64Doc = soapBodyElem.addChildElement("base64Document");
		soapBodyElemBase64Doc.addTextNode(Base64.getEncoder().encodeToString(documentContent.getBytes()));

		// set type of document content
		SOAPElement soapBodyElementValidator = soapBodyElem.addChildElement("validator");
		soapBodyElementValidator.addTextNode("IHE XDM ITI-32 Distribute Document Set on Media");

		soapMessage.saveChanges();

		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

		soapMessage.writeTo(byteOutput);

		return byteOutput.toByteArray();
	}

	/**
	 * This test checks the behavior of the
	 * {@link ConvenienceCommunication#getXdmContents(ZipFile)} when two documents
	 * (CDA and PDF) are exported to a ZIP file.
	 * 
	 * Export / Import Test.
	 * 
	 * @throws IOException
	 */
	@Test
	void exportImportTest() throws IOException {
		// First an XDM ZIP File is exported. 
		final File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "") + ".zip");

		convenienceCommunication.clearDocuments();
		final XdmContents exportContents = exportSamples(convenienceCommunication, targetFile, CDA_FILE_PATH,
				PDF_FILE_PATH);

		// Check if XDM content was exported successfully
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());

		// After this, the file is imported again.
		// The metadata as well as the hash value and the size of the file are compared.
		final XdmContents importContents = importSamples(convenienceCommunication, targetFile);
		assertNotNull(importContents);

		// Check if document metadata is equal
		assertEquals(exportContents.getDocumentAndMetadataList().get(0).getDocEntry(),
				importContents.getDocumentAndMetadataList().get(0).getDocEntry());
		assertEquals(exportContents.getDocumentAndMetadataList().get(1).getDocEntry(),
				importContents.getDocumentAndMetadataList().get(1).getDocEntry());

		// Check if sample files got equal hash and size values compared to the
		// deserialized files in the zip
		assertTrue(isSamplesHashAndSizeEqual(importContents, CDA_FILE_PATH, PDF_FILE_PATH));
	}

	/**
	 * Import Integrity Test. An XDM ZIP File will be imported and the file
	 * integrity (hash, size) will be compared to the values in the according
	 * metadata.xml
	 */
	@Test
	void importIntegrityCheck() {
		convenienceCommunication.clearDocuments();
		assertTrue(importIntegrityCheck(XDM_FILE_PATH, convenienceCommunication));
		assertFalse(importIntegrityCheck(XDM_CORRUPT_FILE_PATH, convenienceCommunication));

	}

}
