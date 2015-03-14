/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved.
 * http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the
 * Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the
 * Creative Commons Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Stack;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeDocumentRoot;
import org.ehealth_connector.cda.ch.CdaChVacd;
import org.ehealth_connector.cda.enums.AddressUse;
import org.ehealth_connector.common.ConvenienceUtilsEnums.Language;
import org.ehealth_connector.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.AssignedAuthor;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.LegalAuthenticator;
import org.openhealthtools.mdht.uml.cda.Performer2;
import org.openhealthtools.mdht.uml.cda.StrucDocText;
import org.openhealthtools.mdht.uml.hl7.datatypes.AD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.ENXP;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.ON;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * Hilfs-Methoden.
 */
public class Util {

  /**
   * The Constant TELECOMS_FAX_PREFIX.
   */
  public static final String TELECOMS_FAX_PREFIX = "fax:";

  /**
   * The Constant TELECOMS_EMAIL_PREFIX.
   */
  public static final String TELECOMS_EMAIL_PREFIX = "mailto:";

  /**
   * The Constant TELECOMS_PHONE_PREFIX.
   */
  public static final String TELECOMS_PHONE_PREFIX = "tel:";
  
  public static final String TELECOMS_WEBSIDE_PREFIX = "http";

  /**
   * Erzeugt eine Adresse.
   *
   * @param streetName Contains the StreetName
   * @param houseNumber Contains the house number
   * @param zip PLZ
   * @param city Ort
   * @param usage Verwendungszweck (Privat, GeschÃ¤ft)
   * @return the new address
   */
  public static AD createAddress(String streetName, String houseNumber, String zip, String city,
      UseCode usage) {
    final AD ad = createAddress(zip, city, usage);

    if (streetName != null) {
      ad.addStreetAddressLine(streetName);
    }
    if (houseNumber != null) {
      ad.addHouseNumber(houseNumber);
    }
    return ad;
  }

  /**
   * Erzeugt eine Adresse.
   *
   * @param zip PLZ
   * @param city Ort
   * @param usage Verwendungszweck (Privat, GeschÃ¤ft)
   * @return HL7 AD Objekt
   */
  public static AD createAddress(String zip, String city, UseCode usage) {
    final AD ad = DatatypesFactory.eINSTANCE.createAD();

    if (zip != null) {
      ad.addPostalCode(zip);
    }
    if (city != null) {
      ad.addCity(city);
    }
    if (usage != null) {
      // TODO add the real Use Code here
      // ad.getUses().add(usage);
    }
    return ad;
  }

  /**
   * Erzeugt eine Adresse.
   *
   * @param addressline <br>
   * 		<div class="de"> addressline</div>
   * 		<div class="fr"> addressline</div>
   * 		<div class="it"> addressline</div>
   * @param zip PLZ
   * @param city Ort
   * @param usage Verwendungszweck (Privat, GeschÃ¤ft)
   * @return the ad
   */
  public static AD createAdress(String addressline, String zip, String city, UseCode usage) {
    final AD ad = createAddress(zip, city, usage);

    if (addressline != null) {
      ad.addStreetAddressLine(addressline);
    }
    return ad;
  }

  /**
   * <div class="en">Creates the ce null flavor nask.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ce
   */
  public static CE createCENullFlavorNASK() {
    CE ce = DatatypesFactory.eINSTANCE.createCE();
    ce.setNullFlavor(NullFlavor.NASK);
    return ce;
  }

  /**
   * <div class="en">Creates the code null flavor.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the cd
   */
  public static CD createCodeNullFlavor() {
    CD code = DatatypesFactory.eINSTANCE.createCD();
    code.setNullFlavor(NullFlavor.NA);
    return code;
  }

  /**
   * Erzeugt aus einem MDHT Organization Objekt ein neues MDHT CustodianOrganization Objekt.
   *
   * @param organization Organisation
   * @return CustodianOrganization
   */
  public static CustodianOrganization createCustodianOrganizationFromOrganization(
      Organization organization) {
    // create and set the mdht RepresentedCustodianOrganization Object
    final CustodianOrganization mdhtCustOrg = CDAFactory.eINSTANCE.createCustodianOrganization();

    ON on = DatatypesFactory.eINSTANCE.createON();
    on.addText(organization.getName());
    mdhtCustOrg.setName(on);
    // take the first address and set it as CustodianAdress
    mdhtCustOrg.setAddr(organization.getMdhtOrganization().getAddrs().get(0));
    // take the first telecom and set it as CustodianTelecom
    mdhtCustOrg.setTelecom(organization.getMdhtOrganization().getTelecoms().get(0));
    // TODO handle any other adresses/telecoms
    return mdhtCustOrg;
  }

