/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.ps;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.base.Beilagen;
import org.husky.cda.elga.generated.artdecor.base.Brieftext;
import org.husky.cda.elga.generated.artdecor.ps.AbschliessendeBemerkung;
import org.husky.cda.elga.generated.artdecor.ps.AllergienUnvertraeglichkeiten;
import org.husky.cda.elga.generated.artdecor.ps.ElgapatientConsultationSummary;
import org.husky.cda.elga.generated.artdecor.ps.EmpfohleneMedikationFull;
import org.husky.cda.elga.generated.artdecor.ps.KonsultationsUeberweisunggrund;
import org.husky.cda.elga.generated.artdecor.ps.MedikationVerordnungEntryNoDrugTherapy;
import org.husky.cda.elga.generated.artdecor.ps.WeitereInformation;
import org.husky.cda.elga.generated.artdecor.ps.WichtigeHinweise;
import org.husky.cda.elga.generated.artdecor.ps.enums.ElgaSections;
import org.husky.cda.elga.models.AdditionalInformation;
import org.husky.cda.elga.models.Allergy;
import org.husky.cda.elga.models.Appendix;
import org.husky.cda.elga.models.Disease;
import org.husky.cda.elga.models.PatientCdaAt;
import org.husky.cda.elga.models.PractitionerCdaAt;
import org.husky.cda.elga.models.PrescriptionEntry;
import org.husky.cda.elga.narrative.AppendixNarrativeTextGenerator;
import org.husky.cda.elga.narrative.KonsUeberwGrundNarrativeTextGenerator;
import org.husky.cda.elga.narrative.RecommendedMedNarrativeTextGenerator;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.POCDMT000040Author;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040Component2;
import org.husky.common.hl7cdar2.POCDMT000040Component3;
import org.husky.common.hl7cdar2.POCDMT000040Entry;
import org.husky.common.hl7cdar2.POCDMT000040RecordTarget;
import org.husky.common.hl7cdar2.POCDMT000040Section;
import org.husky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.husky.common.hl7cdar2.ST;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.TEL;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Organization;
import org.husky.common.utils.time.DateTimes;
import org.husky.common.utils.time.Hl7Dtm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PatientConsultationSummary  {
	private static final Logger LOGGER = LoggerFactory.getLogger(PatientConsultationSummary.class.getName());

	private PatientCdaAt patient;
	private PractitionerCdaAt author;
	private ZonedDateTime authorTime;
	private Organization custodian;
	private PractitionerCdaAt legalAuthenticator;
	private ZonedDateTime legalAuthenticatorTime;
	private String docId;
	private String setId;
	private int version;
	private String title;
	private List<Disease> diseases;
	private String lettertext;
	private String importantNotes;
	private String furtherInformation;
	private String finalRemarks;
	private List<Appendix> appendices;
	private List<PrescriptionEntry> prescriptions;
	private List<Allergy> allergies;

	public List<PrescriptionEntry> getPrescriptions() {
		return prescriptions;
	}

	public void setPrescriptions(List<PrescriptionEntry> prescriptions) {
		this.prescriptions = prescriptions;
	}

	public List<Allergy> getAllergies() {
		return allergies;
	}

	public void setAllergies(List<Allergy> allergies) {
		this.allergies = allergies;
	}

	public PatientCdaAt getPatient() {
		return patient;
	}

	public void setPatient(PatientCdaAt patient) {
		this.patient = patient;
	}

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public Organization getCustodian() {
		return custodian;
	}

	public void setCustodian(Organization organization) {
		this.custodian = organization;
	}

	public PractitionerCdaAt getLegalAuthenticator() {
		return this.legalAuthenticator;
	}

	public void setLegalAuthenticator(PractitionerCdaAt legalAuthenticator) {
		this.legalAuthenticator = legalAuthenticator;
	}

	public String getDocId() {
		return docId;
	}

	public void setDocId(String docId) {
		this.docId = docId;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Disease> getDiseases() {
		return diseases;
	}

	public void setDiseases(List<Disease> diseases) {
		this.diseases = diseases;
	}

	public String getLettertext() {
		return lettertext;
	}

	public void setLettertext(String lettertext) {
		this.lettertext = lettertext;
	}

	public String getImportantNotes() {
		return importantNotes;
	}

	public void setImportantNotes(String importantNotes) {
		this.importantNotes = importantNotes;
	}

	public String getFurtherInformation() {
		return furtherInformation;
	}

	public void setFurtherInformation(String furtherInformation) {
		this.furtherInformation = furtherInformation;
	}

	public String getFinalRemarks() {
		return finalRemarks;
	}

	public void setFinalRemarks(String finalRemarks) {
		this.finalRemarks = finalRemarks;
	}

	public List<Appendix> getAppendices() {
		return appendices;
	}

	public void setAppendices(List<Appendix> appendices) {
		this.appendices = appendices;
	}

	public ZonedDateTime getAuthorTime() {
		return authorTime;
	}

	public void setAuthorTime(ZonedDateTime authorTime) {
		this.authorTime = authorTime;
	}

	public ZonedDateTime getLegalAuthenticatorTime() {
		return legalAuthenticatorTime;
	}

	public void setLegalAuthenticatorTime(ZonedDateTime legalAuthenticatorTime) {
		this.legalAuthenticatorTime = legalAuthenticatorTime;
	}

	private Beilagen getAppendixSection() {
		Beilagen appendix = new Beilagen();
		ST stTitle = new ST();
		stTitle.setXmlMixed("Beilagen");
		appendix.setHl7Title(stTitle);

		int index = 1;
		for (Appendix appendixDoc : this.appendices) {
			appendix.addHl7Entry(appendixDoc.getHl7CdaR2AppendixEntry("consultation", index));
			index++;
		}

		StrucDocText text = new StrucDocText();
		AppendixNarrativeTextGenerator textbuilder = new AppendixNarrativeTextGenerator(appendix.getEntry(),
				this.appendices);
		text.getContent().add(textbuilder.toString());
		appendix.setHl7Text(text);

		return appendix;
	}

	private KonsultationsUeberweisunggrund getConsultationCauseSection() {
		if (this.diseases == null) {
			return null;
		}

		KonsultationsUeberweisunggrund cause = new KonsultationsUeberweisunggrund();

		int index = 0;
		for (Disease problem : this.diseases) {
			if (problem != null) {
				cause.setHl7Entry(problem.getGesundheitsProblemEntry(index++));
			}
		}

		StrucDocText textKonsUeberwGrund = new StrucDocText();
		KonsUeberwGrundNarrativeTextGenerator textbuilder = new KonsUeberwGrundNarrativeTextGenerator(cause.getEntry());
		textKonsUeberwGrund.getContent().add(textbuilder.toString());
		cause.setText(textKonsUeberwGrund);

		ST stTitle = new ST();
		stTitle.setXmlMixed("Konsultations- oder Überweisungsgrund");
		cause.setTitle(stTitle);
		return cause;
	}

	private POCDMT000040Section getAllergyIntoleranceSection() {
		if (allergies == null) {
			return null;
		}

		AllergienUnvertraeglichkeiten allergySection = new AllergienUnvertraeglichkeiten();
		ST stTitle = new ST();
		stTitle.setXmlMixed("Allergien und Intoleranzen");
		allergySection.setTitle(stTitle);

		if (allergies.stream()
				.allMatch(allergy -> allergy.getAbsentAllergy() != null || allergy.getKindOfAllergy() != null)) {
			int index = 0;
			for (Allergy allergy : allergies) {
				if (allergy != null) {
					allergySection.addHl7Entry(allergy.getHl7CdaR2AllergyEntry(index++));
				}
			}
		} else {
			StrucDocText structext = new StrucDocText();
			structext.setMediaType("text/plain");
			for (Allergy allergy : allergies) {
				structext.getContent().add(allergy.getText());
			}
			allergySection.setText(structext);
			allergySection.getEntry().clear();
		}

		return allergySection;
	}

	protected POCDMT000040Section getRecommendedMedicationSection() {
		EmpfohleneMedikationFull recommendedMedSection = new EmpfohleneMedikationFull();

		ST stTitle = new ST();
		stTitle.setXmlMixed("Empfohlene Medikation");
		recommendedMedSection.setTitle(stTitle);

		if (prescriptions != null && !prescriptions.isEmpty()) {
			for (PrescriptionEntry prescription : prescriptions) {
				recommendedMedSection.setHl7Entry(prescription.getMedikationVerordnungEntryemed());
			}
		} else {
			recommendedMedSection.setHl7Entry(getMedikationVerordnungEntryNoDrugTherapy());
		}

		List<List<AdditionalInformation>> patientInstructions = new LinkedList<>();
		List<List<AdditionalInformation>> pharmacistInstructions = new LinkedList<>();

		for (PrescriptionEntry entry : prescriptions) {
			if (entry != null) {
				patientInstructions.add(entry.getAddInfoPat());
				pharmacistInstructions.add(entry.getAddInfoPharm());
			}
		}

		StrucDocText text = new StrucDocText();
		RecommendedMedNarrativeTextGenerator textbuilder = new RecommendedMedNarrativeTextGenerator(
				recommendedMedSection.getEntry(), patientInstructions, pharmacistInstructions);
		text.getContent().add(textbuilder.toString());
		recommendedMedSection.setText(text);

		return recommendedMedSection;
	}

	protected POCDMT000040Entry getMedikationVerordnungEntryNoDrugTherapy() {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		MedikationVerordnungEntryNoDrugTherapy noDrugTherapy = new MedikationVerordnungEntryNoDrugTherapy();
		noDrugTherapy.setText(new ED(null, new TEL("#nomed1")));
		entry.setSubstanceAdministration(noDrugTherapy);
		return entry;
	}

	protected POCDMT000040StructuredBody getHl7CdaR2Pocdmt000040StructuredBody() {
		POCDMT000040StructuredBody structuredBody = new POCDMT000040StructuredBody();
		structuredBody.getClassCode().add("DOCBODY");
		structuredBody.getMoodCode().add("EVN");

		if (this.lettertext != null && !this.lettertext.isEmpty()) {
			structuredBody.getComponent().add(createComp3FreeText(new Brieftext(), this.lettertext, "Brieftext"));
		}

		if (this.diseases != null && !this.diseases.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getConsultationCauseSection());
			structuredBody.getComponent().add(comp3);
		}

		if (allergies != null && !allergies.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getAllergyIntoleranceSection());
			structuredBody.getComponent().add(comp3);
		}

		if (prescriptions != null && !prescriptions.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getRecommendedMedicationSection());
			structuredBody.getComponent().add(comp3);
		}

		if (this.importantNotes != null && !this.importantNotes.isEmpty()) {
			structuredBody.getComponent()
					.add(createComp3FreeText(new WichtigeHinweise(), importantNotes, "Wichtige Hinweise"));
		}

		if (this.furtherInformation != null && !this.furtherInformation.isEmpty()) {
			structuredBody.getComponent()
					.add(createComp3FreeText(new WeitereInformation(), furtherInformation, "Weitere Informationen"));
		}

		if (this.finalRemarks != null && !this.finalRemarks.isEmpty()) {
			structuredBody.getComponent()
					.add(createComp3FreeText(new AbschliessendeBemerkung(), finalRemarks, "Abschließende Bemerkungen"));
		}

		if (appendices != null && !appendices.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getAppendixSection());
			structuredBody.getComponent().add(comp3);
		}

		return structuredBody;
	}

	private void getHeader(ElgapatientConsultationSummary cda) {
		ST stTitle = new ST();
		stTitle.setXmlMixed(title);
		cda.setTitle(stTitle);
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		if (patient != null) {
			cda.setHl7RecordTarget(this.patient.getHeaderRecordTargetBase());
		}

		if (author != null) {
			String gdaIndex = this.author.getGdaIndex();
			cda.setHl7Id(new Identificator(gdaIndex, docId).getHl7CdaR2Ii());
			cda.setVersion(new Identificator(gdaIndex, this.setId), 1);
			cda.setHl7Author(author.getAtcdabbrHeaderAuthor(this.authorTime));
		}

		cda.setHl7Custodian(this.custodian.getHl7CdaR2Pocdmt000040Custodian());

		if (this.legalAuthenticator != null) {
			cda.setHl7LegalAuthenticator(legalAuthenticator.getHeaderLegalAuthenticator(legalAuthenticatorTime));
		}
	}

	private void setHeader(ElgapatientConsultationSummary cda) {
		if (cda.getTitle() != null && cda.getTitle().getReference() != null) {
			this.title = cda.getTitle().getReference().getMergedXmlMixed();
		}

		if (cda.getEffectiveTime() != null && cda.getEffectiveTime().getValue() != null) {
			Hl7Dtm hl7dtm = Hl7Dtm.fromHl7(cda.getEffectiveTime().getValue());
			this.authorTime = hl7dtm.getDateTime().toZonedDateTime();
		}

		if (cda.getRecordTarget() != null) {
			for (POCDMT000040RecordTarget target : cda.getRecordTarget()) {
				this.patient = new PatientCdaAt(target);
			}
		}

		if (cda.getAuthor() != null) {
			for (POCDMT000040Author authorHl7cdar2 : cda.getAuthor()) {
				this.author = new PractitionerCdaAt(authorHl7cdar2);
			}
		}

		if (cda.getCustodian() != null && cda.getCustodian().getAssignedCustodian() != null
				&& cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization() != null) {
			this.custodian = new Organization(
					cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization());
		}

		if (cda.getLegalAuthenticator() != null && cda.getCustodian().getAssignedCustodian() != null
				&& cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization() != null) {
			this.legalAuthenticator = new PractitionerCdaAt(cda.getLegalAuthenticator());
		}
	}

	private void setStructuredBody(ElgapatientConsultationSummary cda) {
		if (cda.getComponent() != null && cda.getComponent().getStructuredBody() != null) {
			extractContent(cda);

			extractPatient(cda);
			extractAuthor(cda);
			extractLegalAuthenticator(cda);
			extractCustodian(cda);
		}
	}

	private void extractContent(POCDMT000040ClinicalDocument cda) {
		Code sectionCode;
		for (POCDMT000040Component3 component3 : cda.getComponent().getStructuredBody().getComponent()) {
			if (component3 != null && component3.getSection() != null && component3.getSection().getCode() != null) {
				sectionCode = new Code(component3.getSection().getCode());

				extractText(sectionCode, component3);

				if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.BEILAGEN_CODE)) {
					extractAppendices(component3);
				} else if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.DISCHARGE_MEDICATION_CODE)) {
					extractPrescriptions(component3);
				} else if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.ALLERGIES_CODE)) {
					extractAllergies(component3);
				} else if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.CHIEF_COMPLAINT_CODE)) {
					extractDiseases(component3);
				}
			}
		}
	}

	private void extractText(Code sectionCode, POCDMT000040Component3 component3) {
		if (component3.getSection() != null && component3.getSection().getText() != null) {
			if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.BRIEFTEXT_CODE)) {
				this.lettertext = component3.getSection().getText().getMergedXmlMixed();
			} else if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.ALERT_CODE)) {
				this.importantNotes = component3.getSection().getText().getMergedXmlMixed();
			} else if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.CLINICAL_INFORMATION_CODE)) {
				this.furtherInformation = component3.getSection().getText().getMergedXmlMixed();
			} else if (sectionCode.getCode().equalsIgnoreCase(ElgaSections.ABBEM_CODE)) {
				this.finalRemarks = component3.getSection().getText().getMergedXmlMixed();
			}
		}

	}

	private void extractAppendices(POCDMT000040Component3 component3) {
		this.appendices = new ArrayList<>();
		for (POCDMT000040Entry entry : component3.getSection().getEntry()) {
			this.appendices.add(new Appendix(entry));
		}
	}

	private void extractPrescriptions(POCDMT000040Component3 component3) {
		this.prescriptions = new ArrayList<>();
		for (POCDMT000040Entry entry : component3.getSection().getEntry()) {
			this.prescriptions.add(new PrescriptionEntry(entry));
		}
	}

	private void extractDiseases(POCDMT000040Component3 component3) {
		this.diseases = new ArrayList<>();
		for (POCDMT000040Entry entry : component3.getSection().getEntry()) {
			this.diseases.add(new Disease(entry));
		}
	}

	private void extractAllergies(POCDMT000040Component3 component3) {
		this.allergies = new ArrayList<>();
		if (!component3.getSection().getEntry().isEmpty()) {
			for (POCDMT000040Entry entry : component3.getSection().getEntry()) {
				this.allergies.add(new Allergy(entry));
			}
		} else {
			this.allergies.add(new Allergy(component3.getSection().getText().getMergedXmlMixed()));
		}
	}

	private void extractCustodian(POCDMT000040ClinicalDocument cda) {
		if (cda.getCustodian() != null && cda.getCustodian().getAssignedCustodian() != null
				&& cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization() != null) {
			this.custodian = new Organization(
					cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization());
		}
	}

	private void extractLegalAuthenticator(POCDMT000040ClinicalDocument cda) {
		if (cda.getLegalAuthenticator() != null && cda.getCustodian().getAssignedCustodian() != null
				&& cda.getCustodian().getAssignedCustodian().getRepresentedCustodianOrganization() != null) {
			this.legalAuthenticator = new PractitionerCdaAt(cda.getLegalAuthenticator());
		}
	}

	private void extractAuthor(POCDMT000040ClinicalDocument cda) {
		for (POCDMT000040Author authorHl7cdar2 : cda.getAuthor()) {
			this.author = new PractitionerCdaAt(authorHl7cdar2);
		}
	}

	private void extractPatient(POCDMT000040ClinicalDocument cda) {
		for (POCDMT000040RecordTarget target : cda.getRecordTarget()) {
			this.patient = new PatientCdaAt(target);
		}
	}

	public ElgapatientConsultationSummary getElgapatientConsultationSummaryCdaDocument() {
		ElgapatientConsultationSummary cda = new ElgapatientConsultationSummary();

		getHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(getHl7CdaR2Pocdmt000040StructuredBody());
		cda.setHl7Component(comp2);

		return cda;
	}

	public void setElgapatientConsultationSummaryCdaDocument(ElgapatientConsultationSummary cda) {
		setHeader(cda);
		setStructuredBody(cda);
	}

	protected POCDMT000040Component3 createComp3FreeText(POCDMT000040Section section, String text, String titleText) {
		POCDMT000040Component3 comp3 = new POCDMT000040Component3();
		StrucDocText structext = new StrucDocText();
		structext.setMediaType("text/plain");
		structext.getContent().add(text);
		section.setText(structext);

		ST stTitle = new ST();
		stTitle.setXmlMixed(titleText);
		section.setTitle(stTitle);
		comp3.setSection(section);
		return comp3;
	}

}
