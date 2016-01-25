/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.mtps;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseSection;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;

public class CdaChMtpsDis extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis> {
	
	private final String formatCode = "urn:ihe:pharm:dis:2010";

	public CdaChMtpsDis() {
		super(CHFactory.eINSTANCE.createCdaChMtpsDis().init());
		super.initCda();
		getDoc().getRealmCodes().get(0).setCode("CHE");
		
		DispenseSection dispenseSection = PHARMFactory.eINSTANCE.createDispenseSection().init();
		this.getDoc().addSection(dispenseSection);
	}
	
	public CdaChMtpsDis(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis doc) {
		super(doc);
	}
}