  /**
   * <div class="en">Creates the ed.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param text <br>
   * 		<div class="de"> text</div>
   * 		<div class="fr"> text</div>
   * 		<div class="it"> text</div>
   * @return the ed
   */
  public static ED createEd(String text) {
    ED ed = DatatypesFactory.eINSTANCE.createED();
    // ed.setReference(arg0);
    return (ed.addText(text));
  }

  /**
   * <div class="en">Creates the e mail.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param eMail <br>
   * 		<div class="de"> e mail</div>
   * 		<div class="fr"> e mail</div>
   * 		<div class="it"> e mail</div>
   * @param usage <br>
   * 		<div class="de"> usage</div>
   * 		<div class="fr"> usage</div>
   * 		<div class="it"> usage</div>
   * @return the tel
   */
  public static TEL createEMail(String eMail, AddressUse usage) {
    TEL tel = DatatypesFactory.eINSTANCE.createTEL();
    tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
    tel.setValue(TELECOMS_EMAIL_PREFIX + eMail);
    return tel;
  }

  /**
   * <div class="en">Creates the eur date str from ts.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param hl7Stimestamp <br>
   * 		<div class="de"> hl7 stimestamp</div>
   * 		<div class="fr"> hl7 stimestamp</div>
   * 		<div class="it"> hl7 stimestamp</div>
   * @return the string
   */
  public static String createEurDateStrFromTS(String hl7Stimestamp) {
    // TODO PrÃ¼fen, ob der Ã¼bergebene String das richtige Format hat.
    String eurDateStr =
        hl7Stimestamp.substring(6, 8) + "." + hl7Stimestamp.substring(4, 6) + "."
            + hl7Stimestamp.substring(0, 4);
    return eurDateStr;
  }

  /**
   * <div class="en">Creates the fax.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param faxNr <br>
   * 		<div class="de"> fax nr</div>
   * 		<div class="fr"> fax nr</div>
   * 		<div class="it"> fax nr</div>
   * @param usage <br>
   * 		<div class="de"> usage</div>
   * 		<div class="fr"> usage</div>
   * 		<div class="it"> usage</div>
   * @return the tel
   */
  public static TEL createFax(String faxNr, AddressUse usage) {
    TEL tel = DatatypesFactory.eINSTANCE.createTEL();
    tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
    tel.setValue(TELECOMS_FAX_PREFIX + faxNr);
    return tel;
  }

  public static II createIdentificator(Identificator id) {
    II ii;
    if (id==null) {
      ii = DatatypesFactory.eINSTANCE.createII();
      ii.setRoot(EHealthConnectorVersions.EHealthConnectorV1.getId());
      ii.setExtension(UUID.generate());
    }
    else {
      ii = id.getIi();
    }
    return ii;
  }

  /**
   * <div class="en">Creates the iv l_ pq null flavor na.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ivl pq
   */
  public static IVL_PQ createIVL_PQNullFlavorNA() {
    IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
    ivlpq.setNullFlavor(NullFlavor.NA);
    return ivlpq;
  }

  /**
   * <div class="en">Creates the iv l_ pq null flavor nask.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ivl pq
   */
  public static IVL_PQ createIVL_PQNullFlavorNASK() {
    IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
    ivlpq.setNullFlavor(NullFlavor.NASK);
    return ivlpq;
  }

  /**
   * Erezugt aus einem MDHT Author Objekt ein neues MDHT LegalAuthenticator Objekt.
   *
   * @param author <br>
   * 		<div class="de"> author</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @return the legal authenticator
   */
  public static LegalAuthenticator createLagalAuthenticatorFromAuthor(org.ehealth_connector.common.Author author) {
	  org.openhealthtools.mdht.uml.cda.Author a = author.copyMdhtAuthor();
    LegalAuthenticator mdhtLegAuth = CDAFactory.eINSTANCE.createLegalAuthenticator();
    mdhtLegAuth.setAssignedEntity(createAssignedEntityFromAssignedAuthor(a.getAssignedAuthor()));
    
    //Set signature Code to 's'
    CS cs = DatatypesFactory.eINSTANCE.createCS("S");
    mdhtLegAuth.setSignatureCode(cs);
    //Copy Time
    mdhtLegAuth.setTime(a.getTime());
    
    return mdhtLegAuth;
  }
  
