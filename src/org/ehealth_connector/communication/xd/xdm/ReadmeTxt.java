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
package org.ehealth_connector.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;

import org.apache.log4j.Logger;
import org.ehealth_connector.util.VendorInformation;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * The Class ReadmeTxt represents the README.TXT file, which is part of the
 * contents of an XDM volume. The File contains information about the vendor,
 * who build the system that created the XDM volume.
 */
public class ReadmeTxt {

	/** The log service. */
	private static Logger logService = Logger.getLogger(ReadmeTxt.class.getName());

	/** The InputStream */
	private InputStream is = null;

	/** The Constant TEMPLATE_EN. */
	public static final String TEMPLATE_EN = "Vendor: {0}\n" + "Application: {1}\n"
			+ "Contact info: {2}\n\n" + "Created for Patient with ID: {3}\n";

	/**
	 * Instantiates a new readme txt.
	 *
	 * @param readmeTxtStream
	 *            the readme txt stream
	 */
	public ReadmeTxt(InputStream readmeTxtStream) {
		is = readmeTxtStream;
	}

	/**
	 * Creates a new README.TXT Object
	 *
	 * @param txnData
	 *            the SubmitTransactionData
	 */
	public ReadmeTxt(SubmitTransactionData txnData) {
		this(txnData, new VendorInformation());
	}

	/**
	 * Instantiates a new readme txt.
	 *
	 * @param txnData
	 *            the SubmitTransactionData data
	 * @param vendorInfo
	 *            the vendor info
	 */
	public ReadmeTxt(SubmitTransactionData txnData, VendorInformation vendorInfo) {
		logService.debug("Creating the README.TXT file");

		Object[] values = new Object[] { vendorInfo.getName(), vendorInfo.getApplicationName(),
				vendorInfo.getContactInformation(),
				txnData.getSubmissionSet().getPatientId().getIdNumber() };
		String str = MessageFormat.format(TEMPLATE_EN, values);
		is = new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * Gets the index.htm contents as InputStream
	 *
	 * @return the input stream
	 */
	public InputStream getInputStream() {
		return is;
	}
}
