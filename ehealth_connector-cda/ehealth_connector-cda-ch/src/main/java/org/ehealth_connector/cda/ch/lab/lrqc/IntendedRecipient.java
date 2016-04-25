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
package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.lab.lrqc.enums.QualabQcc;
import org.ehealth_connector.common.Identificator;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class IntendedRecipient. <div class="en">The recipient MUST be the
 * Quality Control Center (QKZ)</div> <div class="de">Als Empfänger MUSS das QKZ
 * deklariert werden.</div>
 */
public class IntendedRecipient extends org.ehealth_connector.common.IntendedRecipient {

	/**
	 * Instantiates a new intended recipient.
	 */
	public IntendedRecipient() {
		super();
	}

	/**
	 * Instantiates a new intended recipient.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public IntendedRecipient(org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements. This constructor will
	 * set: ClinicalDocument/informationRecipient/intendedRecipient/
	 * informationRecipient/addr = NASK
	 * ClinicalDocument/informationRecipient/intendedRecipient/
	 * informationRecipient/telecom = NASK
	 *
	 * @param recipient
	 *            the recipient
	 */
	public IntendedRecipient(QualabQcc recipient) {
		addId(recipient);

		// addr = NASK
		final AD ad = DatatypesFactory.eINSTANCE.createAD();
		ad.setNullFlavor(NullFlavor.NASK);
		getIntendedRecipient().getIntendedRecipient().getAddrs().add(ad);

		// telecoms = NASK
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.MSK);
		getIntendedRecipient().getIntendedRecipient().getTelecoms().add(tel);
	}

	/**
	 * Assigns the id of the given recipient.
	 *
	 * @param recipient
	 *            the recipient
	 */
	public void addId(QualabQcc recipient) {
		final Identificator id = Identificator.convertToIdentificator(recipient.getCode());
		getIntendedRecipient().getIntendedRecipient().getIds().add(id.getIi());
	}

	/**
	 * <div class="en">Gets all ids of the author</div> <div class="de">Liefert
	 * alle IDs des Autoren</div> <div class="fr"></div> <div class="it"></div>.
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<QualabQcc> getIdsEnum() {
		final List<QualabQcc> iil = new ArrayList<QualabQcc>();
		for (final II ii : getIntendedRecipient().getIntendedRecipient().getIds()) {
			if (QualabQcc.getEnum(ii.getExtension()) != null) {
				iil.add(QualabQcc.getEnum(ii.getExtension()));
			}
		}
		return iil;
	}
}
