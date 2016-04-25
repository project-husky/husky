package org.ehealth_connector.fhir.ch;

import org.ehealth_connector.cda.ch.lab.lrqc.CdaChLrqc;

import ca.uhn.fhir.model.dstu2.resource.Bundle;

public class FhirCdaChLrqc {
	public static class LrqcDocument extends Bundle {
	}

	public CdaChLrqc createCdaChLrqcFromFHIRBundle(LrqcDocument lrphDocument, String styleSheet,
			String css) {
		// TODO Auto-generated method stub
		return null;
	}

	public LrqcDocument readLrqcDocumentFromFile(String inputFn) {
		// TODO Auto-generated method stub
		return null;
	}
}
