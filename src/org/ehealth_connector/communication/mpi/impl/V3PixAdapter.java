/*******************************************************************************
*
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
* All rights reserved. http://medshare.net
*
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
*
 * This code is are made available under the terms of the Eclipse Public License v1.0.
*
 * Accompanying materials are made available under the terms of the Creative Commons
* Attribution-ShareAlike 4.0 Switzerland License.
*
 * Year of publication: 2015
*
 *******************************************************************************/
package org.ehealth_connector.communication.mpi.impl;

import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.communication.mpi.FhirPatient;
import org.ehealth_connector.communication.mpi.MpiAdapterInterface;
import org.hl7.v3.AD;
import org.openhealthtools.ihe.atna.auditor.PIXConsumerAuditor;
import org.openhealthtools.ihe.atna.auditor.PIXSourceAuditor;
import org.openhealthtools.ihe.common.hl7v3.client.PixPdqV3Utils;
import org.openhealthtools.ihe.pix.consumer.v3.V3PixConsumer;
import org.openhealthtools.ihe.pix.consumer.v3.V3PixConsumerQuery;
import org.openhealthtools.ihe.pix.consumer.v3.V3PixConsumerResponse;
import org.openhealthtools.ihe.pix.source.v3.V3PixSource;
import org.openhealthtools.ihe.pix.source.v3.V3PixSourceAcknowledgement;
import org.w3c.dom.Element;

import ca.uhn.fhir.model.api.IDatatype;
import ca.uhn.fhir.model.dstu2.composite.AddressDt;
import ca.uhn.fhir.model.dstu2.composite.CodeableConceptDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.primitive.BooleanDt;
import ca.uhn.fhir.model.primitive.DateTimeDt;
import ca.uhn.fhir.model.primitive.IntegerDt;

/**
 * V3PixAdapter
 * 
 * V3PixAdapter implements the Actor Patient Identity Source from ITI-44 Patient Identity Feed HL7
 * V3 and the Actor Patient Identifier Cross-reference Consumer from ITI-45 PIXV3 Query.
 * 
 * @author oliveregger
 * @see ftp://ftp.ihe.net/DocumentPublication/CurrentPublished/ITInfrastructure/IHE_ITI_TF_Vol2b.pdf
 * 
 *      The V3PixAdapter implements the MpiAdapterIntefarce with the Open Health Tools (OHT) IHE
 *      Profile Classes V3PixConsumer and V3PixSource Open Health Tools IHE Profiles
 * @see https://www.projects.openhealthtools.org/sf/projects/iheprofiles/ V3PixSource @see
 *      https://www
 *      .projects.openhealthtools.org/sf/projects/iheprofiles/javadocs/2.0.0/org/openhealthtools
 *      /ihe/pix/source/v3/V3PixSource.html V3PixConsumer @see
 *      https://www.projects.openhealthtools.org/sf/projects/iheprofiles
 *      /javadocs/2.0.0/org/openhealthtools/ihe/pix/consumer/v3/V3PixConsumer.html
 */
public class V3PixAdapter implements MpiAdapterInterface {

  /** The log. */
  private Log log = LogFactory.getLog(V3PixAdapter.class);

  /** The adapter cfg. */
  private V3PixAdapterConfig adapterCfg;

  /** The home community oid. */
  private String homeCommunityOid;

  /** The source configured. */
  private boolean sourceConfigured;

  /** The consumer configured. */
  private boolean consumerConfigured;

  /** The pix source. */
  protected V3PixSource pixSource;

  /** The v3 pix consumer. */
  protected V3PixConsumer v3PixConsumer;

  /**
   * Used to capture additional oid identifiers for the person such as a Drivers’ license or Social
   * Security Number.
   */
  protected Set<String> otherIdsOidSet;

  /**
   * Instantiates a new v3 pix adapter.
   */
  public V3PixAdapter() {
    otherIdsOidSet = new HashSet<String>();
  }

  /**
   * Instantiates a new v3 pix adapter.
   * 
   * @param adapterConfig the adapter config
   */
  public V3PixAdapter(V3PixAdapterConfig adapterConfig) {
    otherIdsOidSet = new HashSet<String>();
    adapterCfg = adapterConfig;
    homeCommunityOid = adapterCfg.homeCommunityOid;
    if (adapterConfig.otherOidIds!=null) {
      for(String oid: adapterConfig.otherOidIds) {
        otherIdsOidSet.add(oid); 
      }
    }
  }


