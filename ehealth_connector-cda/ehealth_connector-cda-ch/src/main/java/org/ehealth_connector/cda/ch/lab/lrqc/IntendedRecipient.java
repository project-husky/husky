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

public class IntendedRecipient extends org.ehealth_connector.common.IntendedRecipient {
	public IntendedRecipient() {
		super();
	}

	/**
	 * Instantiates the class with the required elements. This constructor will
	 * set: ClinicalDocument/informationRecipient/intendedRecipient/
	 * informationRecipient/addr = NASK
	 * ClinicalDocument/informationRecipient/intendedRecipient/
	 * informationRecipient/telecom = NASK
	 *
	 * @param recipient
	 *          the recipient
	 */
	public IntendedRecipient(QualabQcc recipient) {
		addId(recipient);

		// addr = NASK
		AD ad = DatatypesFactory.eINSTANCE.createAD();
		ad.setNullFlavor(NullFlavor.NASK);
		mIntendedRecipient.getIntendedRecipient().getAddrs().add(ad);

		// telecoms = NASK
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.MSK);
		mIntendedRecipient.getIntendedRecipient().getTelecoms().add(tel);
	}

	/**
	 * Assigns the id of the given recipient
	 *
	 * @param recipient
	 *          the recipient
	 */
	public void addId(QualabQcc recipient) {
		Identificator id = Identificator.convertToIdentificator(recipient.getCode());
		mIntendedRecipient.getIntendedRecipient().getIds().add(id.getIi());
	}

	/**
	 * <div class="en">Gets all ids of the author</div> <div class="de">Liefert
	 * alle IDs des Autoren</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the ids</div>
	 */
	public List<QualabQcc> getIdsEnum() {
		ArrayList<QualabQcc> iil = new ArrayList<QualabQcc>();
		for (II ii : mIntendedRecipient.getIntendedRecipient().getIds()) {
			if (QualabQcc.getEnum(ii.getExtension()) != null) {
				iil.add(QualabQcc.getEnum(ii.getExtension()));
			}
		}
		return iil;
	}
}
