package org.ehealth_connector.cda;

import org.ehealth_connector.common.enums.StatusCode;
import org.openhealthtools.mdht.uml.cda.Organizer;

public class MdhtOrganizerFacade<E extends Organizer> extends MdhtFacade<E> {

	protected MdhtOrganizerFacade(E mdht) {
		super(mdht, null, null);
	}

	protected StatusCode getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return StatusCode.getEnum(getMdht().getStatusCode().getCode());
		}
		return null;
	}

	protected void setStatusCode(StatusCode statusCode) {
		getMdht().setStatusCode(statusCode.getCS());
	}
}
