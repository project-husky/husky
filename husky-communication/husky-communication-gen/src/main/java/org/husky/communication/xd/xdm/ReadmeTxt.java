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
package org.husky.communication.xd.xdm;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Date;

import org.husky.common.enums.EhcVersions;
import org.husky.common.model.VendorInformation;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class ReadmeTxt represents the README.TXT file, which is part of the
 * contents of an XDM volume. The File contains information about the vendor,
 * who build the system that created the XDM volume.
 */
public class ReadmeTxt {

	/** The Constant TEMPLATE_EN. */
	public static final String TEMPLATE_EN = """
			Vendor name: {0}
			Product: {1}
			Module: {2}
			Version: {3}
			Contact info: See {4}
			Creation timestamp: {5}
			""";

	/** The SLF4J logger instance. */
	private final Logger log = LoggerFactory.getLogger(getClass());

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
	public ReadmeTxt(ProvideAndRegisterDocumentSet txnData) {
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
	public ReadmeTxt(ProvideAndRegisterDocumentSet txnData, VendorInformation vendorInfo) {
		log.debug("Creating the README.TXT file");

		final var values = new Object[] { vendorInfo.getVendorName(),
				vendorInfo.getProductName(), vendorInfo.getModuleName(),
				EhcVersions.getCurrentVersion() + ", Release Date "
						+ EhcVersions.getCurrentVersion().getReleaseDate(),
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
