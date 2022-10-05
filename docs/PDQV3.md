# pdqv3 component

The husky pdq component encapsulates IPF components in order to implement the following use case

* Actor (Consumer) searches a patient registry for patient data that conforms to a number of given search criteria.
  
All attributes of a patient objects can be used as search criteria. Usually unique identifiers like an SPID or a social security number o person specific attributes like name, first name, gender, birth date, address  e.g are used to search for and retrieve stored patient data

In order to achieve the described functionality the following IPF component has been integrated

## IPF component
* pdqv3-iti-47 component (https://oehf.github.io/ipf-docs/docs/ihe/iti47)


## search for a patient in a patient registry


The following code excerpt shows how to search for patient by first name birth date and address. In case the query succeeds (no exception occurs) the the success attribute of the response object is set to true. The response object contains a list of all Patient objects that confirm to the given search criteria, which might be empty in case no record was found.
The complete source code of the test classes can be found in the file PixV3QueryTest in the package package org.projecthusky.communication.integration 

```
public void ITI47ConsumerQueryPatientPatientIdMultipleCriteria() {
		
		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();
		dest.setUri(URI.create(pdqUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(applicationName);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest); 

		LOGGER.debug("ITI47ConsumerQueryPatientPatientIdSearchByName with ipAdress Target " + pdqUri);
		final MasterPatientIndexQuery mpiQuery = new MasterPatientIndexQuery(affinityDomain.getPdqDestination());
		
		try {
			mpiQuery.setPatientDateOfBirth(new SimpleDateFormat("dd.MM.yyyy").parse("22.06.1958"));
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	  
		Name patientName = new Name();
		patientName.setGiven("David");
		mpiQuery.addPatientName(false, patientName);
	    Address address = new Address(new AddressBaseType());
	    address.setCity("Acworth");
	    address.setPostalCode("30101");
	    address.setStreetName("Southside Drive");
	    mpiQuery.addPatientAddress(address);
		
		final MasterPatientIndexQueryResponse response = convenienceMasterPatientIndexV3Client
				.queryPatientDemographics(mpiQuery, affinityDomain, null);
		
		assertTrue(response.getSuccess());
		assertEquals(response.getPatients().size(),1);
		Patient patient = response.getPatients().get(0);
		assertEquals(patient.getCompleteName().trim(),"David Sanders");
		assertEquals(patient.getAdministrativeGenderCode(),AdministrativeGender.MALE.getCodeValue());
		
	} 

```