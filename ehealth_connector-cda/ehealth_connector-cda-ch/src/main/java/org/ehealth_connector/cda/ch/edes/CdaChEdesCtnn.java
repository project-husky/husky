package org.ehealth_connector.cda.ch.edes;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;

public class CdaChEdesCtnn extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn> {

	public CdaChEdesCtnn() {
		super(CHFactory.eINSTANCE.createCdaChEdesCtnn().init());
	}
	
	public CdaChEdesCtnn(org.openhealthtools.mdht.uml.cda.ch.CdaChEdesCtnn doc) {
		super(doc);
	}
}
