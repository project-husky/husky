package org.ehealth_connector.communication.xd.xdm;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

public class ReadmeTxt {

	private static Logger logService = Logger.getLogger(ReadmeTxt.class.getName());

	private String str = new String();
	public static final String TEMPLATE_EN = "Vendor: {0}\n" + "Application: {1}\n"
			+ "Contact info: {2}\n\n" + "Created for Patient with ID: {3}\n";

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
		str = MessageFormat.format(TEMPLATE_EN, values);
	}

	/**
	 * Writes the index.htm contents to an OutputStream
	 */
	public InputStream getInputStream() {
		return IOUtils.toInputStream(str);
	}

	/**
	 * Provides the readme.txt as a bytearray
	 * 
	 * @return The readme.txt as a bytearray
	 */
	public byte[] getReadmeTxt() {
		return str.toString().getBytes();
	}

	/**
	 * Writes the index.htm contents to an OutputStream
	 */
	public void writeToOutputStream(OutputStream outputStream) {
		try {
			outputStream.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