  public static AssignedEntity createAssignedEntityFromAssignedAuthor(AssignedAuthor a) {
	  AssignedEntity asEnt = CDAFactory.eINSTANCE.createAssignedEntity();  
	  //Copy Addresses
	    if (a.getAddrs()!=null) {
	    	asEnt.getAddrs().addAll(a.getAddrs());
	    }
	    //Copy Ids
	    if (a.getIds() !=null) {
	    	asEnt.getIds().addAll(a.getIds());
	    }
	    //Copy Telecoms
	    if (a.getTelecoms() != null) {
	    	asEnt.getTelecoms().addAll(a.getTelecoms());
	    }
	    //Copy Represented Organization
	    if (a.getRepresentedOrganization()!=null) {
	    	asEnt.getRepresentedOrganizations().add(a.getRepresentedOrganization());
	    }
	    //Set Assigned Person
	    asEnt.setAssignedPerson(a.getAssignedPerson());
	    return asEnt;
  }

  /**
   * Erzeut ein LanguageCode Objekt.
   *
   * @param language Sprache
   * @return HL7 CS Objekt
   */
  public static CS createLanguageCode(Language language) {
    // TODO: Use Modeled code system
    // Set one of the language codes which are possible in Swiss
    final CS lang = DatatypesFactory.eINSTANCE.createCS();
    switch (language) {
      case German:
        lang.setCode("de-CH");
        break;
      case French:
        lang.setCode("fr-CH");
        break;
      case Italian:
        lang.setCode("it-CH");
    }
    return lang;
  }

  /**
   * <div class="en">Creates the name.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param name <br>
   * 		<div class="de"> name</div>
   * 		<div class="fr"> name</div>
   * 		<div class="it"> name</div>
   * @return the enxp
   */
  public static ENXP createName(String name) {
    ENXP mName = DatatypesFactory.eINSTANCE.createENXP();
    mName.addText(name);
    return mName;
  }

