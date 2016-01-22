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

public class CdaChMtpsPadv extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv> {

	public CdaChMtpsPadv() {
		super(CHFactory.eINSTANCE.createCdaChMtpsPadv().init());
	}
	
	public CdaChMtpsPadv(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPadv doc) {
		super(doc);
	}
}
