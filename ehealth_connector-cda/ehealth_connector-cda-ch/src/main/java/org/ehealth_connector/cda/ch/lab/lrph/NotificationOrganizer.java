package org.ehealth_connector.cda.ch.lab.lrph;

import org.ehealth_connector.common.enums.StatusCode;

class NotificationOrganizer extends org.ehealth_connector.cda.ihe.lab.NotificationOrganizer {
	protected NotificationOrganizer() {
		super();
		setStatusCode(StatusCode.COMPLETED);
	}

	protected NotificationOrganizer(
			org.openhealthtools.mdht.uml.cda.ihe.lab.NotificationOrganizer mdht) {
		super(mdht);
	}

	protected OutbreakIdentificationObservation getOutbreakIdentificationObservation() {
		return new OutbreakIdentificationObservation(getMdht().getOutbreakIdentifications().get(0));
	}

	protected void setOutbreakIdentification(
			OutbreakIdentificationObservation outbreakIdentification) {
		getMdht().addObservation(outbreakIdentification.copy());
	}
}
