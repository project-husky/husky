/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.common.utils;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Telecom;
import org.ehealth_connector.common.basetypes.AddressBaseType;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.basetypes.NameBaseType;
import org.ehealth_connector.common.basetypes.OrganizationBaseType;
import org.ehealth_connector.common.basetypes.TelecomBaseType;
import org.ehealth_connector.common.enums.TelecomAddressUse;
import org.ehealth_connector.common.hl7cdar2.AD;
import org.ehealth_connector.common.hl7cdar2.AdxpCity;
import org.ehealth_connector.common.hl7cdar2.AdxpPostalCode;
import org.ehealth_connector.common.hl7cdar2.CD;
import org.ehealth_connector.common.hl7cdar2.CE;
import org.ehealth_connector.common.hl7cdar2.ED;
import org.ehealth_connector.common.hl7cdar2.ENXP;
import org.ehealth_connector.common.hl7cdar2.II;
import org.ehealth_connector.common.hl7cdar2.IVLPQ;
import org.ehealth_connector.common.hl7cdar2.IVLTS;
import org.ehealth_connector.common.hl7cdar2.IVXBTS;
import org.ehealth_connector.common.hl7cdar2.ON;
import org.ehealth_connector.common.hl7cdar2.PN;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedAuthor;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040AssignedEntity;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Authenticator;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040Author;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040CustodianOrganization;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.ehealth_connector.common.hl7cdar2.POCDMT000040LegalAuthenticator;
import org.ehealth_connector.common.hl7cdar2.ST;
import org.ehealth_connector.common.hl7cdar2.TEL;
import org.ehealth_connector.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.ehealth_connector.common.mdht.Participant;
import org.ehealth_connector.common.mdht.ParticipantRole;
import org.ehealth_connector.common.mdht.PlayingEntity;
import org.ehealth_connector.common.mdht.enums.PostalAddressUse;
import org.ehealth_connector.common.mdht.enums.Signature;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Helper methods for the eHealth Connector and CDA.
 */
public class Util {

	/** The SLF4J logger instance. */
	private static org.slf4j.Logger log = LoggerFactory.getLogger(Util.class);

	/**
	 * The StreamGobbler is a helper for the runExternalCommand method.
	 */
	private static class StreamGobbler implements Runnable {

		/** The input stream. */
		private InputStream inputStream;

		/** The consumer. */
		private Consumer<String> consumer;

		/**
		 * Instantiates a new stream gobbler.
		 *
		 * @param inputStream
		 *            the input stream
		 * @param consumer
		 *            the consumer
		 */
		public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
			this.inputStream = inputStream;
			this.consumer = consumer;
		}

