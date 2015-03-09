/*******************************************************************************
 * 
 * The authorship of this code and the accompanying materials is held by ahdis gmbh, Switzerland.
 * All rights reserved. http://ahdis.ch
 * 
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * 
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 * 
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 3.0 Switzerland License.
 * 
 * Year of publication: 2015
 * 
 *******************************************************************************/
package org.ehealth_connector.communication.mpi.impl;

import java.io.StringWriter;
import java.net.URI;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.MpiAdapterInterface;
import org.openhealthtools.ihe.atna.auditor.PIXConsumerAuditor;
import org.openhealthtools.ihe.atna.auditor.PIXSourceAuditor;
import org.openhealthtools.ihe.pix.consumer.v3.V3PixConsumer;
import org.openhealthtools.ihe.pix.consumer.v3.V3PixConsumerQuery;
import org.openhealthtools.ihe.pix.consumer.v3.V3PixConsumerResponse;
import org.openhealthtools.ihe.pix.source.v3.V3PixSource;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceAcknowledgement;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceMergePatients;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceRecordAdded;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceRecordRevised;
import org.w3c.dom.Element;

import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Organization;

/**
 * V3PixAdapter
 * 
 * V3PixAdapter implements the Actor Patient Identity Source from ITI-44 Patient Identity Feed HL7
 * V3 and the Actor Patient Identifier Cross-reference Consumer from ITI-55 PIXV3 Query
 * 
 * @see ftp://ftp.ihe.net/DocumentPublication/CurrentPublished/ITInfrastructure/IHE_ITI_TF_Vol2b.pdf
 * 
 * The V3PixAdapter implements the MpiAdapterIntefarce with the Open Health Tools (OHT) IHE
 * Profile Classes V3PixConsumer and V3PixSource Open Health Tools IHE Profiles 
 * @see https://www.projects.openhealthtools.org/sf/projects/iheprofiles/ 
 * V3PixSource @see https://www.projects.openhealthtools.org/sf/projects/iheprofiles/javadocs/2.0.0/org/openhealthtools/ihe/pix/source/v3/V3PixSource.html 
 * V3PixConsumer @see https://www.projects.openhealthtools.org/sf/projects/iheprofiles /javadocs/2.0.0/org/openhealthtools/ihe/pix/consumer/v3/V3PixConsumer.html
 * 
 * @author oliveregger
 */
public class V3PixAdapter implements MpiAdapterInterface {

  private Log log = LogFactory.getLog(V3PixAdapter.class);

  private V3PixAdapterConfig adapterCfg;

  private String homeCommunityOid;

  private boolean sourceConfigured;

  private boolean consumerConfigured;

  protected V3PixSource pixSource;

  protected V3PixConsumer v3PixConsumer;

  /**
   * Instantiates a new v3 pix adapter.
   */
  public V3PixAdapter() {

  }

  /**
   * Instantiates a new v3 pix adapter.
   * 
   * @param adapterConfig the adapter config
   */
  public V3PixAdapter(V3PixAdapterConfig adapterConfig) {
    adapterCfg = adapterConfig;
    homeCommunityOid = adapterCfg.homeCommunityOid;
  }

  /**
   * Adds the demographic data of a patient for the V3PixSourceRecordAdded message
   * 
   * @param patient the patient
   * @param v3RecordAddedMessage the message
   */
  private void addDemographicData(FhirPatient patient, V3PixSourceRecordAdded v3RecordAddedMessage) {
    addDemographicData(patient, v3RecordAddedMessage, null, null);
  }

  /**
   * Adds the demographic data of a patient for the V3PixSourceRecordRevised message
   * 
   * @param patient the patient
   * @param v3RecordRevisedMessage the message
   */
  private void addDemographicData(FhirPatient patient,
      V3PixSourceRecordRevised v3RecordRevisedMessage) {
    addDemographicData(patient, null, v3RecordRevisedMessage, null);
  }

  /**
   * Adds the demographic data of a patient for the V3PixSourceMergePatients message
   * 
   * @param patient the patient
   * @param v3MergePatientsMessage the message
   */
  private void addDemographicData(FhirPatient patient,
      V3PixSourceMergePatients v3MergePatientsMessage) {
    addDemographicData(patient, null, null, v3MergePatientsMessage);
  }

