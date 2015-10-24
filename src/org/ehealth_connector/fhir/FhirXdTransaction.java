/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.fhir;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.communication.AffinityDomain;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Description;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Basic;
import ca.uhn.fhir.model.dstu2.resource.Composition;
import ca.uhn.fhir.model.dstu2.resource.Condition;
import ca.uhn.fhir.model.dstu2.resource.HealthcareService;

/**
 * FhirXdTransaction supports the creation of destination and submission-set from a HL7 FHIR
 * Resource. The content of these resources is not currently documented. They are
 * derived resources from FHIR. These resources may be created by the class
 * org.ehealth_connector.demo.fhir.XDResources. This is currently the one any
 * only way to create valid FHIR document resources for XD Transactions. You may
 * edit these FHIR resources in a text editor in order to change the payload of
 * the resulting objects on your own risk.
 * 
 * @see "https://www.hl7.org/fhir/"
 */
public class FhirXdTransaction {

	/**
	 * The Class VacdDocument.
	 */
	@ResourceDef(name = "Transaction")
	public static class Transaction extends Basic {

		/** The Constant serialVersionUID. */
		//TODO: Neue Konstante, da diese gleich ist wie VacdDocument
		private static final long serialVersionUID = -1316775746486313864L;

		/** The Constant urnUseAsAffinityDomain. */
		public static final String urnUseAsAffinityDomain = "urn:ehealth_connector:FhirExtension:useAsAffinityDomain";

		/** The Constant urnUseAsSubmissionSets. */
		public static final String urnUseAsSubmissionSets = "urn:ehealth_connector:FhirExtension:useAsSubmissionSets";

		/** The affinity domain setting. */
		@Child(name = "affinityDomain", max = 1)
		@Extension(url = urnUseAsAffinityDomain, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "affinityDomain")
		private ResourceReferenceDt affinityDomain;

		/** The submission-sets. */
		@Child(name = "submissionSets", max = Child.MAX_UNLIMITED)
		@Extension(url = urnUseAsSubmissionSets, definedLocally = false, isModifier = true)
		@Description(shortDefinition = "submissionSets")
		private List<ResourceReferenceDt> submissionSets;

		/**
		 * Sets the affinityDomain.
		 *
		 * @param affinityDomain
		 *            the affinityDomain
		 */
		public void setAffinityDomain(HealthcareService affinityDomain) {
			//TODO
//			if (activeProblemConcernEntries == null) {
//				activeProblemConcernEntries = new ArrayList<ResourceReferenceDt>();
//			}
//			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
//			resourceRef.setResource(activeProbemlConcernEntry);
//			this.activeProblemConcernEntries.add(resourceRef);
		}

		/**
		 * Gets the affinityDomain.
		 *
		 * @return the affinity domain
		 */
		public HealthcareService getAffinityDomain() {
//			ArrayList<Condition> list = new ArrayList<Condition>();
//			if (this.activeProblemConcernEntries != null) {
//				for (ResourceReferenceDt resource : this.activeProblemConcernEntries) {
//					list.add((Condition) resource.getResource());
//				}
//			}
//			return list;
			return null;
		}
		
		/**
		 * Adds a submission-set.
		 *
		 * @param submission-set
		 *            the submission-set
		 */
		public void addSubmissionSet(Composition submissionSet){
			if (submissionSets == null) {
				submissionSets = new ArrayList<ResourceReferenceDt>();
			}
			ResourceReferenceDt resourceRef = new ResourceReferenceDt();
			resourceRef.setResource(submissionSet);
			this.submissionSets.add(resourceRef);
		}

		
	};

	/** The m fhir ctx. */
	private final FhirContext mFhirCtx = new FhirContext();

	/**
	 * <div class="en">Empty constructor (default)</div><div class="de"></div>
	 * <div class="fr"></div>.
	 */
	public FhirXdTransaction() {
	}

	/**
	 * Creates the affinity domain setting from fhir bundle.
	 *
	 * @param fhirDoc
	 *            the fhir doc
	 * @return the affinity domain setting
	 */
	public org.ehealth_connector.communication.AffinityDomain createAffinityDomainFromFHIRBundle(Transaction fhirDoc) {

		AffinityDomain ad = new AffinityDomain();
		//TODO

		return ad;
	}

}
