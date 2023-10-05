/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.ems;

import java.io.StringWriter;
import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsDocumentArztmeldung;
import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsEntryHospitalization;
import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsHeaderRecordTarget;
import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsPatient;
import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsPatientRole;
import org.projecthusky.cda.elga.generated.artdecor.ems.EpimsSectionEmssectionArztmeldung;
import org.projecthusky.cda.elga.models.PatientCdaAt;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.narrative.ArztmeldungNarrativeTextGenerator;
import org.projecthusky.cda.elga.utils.DateTimeUtils;
import org.projecthusky.common.at.OrganizationAt;
import org.projecthusky.common.at.enums.ConfidentialityCode;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component2;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component3;
import org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040InfrastructureRootTypeId;
import org.projecthusky.common.hl7cdar2.POCDMT000040Performer1;
import org.projecthusky.common.hl7cdar2.POCDMT000040RelatedDocument;
import org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent;
import org.projecthusky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.common.hl7cdar2.XServiceEventPerformer;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.time.DateTimes;

public class Arztmeldung {

	private Identificator docId;
	private Identificator setId;
	private int version;
	private PatientCdaAt patient;
	private List<PractitionerCdaAt> authors;
	private ZonedDateTime authorTime;
	private OrganizationAt custodian;
	private PractitionerCdaAt legalAuthenticator;
	private InformationRecipient informationRecipient;
	private ZonedDateTime startValidityPeriod;
	private ZonedDateTime stopValidityPeriod;
	private ZonedDateTime startPossibleInfection;
	private ZonedDateTime stopPossibleInfection;
	private ZonedDateTime startPhysicianVisit;
	private ZonedDateTime stopPhysicianVisit;
	private PractitionerCdaAt reportingPhysician;
	private Identificator parentDocument;
	private CaseIdentification caseIdentification;
	private Identificator gdaId;
	private ZonedDateTime hospitalisation;
	private ClinicalManifestation clinicalManifestation;
	private Care care;
	private ActivityArea activitArea;

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

	public OrganizationAt getCustodian() {
		return custodian;
	}

	public void setCustodian(OrganizationAt custodian) {
		this.custodian = custodian;
	}

	public PractitionerCdaAt getLegalAuthenticator() {
		return legalAuthenticator;
	}

	public void setLegalAuthenticator(PractitionerCdaAt legalAuthenticator) {
		this.legalAuthenticator = legalAuthenticator;
	}

	public InformationRecipient getInformationRecipient() {
		return informationRecipient;
	}

