package org.projecthusky.fhir.vacd.ch.common.validation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.Narrative;
import org.hl7.fhir.r4.model.Narrative.NarrativeStatus;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Practitioner;
import org.hl7.fhir.r4.model.PractitionerRole;
import org.hl7.fhir.r4.model.Reference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.projecthusky.fhir.core.ch.resource.r4.ChCorePatientEpr;
import org.projecthusky.fhir.core.ch.util.IdUtil;
import org.projecthusky.fhir.vacd.ch.common.TestHelper;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunization;
import org.projecthusky.fhir.vacd.ch.common.resource.r4.ChVacdImmunizationAdministrationDocument;
import org.projecthusky.fhir.validation.model.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.narrative.DefaultThymeleafNarrativeGenerator;

class ChVacdValidatorTest extends TestHelper {

	private Logger log = LoggerFactory.getLogger(ChVacdValidatorTest.class);

	private ChVacdValidator validator;

	private FhirContext ctx;

	@BeforeEach
	void setUp() throws Exception {

		ctx = FhirContext.forR4();
		DefaultThymeleafNarrativeGenerator narr = new DefaultThymeleafNarrativeGenerator();
		ctx.setNarrativeGenerator(narr);

		validator = new ChVacdValidator(ctx, null, null);//"https://tx.fhir.org/r4");
	}

	@Test
	void testValidateDocumentBundleSimple() {
		ChVacdImmunizationAdministrationDocument document = new ChVacdImmunizationAdministrationDocument();

		prettyPrint(document);
		
		ValidationResult res = validator.validateDocumentBundle(document,
				"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration");
		assertNotNull(res);
		log.info("Validation result: {}", res);
		

		assertTrue(!res.isSuccessful(), "Validation should not be successful");
		assertEquals(0, res.getFatals().size());
		assertEquals(5, res.getErrors().size());
		assertEquals(0, res.getWarnings().size());
		assertEquals(0, res.getInformations().size());
		assertEquals(5, res.getIssues().size());
		
		assertTrue(res.getErrors().stream().map(i -> i.getMessage()).filter(m -> m.contains("Bundle.entry: minimum required = 2, but only found 0")).findAny().isPresent());
		assertTrue(res.getErrors().stream().map(i -> i.getMessage()).filter(m -> m.contains("Slice 'Bundle.entry:Composition': a matching slice is required, but not found")).findAny().isPresent());
		assertTrue(res.getErrors().stream().map(i -> i.getMessage()).filter(m -> m.contains("Slice 'Bundle.entry:Patient': a matching slice is required, but not found")).findAny().isPresent());
		assertTrue(res.getErrors().stream().map(i -> i.getMessage()).filter(m -> m.contains("Constraint failed: bdl-11: 'A document must have a Composition as the first resource'")).findAny().isPresent());
		assertTrue(res.getErrors().stream().map(i -> i.getMessage()).filter(m -> m.contains("Documents or Messages must contain at least one entry")).findAny().isPresent());
	}

	@Test
	void testValidateDocumentBundleBasic() {
		ChVacdImmunizationAdministrationDocument document = new ChVacdImmunizationAdministrationDocument();
		// document.resolveComposition().setStatus(CompositionStatus.FINAL);
		ChCorePatientEpr patient = new ChCorePatientEpr();
		patient.setId(IdUtil.generateUrnUuid());
		patient.addName().addGiven("Max").setFamily("Mustermann");
		patient.addIdentifier()
				.setSystem("http://fhir.ch/ig/ch-core/CodeSystem/ch-core-identifier-type")
				.setValue("CH123456789");
		patient.setGender(AdministrativeGender.MALE);
		patient.setBirthDate(new Date());
		document.setPatient(patient);

		PractitionerRole pr = document.addPractitionerRole();
		((Practitioner) pr.getPractitioner().getResource()).addName().addGiven("Dr. med.")
				.setFamily("Musterarzt");
		((Practitioner) pr.getPractitioner().getResource()).addIdentifier()
				.setSystem("urn:oid:2.51.1.3").setValue("7603000000136");
		((Organization) pr.getOrganization().getResource()).setName("Musterarztpraxis");
		document.addAuthor(pr, new Date());

		ChVacdImmunization immunization = document.addImmunization();
		immunization.setVaccineCode(new CodeableConcept().addCoding(
				new Coding("http://snomed.info/sct", "1119349007", "COVID-19 mRNA vaccine")));
		immunization.setLotNumber("123456789");
		immunization.setOccurrence(new Date());
		immunization.setTargetDiseases(List.of(new CodeableConcept()
				.addCoding(new Coding("http://snomed.info/sct", "840539006", "COVID-19"))));

		immunization.setDoseNumber(1);
		immunization.setVerificationStatus(
				new Coding("http://snomed.info/sct", "59156000", "Confirmed by"));

		ValidationResult res = validator.validateDocumentBundle(document,
				"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration");
		assertNotNull(res);
		log.info("Validation result: {}", res);

		assertTrue(res.isSuccessful(), "Validation should be successful");

		assertEquals(0, res.getFatals().size());
		assertEquals(0, res.getErrors().size());
		assertEquals(7, res.getWarnings().size());
		assertEquals(9, res.getInformations().size());
		assertEquals(16, res.getIssues().size());
	}

