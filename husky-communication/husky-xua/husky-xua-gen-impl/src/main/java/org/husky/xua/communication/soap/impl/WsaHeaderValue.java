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
package org.husky.xua.communication.soap.impl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the parameters for SOAP WSA Headers</div>
 * <div class="de">Klasse welche die Parameter und Methoden für SOAP WSA Headers definiert</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class WsaHeaderValue {
	private String mAction;
	private String mMessageId;
	private boolean mMustUnderstand;
	private String mTo;

	public WsaHeaderValue(String messageId, String action, String to) {
		super();
		mMessageId = messageId;
		mAction = action;
		mTo = to;
		mMustUnderstand = false;
	}

	public WsaHeaderValue(String messageId, String action, String to, boolean aMustUnderstand) {
		super();
		mMessageId = messageId;
		mAction = action;
		mTo = to;
		mMustUnderstand = aMustUnderstand;
	}

	public String getAction() {
		return mAction;
	}

	public String getMessageId() {
		return mMessageId;
	}

	public String getTo() {
		return mTo;
	}

	public boolean isMustUnderstand() {
		return mMustUnderstand;
	}

	public void setAction(String action) {
		mAction = action;
	}

	public void setMessageId(String messageId) {
		mMessageId = messageId;
	}

	public void setMustUnderstand(boolean mustUnderstand) {
		mMustUnderstand = mustUnderstand;
	}

	public void setTo(String to) {
		mTo = to;
	}

}