  /**
   * <div class="en">Creates the non qoted struc doc text.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param xmlString <br>
   * 		<div class="de"> xml string</div>
   * 		<div class="fr"> xml string</div>
   * 		<div class="it"> xml string</div>
   * @return the struc doc text
   */
  public static StrucDocText createNonQotedStrucDocText(String xmlString) {
    Resource.Factory factory = new GenericXMLResourceFactoryImpl();
    XMLResource resource = (XMLResource) factory.createResource(null);
    try {
      resource.load(new URIConverter.ReadableInputStream("<text>" + xmlString + "</text>"), null);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    XMLTypeDocumentRoot root = (XMLTypeDocumentRoot) resource.getContents().get(0);
    AnyType value = (AnyType) root.getMixed().getValue(0);
    StrucDocText text = CDAFactory.eINSTANCE.createStrucDocText();
    text.getMixed().addAll(value.getMixed());
    return text;
  }

  /**
   * <div class="en">Creates the null flavor unknown.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ivxb ts
   */
  public static IVXB_TS createNullFlavorUnknown() {
    IVXB_TS ts = DatatypesFactory.eINSTANCE.createIVXB_TS();
    ts.setNullFlavor(NullFlavor.UNK);
    return ts;
  }

  /**
   * <div class="en">Creates the problem entry text.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @return the ed
   */
  public static ED createProblemEntryText() {
    return DatatypesFactory.eINSTANCE.createED();
  }



  /**
   * <div class="en">Creates the reference.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param contentId <br>
   * 		<div class="de"> content id</div>
   * 		<div class="fr"> content id</div>
   * 		<div class="it"> content id</div>
   * @param prefix <br>
   * 		<div class="de"> prefix</div>
   * 		<div class="fr"> prefix</div>
   * 		<div class="it"> prefix</div>
   * @return the ed
   */
  public static ED createReference(int contentId, String prefix) {
    ED text = DatatypesFactory.eINSTANCE.createED();
    TEL tel = DatatypesFactory.eINSTANCE.createTEL();

    // Dirty BugFix for missing addReference method.
    // TODO Make me beautiful :)
    tel.setValue("#" + prefix + String.valueOf(contentId));
    text.setReference(tel);
    return text;
  }

  /**
   * <div class="en">Creates the tel.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param telNr <br>
   * 		<div class="de"> tel nr</div>
   * 		<div class="fr"> tel nr</div>
   * 		<div class="it"> tel nr</div>
   * @param usage <br>
   * 		<div class="de"> usage</div>
   * 		<div class="fr"> usage</div>
   * 		<div class="it"> usage</div>
   * @return the tel
   */
  public static TEL createTel(String telNr, AddressUse usage) {
    TEL tel = DatatypesFactory.eINSTANCE.createTEL();
    if (usage!=null) {
      tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
    }
    tel.setValue(TELECOMS_PHONE_PREFIX + telNr);
    return tel;
  }

  /**
   * <div class="en">Creates the uuid vacd.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param id <br>
   * 		<div class="de"> id</div>
   * 		<div class="fr"> id</div>
   * 		<div class="it"> id</div>
   * @return the ii
   */
  public static II createUuidVacd(String id) {
    II ii = DatatypesFactory.eINSTANCE.createII();
    ii.setRoot(CdaChVacd.OID_VACD);
    if (id==null) {
      ii.setExtension(UUID.generate());
    }
    else {
      ii.setRoot(id);
    }
    return ii;
  }

  /**
   * <div class="en">Creates the uuid vacd identificator.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param id <br>
   * 		<div class="de"> id</div>
   * 		<div class="fr"> id</div>
   * 		<div class="it"> id</div>
   * @return the ii
   */
  public static II createUuidVacdIdentificator(Identificator id) {
    II ii;
    if (id == null){
      ii = Util.createUuidVacd(null);
    }
    else {
      ii = id.getIi();
    }
    return ii;
  }

  /**
   * <div class="en">Extract string from non quoted struc doc text.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param strucDocText <br>
   * 		<div class="de"> struc doc text</div>
   * 		<div class="fr"> struc doc text</div>
   * 		<div class="it"> struc doc text</div>
   * @return the string
   */
  public static String extractStringFromNonQuotedStrucDocText(StrucDocText strucDocText) {
    StringBuilder sb = new StringBuilder();
    if (strucDocText != null) {
      sb = traverse2(strucDocText.getMixed(), sb);
    }
    return sb.toString();
  }

  /**
   * <div class="en">Find ii.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param iis <br>
   * 		<div class="de"> iis</div>
   * 		<div class="fr"> iis</div>
   * 		<div class="it"> iis</div>
   * @param ii <br>
   * 		<div class="de"> ii</div>
   * 		<div class="fr"> ii</div>
   * 		<div class="it"> ii</div>
   * @return the ii
   */
  public static II findII(EList<II> iis, II ii) {
    for (II curII: iis) {
      if (curII.getRoot().equals(ii.getRoot())) {
        if (ii.getExtension() == null || curII.getExtension().equals(ii.getExtension())) {
          return curII;
        }
      }
    }
    return null;
  }



  /**
   * Erzeugt eine Dokumenten ID mit Hilfe einer applicationOidRoot.
   *
   * @param appliactionOidRoot identifiziert diese Version des eHCs
   * @return HL7 II Objekt
   */
  public static II generateDocId(String appliactionOidRoot) {
    // Unique identifier of the document. The root part identifies the
    // application instance, the extension part identifies the document
    // instance.

    final String documentOid =
        org.openhealthtools.ihe.utils.OID.createOIDGivenRoot("ehealthconnctor");
    // Creates a random extension ID to identify the document
    final Random r = new Random();
    final II id = DatatypesFactory.eINSTANCE.createII(documentOid, String.valueOf(r.nextInt()));
    return id;
  }

  /**
   * <div class="en">Gets the e mail.</div>
   * <div class="de">Liefert e mail.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param telecoms <br>
   * 		<div class="de"> telecoms</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @return <div class="en">the e mail</div>
   */
  public static HashMap<String, AddressUse> getEMail(ArrayList<TEL> telecoms) {
    return getTelecomType(telecoms, TELECOMS_EMAIL_PREFIX);
  }



  /**
   * <div class="en">Gets the fax.</div>
   * <div class="de">Liefert fax.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param telecoms <br>
   * 		<div class="de"> telecoms</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @return <div class="en">the fax</div>
   */
  public static HashMap<String, AddressUse> getFax(ArrayList<TEL> telecoms) {
    return getTelecomType(telecoms, TELECOMS_FAX_PREFIX);
  }



  /**
   * <div class="en">Gets the phone.</div>
   * <div class="de">Liefert phone.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param telecoms <br>
   * 		<div class="de"> telecoms</div>
   * 		<div class="fr"></div>
   * 		<div class="it"></div>
   * @return <div class="en">the phone</div>
   */
  public static HashMap<String, AddressUse> getPhones(ArrayList<TEL> telecoms) {
    return getTelecomType(telecoms, TELECOMS_PHONE_PREFIX);
  }
  
  /**
   * <div class="en">Gets the Webside</div>
   * <div class="de">Liefert Webside.</div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param telecoms <br>
   *        <div class="de"> telecoms</div>
   *        <div class="fr"></div>
   *        <div class="it"></div>
   * @return <div class="en">the webside</div>
   */
  public static HashMap<String, AddressUse> getWebsites(ArrayList<TEL> telecoms) {
    return getTelecomType(telecoms, TELECOMS_WEBSIDE_PREFIX);
  }

  private static HashMap<String, AddressUse> getTelecomType(ArrayList<TEL> telecoms, String type) {
    HashMap<String, AddressUse> tl = new HashMap<String, AddressUse>();
    for (TEL tel : telecoms) {
      if (tel.getValue().toLowerCase().contains(type)) {
        tl.put(tel.getValue(), (tel.getUses().size()>0 ? AddressUse.getEnum(tel.getUses().get(0).getName()) : null));
      }
    }
    return tl;
  }

  private static String getText(FeatureMap featureMap) {
    StringBuffer buffer = new StringBuffer("");
    for (FeatureMap.Entry entry : featureMap) {
      if (FeatureMapUtil.isText(entry)) {
        buffer.append(entry.getValue().toString());
      } else {
        if (entry.getEStructuralFeature() instanceof EReference) {
          buffer.append("<" + entry.getEStructuralFeature().getName() + ">");
        }
        // AnyType anyValue = (AnyType)entry.getValue();
        // buffer.append(getText(anyValue.getMixed()));
      }
    }
    return buffer.toString().trim();
  }

  /**
   * <div class="en">Ii.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param root <br>
   * 		<div class="de"> root</div>
   * 		<div class="fr"> root</div>
   * 		<div class="it"> root</div>
   * @return the ii
   */
  public static II ii(String root) {
    II ii = DatatypesFactory.eINSTANCE.createII();
    ii.setRoot(root);
    return ii;
  }

  /**
   * <div class="en">Ii.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param root <br>
   * 		<div class="de"> root</div>
   * 		<div class="fr"> root</div>
   * 		<div class="it"> root</div>
   * @param extension <br>
   * 		<div class="de"> extension</div>
   * 		<div class="fr"> extension</div>
   * 		<div class="it"> extension</div>
   * @return the ii
   */
  public static II ii(String root, String extension) {
    II ii = ii(root);
    ii.setExtension(extension);
    return ii;
  }

  /**
   * <div class="en">Join.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param nameList <br>
   * 		<div class="de"> name list</div>
   * 		<div class="fr"> name list</div>
   * 		<div class="it"> name list</div>
   * @param delimiter <br>
   * 		<div class="de"> delimiter</div>
   * 		<div class="fr"> delimiter</div>
   * 		<div class="it"> delimiter</div>
   * @return the string
   */
  public static String join(ArrayList<String> nameList, String delimiter) {
    String string;
    StringBuilder builder;

    if (nameList == null || nameList.isEmpty()) return "";
    Iterator<String> iter = nameList.iterator();
    string = iter.next();
    if (string.equals("")) {
      builder = new StringBuilder(iter.next());
    }
    else {
      builder = new StringBuilder(iter.next());
    }
    while( iter.hasNext() )
    {
      string = iter.next();
      if (string.equals("")) {
      }
      else {
        builder.append(delimiter).append(string);
      }
    }
    return builder.toString();
  }

  /**
   * <div class="en">Join e list str.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param list <br>
   * 		<div class="de"> list</div>
   * 		<div class="fr"> list</div>
   * 		<div class="it"> list</div>
   * @return the string
   */
  public static String joinEListStr(EList<ENXP> list) {
    if (list.size()==0) {
      return "";
    }
    String names = list.get(0).getText();
    if (list.size()>1) {
      ArrayList<String> nameList = new ArrayList<String>();
      for (int i = 0; i<list.size();i++) {
        nameList.add(list.get(i).getText());
      }
      return Util.join(nameList, " ");
    }
    return names;
  }

  /**
   * <div class="en">St.</div>
   * <div class="de"></div>
   * <div class="fr"></div>
   * <div class="it"></div>
   *
   * @param text <br>
   * 		<div class="de"> text</div>
   * 		<div class="fr"> text</div>
   * 		<div class="it"> text</div>
   * @return the st
   */
  public static ST st(String text) {
    ST value = DatatypesFactory.eINSTANCE.createST();
    value.addText(text);
    return value;
  }

  private static void traverse(FeatureMap root) {
    Stack<FeatureMap> stack = new Stack<FeatureMap>();
    Stack<String> stack2 = new Stack<String>();
    stack.push(root);
    while (!stack.isEmpty()) {
      FeatureMap featureMap = stack.pop();
      for (int i = featureMap.size() - 1; i >= 0; i--) {
        Entry entry = featureMap.get(i);
        if (entry.getEStructuralFeature() instanceof EReference) {
          System.out.print("<" + entry.getEStructuralFeature().getName());
          AnyType anyType = (AnyType) entry.getValue();
          traverseAttributes(anyType.getAnyAttribute());
          System.out.print(">");
          stack.push(anyType.getMixed());

        } else {
          // if (entry.getValue() != null && !stack2.isEmpty()) {
          // System.out.print("</"+stack2.pop()+">");}
          // //Text between the Elements
          if (entry.getValue() != null) {
            String value = entry.getValue().toString();
            if (value.trim().length() > 0) {
              System.out.print(value);
            }
          } else {
            System.out.println(" }");
          }
        }
        if (entry.getValue() != null && !stack2.isEmpty()) {
          System.out.print("</" + stack2.pop() + ">");
        }
      }
    }
  }

  private static StringBuilder traverse2(FeatureMap featureMap, StringBuilder sb) {
    for (int i = 0; i <= featureMap.size() - 1; i++) {
      // for (int i = featureMap.size() - 1; i >= 0; i--) {
      Entry entry = featureMap.get(i);
      if (entry.getEStructuralFeature() instanceof EReference) {
        sb.append("<" + entry.getEStructuralFeature().getName());
        AnyType anyType = (AnyType) entry.getValue();
        sb = traverseAttributes2(anyType.getAnyAttribute(), sb);
        sb.append(">");
        traverse2(anyType.getMixed(), sb);
        sb.append("</" + entry.getEStructuralFeature().getName() + ">");
      } else {
        // //Text between the Elements
        if (entry.getValue() != null) {
          String value = entry.getValue().toString();
          if (value.trim().length() > 0) {
            sb.append(value);
          }
        } else {
          System.out.println(" }");
        }
      }
    }
    return sb;
  }

  private static void traverseAttributes(FeatureMap anyAttribute) {
    for (Entry entry : anyAttribute) {
      System.out.print(" " + entry.getEStructuralFeature().getName() + "=\""
          + entry.getValue().toString() + "\"");
    }
  }

  private static StringBuilder traverseAttributes2(FeatureMap anyAttribute, StringBuilder sb) {
    for (Entry entry : anyAttribute) {
      sb.append(" " + entry.getEStructuralFeature().getName() + "=\"" + entry.getValue().toString()
          + "\"");
    }
    return sb;
  }

  /**
   * Erzeugt eine Adresse.
   *
   * @param addressline1 Adresszeile 1
   * @param addressline2 Adresszeile 2
   * @param addressline3 Adresszeile 3
   * @param zip PLZ
   * @param city Ort
   * @param usage Verwendungszweck (Privat, GeschÃ¤ft)
   * @return HL7 AD Objekt
   */
  public AD createAddress(String addressline1, String addressline2, String addressline3,
      String zip, String city, UseCode usage) {
    final AD ad = createAddress(zip, city, usage);

    if (addressline1 != null) {
      ad.addStreetAddressLine(addressline1);
    }
    if (addressline2 != null) {
      ad.addStreetAddressLine(addressline2);
    }
    if (addressline3 != null) {
      ad.addStreetAddressLine(addressline3);
    }
    return ad;
  }
}
