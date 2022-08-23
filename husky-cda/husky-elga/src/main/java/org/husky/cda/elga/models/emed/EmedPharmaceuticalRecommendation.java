/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models.emed;

import java.time.ZonedDateTime;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.emed.EMedikationPharmazeutischeEmpfehlung;
import org.husky.cda.elga.generated.artdecor.emed.HeaderRelatedDocument;
import org.husky.cda.elga.generated.artdecor.emed.PharmazeutischeEmpfehlungSektion;
import org.husky.cda.elga.models.PatientCdaAt;
import org.husky.cda.elga.models.PractitionerCdaAt;
import org.husky.cda.elga.narrative.PharmRecommendationNarrativeTextGenerator;
import org.husky.common.hl7cdar2.CS;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.POCDMT000040Component2;
import org.husky.common.hl7cdar2.POCDMT000040Component3;
import org.husky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Organization;
import org.husky.common.utils.time.DateTimes;


public class EmedPharmaceuticalRecommendation  {

	private Identificator docId;
	private Identificator setId;
	private int version;
	private PatientCdaAt patient;
	private List<PractitionerCdaAt> authors;
	private ZonedDateTime authorTime;
	private Organization custodian;
	private PractitionerCdaAt legalAuthenticator;
	private ZonedDateTime startValidityPeriod;
	private ZonedDateTime stopValidityPeriod;
	private Identificator parentDocument;
	private Code kindOfPrescription;
	private List<PharmaceuticalRecommendationEntry> pharmRecommendationEntries;
	private Identificator gdaId;

	public Code getKindOfPrescription() {
		return kindOfPrescription;
	}

	public void setKindOfPrescription(Code kindOfPrescription) {
		this.kindOfPrescription = kindOfPrescription;
	}

	public Identificator getDocId() {
		return docId;
	}

	public void setDocId(Identificator docId) {
		this.docId = docId;
	}

	public Identificator getSetId() {
		return setId;
	}

	public void setSetId(Identificator setId) {
		this.setId = setId;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public PatientCdaAt getPatient() {
		return patient;
	}

	public void setPatient(PatientCdaAt patient) {
		this.patient = patient;
	}

	public List<PractitionerCdaAt> getAuthors() {
		return authors;
	}

	public void setAuthors(List<PractitionerCdaAt> authors) {
		this.authors = authors;
	}

	public ZonedDateTime getAuthorTime() {
		return authorTime;
	}

	public void setAuthorTime(ZonedDateTime authorTime) {
		this.authorTime = authorTime;
	}

	public Organization getCustodian() {
		return custodian;
	}

	public void setCustodian(Organization custodian) {
		this.custodian = custodian;
	}

	public PractitionerCdaAt getLegalAuthenticator() {
		return legalAuthenticator;
	}

	public void setLegalAuthenticator(PractitionerCdaAt legalAuthenticator) {
		this.legalAuthenticator = legalAuthenticator;
	}

	public ZonedDateTime getStartValidityPeriod() {
		return startValidityPeriod;
	}

	public void setStartValidityPeriod(ZonedDateTime startValidityPeriod) {
		this.startValidityPeriod = startValidityPeriod;
	}

	public ZonedDateTime getStopValidityPeriod() {
		return stopValidityPeriod;
	}

	public void setStopValidityPeriod(ZonedDateTime stopValidityPeriod) {
		this.stopValidityPeriod = stopValidityPeriod;
	}

	public Identificator getParentDocument() {
		return parentDocument;
	}

	public void setParentDocument(Identificator parentDocument) {
		this.parentDocument = parentDocument;
	}

	public List<PharmaceuticalRecommendationEntry> getPharmRecommendationEntries() {
		return pharmRecommendationEntries;
	}

	public void setPharmRecommendationEntries(List<PharmaceuticalRecommendationEntry> pharmRecommendationEntries) {
		this.pharmRecommendationEntries = pharmRecommendationEntries;
	}

	public Identificator getGdaId() {
		return gdaId;
	}

	public void setGdaId(Identificator gdaId) {
		this.gdaId = gdaId;
	}

	protected HeaderRelatedDocument getAtcdabbrHeaderDocumentReplacementRelatedDocument() {
		HeaderRelatedDocument relatedDocument = new HeaderRelatedDocument();
		relatedDocument.getHl7ParentDocument().getId().add(this.parentDocument.getHl7CdaR2Ii());
		return relatedDocument;
	}

	protected POCDMT000040StructuredBody getHl7CdaR2Pocdmt000040StructuredBodyEMedicationPharmaceuticalRecommendation() {
		POCDMT000040StructuredBody structuredBody = new POCDMT000040StructuredBody();
		structuredBody.getClassCode().add("DOCBODY");
		structuredBody.getMoodCode().add("EVN");

		if (this.pharmRecommendationEntries != null && !this.pharmRecommendationEntries.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getPharmaceuticalRecommendationSection());
			structuredBody.getComponent().add(comp3);
		}

		return structuredBody;
	}

