/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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
package org.ehealth_connector.communication.ch.ppq.impl;

import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeedResponse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PrivacyPolicyFeed.</div>
 * <div class="de">Die Klasse implementiert das entsprechende interface PrivacyPolicyFeed.</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedResponseImpl implements PrivacyPolicyFeedResponse {

	private String mStatus;

	private PpfMethod mMethod;

	protected PrivacyPolicyFeedResponseImpl() {

	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeedResponse#getStatus()
	 */
	@Override
	public String getStatus() {
		return mStatus;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.communication.ch.ppq.PrivacyPolicyFeedResponse#getMethod()
	 */
	@Override
	public PpfMethod getMethod() {
		return mMethod;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the status of the Response.</div>
	 * <div class="de">Methode um den Status der Antwort zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * @param aStatus
	 * <div class="en">the status to be set.</div>
	 * <div class="de">der Status der gesetzt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public void setStatus(String aStatus) {
		mStatus = aStatus;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the method.</div>
	 * <div class="de">Methode um die Methode zu setzen.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 *
	 * @param aMethod
	 * <div class="en">the method to be set.</div>
	 * <div class="de">der Method der gesetzt werden soll.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public void setMethod(PpfMethod aMethod) {
		mMethod = aMethod;
	}

}
