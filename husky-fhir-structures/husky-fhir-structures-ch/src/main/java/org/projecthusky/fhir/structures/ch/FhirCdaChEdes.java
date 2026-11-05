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

package org.projecthusky.fhir.structures.ch;

import org.hl7.fhir.r4.model.Basic;
import org.hl7.fhir.r4.model.Reference;
import org.projecthusky.fhir.structures.gen.FhirCommon;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;

/**
 * Supports the FHIR to eHC conversion for EDES CTNN documents
 *
 */
/* derived from external library */
@SuppressWarnings("java:S110")
public class FhirCdaChEdes {
	
	private FhirCdaChEdes() {
		
	}

	/**
	 * The class EdesCtnnDocument is a derived FHIR resource containing all
	 * information of an Emergency Department Encounter Summary document based
	 * on a Composite Triage and Nursing Note corresponding to the CDA-CH-EDES
	 * specification
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class EdesCtnnDocument extends CdaFhirDocument {

		private static final long serialVersionUID = 7883384366035439713L;

		/** The confidentiality. */
		@Child(name = "confidentiality")
		@Extension(url = FhirCommon.URN_USE_AS_CONFIDENTIALITY, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "confidentiality")
		private Reference confidentiality;

		/**
		 * Gets the confidentiality code.
		 *
		 * @return the confidentiality code
		 */
		public Basic getConfidentiality() {
			if (this.confidentiality != null) {
				return (Basic) this.confidentiality.getResource();
			}
			return null;
		}

		/**
		 * Sets the confidentiality code.
		 *
		 * @param confidentiality
		 *            the new confidentiality code
		 */
		public void setConfidentiality(Basic confidentiality) {
			final var resourceRef = new Reference();
			resourceRef.setResource(confidentiality);
			this.confidentiality = resourceRef;
		}

	}
}
