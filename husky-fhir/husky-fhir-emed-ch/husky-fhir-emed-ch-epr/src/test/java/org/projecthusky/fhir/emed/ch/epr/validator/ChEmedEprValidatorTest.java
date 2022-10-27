package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChEmedEprValidatorTest {

    @Test
    void validateDocumentBundle() throws IOException {
        FhirContext ctx = FhirContext.forR4();

        ChEmedPmpValidator validator = new ChEmedPmpValidator(ctx);

        final var composition = """
                  <Composition xmlns="http://hl7.org/fhir">
                      <id value="1-1-MedicationTreatmentPlan" />
                      <meta>
                      <profile value="http://fhir.ch/ig/ch-emed/StructureDefinition/ch-emed-composition-medicationtreatmentplan" />
                      </meta>
                      <language value="de-CH" />
                      <text>
                          <status value="extensions" />
                          <div xmlns="http://www.w3.org/1999/xhtml" xml:lang="de-CH" lang="de-CH">
                            <p>...</p>
                          </div>
                      </text>
                      <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-informationrecipient">
                          <valueReference>
                              <reference value="Patient/MonikaWegmuellerRecipient" />
                          </valueReference>
                      </extension>
                      <identifier>
                          <system value="urn:ietf:rfc:3986" />
                          <value value="urn:uuid:c9f758a1-296c-4710-84d4-e181db8c7478" />
                      </identifier>
                      <status value="final" />
                      <type>
                          <coding>
                              <system value="http://loinc.org" />
                              <code value="77603-9" />
                              <display value="Medication treatment plan.extended" />
                          </coding>
                          <coding>
                              <system value="http://snomed.info/sct" />
                              <code value="419891008" />
                              <display value="Record artifact (record artifact)" />
                          </coding>
                      </type>
                      <subject>
                          <reference value="Patient/MonikaWegmueller" />
                      </subject>
                      <date value="2011-11-29T11:00:00+01:00" />
                      <author>
                          <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time">
                              <valueDateTime value="2011-11-29T11:00:00+01:00" />
                          </extension>
                          <reference value="PractitionerRole/FamilienHausarztAtHausarzt" />
                      </author>
                      <title value="Therapieentscheid Medikation" />
                      <confidentiality value="N">
                          <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-confidentialitycode">
                              <valueCodeableConcept>
                                  <coding>
                                      <system value="http://snomed.info/sct" />
                                      <code value="17621005" />
                                      <display value="Normally accessible" />
                                  </coding>
                              </valueCodeableConcept>
                          </extension>
                      </confidentiality>
                      <custodian>
                          <reference value="Organization/Custodian" />
                      </custodian>
                      <section>
                          <title value="Medikamentöser Behandlungsplan" />
                          <code>
                        <coding>
                          <system value="http://loinc.org"/>
                          <code value="77604-7"/>
                          <display value="Medication treatment plan.brief"/>
                        </coding>
                      </code>
                          <text>
                              <status value="generated" />
                              <div xmlns="http://www.w3.org/1999/xhtml">
                                <p>...</p>
                              </div>
                          </text>
                          <entry>
                              <reference value="MedicationStatement/1-1-MedStatTriatec" />
                          </entry>
                      </section>
                  </Composition>""";

        assertTrue(validator.validateDocumentBundle(composition)); // Pas Ok

        final var patient = """
                <Patient xmlns="http://hl7.org/fhir">
                    <id value="ManuelaMuster" />
                    <meta>
                    <profile value="http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient" />
                    </meta>
                    <text>
                        <status value="additional" />
                        <div xmlns="http://www.w3.org/1999/xhtml">
                            <p>...</p>
                        </div>
                    </text>
                    <extension url="http://hl7.org/fhir/StructureDefinition/patient-birthPlace">
                        <valueAddress>
                            <city value="Paris" />
                            <country value="Frankreich" />
                        </valueAddress>
                    </extension>
                    <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-patient-ech-11-placeoforigin">
                        <valueAddress>
                            <city value="Köniz" />
                            <state value="BE" />
                        </valueAddress>
                    </extension>
                    <extension url="http://hl7.org/fhir/StructureDefinition/patient-religion">
                        <valueCodeableConcept>
                            <coding>
                                <system value="http://terminology.hl7.org/CodeSystem/v3-ReligiousAffiliation" />
                                <code value="1077" />
                                <display value="Protestant" />
                            </coding>
                        </valueCodeableConcept>
                    </extension>
                    <identifier>
                        <system value="urn:oid:2.16.756.5.30.1.127.3.10.3" />
                        <value value="761337615317835750" />
                    </identifier>
                    <name>
                        <family value="Muster" />
                        <given value="Manuela" />
                    </name>
                    <gender value="female" />
                    <birthDate value="1997-02-21" />
                    <maritalStatus>
                        <coding>
                            <system value="http://fhir.ch/ig/ch-core/CodeSystem/ech-11-maritalstatus" />
                            <code value="6" />
                            <display value="in eingetragener Partnerschaft" />
                        </coding>
                    </maritalStatus>
                    <communication>
                        <language>
                            <coding>
                                <system value="urn:ietf:bcp:47" />
                                <code value="de-CH" />
                            </coding>
                            <text value="Deutsch (Schweiz)" />
                        </language>
                        <preferred value="true" />
                    </communication>
                </Patient>""";

        assertTrue(validator.validateDocumentBundle(patient)); // Ok
    }

}
