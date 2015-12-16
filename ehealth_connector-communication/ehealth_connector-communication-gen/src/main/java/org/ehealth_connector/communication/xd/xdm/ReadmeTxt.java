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
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.common.EHealthConnectorVersions;
import org.ehealth_connector.common.VendorInformation;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;

/**
 * The Class ReadmeTxt represents the README.TXT file, which is part of the
 * contents of an XDM volume. The File contains information about the vendor,
 * who build the system that created the XDM volume.
 */
public class ReadmeTxt {

	/** The log service. */
	private static Log log = LogFactory.getLog(IndexHtm.class);

	/** The Constant TEMPLATE_EN. */
	public static final String TEMPLATE_EN = "Vendor name: {0}\n" + "Product: {1}\n"
			+ "Module: {2}\n" + "Version: {3}\n" + "Contact info: See {4}\n"
			+ "Creation timestamp: {5}\n";

	/** The InputStream */
	private InputStream inputStream = null;

	/**
	 * Creates a new README.TXT based on the given InputStream.
	 * 
	 * @param readmeTxtStream
	 *            the readme txt stream
	 */
	public ReadmeTxt(InputStream readmeTxtStream) {
		inputStream = readmeTxtStream;
	}

	/**
	 * Creates a new README.TXT Object based on the given txnData (default
	 * values will be used for vendor information).
	 * 
	 * @param txnData
	 *            the SubmitTransactionData
	 */
	public ReadmeTxt(SubmitTransactionData txnData) {
		this(txnData, new VendorInformation());
	}

	/**
	 * Creates a new README.TXT Object based on the given txnData and the given
	 * vendor information.
	 * 
	 * @param txnData
	 *            the SubmitTransactionData data
	 * @param vendorInfo
	 *            the vendor info
	 */
	public ReadmeTxt(SubmitTransactionData txnData, VendorInformation vendorInfo) {
		log.debug("Creating the README.TXT file");

		final Object[] values = new Object[] { vendorInfo.getVendorName(),
				vendorInfo.getProductName(), vendorInfo.getModuleName(),
				EHealthConnectorVersions.getCurrentVersion() + ", Release Date "
						+ EHealthConnectorVersions.getCurrentVersion().getReleaseDate(),
				vendorInfo.getContactInformation(), new Date().toString() };
		final String str = MessageFormat.format(TEMPLATE_EN, values);
		inputStream = new ByteArrayInputStream(str.getBytes());
	}

	/**
	 * Gets the INDEX.HTM contents as InputStream
	 * 
	 * @return the input stream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
}
