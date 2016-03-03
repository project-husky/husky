package org.ehealth_connector.cda.ch.lab;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.ihe.lab.ReferralOrderingPhysician;
import org.ehealth_connector.common.AuthoringDevice;
import org.ehealth_connector.common.IntendedRecipient;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.Participant1;

public abstract class AbstractLaboratoryReport<EClinicalDocument extends ClinicalDocument>
		extends AbstractCdaCh<EClinicalDocument> {

	protected AbstractLaboratoryReport(EClinicalDocument doc) {
		this(doc, null, null, null);
	}

	protected AbstractLaboratoryReport(EClinicalDocument doc, LanguageCode languageCode) {
		this(doc, languageCode, null, null);
	}

	protected AbstractLaboratoryReport(EClinicalDocument doc, LanguageCode languageCode,
			String styleSheet, String css) {
		super(doc, styleSheet, css);
		// If the language code is null use default ENGLISH
		if (languageCode == null) {
			this.setLanguageCode(LanguageCode.ENGLISH);
		} else {
			this.setLanguageCode(languageCode);
		}
		setTitle(getSpecialitySectionTitle());
	}

	public void addAuthorOrganization(Organization organization, AuthoringDevice device) {
		Author author = CDAFactory.eINSTANCE.createAuthor();
		author.setAssignedAuthor(Util.createAuthorFromOrganization(organization));
		// TODO
	}

	public void addIntendedRecipient(IntendedRecipient recipient) {
		// InformationRecipient ir =
		// CDAFactory.eINSTANCE.createInformationRecipient();
		//
		// ir.setTypeCode(x_InformationRecipient.PRCP);
		// ir.setIntendedRecipient(recipient.copy());
		// getMdht().getInformationRecipients().add(ir);
		getMdht().getInformationRecipients().add(recipient.getIntendedRecipient());
	}

	public void addReferralOrderingPhysician(ReferralOrderingPhysician physician) {
		getMdht().getParticipants().add(physician.copy());
	}

	public List<IntendedRecipient> getIntendedRecipients() {
		List<IntendedRecipient> il = new ArrayList<IntendedRecipient>();
		for (InformationRecipient ir : getMdht().getInformationRecipients()) {
			if (ir.getIntendedRecipient() != null) {
				org.openhealthtools.mdht.uml.cda.IntendedRecipient mdht = ir.getIntendedRecipient();
				if (mdht instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient) {
					org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient iheIr = (org.openhealthtools.mdht.uml.cda.ihe.lab.IntendedRecipient) mdht;
					il.add(new IntendedRecipient(iheIr));
				}
			}
		}
		return il;
	}

	public List<ReferralOrderingPhysician> getReferralOrderingPhysicians() {
		List<ReferralOrderingPhysician> pl = new ArrayList<ReferralOrderingPhysician>();
		for (Participant1 p : getMdht().getParticipants()) {
			if (p instanceof org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician) {
				ReferralOrderingPhysician mdht = new ReferralOrderingPhysician(
						(org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician) p);
				pl.add(mdht);
			}
		}
		return pl;
	}

	private String getSpecialitySectionTitle() {
		switch (this.getLanguageCode()) {
		case FRENCH:
			return ("Rapport de laboratoire");
		case GERMAN:
			return ("Laborbefund");
		case ITALIAN:
			return ("Rapporto di laboratorio");
		case ENGLISH:
			return ("Laboratory Specialty Section");
		}
		return "";
	}
}
