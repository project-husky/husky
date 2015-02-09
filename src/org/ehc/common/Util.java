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
 * Attribution-ShareAlike 3.0 Switzerland License.
 *
 * Year of publication: 2014
 *
 *******************************************************************************/

package org.ehc.common;

import java.io.IOException;
import java.util.ArrayList;
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
import org.ehc.cda.ch.CdaChVacd;
import org.ehc.cda.ch.enums.AddressUse;
import org.ehc.common.ConvenienceUtilsEnums.Language;
import org.ehc.common.ConvenienceUtilsEnums.UseCode;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.LegalAuthenticator;
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
import org.openhealthtools.mdht.uml.hl7.vocab.TelecommunicationAddressUse;

/**
 * Hilfs-Methoden
 * 
 */
public class Util {
	
	public static final String TELECOMS_FAX_PREFIX = "fax:";
	public static final String TELECOMS_EMAIL_PREFIX = "mailto:";
	public static final String TELECOMS_PHONE_PREFIX = "tel:";

	public static TEL createFax(String faxNr, AddressUse usage) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		tel.setValue(TELECOMS_FAX_PREFIX + faxNr);
		return tel;
	}
	
	public static ArrayList<String> getFax(ArrayList<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_FAX_PREFIX);
	}
	
	public static ArrayList<String> getEMail(ArrayList<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_EMAIL_PREFIX);
	}
	
	public static ArrayList<String> getPhone(ArrayList<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_PHONE_PREFIX);
	}
	
	private static ArrayList<String> getTelecomType(ArrayList<TEL> telecoms, String type) {
		ArrayList<String> tl = new ArrayList<String>();
		for (TEL tel : telecoms) {
			if (tel.getValue().contains(type)) {
				tl.add(tel.getValue());
			}
		}
		return tl;
	}
	
	public static TEL createEMail(String eMail, AddressUse usage) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		tel.setValue(TELECOMS_EMAIL_PREFIX + eMail);
		return tel;
	}
	
	public static TEL createTel(String telNr, AddressUse usage) {
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		tel.setValue(TELECOMS_PHONE_PREFIX + telNr);
		return tel;
	}
	
	public static String joinEListStr(EList<ENXP> list) {
		if (list.size()==0) {
			return null;
		}
		String names = list.get(0).getText();
		if (list.size()>1) {
			for (int i = 2; i<= list.size();i++) {
				names = String.join(" ", names, list.get(i).getText());
			}
		}
		return names;
	}
	
	/**
	 * Erzeugt eine Adresse
	 * 
	 * @param streetName Contains the StreetName
	 * @param houseNumber Contains the house number
	 * @param zip PLZ
	 * @param city Ort
	 * @param usage Verwendungszweck (Privat, Geschäft)
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
	 * Erzeugt eine Adresse
	 * 
	 * @param zip PLZ
	 * @param city Ort
	 * @param usage Verwendungszweck (Privat, Geschäft)
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
	 * Erzeugt eine Adresse
	 * 
	 * @param addressline
	 * @param zip PLZ
	 * @param city Ort
	 * @param usage Verwendungszweck (Privat, Geschäft)
	 */
	public static AD createAdress(String addressline, String zip, String city, UseCode usage) {
		final AD ad = createAddress(zip, city, usage);

		if (addressline != null) {
			ad.addStreetAddressLine(addressline);
		}
		return ad;
	}

	public static CE createCENullFlavorNASK() {
		CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NASK);
		return ce;
	}

	public static CD createCodeNullFlavor() {
		CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setNullFlavor(NullFlavor.NA);
		return code;
	}

	/**
	 * Erzeugt aus einem MDHT Organization Objekt ein neues MDHT CustodianOrganization Objekt
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

	public static ED createEd(String text) {
		ED ed = DatatypesFactory.eINSTANCE.createED();
		// ed.setReference(arg0);
		return (ed.addText(text));
	}

	public static String createEurDateStrFromTS(String hl7Stimestamp) {
		// TODO Prüfen, ob der übergebene String das richtige Format hat.
		String eurDateStr =
				hl7Stimestamp.substring(6, 8) + "." + hl7Stimestamp.substring(4, 6) + "."
						+ hl7Stimestamp.substring(0, 4);
		return eurDateStr;
	}

	public static IVL_PQ createIVL_PQNullFlavorNASK() {
		IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivlpq.setNullFlavor(NullFlavor.NASK);
		return ivlpq;
	}



	/**
	 * Erezugt aus einem MDHT Author Objekt ein neues MDHT LegalAuthenticator Objekt
	 * 
	 * @param author
	 */
	public static LegalAuthenticator createLagalAuthenticatorFromAuthor(org.ehc.common.Author author) {
		// FIXME Copy the values from the author object, without drawing / move
		// them from it.

		// create and set the mdht RepresentedCustodianOrganization Object
		LegalAuthenticator mdhtLegAuth = CDAFactory.eINSTANCE.createLegalAuthenticator();
		AssignedEntity asEnt = CDAFactory.eINSTANCE.createAssignedEntity();
		mdhtLegAuth.setAssignedEntity(asEnt);

		org.openhealthtools.mdht.uml.cda.Person authorPerson = CDAFactory.eINSTANCE.createPerson();
		asEnt.setAssignedPerson(authorPerson);

		authorPerson = author.getAuthorMdht().getAssignedAuthor().getAssignedPerson();

		return mdhtLegAuth;
	}

	/**
	 * Erzeut ein LanguageCode Objekt
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

	public static ENXP createName(String name) {
		ENXP mName = DatatypesFactory.eINSTANCE.createENXP();
		mName.addText(name);
		return mName;
	}

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

	public static IVXB_TS createNullFlavorUnknown() {
		IVXB_TS ts = DatatypesFactory.eINSTANCE.createIVXB_TS();
		ts.setNullFlavor(NullFlavor.UNK);
		return ts;
	}



	public static ED createProblemEntryText() {
		return DatatypesFactory.eINSTANCE.createED();
	}

	public static ED createReference(int contentId, String prefix) {
		ED text = DatatypesFactory.eINSTANCE.createED();
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();

		// Dirty BugFix for missing addReference method.
		// TODO Make me beautiful :)
		tel.setValue("#" + prefix + String.valueOf(contentId));
		text.setReference(tel);
		return text;
	}



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



	public static String extractStringFromNonQuotedStrucDocText(StrucDocText strucDocText) {
		StringBuilder sb = new StringBuilder();
		if (strucDocText != null) {
			sb = traverse2(strucDocText.getMixed(), sb);
		}
		return sb.toString();
	}

	/**
	 * Erzeugt eine Dokumenten ID mit Hilfe einer applicationOidRoot
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

	public static II ii(String root) {
		II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(root);
		return ii;
	}

	public static II ii(String root, String extension) {
		II ii = ii(root);
		ii.setExtension(extension);
		return ii;
	}

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
	 * Erzeugt eine Adresse
	 * 
	 * @param addressline1 Adresszeile 1
	 * @param addressline2 Adresszeile 2
	 * @param addressline3 Adresszeile 3
	 * @param zip PLZ
	 * @param city Ort
	 * @param usage Verwendungszweck (Privat, Geschäft)
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


}
