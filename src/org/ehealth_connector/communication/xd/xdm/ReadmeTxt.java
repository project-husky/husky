package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class ReadmeTxt {

	private static Logger logService = Logger.getLogger(ReadmeTxt.class.getName());

	private InputStream is = null;
	public static final String TEMPLATE_EN = "Vendor: {0}\n" + "Application: {1}\n"
			+ "Contact info: {2}\n\n" + "Created for Patient with ID: {3}\n";

	public ReadmeTxt(InputStream readmeTxtStream) {
		is = readmeTxtStream;
	}

	/**
	 * Creates a new README.TXT Object
	 * 
	 * @param patientID
	 *            Contains the PatientID as a string
	 * @param documentID
	 *            Contains the DocumentID as a string
	 * @param submissionSetID
	 *            Contains the submissionSetID as a string
	 */
	public ReadmeTxt(SubmitTransactionData txnData) {
		this(txnData, new VendorInformation());
	}

	public ReadmeTxt(SubmitTransactionData txnData, VendorInformation vendorInfo) {
		logService.debug("Creating the README.TXT file");

		Object[] values = new Object[] { vendorInfo.getName(), vendorInfo.getApplicationName(),
				vendorInfo.getContactInformation(),
				txnData.getSubmissionSet().getPatientId().getIdNumber() };
		String str = MessageFormat.format(TEMPLATE_EN, values);
		is = new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * Writes the index.htm contents to an OutputStream
	 */
	public InputStream getInputStream() {
		return is;
	}

	// /**
	// * Writes the index.htm contents to an OutputStream
	// */
	// public void writeToOutputStream(OutputStream outputStream) {
	// try {
	// // outputStream.write(str.getBytes());
	// IOUtils.copy(is, outputStream);
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
}
