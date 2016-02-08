package org.ehealth_connector.cda;

import org.openhealthtools.mdht.uml.cda.Observation;

public class MdhtObservationFacade<E extends Observation> extends MdhtFacade<E> {

	protected MdhtObservationFacade(E mdht) {
		super(mdht, null, null);
	}
}
