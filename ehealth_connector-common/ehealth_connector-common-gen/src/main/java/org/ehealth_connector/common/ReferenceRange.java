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
package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipType;

/**
 * The Class ReferenceRange. A reference range or reference interval is the
 * range of values for a physiologic measurement in persons
 */
public class ReferenceRange extends ObservationRange {

	/** The m rr. */
	org.openhealthtools.mdht.uml.cda.ReferenceRange mRr;

	/**
	 * Instantiates a new reference range.
	 */
	public ReferenceRange() {
		super();
		mRr = CDAFactory.eINSTANCE.createReferenceRange();
		mRr.setObservationRange(mObsR);
		mRr.setTypeCode(ActRelationshipType.REFV);
		this.setInterpretationCode(ObservationInterpretation.NORMAL);
	}

	/**
	 * Instantiates a new reference range.
	 *
	 * @param mdht
	 *          the mdht
	 */
	public ReferenceRange(org.openhealthtools.mdht.uml.cda.ReferenceRange mdht) {
		super(mdht.getObservationRange());
		this.mRr = mdht;
	}

	/**
	 * Instantiates a new reference range.
	 *
	 * @param value
	 *          the value
	 * @param interpretationCode
	 *          the interpretation code
	 */
	public ReferenceRange(Value value, ObservationInterpretation interpretationCode) {
		this();
		setValue(value);
		setInterpretationCode(interpretationCode);
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
}
