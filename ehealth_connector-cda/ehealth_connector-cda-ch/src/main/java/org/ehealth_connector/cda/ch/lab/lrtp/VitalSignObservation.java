package org.ehealth_connector.cda.ch.lab.lrtp;

import org.ehealth_connector.cda.AbstractVitalSignObservation;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.common.Identificator;

public class VitalSignObservation extends AbstractVitalSignObservation {

	/**
	 * Instantiates a new vital sign observation.
	 */
	public VitalSignObservation() {
		initMdht();
	}

	@Override
	protected void initMdht() {
		super.initMdht();
		Identificator id = new Identificator(AbstractCdaCh.OID_V1, "CDA-CH.Body.VitalSignL3");
		mVitalSignObservation.getTemplateIds().add(id.getIi());
	}
}
