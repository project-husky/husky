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
package org.husky.communication.ch.ppq.hl7v3;

import org.husky.xua.hl7v3.Role;
import org.husky.xua.hl7v3.impl.RoleBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class providing method to generate the CH:EPD Role instances ASS, DADM, HCP, PAT, PADM, REP, TCU</div>
 * <div class="de">Klasse die die methoden für die Generierung von CH:EPD Role Instanzen ASS, DADM, HCP, PAT, PADM, REP, TCU</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public abstract class RoleChImpl {
	public static final String CODE_SYSTEM_NAME = "eHealth Suisse EPR Akteure";
	public static final String CODE_SYSTEM = "2.16.756.5.30.1.127.3.10.6";
	public static final String CODE_ASS = "ASS";
	public static final String CODE_DADM = "DADM";
	public static final String CODE_HCP = "HCP";
	public static final String CODE_PAT = "PAT";
	public static final String CODE_PADM = "PADM";
	public static final String CODE_REP = "REP";
	public static final String CODE_TCU = "TCU";

	// <Role code="ASS" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Assistent"
	// xsi:type="CE"/>
	public static Role ASSISTENT() {
		return generateRole(CODE_ASS, "Assistent");
	}

	// <Role code="DADM" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Document
	// Administrator" xsi:type="CE"/>
	public static Role DOCUMENT_ADMINISTRATOR() {
		return generateRole(CODE_DADM, "Document Administrator");
	}

	private static Role generateRole(String code, String displayName) {
		return new RoleBuilder() //
				.code(code) //
				.codeSystem(CODE_SYSTEM) //
				.codeSystemName(CODE_SYSTEM_NAME).displayName(displayName) //
				.buildObject();
	}

	// <Role code="ASS" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Assistent"
	// xsi:type="CE"/>
	public static Role HEALT_CARE_PROFESSIONAL() {
		return generateRole(CODE_HCP, "Behandelnde(r)");
	}

	// <Role code="PAT" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Patient"
	// xsi:type="CE"/>
	public static Role PATIENT() {
		return generateRole(CODE_PAT, "Patient");
	}

	// <Role code="PADM" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Policy
	// Administrator" xsi:type="CE"/>
	public static Role POLICY_ADMINISTRATOR() {
		return generateRole(CODE_PADM, "Policy Administrator");
	}

	// <Role code="REP" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Representative"
	// xsi:type="CE"/>
	public static Role REPRESENTATIVE() {
		return generateRole(CODE_REP, "Representative");
	}

	// <Role code="TCU" codeSystem="2.16.756.5.30.1.127.3.10.6"
	// codeSystemName="eHealth Suisse EPR Akteure" displayName="Technical user"
	// xsi:type="CE"/>
	public static Role TECHNICAL_USER() {
		return generateRole(CODE_TCU, "Technical user");
	}
}
