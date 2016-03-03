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
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xml.type.AnyType;
import org.eclipse.emf.ecore.xml.type.XMLTypeDocumentRoot;
import org.ehealth_connector.common.EHealthConnectorVersions;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Participant;
import org.ehealth_connector.common.ParticipantRole;
import org.ehealth_connector.common.PlayingEntity;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.Signature;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.AssignedAuthor;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
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
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;

/**
 * Helper methods for the eHealth Connector and CDA
 */
public class Util {

	/**
	 * The Constant TELECOMS_EMAIL_PREFIX.
	 */
	public static final String TELECOMS_EMAIL_PREFIX = "mailto:";

	/**
	 * The Constant TELECOMS_FAX_PREFIX.
	 */
	public static final String TELECOMS_FAX_PREFIX = "fax:";

	/**
	 * The Constant TELECOMS_PHONE_PREFIX.
	 */
	public static final String TELECOMS_PHONE_PREFIX = "tel:";

	/**
	 * The Constant TELECOMS_WEBSITE_PREFIX. Note: omitting the : here in order to
	 * support http and https
	 */
	public static final String TELECOMS_WEBSITE_PREFIX = "http";

	// /**
	// * Adds the copy of a given section to a given structured body
	// *
	// * @param sb
	// * the StructuredBody
	// * @param s
	// * the Section
	// */
	// public static void addSectionToStructuredBodyAsCopy(StructuredBody sb,
	// Section s) {
	// if ((sb != null) && (s != null)) {
	// final Component3 c = CDAFactory.eINSTANCE.createComponent3();
	// c.setSection(EcoreUtil.copy(s));
	// sb.getComponents().add(c);
	// }
	// }

	/**
	 * Checks to see if the list has at least one element.
	 *
	 * @param l
	 *          the list
	 * @return false if l is null, if l.size() smaller 1 or if l.get(0) is null.
	 *         Otherwise, return true.
	 */
	@SuppressWarnings("rawtypes")
	public static boolean atLeastOne(List l) {
		if ((l == null) || (l.size() < 1) || (l.get(0) == null)) {
			return false;
		}
		return true;
	}

	/**
	 * <div class="en"> Converts a list of II int a list of Identificators
	 *
	 * @param mII
	 *          the list to convert
	 * @return </div> <div class="de"></div> <div class="fr"></div>
	 */
	public static ArrayList<Identificator> convertIds(EList<II> mII) {
		final ArrayList<Identificator> il = new ArrayList<Identificator>();
		for (final II mId : mII) {
			final Identificator id = new Identificator(mId);
			il.add(id);
		}
		return il;
	}

	/**
	 * Creates an address
	 *
	 * @param zip
	 *          ZIP code
	 * @param city
	 *          the city
	 * @param usage
	 *          usage of this address
	 * @return HL7 AD Object
	 */
	public static AD createAddress(String zip, String city, AddressUse usage) {
		final AD ad = DatatypesFactory.eINSTANCE.createAD();

		if (zip != null) {
			ad.addPostalCode(zip);
		}
		if (city != null) {
			ad.addCity(city);
		}
		if (usage != null) {
			ad.getUses().add(usage.getAddressUseAsPostalAddressUse());
		}
		return ad;
	}

	/**
	 * Creates an MDHT assignedEntity object from an MDHT AssignedAuthor object
	 *
	 * @param a
	 *          the assignedAuthor
	 * @return the assignedEntity
	 */
	public static AssignedEntity createAssignedEntityFromAssignedAuthor(AssignedAuthor a) {
		final AssignedEntity asEnt = CDAFactory.eINSTANCE.createAssignedEntity();
		// Copy Addresses
		if (a.getAddrs() != null) {
			asEnt.getAddrs().addAll(a.getAddrs());
		}
		// Copy Ids
		if (a.getIds() != null) {
			asEnt.getIds().addAll(a.getIds());
		}
		// Copy Telecoms
		if (a.getTelecoms() != null) {
			asEnt.getTelecoms().addAll(a.getTelecoms());
		}
		// Copy Represented Organization
		if (a.getRepresentedOrganization() != null) {
			asEnt.getRepresentedOrganizations().add(a.getRepresentedOrganization());
		}
		// Set Assigned Person
		asEnt.setAssignedPerson(a.getAssignedPerson());
		return asEnt;
	}

