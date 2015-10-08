package org.ehealth_connector.communication;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.ehealth_connector.communication.xd.xdm.XdmContents;
import org.junit.Test;

public class XdmExportImportTest extends XdmTestUtils {

	public static final String XDM_FILE_PATH = "/docConsumer/xdm.zip";
	public static final String XDM_CORRUPT_FILE_PATH = "/docConsumer/xdmCorrupt.zip";
	public static final String PDF_FILE_PATH = "/docConsumer/patientconsent.pdf";
	public static final String CDA_FILE_PATH = "/docConsumer/CDA-CH-VACD_Impfausweis.xml";

	// private final Log log = LogFactory.getLog(XdmExportImportTest.class);
	private static final DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

	ConvenienceCommunication conCom = new ConvenienceCommunication();
	String filePath = FileUtils.getTempDirectoryPath();

	@Test
	public void exportForValidationTest() {
		// log.info("Export for Validation test. An XDM ZIP File will be exported for online validation)");
		File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "")
				+ ".zip");

		XdmContents exportContents = exportSamples(conCom, targetFile, CDA_FILE_PATH, PDF_FILE_PATH);
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());

		// try {
		// //log.info("Success. Created Zip for online validation. Exported it to: "
		// // + targetFile.getCanonicalPath());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
	}

	@Test
	public void exportImportTest() {
		// log.info("Export / Import Test. An XDM ZIP File will be exported. After this, the file will be imported again and the metadata as well as the file hash and size will be compared.");
		File targetFile = new File(filePath + "/xdm_"
				+ dateFormat.format(new Date()).replace(".", "").replace(" ", "").replace(":", "")
				+ ".zip");

		XdmContents exportContents = exportSamples(conCom, targetFile, CDA_FILE_PATH, PDF_FILE_PATH);
		assertNotNull(exportContents);
		assertTrue(targetFile.exists());

		XdmContents importContents = importSamples(conCom, targetFile);
		// XdmContents importContents2 = importSamples(conCom, targetFile);
		assertNotNull(importContents);

		// Check if document metadata is equal
		assertTrue(exportContents.getDocumentAndMetadataList().get(0).getDocEntry()
				.equals(importContents.getDocumentAndMetadataList().get(0).getDocEntry()));
		assertTrue(exportContents.getDocumentAndMetadataList().get(1).getDocEntry()
				.equals(importContents.getDocumentAndMetadataList().get(1).getDocEntry()));

		// Check if sample files got equal hash and size values compared to the
		// deserialized files in the zip
		assertTrue(isSamplesHashAndSizeEqual(importContents, CDA_FILE_PATH, PDF_FILE_PATH));
		// log.info("Success.");
	}

	@Test
	public void importIntegrityCheck() {
		// log.info("Import Integrity Test. An XDM ZIP File will be imported and the file integrity (hash, size) will be compared to the values in the according metadata.xml");

		assertTrue(importIntegrityCheck(XDM_FILE_PATH, conCom));
		assertFalse(importIntegrityCheck(XDM_CORRUPT_FILE_PATH, conCom));

		// log.info("Success.");
	}
}
