package org.projecthusky.fhir.vacd.ch.common.narrative;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePractitionerRoleEpr;
import org.projecthusky.fhir.core.ch.util.IdUtil;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunization;

import ca.uhn.fhir.context.FhirContext;

class ChVacdThymeleafNarrativeGeneratorTest extends TestHelper {

	private FhirContext fhirContext;

	@BeforeEach
	void setUp() throws Exception {

		fhirContext = FhirContext.forR4();
		fhirContext.setNarrativeGenerator(new ChVacdThymeleafNarrativeGenerator());
	}

	@Test
	void testPopulateResourceNarrativeFhirContextIBaseResource() {
		ChCorePatientEpr patient = new ChCorePatientEpr();
		patient.setId(IdUtil.generateUrnUuid());
		patient.addName().addGiven("Max").setFamily("Mustermann");
		patient.addIdentifier()
				.setSystem("http://fhir.ch/ig/ch-core/CodeSystem/ch-core-identifier-type")
				.setValue("CH123456789");
		patient.setGender(AdministrativeGender.MALE);
		patient.setBirthDate(new Date());

		ChVacdImmunization immunization = new ChVacdImmunization();
		immunization.setId(UUID.randomUUID().toString());
		// Narrative text = new Narrative();
		// text.setStatus(NarrativeStatus.GENERATED).setDivAsString(
		// "<div xmlns=\"http://www.w3.org/1999/xhtml\">COVID-19 mRNA
		// vaccine</div>");
		// immunization.setText(text);

		immunization.setPatient(new Reference(patient));
		immunization.setVaccineCode(new CodeableConcept().addCoding(
				new Coding("http://snomed.info/sct", "1119349007", "COVID-19 mRNA vaccine")));
		immunization.setLotNumber("123456789");
		immunization.setOccurrence(new Date());
		immunization.setTargetDiseases(List.of(new CodeableConcept()
				.addCoding(new Coding("http://snomed.info/sct", "840539006", "COVID-19"))));

		immunization.setDoseNumber(1);
		immunization.setVerificationStatus(
				new Coding("http://snomed.info/sct", "59156000", "Confirmed by"));

		assertTrue(new ChVacdThymeleafNarrativeGenerator().populateResourceNarrative(fhirContext,
				immunization));

		var ref = toString(immunization);
		assertNotNull(ref);
		
		prettyPrint(immunization);
	}

	@Test
	void testPopulateResourceNarrativePractitionerRole() {
		ChCorePractitionerRoleEpr practitionerRole = new ChCorePractitionerRoleEpr();
		practitionerRole.setId(UUID.randomUUID().toString());

		practitionerRole.setPractitioner(new Reference("urn:uuid:" + UUID.randomUUID().toString()));
		practitionerRole.setOrganization(new Reference("urn:uuid:" + UUID.randomUUID().toString()));

		assertTrue(new ChVacdThymeleafNarrativeGenerator().populateResourceNarrative(fhirContext,
				practitionerRole));

		prettyPrint(practitionerRole);
	}
}
