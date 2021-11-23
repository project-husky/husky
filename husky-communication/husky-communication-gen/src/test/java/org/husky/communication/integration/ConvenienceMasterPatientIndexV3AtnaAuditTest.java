package org.husky.communication.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;

import org.hl7.fhir.r4.model.Enumerations.AdministrativeGender;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.husky.common.communication.AffinityDomain;
import org.husky.common.communication.Destination;
import org.husky.common.model.Identificator;
import org.husky.common.utils.DateUtil;
import org.husky.communication.ConvenienceMasterPatientIndexV3;
import org.husky.communication.MasterPatientIndexQuery;
import org.husky.communication.MasterPatientIndexQueryResponse;
import org.husky.communication.mpi.impl.PixV3Query;
import org.husky.communication.testhelper.TestApplication;
import org.husky.fhir.structures.gen.FhirCommon;
import org.husky.fhir.structures.gen.FhirPatient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;

/**
 * This test class is to check whether ATNA audit messages are sent in the
 * course of PIX and PDQ transactions. This is tested by checking whether audit
 * entries have been written to the LOG file.
 */
@ExtendWith(value = SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = { TestApplication.class })
@EnableAutoConfiguration
@ActiveProfiles("atna")
public class ConvenienceMasterPatientIndexV3AtnaAuditTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConvenienceMasterPatientIndexV3AtnaAuditTest.class.getName());

	@Autowired
	private ConvenienceMasterPatientIndexV3 convenienceMasterPatientIndexV3Client;

	final private String pdqUri = "https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PDQSupplier_Service/PDQSupplier_PortType";
	final private String pixUri = "https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType";

	final private String applicationName = "2.16.840.1.113883.3.72.6.5.100.1399";
	final private String facilityName = null;

	final private String senderApplicationOid = "1.2.3.4";
	final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";

	final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";
	final private String homeCommunityNamespace = "CHPAM2";

	final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";
	final private String spidEprNamespace = "SPID";

	private Organization getScopingOrganization() {
		final Organization org = new Organization();
		final Identifier identifier = new Identifier();
		identifier.setValue("Husky");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		org.getIdentifier().add(identifier);
		return org;
	}

	/**
	 * Test method for
	 * {@link ConvenienceMasterPatientIndexV3#queryPatientDemographics(MasterPatientIndexQuery, AffinityDomain, org.husky.xua.core.SecurityHeaderElement)}.
	 * (PDQ ITI-47)
	 * 
	 * @throws Exception
	 */
	@Test
	public void queryPatientDemographicsWithAtnaAuditMessageTest() throws Exception {
		LOGGER.debug("ITI47ConsumerQueryPatientPatientIdStep1Test with ipAdress Target " + pdqUri);

		// sets endpoint of PDQ service
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		try {
			dest.setUri(new URI(pdqUri));
		} catch (final URISyntaxException e) {
			e.printStackTrace();
		}
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(affinityDomain.getPdqDestination());

		// Add identifier of the person for whom the demographic data should be searched
		// for
		final Identificator identificator = new Identificator("1.3.6.1.4.1.12559.11.20.1", "4711");
		mpiQuery.addPatientIdentificator(identificator);
		
		// query patient demographics
		final MasterPatientIndexQueryResponse response = convenienceMasterPatientIndexV3Client
				.queryPatientDemographics(mpiQuery, affinityDomain, null);
		assertTrue(response.getSuccess());

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110112\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-47\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	@Test
	public void updatePatientTest() throws IOException {
		// sets endpoint of PIX service
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);	

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, null, null,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Bauer-Maier").addGiven("Anton");
		patient.getName().add(humanName);
		final org.hl7.fhir.r4.model.Address address = new org.hl7.fhir.r4.model.Address().addLine("Testgasse 18")
				.setPostalCode("1020").setCity("Wien").setState("AUT");
		final Identifier identifier = new Identifier();
		identifier.setValue("1634793774730");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);
		
		final Identifier identifier2 = new Identifier();
		identifier2.setValue("SPID-101");
		identifier2.setSystem(spidEprOid);
		patient.getIdentifier().add(identifier2);

		patient.setBirthDate(DateUtil.parseDateyyyyMMdd("19500324"));
		patient.getAddress().add(address);
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.R4);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		LOGGER.debug(encoded);

		assertTrue(pixV3Query.updatePatient(patient, null));

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110110\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-44\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	@Test
	public void queryPatientIdTest() throws IOException {

		// sets endpoint of PIX service
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, spidEprOid,
				spidEprNamespace, convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final Identifier identifier = new Identifier();
		identifier.setValue("CHPAM4489");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		String patId = pixV3Query.queryPatientId(patient, null);

		assertEquals("761337610436974489", patId);

		// check audit logging entries
		String logContent = checkAuditLogging();
		assertTrue(logContent.contains("<EventID csd-code=\"110112\""));
		assertTrue(logContent.contains("<EventTypeCode csd-code=\"ITI-45\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110153\""));
		assertTrue(logContent.contains("RoleIDCode csd-code=\"110152\""));
	}

	/**
	 * This method extracts content of LOG file and checks if auditing is basically
	 * enabled.
	 * 
	 * @return content of LOG file
	 * 
	 * @throws IOException
	 */
	private String checkAuditLogging() throws IOException {
		File originLogFile = new File("log/Spring-TestEHC.log");

		// extract content of log file
		String logContent = new String(Files.readAllBytes(originLogFile.toPath()));

		// check if ATNA audit events could be sent
		assertFalse(logContent.contains("Failed to send ATNA audit event to destination"));

		// check if ATNA auditing is basically enabled
		assertTrue(logContent.contains("Auditing"));

		return logContent;
	}

}