		/**
		 * Run.
		 */
		@Override
		public void run() {
			new BufferedReader(new InputStreamReader(inputStream)).lines().forEach(consumer);
		}
	}

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
	 * The Constant TELECOMS_WEBSITE_PREFIX. Note: omitting the : here in order
	 * to support http and https
	 */
	public static final String TELECOMS_WEBSITE_PREFIX = "http";

	/** HL7v3 namespace. */
	public static final String NAMESPACE_HL7_V3 = "urn:hl7-org:v3";

	private static Random rand;

	/**
	 * Checks to see if the list has at least one element.
	 *
	 * @param l
	 *            the list
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
	 * <div class="en"> Converts a list of II int a list of Identificators.
	 *
	 * @param mII
	 *            the list to convert
	 * @return </div> <div class="de"></div> <div class="fr"></div>
	 */
	public static List<Identificator> convertIds(List<org.ehealth_connector.common.hl7cdar2.II> mII) {
		final List<Identificator> il = new ArrayList<>();
		for (final org.ehealth_connector.common.hl7cdar2.II mId : mII) {
			il.add(new Identificator(mId));
		}
		return il;
	}

	/**
	 * Escapes all non java character in the inputsream that is expected as XML.
	 *
	 * @param inputStream
	 *            the input stream to be escaped
	 * @return the input stream
	 */
	public static InputStream convertNonAsciiText2Unicode(InputStream inputStream) {
		InputStream retVal = null;
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder;
		try {
			docBuilder = docBuilderFactory.newDocumentBuilder();
			Document document = docBuilder.parse(inputStream);
			convertNonAsciiText2Unicode(document.getDocumentElement());
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			Source xmlSource = new DOMSource(document);
			Result outputTarget = new StreamResult(outputStream);
			TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
			retVal = new ByteArrayInputStream(outputStream.toByteArray());
		} catch (ParserConfigurationException | SAXException | IOException | TransformerException
				| TransformerFactoryConfigurationError e) {
			// Do nothing
		}
		return retVal;
	}

	/**
	 * Escapes all non java character in the node text.
	 *
	 * @param node
	 *            the node to be escaped
	 */
	@SuppressWarnings("deprecation")
	public static void convertNonAsciiText2Unicode(Node node) {
		if (node.getFirstChild() != null) {
			String nodeValue = node.getFirstChild().getNodeValue();
			if (nodeValue != null) {
				nodeValue = nodeValue.replace("\n", "").replace("\t", "");
				node.getFirstChild().setNodeValue(
						org.apache.commons.lang3.StringEscapeUtils.escapeJava(nodeValue));
			}
		}
		NodeList nodeList = node.getChildNodes();
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node currentNode = nodeList.item(i);
			if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
				// calls this method for all the children which is Element
				convertNonAsciiText2Unicode(currentNode);
			}
		}
	}

	/**
	 * Creates an address.
	 *
	 * @param zip
	 *            ZIP code
	 * @param city
	 *            the city
	 * @param usage
	 *            usage of this address
	 * @return HL7 AD Object
	 */
	public static AD createAddress(String zip, String city, PostalAddressUse usage) {
		final var retVal = new AD();

		if (city != null) {
			var obj = new AdxpCity();
			obj.xmlContent = city;
			retVal.getContent()
					.add(new JAXBElement<AdxpCity>(new QName(NAMESPACE_HL7_V3, "city"), AdxpCity.class, obj));
		}

		if (zip != null) {
			var obj = new AdxpPostalCode();
			obj.xmlContent = zip;
			retVal.getContent().add(new JAXBElement<AdxpPostalCode>(new QName(NAMESPACE_HL7_V3, "postalCode"),
					AdxpPostalCode.class, obj));
		}

		if (usage != null) {
			retVal.getUse().clear();
			retVal.getUse().add(usage.getCodeValue());
		}

		return retVal;
	}

	/**
	 * Creates an MDHT assignedEntity object from an MDHT AssignedAuthor object.
	 *
	 * @param a
	 *            the assignedAuthor
	 * @return the assignedEntity
	 */
	public static POCDMT000040AssignedAuthor createAssignedAuthorFromAssignedEntity(POCDMT000040AssignedEntity a) {
		final POCDMT000040AssignedAuthor asAut = new POCDMT000040AssignedAuthor();
		// Copy Addresses
		if (a.getAddr() != null) {
			asAut.getAddr().addAll(a.getAddr());
		}
		// Copy Ids
		if (a.getId() != null) {
			asAut.getId().addAll(a.getId());
		}
		// Copy Telecoms
		if (a.getTelecom() != null) {
			asAut.getTelecom().addAll(a.getTelecom());
		}
		// Copy Represented Organization
		asAut.setRepresentedOrganization(a.getRepresentedOrganization());

		// Set Assigned Person
		asAut.setAssignedPerson(a.getAssignedPerson());

		return asAut;
	}

	/**
	 * Creates the assigned author from organization.
	 *
	 * @param organization
	 *            the organization
	 * @return the assigned author
	 */
	public static POCDMT000040AssignedAuthor createAssignedAuthorFromOrganization(org.ehealth_connector.common.Organization organization) {
		final var o = organization.getHl7CdaR2Pocdmt000040Organization();
		final var a = new POCDMT000040AssignedAuthor();
		if (!o.getAddr().isEmpty()) {
			a.getAddr().addAll(o.getAddr());
		}
		if (!o.getTelecom().isEmpty()) {
			a.getTelecom().addAll(o.getTelecom());
		}
		if (!o.getId().isEmpty()) {
			a.getId().addAll(o.getId());
		}
		return a;
	}

	/**
	 * Creates an assignedEntity object from an AssignedAuthor object.
	 *
	 * @param a the assignedAuthor
	 * @return the assignedEntity
	 */
	public static POCDMT000040AssignedEntity createAssignedEntityFromAssignedAuthor(POCDMT000040AssignedAuthor a) {
		final var asEnt = new POCDMT000040AssignedEntity();
		// Copy Addresses
		if (a.getAddr() != null) {
			asEnt.getAddr().addAll(a.getAddr());
		}
		// Copy Ids
		if (a.getId() != null) {
			asEnt.getId().addAll(a.getId());
		}
		// Copy Telecoms
		if (a.getTelecom() != null) {
			asEnt.getTelecom().addAll(a.getTelecom());
		}
		// Copy Represented Organization
		if (a.getRepresentedOrganization() != null) {
			asEnt.setRepresentedOrganization(a.getRepresentedOrganization());
		}
		// Set Assigned Person
		if (a.getAssignedPerson() != null) {
			asEnt.setAssignedPerson(a.getAssignedPerson());
		}

		return asEnt;
	}

	/**
	 * Creates the assigned entity from organization.
	 *
	 * @param organization
	 *            the organization
	 * @return the assigned entity
	 */
	public static POCDMT000040AssignedEntity createAssignedEntityFromOrganization(Organization organization) {
		final var o = organization.getHl7CdaR2Pocdmt000040Organization();
		final var a = new POCDMT000040AssignedEntity();
		if (!o.getAddr().isEmpty()) {
			a.getAddr().addAll(o.getAddr());
		}
		if (!o.getTelecom().isEmpty()) {
			a.getTelecom().addAll(o.getTelecom());
		}
		if (!o.getId().isEmpty()) {
			a.getId().addAll(o.getId());
		}
		return a;
	}

	/**
	 * Creates the authenticator from author.
	 *
	 * @param author
	 *            the author
	 * @return the authenticator
	 */
	public static POCDMT000040Authenticator createAuthenticatorFromAuthor(
			org.ehealth_connector.common.Author author) {
		final POCDMT000040Author a = author.getAuthorMdht();
		final POCDMT000040Authenticator auth = new POCDMT000040Authenticator();
		auth.setAssignedEntity(createAssignedEntityFromAssignedAuthor(a.getAssignedAuthor()));

		// Set signature Code to 's'
		final var cs = Signature.SIGNED.getCS();
		auth.setSignatureCode(cs);
		// Copy Time
		auth.setTime(a.getTime());

		return auth;
	}

	/**
	 * Creates a new MDHT Author object from an MDHT LegalAuthenticator object.
	 *
	 * @param authenticator
	 *            <br>
	 *            <div class="de">the authenticator</div>
	 * @return the Author
	 */
	public static POCDMT000040Author createAuthorFromAuthenticator(
			POCDMT000040Authenticator authenticator) {
		final POCDMT000040Author a = new POCDMT000040Author();

		a.setAssignedAuthor(
				createAssignedAuthorFromAssignedEntity(authenticator.getAssignedEntity()));

		// Copy Time
		a.setTime(authenticator.getTime());

		return a;
	}

	/**
	 * Creates a new MDHT Author object from an MDHT LegalAuthenticator object.
	 *
	 * @param authenticator
	 *            <br>
	 *            <div class="de">the authenticator</div>
	 * @return the Author
	 */
	public static POCDMT000040Author createAuthorFromLegalAuthenticator(POCDMT000040LegalAuthenticator authenticator) {
		final POCDMT000040Author a = new POCDMT000040Author();

		a.setAssignedAuthor(
				createAssignedAuthorFromAssignedEntity(authenticator.getAssignedEntity()));

		// Copy Time
		a.setTime(authenticator.getTime());

		return a;
	}

	/**
	 * <div class="en">Creates the MDHT CE null flavor NASK.</div>
	 *
	 * @return the CE
	 */
	public static CE createCENullFlavorNASK() {
		final var ce = new CE();
		ce.nullFlavor = new LinkedList<>();
		ce.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_ASKED_CODE);
		return ce;
	}

	/**
	 * <div class="en">Creates the MDHT CE null flavor UNK.</div>
	 *
	 * @return the CE
	 */
	public static CE createCENullFlavorUNK() {
		final var ce = new CE();
		ce.nullFlavor = new LinkedList<>();
		ce.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.UNKNOWN_CODE);
		return ce;
	}

	/**
	 * <div class="en">Creates the MDHT CD null flavor NA.</div>
	 *
	 * @return the CD
	 */
	public static CD createCodeNullFlavorNA() {
		final var code = new CD();
		code.nullFlavor = new LinkedList<>();
		code.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
		return code;
	}

	/**
	 * <div class="en">Creates the MDHT CD null flavor UNK.</div>
	 *
	 * @return the CD
	 */
	public static CD createCodeNullFlavorUNK() {
		final var code = new CD();
		code.nullFlavor = new LinkedList<>();
		code.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.UNKNOWN_CODE);
		return code;
	}

	/**
	 * Creates a new MDHT CustodianOrganization object from an eHC Organization
	 * object.
	 *
	 * @param organization
	 *            the Organization
	 * @return CustodianOrganization the CustodianOrganization
	 */
	public static POCDMT000040CustodianOrganization createCustodianOrganizationFromOrganization(
			Organization organization) {
		// create and set the mdht RepresentedCustodianOrganization Object
		if (organization != null) {
			final var mdhtCustOrg = new POCDMT000040CustodianOrganization();

			final var on = new ON();
			on.xmlContent = organization.getPrimaryName().getFullName();

			if (!organization.getHl7CdaR2Pocdmt000040Organization().getName().isEmpty()) {
				if (organization.getHl7CdaR2Pocdmt000040Organization().getName().get(0).getUse() != null) {
					on.getUse().clear();
					for (String item : organization.getHl7CdaR2Pocdmt000040Organization().getName().get(0)
							.getUse()) {
						on.getUse().add(item);
					}
				}
			}
			mdhtCustOrg.setName(on);

			// take the first address and set it as CustodianAdress
			if (!organization.getHl7CdaR2Pocdmt000040Organization().getAddr().isEmpty()) {
				mdhtCustOrg.setAddr(organization.getHl7CdaR2Pocdmt000040Organization().getAddr().get(0));
				// Somehow PostalAddressUse is not copied by the MDHT function.
				// We have
				// to do it manually.
				mdhtCustOrg.getAddr().getUse()
						.addAll(organization.getHl7CdaR2Pocdmt000040Organization().getAddr().get(0).getUse());
			}

			// take the first telecom and set it as CustodianTelecom
			if (!organization.getHl7CdaR2Pocdmt000040Organization().getTelecom().isEmpty()) {
				mdhtCustOrg.setTelecom(organization.getHl7CdaR2Pocdmt000040Organization().getTelecom().get(0));
				mdhtCustOrg.getTelecom().getUse()
						.add(
								organization.getHl7CdaR2Pocdmt000040Organization().getTelecom().get(0).getUse()
										.get(0));
			}
			return mdhtCustOrg;
		}
		return null;
	}

	/**
	 * <div class="en">Creates the ED.</div>
	 *
	 * @param text
	 *            <br>
	 *            <div class="en">text</div>
	 * @return the ED
	 */
	public static ED createEd(String text) {
		final var ed = new ED();
		ed.xmlContent = text;
		return ed;
	}

	/**
	 * Creates the effective time null flavor unk.
	 *
	 * @return the ivl ts
	 */
	public static IVLTS createEffectiveTimeNullFlavorUnk() {
		final var ivlts = new IVLTS();
		ivlts.nullFlavor = new LinkedList<>();
		ivlts.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.UNKNOWN_CODE);
		return ivlts;
	}

	/**
	 * <div class="en">Creates the MDHT email TEL object.</div>
	 *
	 * @param eMail
	 *            <br>
	 *            <div class="en"> e mail</div>
	 * @param usage
	 *            <br>
	 *            <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createEMail(String eMail, TelecomAddressUse usage) {
		final var tel = new TEL();
		tel.getUse().add(usage.getCodeValue());
		tel.setValue(TELECOMS_EMAIL_PREFIX + eMail);
		return tel;
	}

	/**
	 * <div class="en">Creates the eur date str from ts.</div>
	 *
	 * @param hl7Stimestamp
	 *            <br>
	 *            <div class="en"> hl7 stimestamp</div><div class="de"></div>
	 *            <div class="fr"> </div> <div class="it"></div>
	 * @return the string
	 */
	public static String createEurDateStrFromTS(String hl7Stimestamp) {
		return hl7Stimestamp.substring(6, 8) + "."
				+ hl7Stimestamp.substring(4, 6) + "." + hl7Stimestamp.substring(0, 4);
	}

	/**
	 * <div class="en">Creates the MDHT fax TEL object.</div>
	 *
	 * @param faxNr
	 *            <br>
	 *            <div class="en"> fax nr</div>
	 * @param usage
	 *            <br>
	 *            <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createFax(String faxNr, TelecomAddressUse usage) {
		final var tel = new TEL();
		tel.getUse().add(usage.getCodeValue());
		tel.setValue(TELECOMS_FAX_PREFIX + faxNr);
		return tel;
	}

	/**
	 * <div class="en">Creates the MDHT IVL_PQ null flavor NA object.</div>
	 *
	 * @return the IVL_PQ
	 */
	public static IVLPQ createIVL_PQNullFlavorNA() {
		final var ivlpq = new IVLPQ();
		ivlpq.nullFlavor = new LinkedList<>();
		ivlpq.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_APPLICABLE_CODE);
		return ivlpq;
	}

	/**
	 * <div class="en">Creates the IVL_PQ null flavor NASK object.</div>
	 *
	 * @return the IVL_PQ
	 */
	public static IVLPQ createIVL_PQNullFlavorNASK() {
		final var ivlpq = new IVLPQ();
		ivlpq.nullFlavor = new LinkedList<>();
		ivlpq.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.NOT_ASKED_CODE);
		return ivlpq;
	}

	/**
	 * <div class="en">Creates the IVL_PQ null flavor UNK object.</div>
	 *
	 * @return the IVL_PQ
	 */
	public static IVLPQ createIVL_PQNullFlavorUNK() {
		final var ivlpq = new IVLPQ();
		ivlpq.nullFlavor = new LinkedList<>();
		ivlpq.getNullFlavor().add(org.ehealth_connector.common.enums.NullFlavor.UNKNOWN_CODE);
		return ivlpq;
	}

	/**
	 * Creates a new MDHT LegalAuthor object from an MDHT Author object.
	 * Signature Code will be set to fixed 's'
	 *
	 * @param author
	 *            <br>
	 *            <div class="de">the author</div>
	 * @return the legal authenticator
	 */
	public static POCDMT000040LegalAuthenticator createLegalAuthenticatorFromAuthor(
			org.ehealth_connector.common.Author author) {
		final POCDMT000040Author a = author.getAuthorMdht();
		final var mdhtLegAuth = new POCDMT000040LegalAuthenticator();
		mdhtLegAuth
				.setAssignedEntity(createAssignedEntityFromAssignedAuthor(a.getAssignedAuthor()));

		// Set signature Code to 's'
		final var cs = Signature.SIGNED.getCS();
		mdhtLegAuth.setSignatureCode(cs);
		// Copy Time
		mdhtLegAuth.setTime(a.getTime());

		return mdhtLegAuth;
	}

	/**
	 * <div class="en">Creates the MDHT IVXB_TS null flavor UNK.</div>
	 *
	 * @return the ivxb ts
	 */
	public static IVXBTS createNullFlavorUnknown() {
		final IVXBTS ts = new IVXBTS();
		ts.nullFlavor = new LinkedList<>();
		ts.nullFlavor.add(org.ehealth_connector.common.enums.NullFlavor.UNKNOWN_CODE);
		return ts;
	}

	/**
	 * Creates the on from pn.
	 *
	 * @param pn
	 *            the pn
	 * @return the on
	 */
	private static ON createOnFromPn(PN pn) {
		final var on = new ON();
		on.xmlContent = pn.xmlContent;
		return on;
	}

	/**
	 * Creates the organization from custodian organization.
	 *
	 * @param mdhtCO
	 *            the mdht CO
	 * @return the org.openhealthtools.mdht.uml.cda. organization
	 */
	public static POCDMT000040CustodianOrganization createOrganizationFromCustodianOrganization(
			POCDMT000040CustodianOrganization mdhtCO) {
		final POCDMT000040CustodianOrganization o = new POCDMT000040CustodianOrganization();
		if (mdhtCO != null) {
			// Name
			if (mdhtCO.getName() != null) {
				o.setName(mdhtCO.getName());
			}
			// Ids
			if (!mdhtCO.getId().isEmpty()) {
				o.getId().addAll(mdhtCO.getId());
			}
			// Addr
			if (mdhtCO.getAddr() != null) {
				o.setAddr(mdhtCO.getAddr());
			}
			// Telecoms
			if (mdhtCO.getTelecom() != null) {
				o.setTelecom(mdhtCO.getTelecom());
			}
		}
		return o;
	}

	/**
	 * Creates the organization from participant.
	 *
	 * @param p
	 *            the p
	 * @return the organization
	 */
	public static Organization createOrganizationFromParticipant(Participant p) {
		final Organization o = new Organization(new OrganizationBaseType());

		// id, addrs, names, telecoms

		for (II id : p.getMdht().getParticipantRole().getId()) {
			if (id != null) {
				o.getHl7CdaR2Pocdmt000040Organization().getId().add(id);
			}
		}

		for (AD ad : p.getMdht().getParticipantRole().getAddr()) {
			if (ad != null) {
				o.getHl7CdaR2Pocdmt000040Organization().getAddr().add(ad);
			}
		}

		if ((p.getMdht().getParticipantRole().getPlayingEntity().getName() != null)
				&& !p.getMdht().getParticipantRole().getPlayingEntity().getName().isEmpty()) {
			for (PN pn : p.getMdht().getParticipantRole().getPlayingEntity().getName()) {
				o.getHl7CdaR2Pocdmt000040Organization().getName().add(createOnFromPn(pn));
			}
		}

		for (TEL tel : p.getMdht().getParticipantRole().getTelecom()) {
			o.getHl7CdaR2Pocdmt000040Organization().getTelecom().add(tel);
		}

		return o;
	}

	/**
	 * Creates the participant from organization.
	 *
	 * @param o
	 *            the o
	 * @return the participant
	 */
	public static Participant createParticipantFromOrganization(Organization o) {
		final var pe = new PlayingEntity();
		final var pr = new ParticipantRole();
		pr.setPlayingEntity(pe);
		final var p = new Participant();
		p.setParticipantRole(pr);

		// id, addrs, names, telecoms

		for (IdentificatorBaseType id : o.getIdentificatorList()) {
			p.getMdht().getParticipantRole().getId().add(new Identificator(id).getHl7CdaR2Ii());
		}

		for (AddressBaseType address : o.getAddressList()) {
			if (address != null) {
				p.getMdht().getParticipantRole().getAddr().add(new Address(address).getHl7CdaR2Ad());
			}
		}

		if ((o.getNameList() != null) && !o.getNameList().isEmpty()) {
			for(NameBaseType nameType: o.getNameList()) {
				if(nameType != null) {
					p.getMdht().getParticipantRole().getPlayingEntity().getName()
							.add(new Name(nameType).getHl7CdaR2Pn());
				}
			}
		}

		if (o.getTelecomList() != null) {
			for (TelecomBaseType telecom : o.getTelecomList()) {
				p.getMdht().getParticipantRole().getTelecom().add(new Telecom(telecom).getHl7CdaR2Tel());
			}
		}

		return p;
	}

	/**
	 * Creates the pn from on.
	 *
	 * @param on
	 *            the on
	 * @return the pn
	 */
	public static PN createPnFromOn(org.ehealth_connector.common.hl7cdar2.ON on) {
		final var pn = new org.ehealth_connector.common.hl7cdar2.PN();
		pn.xmlContent = on.xmlContent;
		return pn;
	}

	/**
	 * Creates an MDHT ED reference from a given String. Adds the hashtag '#'
	 * automatically, if not present as first character.
	 *
	 * @param existingText
	 *            the existing text
	 * @param reference
	 *            the reference
	 * @return the MDHT ED
	 */
	public static ED createReference(ED existingText, String reference) {
		var ed = existingText;
		if (ed == null)
			ed = new ED();
		ed.setReference(createReferenceTel(reference));
		return ed;
	}

	/**
	 * <div class="en">Creates the reference.</div>
	 *
	 * @param contentId
	 *            <br>
	 *            <div class="en">content id</div>
	 * @param prefix
	 *            <br>
	 *            <div class="en">prefix</div>
	 * @return the ed
	 */
	public static ED createReference(int contentId, String prefix) {
		final var text = new ED();
		final var tel = new TEL();

		// Dirty BugFix for missing addReference method.
		tel.setValue("#" + prefix + contentId);
		text.setReference(tel);
		return text;
	}

	/**
	 * Creates an MDHT ED reference from a given String. Adds the hashtag '#'
	 * automatically, if not present as first character.
	 *
	 * @param reference
	 *            the reference value
	 * @return the MDHT ED
	 */
	public static ED createReference(String reference) {
		ED ed = new ED();
		ed.setReference(createReferenceTel(reference));
		return ed;
	}

	/**
	 * Creates an MDHT ED reference from a given String.
	 *
	 * @param url
	 *            the reference url
	 * @param narrativeText
	 *            the reference narrative text
	 * @return the MDHT ED
	 */
	public static ED createReference(String url, String narrativeText) {
		final var tel = new TEL();
		final var ed = new ED();
		tel.setValue(url);
		ed.xmlContent = narrativeText;
		ed.setReference(tel);
		return ed;
	}

	/**
	 * Creates the reference tel.
	 *
	 * @param value
	 *            the value
	 * @return the tel
	 */
	public static TEL createReferenceTel(String value) {
		final var tel = new TEL();
		if (!value.startsWith("#")) {
			value = "#" + value;
		}
		tel.setValue(value);
		return tel;
	}

	/**
	 * <div class="en">Creates the MDHT phone TEL object.</div>
	 *
	 * @param telNr
	 *            <br>
	 *            <div class="en"> tel nr</div>
	 * @param usage
	 *            <br>
	 *            <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createTel(String telNr, TelecomAddressUse usage) {
		final var tel = new TEL();
		if (usage != null) {
			tel.getUse().add(usage.getCodeValue());
		}
		tel.setValue(TELECOMS_PHONE_PREFIX + telNr.replaceAll("\\s+", ""));
		return tel;
	}

	/**
	 * <div class="en">Creates the MDHT phone TEL object, without knowing the
	 * type of TEL object (id the endpoint is a fax, phone etc. is
	 * unknown).</div>
	 *
	 * @param endpointIdentifier
	 *            <br>
	 *            <div class="en"> tel nr</div><div class="de">Der Endpunkt der
	 *            Kommunikation (z.B. eine Telefonnummer)</div>
	 * @param usage
	 *            <br>
	 *            <div class="en"> usage</div>
	 * @return the tel
	 */
	public static TEL createUnknownTel(String endpointIdentifier, TelecomAddressUse usage) {
		final var tel = new TEL();
		if (usage != null) {
			tel.getUse().clear();
			tel.getUse().add(usage.getCodeValue());
		}
		tel.setValue(endpointIdentifier);
		return tel;
	}

	/**
	 * Enables immediate logging. All appenders will flush at the end of each
	 * write. Currently implemented for FileAppenders, only.
	 *
	 * @param logger
	 *            the desired logger for which immediate logging shall be
	 *            enabled.
	 */
	@SuppressWarnings("rawtypes")
	public static void enableImmediateLogging(org.apache.log4j.Logger logger) {
		Enumeration allAppenders = logger.getAllAppenders();
		while (allAppenders.hasMoreElements()) {
			Object nextElement = allAppenders.nextElement();
			if (nextElement instanceof org.apache.log4j.FileAppender) {
				org.apache.log4j.FileAppender fileAppender = (org.apache.log4j.FileAppender) nextElement;
				fileAppender.setImmediateFlush(true);
			}
		}
		allAppenders = logger.getParent().getAllAppenders();
		while (allAppenders.hasMoreElements()) {
			Object nextElement = allAppenders.nextElement();
			if (nextElement instanceof org.apache.log4j.FileAppender) {
				org.apache.log4j.FileAppender fileAppender = (org.apache.log4j.FileAppender) nextElement;
				fileAppender.setImmediateFlush(true);
			}
		}
	}

	/**
	 * <div class="en"> Extracts a file from embedded resources in the Jar as
	 * temporary file on the local filesystem.
	 *
	 * @param rscPath
	 *            path to the desired file in the Jar
	 * @return Full path and file name of the created temporary file </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static String extractFileFromResource(String rscPath) {
		return extractFileFromResource(rscPath, true);
	}

	/**
	 * <div class="en"> Extracts a file from embedded resources in the Jar as
	 * temporary file on the local filesystem.
	 *
	 * @param rscPath
	 *            path to the desired file in the Jar
	 * @param pathfix
	 *            if path should be corrected at start depending on ox system
	 * @return Full path and file name of the created temporary file </div>
	 *         <div class="de"></div> <div class="fr"></div>
	 */
	public static String extractFileFromResource(String rscPath, boolean pathfix) {
		final String filename = FilenameUtils.getName(rscPath);
		String targetPath = null;

		if (pathfix && !rscPath.startsWith("/")) {
			rscPath = "/" + rscPath;
		}

		try {
			targetPath = File.createTempFile(filename, "").getAbsolutePath();
			final InputStream input = Util.class.getResourceAsStream(rscPath);
			if (input == null) {
				throw new IOException("File '" + filename + "' not found.");
			}
			try (OutputStream output = new FileOutputStream(targetPath)) {
				final var buffer = new byte[2048];
				int bytesRead;
				while ((bytesRead = input.read(buffer)) != -1) {
					output.write(buffer, 0, bytesRead);
				}
			}

			input.close();
		} catch (final IOException e1) {
			log.error(e1.getMessage(), e1);
		}

		return targetPath;
	}

	/**
	 * Run the Garbage Collector to get the most possible heap space free for
	 * subsequent tasks. This is not recommended but can be used if situations
	 * arise.
	 */
	public static void freeMemory() {
		Runtime.getRuntime().gc();
	}

	/**
	 * Creates a document ID with the eHC root ID.
	 *
	 * @param applicationOidRoot
	 *            identifiziert diese Version des eHCs
	 * @return HL7 II Objekt
	 */
	public static II generateDocId(String applicationOidRoot) {
		// Unique identifier of the document. The root part identifies the
		// application instance, the extension part identifies the document
		// instance.

		if (Util.getRand() == null) {
			try {
				Util.setRand(SecureRandom.getInstanceStrong());
			} catch (NoSuchAlgorithmException e) {
				Util.setRand(new Random());
			}
		}

		final String documentOid = OID
				.createOIDGivenRoot("ehealthconnctor");
		// Creates a random extension ID to identify the document

		final var id = new II();
		id.setRoot(documentOid);
		id.setExtension(String.valueOf(rand.nextInt()));
		return id;
	}

	/**
	 * Gets the checksum of a serializable object.
	 *
	 * @param object
	 *            the object
	 * @return the checksum
	 */
	public static int getChecksum(Serializable object) {
		int retVal = -1;
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			var md = MessageDigest.getInstance("SHA-512");
			byte[] thedigest = md.digest(baos.toByteArray());
			retVal = java.util.Arrays.hashCode(thedigest);
		} catch (IOException | NoSuchAlgorithmException e) {
			log.error(e.getMessage(), e);
		}
		return retVal;
	}

	/**
	 * Extracts the reference to a comment from a given list of MDHT
	 * EntryRelationship objects.
	 *
	 * @param e
	 *            the EntryRelationship list
	 * @return the reference to the comment
	 */
	public static String getCommentRef(List<POCDMT000040EntryRelationship> e) {
		for (final POCDMT000040EntryRelationship er : e) {
			if (er.getTypeCode().equals(XActRelationshipEntryRelationship.SUBJ)) {
				// Get the ed and update it with the reference
				if (er.getAct().getText() != null) {
					final var ed = er.getAct().getText();
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
	 * objects.
	 *
	 * @param e
	 *            the EntryRelationship list
	 * @return the tet of the comment
	 */
	public static String getCommentText(List<POCDMT000040EntryRelationship> e) {
		for (final POCDMT000040EntryRelationship er : e) {
			if (er.getTypeCode().equals(XActRelationshipEntryRelationship.SUBJ)) {
				// Get the ed and update it with the reference
				final var ed = er.getAct().getText();
				return ed.xmlContent;
			}
		}
		return null;
	}

	/**
	 * Returns the text of a comment from a given list of MDHT EntryRelationship
	 * objects and sets the text reference.
	 *
	 * @param e
	 *            the EntryRelationship list
	 * @param contentId
	 *            the content id for the text reference
	 * @return the tet of the comment
	 */
	public static String getCommentText(List<POCDMT000040EntryRelationship> e, String contentId) {
		for (final POCDMT000040EntryRelationship er : e) {
			if (er.getTypeCode().equals(XActRelationshipEntryRelationship.SUBJ)) {
				// Get the ed and update it with the reference
				final var ed = er.getAct().getText();
				ed.setReference(Util.createReferenceTel(contentId));
				return ed.xmlContent;
			}
		}
		return null;
	}

	/**
	 * Gets the current directory.
	 *
	 * @return the current directory
	 */
	public static String getCurrentDirectory() {
		var retVal = "";
		var temp = new File(retVal);
		if (temp != null)
			retVal = temp.getAbsolutePath();

		if (!retVal.endsWith(FileUtil.getPlatformSpecificPathSeparator()))
			retVal += FileUtil.getPlatformSpecificPathSeparator();
		return retVal;
	}

	/**
	 * <div class="en">Gets the e mail from an ArrayList of TEL.</div>
	 * <div class="de">Liefert e mail aus einer ArrayList of TEL.</div>
	 *
	 * @param telecoms
	 *            <br>
	 *            <div class="en"> the telecoms</div>
	 * @return <div class="en">the e mail</div>
	 */
	public static Map<String, TelecomAddressUse> getEMail(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_EMAIL_PREFIX);
	}

	/**
	 * <div class="en">Gets the fax from an ArrayList of TEL.</div>
	 * <div class="de">Liefert cax aus einer ArrayList von TEL.</div>
	 *
	 * @param telecoms
	 *            <br>
	 *            <div class="en">the telecoms</div>
	 * @return <div class="en">the fax</div>
	 */
	public static Map<String, TelecomAddressUse> getFax(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_FAX_PREFIX);
	}

	/**
	 * <div class="en">Gets the e mail from an ArrayList of TEL.</div>
	 * <div class="de">Liefert e mail aus einer ArrayList von TEL.</div>
	 *
	 * @param telecoms
	 *            <br>
	 *            <div class="en">the telecoms</div>
	 * @return <div class="en">the phone</div>
	 */
	public static Map<String, TelecomAddressUse> getPhones(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_PHONE_PREFIX);
	}

	/**
	 * Gets the platform specific line break (\n as default; \r\n for Windows).
	 *
	 * @return the platform specific line break
	 */
	public static String getPlatformSpecificLineBreak() {
		var retVal = "\n";
		if (Util.isWindows())
			retVal = "\r\n";
		return retVal;
	}

	/**
	 * Gets the rsc directory (./rsc or ../rsc or specified by the command line
	 * argument rscdir).
	 *
	 * @return the rsc dir
	 */
	public static String getRscDir() {

		String rscDir = new File("").getAbsoluteFile().getAbsolutePath()
				+ FileUtil.getPlatformSpecificPathSeparator() + "rsc";
		if (!(new File(rscDir)).exists())
			rscDir = new File("").getAbsoluteFile().getAbsolutePath()
					+ FileUtil.getPlatformSpecificPathSeparator() + ".."
					+ FileUtil.getPlatformSpecificPathSeparator() + "rsc";

		final var runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		final List<String> vmArgs = runtimeMxBean.getInputArguments();
		for (final String vmArg : vmArgs) {
			if (vmArg.toLowerCase().startsWith("-drscdir=")) {
				rscDir = vmArg.substring(9, vmArg.length());
			}
		}

		if (!rscDir.endsWith(FileUtil.getPlatformSpecificPathSeparator()))
			rscDir += FileUtil.getPlatformSpecificPathSeparator();

		if (!(new File(rscDir)).exists())
			throw new RuntimeException("rsc dir not found (" + rscDir + ")");
		else
			return rscDir;
	}

	/**
	 * <div class="en">Gets the system fonts paths in relation to the current
	 * OS. This is where all the fonts must be found in order to embed them into
	 * the PDF/A document.</div>
	 *
	 * @return <div class="en">the system fonts paths</div>
	 */
	public static List<String> getSystemFontsPaths() {
		List<String> result = new ArrayList<>();
		if (SystemUtils.IS_OS_WINDOWS) {
			String path = System.getenv("WINDIR");
			result.add(path + "\\" + "Fonts");
			return result;
		} else if (SystemUtils.IS_OS_MAC_OSX || SystemUtils.IS_OS_MAC) {
			result.add(System.getProperty("user.home") + File.separator + "Library/Fonts");
			result.add("/Library/Fonts");
			result.add("/System/Library/Fonts");
			return result;
		} else if (SystemUtils.IS_OS_LINUX) {
			String[] pathsToCheck = { System.getProperty("user.home") + File.separator + ".fonts",
					"/usr/share/fonts/truetype", "/usr/share/fonts/TTF" };
			ArrayList<String> resultList = new ArrayList<>();

			for (int i = pathsToCheck.length - 1; i >= 0; i--) {
				String path = pathsToCheck[i];
				File tmp = new File(path);
				if (tmp.exists() && tmp.isDirectory() && tmp.canRead()) {
					resultList.add(path);
				}
			}
		}
		return result;
	}

	/**
	 * Extracts a HashMap<String, AddressUse> with a given Type from a given eHC
	 * ArrayList<TEL>.
	 *
	 * @param telecoms
	 *            the List with unsorted MDHT TEL objects
	 * @param type
	 *            the type of telecommunication endpoint that should be
	 *            extracted
	 * @return the HashMap with TEL objects of the given type
	 */
	private static Map<String, TelecomAddressUse> getTelecomType(List<TEL> telecoms, String type) {
		final Map<String, TelecomAddressUse> tl = new HashMap<>();
		for (final TEL tel : telecoms) {
			if (tel.getValue().toLowerCase().contains(type)) {
				tl.put(tel.getValue(),
						(!tel.getUse().isEmpty()
								? TelecomAddressUse.getEnum(tel.getUse().get(0))
								: null));
			}
		}
		return tl;
	}

	/**
	 * <div class="en">Gets a temp folder for output files. If you set an
	 * environment variable with the name 'eHCTempPath' the eHealth Connector
	 * will use the path specified in this environment variable. If no such
	 * environment variable is set, it will try to use /temp. If the path is not
	 * writable the eHealth Connector will use the system temp folder.
	 *
	 * @return path to temp folder</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public static String getTempDirectory() {
		final String envVariable = "eHCTempPath";
		String tempDirectoryPath = null;

		final Logger log = LogManager.getLogger(Util.class);

		try {
			final String env = System.getenv(envVariable);
			if (env != null) {
				tempDirectoryPath = env;
				log.debug("Trying to use temp folder set by environment variable '" + envVariable
						+ "': " + tempDirectoryPath);
			} else {
				tempDirectoryPath = FileUtil.getPlatformSpecificPathSeparator() + "temp";
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
	 *
	 * Gets the used memory as string for display e.g. to console.
	 *
	 * @param hint
	 *            to be added to the string
	 * @return the used memory string
	 */
	public static String getUsedMemoryString(String hint) {

		return hint + ": Used VM memory: " + Long.toString(getVmMemoryUsedInMegaBytes()) + " MB\n";

	}

	/**
	 * Gets the utf 8 input stream from file.
	 *
	 * @param file
	 *            the file
	 * @return the utf 8 input stream from file
	 */
	public static InputStream getUtf8InputStream(File file) {
		try {
			return getUtf8InputStream(new FileInputStream(file));
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Gets the utf 8 input stream from file.
	 *
	 * @param fis
	 *            the fis
	 * @return the utf 8 input stream from file
	 */
	public static InputStream getUtf8InputStream(FileInputStream fis) {
		try {
			return IOUtils.toInputStream(IOUtils.toString(new InputStreamReader(fis, Charsets.UTF_8)),
					Charsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Gets the utf 8 input stream from file.
	 *
	 * @param is
	 *            the is
	 * @return the utf 8 input stream from file
	 */
	public static InputStream getUtf8InputStream(InputStream is) {
		try {
			return IOUtils.toInputStream(IOUtils.toString(new InputStreamReader(is, Charsets.UTF_8)),
					Charsets.UTF_8);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * Gets the utf 8 input stream from file.
	 *
	 * @param fileName
	 *            the file name
	 * @return the utf 8 input stream from file
	 */
	public static InputStream getUtf8InputStream(String fileName) {
		return getUtf8InputStream(new File(fileName));
	}

	/**
	 * Gets the free Java VM heap space in mega bytes.
	 *
	 * @return the free Java VM heap space in mega bytes.
	 */
	public static int getVmMemoryFreeInMegaBytes() {
		return (int) (Runtime.getRuntime().freeMemory() / (1024 * 1024));
	}

	/**
	 * Gets the total Java VM heap space in mega bytes.
	 *
	 * @return the total Java VM heap space in mega bytes.
	 */
	public static int getVmMemoryTotalInMegaBytes() {
		return (int) (Runtime.getRuntime().totalMemory() / (1024 * 1024));
	}

	/**
	 * Gets the used Java VM heap space in mega bytes.
	 *
	 * @return the used Java VM heap space in mega bytes.
	 */
	public static int getVmMemoryUsedInMegaBytes() {
		return (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())
				/ (1024 * 1024));
	}

	/**
	 * <div class="en">Gets the website from an ArrayList of TEL.</div>
	 * <div class="de">Liefert die Webseite aus einer ArrayList von TEL.</div>
	 *
	 * @param telecoms
	 *            <br>
	 *            <div class="en">the telecoms</div>
	 * @return <div class="en">the webside</div>
	 */
	public static Map<String, TelecomAddressUse> getWebsites(List<TEL> telecoms) {
		return getTelecomType(telecoms, TELECOMS_WEBSITE_PREFIX);
	}

	/**
	 * <div class="en">Creates an MDHT II object.</div>
	 *
	 * @param root
	 *            <br>
	 *            <div class="en">the root</div>
	 * @return the II
	 */
	public static II ii(String root) {
		final var ii = new II();
		ii.setRoot(root);
		return ii;
	}

	/**
	 * Inits the logger.
	 *
	 * @param myClass
	 *            the my class
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@SuppressWarnings("rawtypes")
	public static void initLogger(Class myClass) throws MalformedURLException {
		initLogger(Util.getRscDir(), myClass);
	}

	/**
	 * Inits the logger.
	 *
	 * @param rscDir
	 *            the rsc dir
	 * @param myClass
	 *            the my class
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 */
	@SuppressWarnings("rawtypes")
	public static void initLogger(String rscDir, Class myClass) throws MalformedURLException {
		// Init
		String log4jConfigFn = null;
		final var runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		final List<String> vmArgs = runtimeMxBean.getInputArguments();
		for (final String vmArg : vmArgs) {
			if (vmArg.toLowerCase().startsWith("-dlog4j.configuration=")) {
				log4jConfigFn = vmArg.substring(22, vmArg.length());
			}
		}

		URL res = null;

		File logConfig = null;

		// use the log4j config given by the -Dlog4j.configuration vm
		// argument
		if (log4jConfigFn != null)
			logConfig = new File(log4jConfigFn);

		// use default log4j config
		// Logfile: logs/ehealthconnectordemo.log
		if (logConfig == null) {
			logConfig = new File(rscDir + "log4jConfigs/log4j.xml".replace("/",
					FileUtil.getPlatformSpecificPathSeparator()));
		}
		if (!logConfig.exists()) {
			logConfig = new File(Util.getCurrentDirectory() + "rsc/log4jConfigs/log4j.xml"
					.replace("/", FileUtil.getPlatformSpecificPathSeparator()));
		}
		if (!logConfig.exists()) {
			logConfig = new File(Util.getCurrentDirectory() + "../rsc/log4jConfigs/log4j.xml"
					.replace("/", FileUtil.getPlatformSpecificPathSeparator()));
		}
		if (!logConfig.exists()) {
			logConfig = new File(
					Util.getCurrentDirectory() + "src/main/resources/log4jConfigs/log4j.xml"
							.replace("/", FileUtil.getPlatformSpecificPathSeparator()));
		}
		if (!logConfig.exists()) {
			res = myClass.getResource("log4jConfigs/log4j.xml");
		} else {
			res = logConfig.toURI().toURL();
		}
		if (res == null) {
			System.out.print("***ERROR: No valid log4j config selected\n\n");
		} else {
			log4jConfigFn = res.getFile();
			DOMConfigurator.configure(res);

			Util.enableImmediateLogging(LogManager.getLogger(myClass));
			System.out.print("log4j config: " + log4jConfigFn + "\n");
		}

		if (LogManager.getLogger(myClass) == null)
			System.out.print("***ERROR: No valid log4j config selected\n\n");

	}

	/**
	 * Checks if an EntryRelationship is a comment.
	 *
	 * @param er
	 *            the EntryRelationship
	 * @return true if the EntryRelationship is a comment, false otherwise
	 */
	public static boolean isComment(POCDMT000040EntryRelationship er) {
		return er.getTypeCode().equals(XActRelationshipEntryRelationship.SUBJ) && er.isInversionInd() != null
				&& er.isInversionInd().booleanValue();
	}

	/**
	 * This is for debugging purposes, only. For normal use, this function shall
	 * return false.
	 *
	 * Debug examples: memory usage is to be displayed, make CDA contents
	 * comparable to previous releases
	 *
	 * @return true, when Debug mode is on. false for normal usage.
	 */
	public static boolean isDebug() {
		return false;
	}

	/**
	 * Detects whether the current platform is Mac.
	 *
	 * @return true for Mac platforms; false otherwise
	 */
	public static boolean isMac() {

		return (System.getProperty("os.name").toLowerCase().indexOf("mac") >= 0);

	}

	/**
	 * Detects whether the current platform is Solaris.
	 *
	 * @return true for Solaris platforms; false otherwise
	 */
	public static boolean isSolaris() {

		return (System.getProperty("os.name").toLowerCase().indexOf("sunos") >= 0);

	}

	/**
	 * Detects whether the current platform is Unix.
	 *
	 * @return true for Unix platforms; false otherwise
	 */
	public static boolean isUnix() {

		return ((System.getProperty("os.name").toLowerCase().indexOf("nix") >= 0)
				|| (System.getProperty("os.name").toLowerCase().indexOf("nux") >= 0)
				|| (System.getProperty("os.name").toLowerCase().indexOf("aix") >= 0));

	}

	/**
	 * Detects whether the current platform is Windows.
	 *
	 * @return true for Windows platforms; false otherwise
	 */
	public static boolean isWindows() {

		return (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0);

	}

	/**
	 * <div class="en">Join an ArrayList of String with person names to a whole
	 * name</div>.
	 *
	 * @param nameList
	 *            <br>
	 *            <div class="en"> name list</div>
	 * @param delimiter
	 *            <br>
	 *            <div class="en"> delimiter</div>
	 * @return the string
	 */
	public static String join(List<String> nameList, String delimiter) {
		if ((nameList == null) || nameList.isEmpty()) {
			return "";
		}

		final var builder = new StringBuilder();
		final Iterator<String> iter = nameList.iterator();
		// String string = iter.next();
		// if ("".equals(string)) {
		// builder = new StringBuilder(iter.next());
		// } else {
		// builder = new StringBuilder(iter.next());
		// }
		while (iter.hasNext()) {
			final var string = iter.next();
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
	 * name</div>.
	 *
	 * @param list
	 *            <br>
	 *            <div class="en">the list</div>
	 * @return the string
	 */
	public static String joinEListStr(List<ENXP> list) {
		if (list.isEmpty()) {
			return "";
		}
		final String names = list.get(0).xmlContent;
		if (list.size() > 1) {
			final List<String> nameList = new ArrayList<>();
			for (var i = 0; i < list.size(); i++) {
				nameList.add(list.get(i).xmlContent);
			}
			return Util.join(nameList, " ");
		}
		return names;
	}

	/**
	 * Logs the available memory.
	 *
	 * @param theClass
	 *            the the class Class to be used in the Log4J log
	 * @param hint
	 *            the hint hint to be added to the log message
	 */
	public static void logAvailableMemory(@SuppressWarnings("rawtypes") Class theClass,
			String hint) {

		final Logger log = LogManager.getLogger(theClass);
		freeMemory();
		log.info(
				hint + ": freeMemory: " + Long.toString(Util.getVmMemoryFreeInMegaBytes()) + " MB");

	}

	/**
	 * Runs the given external command.
	 *
	 * @param cmd
	 *            the command to run
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws InterruptedException
	 *             the interrupted exception
	 */
	public static void runExternalCommand(String cmd) throws IOException, InterruptedException {
		// String homeDirectory = System.getProperty("user.home");
		Process process;
		process = Runtime.getRuntime().exec(cmd);
		StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(),
				System.out::println);
		final ExecutorService ex = Executors.newSingleThreadExecutor();
		ex.submit(streamGobbler);
		int exitCode = process.waitFor();
		ex.shutdown();
		assert exitCode == 0;
	}

	/**
	 * <div class="en">Creates an MDHT ST</div>.
	 *
	 * @param text
	 *            <br>
	 *            <div class="de">the text</div>
	 * @return the st
	 */
	public static ST st(String text) {
		final var value = new ST();
		value.xmlContent = text;
		return value;
	}

	/**
	 * Converts the given string to an InputStream.
	 *
	 * @param inputStr
	 *            the input string
	 * @return the input stream
	 */
	public static InputStream string2InputStream(String inputStr) {
		return new ByteArrayInputStream(inputStr.getBytes(StandardCharsets.UTF_8));
	}

	public static Random getRand() {
		return rand;
	}

	public static void setRand(Random rand) {
		Util.rand = rand;
	}

}
