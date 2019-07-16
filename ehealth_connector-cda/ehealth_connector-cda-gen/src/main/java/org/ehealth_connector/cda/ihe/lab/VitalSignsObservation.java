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

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.MdhtObservationFacade;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Value;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;

/**
 * The Class VitalSignsObservation. A vital signs observation is a simple
 * observation that uses a specific vocabulary, and inherits constraints from
 * CCD.
 */
public class VitalSignsObservation
		extends MdhtObservationFacade<org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation> {

	/**
	 * Instantiates a new vital signs observation.
	 */
	public VitalSignsObservation() {
		super(IHEFactory.eINSTANCE.createVitalSignObservation().init());
	}

	/**
	 * Instantiates a new vital signs observation.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public VitalSignsObservation(VitalSignObservation mdht) {
		super(mdht);
	}

	/**
	 * Adds the method code.
	 *
	 * @param code
	 *            the code
	 */
	public void addMethodCode(Code code) {
		getMdht().getMethodCodes().add(code.getCE());
	}

	/**
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.MdhtObservationFacade#addValue(org.ehealth_connector.common.mdht.Value)
	 */
	@Override
	public void addValue(Value value) {
		getMdht().getValues().add(value.getValue());
	}

	/**
	 * Gets the method codes.
	 *
	 * @return the method codes
	 */
	public List<Code> getMethodCodes() {
		final List<Code> cl = new ArrayList<Code>();
		for (final CE ce : getMdht().getMethodCodes()) {
			cl.add(new Code(ce));
		}
		return cl;
	}
}
