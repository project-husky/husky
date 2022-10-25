/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models.eimpf;

import java.time.ZonedDateTime;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderDocumentReplacementRelatedDocument;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrHeaderDocumentationOfServiceEventEImpfpass;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabrrSectionExpositionsrisikoPersonengruppenKodiert;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabrrSectionImpfempfehlungenKodiert;
import org.projecthusky.cda.elga.generated.artdecor.AtcdabrrSectionImpfungenKodiert;
import org.projecthusky.cda.elga.generated.artdecor.EimpfSectionAntikoerperBestimmungKodiert;
import org.projecthusky.cda.elga.generated.artdecor.EimpfSectionImpfrelevanteErkrankungen;
import org.projecthusky.cda.elga.models.Disease;
import org.projecthusky.cda.elga.models.PatientCdaAt;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.cda.elga.models.Translation;
import org.projecthusky.cda.elga.narrative.ExposureRiskNarrativeTextGenerator;
import org.projecthusky.cda.elga.narrative.ImmunizationLabResultNarrativeTextGenerator;
import org.projecthusky.cda.elga.narrative.ImmunizationNarrativeTextGenerator;
import org.projecthusky.cda.elga.narrative.ImmunizationRecommendationNarrativeTextGenerator;
import org.projecthusky.cda.elga.narrative.ImmunizationRelevantDiseasesNarrativeTextGenerator;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.ActRelationshipHasComponent;
import org.projecthusky.common.hl7cdar2.CE;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component3;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component5;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040Section;
import org.projecthusky.common.hl7cdar2.POCDMT000040StructuredBody;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Organization;
import org.projecthusky.common.utils.time.DateTimes;

public class ImmunizationState {

	private String title;
	private String docId;
	private String setId;
	private int version;
	private PatientCdaAt patient;
	private List<PractitionerCdaAt> authors;
	private ZonedDateTime authorTime;
	private Organization custodian;
	private ZonedDateTime startImmunization;
	private ZonedDateTime stopImmunization;
	private Identificator parentDocument;
	private List<Immunization> immunizations;
	private List<ExposureRiskPersonGroup> exposureRiskPersons;
	private List<Disease> immunizationRelevantDiseases;
	private List<AntibodyDetermination> antibodyDeterminations;
	private List<ImmunizationRecommendation> immunizationRecommendations;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public ZonedDateTime getStartImmunization() {
		return startImmunization;
	}

	public void setStartImmunization(ZonedDateTime startImmunization) {
		this.startImmunization = startImmunization;
	}

	public ZonedDateTime getStopImmunization() {
		return stopImmunization;
	}

	public void setStopImmunization(ZonedDateTime stopImmunization) {
		this.stopImmunization = stopImmunization;
	}

	public Identificator getParentDocument() {
		return parentDocument;
	}

	public void setParentDocument(Identificator parentDocument) {
		this.parentDocument = parentDocument;
	}

	public List<Immunization> getImmunizations() {
		return immunizations;
	}

	public void setImmunizations(List<Immunization> immunizations) {
		this.immunizations = immunizations;
	}

	public List<ExposureRiskPersonGroup> getExposureRiskPersons() {
		return exposureRiskPersons;
	}

	public void setExposureRiskPersons(List<ExposureRiskPersonGroup> exposureRiskPersons) {
		this.exposureRiskPersons = exposureRiskPersons;
	}

	public List<Disease> getImmunizationRelevantDiseases() {
		return immunizationRelevantDiseases;
	}

	public void setImmunizationRelevantDiseases(List<Disease> immunizationRelevantDiseases) {
		this.immunizationRelevantDiseases = immunizationRelevantDiseases;
	}

	public List<AntibodyDetermination> getAntibodyDeterminations() {
		return antibodyDeterminations;
	}

	public void setAntibodyDeterminations(List<AntibodyDetermination> antibodyDeterminations) {
		this.antibodyDeterminations = antibodyDeterminations;
	}

	public List<ImmunizationRecommendation> getImmunizationRecommendations() {
		return immunizationRecommendations;
	}

	public void setImmunizationRecommendations(List<ImmunizationRecommendation> immunizationRecommendations) {
		this.immunizationRecommendations = immunizationRecommendations;
	}

