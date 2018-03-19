/*
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
package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipType;

/**
 * The Class ReferenceRange. A reference range or reference interval is the
 * range of values for a physiologic measurement in persons
 */
public class ReferenceRange extends ObservationRange {

	/** The MDHT Reference Range. */
	private org.openhealthtools.mdht.uml.cda.ReferenceRange mRr;

	/**
	 * Instantiates a new reference range.
	 */
	public ReferenceRange() {
		super();
		mRr = CDAFactory.eINSTANCE.createReferenceRange();
		mRr.setObservationRange(getObsR());
		mRr.setTypeCode(ActRelationshipType.REFV);
		this.setInterpretation(ObservationInterpretation.NORMAL);
	}

	/**
	 * Instantiates a new reference range.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ReferenceRange(org.openhealthtools.mdht.uml.cda.ReferenceRange mdht) {
		super(mdht.getObservationRange());
		this.mRr = mdht;
	}

	/**
	 * Instantiates a new reference range.
	 *
	 * @param value
	 *            the value
	 * @param interpretationCode
	 *            the interpretation code
	 */
	public ReferenceRange(Value value, ObservationInterpretation interpretationCode) {
		this();
		setValue(value);
		setInterpretation(interpretationCode);
	}

	/**
	 * Copy.
	 *
	 * @return the org.openhealthtools.mdht.uml.cda. reference range
	 */
	public org.openhealthtools.mdht.uml.cda.ReferenceRange copy() {
		return EcoreUtil.copy(mRr);
	}

	/**
	 * Gets the mdht.
	 *
	 * @return the mdht
	 */
	public org.openhealthtools.mdht.uml.cda.ReferenceRange getMdht() {
		return mRr;
	}

	/**
	 * Returns narrative string.
	 *
	 * @return the Reference Range as narrative String
	 */
	public String toNarrativeString() {
		String retVal = "";
		String value = "";
		String lowValue = "";
		String lowUnit = "";
		String highValue = "";
		String highUnit = "";

		IVL_PQ tempIvl = null;
		if (mRr != null)
			if (mRr.getObservationRange() != null)
				if (mRr.getObservationRange().getValue() != null) {
					if (mRr.getObservationRange().getValue() instanceof IVL_PQ)
						tempIvl = (IVL_PQ) mRr.getObservationRange().getValue();
					if (mRr.getObservationRange().getValue() instanceof BL)
						value = ((BL) mRr.getObservationRange().getValue()).getValue().toString();
				}
		if (tempIvl != null) {
			lowValue = tempIvl.getLow().getValue().toString();
			lowUnit = tempIvl.getLow().getUnit();
			highValue = tempIvl.getHigh().getValue().toString();
			highUnit = tempIvl.getHigh().getUnit();
		}
		if (!"".equals(value)) {
			retVal = value;
		} else {
			if (!"".equals(lowUnit))
				lowUnit = " " + lowUnit;
			if (!"".equals(highUnit))
				highUnit = " " + highUnit;

			if (lowUnit.equals(highUnit))
				retVal = lowValue + " - " + highValue + lowUnit;
			else
				retVal = lowValue + lowUnit + " - " + highValue + highUnit;
		}

		return retVal;
	}
}
