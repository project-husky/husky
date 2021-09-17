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
package org.ehealth_connector.communication.xd.xdm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.ehealth_connector.communication.ConvenienceCommunication;
import org.ehealth_connector.communication.testhelper.XdmTestUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test of class XdmContents
 */
@Disabled
public class XdmContentsTest extends XdmTestUtils {

	public static final String XDM_FILE_PATH = "/docConsumer/xdm.zip";
	public static final String XDM_CORRUPT_FILE_PATH = "/docConsumer/xdmCorrupt.zip";
	public static final String PDF_FILE_PATH = "/docConsumer/patientconsent.pdf";
	public static final String CDA_FILE_PATH = "/docConsumer/CDA-CH-VACD_Impfausweis.xml";

	// private final Log log = LogFactory.getLog(XdmExportImportTest.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	ConvenienceCommunication conCom = new ConvenienceCommunication();
	String filePath = getTempFilePath();

	@Test
	public void exportForValidationTest() {
		// log.info("Export for Validation test. An XDM ZIP File will be
		// exported for online validation)");
		final File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "")
				+ ".zip");

		final XdmContents exportContents = exportSamples(conCom, targetFile, CDA_FILE_PATH,
				PDF_FILE_PATH);
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());

		// try {
		// //log.info("Success. Created Zip for online validation. Exported it
		// to: "
		// // + targetFile.getCanonicalPath());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	@Test
	public void exportImportTest() throws IOException {
		// log.info("Export / Import Test. An XDM ZIP File will be exported.
		// After this, the file will be imported again and the metadata as well
		// as the file hash and size will be compared.");
		final File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "")
				+ ".zip");

		final XdmContents exportContents = exportSamples(conCom, targetFile, CDA_FILE_PATH,
				PDF_FILE_PATH);
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());

		final XdmContents importContents = importSamples(conCom, targetFile);
		// XdmContents importContents2 = importSamples(conCom, targetFile);
		assertNotNull(importContents);

		// Check if document metadata is equal
		assertEquals(exportContents.getDocumentAndMetadataList().get(0).getDocEntry(),
				importContents.getDocumentAndMetadataList().get(0).getDocEntry());
		assertEquals(exportContents.getDocumentAndMetadataList().get(1).getDocEntry(),
				importContents.getDocumentAndMetadataList().get(1).getDocEntry());

		// Check if sample files got equal hash and size values compared to the
		// deserialized files in the zip
		assertTrue(isSamplesHashAndSizeEqual(importContents, CDA_FILE_PATH, PDF_FILE_PATH));
		// log.info("Success.");
	}

	@Test
	public void importIntegrityCheck() {
		// log.info("Import Integrity Test. An XDM ZIP File will be imported and
		// the file integrity (hash, size) will be compared to the values in the
		// according metadata.xml");

		assertTrue(importIntegrityCheck(XDM_FILE_PATH, conCom));
		assertFalse(importIntegrityCheck(XDM_CORRUPT_FILE_PATH, conCom));

		// log.info("Success.");
	}

}