	public void setInformationRecipient(InformationRecipient informationRecipient) {
		this.informationRecipient = informationRecipient;
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

	public ZonedDateTime getStartPossibleInfection() {
		return startPossibleInfection;
	}

	public void setStartPossibleInfection(ZonedDateTime startPossibleInfection) {
		this.startPossibleInfection = startPossibleInfection;
	}

	public ZonedDateTime getStopPossibleInfection() {
		return stopPossibleInfection;
	}

	public void setStopPossibleInfection(ZonedDateTime stopPossibleInfection) {
		this.stopPossibleInfection = stopPossibleInfection;
	}

	public ZonedDateTime getStartPhysicianVisit() {
		return startPhysicianVisit;
	}

	public void setStartPhysicianVisit(ZonedDateTime startPhysicianVisit) {
		this.startPhysicianVisit = startPhysicianVisit;
	}

	public ZonedDateTime getStopPhysicianVisit() {
		return stopPhysicianVisit;
	}

	public void setStopPhysicianVisit(ZonedDateTime stopPhysicianVisit) {
		this.stopPhysicianVisit = stopPhysicianVisit;
	}

	public PractitionerCdaAt getReportingPhysician() {
		return reportingPhysician;
	}

	public void setReportingPhysician(PractitionerCdaAt reportingPhysician) {
		this.reportingPhysician = reportingPhysician;
	}

	public Identificator getParentDocument() {
		return parentDocument;
	}

	public void setParentDocument(Identificator parentDocument) {
		this.parentDocument = parentDocument;
	}

	public Identificator getGdaId() {
		return gdaId;
	}

	public void setGdaId(Identificator gdaId) {
		this.gdaId = gdaId;
	}

	public ZonedDateTime getHospitalisation() {
		return hospitalisation;
	}

	public void setHospitalisation(ZonedDateTime hospitalisation) {
		this.hospitalisation = hospitalisation;
	}

	public CaseIdentification getCaseIdentification() {
		return caseIdentification;
	}

	public void setCaseIdentification(CaseIdentification caseIdentification) {
		this.caseIdentification = caseIdentification;
	}

	public ClinicalManifestation getClinicalManifestation() {
		return clinicalManifestation;
	}

	public void setClinicalManifestation(ClinicalManifestation clinicalManifestation) {
		this.clinicalManifestation = clinicalManifestation;
	}

	public Care getCare() {
		return care;
	}

	public void setCare(Care care) {
		this.care = care;
	}

	public ActivityArea getActivitArea() {
		return activitArea;
	}

	public void setActivitArea(ActivityArea activitArea) {
		this.activitArea = activitArea;
	}

	protected POCDMT000040DocumentationOf getAtcdabbrHeaderDocumentationOfServiceEvent(Code serviceEventCode,
			ZonedDateTime start, ZonedDateTime stop) {
		POCDMT000040DocumentationOf documentationOfServiceEvent = new POCDMT000040DocumentationOf();
		POCDMT000040ServiceEvent serviceEvent = new POCDMT000040ServiceEvent();

		serviceEvent.setCode(serviceEventCode.getHl7CdaR2Ce());
		serviceEvent.setEffectiveTime(DateTimeUtils.createIvlts(start, stop));

		documentationOfServiceEvent.setServiceEvent(serviceEvent);

		return documentationOfServiceEvent;
	}

	protected POCDMT000040RelatedDocument getAtcdabbrHeaderDocumentReplacementRelatedDocument() {
		POCDMT000040RelatedDocument relatedDocument = new POCDMT000040RelatedDocument();
		relatedDocument.getParentDocument().getId().add(this.parentDocument.getHl7CdaR2Ii());
		return relatedDocument;
	}

	protected POCDMT000040StructuredBody getHl7CdaR2Pocdmt000040StructuredBody() {
		POCDMT000040StructuredBody structuredBody = new POCDMT000040StructuredBody();
		structuredBody.getClassCode().add("DOCBODY");
		structuredBody.getMoodCode().add("EVN");

		if (this.caseIdentification != null) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getSection());
			structuredBody.getComponent().add(comp3);
		}

