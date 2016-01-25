package org.ehealth_connector.cda.ch.edes;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChEdesEdpn  extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn> {

	public CdaChEdesEdpn() {
		super(CHFactory.eINSTANCE.createCdaChEdesEdpn().init());
	}
	
	public CdaChEdesEdpn(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesEdpn doc) {
		super(doc);
	}
}
