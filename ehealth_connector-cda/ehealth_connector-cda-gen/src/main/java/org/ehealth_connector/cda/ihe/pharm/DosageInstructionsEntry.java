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

package org.ehealth_connector.cda.ihe.pharm;

import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Implements the IHE DosageInstructionsEntry.
 */
public class DosageInstructionsEntry extends MedicationItemEntry {

	/**
	 * Instantiates a new dispense item reference entry.
	 */
	public DosageInstructionsEntry() {
		this(PHARMFactory.eINSTANCE.createDosageInstructionsEntry().init());
	}

	/**
	 * Instantiates a new dispense item reference entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public DosageInstructionsEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.DosageInstructionsEntry mdht) {
		super(mdht);
		final Consumable consumable = CDAFactory.eINSTANCE.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		this.getMdht().setConsumable(consumable);
	}

}