		return structuredBody;
	}

	protected EpimsSectionEmssectionArztmeldung getSection() {
		if (this.caseIdentification == null) {
			return null;
		}

		EpimsSectionEmssectionArztmeldung section = new EpimsSectionEmssectionArztmeldung();
		section.setTitle(new ST("Arztmeldung"));
		section.getEntry().clear();
		section.getEntry().add(this.caseIdentification.getEpimsEntryCaseIdenticationArzt());

		if (this.hospitalisation != null) {
			section.getEntry().add(getHospitalisationEntry());
		}

		if (this.clinicalManifestation != null) {
			section.getEntry().add(this.clinicalManifestation.getEpimsEntryProblemConcernEntry());
		}

		StrucDocText textKonsUeberwGrund = new StrucDocText();
		ArztmeldungNarrativeTextGenerator textbuilder = new ArztmeldungNarrativeTextGenerator(this);
		textKonsUeberwGrund.getContent().add(textbuilder.getTable());
		section.setText(textKonsUeberwGrund);

		return section;
	}

	public EpimsDocumentArztmeldung getArztmeldung() {
		EpimsDocumentArztmeldung cda = new EpimsDocumentArztmeldung();
		cda.setHl7RealmCode(new CS("AT"));
		POCDMT000040InfrastructureRootTypeId typeId = new POCDMT000040InfrastructureRootTypeId();
		typeId.setExtension("POCD_HD000040");
		typeId.setRoot("2.16.840.1.113883.1.3");
		cda.setTypeId(typeId);
		cda.setLanguageCode(new CS("de-AT"));
		cda.setTitle(new ST("Arztmeldung"));

		CE confidentialityCode = ConfidentialityCode.NORMAL.getCE();
		confidentialityCode.setCodeSystemName("HL7:Confidentiality");
		cda.setConfidentialityCode(confidentialityCode);

		addHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(getHl7CdaR2Pocdmt000040StructuredBody());
		cda.setHl7Component(comp2);

		return cda;
	}

	public POCDMT000040Entry getHospitalisationEntry() {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		EpimsEntryHospitalization hospitalizationEntryAct = new EpimsEntryHospitalization();
		hospitalizationEntryAct.setEffectiveTime(new IVLTS(DateTimes.toDatetimeTs(this.hospitalisation).getValue()));
		entry.setAct(hospitalizationEntryAct);
		return entry;
	}

	private void addHeader(EpimsDocumentArztmeldung cda) {
		cda.setHl7Id(getDocId().getHl7CdaR2Ii());
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		cda.setSetId(getSetId().getHl7CdaR2Ii());
		cda.setVersionNumber(new INT(this.version));

		if (patient != null) {
			cda.getRecordTarget().clear();
			cda.getRecordTarget().add(patient.getHeaderRecordTarget());
		}

		if (this.getAuthors() != null && !this.getAuthors().isEmpty()) {
			for (PractitionerCdaAt author : getAuthors()) {
				cda.getAuthor().add(author.getAtcdabbrHeaderAuthor(authorTime));
			}
		}

		if (custodian != null) {
			cda.setCustodian(this.custodian.createHeaderCustodian());
		}

		if (legalAuthenticator != null) {
			cda.setLegalAuthenticator(legalAuthenticator.getHeaderLegalAuthenticator(this.getAuthorTime()));
		}

		if (informationRecipient != null) {
			cda.setHl7InformationRecipient(informationRecipient.getPOCDMT000040InformationRecipient());
		}

		Code serviceEventInfectiousDiseaseNote = new Code();
		serviceEventInfectiousDiseaseNote.setCode("34782-3");
		serviceEventInfectiousDiseaseNote.setCodeSystem("2.16.840.1.113883.6.1");
		serviceEventInfectiousDiseaseNote.setCodeSystemName("LOINC");
		serviceEventInfectiousDiseaseNote.setDisplayName("Infectious disease Note");

		cda.getDocumentationOf().add(getAtcdabbrHeaderDocumentationOfServiceEvent(serviceEventInfectiousDiseaseNote,
				this.startPossibleInfection, this.stopPossibleInfection));

		Code serviceEventPhysicianNote = new Code();
		serviceEventPhysicianNote.setCode("75476-2");
		serviceEventPhysicianNote.setCodeSystem("2.16.840.1.113883.6.1");
		serviceEventPhysicianNote.setCodeSystemName("LOINC");
		serviceEventPhysicianNote.setDisplayName("Physician Note");
		
		POCDMT000040DocumentationOf documentationOf = getAtcdabbrHeaderDocumentationOfServiceEvent(serviceEventPhysicianNote,
				this.startPhysicianVisit, this.stopPhysicianVisit);

		if(this.getReportingPhysician() != null) {
			POCDMT000040Performer1 performer = this.getReportingPhysician().getPerformer();
			performer.setTypeCode(XServiceEventPerformer.PRF);
			performer.getTemplateId().add(new II("1.3.6.1.4.1.19376.1.3.3.1.7"));
			documentationOf.getServiceEvent().getPerformer().add(performer);
		}
		
		cda.getDocumentationOf().add(documentationOf);

		if (this.getParentDocument() != null && this.getParentDocument().getRoot() != null) {
			cda.getRelatedDocument().add(getAtcdabbrHeaderDocumentReplacementRelatedDocument());
		}

	}

	/**
	 * Marshalles a Arztmeldung CDA document to a {@link String}.
	 *
	 * @return the XML representation of the {@code clinicalDocument}.
	 * @throws JAXBException if an error was encountered while creating the
	 *                       marshaller.
	 */
	public String marshall() throws JAXBException {
		final var jaxbContext = JAXBContext.newInstance(EpimsDocumentArztmeldung.class, EpimsHeaderRecordTarget.class,
				EpimsPatientRole.class, EpimsPatient.class);
		final var marshaller = jaxbContext.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, true); // Remove the marshaller XML declaration

		final var writer = new StringWriter();
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); // This is required by the CCE spec
		marshaller.marshal(this.getArztmeldung(), writer);
		return writer.toString();
	}

}
