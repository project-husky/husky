package org.ehealth_connector.cda;

import org.openhealthtools.mdht.uml.cda.Procedure;

public class MdhtProcedureFacade<E extends Procedure> extends MdhtFacade<E> {

	protected MdhtProcedureFacade(E mdht) {
		super(mdht, null, null);
	}
}
