/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.lab;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.base.Annotation;
import org.projecthusky.cda.elga.generated.artdecor.base.Brieftext;
import org.projecthusky.cda.elga.generated.artdecor.base.HeaderInFulfillmentOf;
import org.projecthusky.cda.elga.generated.artdecor.base.HeaderRelatedDocument;
import org.projecthusky.cda.elga.generated.artdecor.base.LaboratoryReportCommentSection;
import org.projecthusky.cda.elga.generated.artdecor.base.LaboratorySpecimenEntry;
import org.projecthusky.cda.elga.generated.artdecor.base.Laborbefund;
import org.projecthusky.cda.elga.generated.artdecor.base.SpecialitySection;
import org.projecthusky.cda.elga.generated.artdecor.base.SpezimenSection;
import org.projecthusky.cda.elga.generated.artdecor.base.Ueberweisungsgrund;
import org.projecthusky.cda.elga.models.Appendix;
import org.projecthusky.cda.elga.models.BaseDocument;
import org.projecthusky.cda.elga.models.PatientCdaAt;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.narrative.AnnotationTextBuilder;
import org.projecthusky.cda.elga.narrative.SpecimenNarrativeTextGenerator;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.INT;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040AssociatedEntity;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component2;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component3;
import org.projecthusky.common.hl7cdar2.POCDMT000040DocumentationOf;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040InFulfillmentOf;
import org.projecthusky.common.hl7cdar2.POCDMT000040Participant1;
import org.projecthusky.common.hl7cdar2.POCDMT000040Section;
import org.projecthusky.common.hl7cdar2.POCDMT000040ServiceEvent;
import org.projecthusky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Organization;
import org.projecthusky.common.utils.time.DateTimes;

public class LaboratoryReport extends BaseDocument {

	private Identificator docId;
	private Identificator setId;
	private int version;
	private String title;
	private PatientCdaAt patient;
	private List<PractitionerCdaAt> authors;
	private ZonedDateTime authorTime;
	private Organization custodian;
	private PractitionerCdaAt legalAuthenticator;
	private PractitionerCdaAt dataEnterer;
	private PractitionerCdaAt orderingProvider;
	private Identificator orderId;
	private ZonedDateTime startTime;
	private ZonedDateTime stopTime;
	private ZonedDateTime orderingDate;
	private Identificator parentDocument;
	private Code kindOfLaboratory;
	private Identificator gdaId;
	private List<SpecimenCollection> specimenCollection;
	private String logo;
	private String lettertext;
	private String reasonForReferral;
	private Code structure;
	private List<LaboratoryReportData> laboratoryData;
	private String note;
	private List<Appendix> appendices;

	public Identificator getDocId() {
		return docId;
	}

	public Identificator getSetId() {
		return setId;
	}

	public int getVersion() {
		return version;
	}

	public String getTitle() {
		return title;
	}

	public PatientCdaAt getPatient() {
		return patient;
	}

	public List<PractitionerCdaAt> getAuthors() {
		return authors;
	}

	public ZonedDateTime getAuthorTime() {
		return authorTime;
	}

	public Organization getCustodian() {
		return custodian;
	}

	public PractitionerCdaAt getLegalAuthenticator() {
		return legalAuthenticator;
	}

	public PractitionerCdaAt getDataEnterer() {
		return dataEnterer;
	}

	public PractitionerCdaAt getOrderingProvider() {
		return orderingProvider;
	}
	
