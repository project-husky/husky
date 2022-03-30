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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.husky.cda.elga.generated.artdecor.emed.Cdarezept;
import org.husky.cda.elga.generated.artdecor.emed.HeaderRelatedDocument;
import org.husky.cda.elga.generated.artdecor.emed.RezeptSection;
import org.husky.cda.elga.generated.artdecor.emed.enums.ElgaMedikationRezeptart;
import org.husky.cda.elga.models.AdditionalInformation;
import org.husky.cda.elga.models.PatientCdaAt;
import org.husky.cda.elga.models.PractitionerCdaAt;
import org.husky.cda.elga.models.PrescriptionEntry;
import org.husky.cda.elga.narrative.MedBaseTextGenerator;
import org.husky.cda.elga.utils.NamespaceUtils;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.INT;
import org.husky.common.hl7cdar2.IVLTS;
import org.husky.common.hl7cdar2.POCDMT000040ClinicalDocument;
import org.husky.common.hl7cdar2.POCDMT000040Component2;
import org.husky.common.hl7cdar2.POCDMT000040Component3;
import org.husky.common.hl7cdar2.POCDMT000040DocumentationOf;
import org.husky.common.hl7cdar2.POCDMT000040ServiceEvent;
import org.husky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.husky.common.hl7cdar2.StrucDocText;
import org.husky.common.hl7cdar2.TS;
import org.husky.common.model.Code;
import org.husky.common.model.Identificator;
import org.husky.common.model.Organization;
import org.husky.common.utils.time.DateTimes;

public class EmedPrescription  {

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
	private List<PrescriptionEntry> prescriptionEntries;
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

	public List<PrescriptionEntry> getPrescriptionEntries() {
		return prescriptionEntries;
	}

	public void setPrescriptionEntries(List<PrescriptionEntry> prescriptionEntries) {
		this.prescriptionEntries = prescriptionEntries;
	}

	public Identificator getGdaId() {
		return gdaId;
	}

	public void setGdaId(Identificator gdaId) {
		this.gdaId = gdaId;
	}

	protected POCDMT000040DocumentationOf getAtcdabbrHeaderDocumentationOfServiceEvent() {
		POCDMT000040DocumentationOf documentationOfServiceEvent = new POCDMT000040DocumentationOf();
		POCDMT000040ServiceEvent serviceEvent = new POCDMT000040ServiceEvent();

		if (kindOfPrescription != null) {
			serviceEvent.setCode(kindOfPrescription.getHl7CdaR2Ce());

			if (kindOfPrescription.getCode() != null
					&& (kindOfPrescription.getCode().equals(ElgaMedikationRezeptart.KASSENREZEPT_CODE)
							|| kindOfPrescription.getCode().equals(ElgaMedikationRezeptart.PRIVATREZEPT_CODE))) {
				startValidityPeriod = ZonedDateTime.now();
			}

			if (kindOfPrescription.getCode().equals(ElgaMedikationRezeptart.KASSENREZEPT_CODE)) {
				stopValidityPeriod = startValidityPeriod.plusMonths(1).plusDays(1);
			}

			if (startValidityPeriod != null && stopValidityPeriod != null) {
				IVLTS time = new IVLTS();
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(startValidityPeriod)));
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(stopValidityPeriod)));
				serviceEvent.setEffectiveTime(time);
			} else {
				IVLTS ivlts = new IVLTS();
				ivlts.nullFlavor = new ArrayList<>();
				ivlts.nullFlavor.add(NullFlavor.MASKED_CODE);
				serviceEvent.setEffectiveTime(ivlts);
			}
		}

		documentationOfServiceEvent.setServiceEvent(serviceEvent);

		return documentationOfServiceEvent;
	}

	protected HeaderRelatedDocument getAtcdabbrHeaderDocumentReplacementRelatedDocument() {
		HeaderRelatedDocument relatedDocument = new HeaderRelatedDocument();		
		relatedDocument.getHl7ParentDocument().getId().add(this.parentDocument.getHl7CdaR2Ii());		
		return relatedDocument;
	}

	protected POCDMT000040StructuredBody getHl7CdaR2Pocdmt000040StructuredBodyEMedicationPrescription() {
		POCDMT000040StructuredBody structuredBody = new POCDMT000040StructuredBody();
		structuredBody.getClassCode().add("DOCBODY");
		structuredBody.getMoodCode().add("EVN");

		if (this.prescriptionEntries != null && !this.prescriptionEntries.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getRezeptSection());
			structuredBody.getComponent().add(comp3);
		}

		return structuredBody;
	}

	protected RezeptSection getRezeptSection() {
		if (this.prescriptionEntries == null || this.prescriptionEntries.isEmpty()) {
			return null;
		}

		RezeptSection prescriptionSection = new RezeptSection();

		int index = 0;
		prescriptionSection.getEntry().clear();
		for (PrescriptionEntry entry : prescriptionEntries) {
			if (entry != null) {
				prescriptionSection.getEntry()
						.add(entry.getMedikationVerordnungEntryemedEmedication(index, gdaId, kindOfPrescription));
			}
		}
		
		List<List<AdditionalInformation>> patientInstructions = new LinkedList<>();
		List<List<AdditionalInformation>> pharmacistInstructions = new LinkedList<>();

		for (PrescriptionEntry entry : prescriptionEntries) {
			if (entry != null) {
				patientInstructions.add(entry.getAddInfoPat());
				pharmacistInstructions.add(entry.getAddInfoPharm());
			}
		}

		StrucDocText textKonsUeberwGrund = new StrucDocText();
		MedBaseTextGenerator textbuilder = new MedBaseTextGenerator(patientInstructions, pharmacistInstructions);
		textKonsUeberwGrund.getContent().addAll(textbuilder.getTablesFromCda(prescriptionSection.getEntry()));
		prescriptionSection.setText(textKonsUeberwGrund);

		return prescriptionSection;
	}

	public Cdarezept getEMedicationPrescription() {
		Cdarezept cda = new Cdarezept();

		addHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(getHl7CdaR2Pocdmt000040StructuredBodyEMedicationPrescription());
		cda.setHl7Component(comp2);

		return cda;
	}

	private void addHeader(POCDMT000040ClinicalDocument cda) {
		cda.setId(getDocId().getHl7CdaR2Ii());
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		cda.setSetId(getSetId().getHl7CdaR2Ii());
		cda.setVersionNumber(new INT(this.getVersion()));

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

		cda.getDocumentationOf().add(getAtcdabbrHeaderDocumentationOfServiceEvent());

		if (this.getParentDocument() != null && this.getParentDocument().getRoot() != null) {
			cda.getRelatedDocument().add(getAtcdabbrHeaderDocumentReplacementRelatedDocument());
		}

	}
}
