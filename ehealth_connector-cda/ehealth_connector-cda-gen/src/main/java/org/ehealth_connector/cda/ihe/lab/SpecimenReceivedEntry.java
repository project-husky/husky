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
package org.ehealth_connector.cda.ihe.lab;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtEntryActFacade;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.utils.DateUtilOld;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class SpecimenReceivedEntry. Specimen Received, when present, SHALL be
 * recorded under the Specimen Act in an entryRelationship under the Specimen
 * Collection Procedure.
 */
public class SpecimenReceivedEntry
		extends MdhtEntryActFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived> {

	/**
	 * Instantiates a new specimen received entry.
	 */
	public SpecimenReceivedEntry() {
		super(LABFactory.eINSTANCE.createSpecimenReceived().init());
	}

	/**
	 * Instantiates the class with the required elements for LRQC.
	 *
	 * @param effectiveTime
	 *            the effectiveTime
	 * @param id
	 *            the id. If null, it will be set to NullFlavor.UNK
	 */
	public SpecimenReceivedEntry(Date effectiveTime, Identificator id) {
		this();
		setEffectiveTime(effectiveTime);
		addId(id);
	}

	/**
	 * Instantiates a new specimen received entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public SpecimenReceivedEntry(SpecimenReceived mdht) {
		super(mdht);
	}

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the id
	 */
	public void addId(Identificator id) {
		if (id != null) {
			getMdht().getIds().add(id.getIi());
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(NullFlavor.ASKU);
			getMdht().getIds().add(ii);
		}
	}

	/**
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public Date getEffectiveTime() {
		return DateUtilOld.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
	}

	/**
	 * Gets the ids.
	 *
	 * @return the ids
	 */
	public List<Identificator> getIds() {
		return Util.convertIds(getMdht().getIds());
	}

	/**
	 * Sets the effective time.
	 *
	 * @param effectiveTime
	 *            the new effective time
	 */
	public void setEffectiveTime(Date effectiveTime) {
		getMdht().setEffectiveTime(DateUtilOld.convertDateToIvlTsyyyyMMddHHmmssZZZZ(effectiveTime));
	}
}
