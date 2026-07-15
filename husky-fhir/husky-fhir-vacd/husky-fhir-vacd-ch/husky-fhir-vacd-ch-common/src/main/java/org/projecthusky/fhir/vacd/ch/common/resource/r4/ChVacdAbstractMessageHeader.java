package org.projecthusky.fhir.vacd.ch.common.resource.r4;

import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.MessageHeader;

public class ChVacdAbstractMessageHeader extends MessageHeader {

	private static final long serialVersionUID = -4770265487196825537L;

	protected ChVacdAbstractMessageHeader() {
		super();
		this.setId("urn:uuid:" + this.getId());
		if (!this.getReason().hasCoding("http://snomed.info/sct", "830152006")) {
			this.getReason()
					.addCoding(new Coding("http://snomed.info/sct", "830152006", "Recommend vaccination"));
		}

	}

}
