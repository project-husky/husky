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

package org.ehealth_connector.cda.ch;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.ch.enums.MedicationsSpecialConditions;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.PreconditionEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * <div class="en">This element contains the recommended immunizations for the
 * patient. It can also hold a reference to according</div> Dieses Element
 * enthält den empfohlenen Impfplan für den Patienten. Zudem kann zur Begründung
 * ein Verweis auf entsprechende Guidelines angegeben werden. Dieses Kapitel ist
 * KONDITIONAL und nur dann erforderlich, wenn es sich beim Dokument um die
 * Antwort aus einem Expertensystem für Impfempfehlungen handelt (Clinical
 * Decision Support System; CDSS) oder wenn beabsichtigte aber noch nicht
 * erfolgte Impfungen dokumentiert werden.
 */
public class ImmunizationRecommendation extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation> {

	/**
	 * Instantiates a new immunization recommendation.
	 */
	public ImmunizationRecommendation() {
		super(CHFactory.eINSTANCE.createImmunizationRecommendation().init(), CdaCh.OID_V1, "CDA-CH.Body.MediL3");

		setRouteOfAdministration(null);
		setDosage(null);
		setPriorityCode(createPriorityCode());
	}

	/**
	 * Instantiates a new immunization recommendation.
	 * 
	 * @param consumable
	 *            recommended vaccine
	 * @param author
	 *            author of this entry
	 * @param startOfPossibleAppliance
	 *            start of applicance for this immunization
	 * @param endOfPossibleAppliance
	 *            end of applicance for this immunization
	 * @param intendedOrProposed
	 *            if immunization is intended and or proposed
	 * @param shallNotBeAdministerd
	 *            if immunization should not be administred
	 */
	public ImmunizationRecommendation(Consumable consumable, org.ehealth_connector.common.Author author, Date startOfPossibleAppliance,
			Date endOfPossibleAppliance, boolean intendedOrProposed, boolean shallNotBeAdministerd) {

		this();
		if (intendedOrProposed) {
			setIntended();
		} else {
			setProposed();
		}

		// Set the Attributes of this class
		addId(null);
		setShallNotBeAdministerd(shallNotBeAdministerd);
		setPossibleAppliance(startOfPossibleAppliance, endOfPossibleAppliance);
		setAuthor(author);
		setConsumable(consumable);
	}

