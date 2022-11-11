/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.cda.elga.models.ems;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.projecthusky.cda.elga.generated.artdecor.ems.enums.ElgaDiagnosesicherheit;
import org.projecthusky.cda.elga.generated.artdecor.ems.enums.EpimsMeldepflichtigeKrankheiten;
import org.projecthusky.cda.elga.models.PatientCdaAt;
import org.projecthusky.cda.elga.models.PractitionerCdaAt;
import org.projecthusky.common.at.OrganizationAt;
import org.projecthusky.common.basetypes.AddressBaseType;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.basetypes.TelecomBaseType;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Organization;
import org.junit.jupiter.api.Test;

/**
 * Test of {@link Arztmeldung}.
 *
 * @author Anna Jungwirth
 */
class ArztmeldungTest {

	/**
	 * Test method for {@link Arztmeldung}.
	 *
	 * @throws JAXBException the JAXB exception
	 * @throws IOException   Signals that an I/O exception has occurred.
	 */
	@Test
	void testCreateFirstElementsCda() throws JAXBException {

		Arztmeldung document = new Arztmeldung();
		PatientCdaAt patient = new PatientCdaAt();
		List<Identificator> patIds = new ArrayList<>();
		patIds.add(new Identificator("1.2.40.0.10.1.4.3.1", "1001210995"));
		patIds.add(new Identificator("1.2.40.0.34.99.3.2.1046167", "70000"));
		patient.setIds(patIds);

		patient.setDateOfDeath(LocalDate.now());

		Name patientName = new Name();
		patientName.setFamily("Musterpatient");
		patientName.setGiven("Max");
		patientName.setUsage(null);
		patient.getNames().addAll(Arrays.asList(patientName));

		AddressBaseType patAddress = new AddressBaseType();
		patAddress.setStreetName("Teststraße");
		patAddress.setBuildingNumber("58b");
		patAddress.setCity("Graz");
		patAddress.setPostalCode("8020");
		patAddress.setCountry("Österreich");
		patAddress.setUsage(null);
		Address patAddress1 = new Address(patAddress);
		patient.getAddresses().addAll(Arrays.asList(patAddress1));

		patient.setBirthday(ZonedDateTime.now());
		patient.setAdministrativeGender(AdministrativeGender.MALE);

		document.setPatient(patient);

		Name authName = new Name();
		authName.setGiven("046167");
		authName.setFamily("Entwicklung ELGA KST");
		authName.setPrefix("Dr.");
		authName.setUsage(null);

		ArrayList<IdentificatorBaseType> orgIds = new ArrayList<>();
		Identificator id = new Identificator("1.2.40.0.34.99.3.2.1046167");
		id.setAssigningAuthorityName("Ordination Dr. 046167 Entwicklung ELGA");
		orgIds.add(id);

		OrganizationBaseType authOrg = new OrganizationBaseType();
		authOrg.setIdentificatorList(orgIds);
		NameBaseType aName = new NameBaseType();
		aName.setName("Ordination Dr. 046167 Entwicklung ELGA");
		aName.setUsage(null);
		authOrg.clearNameList();
		authOrg.addName(aName);
		OrganizationAt author = new OrganizationAt(authOrg);
		List<PractitionerCdaAt> authors = new LinkedList<>();
		PractitionerCdaAt practitioner = new PractitionerCdaAt();
		practitioner.setIdentifier(List.of(new Identificator("1.2.3.4.5.6", "123")));
		practitioner.setNames(List.of(authName));
		practitioner.setOrganization(author);

		authors.add(practitioner);
		document.setAuthors(authors);

		OrganizationBaseType custodian = new OrganizationBaseType();
		custodian.setIdentificatorList(orgIds);
		ArrayList<NameBaseType> names = new ArrayList<>();
		NameBaseType custName = new NameBaseType();
		custName.setName("Ordination Dr. 046167 Entwicklung ELGA");
		custName.setUsage(null);
		names.add(custName);
		custodian.setNameList(names);
		ArrayList<AddressBaseType> addressCustodian = new ArrayList<>();
		AddressBaseType addressBaseTypeCust = new AddressBaseType();
		addressBaseTypeCust.setStreetAddressLine1("Radetzkystraße 2");
		addressBaseTypeCust.setPostalCode("1030");
		addressBaseTypeCust.setCity("Wien");
		addressBaseTypeCust.setCountry("Österreich");
		addressCustodian.add(addressBaseTypeCust);
		custodian.setAddressList(addressCustodian);
		OrganizationAt custodianOrg = new OrganizationAt(custodian);
		document.setCustodian(custodianOrg);

		PractitionerCdaAt legalAuthenticator = new PractitionerCdaAt();
		legalAuthenticator.setIdentifier(List.of(new Identificator("1.2.3.4.5", "1")));
		legalAuthenticator.setNames(practitioner.getNames());
		OrganizationBaseType legalAuthenOrg = new OrganizationBaseType();
		legalAuthenOrg.setIdentificatorList(orgIds);
		legalAuthenOrg.setNameList(names);
		OrganizationAt legalAuthen = new OrganizationAt(legalAuthenOrg);
		legalAuthenticator.setOrganization(legalAuthen);
		document.setLegalAuthenticator(legalAuthenticator);

		InformationRecipient informationRecipient = new InformationRecipient();
		informationRecipient.setName("BMGF");

		Identificator recipientIdentificator = new Identificator("1.2.40.0.34.3.1.1");
		recipientIdentificator.setAssigningAuthorityName("BMGF");
		informationRecipient.setId(recipientIdentificator);
		Organization recipientOrganization = new Organization(new OrganizationBaseType());
		Identificator recId = new Identificator("1.2.40.0.34.3.1.1", "BMSGPK");
		ArrayList<IdentificatorBaseType> recIds = new ArrayList<>();
		recIds.add(recId);
		recipientOrganization.setIdentificatorList(recIds);
		ArrayList<NameBaseType> recNames = new ArrayList<>();
		NameBaseType recName = new NameBaseType();
		recName.setName("BMSGPK");
		recNames.add(recName);
		recipientOrganization.setNameList(recNames);
		ArrayList<AddressBaseType> addressOrgList = new ArrayList<>();
		AddressBaseType addressBaseType = new AddressBaseType();
		addressBaseType.setStreetAddressLine1("Radetzkystraße 2");
		addressBaseType.setPostalCode("1030");
		addressBaseType.setCity("Wien");
		addressBaseType.setCountry("Österreich");
		addressOrgList.add(addressBaseType);
		recipientOrganization.setAddressList(addressOrgList);
		ArrayList<TelecomBaseType> telecomList = new ArrayList<>();
		TelecomBaseType telecomBaseType = new TelecomBaseType();
		telecomBaseType.setPhone("+43.1.71100-0");
		telecomList.add(telecomBaseType);
		recipientOrganization.setTelecomList(telecomList);
		informationRecipient.setReceivedOrganization(recipientOrganization);
		document.setInformationRecipient(informationRecipient);

		CaseIdentification caseIdentification = new CaseIdentification();
		caseIdentification.setDiagnosisDate(ZonedDateTime.of(2020, 9, 8, 0, 0, 0, 0, ZoneOffset.systemDefault()));
		Code disease = new Code();
		disease.setCode(EpimsMeldepflichtigeKrankheiten.CAMPYLOBAKTER_SPP_DARMPATHOGEN.getCodeValue());
		disease.setCodeSystem(EpimsMeldepflichtigeKrankheiten.CAMPYLOBAKTER_SPP_DARMPATHOGEN.getCodeSystemId());
		disease.setDisplayName(EpimsMeldepflichtigeKrankheiten.CAMPYLOBAKTER_SPP_DARMPATHOGEN.getDisplayName());
		caseIdentification.setDisease(disease);

		Code diagnosisConf = new Code();
		diagnosisConf.setCode(ElgaDiagnosesicherheit.VERDACHT_AUF.getCodeValue());
		diagnosisConf.setCodeSystem(ElgaDiagnosesicherheit.VERDACHT_AUF.getCodeSystemId());
		diagnosisConf.setDisplayName(ElgaDiagnosesicherheit.VERDACHT_AUF.getDisplayName());
		caseIdentification.setDiagnosisConfidence(diagnosisConf);
		document.setCaseIdentification(caseIdentification);

		/*
		 * "A04.5", "1.2.40.0.34.5.171", "Campylobakter spp., darmpathogen",
		 * "Campylobakter spp., darmpathogen"
		 */

		document.setDocId(new Identificator("1.2.3.4.5", "123"));
		document.setSetId(new Identificator("1.2.3.4.5", "123"));
		document.setVersion(1);

		String cdaXml = document.marshall();

		System.out.println(cdaXml);

		assertTrue(cdaXml != null && !cdaXml.isEmpty() && cdaXml.length() > 1);

	}

}
