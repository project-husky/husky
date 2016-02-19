package org.ehealth_connector.common;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.ActRelationshipType;

public class ReferenceRange extends ObservationRange {
	org.openhealthtools.mdht.uml.cda.ReferenceRange mRr;

	public ReferenceRange() {
		super();
		mRr = CDAFactory.eINSTANCE.createReferenceRange();
		mRr.setObservationRange(mObsR);
		mRr.setTypeCode(ActRelationshipType.REFV);
		this.setInterpretationCode(ObservationInterpretation.NORMAL);
	}

	public ReferenceRange(org.openhealthtools.mdht.uml.cda.ReferenceRange mdht) {
		super(mdht.getObservationRange());
		this.mRr = mdht;
	}

	public org.openhealthtools.mdht.uml.cda.ReferenceRange copy() {
		return EcoreUtil.copy(mRr);
	}

	public org.openhealthtools.mdht.uml.cda.ReferenceRange getMdht() {
		return mRr;
	}
}
