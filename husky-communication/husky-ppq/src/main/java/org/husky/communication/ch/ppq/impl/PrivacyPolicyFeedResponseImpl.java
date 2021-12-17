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
package org.husky.communication.ch.ppq.impl;

import java.util.ArrayList;
import java.util.List;

import org.husky.communication.ch.ppq.api.PrivacyPolicyFeedResponse;
import org.husky.communication.ch.ppq.api.PrivacyPolicyFeed.PpfMethod;

/**
 * Class implementing the corresponding interface for PrivacyPolicyFeed.
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
