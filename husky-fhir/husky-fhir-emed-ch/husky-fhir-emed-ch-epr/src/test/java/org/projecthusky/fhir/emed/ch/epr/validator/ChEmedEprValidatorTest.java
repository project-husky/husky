package org.projecthusky.fhir.emed.ch.epr.validator;

import ca.uhn.fhir.context.FhirContext;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ChEmedEprValidatorTest {

    void validateDocumentBundle() throws IOException {
        FhirContext ctx = FhirContext.forR4();

        ChEmedPmpValidator validator = new ChEmedPmpValidator(ctx);

        final var composition = """
                <Composition xmlns="http://hl7.org/fhir">
                    <id value="ZuweisungZurRadiologischenDiagnostik" />
                    <meta>
                    <profile value="http://fhir.ch/ig/ch-core/StructureDefinition/ch-core-composition-epr" />
                    </meta>
                    <language value="de-CH" />
                    <text>
                        <status value="extensions" />
                        <div xmlns="http://www.w3.org/1999/xhtml" xml:lang="de-CH" lang="de-CH">
                            <p><b>Generated Narrative</b></p>
                        </div>
                    </text>
                    <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-versionnumber">
                        <valueUnsignedInt value="2" />
                    </extension>
                    <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-informationrecipient">
                        <valueReference>
                            <reference value="Organization/Radiologieinstitut" />
                        </valueReference>
                    </extension>
                    <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-dataenterer">
                        <extension url="enterer">
                            <valueReference>
                                <reference value="PractitionerRole/SchreibKraft" />
                            </valueReference>
                        </extension>
                        <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time">
                            <valueDateTime value="2017-10-03T13:15:00+01:00" />
                        </extension>
                    </extension>
                    <identifier>
                        <system value="urn:ietf:rfc:3986" />
                        <value value="urn:uuid:31397B31-BE60-47E1-BEC6-F37816D42B0C" />
                    </identifier>
                    <status value="final" />
                    <type>
                        <coding>
                            <system value="http://loinc.org" />
                            <code value="28616-1" />
                            <display value="Physician Transfer note" />
                        </coding>
                        <coding>
                            <system value="http://snomed.info/sct" />
                            <code value="371535009" />
                            <display value="Transfer summary report" />
                        </coding>
                    </type>
                    <subject>
                        <reference value="Patient/MaxMuster" />
                    </subject>
                    <date value="2017-10-03T17:33:00+01:00" />
                    <author>
                        <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-time">
                            <valueDateTime value="2017-10-03T16:09:00+01:00" />
                        </extension>
                        <reference value="Practitioner/AllzeitBereit" />
                    </author>
                    <title value="Zuweisung zur Radiologischen Diagnostik" />
                    <confidentiality value="N">
                        <extension url="http://fhir.ch/ig/ch-core/StructureDefinition/ch-ext-epr-confidentialitycode">
                            <valueCodeableConcept>
                                <coding>
                                    <system value="http://snomed.info/sct" />
                                    <code value="17621005" />
                                    <display value="Normal" />
                                </coding>
                            </valueCodeableConcept>
                        </extension>
                    </confidentiality>
                    <attester>
                        <mode value="legal" />
                        <time value="2017-10-03" />
                        <party>
                            <reference value="Practitioner/AllzeitBereit" />
                        </party>
                    </attester>
                    <custodian>
                        <reference value="Organization/GruppenpraxisCH" />
                    </custodian>
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
