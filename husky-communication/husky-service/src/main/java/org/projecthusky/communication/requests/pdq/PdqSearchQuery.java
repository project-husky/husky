/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.pdq;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Singular;
import lombok.ToString;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectAdministrativeGender;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectBirthTime;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02LivingSubjectName;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02MothersMaidenName;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02OtherIDsScopingOrganization;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientAddress;
import net.ihe.gazelle.hl7v3.prpamt201306UV02.PRPAMT201306UV02PatientTelecom;
import net.ihe.gazelle.hl7v3.voc.EntityNameSearchUse;
import org.hl7.fhir.r4.model.ContactPoint;
import org.hl7.fhir.r4.model.Identifier;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.common.enums.AdministrativeGender;
import org.projecthusky.common.model.Address;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.model.Name;
import org.projecthusky.common.model.Telecom;
import org.projecthusky.communication.utils.ConverterUtil;
import org.projecthusky.communication.utils.PixPdqV3Utils;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.fhir.structures.gen.FhirPatient;

/**
 * This class is designed to contain all possible search parameters when looking for patients with the webservice. Parameters are optional, only the ones set will be used in the webservice request.<br/>
 * A SearchQuery is a <b>Patient Demographics Query (PDQ)</b>, as defined in the <a href="https://www.e-health-suisse.ch/technik-semantik/epd-anbindung/informatikverantwortliche.html">E-Health Suisse</a>
 * architecture and in detail in the examples in <a href="https://github.com/ehealthsuisse/EPD-by-example/blob/main/files/PDQ.md">GitHub EPD-By-Example</a>.
 * The possible parameters are listed once more in the <a href="https://profiles.ihe.net/ITI/TF/Volume2/ITI-47.html">IHE definition</a> (under Major Components...).<br/>
 * Important: all below parameters work in unison as <b>AND</b> logic, meaning only Patients which fulfill <b>all</b> given parameters will be returned by the webservice.<br/>
 * The {@link Destination} is a special parameter, it is required to define where the webservice resides and is essential, therefore can not be omitted.<br/>
 * Possible parameters to search Patients by are:
 * <ul>
 * <li>Patient name ({@link Name})</li>
 * <li>Patient's mother's maiden name ({@link Name})</li>
 * <li>Both names can be done in a fuzzy search</li>
 * <li>Patient's ID ({@link Identificator})</li>
 * <li>Patient's Address ({@link Address})</li>
 * <li>Patient's birthday ({@link Date})</li>
 * <li>Patient's gender ({@link AdministrativeGender})</li>
 * <li>Patient's telecom contact ( {@link Telecom}), mostly just telephone numbers though.</li>
 * <li>String IDs of other domains to search in. (a List)</li>
 * </ul>
 * Build all of these into one query and send it with the {@link HuskyService#send(PdqSearchQuery)} method to the webservice.
 * @author szalai
 * @see HuskyService
 * @see HuskyServiceSearchQueryTest
 * @see HuskyQueryExperimentsTest
 */
@Getter
@Builder
@ToString
public class PdqSearchQuery {
	@NonNull
	private Destination destination;

	//TODO: The underlying framework (and the webservice) supports a list of search parameters for each of these below, as is implemented for the domainsToReturn.
	private Name patientName;
	@Builder.Default
	private boolean useFuzzyNameSearch = false;
	private Name mothersMaidenName;
	@Builder.Default
	private boolean useFuzzyMothersMaidenNameSearch = false;
	private Identificator identificator;
	private Address patientAddress;
	private Date patientDateOfBirth;
	private AdministrativeGender patientGender;
	private Telecom telecomContact;

	@Singular("domainToReturn")
	private final List<String> domainsToReturn;
	
	
	public static class PdqSearchQueryBuilder {}

	/**
	 * This method will take all parameters, which are set into the SearchQuery and fill a {@link PdqQuery} with them. Not set params are ignored.
	 * @return a {@link PdqQuery} ready to be sent with the {@link HuskyWebServiceClient} to the webservice.
	 */
	public PdqQuery build() {
		PdqQuery consumerQueryRequestMessage = new PdqQuery(this.destination.getSenderApplicationOid(), null, this.destination.getReceiverApplicationOid(), null);

		addPatientNameToSearchQueryRequestIfSet(consumerQueryRequestMessage);
		addMothersMaidenNameToSearchQueryRequestIfSet(consumerQueryRequestMessage);
		addIdentificatorToSearchQueryRequestIfSet(consumerQueryRequestMessage);
		addPatientAddressToSearchQueryRequestIfSet(consumerQueryRequestMessage);
		addPatientsDateOfBirthToSearchQueryRequestIfSet(consumerQueryRequestMessage);
		addPatientGenderToSerchQueryRequestIfSet(consumerQueryRequestMessage);
		addTelecomContactToSearchQueryRequestIfSet(consumerQueryRequestMessage);
		addAllDomainsToReturnToSearchQueryRequestIfAnySet(consumerQueryRequestMessage);

		return consumerQueryRequestMessage;
	}

	private void addAllDomainsToReturnToSearchQueryRequestIfAnySet(PdqQuery consumerQueryRequestMessage) {
		for (String domainToReturn : this.domainsToReturn) {
			var currentScopingOrganization = new PRPAMT201306UV02OtherIDsScopingOrganization();

			currentScopingOrganization.getValue().add(PixPdqV3Utils.createII(domainToReturn, "", ""));
			currentScopingOrganization.setSemanticsText(PixPdqV3Utils.createST("OtherIDs.scopingOrganization.id"));
			consumerQueryRequestMessage.getParameterList().getOtherIDsScopingOrganization().add(currentScopingOrganization);
		}
	}

