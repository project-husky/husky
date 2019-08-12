/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
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
package org.ehealth_connector.security.communication.soap.impl;

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
