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
package org.husky.communication.mpi.impl.pdq;

import java.util.Iterator;
import java.util.List;

import org.husky.communication.mpi.V3Response;
import org.husky.communication.utils.PixPdqV3Utils;

import net.ihe.gazelle.hl7v3.datatypes.II;
import net.ihe.gazelle.hl7v3.prpain201306UV02.PRPAIN201306UV02Type;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02Patient;
import net.ihe.gazelle.hl7v3.prpamt201310UV02.PRPAMT201310UV02PersonalRelationship;

/**
 * @author <a href="mailto:anthony.larocca@sage.com">Anthony Larocca</a>
 *
 */
public class V3PdqConsumerResponse extends V3Response {

	private PRPAIN201306UV02Type rootElement = null;
	private String queryAcknowledgement = null;

	/**
	 * Create the V3PdqConsumerResponse given the provided XML element
	 *
	 * @param pdqConsumerResponseElement
	 * @throws Exception
	 */
	public V3PdqConsumerResponse(PRPAIN201306UV02Type pdqConsumerResponseElement) {

		// if we got a pdq response
		rootElement = pdqConsumerResponseElement;

		// set the id
		this.messageId = rootElement.getId();

		// get sender information
		this.sendingApplication = rootElement.getSender().getDevice().getId().get(0).getRoot();
		if (null != rootElement.getSender().getDevice().getAsAgent()
				&& null != rootElement.getSender().getDevice().getAsAgent().getRepresentedOrganization()
				&& !rootElement.getSender().getDevice().getAsAgent().getRepresentedOrganization().getId().isEmpty())
			this.sendingFacility = rootElement.getSender().getDevice().getAsAgent().getRepresentedOrganization().getId()
					.get(0).getRoot();

		// find how many receivers there are
		final int numReceivers = rootElement.getReceiver().size();

		// for each reciever
		for (var i = 0; i < numReceivers; i++) {
			// get the application and (if available) facility
			this.addReceivingApplication(rootElement.getReceiver().get(i).getDevice().getId().get(0).getRoot());
			if (null != rootElement.getReceiver().get(i).getDevice().getAsAgent())
				this.addReceivingFacility(rootElement.getReceiver().get(i).getDevice().getAsAgent()
						.getRepresentedOrganization().getId().get(0).getRoot());
		}

		// get the ack code
		this.acknowledgementCode = rootElement.getAcknowledgement().get(0).getTypeCode().getCode();

		// if there is acknowledgement detail
		if (!rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().isEmpty()) {
			var detailCode = "";
			var detailText = "";

			if (null != rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getCode())
				detailCode = rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getCode()
						.getCode();

			if (null != rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getText())
				detailText = rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getText()
						.getMixed().get(0).toString();

			if (rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getLocation() != null
					&& !rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0).getLocation()
							.isEmpty())
				detailText += " Location: " + rootElement.getAcknowledgement().get(0).getAcknowledgementDetail().get(0)
						.getLocation().get(0).getMixed().get(0).toString();

			this.acknowledgementDetailCode = detailCode;
			this.acknowledgementDetailText = detailText;
		}