	protected AtcdabbrHeaderDocumentationOfServiceEventEImpfpass getAtcdabbrHeaderDocumentationOfServiceEvent() {
		AtcdabbrHeaderDocumentationOfServiceEventEImpfpass documentationOfServiceEvent = new AtcdabbrHeaderDocumentationOfServiceEventEImpfpass();

		CE eventCode = new CE("41000179103", "2.16.840.1.113883.6.96", "SNOMEDCT",
				"Immunization record (record artifact)");
		documentationOfServiceEvent.getServiceEvent().setCode(eventCode);

		documentationOfServiceEvent.getServiceEvent().setEffectiveTime(new IVLTS());

		if (startImmunization != null) {
			documentationOfServiceEvent.getServiceEvent().getEffectiveTime().getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(startImmunization)));
		}

		if (stopImmunization != null) {
			documentationOfServiceEvent.getServiceEvent().getEffectiveTime().getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(stopImmunization)));
		}

		return documentationOfServiceEvent;
	}

	protected AtcdabbrHeaderDocumentReplacementRelatedDocument getAtcdabbrHeaderDocumentReplacementRelatedDocument() {
		AtcdabbrHeaderDocumentReplacementRelatedDocument relatedDocument = new AtcdabbrHeaderDocumentReplacementRelatedDocument();
		relatedDocument.getHl7ParentDocument().getId().add(this.parentDocument.getHl7CdaR2Ii());
		return relatedDocument;
	}

	protected POCDMT000040StructuredBody getHl7CdaR2Pocdmt000040StructuredBodyImmunizationState() {
		POCDMT000040StructuredBody structuredBody = new POCDMT000040StructuredBody();
		structuredBody.getClassCode().add("DOCBODY");
		structuredBody.getMoodCode().add("EVN");

		if (this.immunizations != null && !this.immunizations.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getAtcdabbrSectionImpfungenKodiert());
			structuredBody.getComponent().add(comp3);
		}

		if (this.exposureRiskPersons != null) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getAtcdabbrSectionExpositionsrisikoPersonengruppenKodiert());
			structuredBody.getComponent().add(comp3);
		}

		if (this.immunizationRelevantDiseases != null && !this.immunizationRelevantDiseases.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getEimpfSectionImpfrelevanteErkrankungen());
			structuredBody.getComponent().add(comp3);
		}

		if (this.antibodyDeterminations != null && !this.antibodyDeterminations.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getEimpfSectionAntikoerperBestimmungKodiert());
			structuredBody.getComponent().add(comp3);
		}

		if (this.immunizationRecommendations != null && !this.immunizationRecommendations.isEmpty()) {
			POCDMT000040Component3 comp3 = new POCDMT000040Component3();
			comp3.setSection(getAtcdabbrSectionImpfempfehlungenKodiert());
			structuredBody.getComponent().add(comp3);
		}

		return structuredBody;
	}

	protected AtcdabrrSectionImpfungenKodiert getAtcdabbrSectionImpfungenKodiert() {
		if (this.immunizations == null || this.immunizations.isEmpty()) {
			return null;
		}

		AtcdabrrSectionImpfungenKodiert vaccinationSection = new AtcdabrrSectionImpfungenKodiert();
		vaccinationSection.setTitle(createTitle("Impfungen"));

		int index = 0;
		for (Immunization immunization : immunizations) {
			if (immunization != null) {
				vaccinationSection.getEntry().add(immunization.getImmunizationEntry(index++));

				if (immunization.getTranslations() != null) {
					for (Translation translation : immunization.getTranslations()) {
						if (translation != null) {
							vaccinationSection.getComponent()
									.add(getPOCDMT000040Component5(ActRelationshipHasComponent.COMP, true,
											translation.getAtcdabbrSectionUebersetzung()));
						}
					}
				}
			}
		}

		StrucDocText narrativeVaccText = new StrucDocText();
		ImmunizationNarrativeTextGenerator textbuilder = new ImmunizationNarrativeTextGenerator(
				vaccinationSection.getEntry());
		narrativeVaccText.getContent().addAll(textbuilder.getTables());
		vaccinationSection.setText(narrativeVaccText);

		return vaccinationSection;
	}

	protected AtcdabrrSectionExpositionsrisikoPersonengruppenKodiert getAtcdabbrSectionExpositionsrisikoPersonengruppenKodiert() {
		if (this.exposureRiskPersons == null || this.exposureRiskPersons.isEmpty()) {
			return null;
		}

		AtcdabrrSectionExpositionsrisikoPersonengruppenKodiert riskGroupSection = new AtcdabrrSectionExpositionsrisikoPersonengruppenKodiert();
		riskGroupSection.setTitle(createTitle("Spezielle Impfindikation"));

		int index = 0;
		for (ExposureRiskPersonGroup personGroup : this.exposureRiskPersons) {
			riskGroupSection.getEntry().add(personGroup.getExposureRiskPersonGroupEntry(index++));

			if (personGroup.getTranslations() != null) {
				for (Translation translation : personGroup.getTranslations()) {
					if (translation != null) {
						riskGroupSection.getComponent().add(getPOCDMT000040Component5(
								ActRelationshipHasComponent.COMP, true, translation.getAtcdabbrSectionUebersetzung()));
					}
				}
			}
		}

		StrucDocText textRisks = new StrucDocText();
		ExposureRiskNarrativeTextGenerator textbuilder = new ExposureRiskNarrativeTextGenerator(
				riskGroupSection.getEntry());
		textRisks.getContent().add(textbuilder.toString());
		riskGroupSection.setText(textRisks);

		return riskGroupSection;
	}

	protected EimpfSectionImpfrelevanteErkrankungen getEimpfSectionImpfrelevanteErkrankungen() {
		if (this.immunizationRelevantDiseases == null || this.immunizationRelevantDiseases.isEmpty()) {
			return null;
		}

		EimpfSectionImpfrelevanteErkrankungen relevantDiseases = new EimpfSectionImpfrelevanteErkrankungen();
		relevantDiseases.setTitle(createTitle("Impfrelevante Erkrankungen"));

		relevantDiseases.getEntry().clear();
		int index = 0;
		for (Disease disease : this.immunizationRelevantDiseases) {
			if (disease != null) {
				POCDMT000040Entry entry = new POCDMT000040Entry();
				entry.setTypeCode(XActRelationshipEntry.DRIV);
				entry.setContextConductionInd(true);
				entry.setAct(disease.getEimpfEntryImpfrelevanteErkrankungenProblemConcern(index++));
				relevantDiseases.getEntry().add(entry);

				if (disease.getTranslations() != null) {
					for (Translation translation : disease.getTranslations()) {
						if (translation != null) {
							relevantDiseases.getComponent()
									.add(getPOCDMT000040Component5(ActRelationshipHasComponent.COMP, true,
											translation.getAtcdabbrSectionUebersetzung()));
						}
					}
				}
			}
		}

		StrucDocText relevanteDiseasesText = new StrucDocText();
		ImmunizationRelevantDiseasesNarrativeTextGenerator textbuilder = new ImmunizationRelevantDiseasesNarrativeTextGenerator(
				relevantDiseases.getEntry());
		relevanteDiseasesText.getContent().add(textbuilder.toString());
		relevantDiseases.setText(relevanteDiseasesText);

		return relevantDiseases;
	}

	protected EimpfSectionAntikoerperBestimmungKodiert getEimpfSectionAntikoerperBestimmungKodiert() {
		if (this.antibodyDeterminations == null || this.antibodyDeterminations.isEmpty()) {
			return null;
		}

		EimpfSectionAntikoerperBestimmungKodiert antibodiesSection = new EimpfSectionAntikoerperBestimmungKodiert();
		antibodiesSection.setTitle(createTitle("Laboruntersuchungen"));

		int index = 0;
		antibodiesSection.getEntry().clear();
		for (AntibodyDetermination determination : this.antibodyDeterminations) {
			antibodiesSection.getEntry().add(determination.getEimpfEntryAntikoerperBestimmungDataProcessing(index++));

			if (determination.getTranslations() != null) {
				for (Translation translation : determination.getTranslations()) {
					if (translation != null) {
						antibodiesSection.getComponent().add(getPOCDMT000040Component5(
								ActRelationshipHasComponent.COMP, true, translation.getAtcdabbrSectionUebersetzung()));
					}
				}
			}
		}

		StrucDocText textImmunizationLabResult = new StrucDocText();
		ImmunizationLabResultNarrativeTextGenerator textbuilder = new ImmunizationLabResultNarrativeTextGenerator(
				antibodiesSection.getEntry());
		textImmunizationLabResult.getContent().add(textbuilder.toString());
		antibodiesSection.setText(textImmunizationLabResult);

		return antibodiesSection;
	}

	protected AtcdabrrSectionImpfempfehlungenKodiert getAtcdabbrSectionImpfempfehlungenKodiert() {
		if (this.immunizationRecommendations == null || this.immunizationRecommendations.isEmpty()) {
			return null;
		}

		AtcdabrrSectionImpfempfehlungenKodiert treatmentPlanSection = new AtcdabrrSectionImpfempfehlungenKodiert();
		treatmentPlanSection.setTitle(createTitle("Impfempfehlungen"));

		int index = 0;
		treatmentPlanSection.getEntry().clear();
		for (ImmunizationRecommendation immunizationRec : this.immunizationRecommendations) {
			treatmentPlanSection.getEntry().add(immunizationRec.getImmunizationRecommendationEntry(index++));

			if (immunizationRec.getTranslations() != null) {
				for (Translation translation : immunizationRec.getTranslations()) {
					if (translation != null) {
						treatmentPlanSection.getComponent().add(getPOCDMT000040Component5(
								ActRelationshipHasComponent.COMP, true, translation.getAtcdabbrSectionUebersetzung()));
					}
				}
			}
		}

		StrucDocText textImmunizationRecommendation = new StrucDocText();
		ImmunizationRecommendationNarrativeTextGenerator textbuilder = new ImmunizationRecommendationNarrativeTextGenerator(
				treatmentPlanSection.getEntry());
		textImmunizationRecommendation.getContent().add(textbuilder.toString());
		treatmentPlanSection.setText(textImmunizationRecommendation);

		return treatmentPlanSection;
	}

	private POCDMT000040Component5 getPOCDMT000040Component5(ActRelationshipHasComponent typeCode,
			boolean contextInduction, POCDMT000040Section section) {
		POCDMT000040Component5 comp5 = new POCDMT000040Component5();
		comp5.setTypeCode(typeCode);
		comp5.setContextConductionInd(contextInduction);
		comp5.setSection(section);
		return comp5;
	}

	protected ST createTitle(String text) {
		ST titleSt = new ST();
		if (text != null) {
			titleSt.setXmlMixed(text);
		}

		return titleSt;
	}

}