  /**
   * adds the demographic data to the pix queries, can be overloaded if additional information of
   * the patient needs to be providied for the mpi.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 add message
   */
  protected void addDemographicData(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    if (v3PixSourceMessage == null) {
      return;
    }
    setScopingOrganization(patient, v3PixSourceMessage);
    addPatientIds(patient, v3PixSourceMessage);
    addPatientName(patient, v3PixSourceMessage);
    setPatientBirthTime(patient, v3PixSourceMessage);
    setPatientGender(patient, v3PixSourceMessage);
    addPatientAddresses(patient, v3PixSourceMessage);
    addPatientTelecoms(patient, v3PixSourceMessage);
    addLanguageCommunications(patient, v3PixSourceMessage);
    setPatientMaritalStatus(patient, v3PixSourceMessage);
    setDeceased(patient, v3PixSourceMessage);
    setMultipeBirth(patient, v3PixSourceMessage);
    setPatientMothersMaidenName(patient, v3PixSourceMessage);
    setBirthPlace(patient, v3PixSourceMessage);
    setPatientReligiousAffiliation(patient, v3PixSourceMessage);
    // TODO Citizen not implemented in OHT
    // TODO Nation not implemented in OHT
    // TODO Employee not implemented in OHT
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
    V3PixSourceMessageHelper v3RecordAddedMessage =
        new V3PixSourceMessageHelper(true, false, false, adapterCfg.senderApplicationOid,
            adapterCfg.senderFacilityOid, adapterCfg.receiverApplicationOid,
            adapterCfg.receiverFacilityOid);
    log.debug("add demographic data");
    addDemographicData(patient, v3RecordAddedMessage);
    try {
      printMessage("addPatient", v3RecordAddedMessage.getV3RecordAddedMessage().getRequest());
      V3PixSourceAcknowledgement v3pixack =
          pixSource.sendRecordAdded(v3RecordAddedMessage.getV3RecordAddedMessage());
      printMessage("sendRecordAdded", v3pixack.getRequest());
      return checkResponse(v3pixack);
    } catch (Exception e) {
      log.error("addPatient failed", e);
      return false;
    }
  }