		// if the code was AA, then:
		if (acknowledgementCode.equalsIgnoreCase("AA")) {
			// set up the response for data retrieval
			queryAcknowledgement = rootElement.getControlActProcess().getQueryAck().getQueryResponseCode().getCode();

			// if this was an app error
			if (queryAcknowledgement.equalsIgnoreCase("AE")) {
				// set the error text
				errorText = "Query Acknowledgement: AE - Application Error";
			} else if (queryAcknowledgement.equalsIgnoreCase("QE")) {
				// set the error text
				errorText = "Query Acknowledgement: QE - Query Parameter Error";
			} else if (queryAcknowledgement.equalsIgnoreCase("NF")) {
				// Technically, this shouldn't be an error
				hasError = false;
				// set the error text
				errorText = "No patients found.";
			} else if (queryAcknowledgement.equalsIgnoreCase("OK")) {
				// Success!
				hasError = false;
			} else {
				// error occurred, unknown ack
				errorText = "Query Acknowledgement: " + queryAcknowledgement + " not understood.";
			}
		} else {
			// error occurred, unknown ack
			errorText = "Acknowledgement Code: " + acknowledgementCode + " not understood.";
		}
	}

	/**
	 * Get the AckQueryID
	 *
	 * @return II - the AckQueryID for this response
	 */
	public II getAckQueryID() {
		return rootElement.getControlActProcess().getQueryAck().getQueryId();
	}

	/**
	 * Get the number of patient ids for the specified patient.
	 *
	 * @param patientIndex
	 * @return int - the number of patient ids for the specified patient.
	 */
	public int getNumPatientIDs(int patientIndex) {
		return getPatientByIndex(patientIndex).getId().size();
	}

	/**
	 * Get the number of records on this response
	 *
	 * @return int - the value in the "result current quantity" of the response
	 */
	public int getNumRecordsCurrent() {
		var numRecords = 0;
		if (rootElement != null && rootElement.getControlActProcess().getQueryAck().getResultCurrentQuantity() != null)
			numRecords = rootElement.getControlActProcess().getQueryAck().getResultCurrentQuantity().getValue()
					.intValue();
		return numRecords;
	}

	/**
	 * Get the number of records remaining
	 *
	 * @return int - the value in the "result remaining quantity" of the response
	 */
	public int getNumRecordsRemaining() {
		var numRecords = 0;
		if (rootElement != null
				&& rootElement.getControlActProcess().getQueryAck().getResultRemainingQuantity() != null)
			numRecords = rootElement.getControlActProcess().getQueryAck().getResultRemainingQuantity().getValue()
					.intValue();
		return numRecords;
	}

	/**
	 * Get first Address for specified patient
	 *
	 * @param patientIndex
	 * @return String[] - first address for specified patient in String Array
	 *         String[0] = Street Address Line String[1] = Additional Locator
	 *         String[2] = City String[3] = State String[4] = Postal Code String[5]
	 *         = <not populated> String[6] = <not populated> String[7] = <not
	 *         populated> String[8] = County
	 */
	public String[] getPatientAddress(int patientIndex) {
		// just get the first address
		return getPatientAddress(patientIndex, 0);
	}

	/**
	 * Get specified address for specified patient
	 *
	 * @param patientIndex
	 * @param addrIndex
	 * @return String[] - specified address for specified patient in String Array
	 *         String[0] = Street Address Line String[1] = Additional Locator
	 *         String[2] = City String[3] = State String[4] = Postal Code String[5]
	 *         = <not populated> String[6] = <not populated> String[7] = <not
	 *         populated> String[8] = County
	 */
	public String[] getPatientAddress(int patientIndex, int addrIndex) {
		var addressArray = new String[9];
		// get the patient address as an array
		if (getPatientByIndex(patientIndex).getPatientPerson().getAddr().size() > addrIndex)
			addressArray = PixPdqV3Utils
					.adToStringArray(getPatientByIndex(patientIndex).getPatientPerson().getAddr().get(addrIndex));
		return addressArray;
	}

	/**
	 * Get the specified patient's birth order number.
	 *
	 * @param patientIndex
	 * @return String - patient's birth order number
	 */
	public String getPatientBirthOrderNumber(int patientIndex) {

		if (getPatientByIndex(patientIndex).getPatientPerson().getMultipleBirthOrderNumber() != null) {
			final Integer birthOrder = getPatientByIndex(patientIndex).getPatientPerson()
					.getMultipleBirthOrderNumber().getValue();
			return birthOrder.toString();
		}
		return null;
	}

	/**
	 * Get the specified patient object
	 *
	 * @param patientIndex
	 * @return PRPAMT201310UV02Patient - the patient object at the specified index.
	 */
	private PRPAMT201310UV02Patient getPatientByIndex(int patientIndex) {
		return rootElement.getControlActProcess().getSubject().get(patientIndex).getRegistrationEvent().getSubject1()
				.getPatient();
	}

	/**
	 * Get Date of Birth for the specified patient.
	 *
	 * @param patientIndex
	 * @return String - Specified Patient's Date of Birth
	 */
	public String getPatientDOB(int patientIndex) {
		var patientDOB = "";
		if (getPatientByIndex(patientIndex).getPatientPerson().getBirthTime() != null)
			patientDOB = getPatientByIndex(patientIndex).getPatientPerson().getBirthTime().getValue();
		return patientDOB;
	}

	/**
	 * Get the first id for the specified patient
	 *
	 * @param patientIndex
	 * @return String[] - Patient ID in String Array String[0] = id.getExtension();
	 *         String[1] = id.getAssigningAuthorityName(); String[2] = id.getRoot();
	 *         String[3] = "";
	 */
	public String[] getPatientID(int patientIndex) {
		// get just the first patientID
		return getPatientID(patientIndex, 0);
	}

	/**
	 * Get the specified ID for the specified patient
	 *
	 * @param patientIndex
	 * @param idIndex
	 * @return String[] - Patient ID in String Array String[0] = id.getExtension();
	 *         String[1] = id.getAssigningAuthorityName(); String[2] = id.getRoot();
	 *         String[3] = "";
	 */
	public String[] getPatientID(int patientIndex, int idIndex) {
		String[] response = null;
		// if there is an id at this level
		if (getPatientByIndex(patientIndex).getId().size() > idIndex)
			response = PixPdqV3Utils.iiToStringArray(getPatientByIndex(patientIndex).getId().get(idIndex));

		// return the response
		return response;
	}

	/**
	 * Get all of the patient Ids from the response
	 *
	 * @return String[] - Array of Ids in HL7 format
	 */
	public String[] getPatientIds() {
		final var patientIds = new String[getNumRecordsCurrent()];
		for (var i = 0; i < getNumRecordsCurrent(); i++) {
			final String[] patientId = getPatientID(i);
			patientIds[i] = patientId[0] + "^^^&" + patientId[2] + "&" + patientId[1];
		}
		return patientIds;
	}

	/**
	 * Get the first mother's maiden name for the specified patient
	 *
	 * @param patientIndex
	 * @return String[] - the first Mother's maiden name in String Array if
	 *         available, otherwise null
	 */
	public String[] getPatientMothersMaidenName(int patientIndex) {
		return getPatientName(patientIndex, 0);
	}

	/**
	 * Get the specified Mother's Maiden name for the specified Patient
	 *
	 * @param patientIndex
	 * @param nameIndex
	 * @return String[] - Mother's maiden name in String Array if available,
	 *         otherwise null
	 */
	public String[] getPatientMothersMaidenName(int patientIndex, int nameIndex) {

		final List<PRPAMT201310UV02PersonalRelationship> relationship = getPatientByIndex(patientIndex)
				.getPatientPerson().getPersonalRelationship();
		if (relationship != null) {
			final Iterator<PRPAMT201310UV02PersonalRelationship> iter = relationship.iterator();
			while (iter.hasNext()) {
				final PRPAMT201310UV02PersonalRelationship pr = iter.next();
				if (pr.getCode().getCode().equalsIgnoreCase("MTH")) {
					return PixPdqV3Utils.enToStringArray(pr.getRelationshipHolder1().getName().get(nameIndex));
				}
			}
		}
		return null;
	}

	/**
	 * Get the specified patient's Multiple Birth Indicator
	 *
	 * @param patientIndex
	 * @return String - patient's Multiple Birth Indicator
	 */
	public String getPatientMultipleBirthIndicator(int patientIndex) {

		if (getPatientByIndex(patientIndex).getPatientPerson().getMultipleBirthInd() != null) {
			final boolean response = getPatientByIndex(patientIndex).getPatientPerson().getMultipleBirthInd().value;
			if (response) {
				return "true";
			}
			return "false";
		}
		return null;
	}

	/**
	 * Get the first patient name for the specified patient
	 *
	 * @param patientIndex
	 * @return String[] - specified patient name in String Array: String[0] = Family
	 *         Name String[1] = Given Name (first instance) String[2] = Given Name
	 *         (second instance, if available) String[3] = Suffix String[4] = Prefix
	 */
	public String[] getPatientName(int patientIndex) {
		// get the patient name as an array
		return getPatientName(patientIndex, 0);
	}

	/**
	 * Get the specified patient name for the specified patient
	 *
	 * @param patientIndex
	 * @param nameIndex
	 * @return String[] - specified patient name in String Array: String[0] = Family
	 *         Name String[1] = Given Name (first instance) String[2] = Given Name
	 *         (second instance, if available) String[3] = Suffix String[4] = Prefix
	 */
	public String[] getPatientName(int patientIndex, int nameIndex) {
		// get the patient name as an array
		return PixPdqV3Utils
				.pnToStringArray(getPatientByIndex(patientIndex).getPatientPerson().getName().get(nameIndex));
	}

	/**
	 * Get the Patients Business Phone number (Use code of "WP")
	 *
	 * @param patientIndex
	 * @return String - Telecom value with use code of "WP" for the specified
	 *         patient, if available
	 */
	public String getPatientPhoneBusiness(int patientIndex) {
		return PixPdqV3Utils.getTelecomByUseCode(getPatientByIndex(patientIndex).getPatientPerson().getTelecom(), "WP");
	}

	/**
	 * Get the Patients Home Phone number (Use code of "HP")
	 *
	 * @param patientIndex
	 * @return String - Telecom value with use code of "HP" for the specified
	 *         patient, if available
	 */
	public String getPatientPhoneHome(int patientIndex) {
		return PixPdqV3Utils.getTelecomByUseCode(getPatientByIndex(patientIndex).getPatientPerson().getTelecom(), "HP");
	}

	/**
	 * @param patientIndex
	 * @return
	 */
	public String getPatientSex(int patientIndex) {
		return getPatientByIndex(patientIndex).getPatientPerson().getAdministrativeGenderCode().getCode();
	}

	/**
	 * Get the root element of the response
	 *
	 * @return PRPAIN201306UV02Type - the root element
	 */
	public PRPAIN201306UV02Type getPdqResponse() {
		return rootElement;
	}

	/**
	 * Get the Query Acknowledgement
	 *
	 * @return String - the Query Acknowledgement
	 */
	public String getQueryAcknowledgement() {
		return queryAcknowledgement;
	}

}
