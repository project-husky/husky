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
 * Supports the FHIR to eHC conversion for CDA-CH-LRPH documents
 *
 */
/* derived from external library */
@SuppressWarnings("java:S110")
public class FhirCdaChLr {
	/**
	 * <div class="en">Type of the FHIR resource to define whether the resulting
	 * CDA document contains full or masked patient demographics</div>
	 * <div class="de"></div><div class="fr"></div>
	 */
	public enum DocTypeCode {
		/**
		 * <div class="en">the resulting CDA document contains hiv patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		HIV,
		/**
		 * <div class="en">the resulting CDA document contains full patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		PATIENT,
		/**
		 * <div class="en">the resulting CDA document contains masked patient
		 * demographics</div><div class="de"></div> <div class="fr"></div>
		 */
		PSEUDONYMIZED
	}

	/**
	 * The class FhirCdaChLrph is a derived FHIR resource containing all
	 * information of an LRPH document corresponding to the CDA-CH-LRPH
	 * specification
	 */
	@ResourceDef(name = "DocumentManifest")
	public static class LrphDocument extends CdaFhirDocument {

		private static final long serialVersionUID = 7883384366035439713L;

		/** The informationRecipient. */
		@Child(name = "docInformationRecipient")
		@Extension(url = FhirCommon.URN_USE_AS_INFORMATION_RECIPIENT, definedLocally = false, isModifier = false)
		@Description(shortDefinition = "informationRecipient")
		private Reference informationRecipient;


		/**
		 * Gets the information recipient.
		 *
		 * @return the information recipient
		 */
		public Basic getInformationRecipient() {
			if (this.informationRecipient != null) {
				return (Basic) this.informationRecipient.getResource();
			}
			return null;
		}


		/**
		 * Sets the information recipient.
		 *
		 * @param informationRecipient
		 *            the information recipient
		 */
		public void setInformationRecipient(Basic informationRecipient) {
			final var resourceRef = new Reference();
			resourceRef.setResource(informationRecipient);
			this.informationRecipient = resourceRef;
		}

	}

}