	public static AssignedAuthor createAuthorFromOrganization(Organization organization) {
		org.openhealthtools.mdht.uml.cda.Organization o = organization.getMdhtOrganization();
		AssignedAuthor a = CDAFactory.eINSTANCE.createAssignedAuthor();
		if (!o.getAddrs().isEmpty()) {
			a.getAddrs().addAll(EcoreUtil.copyAll(o.getAddrs()));
		}
		if (!o.getTelecoms().isEmpty()) {
			a.getTelecoms().addAll(EcoreUtil.copyAll(o.getTelecoms()));
		}
		if (!o.getIds().isEmpty()) {
			a.getIds().addAll(EcoreUtil.copyAll(o.getIds()));
		}
		return a;
	}

	/**
	 * <div class="en">Creates the MDHT CE null flavor NASK.</div>
	 *
	 * @return the CE
	 */
	public static CE createCENullFlavorNASK() {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NASK);
		return ce;
	}

	/**
	 * <div class="en">Creates the MDHT CE null flavor UNK.</div>
	 *
	 * @return the CE
	 */
	public static CE createCENullFlavorUNK() {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.UNK);
		return ce;
	}

	/**
	 * <div class="en">Creates the MDHT CD null flavor NA.</div>
	 *
	 * @return the CD
	 */
	public static CD createCodeNullFlavorNA() {
		final CD code = DatatypesFactory.eINSTANCE.createCD();
		code.setNullFlavor(NullFlavor.NA);
		return code;
	}

	/**
	 * Creates a new MDHT CustodianOrganization object from an eHC Organization
	 * object
	 *
	 * @param organization
	 *          the Organization
	 * @return CustodianOrganization the CustodianOrganization
	 */
	public static CustodianOrganization createCustodianOrganizationFromOrganization(
			Organization organization) {
		// create and set the mdht RepresentedCustodianOrganization Object
		if (organization != null) {
			final CustodianOrganization mdhtCustOrg = CDAFactory.eINSTANCE.createCustodianOrganization();

			final ON on = DatatypesFactory.eINSTANCE.createON();
			on.addText(organization.getName());
			mdhtCustOrg.setName(on);

			// take the first address and set it as CustodianAdress
			if (organization.getMdhtOrganization().getAddrs().size() > 0) {
				mdhtCustOrg.setAddr(EcoreUtil.copy(organization.getMdhtOrganization().getAddrs().get(0)));
			}

			// take the first telecom and set it as CustodianTelecom
			if (organization.getMdhtOrganization().getTelecoms().size() > 0) {
				mdhtCustOrg
						.setTelecom(EcoreUtil.copy(organization.getMdhtOrganization().getTelecoms().get(0)));
			}
			return mdhtCustOrg;
		}
		return null;
	}

	/**
	 * <div class="en">Creates the ED.</div>
	 *
	 * @param text
	 *          <br>
	 *          <div class="en">text</div>
	 * @return the ED
	 */
	public static ED createEd(String text) {
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		return (ed.addText(text));
	}

	/**
	 * <div class="en">Creates the MDHT email TEL object.</div>
	 *
	 * @param eMail
	 *          <br>
	 *          <div class="en"> e mail</div>
	 * @param usage
	 *          <br>
	 *          <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createEMail(String eMail, AddressUse usage) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		tel.setValue(TELECOMS_EMAIL_PREFIX + eMail);
		return tel;
	}

	/**
	 * <div class="en">Creates the eur date str from ts.</div>
	 *
	 * @param hl7Stimestamp
	 *          <br>
	 *          <div class="en"> hl7 stimestamp</div><div class="de"></div>
	 *          <div class="fr"> </div> <div class="it"></div>
	 * @return the string
	 */
	public static String createEurDateStrFromTS(String hl7Stimestamp) {
		final String eurDateStr = hl7Stimestamp.substring(6, 8) + "." + hl7Stimestamp.substring(4, 6)
				+ "." + hl7Stimestamp.substring(0, 4);
		return eurDateStr;
	}

	/**
	 * <div class="en">Creates the MDHT fax TEL object.</div>
	 *
	 * @param faxNr
	 *          <br>
	 *          <div class="en"> fax nr</div>
	 * @param usage
	 *          <br>
	 *          <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createFax(String faxNr, AddressUse usage) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		tel.setValue(TELECOMS_FAX_PREFIX + faxNr);
		return tel;
	}

	/**
	 * Creates an MDHT II object with the eHealthConnector root OID from an eHC
	 * Identificator object
	 *
	 * @param id
	 *          the Identificator
	 * @return the MDHT II
	 */
	public static II createIdentificator(Identificator id) {
		II ii;
		if (id == null) {
			ii = DatatypesFactory.eINSTANCE.createII();
			ii.setRoot(EHealthConnectorVersions.EHealthConnectorDev.oid());
			ii.setExtension(UUID.generate());
		} else {
			ii = id.getIi();
		}
		return ii;
	}

	/**
	 * <div class="en">Creates the MDHT IVL_PQ null flavor NA object.</div>
	 *
	 * @return the IVL_PQ
	 */
	public static IVL_PQ createIVL_PQNullFlavorNA() {
		final IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivlpq.setNullFlavor(NullFlavor.NA);
		return ivlpq;
	}

	/**
	 * <div class="en">Creates the IVL_PQ null flavor NASK object.</div>
	 *
	 * @return the IVL_PQ
	 */
	public static IVL_PQ createIVL_PQNullFlavorNASK() {
		final IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivlpq.setNullFlavor(NullFlavor.NASK);
		return ivlpq;
	}

	/**
	 * <div class="en">Creates the IVL_PQ null flavor UNK object.</div>
	 *
	 * @return the IVL_PQ
	 */
	public static IVL_PQ createIVL_PQNullFlavorUNK() {
		final IVL_PQ ivlpq = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivlpq.setNullFlavor(NullFlavor.UNK);
		return ivlpq;
	}

	/**
	 * Creates a new MDHT LegalAuthor object from an MDHT Author object. Signature
	 * Code will be set to fixed 's'
	 *
	 * @param author
	 *          <br>
	 *          <div class="de">the author</div>
	 * @return the legal authenticator
	 */
	public static LegalAuthenticator createLagalAuthenticatorFromAuthor(
			org.ehealth_connector.common.Author author) {
		final org.openhealthtools.mdht.uml.cda.Author a = author.copyMdhtAuthor();
		final LegalAuthenticator mdhtLegAuth = CDAFactory.eINSTANCE.createLegalAuthenticator();
		mdhtLegAuth.setAssignedEntity(createAssignedEntityFromAssignedAuthor(a.getAssignedAuthor()));

		// Set signature Code to 's'
		final CS cs = Signature.SIGNED.getCS();
		mdhtLegAuth.setSignatureCode(cs);
		// Copy Time
		mdhtLegAuth.setTime(a.getTime());

		return mdhtLegAuth;
	}

	/**
	 * <div class="en">Creates the non quoted MDHT StrucDocText.</div>
	 *
	 * @param xmlString
	 *          <br>
	 *          <div class="de"> xml string</div>
	 * @return the StrucDocText
	 */
	public static StrucDocText createNonQotedStrucDocText(String xmlString) {
		final Resource.Factory factory = new GenericXMLResourceFactoryImpl();
		final XMLResource resource = (XMLResource) factory.createResource(null);
		try {
			resource.load(new URIConverter.ReadableInputStream("<text>" + xmlString + "</text>"), null);
		} catch (final IOException e) {
			e.printStackTrace();
		}
		final XMLTypeDocumentRoot root = (XMLTypeDocumentRoot) resource.getContents().get(0);
		final AnyType value = (AnyType) root.getMixed().getValue(0);
		final StrucDocText text = CDAFactory.eINSTANCE.createStrucDocText();
		text.getMixed().addAll(value.getMixed());
		return text;
	}

	/**
	 * <div class="en">Creates the MDHT IVXB_TS null flavor UNK.</div>
	 *
	 * @return the ivxb ts
	 */
	public static IVXB_TS createNullFlavorUnknown() {
		final IVXB_TS ts = DatatypesFactory.eINSTANCE.createIVXB_TS();
		ts.setNullFlavor(NullFlavor.UNK);
		return ts;
	}

	private static ON createOnFromPn(PN pn) {
		ON on = DatatypesFactory.eINSTANCE.createON();
		on.addText(pn.getText());
		return on;
	}

	public static Organization createOrganizationFromParticipant(Participant p) {
		Organization o = new Organization();

		// id, addrs, names, telecoms
		o.getMdhtOrganization().getIds()
				.addAll(EcoreUtil.copyAll(p.getMdht().getParticipantRole().getIds()));
		o.getMdhtOrganization().getAddrs()
				.addAll(EcoreUtil.copyAll(p.getMdht().getParticipantRole().getAddrs()));
		if (p.getMdht().getParticipantRole().getPlayingEntity().getNames() != null
				&& !p.getMdht().getParticipantRole().getPlayingEntity().getNames().isEmpty()) {
			o.getMdhtOrganization().getNames().add(EcoreUtil.copy(
					createOnFromPn(p.getMdht().getParticipantRole().getPlayingEntity().getNames().get(0))));
		}
		o.getMdhtOrganization().getTelecoms().addAll(p.getMdht().getParticipantRole().getTelecoms());

		return o;
	}

	public static Participant createParticipantFromOrganization(Organization o) {
		PlayingEntity pe = new PlayingEntity();
		ParticipantRole pr = new ParticipantRole();
		pr.setPlayingEntity(pe);
		Participant p = new Participant();
		p.setParticipantRole(pr);

		// id, addrs, names, telecoms
		p.getMdht().getParticipantRole().getIds()
				.addAll(EcoreUtil.copyAll(o.getMdhtOrganization().getIds()));
		p.getMdht().getParticipantRole().getAddrs()
				.addAll(EcoreUtil.copyAll(o.getMdhtOrganization().getAddrs()));
		if (o.getMdhtOrganization().getNames() != null
				&& !o.getMdhtOrganization().getNames().isEmpty()) {
			p.getMdht().getParticipantRole().getPlayingEntity().getNames()
					.add(EcoreUtil.copy(createPnFromOn(o.getMdhtOrganization().getNames().get(0))));
		}
		p.getMdht().getParticipantRole().getTelecoms().addAll(o.getMdhtOrganization().getTelecoms());

		return p;
	}

	public static PN createPnFromOn(ON on) {
		PN pn = DatatypesFactory.eINSTANCE.createPN();
		pn.addText(on.getText());
		return pn;
	}

	/**
	 * <div class="en">Creates the reference.</div>
	 *
	 * @param contentId
	 *          <br>
	 *          <div class="en">content id</div>
	 * @param prefix
	 *          <br>
	 *          <div class="en">prefix</div>
	 * @return the ed
	 */
	public static ED createReference(int contentId, String prefix) {
		final ED text = DatatypesFactory.eINSTANCE.createED();
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();

		// Dirty BugFix for missing addReference method.
		tel.setValue("#" + prefix + String.valueOf(contentId));
		text.setReference(tel);
		return text;
	}

	/**
	 * Creates an MDHT ED reference from a given String
	 *
	 * @param value
	 *          the reference value
	 * @return the MDHT ED
	 */
	public static ED createReference(String value) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		tel.setValue(value);
		ed.setReference(tel);
		return ed;
	}

	/**
	 * Creates an MDHT ED reference from a given String
	 *
	 * @param url
	 *          the reference url
	 * @param narrativeText
	 *          the reference narrative text
	 * @return the MDHT ED
	 */
	public static ED createReference(String url, String narrativeText) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		final ED ed = DatatypesFactory.eINSTANCE.createED();
		tel.setValue(url);
		ed.setReference(tel);
		ed.addText(narrativeText);
		return ed;
	}

	/**
	 * <div class="en">Creates the MDHT phone TEL object.</div>
	 *
	 * @param telNr
	 *          <br>
	 *          <div class="en"> tel nr</div>
	 * @param usage
	 *          <br>
	 *          <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createTel(String telNr, AddressUse usage) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		if (usage != null) {
			tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		}
		tel.setValue(TELECOMS_PHONE_PREFIX + telNr.replaceAll("\\s+", ""));
		return tel;
	}

	// /**
	// * <div class="en">Creates a UUID for VACD documents with the VACD root ID
	// * and a generated extension.</div>
	// *
	// * @param id
	// * <br>
	// * <div class="en"> the id</div>
	// * @return the ii
	// */
	// public static II createUuidVacd(String id) {
	// final II ii = DatatypesFactory.eINSTANCE.createII();
	// ii.setRoot(CdaChVacd.OID_MAIN);
	// if (id == null) {
	// ii.setExtension(UUID.generate());
	// } else {
	// ii.setRoot(id);
	// }
	// return ii;
	// }
	//
	// /**
	// * <div class="en">Creates a UUID for VACD documents with the VACD root ID
	// * (if the root id is null, otherwise the provided id will be used) and a
	// * generated extension.</div>
	// *
	// * @param id
	// * <br>
	// * <div class="en"> the id</div>
	// * @return the ii
	// */
	// public static II createUuidVacdIdentificator(Identificator id) {
	// II ii;
	// if (id == null) {
	// ii = Util.createUuidVacd(null);
	// } else {
	// ii = id.getIi();
	// }
	// return ii;
	// }

	/**
	 * <div class="en">Creates the MDHT phone TEL object, without knowing the type
	 * of TEL object (id the endpoint is a fax, phone etc. is unknown).</div>
	 *
	 * @param endpointIdentifier
	 *          <br>
	 *          <div class="en"> tel nr</div><div class="de">Der Endpunkt der
	 *          Kommunikation (z.B. eine Telefonnummer)</div>
	 * @param usage
	 *          <br>
	 *          <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createUnknownTel(String endpointIdentifier, AddressUse usage) {
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		if (usage != null) {
			tel.getUses().add(usage.getAddressUseAsTelecommunicationAddressUse());
		}
		tel.setValue(endpointIdentifier);
		return tel;
	}

	/**
	 * <div class="en"> Extracts a file from embedded resources in the Jar as
	 * temporary file on the local filesystem
	 *
	 * @param rscPath
	 *          path to the desired file in the Jar
	 * @return Full path and file name of the created temporary file </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static String extractFileFromResource(String rscPath) {
		final String filename = FilenameUtils.getName(rscPath);
		String targetPath = null;

		if (!rscPath.startsWith("/"))
			rscPath = "/" + rscPath;

		try {
			targetPath = File.createTempFile(filename, "").getAbsolutePath();
			final InputStream input = Util.class.getResourceAsStream(rscPath);
			if (input == null) {
				throw new IOException("File '" + filename + "' not found.");
			}
			final OutputStream output = new FileOutputStream(targetPath);
			final byte[] buffer = new byte[2048];
			int bytesRead;
			while ((bytesRead = input.read(buffer)) != -1) {
				output.write(buffer, 0, bytesRead);
			}
			input.close();
			output.close();
		} catch (final IOException e1) {
			e1.printStackTrace();
		}

		return targetPath;
	}

	/**
	 * <div class="en">Extract string from a non quoted MDHT StrucDocText.</div>
	 *
	 * @param strucDocText
	 *          <br>
	 *          <div class="en">the StrucDocText</div>
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
	 * Creates a document ID with the eHC root ID
	 *
	 * @param applicationOidRoot
	 *          identifiziert diese Version des eHCs
	 * @return HL7 II Objekt
	 */
	public static II generateDocId(String applicationOidRoot) {
		// Unique identifier of the document. The root part identifies the
		// application instance, the extension part identifies the document
		// instance.

		final String documentOid = org.openhealthtools.ihe.utils.OID
				.createOIDGivenRoot("ehealthconnctor");
		// Creates a random extension ID to identify the document
		final Random r = new Random();
		final II id = DatatypesFactory.eINSTANCE.createII(documentOid, String.valueOf(r.nextInt()));
		return id;
	}

	/**
	 * Extracts the reference to a comment from a given list of MDHT
	 * EntryRelationship objects
	 *
	 * @param e
	 *          the EntryRelationship list
	 * @return the reference to the comment
	 */
	public static String getCommentRef(EList<EntryRelationship> e) {
		for (final EntryRelationship er : e) {
			if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ)) {
				// Get the ed and update it with the reference
				if (er.getAct().getText() != null) {
					final ED ed = er.getAct().getText();
					if (ed.getReference() != null) {
						return ed.getReference().getValue();
					}
				}
			}
		}
		return null;
	}

	/**
	 * Returns the text of a comment from a given list of MDHT EntryRelationship
	 * objects
	 *
	 * @param e
	 *          the EntryRelationship list
	 * @return the tet of the comment
	 */
	public static String getCommentText(EList<EntryRelationship> e) {
		for (final EntryRelationship er : e) {
			if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ)) {
				// Get the ed and update it with the reference
				final ED ed = er.getAct().getText();
				return ed.getText();
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the e mail from an ArrayList of TEL.</div>
	 * <div class="de">Liefert e mail aus einer ArrayList of TEL.</div>
	 *
	 * @param telecoms
	 *          <br>
	 *          <div class="en"> the telecoms</div>
	 * @return <div class="en">the e mail</div>
	 */
	public static Map<String, AddressUse> getEMail(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_EMAIL_PREFIX);
	}

	/**
	 * <div class="en">Gets the fax from an ArrayList of TEL.</div>
	 * <div class="de">Liefert cax aus einer ArrayList von TEL.</div>
	 *
	 * @param telecoms
	 *          <br>
	 *          <div class="en">the telecoms</div>
	 * @return <div class="en">the fax</div>
	 */
	public static Map<String, AddressUse> getFax(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_FAX_PREFIX);
	}

	/**
	 * <div class="en">Gets the e mail from an ArrayList of TEL.</div>
	 * <div class="de">Liefert e mail aus einer ArrayList von TEL.</div>
	 *
	 * @param telecoms
	 *          <br>
	 *          <div class="en">the telecoms</div>
	 * @return <div class="en">the phone</div>
	 */
	public static Map<String, AddressUse> getPhones(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_PHONE_PREFIX);
	}

	/**
	 * Extracts a HashMap<String, AddressUse> with a given Type from a given eHC
	 * ArrayList<TEL>
	 *
	 * @param telecoms
	 *          the List with unsorted MDHT TEL objects
	 * @param type
	 *          the type of telecommunication endpoint that should be extracted
	 * @return the HashMap with TEL objects of the given type
	 */
	private static Map<String, AddressUse> getTelecomType(List<TEL> telecoms, String type) {
		final Map<String, AddressUse> tl = new HashMap<String, AddressUse>();
		for (final TEL tel : telecoms) {
			if (tel.getValue().toLowerCase().contains(type)) {
				tl.put(tel.getValue(),
						(tel.getUses().size() > 0 ? AddressUse.getEnum(tel.getUses().get(0).getName()) : null));
			}
		}
		return tl;
	}

	/**
	 * <div class="en">Gets a temp folder for output files. If you set an
	 * environment variable with the name 'eHCTempPath' the eHealth Connector will
	 * use the path specified in this environment variable. If no such environment
	 * variable is set, it will try to use /temp. If the path is not writable the
	 * eHealth Connector will use the system temp folder.
	 *
	 * @return path to temp folder</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String getTempDirectory() {
		final String envVariable = "eHCTempPath";
		String tempDirectoryPath = null;
		final Log log = LogFactory.getLog(Util.class);
		try {
			final String env = System.getenv(envVariable);
			if (env != null) {
				tempDirectoryPath = env;
				log.debug("Trying to use temp folder set by environment variable '" + envVariable + "': "
						+ tempDirectoryPath);
			} else {
				tempDirectoryPath = "/temp";
				log.debug("Trying to use hardcoded temp folder: " + tempDirectoryPath);
			}
			final File uniqueFile = File.createTempFile("eHC", ".tmp", new File(tempDirectoryPath));
			FileUtils.writeStringToFile(uniqueFile, "write check");
			FileUtils.deleteQuietly(uniqueFile);
		} catch (final Exception e) {
			tempDirectoryPath = FileUtils.getTempDirectoryPath();
			log.debug("failed... Will use system temp folder: " + tempDirectoryPath);
		}
		log.info("Temp folder: " + tempDirectoryPath);
		return tempDirectoryPath;
	}

	/**
	 * Extract text from an Ecore FeatureMap
	 *
	 * @param featureMap
	 *          the featureMap
	 * @return the text as String
	 */
	@SuppressWarnings("unused")
	private static String getText(FeatureMap featureMap) {
		final StringBuffer buffer = new StringBuffer("");
		for (final FeatureMap.Entry entry : featureMap) {
			if (FeatureMapUtil.isText(entry)) {
				buffer.append(entry.getValue().toString());
			} else {
				if (entry.getEStructuralFeature() instanceof EReference) {
					buffer.append("<" + entry.getEStructuralFeature().getName() + ">");
				}
			}
		}
		return buffer.toString().trim();
	}

	/**
	 * <div class="en">Gets the website from an ArrayList of TEL.</div>
	 * <div class="de">Liefert die Webseite aus einer ArrayList von TEL.</div>
	 *
	 * @param telecoms
	 *          <br>
	 *          <div class="en">the telecoms</div>
	 * @return <div class="en">the webside</div>
	 */
	public static Map<String, AddressUse> getWebsites(List<TEL> telecoms) {
		final Map<String, AddressUse> h = getTelecomType(telecoms, TELECOMS_WEBSITE_PREFIX);
		return h;
	}

	/**
	 * <div class="en">Creates an MDHT II object.</div>
	 *
	 * @param root
	 *          <br>
	 *          <div class="en">the root</div>
	 * @return the II
	 */
	public static II ii(String root) {
		final II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(root);
		return ii;
	}

	/**
	 * Checks if an EntryRelationship is a comment
	 *
	 * @param er
	 *          the EntryRelationship
	 * @return true if the EntryRelationship is a comment, false otherwise
	 */
	public static boolean isComment(EntryRelationship er) {
		if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ) && er.getInversionInd())
			return true;
		else {
			return false;
		}
	}

	// /**
	// * Updates a Reference if it is a comment (in a deph of two counters)
	// *
	// * @param er
	// * the EntryRelationship
	// * @param i
	// * first counter
	// * @param j
	// * second counter
	// * @param prefix
	// * the prefix of the reference
	// * @return the EntryRelationship
	// */
	// public static EntryRelationship updateRefIfComment(EntryRelationship er,
	// int i, int j,
	// SectionsVACD prefix) {
	// if (er.getTypeCode().equals(x_ActRelationshipEntryRelationship.SUBJ)
	// && er.getInversionInd().equals(true)) {
	// // Get the ed and update it with the reference
	// final ED ed = er.getAct().getText();
	// final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
	// ed.setReference(tel);
	// if (CdaChVacd.CDA_LEVEL2_TEXT_GENERATION) {
	// tel.setValue("#" + prefix.getContentIdPrefix() + "-comment" + i + j);
	// } else {
	// tel.setValue(("#" + prefix.getContentIdPrefix() + "1"));
	// }
	// er.getAct().setText(ed);
	// }
	// return er;
	// }
	//
	// /**
	// * Updates a Reference if it is a comment
	// *
	// * @param er
	// * the EntryRelationship
	// * @param ref
	// * the reference
	// * @param prefix
	// * the prefix of the reference
	// * @return the EntryRelationship
	// */
	// public static EntryRelationship updateRefIfComment(EntryRelationship er,
	// String ref,
	// SectionsVACD prefix) {
	// if (isComment(er)) {
	// // Get the ed and update it with the reference
	// final ED ed = er.getAct().getText();
	// final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
	// ed.setReference(tel);
	// if (CdaChVacd.CDA_LEVEL2_TEXT_GENERATION) {
	// tel.setValue("#" + prefix.getContentIdPrefix() + "-comment" + ref);
	// } else {
	// tel.setValue(("#" + prefix.getContentIdPrefix() + "1"));
	// }
	// er.getAct().setText(ed);
	// }
	// return er;
	// }

	/**
	 * <div class="en">Join an ArrayList of String with person names to a whole
	 * name</div>
	 *
	 * @param nameList
	 *          <br>
	 *          <div class="en"> name list</div>
	 * @param delimiter
	 *          <br>
	 *          <div class="en"> delimiter</div>
	 * @return the string
	 */
	public static String join(List<String> nameList, String delimiter) {
		if ((nameList == null) || nameList.isEmpty()) {
			return "";
		}

		final StringBuilder builder = new StringBuilder();
		final Iterator<String> iter = nameList.iterator();
		// String string = iter.next();
		// if ("".equals(string)) {
		// builder = new StringBuilder(iter.next());
		// } else {
		// builder = new StringBuilder(iter.next());
		// }
		while (iter.hasNext()) {
			final String string = iter.next();
			if (builder.length() > 0) {
				builder.append(delimiter).append(string);
			} else {
				builder.append(string);
			}
		}
		return builder.toString();
	}

	/**
	 * <div class="en">Join a list of MDHT ENXP (name parts) to a whole person
	 * name</div>
	 *
	 * @param list
	 *          <br>
	 *          <div class="en">the list</div>
	 * @return the string
	 */
	public static String joinEListStr(EList<ENXP> list) {
		if (list.size() == 0) {
			return "";
		}
		final String names = list.get(0).getText();
		if (list.size() > 1) {
			final List<String> nameList = new ArrayList<String>();
			for (int i = 0; i < list.size(); i++) {
				nameList.add(list.get(i).getText());
			}
			return Util.join(nameList, " ");
		}
		return names;
	}

	/**
	 * <div class="en">Creates an MDHT ST</div>
	 *
	 * @param text
	 *          <br>
	 *          <div class="de">the text</div>
	 * @return the st
	 */
	public static ST st(String text) {
		final ST value = DatatypesFactory.eINSTANCE.createST();
		value.addText(text);
		return value;
	}

	/**
	 * Tranverses through a given FeatureMap and prints an XML representations of
	 * this map (only for test purposes)
	 *
	 * @param root
	 *          the root of the FeatureMap
	 */
	@SuppressWarnings("unused")
	private static void traverse(FeatureMap root) {
		final Stack<FeatureMap> stack = new Stack<FeatureMap>();
		final Stack<String> stack2 = new Stack<String>();
		stack.push(root);
		while (!stack.isEmpty()) {
			final FeatureMap featureMap = stack.pop();
			for (int i = featureMap.size() - 1; i >= 0; i--) {
				final Entry entry = featureMap.get(i);
				if (entry.getEStructuralFeature() instanceof EReference) {
					System.out.print("<" + entry.getEStructuralFeature().getName());
					final AnyType anyType = (AnyType) entry.getValue();
					traverseAttributes(anyType.getAnyAttribute());
					System.out.print(">");
					stack.push(anyType.getMixed());

				} else {
					// if (entry.getValue() != null && !stack2.isEmpty()) {
					// System.out.print("</"+stack2.pop()+">");}
					// //Text between the Elements
					if (entry.getValue() != null) {
						final String value = entry.getValue().toString();
						if (value.trim().length() > 0) {
							System.out.print(value);
						}
					} else {
						System.out.println(" }");
					}
				}
				if ((entry.getValue() != null) && !stack2.isEmpty()) {
					System.out.print("</" + stack2.pop() + ">");
				}
			}
		}
	}

	/**
	 * Tranverses through a given FeatureMap and updates a given StringBuilder
	 * with the XML representation of the map
	 *
	 * @param featureMap
	 *          the Ecore FeatureMap
	 * @param sb
	 *          the StringBuilder
	 * @return the updated StringBuilder
	 */
	private static StringBuilder traverse2(FeatureMap featureMap, StringBuilder sb) {
		for (int i = 0; i <= (featureMap.size() - 1); i++) {
			final Entry entry = featureMap.get(i);
			if (entry.getEStructuralFeature() instanceof EReference) {
				sb.append("<" + entry.getEStructuralFeature().getName());
				final AnyType anyType = (AnyType) entry.getValue();
				// sb = traverseAttributes2(anyType.getAnyAttribute(), sb);
				traverseAttributes2(anyType.getAnyAttribute(), sb);
				sb.append(">");
				traverse2(anyType.getMixed(), sb);
				sb.append("</" + entry.getEStructuralFeature().getName() + ">");
			} else {
				// //Text between the Elements
				if (entry.getValue() != null) {
					final String value = entry.getValue().toString();
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

	/**
	 * Recursive function to tranverse all attributes and print the contents (only
	 * for test purposes)
	 *
	 * @param anyAttribute
	 *          the Ecore FeatureMap
	 */
	private static void traverseAttributes(FeatureMap anyAttribute) {
		for (final Entry entry : anyAttribute) {
			System.out.print(" " + entry.getEStructuralFeature().getName() + "=\""
					+ entry.getValue().toString() + "\"");
		}
	}

	/**
	 * Recursive function to tranverse all attributes and update the given
	 * StringBuilder with an XML representation of the attributes
	 *
	 * @param anyAttribute
	 *          the Ecore FeatureMap
	 * @param sb
	 *          the StringBuilder
	 * @return the updated StringBuilder
	 */
	private static StringBuilder traverseAttributes2(FeatureMap anyAttribute, StringBuilder sb) {
		for (final Entry entry : anyAttribute) {
			sb.append(" " + entry.getEStructuralFeature().getName() + "=\"" + entry.getValue().toString()
					+ "\"");
		}
		return sb;
	}

}