	protected PharmazeutischeEmpfehlungSektion getPharmaceuticalRecommendationSection() {
		if (this.pharmRecommendationEntries == null || this.pharmRecommendationEntries.isEmpty()) {
			return null;
		}

		PharmazeutischeEmpfehlungSektion pharmaceuticalRecommendationSection = new PharmazeutischeEmpfehlungSektion();

		int index = 0;
		for (PharmaceuticalRecommendationEntry entry : pharmRecommendationEntries) {
			if (entry != null) {
				pharmaceuticalRecommendationSection.getEntry()
						.add(entry.getMedikationPharmazeutischeEmpfehlungEntryemed(index, gdaId, kindOfPrescription));
			}
		}

		StrucDocText textKonsUeberwGrund = new StrucDocText();
		PharmRecommendationNarrativeTextGenerator textbuilder = new PharmRecommendationNarrativeTextGenerator(
				pharmaceuticalRecommendationSection.getEntry());
		textKonsUeberwGrund.getContent().add(textbuilder.toString());
		pharmaceuticalRecommendationSection.setText(textKonsUeberwGrund);

		return pharmaceuticalRecommendationSection;
	}

	public EMedikationPharmazeutischeEmpfehlung getEMedicationPharmaceuticalRecommencation() {
		EMedikationPharmazeutischeEmpfehlung cda = new EMedikationPharmazeutischeEmpfehlung();

		addHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(getHl7CdaR2Pocdmt000040StructuredBodyEMedicationPharmaceuticalRecommendation());
		cda.setHl7Component(comp2);

		return cda;
	}

	private void addHeader(EMedikationPharmazeutischeEmpfehlung cda) {
		cda.setHl7Id(getDocId().getHl7CdaR2Ii());
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		cda.setSetId(getSetId().getHl7CdaR2Ii());
		cda.setVersionNumber(new INT(this.getVersion()));
		cda.getRealmCode().add(new CS("AT"));

		if (patient != null) {
			cda.getRecordTarget().clear();
			cda.getRecordTarget().add(patient.getHeaderRecordTargetBase());
		}

		if (this.getAuthors() != null && !this.getAuthors().isEmpty()) {
			for (PractitionerCdaAt author : getAuthors()) {
				cda.getAuthor().add(author.getAtcdabbrHeaderAuthor(authorTime));
			}
		}

		if (custodian != null) {
			cda.setCustodian(custodian.getHl7CdaR2Pocdmt000040Custodian());
		}

		if (legalAuthenticator != null) {
			cda.setLegalAuthenticator(legalAuthenticator.getHeaderLegalAuthenticator(this.getAuthorTime()));
		}

		if (this.getParentDocument() != null) {
			cda.getRelatedDocument().add(getAtcdabbrHeaderDocumentReplacementRelatedDocument());
		}

	}

}
