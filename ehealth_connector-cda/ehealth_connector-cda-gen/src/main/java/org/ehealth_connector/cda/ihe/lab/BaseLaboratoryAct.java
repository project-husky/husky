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

import org.ehealth_connector.cda.MdhtActFacade;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * The Class AbstractSpecimenAct.
 */
public class BaseLaboratoryAct extends MdhtActFacade<Act> {

	/**
	 * Instantiates a new abstract specimen act.
	 */
	public BaseLaboratoryAct() {
		super(LABFactory.eINSTANCE.createSpecimenAct().init());
	}

	/**
	 * Instantiates a new abstract specimen act.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public BaseLaboratoryAct(Act mdht) {
		super(mdht);
	}

	/**
	 * Adds the laboratory battery organizer.
	 *
	 * @param laboratoryBatteryOrganizer
	 *            the laboratory battery organizer
	 */
	public void addLaboratoryBatteryOrganizer(
			LaboratoryBatteryOrganizer laboratoryBatteryOrganizer) {
		getMdht().addOrganizer(laboratoryBatteryOrganizer.copy());
		// Set the right type for the entryRelationship
		CdaUtil.setEntryRelationshipTypeCode(getMdht().getEntryRelationships(),
				x_ActRelationshipEntryRelationship.COMP);
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public Code getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return new Code(getMdht().getStatusCode());
		}
		return null;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		if (code != null) {
			getMdht().setCode(code.getCD());
		}
	}

	/**
	 * Sets the status code.
	 *
	 * @param code
	 *            the new status code
	 */
	public void setStatusCode(Code code) {
		getMdht().setStatusCode(code.getCS());
	}

}
