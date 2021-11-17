/*
 * This code is made available under the terms of the Eclipse Public License v1.0 in the github project https://github.com/project-husky/husky there you also find a list of the contributors and the license information.
This project has been developed further and modified by the joined working group Husky on the basis of the eHealth Connector opensource project from June 28, 2021, whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
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
package org.husky.communication.xd.xdm;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.openehealth.ipf.commons.ihe.xds.core.metadata.Document;
import org.openehealth.ipf.commons.ihe.xds.core.responses.ErrorInfo;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Status;

/**
 * Class that holds the extracted documents and submission sets from a given xdm
 * volume. It also contains errors, which might occur during the import process.
 *
 */
public class XdmRetrieveResponseTypeImpl {

	protected static final Status STATUS_EDEFAULT = Status.SUCCESS;

	private List<Document> attachments;

	protected List<ErrorInfo> errorList;

	protected Status status = STATUS_EDEFAULT;

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
	 */
	public List<Document> getAttachments() {
		if (!isProcessed()) {
			return new LinkedList<>();
		}
		if (null == attachments) {
			return new LinkedList<>();
		}
		return Collections.unmodifiableList(attachments);
	}

	/**
	 * Determines whether or not the transfer is complete. Not used in the XDM
	 * implementation.
	 *
	 * @see org.openhealthtools.ihe.xds.response.XDSResponseType#isComplete()
	 */
	public boolean isComplete() {
		return true;
	}

	/**
	 * Determines whether or not the processing is complete. Not used in the XDM
	 * implementation.
	 *
	 * @see org.openhealthtools.ihe.xds.response.impl.XDSResponseTypeImpl#isProcessed()
	 */
	protected boolean isProcessed() {
		return true;
	}

	/**
	 * Set the list of attachments
	 *
	 * @param attachments
	 *            List of attachments for this responect
	 */
	protected void setAttachments(List<Document> attachments) {
		this.attachments = attachments;
	}

	public List<ErrorInfo> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<ErrorInfo> errorList) {
		this.errorList = errorList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
