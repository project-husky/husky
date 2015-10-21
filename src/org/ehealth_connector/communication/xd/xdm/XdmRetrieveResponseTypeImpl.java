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

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType;
import org.openhealthtools.ihe.xds.response.impl.XDSRetrieveResponseTypeImpl;

/**
 * Class that holds the extracted documents and submission sets from a given xdm
 * volume. It also contains errors, which might occur during the import process.
 *
 */
public class XdmRetrieveResponseTypeImpl extends XDSRetrieveResponseTypeImpl implements
		XDSRetrieveResponseType {

	private List<XDSDocument> attachments;

	/**
	 * Creates a new XdmRetrieveResponseTypeImpl object
	 */
	public XdmRetrieveResponseTypeImpl() {
		super();
	}

	/**
	 * Returns a list of XDSDocuments
	 * 
	 * @return List of XDSDocuments in the XDM Zip File
	 * @see org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType#getAttachments
	 *      ()
	 */
	@Override
	public List<XDSDocument> getAttachments() {
		if (!isProcessed()) {
			return null;
		}
		if (null == attachments) {
			return null;
		}
		return Collections.unmodifiableList(attachments);
	}

	/**
	 * Contains a map of exceptions thrown. Not used in the XDM implementation.
	 * 
	 * @see org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType#getCaughtExceptions()
	 */
	@Override
	public Map<XDSRetrieveResponseType, Throwable> getCaughtExceptions() {
		return null;
	}

	/**
	 * Determines whether or not the transfer is complete. Not used in the XDM
	 * implementation.
	 * 
	 * @see org.openhealthtools.ihe.xds.response.XDSResponseType#isComplete()
	 */
	@Override
	public boolean isComplete() {
		return true;
	}

	/**
	 * Determines whether or not the processing is complete. Not used in the XDM
	 * implementation.
	 * 
	 * @see org.openhealthtools.ihe.xds.response.impl.XDSResponseTypeImpl#isProcessed()
	 */
	@Override
	protected boolean isProcessed() {
		return true;
	}

	/**
	 * Set the list of attachments
	 * 
	 * @param attachments
	 *            List of attachments for this responect
	 */
	@Override
	protected void setAttachments(List<XDSDocument> attachments) {
		this.attachments = attachments;
	}

}
