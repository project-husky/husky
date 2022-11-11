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
package org.projecthusky.xua.communication.soap.impl;

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

	/**
	 * Constructor with params.
	 * 
	 * @param messageId the message id
	 * @param action    the action
	 * @param to        the to info
	 */
	public WsaHeaderValue(String messageId, String action, String to) {
		super();
		mMessageId = messageId;
		mAction = action;
		mTo = to;
		mMustUnderstand = false;
	}

	/**
	 * Constructor with params.
	 * 
	 * @param messageId       the message id
	 * @param action          the action
	 * @param to              the to info
	 * @param aMustUnderstand the must understand value
	 */
	public WsaHeaderValue(String messageId, String action, String to, boolean aMustUnderstand) {
		super();
		mMessageId = messageId;
		mAction = action;
		mTo = to;
		mMustUnderstand = aMustUnderstand;
	}

	/**
	 * Method to get.
	 * @return the mAction value
	 */
	public String getAction() {
		return mAction;
	}

	/**
	 * Method to get.
	 * @return the mMessageId value
	 */
	public String getMessageId() {
		return mMessageId;
	}

	/**
	 * Method to get.
	 * @return the mTo value
	 */
	public String getTo() {
		return mTo;
	}

	/**
	 * Method to get.
	 * @return the mMustUnderstand value
	 */
	public boolean isMustUnderstand() {
		return mMustUnderstand;
	}

	/**
	 * Method to set.
	 * @param action the action to be set
	 */
	public void setAction(String action) {
		mAction = action;
	}

	/**
	 * Method to set.
	 * @param messageId the messageId to be set
	 */
	public void setMessageId(String messageId) {
		mMessageId = messageId;
	}

	/**
	 * Method to set.
	 * @param mustUnderstand the mustUnderstand to be set
	 */
	public void setMustUnderstand(boolean mustUnderstand) {
		mMustUnderstand = mustUnderstand;
	}

	/**
	 * Method to set.
	 * @param to the to to be set
	 */
	public void setTo(String to) {
		mTo = to;
	}

}
