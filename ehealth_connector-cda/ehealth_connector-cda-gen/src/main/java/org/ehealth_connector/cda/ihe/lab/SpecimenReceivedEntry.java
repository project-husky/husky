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
package org.ehealth_connector.cda.ihe.lab;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtEntryActFacade;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
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
			ii.setNullFlavor(NullFlavor.UNK);
			getMdht().getIds().add(ii);
		}
	}

	/**
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
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
		getMdht().setEffectiveTime(DateUtil.convertDateToIvlTsyyyyMMddHHmmssZZZZ(effectiveTime));
	}
}
