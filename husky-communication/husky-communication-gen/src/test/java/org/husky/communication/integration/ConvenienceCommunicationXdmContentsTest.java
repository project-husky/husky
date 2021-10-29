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
package org.husky.communication.integration;

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
import org.husky.common.communication.DocumentMetadata;
import org.husky.common.communication.SubmissionSetMetadata;
import org.husky.common.enums.DocumentDescriptor;
import org.husky.common.model.Identificator;
import org.husky.communication.ConvenienceCommunication;
import org.husky.communication.testhelper.TestApplication;
import org.husky.communication.testhelper.XdmTestUtils;
import org.husky.communication.xd.xdm.XdmContents;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Test of class ConvenienceCommunication
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
public class ConvenienceCommunicationXdmContentsTest extends XdmTestUtils {

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

	@Test
	public void contextLoads() {
		assertNotNull(convenienceCommunication);
		assertNotNull(convenienceCommunication.getCamelContext());
	}

	@Test
	public void createXdmContentsTest() throws Exception {
		// assemble two files for the XDM Zip
		DocumentMetadata metaData = convenienceCommunication.addDocument(DocumentDescriptor.CDA_R2, getDocCda(),
				getDocCda());
		Identificator patientId = new Identificator("1.3.6.1.4.1.21367.13.20.3000", "IHEBLUE-1043");
		setMetadataForCda(metaData, patientId);

		metaData = convenienceCommunication.addDocument(DocumentDescriptor.PDF, getDocPdf());
		setMetadataForPdf(metaData, patientId);

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

	private void checkZipContent(File targetFile) throws Exception {

		String readmeFile = null;
		String indexHtmFile = null;
		Path iheXdmFolder = null;
		File targetUnzip = new File("src/test/resources/xdmTest_Java");

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

			assertNotNull(readmeFile);
			testReadMeFile(readmeFile);
			assertNotNull(indexHtmFile);
			testIndexHtmFile(indexHtmFile);
			assertNotNull(iheXdmFolder);
		}

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
		assertTrue(readmeContent.contains("Husky - http://ehealth-connector.org"));
		assertTrue(readmeContent.contains("Open Source"));
		assertTrue(readmeContent.contains("Convenience API"));
		assertTrue(readmeContent.contains("http://sourceforge.net/p/ehealthconnector/wiki/Team"));
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
		assertTrue(indexHtmContent.contains("eHealthConnector XDM Cross-Enterprise Document Media Interchange"));

		// check patient details
		assertTrue(indexHtmContent.contains("Patient ID: IHEBLUE-1043 (1.3.6.1.4.1.21367.13.20.3000)"));

		// check references to other documents in folder
		assertTrue(indexHtmContent.contains("<a target=\"_blank\" href=\"README.TXT\">"));
		assertTrue(indexHtmContent.contains("IHE_XDM/SUBSET01/DOC00002.PDF"));
		assertTrue(indexHtmContent.contains("IHE_XDM/SUBSET01/DOC00001.XML"));
	}

	private void checkSubsetDirContent(String dir) throws Exception {

		String metadataXml = null;
		String doc1 = null;
		String doc2 = null;

		File directory = new File(dir);
		File[] files = directory.listFiles();

		assertNotNull(files);

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

		assertNotNull(metadataXml);
		validateMetadata(metadataXml);
		assertNotNull(doc1);
		assertNotNull(doc2);

	}

	private void validateMetadata(String documentContent)
			throws Exception {

		CloseableHttpClient httpClient = HttpClients.custom().build();
		final var post = new HttpPost("https://gazelle.ihe.net/XDStarClient-ejb/ModelBasedValidationWSService/ModelBasedValidationWS");
		post.setEntity(new ByteArrayEntity(createSOAPRequest(documentContent)));

		CloseableHttpResponse response = httpClient.execute(post);
		String contentResponse = IOUtils.toString(response.getEntity().getContent());
		
		assertFalse(contentResponse.contains("FAILED"));
	}

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

		SOAPElement soapBodyElementValidator = soapBodyElem.addChildElement("validator");
		soapBodyElementValidator.addTextNode("IHE XDM ITI-32 Distribute Document Set on Media");

		soapMessage.saveChanges();

		ByteArrayOutputStream byteOutput = new ByteArrayOutputStream();

		soapMessage.writeTo(byteOutput);

		return byteOutput.toByteArray();
	}

	@Test
	public void exportForValidationTest() {
		// Export for Validation test. An XDM ZIP File will be
		// exported for online validation
		final File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "") + ".zip");

		convenienceCommunication.clearDocuments();
		final XdmContents exportContents = exportSamples(convenienceCommunication, targetFile, CDA_FILE_PATH,
				PDF_FILE_PATH);
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());
	}

	@Test
	public void exportImportTest() throws IOException {
		// Export / Import Test.
		// An XDM ZIP File will be exported. After this, the file will be imported again
		// and the metadata as well
		// as the file hash and size will be compared.
		final File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "") + ".zip");

		convenienceCommunication.clearDocuments();
		final XdmContents exportContents = exportSamples(convenienceCommunication, targetFile, CDA_FILE_PATH,
				PDF_FILE_PATH);
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());

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

	@Test
	public void importIntegrityCheck() {
		// Import Integrity Test. An XDM ZIP File will be imported and
		// the file integrity (hash, size) will be compared to the values in the
		// according metadata.xml

		convenienceCommunication.clearDocuments();
		assertTrue(importIntegrityCheck(XDM_FILE_PATH, convenienceCommunication));
		assertFalse(importIntegrityCheck(XDM_CORRUPT_FILE_PATH, convenienceCommunication));

	}

}
