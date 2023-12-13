/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.manual;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.hl7.fhir.r4.model.Address;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointSystem;
import org.hl7.fhir.r4.model.ContactPoint.ContactPointUse;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.HumanName.NameUse;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.hl7.fhir.r4.model.Patient.PatientCommunicationComponent;
import org.hl7.fhir.r4.model.codesystems.V3MaritalStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.enums.CountryCode;
import org.projecthusky.common.enums.TelecomAddressUse;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.mpi.impl.pix.V3PixSourceMessageHelper;
import org.projecthusky.communication.mpi.impl.pix.V3PixSourceRecordAdded;
import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.utils.PixPdqV3Utils;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.ihe.gazelle.hl7v3.prpain201301UV02.PRPAIN201301UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Citizen;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Employee;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02LanguageCommunication;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Nation;
import net.ihe.gazelle.hl7v3.prpamt201301UV02.PRPAMT201301UV02Person;

/**
 * Purpose of this test-class is to experiment with the patient creation request and figure out how to implement it on
 * the low-level webservice client.
 *
 * @author szalai
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class,
    IpfApplicationConfig.class})
public class HuskyWebServiceCreatePatientExperimentalTest {

  @Autowired
  private HuskyWebServiceClient wsClient;

  @Value(value = "${test.pixq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType}")
  private String pixUri;

  private final String facilityName = null; // "2.16.840.1.113883.3.72.6.1";

  private final String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
  private final String senderApplicationOid = "1.2.3.4";
  private final String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
  final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";

  private final Random random = new Random();

  @Test
  public void experiment() throws Exception {
    final Destination dest = new Destination();
    dest.setUri(URI.create(pixUri));
    dest.setSenderApplicationOid(senderApplicationOid);
    dest.setReceiverApplicationOid(receiverApplicationOid);
    dest.setReceiverFacilityOid(facilityName);

    V3PixSourceRecordAdded addRecordQuery = new V3PixSourceRecordAdded(dest.getSenderApplicationOid(), null,
        dest.getReceiverApplicationOid(), null);

    final Identifier identifier = new Identifier();
    identifier.setValue(String.valueOf(System.currentTimeMillis()));
    identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		/*
		if ((identifier.getSystem().length() > 8)) {
			final String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
			if (this.otherOidIds.contains(oid)) {
				v3PixSourceMessage.addPatientOtherID(identifier.getValue(), oid);
			} else {
				if (this.homeCommunityOid != null && this.homeCommunityOid.equals(oid)) {
					v3PixSourceMessage.addPatientID(identifier.getValue(), this.homeCommunityOid,
							this.homeCommunityNamespace);
				} else {
					v3PixSourceMessage.addPatientID(identifier.getValue(), oid, "");
				}
			}
		}
		*/
    String oid = FhirCommon.removeUrnOidPrefix(identifier.getSystem());
    addRecordQuery.addPatientID(identifier.getValue(), oid, "");

    final Identifier identifier2 = new Identifier();
    identifier2.setValue(String.valueOf(System.currentTimeMillis()));
    identifier2.setSystem(spidEprOid);

    oid = FhirCommon.removeUrnOidPrefix(identifier2.getSystem());
    addRecordQuery.addPatientID(identifier2.getValue(), oid, "");

    final HumanName humanName = new HumanName().setFamily("Sanders " + random.nextInt(10))
        .addGiven("Miriam " + random.nextInt(10)).addGiven("Maria " + random.nextInt(10)).addPrefix("Dr.")
        .addSuffix("Msc.").setUse(NameUse.OFFICIAL);
    addRecordQuery.addPatientName(humanName.getFamily(), humanName.getGivenAsSingleString(), null,
        humanName.getPrefixAsSingleString(), humanName.getSuffixAsSingleString());

    DateType birthdate = new DateType();
    birthdate.setValue(new SimpleDateFormat("dd.MM.yyyy").parse("24.03.1950"));
    addRecordQuery.setPatientBirthTime(birthdate.getValueAsString().replace("-", ""));

    addRecordQuery.setPatientGender("M");

    final HumanName mothersMaidenName = new HumanName();
    mothersMaidenName.setFamily("Müller");
    addRecordQuery.setPatientMothersMaidenName(mothersMaidenName.getFamily(),
        mothersMaidenName.getGivenAsSingleString(), null, mothersMaidenName.getPrefixAsSingleString(),
        mothersMaidenName.getSuffixAsSingleString());

    final Address address = new Address().addLine("Testgasse 1").setPostalCode("8010").setCity("Graz")
        .setState("Steiermark").addLine("Eingang 2, Tür 34");
    address.setCountry("AUT");
    addRecordQuery.addPatientAddress(PixPdqV3Utils.createAd(address));

    final CodeableConcept nation = new CodeableConcept();
    nation.setText(CountryCode.AUSTRIA.getCodeAlpha3());

    final PRPAIN201301UV02Type rootElement = addRecordQuery.getRootElement();
    final PRPAMT201301UV02Person patientPerson = rootElement.getControlActProcess().getSubject().get(0)
        .getRegistrationEvent()
        .getSubject1().getPatient().getPatientPerson();

    final var citizen = new PRPAMT201301UV02Citizen();
    final var citizenNation = new PRPAMT201301UV02Nation();
    citizen.setPoliticalNation(citizenNation);
    citizenNation.setCode(PixPdqV3Utils.createCE(nation.getText()));
    patientPerson.getAsCitizen().add(citizen);

    final CodeableConcept religion = new CodeableConcept();
    religion.setText("Agnostic");
    addRecordQuery.setPatientReligiousAffiliation(religion.getText());

    final CodeableConcept maritalStatus = new CodeableConcept();
    maritalStatus.addCoding(new Coding(null, V3MaritalStatus.S.toCode(), V3MaritalStatus.S.getDisplay()));// single
    addRecordQuery.setPatientMaritalStatus(maritalStatus.getCodingFirstRep().getCode());

    final CodeableConcept deAT = new CodeableConcept();
    deAT.setText("de-AT");
    final CodeableConcept en = new CodeableConcept();
    en.setText("en");

    var communication = new PRPAMT201301UV02LanguageCommunication();
    communication.setLanguageCode(
        PixPdqV3Utils.createCE(new PatientCommunicationComponent().setLanguage(deAT).getLanguage().getText()));
    patientPerson.getLanguageCommunication().add(communication);
    communication = new PRPAMT201301UV02LanguageCommunication();
    communication.setLanguageCode(
        PixPdqV3Utils.createCE(new PatientCommunicationComponent().setLanguage(en).getLanguage().getText()));
    patientPerson.getLanguageCommunication().add(communication);

    final ContactPoint telHome = new ContactPoint();
    telHome.setUse(ContactPointUse.HOME);
    telHome.setSystem(ContactPointSystem.PHONE);
    telHome.setValue("+431000000000");

    final ContactPoint telWork = new ContactPoint();
    telWork.setUse(ContactPointUse.WORK);
    telWork.setSystem(ContactPointSystem.PHONE);
    telWork.setValue("+431000000000");

    final ContactPoint telMobile = new ContactPoint();
    telMobile.setUse(ContactPointUse.MOBILE);
    telMobile.setSystem(ContactPointSystem.PHONE);
    telMobile.setValue("+4366400000000");

    final ContactPoint eMail = new ContactPoint();
    eMail.setUse(ContactPointUse.WORK);
    eMail.setSystem(ContactPointSystem.EMAIL);
    eMail.setValue("xyz@abc.at");

    patientPerson.getTelecom()
        .add(V3PixSourceMessageHelper.createTEL(getTelecomValue(telHome), getTelecomAddressUse(telHome)));
    patientPerson.getTelecom()
        .add(V3PixSourceMessageHelper.createTEL(getTelecomValue(telWork), getTelecomAddressUse(telWork)));
    patientPerson.getTelecom()
        .add(V3PixSourceMessageHelper.createTEL(getTelecomValue(telMobile), getTelecomAddressUse(telMobile)));
    patientPerson.getTelecom()
        .add(V3PixSourceMessageHelper.createTEL(getTelecomValue(eMail), getTelecomAddressUse(eMail)));
    addRecordQuery.addPatientTelecom("test telecom", "test telekom");

    final CodeableConcept employeeOccupationCode = new CodeableConcept();
    employeeOccupationCode.setText("employeeOccupationCode");
    final var employee = new PRPAMT201301UV02Employee();
    employee.setOccupationCode(PixPdqV3Utils.createCE(employeeOccupationCode.getText()));
    patientPerson.getAsEmployee().add(employee);

    final Organization org = new Organization();
    final Identifier orgIdentifier = new Identifier();
    orgIdentifier.setValue("Husky");
    orgIdentifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
    org.getIdentifier().add(orgIdentifier);

    String organizationOID = "", organizationName = "", telecomValue = "NOTPROVIDED";
    if (org.getIdentifier() != null && !org.getIdentifier().isEmpty()) {
      final Identifier organizationId = org.getIdentifier().get(0);
      if (organizationId.getSystem().startsWith(FhirCommon.OID_URN)) {
        organizationOID = FhirCommon.removeUrnOidPrefix(organizationId.getSystem());
      }
    }

    if (org.getName() != null) {
      organizationName = org.getName();
    }

    if (org.getTelecom() != null && !org.getTelecom().isEmpty()) {
      final var contactPoint = org.getTelecomFirstRep();
      if (contactPoint != null) {
        telecomValue = contactPoint.getValue();
      }
    }
    addRecordQuery.setScopingOrganization(organizationOID, organizationName, telecomValue);

    this.wsClient.sendPixAddPatientRequest(addRecordQuery.getRootElement(), null, dest.getUri(),
        "urn:hl7-org:v3:PRPA_IN201301UV02", null);
  }

  private String getTelecomValue(ContactPoint contactPoint) {
    var system = "";
    var value = "NULL";

    if (contactPoint.getSystem() != null) {
      system = contactPoint.getSystem().toString().toLowerCase();
    }

    if (contactPoint.getValue() != null) {
      value = contactPoint.getValue();
    }

    if ("phone".equals(system)) {
      return "tel:" + value;
    }
    if ("email".equals(system)) {
      return "mailto:" + value;
    }

    return value;
  }

  private String getTelecomAddressUse(ContactPoint contactPoint) {
    var use = "";

    if (contactPoint.getUse() != null) {
      use = contactPoint.getUse().toString().toLowerCase();
    }

    if ("home".equals(use)) {
      return TelecomAddressUse.PRIVATE.getCodeValue();
    }
    if ("work".equals(use)) {
      return TelecomAddressUse.BUSINESS.getCodeValue();
    }

    return null;
  }

}