	public Identificator getOrderId() {
		return orderId;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public ZonedDateTime getStopTime() {
		return stopTime;
	}

	public ZonedDateTime getOrderingDate() {
		return orderingDate;
	}

	public Identificator getParentDocument() {
		return parentDocument;
	}

	public Code getKindOfLaboratory() {
		return kindOfLaboratory;
	}

	public Identificator getGdaId() {
		return gdaId;
	}

	public List<SpecimenCollection> getSpecimenCollection() {
		return specimenCollection;
	}
	
	public String getLogo() {
		return logo;
	}

	public String getLettertext() {
		return lettertext;
	}

	public String getReasonForReferral() {
		return reasonForReferral;
	}

	public Code getStructure() {
		return structure;
	}

	public List<LaboratoryReportData> getLaboratoryData() {
		return laboratoryData;
	}

	public String getNote() {
		return note;
	}

	public List<Appendix> getAppendices() {
		return appendices;
	}

	public void setDocId(Identificator docId) {
		this.docId = docId;
	}

	public void setSetId(Identificator setId) {
		this.setId = setId;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPatient(PatientCdaAt patient) {
		this.patient = patient;
	}

	public void setAuthors(List<PractitionerCdaAt> authors) {
		this.authors = authors;
	}

	public void setAuthorTime(ZonedDateTime authorTime) {
		this.authorTime = authorTime;
	}

	public void setCustodian(Organization custodian) {
		this.custodian = custodian;
	}

	public void setLegalAuthenticator(PractitionerCdaAt legalAuthenticator) {
		this.legalAuthenticator = legalAuthenticator;
	}

	public void setDataEnterer(PractitionerCdaAt dataEnterer) {
		this.dataEnterer = dataEnterer;
	}

	public void setOrderingProvider(PractitionerCdaAt orderingProvider) {
		this.orderingProvider = orderingProvider;
	}
	
	public void setOrderId(Identificator id) {
		this.orderId = id;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public void setStopTime(ZonedDateTime stopTime) {
		this.stopTime = stopTime;
	}

	public void setOrderingDate(ZonedDateTime orderingDate) {
		this.orderingDate = orderingDate;
	}

	public void setParentDocument(Identificator parentDocument) {
		this.parentDocument = parentDocument;
	}

	public void setKindOfLaboratory(Code kindOfLaboratory) {
		this.kindOfLaboratory = kindOfLaboratory;
	}

	public void setGdaId(Identificator gdaId) {
		this.gdaId = gdaId;
	}

	public void setSpecimenCollection(List<SpecimenCollection> specimenCollection) {
		this.specimenCollection = specimenCollection;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}

	public void setLettertext(String lettertext) {
		this.lettertext = lettertext;
	}

	public void setReasonForReferral(String reasonForReferral) {
		this.reasonForReferral = reasonForReferral;
	}

	public void setStructure(Code structure) {
		this.structure = structure;
	}

	public void setLaboratoryData(List<LaboratoryReportData> laboratoryData) {
		this.laboratoryData = laboratoryData;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setAppendices(List<Appendix> appendices) {
		this.appendices = appendices;
	}

	protected POCDMT000040DocumentationOf getAtcdabbrHeaderDocumentationOfServiceEvent() {
		POCDMT000040DocumentationOf documentationOfServiceEvent = new POCDMT000040DocumentationOf();
		documentationOfServiceEvent.getTypeCode().add("DOC");
		POCDMT000040ServiceEvent serviceEvent = new POCDMT000040ServiceEvent();

		if (kindOfLaboratory != null) {
			serviceEvent.setCode(kindOfLaboratory.getHl7CdaR2Ce());
		}

		if (startTime != null && stopTime != null) {
			IVLTS time = new IVLTS();
			time.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(startTime)));
			time.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(stopTime)));
			serviceEvent.setEffectiveTime(time);
		}

		documentationOfServiceEvent.setServiceEvent(serviceEvent);

		return documentationOfServiceEvent;
	}

	protected HeaderRelatedDocument getAtcdabbrHeaderDocumentReplacementRelatedDocument() {
		HeaderRelatedDocument relatedDocument = new HeaderRelatedDocument();
		relatedDocument.getHl7ParentDocument().getId().add(this.parentDocument.getHl7CdaR2Ii());
		return relatedDocument;
	}

	protected POCDMT000040StructuredBody getHl7CdaR2Pocdmt000040StructuredBodyLaboratoryReport() {
		POCDMT000040StructuredBody structuredBody = new POCDMT000040StructuredBody();
		structuredBody.getClassCode().add("DOCBODY");
		structuredBody.getMoodCode().add("EVN");

		if (this.lettertext != null && !this.lettertext.isEmpty()) {
			structuredBody.getComponent().add(createComp3FreeText(new Brieftext(), this.lettertext, "Brieftext"));
		}

		if (this.reasonForReferral != null && !this.reasonForReferral.isEmpty()) {
			structuredBody.getComponent()
					.add(createComp3FreeText(new Ueberweisungsgrund(), this.reasonForReferral, "Überweisungsgrund"));
		}

		if (specimenCollection != null && !specimenCollection.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getSpezimenSection());
			structuredBody.getComponent().add(comp3);
		}

