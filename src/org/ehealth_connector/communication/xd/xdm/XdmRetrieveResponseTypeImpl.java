package org.ehealth_connector.communication.xd.xdm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType;
import org.openhealthtools.ihe.xds.response.impl.XDSResponseTypeImpl;

public class XdmRetrieveResponseTypeImpl extends XDSResponseTypeImpl implements XDSRetrieveResponseType {

	private List<XDSDocument> attachments;

	public XdmRetrieveResponseTypeImpl() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.openhealthtools.ihe.xds.response.XDSRetrieveResponseType#getAttachments
	 * ()
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

	@Override
	public Map<XDSRetrieveResponseType, Throwable> getCaughtExceptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComplete() {
		return true;
	}

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
	protected void setAttachments(List<XDSDocument> attachments) {
		this.attachments = attachments;
	}

}
