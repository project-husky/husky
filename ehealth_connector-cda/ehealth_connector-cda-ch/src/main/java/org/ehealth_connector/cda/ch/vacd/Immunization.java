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

package org.ehealth_connector.cda.ch.vacd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.cda.enums.MedicationsSpecialConditions;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Performer;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.enums.IdentityDomain;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.Precondition;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.PreconditionEntry;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * <div class="en">This element contains the given immunizations and the
 * immunizations, which are not wanted.</div><div class="de">Dieses Element
 * enthält die verabreichten Impfungen und die ausdrücklich nicht erwünschten
 * Impfungen.</div>
 */
public class Immunization extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ch.Immunization> {

	/**
	 * <div class="en">Creates an object, which represents an
	 * immunization.</div> <div class="de">Erzeugt ein Objekt welches eine
	 * Impfung repräsentiert. Dieser Konstruktor wird verwendet, wenn ein leeres
	 * Object initialisiert werden soll</div>
	 */
	public Immunization() {
		super(CHFactory.eINSTANCE.createImmunization().init(), AbstractCdaCh.OID_V1,
				"CDA-CH.Body.MediL3");
		final EList<II> templateIds = this.getMdht().getTemplateIds();
		boolean foundFirst = false;
		// <templateId root="1.3.6.1.4.1.19376.1.5.3.1.4.12"/> appears twice
		for (final II ii : templateIds) {
			if ("1.3.6.1.4.1.19376.1.5.3.1.4.12".equals(ii.getRoot())) {
				if (foundFirst) {
					templateIds.remove(ii);
				} else {
					foundFirst = true;
				}
			}
		}
		setRouteOfAdministration(null);
		setDosage(null);
		setPriorityCode(createPriorityCode());
	}

	/**
	 * <div class="en">This element contains the administered immunizations and
	 * the immunizations, which are not wanted.</div><div class="de">Dieses
	 * Element enthält die verabreichten Impfungen und die ausdrücklich nicht
	 * erwünschten Impfungen.</div>
	 *
	 * @param consumable
	 *            <div class="en">vaccine</div><div class="de">Impfstoff</div>
	 *
	 * @param author
	 *            <div class="en">Author of the immunization</div>
	 *            <div class="de">Autor der Impfung</div>
	 * @param appliedAt
	 *            <div class="en">date of the immunization</div>
	 *            <div class="de">Datum der Impfung</div>
	 */
	public Immunization(Consumable consumable, Author author, Date appliedAt) {
		this();
		setApplyDate(appliedAt);
		addId(null);
		setConsumable(consumable);
		setAuthor(author);
	}

	/**
	 * <div class="en">This element contains the administered immunizations and
	 * the immunizations, which are not wanted.</div><div class="de">Dieses
	 * Element enthält die verabreichten Impfungen und die ausdrücklich nicht
	 * erwünschten Impfungen.</div>
	 *
	 * @param consumable
	 *            <div class="en">vaccine</div><div class="de">Impfstoff</div>
	 *
	 * @param author
	 *            <div class="en">Author of the immunization</div>
	 *            <div class="de">Autor der Impfung</div>
	 * @param appliedAt
	 *            <div class="en">date of the immunization</div>
	 *            <div class="de">Datum der Impfung</div>
	 * @param route
	 *            <div class="en">route of administration (can be null)</div>
	 *            <div class="de">Einnahmeart (darf null sein)</div>
	 *
	 * @param doseQuantity
	 *            in milliliters (e.g. 0.5) (can be null)
	 */
	public Immunization(Consumable consumable, Author author, Date appliedAt,
			RouteOfAdministration route, Double doseQuantity) {
		this();
		setApplyDate(appliedAt);
		setRouteOfAdministration(route);
		setDosage(doseQuantity);
		addId(null);
		setConsumable(consumable);
		setAuthor(author);
	}

	/**
	 * Erzeugt ein Objekt welches eine Impfung repräsentiert. Dieser Konstruktor
	 * wird verwendet, wenn codiert werden soll, dass keine Impfungen bekannt
	 * sind.
	 *
	 * @param specialCode
	 *            the special code that indicates, why no information is present
	 *            in this element
	 * @param author
	 *            the author of this immunization
	 */
	public Immunization(MedicationsSpecialConditions specialCode, Author author) {
		this();
		setAuthor(author);
		setCode(specialCode);
	}

