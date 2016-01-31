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

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.Product;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Implements the IHE PharmaceuticalAdviceItemReferenceEntry.
 */
public class PharmaceuticalAdviceItemReferenceEntry extends PharmaceuticalAdviceItemEntry {
	
	/**
	 * Instantiates a new pharmaceutical advice item reference entry.
	 */
	public PharmaceuticalAdviceItemReferenceEntry() {
		this(PHARMFactory.eINSTANCE.createPharmaceuticalAdviceItemReferenceEntry().init());		
	}


	/**
	 * Instantiates a new pharmaceutical advice item reference entry.
	 *
	 * @param mdht the mdht
	 */
	public PharmaceuticalAdviceItemReferenceEntry(org.openhealthtools.mdht.uml.cda.ihe.pharm.PharmaceuticalAdviceItemReferenceEntry mdht) {
		super(mdht);
		String templateId = this.getTemplateId();
		this.getMdht().getTemplateIds().clear();
		this.getMdht().getTemplateIds().add(new Identificator(templateId, null).getIi());
		this.getMdht().setStatusCode(null);
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor.NA);
		this.getMdht().setCode(cd);
	}
	

}
