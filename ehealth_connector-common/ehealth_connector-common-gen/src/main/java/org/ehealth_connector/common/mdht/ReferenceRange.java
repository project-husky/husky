/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.common.mdht;

import org.ehealth_connector.common.hl7cdar2.POCDMT000040ReferenceRange;
import org.ehealth_connector.common.mdht.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.hl7.datatypes.BL;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;

/**
 * The Class ReferenceRange. A reference range or reference interval is the
 * range of values for a physiologic measurement in persons
 */
public class ReferenceRange extends ObservationRange {

	/** The MDHT Reference Range. */
	private POCDMT000040ReferenceRange mRr;

	/**
	 * Instantiates a new reference range.
	 */
	public ReferenceRange() {
		super();
		mRr = new POCDMT000040ReferenceRange();
		mRr.setObservationRange(getObsR());
		mRr.getTypeCode().clear();
		mRr.getTypeCode().add("REFV");
		this.setInterpretation(ObservationInterpretation.NORMAL);
	}

	/**
	 * Instantiates a new reference range.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public ReferenceRange(POCDMT000040ReferenceRange mdht) {
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
	 * Gets the mdht.
	 *
	 * @return the mdht
	 */
	public POCDMT000040ReferenceRange getMdht() {
		return mRr;
	}

	/**
	 * Returns narrative string.
	 *
	 * @return the Reference Range as narrative String
	 */
	public String toNarrativeString() {
		var retVal = "";
		var value = "";
		var lowValue = "";
		var lowUnit = "";
		var highValue = "";
		var highUnit = "";

		IVL_PQ tempIvl = null;
		if (mRr != null && mRr.getObservationRange() != null && mRr.getObservationRange().getValue() != null) {
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
			if (lowUnit == null)
				lowUnit = tempIvl.getUnit();
			if (highUnit == null)
				highUnit = tempIvl.getUnit();
		}
		if (!value.isEmpty()) {
			retVal = value;
		} else {
			if (!lowUnit.isEmpty())
				lowUnit = " " + lowUnit;
			if (!highUnit.isEmpty())
				highUnit = " " + highUnit;

			if (lowUnit.equals(highUnit))
				retVal = lowValue + " - " + highValue + lowUnit;
			else
				retVal = lowValue + lowUnit + " - " + highValue + highUnit;
		}

		return retVal;
	}
}
