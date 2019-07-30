/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.cda.ihe.pharm;

import java.util.ArrayList;
import java.util.Date;

import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.enums.RouteOfAdministration;
import org.ehealth_connector.cda.ihe.pharm.enums.SubstanceAdminSubstitution;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.PharmSubjectOf4;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionPermission;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassSupply;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * Implements the IHE SeverityOfConcernEntry.
 */
public class SubstanceAdministration
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.SubstanceAdministration> {

	public static final String APPROACH_SITE_CODE_SYSTEM_OID = "2.16.840.1.113883.6.96";
	public static final String APPROACH_SITE_CODE_SYSTEM_NAME = "SNOMED CT";

	private LanguageCode languageCode;

	/**
	 * Instantiates a new Substance Administration entity - wrapper for the MDHT
	 * class
	 */
	public SubstanceAdministration() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new Substance Administration entity - wrapper for the MDHT
	 * class
	 */
	public SubstanceAdministration(LanguageCode languageCode) {
		super(CdaUtil.getMdhtCdaFactoryInstance().createSubstanceAdministration());
		this.getMdht().getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.2", "IHE PHARM").getIi());
		this.getMdht().getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "IHE PHARM").getIi());
		this.getMdht().getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.24", "HL7 CCD").getIi());
		this.getMdht().getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7", "IHE PHARM").getIi());
		this.getMdht().getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.6", "IHE PHARM").getIi());

		this.getMdht().setClassCode(ActClass.SBADM);
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);
		this.getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
		this.languageCode = languageCode;
	}

	/**
	 * Instantiates a new Substance Administration entity from a MDHT document
	 *
	 * @param mdht
	 *            Substance administration
	 */
	public SubstanceAdministration(org.openhealthtools.mdht.uml.cda.SubstanceAdministration mdht) {
		super(mdht, null, null);
	}

	/**
	 * Adds an author to the authors list
	 *
	 * @param author
	 *            Author to add to the list
	 *
	 */
	public void addAuthor(org.ehealth_connector.common.mdht.Author author) {

		this.getMdht().getAuthors().add(author.getAuthorMdht());

	}

	/**
	 * Adds an effective time
	 *
	 * @param effectiveTime
	 *            Effective time
	 */
	public void addEffectiveTime(SXCM_TS effectiveTime) {
		this.getMdht().getEffectiveTimes().add(effectiveTime);
	}

	/**
	 * Adds an id
	 *
	 * @param id
	 *            ID to add
	 */
	public void addId(String id) {
		if (id == null) {
			this.getMdht().getIds().clear();
			this.getMdht().getIds()
					.add(CdaUtil.getMdhtDatatypesFactoryInstance().createII(NullFlavor.NA));
		} else {
			this.getMdht().getIds().add(DatatypesFactory.eINSTANCE.createII(id));
		}

	}

	/**
	 * Defines the possible substitutions
	 *
	 * @param substanceAdminSubstitution
	 *            Posisble substitution
	 *
	 */
	public void addPossibleSubstitution(LanguageCode languageCode,
			SubstanceAdminSubstitution substanceAdminSubstitution) {

		final EntryRelationship possibleSubstitution = CDAFactory.eINSTANCE
				.createEntryRelationship();

		possibleSubstitution.setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		final Supply substitutionSupply = CDAFactory.eINSTANCE.createSupply();
		substitutionSupply.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.9", "").getIi());
		substitutionSupply.setClassCode(ActClassSupply.SPLY);
		substitutionSupply.setMoodCode(x_DocumentSubstanceMood.RQO);
		substitutionSupply.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));

		final PharmSubjectOf4 subjectOf4 = CDAFactory.eINSTANCE.createPharmSubjectOf4();

		final PharmSubstitutionPermission substitutionPermission = CDAFactory.eINSTANCE
				.createPharmSubstitutionPermission();
		substitutionPermission.setClassCode(ActClassRoot.SUBST);
		substitutionPermission.setMoodCode(ActMood.PERM);

		final CE pharmCode = DatatypesFactory.eINSTANCE.createCE();
		final Code substCode = substanceAdminSubstitution.getCode(languageCode);
		pharmCode.setCodeSystem(substCode.getCodeSystem());
		pharmCode.setCodeSystemName(substCode.getCodeSystemName());
		pharmCode.setCode(substCode.getCode());
		pharmCode.setDisplayName(substCode.getDisplayName());

		substitutionPermission.setCode(pharmCode);

		subjectOf4.setSubstitutionPermission(substitutionPermission);

		substitutionSupply.setSubjectOf4(subjectOf4);

		possibleSubstitution.setSupply(substitutionSupply);

		this.getMdht().getEntryRelationships().add(possibleSubstitution);
	}

	/**
	 * Gets approach site code
	 *
	 */
	public void getApproachSiteCode() {
		// TODO
	}

	/**
	 * Returns the authors
	 *
	 * @return authors list
	 *
	 */
	public ArrayList<org.ehealth_connector.common.mdht.Author> getAuthors() {

		ArrayList<org.ehealth_connector.common.mdht.Author> authors = new ArrayList<org.ehealth_connector.common.mdht.Author>();

		for (final Author mdhtAuthor : this.getMdht().getAuthors()) {
			authors.add(new org.ehealth_connector.common.mdht.Author(mdhtAuthor));
		}

		return authors;

	}

	/**
	 * Gets the consumable section
	 *
	 * @return Consumable or null if none is defined
	 *
	 */
	public Consumable getConsumable() {
		if (this.getMdht().getConsumable() != null) {
			return new Consumable(this.getMdht().getConsumable());
		}
		return null;
	}

	/**
	 * Gets the dose quantity
	 *
	 * @return Dose quantity or null
	 */
	public IVL_PQ getDoseQuantity() {
		return this.getMdht().getDoseQuantity();
	}

	/**
	 * Gets the second - n effective time
	 *
	 * @return 2nd - nth effective time or null
	 */
	public ArrayList<SXCM_TS> getEffectiveTimeList() {

		if (this.getMdht().getEffectiveTimes().size() > 1) {

			ArrayList<SXCM_TS> result = new ArrayList<SXCM_TS>();
			boolean first = true;
			for (SXCM_TS effectiveTime : this.getMdht().getEffectiveTimes()) {
				if (!first)
					result.add(effectiveTime);
				else
					first = false;
			}
			return result;
		}

		return null;
	}

	/**
	 * Gets the possible substitutions
	 *
	 * @return the possible substitutions
	 */
	public Supply getPossibleSubstitution() {

		Supply supply;
		for (final EntryRelationship entryRelationship : getMdht().getEntryRelationships()) {
			if (entryRelationship.getTypeCode()
					.getValue() == x_ActRelationshipEntryRelationship.COMP.getValue()) {
				if ((supply = entryRelationship.getSupply()) != null) {
					if (supply.getClassCode().getValue() == ActClassSupply.SPLY.getValue() && supply
							.getMoodCode().getValue() == x_DocumentSubstanceMood.RQO.getValue()) {
						for (final II templateId : supply.getTemplateIds()) {
							if (templateId.getRoot()
									.equalsIgnoreCase(SubstanceAdminSubstitution.CODE_SYSTEM_OID))
								return supply;
						}
					}
				}
			}
		}

		return null;
	}

	/**
	 * Gets the rate quantity
	 *
	 * @return Rate quantity or null
	 */
	public IVL_PQ getRateQuantity() {
		return this.getMdht().getRateQuantity();
	}

	/**
	 * Returns the Route of Administration code
	 *
	 * @return Code from RouteOfAdministration or null
	 */
	public RouteOfAdministration getRouteOfAdministration() {
		CE code = this.getMdht().getRouteCode();
		if (code == null || code.getCode() == null)
			return null;
		for (RouteOfAdministration route : RouteOfAdministration.values()) {
			if (route.getCode(null).getCode().equalsIgnoreCase(code.getCode()))
				return route;
		}
		return null;
	}

	/**
	 * Gets the first effective time
	 *
	 * @return Initial effective time or null
	 */
	public IVL_TS getStartEndDate() {
		if (this.getMdht().getEffectiveTimes().size() > 0) {
			return (IVL_TS) this.getMdht().getEffectiveTimes().get(0);
		}
		return null;
	}

	/**
	 * Gets the "text" reference content
	 *
	 * @return Reference content
	 */
	@Override
	public String getTextReference() {
		if (this.getMdht().getText() != null)
			return this.getMdht().getText().getCDATA();
		return null;
	}

	/**
	 * Set the Approach Site code with a SNOMED-CT NullFlavor.UNK code (only
	 * text reference)
	 *
	 * @param reference
	 *            Textual reference to approach site code
	 *
	 */
	public void setApproachSiteCode(String reference) {

		final CD approachSiteCode = CdaUtil.getMdhtDatatypesFactoryInstance().createCD();
		approachSiteCode.setNullFlavor(NullFlavor.UNK);
		approachSiteCode.setCodeSystem(APPROACH_SITE_CODE_SYSTEM_OID);
		approachSiteCode.setCodeSystemName(APPROACH_SITE_CODE_SYSTEM_NAME);
		if (reference != null)
			approachSiteCode.setOriginalText(Util.createReference(reference));
		this.getMdht().getApproachSiteCodes().add(approachSiteCode);

	}

	/**
	 * Sets approach site code
	 *
	 * @param code
	 *            Approach site code
	 * @param displayName
	 *            Approach site display name
	 * @param codeSystem
	 *            Used code system
	 * @param codeSystemName
	 *            User code system name
	 * @param reference
	 *            Reference
	 */
	public void setApproachSiteCode(String code, String displayName, String codeSystem,
			String codeSystemName, String reference) {
		final CD approachCode = CdaUtil.getMdhtDatatypesFactoryInstance().createCD();
		if (codeSystem != null)
			approachCode.setCodeSystem(codeSystem);
		if (codeSystemName != null)
			approachCode.setCodeSystem(codeSystemName);
		if (code != null) {
			approachCode.setCode(code);
			if (displayName != null)
				approachCode.setDisplayName(displayName);
		} else {
			approachCode.setNullFlavor(NullFlavor.UNK);
		}
		if (reference != null)
			approachCode.setOriginalText(Util.createReference(reference));
		this.getMdht().getApproachSiteCodes().add(approachCode);
	}

	/**
	 * Sets the consumable section
	 *
	 * @param consumable
	 *            Consumable
	 */
	public void setConsumable(Consumable consumable) {
		this.getMdht().setConsumable(consumable.getMdht());
	}

	/**
	 * Defines the dose quantity - if null, sets a Null Flavor dose quantity
	 *
	 * @param doseQuantity
	 *            Dose quantity
	 */
	public void setDoseQuantity(IVL_PQ doseQuantity) {
		if (doseQuantity == null) {
			final IVL_PQ ivl = CdaUtil.getMdhtDatatypesFactoryInstance().createIVL_PQ();
			ivl.setNullFlavor(NullFlavor.UNK);
			this.getMdht().setDoseQuantity(ivl);
		} else
			this.getMdht().setDoseQuantity(doseQuantity);
	}

	/**
	 * Defines the prescribed amount
	 *
	 * @param quantity
	 *            Amount
	 * @param quantityUnit
	 *            Unit of prescribed amount
	 * @param isPackageAmount
	 *            True if the amount is in terms of packages (no unit will be
	 *            displayed)
	 */
	public void setQuantity(Double quantity, String quantityUnit, String textQuantityUnit,
			boolean isPackageAmount) {

		final EntryRelationship prescribedQty = CdaUtil.getMdhtCdaFactoryInstance()
				.createEntryRelationship();
		prescribedQty.setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		final Supply prescribedQuantity = CdaUtil.getMdhtCdaFactoryInstance().createSupply();
		prescribedQuantity.setClassCode(ActClassSupply.SPLY);
		prescribedQuantity.setMoodCode(x_DocumentSubstanceMood.RQO);
		prescribedQuantity.setIndependentInd(
				CdaUtil.getMdhtDatatypesFactoryInstance().createBL(java.lang.Boolean.FALSE));

		if (quantity == null) {
			PQ quantityPq = CdaUtil.getMdhtDatatypesFactoryInstance().createPQ();
			quantityPq.setNullFlavor(NullFlavor.NA);
			prescribedQuantity.setQuantity(quantityPq);
		} else {
			if (isPackageAmount || quantityUnit == null) {
				prescribedQuantity.setQuantity(CdaUtil.getMdhtDatatypesFactoryInstance()
						.createPQ(quantity.doubleValue(), null));
			} else {
				prescribedQuantity.setQuantity(CdaUtil.getMdhtDatatypesFactoryInstance()
						.createPQ(quantity.doubleValue(), quantityUnit));
			}
			prescribedQuantity.setText(CdaUtil.getMdhtDatatypesFactoryInstance().createED(
					quantity + (textQuantityUnit == null || textQuantityUnit.length() == 0 ? ""
							: " " + textQuantityUnit)));
		}
		prescribedQty.setSupply(prescribedQuantity);

		this.getMdht().getEntryRelationships().add(prescribedQty);
	}

	/**
	 * Defines the dose quantity - if null, sets a null flavored rate quantity
	 *
	 * @param rateQuantity
	 *            Rate quantity
	 */
	public void setRateQuantity(IVL_PQ rateQuantity) {
		if (rateQuantity == null) {
			final IVL_PQ ivl = CdaUtil.getMdhtDatatypesFactoryInstance().createIVL_PQ();
			ivl.setNullFlavor(NullFlavor.UNK);
			this.getMdht().setRateQuantity(ivl);
		} else
			this.getMdht().setRateQuantity(rateQuantity);
	}

	/**
	 * Sets the reason of treatment
	 *
	 * @param reasonRootId
	 *            Reason root code/id
	 *
	 * @param reasonExtensionId
	 *            Reason extension code/id
	 */
	public void setReasonOfTreatment(String reasonRootId, String reasonExtensionId) {

		final org.openhealthtools.mdht.uml.cda.Act reasonOfTreatment = CdaUtil
				.getMdhtCdaFactoryInstance().createAct();
		reasonOfTreatment.setClassCode(x_ActClassDocumentEntryAct.ACT);
		reasonOfTreatment.setMoodCode(x_DocumentActMood.EVN);
		reasonOfTreatment.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.4.1", "IHE PHARM").getIi());

		final Identificator reasonId = new Identificator(reasonRootId, reasonExtensionId);
		reasonOfTreatment.getIds().add(reasonId.getIi());

		final CD nullFlavorCode = CdaUtil.getMdhtDatatypesFactoryInstance().createCD();
		nullFlavorCode.setNullFlavor(NullFlavor.NA);
		reasonOfTreatment.setCode(nullFlavorCode);

		reasonOfTreatment.getEntryRelationships().clear();

		final EntryRelationship reasonEntryRelationship = CdaUtil.getMdhtCdaFactoryInstance()
				.createEntryRelationship();
		reasonEntryRelationship.unsetInversionInd();
		reasonEntryRelationship.setAct(reasonOfTreatment);
		reasonEntryRelationship.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
		this.getMdht().getEntryRelationships().add(reasonEntryRelationship);
	}

	/**
	 * Sets the Route of Administration code
	 *
	 * @param route
	 *            Code from RouteOfAdministration
	 */
	public void setRouteOfAdministration(RouteOfAdministration route) {
		Code routeCode = route.getCode(languageCode);
		routeCode.setCodeSystemName("RouteOfAdministration");
		this.getMdht().setRouteCode(routeCode.getCE());
	}

	/**
	 * Defines the starting and ending date (clear existing ones before)
	 *
	 * This is the first EffectiveTime in the sequence --> list of effective
	 * times is cleared before setting this one
	 *
	 * @param startingDate
	 *            Starting date
	 *
	 * @param endingDate
	 *            Ending date
	 */
	public void setStartEndDate(Date startingDate, Date endingDate) {

		final IVL_TS time = CdaUtil.getMdhtDatatypesFactoryInstance().createIVL_TS();
		time.setLow(DateUtil.createIVXB_TSFromDate(startingDate));
		time.setHigh(DateUtil.createIVXB_TSFromDate(endingDate));

		this.getMdht().getEffectiveTimes().clear();
		this.getMdht().getEffectiveTimes().add(time);
	}

	/**
	 * Defines the starting and ending date (clear existing ones before)
	 *
	 * This is the first EffectiveTime in the sequence --> list of effective
	 * times is cleared before setting this one
	 *
	 * @param effectiveTime
	 *            Initial effective time
	 */
	public void setStartEndDate(IVL_TS effectiveTime) {
		this.getMdht().getEffectiveTimes().clear();

		final IVL_TS time = CdaUtil.getMdhtDatatypesFactoryInstance().createIVL_TS();
		if (effectiveTime.getLow() != null && effectiveTime.getLow().getValue() != null)
			time.setLow(DateUtil.createIVXB_TSFromDate(
					DateUtil.parseDateyyyyMMdd(effectiveTime.getLow().getValue())));
		else
			time.setLow(null);

		if (effectiveTime.getHigh() != null && effectiveTime.getHigh().getValue() != null)
			time.setHigh(DateUtil.createIVXB_TSFromDate(
					DateUtil.parseDateyyyyMMdd(effectiveTime.getHigh().getValue())));
		else
			time.setHigh(null);

		this.getMdht().getEffectiveTimes().add(time);
	}

	/**
	 * Sets the text reference content
	 *
	 * @param text
	 *            Reference content
	 */
	@Override
	public void setTextReference(String text) {
		this.getMdht().setText(Util.createReference("null"));
	}

}
