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
package org.ehealth_connector.security;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class holding some constants from swiss EPD</div>
 * <div class="de">Klasse mit verschiendene konstanten des Schweizer EPD</div>
 * <div class="fr">VOICIFRANCAIS</div>
 * <div class="it">ITALIANO</div>
 * <!-- @formatter:on -->
 */
public final class XUserAssertionConstantsCh {
	public static final String CH_EPR_2017_ANNEX5_ADDENDUM2 = "http://bag.admin.ch/epr/2017/annex/5/addendum/2";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for patient.</div>
	 * <div class="de">Assertion Rollenwert für Patient.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_PATIENT = "PAT";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for healthcare professional.</div>
	 * <div class="de">Assertion Rollenwert für Healthcare Professional.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_HE_CARE_PRO = "HCP";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for assistant.</div>
	 * <div class="de">Assertion Rollenwert für Assitent.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_ASSITANT = "ASS";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Assertion role value for representativ.</div>
	 * <div class="de">Assertion Rollenwert für eine vertreter des patienten.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String ROLE_REPRESENTATIVE = "REP";

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Purpose of use for normal access.</div>
	 * <div class="de">Purpose of use für normalen Zugriff.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PURPOSE_NORMAL = "NORM";
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Purpose of use for emergency access.</div>
	 * <div class="de">Purpose of use für den Notfallzugriff.</div>
	 * <div class="fr">VOICIFRANCAIS</div>
	 * <div class="it">ITALIANO</div>
	 * <!-- @formatter:on -->
	 */
	public static final String PURPOSE_EMERGENCY = "EMER";
}