  /**
   * Checks the response, error are logged.
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
    V3PixSourceMessageHelper v3RecordRevisedMessage =
        new V3PixSourceMessageHelper(false, true, false, adapterCfg.senderApplicationOid,
            adapterCfg.senderFacilityOid, adapterCfg.receiverApplicationOid,
            adapterCfg.receiverFacilityOid);
    addDemographicData(patient, v3RecordRevisedMessage);
    try {
      printMessage("sourceUpdate", v3RecordRevisedMessage.getV3RecordRevisedMessage().getRequest());
      V3PixSourceAcknowledgement v3pixack =
          pixSource.sendRecordRevised(v3RecordRevisedMessage.getV3RecordRevisedMessage());
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
   * @param patient the patient (with the surviving identifier)
   * @param obsoleteId the obsolete id (duplicate patient identifier)
   * @return true, if successful
   * @see org.ehealth_connector.communication.mpi.MpiAdapterInterface#mergePatient(org.ehealth_connector.
   *      communication.mpi.FhirPatient, java.lang.String)
   */
  public boolean mergePatient(FhirPatient patient, String obsoleteId) {

    if (!configure(true)) {
      return false;
    }

    V3PixSourceMessageHelper v3pixSourceMsgMerge =
        new V3PixSourceMessageHelper(false, false, true, adapterCfg.senderApplicationOid,
            adapterCfg.senderFacilityOid, adapterCfg.receiverApplicationOid,
            adapterCfg.receiverFacilityOid);
    addDemographicData(patient, v3pixSourceMsgMerge);

    v3pixSourceMsgMerge.getV3MergePatientsMessage().setObsoletePatientID(obsoleteId,
        this.homeCommunityOid, this.adapterCfg.homeCommunityNamespace);
    try {
      printMessage("sourceMerge", v3pixSourceMsgMerge.getV3MergePatientsMessage().getRequest());
      V3PixSourceAcknowledgement v3pixack =
          pixSource.sendMergePatients(v3pixSourceMsgMerge.getV3MergePatientsMessage());
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
   * query the mpi with patient id and return the ids in the queried domains from the mpi.
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
      if (adapterCfg.domainToReturnOid != null) {
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

      if (domainToReturnOids != null) {
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
        if (domainToReturnOids != null) {
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
   * Logs a debug message.
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
   * Adds the patient telecoms.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void addPatientTelecoms(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    // telecommunication addresses (only phone and email will be added to source)
    if (patient.getTelecom() != null && patient.getTelecom().size() > 0) {
      for (ContactPointDt contactPointDt : patient.getTelecom()) {
        // system I 0..1 code phone | fax | email | url
        // use M 0..1 code home | work | temp | old | mobile - purpose of this contact point
        String telecomValue = "";
        String useValue = "";
        if ("phone".equals(contactPointDt.getSystem())) {
          telecomValue = "tel:" + contactPointDt.getValue();
          if ("home".equals(contactPointDt.getUse())) {
            useValue = "H";
          }
          if ("work".equals(contactPointDt.getUse())) {
            useValue = "WP";
          }
          if ("mobile".equals(contactPointDt.getUse())) {
            useValue = "MC";
          }
        }
        if ("email".equals(contactPointDt.getSystem())) {
          telecomValue = "mailto:" + contactPointDt.getValue();
          if ("home".equals(contactPointDt.getUse())) {
            useValue = "H";
          }
          if ("work".equals(contactPointDt.getUse())) {
            useValue = "WP";
          }
        }
        v3PixSourceMessage.addPatientTelecom(telecomValue, useValue);
      }
    }
  }

  /**
   * Adds the patient addresses.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void addPatientAddresses(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    if (patient.getAddress().size() > 0) {
      for (AddressDt addressDt : patient.getAddress()) {

        String adressOtherDesignation = null;
        if (addressDt.getLine().size() > 1) {
          adressOtherDesignation = addressDt.getLine().get(1).getValueAsString();
        }
        String addressType = null;
        if (addressDt.getUseElement() != null && addressDt.getUseElement().getValueAsEnum() != null) {
          switch (addressDt.getUseElement().getValueAsEnum()) {
            case HOME:
              addressType = "H";
              break;
            case WORK:
              addressType = "WP";
              break;
            case TEMP:
              addressType = "TMP";
              break;
            case OLD:
              addressType = "OLD";
              break;
          }
        }
        v3PixSourceMessage.addPatientAddress(addressDt.getLineFirstRep().getValue(),
            addressDt.getCity(), null, addressDt.getState(), addressDt.getCountry(),
            addressDt.getPostalCode(), adressOtherDesignation, addressType);
      }
    }
  }

  /**
   * Sets the scoping organization.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void setScopingOrganization(FhirPatient patient,
      V3PixSourceMessageHelper v3PixSourceMessage) {
    // scoping organization set the scoping organization
    String organizationOid = "";
    String organizationName = "";
    String organizationTelecomValue = "";

    Organization organization = (Organization) patient.getManagingOrganization().getResource();

    if (organization != null && organization.getIdentifier().size() > 0) {
      IdentifierDt organizationId = organization.getIdentifier().get(0);
      if (organizationId.getSystem().startsWith("urn:oid:")) {
        organizationOid = organizationId.getSystem().substring(8);
      }
    }

    if (organization != null && organization.getName() != null) {
      organizationName = organization.getName();
    }

    if (organization != null && organization.getTelecom().size() > 0) {
      if (organization.getTelecom().size() > 0) {
        ContactPointDt contactPoint = organization.getTelecomFirstRep();
        if (contactPoint != null) {
          organizationTelecomValue = contactPoint.getValue();
        }
      }
    }

    v3PixSourceMessage.setScopingOrganization(organizationOid, organizationName,
        organizationTelecomValue);
  }

  /**
   * Sets the patient birth time.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void setPatientBirthTime(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    v3PixSourceMessage.setPatientBirthTime(patient.getBirthDateElement().getValueAsString()
        .replaceAll("-", ""));
  }

  /**
   * Sets the patient gender.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void setPatientGender(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
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
      v3PixSourceMessage.setPatientGender(gender);
    }
  }

  /**
   * Adds the patient ids.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void addPatientIds(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    for(IdentifierDt identifierDt : patient.getIdentifier()) {
      if (this.otherIdsOidSet.contains(identifierDt.getSystem())) {
          v3PixSourceMessage.addPatientOtherID(identifierDt.getValue(), identifierDt.getSystem().substring(8));
      } else {
        if (identifierDt.getSystem().length()>8 && (identifierDt.getSystem().startsWith("urn:oid:"))) {
          String oid = identifierDt.getSystem().substring(8);
          if (homeCommunityOid.equals(oid)) {
            v3PixSourceMessage.addPatientID(identifierDt.getValue(), homeCommunityOid,
                adapterCfg.homeCommunityNamespace);
          } else {
            v3PixSourceMessage.addPatientID(identifierDt.getValue(), oid,
                "");
          }
        }
      }
    }
  }

  /**
   * Adds the patient name.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void addPatientName(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    // Name
    String familyName = patient.getName().get(0).getFamilyAsSingleString();
    String givenName = patient.getName().get(0).getGivenAsSingleString();
    String otherName = ""; // other is resolved into given in addPatientName
    // below, we have that already with above lines
    String prefixName = patient.getName().get(0).getPrefixAsSingleString();
    String suffixName = patient.getName().get(0).getSuffixAsSingleString();
    v3PixSourceMessage.addPatientName(familyName, givenName, otherName, prefixName, suffixName);
  }

  /**
   * Adds the language communications. FHIR language code is based on
   * http://tools.ietf.org/html/bcp47, HL7V3 makes no requirements
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void addLanguageCommunications(FhirPatient patient,
      V3PixSourceMessageHelper v3PixSourceMessage) {
    if (patient.getCommunication().size() > 0) {
      for (CodeableConceptDt communication : patient.getCommunication()) {
        v3PixSourceMessage.addLanguageCommunication(communication.getText());
      }
    }
  }

  /**
   * Adds the marital status. TODO is the coding of marital status of fhir equivalent to HL7 V3?
   * http://hl7.org/implement/standards/FHIR-Develop/valueset-marital-status.html
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void setPatientMaritalStatus(FhirPatient patient,
      V3PixSourceMessageHelper v3PixSourceMessage) {
    if (!patient.getMaritalStatus().isEmpty()) {
      v3PixSourceMessage.setPatientMaritalStatus(patient.getMaritalStatus().getValueAsEnum()
          .toArray()[0].toString());
    }
  }

  /**
   * sets the deceased status, either boolean or by datetime.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  public void setDeceased(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    IDatatype idDeceased = patient.getDeceased();
    if (idDeceased instanceof DateTimeDt) {
      DateTimeDt deceased = (DateTimeDt) idDeceased;
      if (deceased.getValue() != null) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        v3PixSourceMessage.setPatientDeceasedTime(dateFormat.format(deceased.getValue()));
        v3PixSourceMessage.setPatientDeceased(true);
      }
    }
    if (idDeceased instanceof BooleanDt) {
      BooleanDt deceased = (BooleanDt) idDeceased;
      if (deceased.getValue() != null) {
        v3PixSourceMessage.setPatientDeceased(deceased.getValue());
      }
    }
  }

  /**
   * Set the patient Birth Order.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  public void setMultipeBirth(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    IDatatype iMultipleBirth = patient.getMultipleBirth();
    if (iMultipleBirth instanceof IntegerDt) {
      IntegerDt multipleBirth = (IntegerDt) iMultipleBirth;
      if (multipleBirth.getValue() != null) {
        v3PixSourceMessage.setMultipleBirthOrderNumber(multipleBirth.getValue());
        v3PixSourceMessage.setMultipleBirthIndicator(true);
      }
    }
    if (iMultipleBirth instanceof BooleanDt) {
      BooleanDt multipleBirth = (BooleanDt) iMultipleBirth;
      if (multipleBirth.getValue() != null) {
        v3PixSourceMessage.setMultipleBirthIndicator(multipleBirth.getValue());
      }
    }
  }

  /**
   * Sets the patients mother maiden name.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  public void setPatientMothersMaidenName(FhirPatient patient,
      V3PixSourceMessageHelper v3PixSourceMessage) {
    HumanNameDt maidenName = patient.getMothersMaidenName();
    if (maidenName.isEmpty()) {
      String familyName = maidenName.getFamilyAsSingleString();
      String givenName = maidenName.getGivenAsSingleString();
      String otherName = ""; // other is resolved into given in addPatientName
      String prefixName = maidenName.getPrefixAsSingleString();
      String suffixName = maidenName.getSuffixAsSingleString();
      v3PixSourceMessage.setPatientMothersMaidenName(familyName, givenName, otherName, suffixName,
          prefixName);
    }
  }

  /**
   * Sets the birthplace.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  public void setBirthPlace(FhirPatient patient, V3PixSourceMessageHelper v3PixSourceMessage) {
    if (patient.getBirthPlace() != null) {
      AddressDt addressDt = patient.getBirthPlace();
      String adressOtherDesignation = null;
      if (addressDt.getLine().size() > 1) {
        adressOtherDesignation = addressDt.getLine().get(1).getValueAsString();
      }
      AD patientAddress =
          PixPdqV3Utils.createAD(addressDt.getLineFirstRep().getValue(), addressDt.getCity(), null,
              addressDt.getState(), addressDt.getCountry(), addressDt.getPostalCode(),
              adressOtherDesignation, null);
      v3PixSourceMessage.setBirthPlace(patientAddress);
    }
  }

  /**
   * Sets the patient religious affiliation.
   * 
   * @param patient the patient
   * @param v3PixSourceMessage the v3 pix source message
   */
  private void setPatientReligiousAffiliation(FhirPatient patient,
      V3PixSourceMessageHelper v3PixSourceMessage) {
    if (patient.getReligiousAffiliation()!=null && !patient.getReligiousAffiliation().isEmpty()) {
      v3PixSourceMessage.setPatientReligiousAffiliation(patient.getReligiousAffiliation().getText());
    }
  }


  /**
   * add another oid identifiers for the person such as a Drivers’ license or Social Security
   * Number.
   * 
   * @param oid
   */
  public void addOtherIdsOid(String oid) {
    otherIdsOidSet.add("urn:oid:" + oid);
  }



}