	/**
	 * Instantiates a new immunization.
	 *
	 * @param immunization
	 *            the immunization
	 */
	public Immunization(org.openhealthtools.mdht.uml.cda.ch.Immunization immunization) {
		super(immunization, null, null);
	}

	/**
	 * Adds the id.
	 *
	 * @param codedId
	 *            the new id
	 */
	public void addId(Identificator codedId) {
		final II ii = CdaChUtil.createUniqueIiFromIdentificator(codedId);
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
	 * Convert date.
	 *
	 * @param appliedAt
	 *            the applied at
	 * @return the sxcm ts
	 */
	private SXCM_TS convertDate(Date appliedAt) {
		final SXCM_TS timestamp = DatatypesFactory.eINSTANCE.createSXCM_TS();
		timestamp.setValue(DateUtil.formatDate(appliedAt));
		return timestamp;
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

	/**
	 * Gets the apply date.
	 *
	 * @return the apply date YYYYmmdd resolution
	 */
	public Date getApplyDate() {
		if ((getMdht().getEffectiveTimes() != null) && (getMdht().getEffectiveTimes().size() > 0)) {
			final SXCM_TS date = getMdht().getEffectiveTimes().get(0);
			return DateUtil.parseDateyyyyMMdd(date.getValue());
		} else {
			return null;
		}
	}

	/**
	 * Returns author of this immunization.
	 *
	 * @return Author
	 */
	public Author getAuthor() {
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
	 * @return the reference of the level 3 comment entry, which point to the
	 *         level 2 text
	 * @deprecated uses setCommentEntry
	 */
	@Deprecated
	public String getCommentRef() {
		return Util.getCommentRef(getMdht().getEntryRelationships());
	}

	/**
	 * Gets the text of the comment text element (this is not necessarily the
	 * comment itself).
	 *
	 * @deprecated use getCommentEntry
	 * @return the comment text
	 */
	@Deprecated
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
	 * @return citerionEntry the new criterion entry
	 */
	public CriterionEntry getCriterionEntry() {
		final EList<Precondition> preconditions = getMdht().getPreconditions();
		if (preconditions.size() > 0) {
			return new CriterionEntry(preconditions.get(0).getCriterion());
		}
		return null;
	}

	/**
	 * Gibt die Dosis der Impfung zurück.
	 *
	 * @return Dosis Dosis der Impfung
	 */
	public Value getDosage() {
		if (getMdht().getDoseQuantity() != null) {
			final Value value = new Value(getMdht().getDoseQuantity());
			return value;
		}
		return null;
	}

	/**
	 * Gets the id of immunization of the software which registred it (see
	 * evadoc 7.5.1.5)
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
	 * Gets the specified id value based on its code system.
	 *
	 * @param codeSystem
	 *            The id's identity domain
	 * @return the id or null if it doesn't exist
	 */
	public Identificator getId(IdentityDomain codeSystem) {
		Identificator ident = null;
		for (final II id : getMdht().getIds()) {
			if (id.getRoot().equalsIgnoreCase(codeSystem.getCodeSystemId())) {
				ident = new Identificator(id);
			}
		}
		return ident;
	}

	/**
	 *
	 * Gets the ids of immunization of the software which registred it (see
	 * evadoc 7.5.1.5)
	 *
	 * @return list of ids
	 */
	public List<Identificator> getIds() {
		final List<Identificator> retVal = new ArrayList<Identificator>();
		if ((getMdht().getIds() != null) && (getMdht().getIds().size() > 0)) {
			for (int i = 0; i < getMdht().getIds().size(); i++) {
				retVal.add(new Identificator(getMdht().getIds().get(i)));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the information, if an immunization is intended, but
	 * not performed, yet. (moodCode:INT).</div> <div class="de">Liefert die
	 * Information, ob eine Impfung beabsichtigt, aber noch nicht erfolgt ist
	 * (moodCode:INT).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en"> true, if an immunization is intended. Otherwise:
	 *         false</div> <div class="de"> true, wenn eine Impfung
	 *         beabsichtigt, aber noch nicht erfolgt ist. Sonst: false</div>
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
		for (final org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry mte : getMdht()
				.getMedicalTargets()) {
			medicationTargetEntries.add(new MedicationTargetEntry(mte));
		}
		return medicationTargetEntries;
	}

	/**
	 * Gets the Performer (Person, die die Impfung durchgeführt hat).
	 *
	 * @return the performer
	 */
	public Performer getPerformer() {
		if ((getMdht().getPerformers() != null) && (this.getMdht().getPerformers().size() > 0)) {
			return new Performer(getMdht().getPerformers().get(0));
		}
		return null;
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
	@Override
	public String getTextReference() {
		if ((this.getMdht().getText() != null)
				&& (this.getMdht().getText().getReference() != null)) {
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
	 * Sets the apply date YYYYmmdd resolution
	 *
	 * @param appliedAt
	 *            the new apply date
	 */
	public void setApplyDate(Date appliedAt) {
		getMdht().getEffectiveTimes().clear();
		getMdht().getEffectiveTimes().add(convertDate(appliedAt));
	}

	/**
	 * Sets the author.
	 *
	 * @param author
	 *            the new author
	 */
	public void setAuthor(Author author) {
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
		getMdht().setCode(specialCode.getCD());
		getMdht().setStatusCode(StatusCode.COMPLETED.getCS());
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.UNK);
		getMdht().setPriorityCode(ce);
		getMdht().setDoseQuantity(Util.createIVL_PQNullFlavorUNK());
		getMdht().getEffectiveTimes().add(DateUtil.createSTCM_TS(new Date()));
		getMdht().getIds().add(CdaChUtil.createUniqueIiFromString(null));
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
		// need to add the the Subj and setInversionInd, cannot do this
		// automatically with mdht
		for (final EntryRelationship entryRelationShip : getMdht().getEntryRelationships()) {
			if (entryRelationShip.getAct() == commentEntry.getMdht()) {
				entryRelationShip.setInversionInd(true);
				entryRelationShip.setTypeCode(x_ActRelationshipEntryRelationship.SUBJ);
			}
		}
	}

	/**
	 * Sets a comment text (not a reference).
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
		final PreconditionEntry preconditionEntry = CHFactory.eINSTANCE.createPreconditionEntry()
				.init();
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
	 * Sets the id of immunization from the software which created it
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		this.getMdht().getIds().add(id.getIi());
	}

	/**
	 * <div class="en">Sets the information that an immunization is intended,
	 * but not performed, yet. (moodCode:INT).</div> <div class="de">Setzt, die
	 * Information, dass eine Impfung beabsichtigt, aber noch nicht erfolgt ist
	 * (moodCode:INT).</div> <div class="fr"></div> <div class="it"></div>
	 *
	 */
	public void setIntended() {
		getMdht().setMoodCode(x_DocumentSubstanceMood.INT);
	}

	/**
	 * Sets the Person, who performs the Immunization.
	 *
	 * @param performer
	 *            the new performer (Convenience Author will be converted to a
	 *            performer)
	 */
	public void setPerformer(Author performer) {
		final Performer2 p2 = CDAFactory.eINSTANCE.createPerformer2();
		getMdht().getPerformers().clear();
		if (performer != null) {
			getMdht().getPerformers().add(p2);

			p2.setAssignedEntity(Util.createAssignedEntityFromAssignedAuthor(
					performer.copyMdhtAuthor().getAssignedAuthor()));
			p2.setTime(performer.getTimeAsIVL_TS());
		}
	}

	/**
	 * Sets the Person, who performs the Immunization.
	 *
	 * @param performer
	 *            the new performer
	 */
	public void setPerformer(Performer performer) {
		getMdht().getPerformers().clear();
		getMdht().getPerformers().add(performer.copyMdhtPerfomer());
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
	 * Creates the reference to the section.
	 *
	 * @param prefix
	 *            the prefix
	 */
	@Override
	public void setTextReference(String prefix) {
		this.getMdht().setText(Util.createReference(prefix));
	}

	/**
	 * Sets if the immunization is not desired.
	 */
	public void setUndesired() {
		this.getMdht().setNegationInd(true);
	}

}