	/**
	 * Instantiates a new immunization recommendation.
	 * 
	 * @param immunizationRecommendation
	 *            <br>
	 *            <div class="de">Impfempfehlung</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public ImmunizationRecommendation(org.openhealthtools.mdht.uml.cda.ch.ImmunizationRecommendation immunizationRecommendation) {
		super(immunizationRecommendation);
	}

	/**
	 * Adds the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		final II ii = CdaUtil.createUuidVacdIdentificator(id);
		this.getMdht().getIds().add(ii);
	}

	/**
	 * Adds the medication target entry.
	 * 
	 * @param medicationTargetEntry
	 *            the medication target entry
	 */
	public void addMedicationTargetEntry(MedicationTargetEntry medicationTargetEntry) {

		this.getMdht().addObservation(medicationTargetEntry.getMdht());
		// need to add the the RSON and inversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getObservation() == medicationTargetEntry.getMdht()) {
				entryRelationShip.setInversionInd(false);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
			}
		}
	}

	/**
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public org.ehealth_connector.common.Author getAuthor() {
		if (getMdht().getAuthors().size() > 0) {
			return new Author(this.getMdht().getAuthors().get(0));
		}
		return null;
	}

	/**
	 * Gets the comment entry.
	 * 
	 * @return the comment entry
	 */
	public SectionAnnotationCommentEntry getCommentEntry() {
		if (this.getMdht().getComment() != null) {
			return new SectionAnnotationCommentEntry(this.getMdht().getComment());
		}
		return null;
	}

	/**
	 * Gets the reference to the comment in the level 2 section text.
	 * 
	 * @return the reference of the level 3 comment entry, which points to the
	 *         level 2 text
	 */
	public String getCommentRef() {
		return Util.getCommentRef(getMdht().getEntryRelationships());
	}

	/**
	 * Gets the text of the comment text element (this is not necessarily the
	 * comment itself).
	 * 
	 * @return the comment text
	 */
	public String getCommentText() {
		return Util.getCommentText(getMdht().getEntryRelationships());
	}

	/**
	 * Gets the consumable.
	 * 
	 * @return the consumable
	 */
	public Consumable getConsumable() {
		if (this.getMdht().getConsumable() != null) {
			final Consumable consumable = new Consumable(getMdht().getConsumable());
			return consumable;
		}
		return null;
	}

	/**
	 * gets the criterion entry.
	 * 
	 * @return the criterion entry
	 */
	public CriterionEntry getCriterionEntry() {
		final EList<Precondition> preconditions = getMdht().getPreconditions();
		if (preconditions.size() > 0) {
			return new CriterionEntry(preconditions.get(0).getCriterion());
		}
		return null;
	}

	/**
	 * Gets the dose.
	 * 
	 * @return the dose
	 */
	public Value getDosage() {
		if (getMdht().getDoseQuantity() != null) {
			final Value value = new Value(getMdht().getDoseQuantity());
			return value;
		}
		return null;
	}

	/**
	 * Gets the external document entry.
	 * 
	 * @return the external document entry
	 */
	public ExternalDocumentEntry getExternalDocumentEntry() {
		if (getMdht().getReferences().size() > 0) {
			final Reference reference = this.getMdht().getReferences().get(0);
			return new ExternalReferenceEntry((org.openhealthtools.mdht.uml.cda.ch.CDACHBodyExtRef) reference).getExternalDocumentEntry();
		}
		return null;
	}

	/**
	 * Gets the id of immunization of the software which registred it (see
	 * evadoc 7.5.8.5/7.5.1.5)
	 * 
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getIds() != null) && (getMdht().getIds().size() > 0)) {
			id = new Identificator(getMdht().getIds().get(0));
		}
		return id;
	}

	/**
	 * <div class="en">Gets wheater an immuinzation is intented but not
	 * administered, yet (moodCode:INT).</div> <div class="de">Liefert die
	 * Information, ob eine Impfung beabsichtigt, aber noch nicht erfolgt ist
	 * (moodCode:INT).</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return <div class="en">true, if the immunization is intendet, but not
	 *         administered, yet. false, otherwise</div><div class="de">true,
	 *         wenn eine Impfung beabsichtigt, aber noch nicht erfolgt ist.
	 *         Sonst: false</div>
	 */
	public boolean getIntended() {
		return getMdht().getMoodCode().equals(x_DocumentSubstanceMood.INT);
	}

	/**
	 * Gets the medication target entries.
	 * 
	 * @return the medication target entries
	 */
	public List<MedicationTargetEntry> getMedicationTargetEntries() {
		final List<MedicationTargetEntry> medicationTargetEntries = new ArrayList<MedicationTargetEntry>();
		for (final org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry mte : getMdht().getMedicalTargets()) {
			medicationTargetEntries.add(new MedicationTargetEntry(mte));
		}
		return medicationTargetEntries;
	}

	/**
	 * Gets the possible appliance.
	 * 
	 * @return the possible appliance YYYYmmdd resolution
	 */
	public Date getPossibleAppliance() {
		return this.getPossibleApplianceStartDate();
	}

	/**
	 * Gets the possible appliance end date.
	 * 
	 * @return the possible appliance end date YYYYmmdd resolution
	 */
	public Date getPossibleApplianceEndDate() {
		Date retVal = null;
		if (getMdht().getEffectiveTimes().size() > 0) {
			final SXCM_TS effectiveTime = getMdht().getEffectiveTimes().get(0);
			if (effectiveTime instanceof IVL_TS) {
				final IVL_TS effectiveTimeInterval = (IVL_TS) effectiveTime;
				if ((effectiveTimeInterval.getHigh() != null) && (effectiveTimeInterval.getHigh().getValue() != null)) {
					retVal = DateUtil.parseDateyyyyMMdd(effectiveTimeInterval.getHigh().getValue());
				}
			} else {
				if (effectiveTime instanceof TS) {
					retVal = DateUtil.parseDateyyyyMMdd(effectiveTime.getValue());
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the possible appliance start date.
	 * 
	 * @return the possible appliance start date YYYYmmdd resolution
	 */
	public Date getPossibleApplianceStartDate() {
		Date retVal = null;
		if (getMdht().getEffectiveTimes().size() > 0) {
			final SXCM_TS effectiveTime = getMdht().getEffectiveTimes().get(0);
			if (effectiveTime instanceof IVL_TS) {
				final IVL_TS effectiveTimeInterval = (IVL_TS) effectiveTime;
				retVal = DateUtil.parseDateyyyyMMdd(effectiveTimeInterval.getLow().getValue());
			} else {
				if (effectiveTime instanceof TS) {
					retVal = DateUtil.parseDateyyyyMMdd(effectiveTime.getValue());
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the timespan, in which the immunization shall be
	 * administered as String (e.g. "01.01.2015 - 01.03.2015")</div>
	 * <div class="de">Liefert, den Zeitraum, in dem die Impfung verabreicht
	 * werden soll als String (z.B. "01.01.2015 - 01.03.2015")</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return <div class="de">Zeitraum, in dem die Impfung verabreicht werden
	 *         soll als String</div> <div class="fr"></div>
	 *         <div class="it"></div>
	 */
	public String getPossibleApplianceString() {
		final List<SXCM_TS> effectiveTimes = getMdht().getEffectiveTimes();
		return DateUtil.convertSXCM_TSToEurString(effectiveTimes);
	}

	/**
	 * A set of codes (e.g., for routine, emergency), specifying the urgency
	 * under which the Act happened, can happen, is happening, is intended to
	 * happen, or is requested/demanded to happen. Codesystem:
	 * 2.16.840.1.113883.5.7
	 * 
	 * @return priorityCode
	 */
	public Code getPriorityCode() {
		return new Code(getMdht().getPriorityCode());
	}

	/**
	 * <div class="en">Gets the information, if an immunization is proposed
	 * (moodCode:PRP)</div> <div class="de">Liefert, die Information, ob eine
	 * Impfung vorgeschlagen ist (moodCode:PRP).</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @return true, wenn eine Impfung vorgeschlagen ist. Sonst: false
	 */
	public boolean getProposed() {
		return getMdht().getMoodCode().equals(x_DocumentSubstanceMood.PRP);
	}

	/**
	 * Gets the route of administration.
	 * 
	 * @return the route of administration
	 */
	public RouteOfAdministration getRouteOfAdministration() {
		return RouteOfAdministration.getEnum(getMdht().getRouteCode().getCode());
	}

	/**
	 * Gets the text reference.
	 * 
	 * @return the text reference
	 */
	public String getTextReference() {
		if ((this.getMdht().getText() != null) && (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * returns if is the immunization was administered
	 * 
	 * @return true, if is undesired
	 */
	public boolean isAdministered() {
		return !getMdht().getNegationInd().booleanValue();
	}

	/**
	 * Checks if is the immunization is not desired
	 * 
	 * @return true, if is undesired
	 */
	public boolean isUndesired() {
		return this.getMdht().getNegationInd().booleanValue();
	}

	/**
	 * Sets the administered.
	 */
	public void setAdministered() {
		this.getMdht().setNegationInd(false);
	}

	/**
	 * Sets the author.
	 * 
	 * @param author
	 *            the new author
	 */
	public void setAuthor(org.ehealth_connector.common.Author author) {
		getMdht().getAuthors().clear();
		getMdht().getAuthors().add(author.getAuthorMdht());

	}

	/**
	 * Sets a special code that explains the absence of immunizations in this
	 * document.
	 * 
	 * @param specialCode
	 *            expresses a special condition for this element
	 */
	public void setCode(MedicationsSpecialConditions specialCode) {
		this.getMdht().setCode(specialCode.getCD());
		this.getMdht().setStatusCode(StatusCode.ACTIVE.getCS());
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.UNK);
		this.getMdht().setPriorityCode(ce);
		this.getMdht().setDoseQuantity(Util.createIVL_PQNullFlavorUNK());
		this.getMdht().getEffectiveTimes().add(DateUtil.createSTCM_TS(new Date()));
		this.getMdht().getIds().add(CdaUtil.createUuidVacd(null));
		final Consumable c = new Consumable(false);
		setConsumable(c);
	}

	/**
	 * Sets the comment entry.
	 * 
	 * @param commentEntry
	 *            the new comment entry
	 */
	public void setCommentEntry(SectionAnnotationCommentEntry commentEntry) {
		this.getMdht().addAct(commentEntry.getMdht());
		// need to add the the Subj and inversiond, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() == commentEntry.getMdht()) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Sets a comment text.
	 * 
	 * @param text
	 *            the text
	 */
	public void setCommentText(String text) {
		final SectionAnnotationCommentEntry commentEntry = new SectionAnnotationCommentEntry();
		commentEntry.setAnnotationCommentText(text);
		this.setCommentEntry(commentEntry);
	}

	/**
	 * Sets the consumable.
	 * 
	 * @param consumable
	 *            the new consumable
	 */
	public void setConsumable(Consumable consumable) {
		getMdht().setConsumable(consumable.getMdht());
	}

	/**
	 * Sets the criterion entry.
	 * 
	 * @param citerionEntry
	 *            the new criterion entry
	 */
	public void setCriterionEntry(CriterionEntry citerionEntry) {
		this.getMdht().getPreconditions().clear();
		final PreconditionEntry preconditionEntry = CHFactory.eINSTANCE.createPreconditionEntry().init();
		preconditionEntry.setCriterion(citerionEntry.getMdht());
		this.getMdht().getPreconditions().add(preconditionEntry);
	}

	/**
	 * Sets the dosage.
	 * 
	 * @param doseQuantity
	 *            the new dosage (use null, if not known)
	 */
	public void setDosage(Double doseQuantity) {
		if (doseQuantity == null) {
			getMdht().setDoseQuantity(Util.createIVL_PQNullFlavorUNK());
		} else {
			final IVL_PQ ivl_pq = DatatypesFactory.eINSTANCE.createIVL_PQ();
			ivl_pq.setUnit("ml");
			ivl_pq.setValue(doseQuantity);
			getMdht().setDoseQuantity(ivl_pq);
		}
	}

	/**
	 * Sets the external document entry.
	 * 
	 * @param externalDocumentEntry
	 *            the new external document entry
	 */
	public void setExternalDocumentEntry(ExternalDocumentEntry externalDocumentEntry) {
		getMdht().getReferences().clear();
		final ExternalReferenceEntry externalReference = new ExternalReferenceEntry();
		externalReference.setExternalDocumentEntry(externalDocumentEntry);
		getMdht().getReferences().add(externalReference.getMdht());
	}

	/**
	 * Sets the id of immunization from the software which created it.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		this.getMdht().getIds().add(id.getIi());
	}

	/**
	 * Sets the information that the immunization is intended but not yed
	 * administred
	 */
	public void setIntended() {
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.INT);
	}

	/**
	 * Sets the possible appliance.
	 * 
	 * @param startOfPossibleAppliance
	 *            the new possible appliance date YYYYmmdd resolution
	 */
	public void setPossibleAppliance(Date startOfPossibleAppliance) {
		getMdht().getEffectiveTimes().clear();
		final SXCM_TS timestamp = DatatypesFactory.eINSTANCE.createSXCM_TS();
		timestamp.setValue(DateUtil.formatDate(startOfPossibleAppliance));
		getMdht().getEffectiveTimes().add(timestamp);
	}

	/**
	 * <div class="de">Setzt, den Zeitraum, in dem die Impfung verabreicht
	 * werden soll.</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param startOfPossibleAppliance
	 *            <br>
	 *            <div class="de">Startpunkt des Zeitraumes, wann die Impfung
	 *            verabreicht werden soll.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 * @param endOfPossibleAppliance
	 *            <div class="de">Endpunkt des Zeitraumes, wann die Impfung
	 *            verabreicht werden soll.</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setPossibleAppliance(Date startOfPossibleAppliance, Date endOfPossibleAppliance) {
		getMdht().getEffectiveTimes().clear();
		this.getMdht().getEffectiveTimes().add(0, DateUtil.createSTCM_TS(startOfPossibleAppliance, endOfPossibleAppliance));
	}

	/**
	 * A set of codes (e.g., for routine, emergency), specifying the urgency
	 * under which the Act happened, can happen, is happening, is intended to
	 * happen, or is requested/demanded to happen. Codesystem:
	 * 2.16.840.1.113883.5.7
	 * 
	 * @param priorityCode
	 *            the priority code
	 */
	public void setPriorityCode(Code priorityCode) {
		getMdht().setPriorityCode(priorityCode.getCE());
	}

	/**
	 * <div class="en">Sets the information that an immunization is proposed
	 * (moodCode:PRP)</div> <div class="de">Setzt, die Information, dass eine
	 * Impfung vorgeschlagen ist (moodCode:PRP).</div> <div class="fr"></div>
	 * <div class="it"></div>
	 */
	public void setProposed() {
		this.getMdht().setMoodCode(x_DocumentSubstanceMood.PRP);
	}

	/**
	 * Optionally, one can set the route code (Einnahmearten). If not set,
	 * 'routeCode nullFlavor="UNK"' is written to CDA document.
	 * 
	 * @param routeCode
	 *            the new route of administration
	 */
	public void setRouteOfAdministration(RouteOfAdministration routeCode) {
		if (routeCode == null) {
			final CE ce = DatatypesFactory.eINSTANCE.createCE();
			ce.setNullFlavor(NullFlavor.NA);
			getMdht().setRouteCode(ce);
		} else {
			getMdht().setRouteCode(routeCode.getCE());
		}
	}

	/**
	 * <div class="en">Sets the information, wheater an immunization shall not
	 * be administered</div> <div class="de">Gibt an, ob eine Impfung nicht
	 * verabreicht werden soll.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @param shallNotBeAdministerd
	 *            <div class="en">true, if the immunization shall not be
	 *            administered. false, otherwise.</div> <div class="de">true,
	 *            wenn die Impfung nicht verabreicht werden soll, sonst
	 *            false</div> <div class="fr"></div> <div class="it"></div>
	 */
	public void setShallNotBeAdministerd(boolean shallNotBeAdministerd) {
		if (shallNotBeAdministerd) {
			this.getMdht().setNegationInd(true);
		} else {
			this.getMdht().setNegationInd(false);
		}
	}

	/**
	 * Creates the reference to the section.
	 * 
	 * @param prefix
	 *            the prefix
	 */
	public void setTextReference(String prefix) {
		this.getMdht().setText(Util.createReference(prefix));
	}

	/**
	 * Sets if the immunization is not desired.
	 */
	public void setUndesired() {
		this.getMdht().setNegationInd(true);
	}

	/**
	 * Creates the priority code.
	 * 
	 * @return the code
	 */
	private Code createPriorityCode() {
		final CD priorityCode = DatatypesFactory.eINSTANCE.createCD();
		priorityCode.setNullFlavor(NullFlavor.UNK);
		return new Code(priorityCode);
	}

}