		if (laboratoryData != null && !laboratoryData.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getSpecialitySection());
			structuredBody.getComponent().add(comp3);
		}

		if (note != null && !note.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getLaboratoryReportCommentSection());
			structuredBody.getComponent().add(comp3);
		}

		if (appendices != null && !appendices.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getAppendixSection(this.appendices, "laboratory-report"));
			structuredBody.getComponent().add(comp3);
		}

		return structuredBody;
	}

	protected POCDMT000040Section getSpezimenSection() {
		SpezimenSection section = new SpezimenSection();

		ST stTitle = new ST();
		stTitle.setXmlMixed("Probeninformation");
		section.setHl7Title(stTitle);

		if (specimenCollection != null && !specimenCollection.isEmpty()) {
			for (SpecimenCollection collection : specimenCollection) {
				POCDMT000040Entry entry = new POCDMT000040Entry();
				entry.setTypeCode(XActRelationshipEntry.DRIV);

				LaboratorySpecimenEntry labSpecimentAct = new LaboratorySpecimenEntry();
				POCDMT000040EntryRelationship rel = new POCDMT000040EntryRelationship();
				rel.setTypeCode(XActRelationshipEntryRelationship.COMP);
				rel.setProcedure(collection.getLaboratorySpecimenCollection(authors.get(0).getGdaIndex()));
				labSpecimentAct.getEntryRelationship().add(rel);

				entry.setAct(labSpecimentAct);
				section.getHl7Entry().add(entry);
			}
		}

		StrucDocText text = new StrucDocText();
		SpecimenNarrativeTextGenerator textbuilder = new SpecimenNarrativeTextGenerator(section.getHl7Entry());
		text.getContent().add(textbuilder.toString());
		section.setHl7Text(text);

		return section;
	}

	protected POCDMT000040Section getLaboratoryReportCommentSection() {
		LaboratoryReportCommentSection section = new LaboratoryReportCommentSection();

		ST stTitle = new ST();
		stTitle.setXmlMixed("Befundbewertung");
		section.setHl7Title(stTitle);

		if (note != null) {
			POCDMT000040Entry entry = new POCDMT000040Entry();
			Annotation annotation = new Annotation();
			annotation.setText(new ED(null, new TEL("#commonComment-" + 0)));
			entry.setAct(annotation);
			section.getHl7Entry().add(entry);
		}

		StrucDocText text = new StrucDocText();
		AnnotationTextBuilder textbuilder = new AnnotationTextBuilder(section.getEntry(), Arrays.asList(note));
		text.getContent().add(textbuilder.toString());
		section.setHl7Text(text);

		return section;
	}

	protected POCDMT000040Section getSpecialitySection() {
		SpecialitySection section = new SpecialitySection();
		section.setHl7Code(structure.getHl7CdaR2Ce());

		ST stTitle = new ST();
		stTitle.setXmlMixed(structure.getDisplayName());
		section.setHl7Title(stTitle);

		if (laboratoryData != null && !laboratoryData.isEmpty()) {
			for (LaboratoryReportData data : laboratoryData) {
				section.addHl7Entry(data.getPOCDMT000040Entry(gdaId.getRoot()));
			}
		}

		StrucDocText text = new StrucDocText();
		AnnotationTextBuilder textbuilder = new AnnotationTextBuilder(section.getEntry(), Arrays.asList(note));
		text.getContent().add(textbuilder.toString());
		section.setHl7Text(text);

		return section;
	}

	public Laborbefund getLaboratoryReport() {
		Laborbefund cda = new Laborbefund();

		addHeader(cda);

		POCDMT000040Component2 comp2 = new POCDMT000040Component2();
		comp2.setStructuredBody(getHl7CdaR2Pocdmt000040StructuredBodyLaboratoryReport());
		cda.setHl7Component(comp2);

		return cda;
	}

	private void addHeader(Laborbefund cda) {
		cda.setHl7Id(docId.getHl7CdaR2Ii());
		cda.setEffectiveTime(DateTimes.toDatetimeTs(ZonedDateTime.now()));

		cda.setSetId(setId.getHl7CdaR2Ii());
		cda.setVersionNumber(new INT(version));
		ST stTitle = new ST();
		stTitle.setXmlMixed(title);
		cda.setHl7Title(stTitle);

		cda.getHl7TemplateId().add(new Identificator("1.2.40.0.34.11.4.0.3").getHl7CdaR2Ii());

		if (patient != null) {
			cda.getRecordTarget().clear();
			cda.getRecordTarget().add(patient.getHeaderRecordTargetBase());
		}

		if (this.authors != null && !this.authors.isEmpty()) {
			for (PractitionerCdaAt author : this.authors) {
				cda.getAuthor().add(author.getAtcdabbrHeaderAuthor(authorTime));
			}
		}

		if (dataEnterer != null) {
			cda.setDataEnterer(dataEnterer.getHeaderDataEnterer(this.authorTime));
		}

		if (custodian != null) {
			cda.setCustodian(custodian.getHl7CdaR2Pocdmt000040Custodian());
		}

		if (legalAuthenticator != null) {
			cda.setLegalAuthenticator(legalAuthenticator.getHeaderLegalAuthenticator(this.authorTime));
		}

		POCDMT000040Participant1 participantOrderingProvdier;
		if (orderingProvider != null) {
			participantOrderingProvdier = orderingProvider.getHeaderOrderingProvider(orderingDate);
		} else {
			participantOrderingProvdier = new POCDMT000040Participant1();
			participantOrderingProvdier.getTypeCode().add("REF");
			participantOrderingProvdier.getNullFlavor().add("UNK");
			POCDMT000040AssociatedEntity entity = new POCDMT000040AssociatedEntity();
			entity.getClassCode().add("PROV");
			participantOrderingProvdier.setAssociatedEntity(entity);
		}
		cda.getParticipant().add(participantOrderingProvdier);
		
		if(this.orderId != null) {
			cda.getInFulfillmentOf().add(getPOCDMT000040InFulfillmentOf());
		}

		cda.addHl7DocumentationOf(getAtcdabbrHeaderDocumentationOfServiceEvent());

		if (this.parentDocument != null && this.parentDocument.getRoot() != null) {
			cda.getRelatedDocument().add(getAtcdabbrHeaderDocumentReplacementRelatedDocument());
		}

	}
	
	private POCDMT000040InFulfillmentOf getPOCDMT000040InFulfillmentOf() {
		HeaderInFulfillmentOf fulfillmentOf = new HeaderInFulfillmentOf();
		fulfillmentOf.getHl7Order().getId().add(this.orderId.getHl7CdaR2Ii());
		return fulfillmentOf;
	}

}
