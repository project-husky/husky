# pixv3 component

The HUSKY pixv3 component encapsulates IPF components in order to implement the following use cases
* Actor (source of patient data) adds patient data to a patient registry 
* Actor merges two patients (and their associated patient data) within a patient registry
* Actor updates patient data within a patient registry
* Actor cross references patients with multiple identifiers (e.g. query patient data and other identifiers by providing one identifier)


In order to achieve the described funtionality the following IPF components have been integrated

## IPF components
The following IPF components are used: 
* pixv3-iti-44 component (https://oehf.github.io/ipf-docs/docs/ihe/iti44pixv3/)
* pixv3-iti-45 component (https://oehf.github.io/ipf-docs/docs/ihe/iti45/)



## Add patient data to a patient registry (Patient identity feed)
A producer (e.g. a hospital, insurance company, ..) acts as a patient identity source and adds patients and their asscoiated data to a registry. 
Patients are registered by sending a valid patient feed message (XML) to the PIX manager, which cross references and validates the patient data and in case of success  adds the patient to the registry and sends back an acknowledgement.

### Example Code
The following code is an excerpt from the test class and shows how to add patient data to the patient manager in the eHealth-Suisse test environment.
(https://ehealthsuisse.ihe-europe.net/PatientManager/patient/allPatients.seam?date=ANY|1634824055405|1634824055405&testData=false)


The following code excerpt shows a simple example of adding a new patient to a patient registry. 
For a more in depth description of all atrributes that may be asscociated with a patient see the java doc of class FhirPatient
The complete source code of the test classes can be found in the file PixV3QueryTest in the package package org.projecthusky.communication.integration 


Excerpt from test class 

```
public void ITI44SourceFeedTest() {

		final AffinityDomain affinityDomain = new AffinityDomain();
		final Destination dest = new Destination();

		dest.setUri(URI.create(pixUri));
		dest.setSenderApplicationOid(senderApplicationOid);
		dest.setReceiverApplicationOid(receiverApplicationOid);
		dest.setReceiverFacilityOid(facilityName);
		affinityDomain.setPdqDestination(dest);
		affinityDomain.setPixDestination(dest);

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace, spidEprOid, spidEprNamespace,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		
		final Identifier identifier = new Identifier();
		identifier.setValue(String.valueOf(System.currentTimeMillis()));
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		final Identifier identifier2 = new Identifier();
		identifier2.setValue(String.valueOf(System.currentTimeMillis()));
		identifier2.setSystem(spidEprOid);
		patient.getIdentifier().add(identifier2);
		
		
		final HumanName humanName = new HumanName().setFamily("Anders").addGiven("Miriam").addGiven("Maria").addPrefix("Dr.")
		.addSuffix("Msc.").setUse(NameUse.OFFICIAL);
		patient.getName().add(humanName);
		
		patient.setGender(AdministrativeGender.OTHER);
		
		final org.hl7.fhir.dstu3.model.Address address = new org.hl7.fhir.dstu3.model.Address()
				.addLine("Testgasse 1").setPostalCode("8010").setCity("Graz").setState("Steiermark").addLine("Eingang 2, Tür 34");
		address.setCountry("AUT");
		patient.getAddress().add(address);
		
		final ContactPoint telHome = new ContactPoint();
		telHome.setUse(ContactPointUse.HOME);
		telHome.setSystem(ContactPointSystem.PHONE);
		telHome.setValue("+431000000000");

		patient.getTelecom().add(telHome);
		
		final CodeableConcept employeeOccupationCode = new CodeableConcept();
		employeeOccupationCode.setText("employeeOccupationCode");
		patient.setEmployeeOccupation(employeeOccupationCode);
		
		patient.getManagingOrganization().setResource(getScopingOrganization());
		
		final FhirContext ctx = new FhirContext(FhirVersionEnum.DSTU3);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.addPatient(patient, null));
		
	}
	
```

## merge two patients within a patient registry
A producer can merge two existing patients by sending a merge request for to a patient registry. The merge request contains a patient object that 
should be merged with an existing patient in the registry identified by a given identifier (second parameter in the mergePatient function call).
The PIX manager performs the merge, and notifies the producer if it was succesful or if an error occured.

The following code excerpt shows a simple example of such a merge request.

```
public void ITI44SourceMergeTest() {
	
		.....

		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Maier").addGiven("Hubert");
		patient.getName().add(humanName);
		
		final Identifier identifier = new Identifier();
		identifier.setValue("1634641399206");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		final Identifier identifier2 = new Identifier();
		identifier2.setValue("SPID-1"); 
		identifier2.setSystem(spidEprOid);
		patient.getIdentifier().add(identifier2);
		patient.setBirthDate(DateUtil.parseDateyyyyMMdd("19500324"));
		patient.setGender(AdministrativeGender.MALE);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.R4);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.mergePatient(patient, "1634721569120", null));
	}
```


## update patient data within a patient registry

A producer can update patient data within a registry eg. changed family names, addresses..
In the following code excerpt the name of patient "Anton Bauer" is changed to "Anton Bauer-Maier"
and the address is also changed


```
public void ITI44SourceUpdateTest() {
		
        ....

		final FhirPatient patient = new FhirPatient();
		final HumanName humanName = new HumanName().setFamily("Bauer-Maier").addGiven("Anton");
		patient.getName().add(humanName);
		final org.hl7.fhir.r4.model.Address address = new org.hl7.fhir.r4.model.Address()
				.addLine("Testgasse 18").setPostalCode("1020").setCity("Wien").setState("AUT");
		final Identifier identifier = new Identifier();
		identifier.setValue("1634793774730");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);
		
		final Identifier identifier2 = new Identifier();
		identifier2.setValue("SPID-101");
		identifier2.setSystem(spidEprOid);
		patient.getIdentifier().add(identifier2);

		patient.getAddress().add(address);
		patient.getManagingOrganization().setResource(getScopingOrganization());

		final FhirContext ctx = new FhirContext(FhirVersionEnum.R4);
		final String encoded = ctx.newXmlParser().encodeResourceToString(patient);
		log.debug(encoded);

		assertTrue(pixV3Query.updatePatient(patient, null));
	}

```


## cross referencing of patients with multiple identifiers

A patient record may be stored in multiple systems, in each of those system it is identified by a unique identifier specific to the system.
A consumer can use one identifier associated with a patient record to query other identifiers associated with the same record.

In the following code excerpt SPID of  patient Léo Gerard is retrieved by using home community ID CHPAM4489

```
public void ITI45ConsumerTest() {

       .....

		PixV3Query pixV3Query = new PixV3Query(affinityDomain, homeCommunityOid, homeCommunityNamespace,
				spidEprOid, spidEprNamespace,
				convenienceMasterPatientIndexV3Client.getContext(),
				convenienceMasterPatientIndexV3Client.getAuditContext());

		final FhirPatient patient = new FhirPatient();
		final Identifier identifier = new Identifier();
		identifier.setValue("CHPAM4489");
		identifier.setSystem(FhirCommon.addUrnOid(homeCommunityOid));
		patient.getIdentifier().add(identifier);

		String patId = pixV3Query.queryPatientId(patient, null);

		assertEquals("761337610436974489", patId);
	}

```
	 









