/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.common.model;

import jakarta.xml.bind.JAXBElement;

import org.projecthusky.common.enums.ObservationInterpretation;
import org.projecthusky.common.hl7cdar2.BL;
import org.projecthusky.common.hl7cdar2.IVLPQ;
import org.projecthusky.common.hl7cdar2.POCDMT000040ReferenceRange;
import org.projecthusky.common.hl7cdar2.PQ;

/**
 * The Class ReferenceRange. A reference range or reference interval is the range of values for a physiologic
 * measurement in persons
 */
public class ReferenceRange extends ObservationRange {

    /**
     * The Reference Range.
     */
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
     * @param mdht the mdht
     */
    public ReferenceRange(POCDMT000040ReferenceRange mdht) {
        super(mdht.getObservationRange());
        this.mRr = mdht;
    }

    /**
     * Instantiates a new reference range.
     *
     * @param value              the value
     * @param interpretationCode the interpretation code
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

        IVLPQ tempIvl = null;
        if (mRr != null && mRr.getObservationRange() != null && mRr.getObservationRange().getValue() != null) {
			if (mRr.getObservationRange().getValue()instanceof IVLPQ obj)
				tempIvl = obj;
			if (mRr.getObservationRange().getValue()instanceof BL obj)
				value = obj.isValue().toString();
        }

        if (tempIvl != null) {
			value = extractValueFromIvlpq(tempIvl);
		}
        
        if (!value.isEmpty()) {
            retVal = value;
        } 

		return retVal;
	}

	private String extractValueFromIvlpq(IVLPQ tempIvl) {
		var lowValue = "";
		var lowUnit = "";
		var highValue = "";
		var highUnit = "";
		String retVal;
		for (JAXBElement<? extends PQ> pqEl : tempIvl.getRest()) {
			if (pqEl != null && pqEl.getName() != null) {
				if ("low".equalsIgnoreCase(pqEl.getName().getLocalPart())) {
					lowValue = tempIvl.getValue();
					lowUnit = tempIvl.getUnit();
				} else if ("high".equalsIgnoreCase(pqEl.getName().getLocalPart())) {
					highValue = tempIvl.getValue();
					highUnit = tempIvl.getUnit();
                }
            }
		}

		if (lowUnit.isEmpty())
			lowUnit = tempIvl.getUnit();
		if (highUnit.isEmpty())
			highUnit = tempIvl.getUnit();

		if (!lowUnit.isEmpty())
			lowUnit = " " + lowUnit;
		if (!highUnit.isEmpty())
			highUnit = " " + highUnit;

		if (lowUnit.equals(highUnit))
			retVal = lowValue + " - " + highValue + lowUnit;
		else
			retVal = lowValue + lowUnit + " - " + highValue + highUnit;

		return retVal;
    }

}
