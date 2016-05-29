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
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.enums.CountryCode;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.AssignedCustodian;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.InFulfillmentOf;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.Participant1;
import org.openhealthtools.mdht.uml.cda.Section;
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
		setTitle(createSpecialitySectionTitle());
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
		getMdht().getInformationRecipients().add(recipient.getMdhtIntendedRecipient());
		final int nb = getMdht().getInformationRecipients().size() - 1;
		getMdht().getInformationRecipients().get(nb).setTypeCode(x_InformationRecipient.PRCP);
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
	 * Gets the speciality section title.
	 *
	 * @return the speciality section title
	 */
	private String createSpecialitySectionTitle() {
		switch (this.getLanguageCode()) {
		case FRENCH:
			return ("Rapport de laboratoire");
		case GERMAN:
			return ("Laborbefund");
		case ITALIAN:
			return ("Rapporto di laboratorio");
		case ENGLISH:
			return ("Laboratory report");
		}
		return "";
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
	 * Gets the laboratory specialty section.
	 *
	 * @return the laboratory specialty section
	 */
	private LaboratorySpecialtySection getLaboratorySpecialtySection() {
		for (final Section s : getMdht().getAllSections()) {
			if (s instanceof LaboratorySpecialtySection) {
				return (LaboratorySpecialtySection) s;
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
			return getLaboratorySpecialtySection().getText().getText();
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
			getLaboratorySpecialtySection().createStrucDocText(text);
		}
	}
}