	@Test
	void testValidateResource() throws IOException {
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
//		Narrative text = new Narrative();
//		text.setStatus(NarrativeStatus.GENERATED).setDivAsString(
//				"<div xmlns=\"http://www.w3.org/1999/xhtml\">COVID-19 mRNA vaccine</div>");
//		immunization.setText(text);

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

		prettyPrint(immunization);

		ValidationResult res = validator.validateResource(immunization,
				"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-immunization");
		assertNotNull(res);
		log.info("Validation result: {}", res);

		assertTrue(res.isSuccessful(), "Validation should be successful");

		assertEquals(0, res.getFatals().size());
		assertEquals(0, res.getErrors().size());
		assertEquals(1, res.getWarnings().size());
		assertEquals(0, res.getInformations().size());
		assertEquals(1, res.getIssues().size());
	}
	
	@Test
	void validateBundleFromFile() throws IOException {
		ChVacdImmunizationAdministrationDocument document = loadBundleFromFile("/fhir/ch-vacd-bunlde-mw_1.json");
		assertNotNull(document);
		
		ValidationResult res = validator.validateDocumentBundle(document,
				"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration");
		assertNotNull(res);
		log.info("Validation result: {}", res);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Fatals:").append("\n");
		res.getFatals().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nErrors:").append("\n");
		res.getErrors().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nWarnings:").append("\n");
		res.getWarnings().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nInformations:").append("\n");
		res.getInformations().forEach(i -> sb.append( i).append("\n"));
		
		
		log.info("\n{}", sb.toString());
	}
	
	@Test
	void validateBundleFromFile2() throws IOException {
		ChVacdImmunizationAdministrationDocument document = loadBundleFromFile("/fhir/chvacd-immunizationadministration-beispielhugo.json");
		assertNotNull(document);
		
		ValidationResult res = validator.validateDocumentBundle(document,
				"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-immunization-administration");
		assertNotNull(res);
		log.info("Validation result: {}", res);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Fatals:").append("\n");
		res.getFatals().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nErrors:").append("\n");
		res.getErrors().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nWarnings:").append("\n");
		res.getWarnings().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nInformations:").append("\n");
		res.getInformations().forEach(i -> sb.append( i).append("\n"));
		
		
		log.info("\n{}", sb.toString());
	}
	
	@Test
	void validateBundleFromFile3() throws IOException {
		ChVacdImmunizationAdministrationDocument document = loadBundleFromFile("/fhir/VaccinationRecord-Beispiel-Hugo.json");
		assertNotNull(document);
		
		ValidationResult res = validator.validateDocumentBundle(document,
				"http://fhir.ch/ig/ch-vacd/StructureDefinition/ch-vacd-document-vaccination-record");
		assertNotNull(res);
		log.info("Validation result: {}", res);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Fatals:").append("\n");
		res.getFatals().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nErrors:").append("\n");
		res.getErrors().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nWarnings:").append("\n");
		res.getWarnings().forEach(i -> sb.append( i).append("\n"));
		
		sb.append("\nInformations:").append("\n");
		res.getInformations().forEach(i -> sb.append( i).append("\n"));
		
		
		log.info("\n{}", sb.toString());
	}

	public ChVacdImmunizationAdministrationDocument loadBundleFromFile(String string) {
		FhirContext ctx = FhirContext.forR4();

		ChVacdImmunizationAdministrationDocument resource = ctx.newJsonParser().parseResource(ChVacdImmunizationAdministrationDocument.class,
				this.getClass().getResourceAsStream(string));
		return resource;
	}
	

}
