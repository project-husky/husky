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
package org.ehealth_connector.communication.ch.ppq.impl;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;
import org.ehealth_connector.communication.ch.ppq.api.PrivacyPolicyFeedResponse;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PrivacyPolicyFeed.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface PrivacyPolicyFeed.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class PrivacyPolicyFeedResponseImpl implements PrivacyPolicyFeedResponse {

	public static final String FAILURE = "urn:e-health-suisse:2015:response-status:failure";
	public static final String SUCCESS = "urn:e-health-suisse:2015:response-status:success";

	private List<Exception> mExceptions;

	private PpfMethod mMethod;

	private String mStatus;

	protected PrivacyPolicyFeedResponseImpl() {
		mExceptions = new ArrayList<>();
	}

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add a exception to the list of exceptions.</div>
	 * <div class="de">Methode um ein Fehler der Liste von Fehlern hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aException
	 * <!-- @formatter:on -->
	 */
	public void addException(Exception aException) {
		mExceptions.add(aException);
	}

	@Override
	public List<Exception> getExceptions() {
		return mExceptions;
	}

	@Override
	public PpfMethod getMethod() {
		return mMethod;
	}

	@Override
	public String getStatus() {
		return mStatus;
	}

	@Override
	public Boolean isStatusSuccess() {
		return PrivacyPolicyFeedResponseImpl.SUCCESS.equals(mStatus);
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the method.</div>
	 * <div class="de">Methode um die Methode zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aMethod
	 * <div class="en">the method to be set.</div>
	 * <div class="de">der Method der gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setMethod(PpfMethod aMethod) {
		mMethod = aMethod;
	}

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set the status of the Response.</div>
	 * <div class="de">Methode um den Status der Antwort zu setzen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * @param aStatus
	 * <div class="en">the status to be set.</div>
	 * <div class="de">der Status der gesetzt werden soll.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public void setStatus(String aStatus) {
		mStatus = aStatus;
	}

}
