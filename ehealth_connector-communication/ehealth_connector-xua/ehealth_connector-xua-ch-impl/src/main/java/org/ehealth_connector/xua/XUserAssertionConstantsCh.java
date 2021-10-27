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
package org.ehealth_connector.xua;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class holding some constants from swiss EPD</div>
 * <div class="de">Klasse mit verschiendene konstanten des Schweizer EPD</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public final class XUserAssertionConstantsCh {
	public static final String CH_EPR_2017_ANNEX5_ADDENDUM2 = "http://bag.admin.ch/epr/2017/annex/5/addendum/2";

	/** principal-id */
	public static final String CH_PRINCIPALID = "urn:e-health-suisse:principal-id";

	/** principal-name */
	public static final String CH_PRINCIPAL_NAME = "urn:e-health-suisse:principal-name";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for assistant.</div>
	 * <div class="de">Assertion Rollenwert für Assitent.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_ASSITANT = "ASS";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for healthcare professional.</div>
	 * <div class="de">Assertion Rollenwert für Healthcare Professional.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_HE_CARE_PRO = "HCP";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for patient.</div>
	 * <div class="de">Assertion Rollenwert für Patient.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_PATIENT = "PAT";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for representativ.</div>
	 * <div class="de">Assertion Rollenwert für eine vertreter des patienten.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_REPRESENTATIVE = "REP";
	
	private XUserAssertionConstantsCh() {
		throw new IllegalStateException("Constants class");
	}

}