  /**
   * adds the demographic data to the pix queries, can be overloaded if additional information of
   * the patient needs to be providied for the mpi.
   * 
   * @param patient the patient
   * @param v3RecordAddedMessage the v3 add message
   * @param v3RecordRevisedMessage the v3 revised message
   * @param v3MergePatientsMessage the v3 merge message
   */
  protected void addDemographicData(FhirPatient patient,
      V3PixSourceRecordAdded v3RecordAddedMessage, V3PixSourceRecordRevised v3RecordRevisedMessage,
      V3PixSourceMergePatients v3MergePatientsMessage) {

    // patient local id
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientID(getPatientId(patient, homeCommunityOid), homeCommunityOid,
          adapterCfg.homeCommunityNamespace);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientID(getPatientId(patient, homeCommunityOid),
          homeCommunityOid, adapterCfg.homeCommunityNamespace);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientID(getPatientId(patient, homeCommunityOid),
          homeCommunityOid, adapterCfg.homeCommunityNamespace);
    }

    // Name
    String familyName = patient.getName().get(0).getFamilyAsSingleString();
    String givenName = patient.getName().get(0).getGivenAsSingleString();
    String otherName = ""; // other is resolved into given in addPatientName
    // below, we have that already with above lines
    String prefixName = patient.getName().get(0).getPrefixAsSingleString();
    String suffixName = patient.getName().get(0).getSuffixAsSingleString();

    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.addPatientName(familyName, givenName, otherName, prefixName, suffixName);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.addPatientName(familyName, givenName, otherName, prefixName,
          suffixName);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.addPatientName(familyName, givenName, otherName, prefixName,
          suffixName);
    }

    // Gender
    if (patient.getGender() != null) {
      String gender = "";
      if ("male".equals(patient.getGender())) {
        gender = "M";
      } else if ("female".equals(patient.getGender())) {
        gender = "F";
      } else {
        gender = "U";
      }
      if (v3RecordAddedMessage != null) {
        v3RecordAddedMessage.setPatientGender(gender);
      }
      if (v3RecordRevisedMessage != null) {
        v3RecordRevisedMessage.setPatientGender(gender);
      }
      if (v3MergePatientsMessage != null) {
        v3MergePatientsMessage.setPatientGender(gender);
      }
    }

    // Birthtime
    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setPatientBirthTime(patient.getBirthDateElement().getValueAsString()
          .replaceAll("-", ""));
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage.setPatientBirthTime(patient.getBirthDateElement().getValueAsString()
          .replaceAll("-", ""));
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage.setPatientBirthTime(patient.getBirthDateElement().getValueAsString()
          .replaceAll("-", ""));
    }

    // scoping organization set the scoping organization
    String organizationOid = "";
    String organizationName = "";
    String telecomValue = "";

    Organization organization = (Organization) patient.getManagingOrganization().getResource();

    if (organization != null && organization.getIdentifier().size() > 0) {
      IdentifierDt organizationId = organization.getIdentifier().get(0);
      if (organizationId.getSystem().startsWith("urn:oid:")) {
        organizationOid = organizationId.getSystem().substring(8);
      }
      organizationName = organizationId.getValue();
    }

    if (organization != null && organization.getTelecom().size() > 0) {
      telecomValue = organization.getTelecomFirstRep().getValue();
    }

    if (v3RecordAddedMessage != null) {
      v3RecordAddedMessage.setScopingOrganization(organizationOid, organizationName, telecomValue);
    }
    if (v3RecordRevisedMessage != null) {
      v3RecordRevisedMessage
          .setScopingOrganization(organizationOid, organizationName, telecomValue);
    }
    if (v3MergePatientsMessage != null) {
      v3MergePatientsMessage
          .setScopingOrganization(organizationOid, organizationName, telecomValue);
    }

    if (patient.getAddress().size()>0) {
      // Patient Address
      AddressDt addressDt = patient.getAddress().get(0);
  
      String adressOtherDesignation = null;
      if (addressDt.getLine().size() > 1) {
        adressOtherDesignation = addressDt.getLine().get(1).getValueAsString();
      }
  
      // FIXME parameter adressType
      if (v3RecordAddedMessage != null) {
        v3RecordAddedMessage.addPatientAddress(addressDt.getLineFirstRep().getValue(),
            addressDt.getCity(), null, addressDt.getState(), addressDt.getCountry(),
            addressDt.getPostalCode(), adressOtherDesignation, null);
      }
      if (v3RecordRevisedMessage != null) {
        v3RecordRevisedMessage.addPatientAddress(addressDt.getLineFirstRep().getValue(),
            addressDt.getCity(), null, addressDt.getState(), addressDt.getCountry(),
            addressDt.getPostalCode(), adressOtherDesignation, null);
      }
      if (v3MergePatientsMessage != null) {
        v3MergePatientsMessage.addPatientAddress(addressDt.getLineFirstRep().getValue(),
            addressDt.getCity(), null, addressDt.getState(), addressDt.getCountry(),
            addressDt.getPostalCode(), adressOtherDesignation, null);
      }
    }

  }

  /**
   * adds a patient to the mpi. implements ITI-44 Patient Identity Source – Add Patient Record
   * 
   * @param patient the patient
   * @return true, if successful
   * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#addPatient(org.ehealth_connector.
   *      communication.mpi.FhirPatient)
   */
  public boolean addPatient(FhirPatient patient) {
    configure(true);
    log.debug("creating v3RecordAddedMessage");
    V3PixSourceRecordAdded v3RecordAddedMessage =
        new V3PixSourceRecordAdded(adapterCfg.senderApplicationOid, adapterCfg.senderFacilityOid,
            adapterCfg.receiverApplicationOid, adapterCfg.receiverFacilityOid);
    log.debug("add demographic data");
    addDemographicData(patient, v3RecordAddedMessage);
    try {
      printMessage("addPatient", v3RecordAddedMessage.getRequest());
      V3PixSourceAcknowledgement v3pixack = pixSource.sendRecordAdded(v3RecordAddedMessage);
      printMessage("sendRecordAdded", v3pixack.getRequest());
      return checkResponse(v3pixack);
    } catch (Exception e) {
      log.error("addPatient failed", e);
      return false;
    }
  }

  /**
   * Checks the response, error are logged
   * 
   * @param response the response
   * @return true, if response has no error, false if there are errors
   */
  private boolean checkResponse(V3PixSourceAcknowledgement response) {
    if (response.hasError()) {
      log.error("AcknowledgementCode: " + response.getAcknowledgementCode());
      log.error("Query error text: " + response.getErrorText());
      return false;
    }
    return true;
  }

  /**
   * updates the demographic information of the patient in the mpi.
   * 
   * implements ITI-44 Patient Identity Source – Revise Patient Record updates the demographic
   * information of the patient in the mpi.
   * 
   * @param patient the patient
   * @return true, if successful
   * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#updatePatient(org.ehealth_connector.
   *      communication.mpi.FhirPatient)
   */
  public boolean updatePatient(FhirPatient patient) {
    if (pixSource == null) {
      pixSource = new V3PixSource(adapterCfg.pixSourceUri);
    }
    V3PixSourceRecordRevised v3RecordRevisedMessage =
        new V3PixSourceRecordRevised(adapterCfg.senderApplicationOid, adapterCfg.senderFacilityOid,
            adapterCfg.receiverApplicationOid, adapterCfg.receiverFacilityOid);
    addDemographicData(patient, v3RecordRevisedMessage);
    try {
      printMessage("sourceUpdate", v3RecordRevisedMessage.getRequest());
      V3PixSourceAcknowledgement v3pixack = pixSource.sendRecordRevised(v3RecordRevisedMessage);
      printMessage("sourceUpdate", v3pixack.getRequest());
      return checkResponse(v3pixack);
    } catch (Exception e) {
      log.error("updatePatient failed", e);
      return false;
    }
  }

  /**
   * Merge patient. implements ITI-44 Patient Identity Source – Patient Identity Merge
   * 
   * Patient Registry Duplicates Resolved message indicates that the Patient Identity Source has
   * done a merge within a specific Patient Identification Domain. That is, the surviving identifier
   * (patient ID) has subsumed a duplicate patient identifier.
   * 
   * @param patient the patient (with the suriving identifier)
   * @param obsoleteId the obsolete id (duplicate patient identifier)
   * @return true, if successful
   * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#mergePatient(org.ehealth_connector.
   *      communication.mpi.FhirPatient, java.lang.String)
   */
  public boolean mergePatient(FhirPatient patient, String obsoleteId) {

    if (!configure(true)) {
      return false;
    }

    V3PixSourceMergePatients v3MergePatientsMessage =
        new V3PixSourceMergePatients(adapterCfg.senderApplicationOid, adapterCfg.senderFacilityOid,
            adapterCfg.receiverApplicationOid, adapterCfg.receiverFacilityOid);
    addDemographicData(patient, v3MergePatientsMessage);
    v3MergePatientsMessage.setObsoletePatientID(obsoleteId, this.homeCommunityOid,
        this.adapterCfg.homeCommunityNamespace);
    try {
      printMessage("sourceMerge", v3MergePatientsMessage.getRequest());
      V3PixSourceAcknowledgement v3pixack = pixSource.sendMergePatients(v3MergePatientsMessage);
      printMessage("sourceMerge", v3pixack.getRequest());
      return checkResponse(v3pixack);
    } catch (Exception e) {
      log.error("mergePatient failed", e);
      return false;
    }
  }

  /**
   * Gets the patient domain id.
   * 
   * @param v3PixConsumerResponse the v3 pix consumer response
   * @param rootOid the root oid
   * @return the patient domain id
   */
  public String getPatientDomainId(V3PixConsumerResponse v3PixConsumerResponse, String rootOid) {

    if (rootOid != null
        && v3PixConsumerResponse != null
        && ((v3PixConsumerResponse.getNumPatientIds() > 0) || (v3PixConsumerResponse
            .getNumAsOtherIds() > 0))) {

      for (int i = 0; i < v3PixConsumerResponse.getNumPatientIds(); i++) {
        String id[] = v3PixConsumerResponse.getPatientID(i);
        if (id[1] != null && id[1].equals(rootOid)) {
          return id[0];
        }
      }
      for (int i = 0; i < v3PixConsumerResponse.getNumAsOtherIds(); i++) {
        String id[] = v3PixConsumerResponse.getPatientAsOtherID(i);
        if (id[1] != null && id[1].equals(rootOid)) {
          return id[0];
        }
      }
    }
    return null;
  }

  /**
   * Gets the home community patient id.
   * 
   * @param patient the patient
   * @return the home community patient id
   */
  private String getHomeCommunityPatientId(FhirPatient patient) {
    for (IdentifierDt identifierDt : patient.getIdentifier()) {
      if (identifierDt.getSystem().startsWith("urn:oid:")) {
        if (identifierDt.getSystem().substring(8).equals(this.homeCommunityOid)) {
          return identifierDt.getValue();
        }
      }
    }
    return null;
  }

  /**
   * Query patient id.
   * 
   * @param patient the patient
   * @return the string
   */
  public String queryPatientId(FhirPatient patient) {
    return queryPatientId(patient, null, null)[0];
  }

  /**
   * query the mpi with patient id and return the ids in the queried Domains from the mpi.
   * 
   * Implements ITI-45 Patient Identifier Cross-reference Consumer Queries the Patient Identifier
   * Cross-reference Manager for a list of corresponding patientidentifiers, if any
   * 
   * @param patient the patient
   * @param queryDomainOids the query domain oids
   * @param queryDomainNamespaces the query domain namespaces
   * @return the string[]
   * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#queryPatientId(org.ehealth_connector.
   *      communication.mpi.FhirPatient, java.lang.String, java.lang.String)
   */
  public String[] queryPatientId(FhirPatient patient, String[] queryDomainOids,
      String[] queryDomainNamespaces) {

    if (!configure(false)) {
      return null;
    }
    String domainToReturnOids[] = null;
    String domainToReturnNamespaces[] = null;

    if (queryDomainOids != null) {
      domainToReturnOids = queryDomainOids;
    } else {
      if (adapterCfg.domainToReturnOid!=null) {
        domainToReturnOids = new String[1];
        domainToReturnOids[0] = adapterCfg.domainToReturnOid;
      }
    }
    if (queryDomainNamespaces != null) {
      domainToReturnNamespaces = queryDomainNamespaces;
    } else if (adapterCfg.domainToReturnNamespace != null) {
      domainToReturnNamespaces = new String[1];
      domainToReturnNamespaces[0] = adapterCfg.domainToReturnNamespace;
    }

    V3PixConsumerQuery v3PixConsumerQuery =
        new V3PixConsumerQuery(adapterCfg.senderApplicationOid, adapterCfg.senderFacilityOid,
            adapterCfg.receiverApplicationOid, adapterCfg.receiverFacilityOid);

    // add the patient identifier
    String homeCommunityPatientId = this.getHomeCommunityPatientId(patient);
    if (homeCommunityPatientId != null) {
      v3PixConsumerQuery.addPatientIdToQuery(homeCommunityPatientId, homeCommunityOid,
          adapterCfg.homeCommunityNamespace);

      if (domainToReturnOids!=null) {
        for (int i = 0; i < domainToReturnOids.length; ++i) {
          String domainToReturnOid = domainToReturnOids[i];
          String domainToReturnNamespace = null;
          if (domainToReturnNamespaces != null && i < domainToReturnNamespaces.length) {
            domainToReturnNamespace = domainToReturnNamespaces[i];
          }
          v3PixConsumerQuery.addDomainToReturn(domainToReturnOid, domainToReturnNamespace);
        }
      }
      V3PixConsumerResponse v3PixConsumerResponse = null;
      try {
        v3PixConsumerResponse = v3PixConsumer.sendQuery(v3PixConsumerQuery);
        if (domainToReturnOids!=null) {
          String returnIds[] = new String[domainToReturnOids.length];
          for (int i = 0; i < returnIds.length; ++i) {
            returnIds[i] = getPatientDomainId(v3PixConsumerResponse, domainToReturnOids[i]);
          }
          return returnIds;
        }
        return null;
      } catch (Exception e) {
        log.error("exception queryPatient", e);
        return null;
      }
    } else {
      log.error("homeCommunityPatientId not provided");
      return null;
    }
  }

  /**
   * Configures the V3PixAdapter, is automatically called by the different functions.
   * 
   * @param source true if source actor, false for consumer
   * @return true, if successful
   */
  public boolean configure(boolean source) {
    try {
      log.debug("configure start");
      if (source && !sourceConfigured) {
        this.sourceConfigured = true;
        if (adapterCfg.auditSourceId != null) {
          PIXSourceAuditor.getAuditor().getConfig().setAuditSourceId(adapterCfg.auditSourceId);
        }
        if (adapterCfg.auditRepositoryUri != null) {
          PIXSourceAuditor.getAuditor().getConfig()
              .setAuditRepositoryUri(adapterCfg.auditRepositoryUri);
        }
        if (pixSource == null) {
          pixSource = new V3PixSource(adapterCfg.pixSourceUri);
        }
      }
      if (!source && !consumerConfigured) {
        this.consumerConfigured = true;
        if (adapterCfg.auditSourceId != null) {
          PIXConsumerAuditor.getAuditor().getConfig().setAuditSourceId(adapterCfg.auditSourceId);
        }
        if (adapterCfg.auditRepositoryUri != null) {
          PIXConsumerAuditor.getAuditor().getConfig()
              .setAuditRepositoryUri(adapterCfg.auditRepositoryUri);
        }
        if (v3PixConsumer == null) {
          v3PixConsumer = new V3PixConsumer(adapterCfg.pixQueryUri);
        }
      }
    } catch (Exception e) {
      log.error("configuring not successfull", e);
      return false;
    }
    log.debug("configure end");
    return true;
  }

  /**
   * Logs a debug message
   * 
   * @param test will be prefixed to the log message
   * @param element the xml element serialized to be logged
   */
  private void printMessage(String test, Element element) {

    try {
      // use a transformer to improve the output of the xml
      Transformer transformer = TransformerFactory.newInstance().newTransformer();
      transformer.setOutputProperty(OutputKeys.INDENT, "yes");

      // initialize StreamResult with File object to save to file
      StreamResult result = new StreamResult(new StringWriter());
      DOMSource source = new DOMSource(element);
      transformer.transform(source, result);

      String xmlString = result.getWriter().toString();

      log.debug(test + "\r" + xmlString);
    } catch (Exception e) {
      log.debug(test + " problem encountered in printMessage");
    }
  }

  /**
   * Inits the home community
   * 
   * if home community ist not defined and patient has only one identifier, the home homeCommunityId
   * is initialized with the system of the identifier
   * 
   * @param patient the patient
   */
  private void initHomeCommunityId(FhirPatient patient) {
    if (homeCommunityOid == null) {
      if (patient.getIdentifier().size() == 1) {
        if (patient.getIdentifierFirstRep().getSystem().startsWith("urn:oid:")) {
          homeCommunityOid = patient.getIdentifier().get(0).getSystem();
        }
      } else {
        throw new IllegalStateException("homeCommunityId has to be specified");
      }
    }
  }

  /**
   * returns a patient id defined by patient identity issuing system.
   * 
   * @param patient the Patient
   * @param systemOid the oid of the system responsible which issued the patient id
   * @return the patient id
   */
  private String getPatientId(FhirPatient patient, String systemOid) {
    initHomeCommunityId(patient);
    for (IdentifierDt identifierDt : patient.getIdentifier()) {
      String idSystem = identifierDt.getSystem();
      if (idSystem != null && idSystem.equals("urn:oid:"+systemOid)) {
        return identifierDt.getValue();
      }
    }
    return null;
  }

}
