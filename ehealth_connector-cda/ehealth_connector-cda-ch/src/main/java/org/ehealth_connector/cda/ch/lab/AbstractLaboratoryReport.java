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
package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.AbstractObservation;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ch.ParticipantClaimer;
import org.ehealth_connector.cda.ch.textbuilder.ObservationChTextBuilder;
import org.ehealth_connector.cda.ihe.lab.AbstractLaboratorySpecialtySection;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.AssignedCustodian;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.Entry;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.InFulfillmentOf;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.Participant1;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection;
import org.openhealthtools.mdht.uml.cda.ihe.impl.CodedVitalSignsSectionImpl;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryBatteryOrganizer;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratorySpecialtySection;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.ADXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_InformationRecipient;

/**
 * The Class AbstractLaboratoryReport.
 *
 * @param <EClinicalDocument>
 *            the generic type
 */
/**
 * @author tony
 *
 * @param <EClinicalDocument>
 */
public abstract class AbstractLaboratoryReport<EClinicalDocument extends ClinicalDocument>
		extends AbstractCdaCh<EClinicalDocument> {

	/**
	 * Instantiates a new abstract laboratory report.
	 *
	 * @param doc
	 *            the doc
	 */
	protected AbstractLaboratoryReport(EClinicalDocument doc) {
		super(doc);
	}

	/**
	 * Instantiates a new abstract laboratory report.
	 *
	 * @param doc
	 *            the doc
	 * @param languageCode
	 *            the language code
	 */
	protected AbstractLaboratoryReport(EClinicalDocument doc, LanguageCode languageCode) {
		super(doc, languageCode);
	}

	/**
	 * Instantiates a new abstract laboratory report.
	 *
	 * @param doc
	 *            the doc
	 * @param languageCode
	 *            the language code
	 * @param styleSheet
	 *            the style sheet
	 * @param css
	 *            the css
	 */
	protected AbstractLaboratoryReport(EClinicalDocument doc, LanguageCode languageCode,
			String styleSheet, String css) {
		super(doc, styleSheet, css);
		// If the language code is null use default ENGLISH
		if (languageCode == null) {
			this.setLanguageCode(LanguageCode.ENGLISH);
		} else {
			this.setLanguageCode(languageCode);
		}
		setTitle(createDocumentTitle());
		initCda();
		// Fix RealmCode
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(CountryCode.SWITZERLAND.getCodeValue());
		getDoc().getRealmCodes().clear();
		getDoc().getRealmCodes().add(cs);
	}

	/**
	 * Adds the intended recipient.
	 *
	 * @param recipient
	 *            the recipient
	 */
	public void addIntendedRecipient(IntendedRecipient recipient) {
		if (recipient != null) {
			getMdht().getInformationRecipients().add(recipient.getMdhtIntendedRecipient());
			final int nb = getMdht().getInformationRecipients().size() - 1;
			getMdht().getInformationRecipients().get(nb).setTypeCode(x_InformationRecipient.PRCP);
		}
	}

	/**
	 * Adds the participant. <div class="en">Physicians performing examinations
	 * in the given laboratory MAY be added as participants.</div>
	 * <div class="de">Ärzte, welche in dem, in <CH-LRQC-CUST> angegebenen Labor
	 * Untersuchungen durchführen KÖNNEN als Participant hinzugefügt
	 * werden.</div>
	 *
	 * @param participant
	 *            the participant
	 */
	public void addParticipant(ParticipantClaimer participant) {
		getMdht().getParticipants().add(participant.getMdht());
	}

	/**
	 * Adds the referral ordering physician.
	 *
	 * @param physician
	 *            the physician
	 */
	public void addReferralOrderingPhysician(ReferralOrderingPhysician physician) {
		if (physician != null) {
			getMdht().getParticipants().add(physician.copy());
		}
	}

	/**
	 * Creates the CDA document title in the given language.
	 *
	 * @return the CDA document title in the given language.
	 */
	protected abstract String createDocumentTitle();

	/**
	 * TODO tsc dokumentieren
	 */
	public String generateNarrativeTextLaboratoryObservations(
			AbstractLaboratorySpecialtySection laboratorySpecialtySection, String contentIdPrefix) {
		return generateNarrativeTextLaboratoryObservations(laboratorySpecialtySection,
				contentIdPrefix, null);
	}

	/**
	 * <div class="en">Generates the human readable text of the laboratory
	 * observations chapter</div> <div class="de">Liefert den menschenlesbaren
	 * Text zu dem Kapitel Laborresultate zurück</div>.
	 *
	 * @param laboratorySpecialtySection
	 *            the laboratory specialty section
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @param posCodeSystemOid
	 *            the oid of the code system to be used as position (e.g.
	 *            2.16.756.5.30.1.129.1.3 for the Swiss Analysis List)
	 * @return the laboratory observations text
	 */
	public String generateNarrativeTextLaboratoryObservations(
			AbstractLaboratorySpecialtySection laboratorySpecialtySection, String contentIdPrefix,
			String posCodeSystemOid) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(laboratorySpecialtySection,
				contentIdPrefix, LanguageCode.getEnum(getMdht().getLanguageCode().getCode()),
				posCodeSystemOid);
		return b.toString();
	}

	/**
	 * <div class="en">Generates the human readable text of the laboratory
	 * observations chapter</div> <div class="de">Liefert den menschenlesbaren
	 * Text zu dem Kapitel Laborresultate zurück</div>.
	 *
	 * @param contentIdPrefix
	 *            the content id prefix
	 * @return the laboratory observations text
	 */
	public String generateNarrativeTextLaboratoryObservations(String contentIdPrefix) {
		return generateNarrativeTextLaboratoryObservations(getLaboratorySpecialtySection(),
				contentIdPrefix, null);
	}

	/**
	 * TODO tsc dokumentieren
	 */
	public String generateNarrativeTextLaboratoryObservations(String contentIdPrefix,
			String posCodeSystemOid) {
		return generateNarrativeTextLaboratoryObservations(getLaboratorySpecialtySection(),
				contentIdPrefix, posCodeSystemOid);
	}

	public String generateNarrativeTextVitalSignObservations(

			org.openhealthtools.mdht.uml.cda.ihe.CodedVitalSignsSection vitalSignsSection,
			String contentIdPrefix) {
		final ObservationChTextBuilder b = new ObservationChTextBuilder(vitalSignsSection,
				contentIdPrefix, LanguageCode.getEnum(getMdht().getLanguageCode().getCode()));
		return b.toString();
	}

	/**
	 * TODO tsc dokumentieren
	 */
	public String generateNarrativeTextVitalSignObservations(String contentIdPrefix) {
		return generateNarrativeTextVitalSignObservations(getCodedVitalSignsSection(),
				contentIdPrefix);
	}

	/**
	 * Gets the coded vital signs section.
	 *
	 * @return the coded vital signs section
	 */
	private CodedVitalSignsSection getCodedVitalSignsSection() {
		for (final Section s : getMdht().getAllSections()) {
			if (s instanceof CodedVitalSignsSectionImpl) {
				return (CodedVitalSignsSectionImpl) s;
			}
		}
		return null;
	}

	/**
	 * Convenience function that returns a list of all order ids of all
	 * inFulfillmentOf Elements.
	 *
	 * @return the order id list (from all underlying
	 *         /clinicalDocument/inFulfillmentOf/order/id)
	 */
	public List<Identificator> getInFulfillmentOfOrderIds() {
		final List<Identificator> al = new ArrayList<Identificator>();
		for (final InFulfillmentOf ifo : getMdht().getInFulfillmentOfs()) {
			for (final II id : ifo.getOrder().getIds()) {
				al.add(new Identificator(id));
			}
		}
		return al;
	}

	/**
	 * Gets the intended recipients.
	 *
	 * @return the intended recipients
	 */
	public List<IntendedRecipient> getIntendedRecipients() {
		final List<IntendedRecipient> il = new ArrayList<IntendedRecipient>();
		for (final InformationRecipient ir : getMdht().getInformationRecipients()) {
			if (ir instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient) {
				final org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient iheIr = (org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient) ir;
				il.add(new IntendedRecipient(iheIr));
			}
		}
		return il;
	}

	/**
	 * <div class="en">Gets the laboratory observations</div>
	 * <div class="de">Liefert alle Laborresultate zurück</div>
	 *
	 * @return List with laboratory observations
	 */
	public List<AbstractObservation> getLaboratoryObservations() {
		// Search for the right section
		final AbstractLaboratorySpecialtySection los = getLaboratorySpecialtySection();
		if (los == null) {
			return null;
		}
		final EList<Entry> entries = los.getMdht().getEntries();

		final List<AbstractObservation> labObservations = new ArrayList<AbstractObservation>();
		for (final Entry entry : entries) {
			final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mLabRdpe = (org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry) entry;

			final Act act = mLabRdpe.getAct();
			for (final EntryRelationship er : act.getEntryRelationships()) {
				if (er.getOrganizer() instanceof LaboratoryBatteryOrganizer) {
					final LaboratoryBatteryOrganizer mLabOrg = (LaboratoryBatteryOrganizer) er
							.getOrganizer();
					for (final org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryObservation mLo : mLabOrg
							.getLaboratoryObservations()) {
						final org.ehealth_connector.cda.ch.vacd.LaboratoryObservation lo = new org.ehealth_connector.cda.ch.vacd.LaboratoryObservation(
								mLo);
						labObservations.add(lo);
					}
				}
			}
		}
		return labObservations;
	}

	/**
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	private AbstractLaboratorySpecialtySection getLaboratorySpecialtySection() {
		for (final Section s : getMdht().getAllSections()) {
			if (s instanceof LaboratorySpecialtySection) {
				return new AbstractLaboratorySpecialtySection((LaboratorySpecialtySection) s);
			}
		}
		return null;
	}

	/**
	 * Returns the narrative Text of the LaboratorySpecialtySection.
	 *
	 * @return the narrative Text. Returns null, if this text does not exist.
	 */
	public String getNarrativeTextSectionLaboratorySpeciality() {
		if ((getLaboratorySpecialtySection() != null)
				&& (getLaboratorySpecialtySection().getText() != null)) {
			// TODO tsc: Check
			// return getLaboratorySpecialtySection().getText().getText();
			return getLaboratorySpecialtySection().getText();
		}
		return null;
	}

	/**
	 * Gets the referral ordering physicians.
	 *
	 * @return the referral ordering physicians
	 */
	public List<ReferralOrderingPhysician> getReferralOrderingPhysicians() {
		final List<ReferralOrderingPhysician> pl = new ArrayList<ReferralOrderingPhysician>();
		for (final Participant1 p : getMdht().getParticipants()) {
			if (p instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician) {
				final ReferralOrderingPhysician mdht = new ReferralOrderingPhysician(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician) p);
				pl.add(mdht);
			}
		}
		return pl;
	}

	/**
	 * Creates an empty Custodian element, according to the LRXX specification.
	 */
	public void setEmtpyCustodian() {
		final Custodian c = CDAFactory.eINSTANCE.createCustodian();
		final AssignedCustodian ac = CDAFactory.eINSTANCE.createAssignedCustodian();
		final CustodianOrganization co = CDAFactory.eINSTANCE.createCustodianOrganization();

		c.setAssignedCustodian(ac);
		ac.setRepresentedCustodianOrganization(co);

		// Id
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setNullFlavor(NullFlavor.NASK);
		co.getIds().add(ii);

		// Name
		final ON on = DatatypesFactory.eINSTANCE.createON();
		on.setNullFlavor(NullFlavor.NASK);
		co.setName(on);

		// Telecom
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.NASK);
		co.setTelecom(tel);

		// Addr
		final AD ad = DatatypesFactory.eINSTANCE.createAD();
		ad.setNullFlavor(NullFlavor.NASK);
		final ADXP adxp = DatatypesFactory.eINSTANCE.createADXP();
		adxp.setNullFlavor(NullFlavor.NASK);
		ad.getStreetNames().add(adxp);
		co.setAddr(ad);

		getMdht().setCustodian(c);
	}

	/**
	 * Sets the section/text element for the LaboratorySpecialtySection.
	 *
	 * @param text
	 *            the text
	 */
	public void setNarrativeTextSectionLaboratorySpeciality(String text) {
		if (getLaboratorySpecialtySection() != null) {
			getLaboratorySpecialtySection().getMdht().createStrucDocText(text);
		}
	}

}