	private void addTelecomContactToSearchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.telecomContact != null) {
			ContactPoint contactPoint = FhirPatient.convertTelecom(this.telecomContact);
			final var patientTel = new PRPAMT201306UV02PatientTelecom();

			final var tel = PixPdqV3Utils.createTEL(contactPoint.getValue(), ConverterUtil.convertContactPointToTypeString(contactPoint));
			patientTel.getValue().add(tel);
			patientTel.setSemanticsText(PixPdqV3Utils.createST("Patient.telecom"));
			consumerQueryRequestMessage.getParameterList().getPatientTelecom().add(patientTel);
		}
	}

	private void addPatientGenderToSerchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.patientGender != null) {
			var livingSubjectAdministrativeGender = new PRPAMT201306UV02LivingSubjectAdministrativeGender();
			livingSubjectAdministrativeGender.getValue()
			.add(PixPdqV3Utils.createCE(ConverterUtil.convertAdministrativeGenderToSingleCharString(FhirPatient.convertGender(patientGender))));
			livingSubjectAdministrativeGender
			.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.administrativeGender"));
			consumerQueryRequestMessage.getParameterList().getLivingSubjectAdministrativeGender().add(livingSubjectAdministrativeGender);
		}
	}

	private void addPatientsDateOfBirthToSearchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.patientDateOfBirth != null) {
			final var sdf = new SimpleDateFormat("yyyyMMdd");
			var livingSubjectBirthTime = new PRPAMT201306UV02LivingSubjectBirthTime();

			livingSubjectBirthTime.getValue().add(PixPdqV3Utils.createIVLTS(sdf.format(patientDateOfBirth)));
			livingSubjectBirthTime.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.birthTime"));
			consumerQueryRequestMessage.getParameterList().getLivingSubjectBirthTime().add(livingSubjectBirthTime);
		}
	}

	private void addPatientAddressToSearchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.patientAddress != null) {
			var patientAddressAD = PixPdqV3Utils.createAd(FhirPatient.convertAddress(patientAddress));
			var patientAddress = new PRPAMT201306UV02PatientAddress();

			patientAddress.getValue().add(patientAddressAD);
			patientAddress.setSemanticsText(PixPdqV3Utils.createST("Patient.addr"));
			consumerQueryRequestMessage.getParameterList().getPatientAddress().add(patientAddress);
		}
	}

	private void addIdentificatorToSearchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.identificator != null) {
			Identifier id = new Identifier();
			id.setSystem(identificator.getRoot());
			id.setValue(identificator.getExtension());
			if (id != null && id.getSystem() != null && id.getSystem().length() > 8 && id.getSystem().startsWith(FhirCommon.OID_URN)) {
				final String oid = FhirCommon.removeUrnOidPrefix(id.getSystem());
				consumerQueryRequestMessage.addPatientID(oid, id.getValue(), "");
			} else if (id != null) {
				consumerQueryRequestMessage.addPatientID(id.getSystem(), id.getValue(), "");
			}
		}
	}

	private void addMothersMaidenNameToSearchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.mothersMaidenName != null) {
			var mothersMaidenName = new PRPAMT201306UV02MothersMaidenName();
			var mothersMaidenNamePN = PixPdqV3Utils.createPN(this.mothersMaidenName.getFamily(), this.mothersMaidenName.getGiven(), null,
					this.mothersMaidenName.getSuffix(), this.mothersMaidenName.getPrefix());
			if (this.useFuzzyMothersMaidenNameSearch) {
				mothersMaidenNamePN.setUse(EntityNameSearchUse.SRCH.value());
			}
			mothersMaidenName.getValue().add(mothersMaidenNamePN);
			mothersMaidenName.setSemanticsText(PixPdqV3Utils.createST("MothersMaidenName.name"));
			//TODO: according to the https://profiles.ihe.net/ITI/TF/Volume2/ITI-47.html doc, the "Person.MothersMaidenName" should be used but doesn't work either.
	//		mothersMaidenName.setSemanticsText(PixPdqV3Utils.createST("Person.MothersMaidenName"));
			consumerQueryRequestMessage.getParameterList().getMothersMaidenName().add(mothersMaidenName);
		}
	}

	private void addPatientNameToSearchQueryRequestIfSet(PdqQuery consumerQueryRequestMessage) {
		if (this.patientName != null) {
			var livingSubjectName = new PRPAMT201306UV02LivingSubjectName();
			//TODO: This infrastructure ignores the first name, only puts the family name into the request. Error present in old code.
			var livingSubjectNameEN = PixPdqV3Utils.createEN(this.patientName.getFamily(), this.patientName.getGiven(), null,
					this.patientName.getSuffix(), this.patientName.getPrefix());

			if (this.useFuzzyNameSearch) {
				livingSubjectNameEN.setUse(EntityNameSearchUse.SRCH.value());
			}

			livingSubjectName.getValue().add(livingSubjectNameEN);
			livingSubjectName.setSemanticsText(PixPdqV3Utils.createST("LivingSubject.name"));
			consumerQueryRequestMessage.getParameterList().getLivingSubjectName().add(livingSubjectName);
		}
	}
}
