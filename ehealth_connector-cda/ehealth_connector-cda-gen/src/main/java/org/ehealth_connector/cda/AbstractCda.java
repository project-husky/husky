/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
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

package org.ehealth_connector.cda;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.Charsets;
import org.apache.commons.lang3.NotImplementedException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMap.Entry;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.ecore.xml.type.impl.ProcessingInstructionImpl;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Code;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Organization;
import org.ehealth_connector.common.mdht.Patient;
import org.ehealth_connector.common.mdht.Person;
import org.ehealth_connector.common.mdht.enums.ConfidentialityCode;
import org.ehealth_connector.common.mdht.enums.EhcVersions;
import org.ehealth_connector.common.mdht.enums.ParticipantType;
import org.ehealth_connector.common.mdht.enums.Signature;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtilOld;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.AssignedCustodian;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.AssociatedEntity;
import org.openhealthtools.mdht.uml.cda.Authenticator;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.Authorization;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Consent;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.CustodianOrganization;
import org.openhealthtools.mdht.uml.cda.DocumentRoot;
import org.openhealthtools.mdht.uml.cda.InFulfillmentOf;
import org.openhealthtools.mdht.uml.cda.InformationRecipient;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.IntendedRecipient;
import org.openhealthtools.mdht.uml.cda.LegalAuthenticator;
import org.openhealthtools.mdht.uml.cda.Order;
import org.openhealthtools.mdht.uml.cda.ParentDocument;
import org.openhealthtools.mdht.uml.cda.Participant1;
import org.openhealthtools.mdht.uml.cda.PatientRole;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.RelatedDocument;
import org.openhealthtools.mdht.uml.cda.internal.resource.CDAResource;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClass;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassAssociative;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipDocument;
import org.openhealthtools.mdht.uml.hl7.vocab.x_InformationRecipient;

/**
 * The implementation of the HL7 CDA R2 (2005) Standard.
 *
 * @param <EClinicalDocument>
 *            the generic type
 */
public abstract class AbstractCda<EClinicalDocument extends ClinicalDocument>
		extends MdhtFacade<EClinicalDocument> {

	/**
	 * This comparator allows to make sure that the top level XML content always
	 * appear in the same order (this simplifies comparison of CDA contents with
	 * previous releases).
	 */
	private class FeatureMapEntryComparator implements Comparator<Entry> {

		/**
		 *
		 * Compares two FeatureMap Entries. ProcessingInstructions based on
		 * their data content.
		 *
		 * {@inheritDoc}
		 *
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Entry a, Entry b) {
			if (a.getValue().getClass() == b.getValue().getClass()) {
				if (a.getValue() instanceof ProcessingInstructionImpl) {
					return ((ProcessingInstructionImpl) a.getValue()).getData()
							.compareTo(((ProcessingInstructionImpl) b.getValue()).getData());
				} else if (a.getValue() instanceof String) {
					return ((String) a.getValue()).compareTo(((String) b.getValue()));
				} else
					throw new NotImplementedException(a.getValue().getClass().getName());
			} else
				return a.getValue().getClass().getName()
						.compareTo(b.getValue().getClass().getName());
		}
	}

	/** The document root. */
	private DocumentRoot docRoot;

	/** The "perform narrative text generation" indicator. */
	private boolean performNarrativeTextGeneration = true;

	/**
	 * <div class="en">Constructor for HL7 CDA documents</div>
	 * <div class="de">Erstellt ein HL7 CDA Dokument</div>
	 * <div class="fr"></div>.
	 *
	 * @param doc
	 *            the CDA Object in its MDHT representation
	 */
	public AbstractCda(EClinicalDocument doc) {
		super(doc);
		// Set the eHealthConnector comment
		docRoot = CDAFactory.eINSTANCE.createDocumentRoot();
		FeatureMapUtil.addComment(docRoot.getMixed(), 0, generateComment());
		// set xml namespaces
		docRoot.getXMLNSPrefixMap().put("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		docRoot.getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);
		docRoot.setClinicalDocument(doc);
		sortXmlHeader();

	}

	/**
	 * <div class="en">Constructor that includes a stylesheet and a cascasing
	 * stylesheet into the document processing instructions and initalizes the
	 * standard document attributes.</div> <div class="de">Erzeugt ein CdaCh
	 * Objekt (CDA Header nach schweizer Spezifikation)</div>
	 * <div class="fr"></div>
	 *
	 * @param doc
	 *            the CDA Object in its MDHT representation
	 * @param languageCode
	 *            the language code
	 * @param stylesheet
	 *            the stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 * @param css
	 *            the Cascasing stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 */
	public AbstractCda(EClinicalDocument doc, LanguageCode languageCode, String stylesheet,
			String css) {
		this(doc);
		if (css != null) {
			addCss(css);
		}
		addStylesheet(stylesheet);
		setLanguageCode(languageCode);
		initCda();
		sortXmlHeader();
	}

	/**
	 * Adds the authenticator.
	 *
	 * @param authenticator
	 *            the authenticator
	 */
	public void addAuthenticator(Authenticator authenticator) {
		getDoc().getAuthenticators().add(authenticator);
	}

	/**
	 * <div class="en">Adds an authenricator to the CDA document</div>
	 * <div class="de">Fügt dem CDA Dokument einen Unterzeichner hinzu</div>.
	 *
	 * @param author
	 *            Unterzeichner
	 */
	public void addAuthenticator(org.ehealth_connector.common.mdht.Author author) {
		final Authenticator auth = CDAFactory.eINSTANCE.createAuthenticator();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		auth.setAssignedEntity(entity);
		auth.setTime(EcoreUtil.copy(author.getAuthorMdht().getTime()));
		entity.setAssignedPerson(author.copyMdhtAuthor().getAssignedAuthor().getAssignedPerson());

		getDoc().getAuthenticators().add(auth);
	}

	/**
	 * <div class="en">Adds an authenticator to the CDA document</div>
	 * <div class="de">Fügt dem CDA Dokument einen Unterzeichner hinzu</div>.
	 *
	 * @param authenticator
	 *            Unterzeichner
	 * @param authenticationTime
	 *            Zeitpunkt der Unterzeichnung
	 */
	public void addAuthenticator(Person authenticator, Date authenticationTime) {
		final Authenticator auth = CDAFactory.eINSTANCE.createAuthenticator();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		// Set time
		auth.setTime(DateUtilOld.ts(authenticationTime));

		// Set signature Code to 's'
		final CS cs = Signature.SIGNED.getCS();
		auth.setSignatureCode(cs);

		// Set assigned entity
		entity.getIds().add(DatatypesFactory.eINSTANCE.createII(NullFlavor.NA));
		entity.setAssignedPerson(authenticator.copyMdhtPerson());
		auth.setAssignedEntity(entity);

		getDoc().getAuthenticators().add(auth);
	}

	/**
	 * <div class="en">Adds an author</div> <div class="de">Fügt einen Autoren
	 * hinzu</div>.
	 *
	 * @param author
	 *            the autor
	 * @return the author
	 */
	/**
	 * @param author
	 * @return the added MDHT Author
	 */
	public Author addAuthor(org.ehealth_connector.common.mdht.Author author) {
		final Author docAuthor = author.copyMdhtAuthor();
		getDoc().getAuthors().add(docAuthor);
		return docAuthor;
	}

	/**
	 * Adds the authorization consent.
	 *
	 * @param narrativeConsent
	 *            the narrative consent
	 */
	public void addAuthorizationConsent(String narrativeConsent) {
		Authorization authorization = CDAFactory.eINSTANCE.createAuthorization();
		Consent consent = CDAFactory.eINSTANCE.createConsent();
		CE code = DatatypesFactory.eINSTANCE.createCE(null, "2.16.756.5.30.2.1.1.2");
		code.setNullFlavor(NullFlavor.OTH);
		code.setOriginalText(DatatypesFactory.eINSTANCE.createED(narrativeConsent));
		consent.setCode(code);
		consent.setStatusCode(StatusCode.COMPLETED.getCS());
		authorization.setConsent(consent);
		getDoc().getAuthorizations().add(authorization);
	}

	/**
	 * <div class="en">Adds a cascading stylesheet (CSS) to the XML processing
	 * instructions</div> <div class="de">Fügt ein Cascading Stylesheet (CSS) zu
	 * den XML Processing Instructions hinzu</div>.
	 *
	 * @param css
	 *            path of the CSS file
	 */
	public void addCss(String css) {
		// Add the stylesheet processing instructions to the document
		FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(), 0, "xml-stylesheet",
				"type=\"text/css\" href=\"" + css + "\"");
	}

	/**
	 * Adds the employer.
	 *
	 * @param employer
	 *            the employer
	 * @param employeeId
	 *            the employee id
	 */
	public void addEmployer(Organization employer, Identificator employeeId) {
		addParticipant(employer, employeeId, ParticipantType.Employer);
	}

	/**
	 * <div class="en">Adds an inFulfillmentOf reference to another
	 * document</div> <div class="de">Weist dem Dokument eine ID eines anderen
	 * Dokumentes zu, auf das es sich bezieht</div>.
	 *
	 * @param id
	 *            of the referenced document
	 */
	public void addInFulfillmentOfOrder(Identificator id) {
		final InFulfillmentOf ifo = CDAFactory.eINSTANCE.createInFulfillmentOf();
		final Order o = CDAFactory.eINSTANCE.createOrder();
		o.getIds().add(id.getIi());

		ifo.setOrder(o);
		getDoc().getInFulfillmentOfs().add(ifo);
	}

	/**
	 * <div class="en">Adds a insurance organization</div> <div class="de">Fügt
	 * eine Versicherung hinzu</div>.
	 *
	 * @param versicherung
	 *            the insurance organization
	 * @param insurantId
	 *            the insurant id
	 */
	public void addInsurance(Organization versicherung, Identificator insurantId) {
		addParticipant(versicherung, insurantId, ParticipantType.Insurance);
	}

	/**
	 * Adds the other recipient.
	 *
	 * @param organization
	 *            the organization
	 * @return the information recipient
	 */
	public InformationRecipient addOtherRecipient(Organization organization) {

		InformationRecipient recipient = CDAFactory.eINSTANCE.createInformationRecipient();
		recipient.setTypeCode(x_InformationRecipient.TRC);
		IntendedRecipient ir = CDAFactory.eINSTANCE.createIntendedRecipient();
		ir.setReceivedOrganization(organization.getMdhtOrganization());
		recipient.setIntendedRecipient(ir);
		getDoc().getInformationRecipients().add(recipient);
		return recipient;
	}

	/**
	 * <div class="en">Adds a participant</div> <div class="de">Fügt dem CDA
	 * Dokument einen Teilnehmer hinzu</div>.
	 *
	 * @param organization
	 *            Organisation
	 * @param participationId
	 *            the participation id
	 * @param participantType
	 *            <div class="en">Kind of participation (e.g. insurance)</div>
	 *            <div class="de">Art der Partizipation (z.B.
	 *            Versicherung)</div>
	 * @return the participant 1
	 */
	public Participant1 addParticipant(Organization organization, Identificator participationId,
			ParticipantType participantType) {
		return addParticipant(organization, participationId, participantType, null);
	}

	/**
	 * <div class="en">Adds a participant</div> <div class="de">Fügt dem CDA
	 * Dokument einen Teilnehmer hinzu</div>.
	 *
	 * @param organization
	 *            Organisation
	 * @param participationId
	 *            the participation id
	 * @param participantType
	 *            <div class="en">Kind of participation (e.g. insurance)</div>
	 *            <div class="de">Art der Partizipation (z.B.
	 *            Versicherung)</div>
	 * @param roleCode
	 *            <div class="en">Role of participation (e.g. insurance law).
	 *            Important note: this attribute will be ignored for employers,
	 *            as their role is defined by IHE</div> <div class="de">Rolle
	 *            der Partizipation (z.B. Versicherungsgesetz). Wichtiger
	 *            Hinweis: Dieses Attribut wird bei Arbeitgebern ignoriert, weil
	 *            deren Rolle durch IHE definiert ist.</div>
	 * @return the participant 1
	 */
	public Participant1 addParticipant(Organization organization, Identificator participationId,
			ParticipantType participantType, Code roleCode) {
		final Participant1 participant = CDAFactory.eINSTANCE.createParticipant1();
		getDoc().getParticipants().add(participant);
		final AssociatedEntity assEnt = CDAFactory.eINSTANCE.createAssociatedEntity();

		final org.openhealthtools.mdht.uml.cda.Organization docOrganization = organization
				.getMdhtOrganization();
		assEnt.setScopingOrganization(docOrganization);

		if (participationId != null) {
			assEnt.getIds().clear();
			assEnt.getIds().add(participationId.getIi());
		}

		switch (participantType) {
		case Employer:
			participant.setTypeCode(ParticipationType.IND);
			assEnt.setClassCode(RoleClassAssociative.CON);
			assEnt.setCode(
					new Code("1.3.5.1.4.1.19376.1.5.3.3", "EMPLOYER", "Employer", "IHERoleCode")
							.getCE());
			break;
		case Insurance:
			participant.setTypeCode(ParticipationType.COV);
			assEnt.setClassCode(RoleClassAssociative.PAYOR);
			if (roleCode != null)
				assEnt.setCode(roleCode.getCE());
			break;
		default:
			break;
		}

		participant.setAssociatedEntity(assEnt);
		return participant;

	}

	/**
	 * <div class="en">Adds a stylesheet to the XML processing
	 * instructions</div> <div class="de">Fügt ein Stylesheet zu den XML
	 * Processing Instructions hinzu</div>.
	 *
	 * @param stylesheet
	 *            Path to the stylesheet (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl')
	 */
	public void addStylesheet(String stylesheet) {
		if (stylesheet != null) {
			// Add the stylesheet processing instructions to the document
			FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(), 0, "xml-stylesheet",
					"type=\"text/xsl\" href=\"" + stylesheet + "\"");
		}
	}

	/**
	 * Switch automatic generation of narrative text off.
	 */
	public void disableNarrativeTextGeneration() {
		performNarrativeTextGeneration = false;
	}

	/**
	 * Switch automatic generation of narrative text on.
	 */
	public void enableNarrativeTextGeneration() {
		performNarrativeTextGeneration = true;
	}

	/**
	 * Generate comment.
	 *
	 * @return the string
	 */
	private String generateComment() {
		return "Document based on CDA R2 generated by "
				+ EhcVersions.getCurrentVersion().getSystemVersionName() + ", Release Date "
				+ EhcVersions.getCurrentVersion().getReleaseDate();
	}

	/**
	 * <div class="en">Returns a list of authenticators of this document</div>
	 * <div class="de">Gibt alle Unterzeichner des Dokuments zurück</div>.
	 *
	 * @return <div class="en">the authenticators</div> <div class="de">die
	 *         Unterzeichner</div>
	 */
	public List<org.ehealth_connector.common.mdht.Person> getAuthenticators() {
		final List<org.ehealth_connector.common.mdht.Person> persons = new ArrayList<org.ehealth_connector.common.mdht.Person>();
		for (final Authenticator mAutor : getDoc().getAuthenticators()) {
			final org.ehealth_connector.common.mdht.Person person = new org.ehealth_connector.common.mdht.Person(
					mAutor.getAssignedEntity().getAssignedPerson());
			persons.add(person);
		}
		return persons;
	}

	/**
	 * Gets the authenticators as author.
	 *
	 * @return the authenticators as author
	 */
	public List<org.ehealth_connector.common.mdht.Author> getAuthenticatorsAsAuthor() {
		List<org.ehealth_connector.common.mdht.Author> retVal = new ArrayList<org.ehealth_connector.common.mdht.Author>();

		for (final Authenticator authenticator : getDoc().getAuthenticators()) {
			org.ehealth_connector.common.mdht.Author author = new org.ehealth_connector.common.mdht.Author(
					Util.createAuthorFromAuthenticator(authenticator));
			retVal.add(author);
		}
		return retVal;
	}

	/**
	 * <div class="en">Returns the (first) author of the document</div>
	 * <div class="de">Gibt den (ersten) Autor des Dokuments zurück</div>.
	 *
	 * @return the author
	 */
	public org.ehealth_connector.common.mdht.Author getAuthor() {
		final org.ehealth_connector.common.mdht.Author author = new org.ehealth_connector.common.mdht.Author(
				getDoc().getAuthors().get(0));
		return author;
	}

	/**
	 * Gets the authorization consents as strings.
	 *
	 * @return the authorization consents
	 */
	public List<String> getAuthorizationConsents() {
		List<String> retVal = new ArrayList<String>();
		for (Authorization item : getDoc().getAuthorizations()) {
			retVal.add(item.getConsent().getCode().getOriginalText().getText());
		}
		return retVal;
	}

	/**
	 * <div class="en">Returns all authors of the document</div>
	 * <div class="de">Gibt alle Autoren des Dokuments zurück</div>.
	 *
	 * @return list of authors
	 */
	public List<org.ehealth_connector.common.mdht.Author> getAuthors() {
		final List<org.ehealth_connector.common.mdht.Author> authors = new ArrayList<org.ehealth_connector.common.mdht.Author>();
		for (final Author mAutor : getDoc().getAuthors()) {
			final org.ehealth_connector.common.mdht.Author author = new org.ehealth_connector.common.mdht.Author(
					mAutor);
			authors.add(author);
		}
		return authors;
	}

	/**
	 * <div class="en">Gets the Confidentially Code</div>
	 * <div class="de"></div>.
	 *
	 * @return code
	 */
	public ConfidentialityCode getConfidentialityCode() {
		if (getDoc().getConfidentialityCode() != null) {
			return ConfidentialityCode.getEnum(getDoc().getConfidentialityCode().getCode());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the custodian</div> <div class="de">Gibt den
	 * Verantwortlichen für das Dokument zurück</div>.
	 *
	 * @return das openHealthTools Custodian Objekt
	 */
	public Custodian getCustodian() {
		return getDoc().getCustodian();
	}

	/**
	 * Returns a new Organization object based on the
	 * custodian/representedOrganization object (name, ids, addr, telecoms will
	 * be copied).
	 *
	 * @return the Organization
	 */
	public Organization getCustodianAsOrganization() {
		final Custodian mdhtC = getMdht().getCustodian();
		AssignedCustodian mdhtAC = null;
		if (mdhtC != null) {
			mdhtAC = mdhtC.getAssignedCustodian();
		}
		CustodianOrganization mdhtCO = null;
		if (mdhtAC != null) {
			mdhtCO = mdhtAC.getRepresentedCustodianOrganization();
		}

		if (mdhtCO != null) {
			return new Organization(Util.createOrganizationFromCustodianOrganization(mdhtCO));
		}
		return null;
	}

	/**
	 * Gets the data enterer.
	 *
	 * @return the data enterer
	 */
	public DataEnterer getDataEnterer() {
		if (getDoc().getDataEnterer() != null) {
			return new DataEnterer(getDoc().getDataEnterer());
		}
		return null;
	}

	/**
	 * Gets the data enterer person.
	 *
	 * @return the data enterer person
	 */
	public org.ehealth_connector.common.mdht.Person getDataEntererPerson() {
		if (getDoc().getDataEnterer() != null) {
			if (getDoc().getDataEnterer().getAssignedEntity() != null) {
				if (getDoc().getDataEnterer().getAssignedEntity().getAssignedPerson() != null) {
					final org.ehealth_connector.common.mdht.Person person = new org.ehealth_connector.common.mdht.Person(
							getDoc().getDataEnterer().getAssignedEntity().getAssignedPerson());
					return person;
				}
			}
		}
		return null;
	}

	/**
	 * Method to get the document.
	 *
	 * @return the doc
	 */
	public EClinicalDocument getDoc() {
		return this.getMdht();
	}

	/**
	 * <div class="en">Gets the document root (which helds the cda
	 * document)</div>.
	 *
	 * @return the document root
	 */
	public DocumentRoot getDocRoot() {
		return this.docRoot;
	}

	/**
	 * <div class="en">Gets the identifier of the document which was replaced by
	 * the current one (see e.g. &lt;CH-VACD-REPL&gt;)</div>
	 * <div class="de"></div> <div class="fr"></div>
	 *
	 * @return <div class="en">identifier of the document which was replaced by
	 *         the current one</div> <div class="de"></div>
	 *         <div class="fr"></div>
	 */
	public Identificator getDocumentToReplaceIdentifier() {
		if ((this.getMdht().getRelatedDocuments() != null)
				&& (getMdht().getRelatedDocuments().size() > 0)) {
			final RelatedDocument relatedDocument = getMdht().getRelatedDocuments().get(0);
			if ((relatedDocument != null) && (relatedDocument.getParentDocument() != null)) {
				final ParentDocument parentDocument = relatedDocument.getParentDocument();
				return new Identificator(parentDocument.getIds().get(0));
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets all employers</div> <div class="de">Gibt alle
	 * Arbeitgeber zurück</div>.
	 *
	 * @return arraylist of organizations
	 */
	public List<Organization> getEmployers() {
		final List<Organization> organizations = new ArrayList<Organization>();
		for (final Participant1 part : getDoc().getParticipants()) {
			if (part.getTypeCode().equals(ParticipationType.IND)) {
				if (part.getAssociatedEntity() != null) {
					if (part.getAssociatedEntity().getClassCode()
							.equals(RoleClassAssociative.CON)) {
						CE ce = part.getAssociatedEntity().getCode();
						if (ce.getCodeSystem().equals("1.3.5.1.4.1.19376.1.5.3.3")
								&& ce.getCode().equals("EMPLOYER")) {
							final Organization org = new Organization(
									part.getAssociatedEntity().getScopingOrganization());
							organizations.add(org);
						}
					}
				}
			}
		}
		return organizations;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Identificator getId() {
		if (getDoc().getId() != null) {
			return new Identificator(getDoc().getId());
		}
		return null;
	}

	/**
	 * <div class="en">Returns a List of all inFulfillmentOf references to other
	 * documents</div> <div class="de">Gibt eine Liste aller Referenzen auf
	 * Dokumente zurück, auf welche sich dasDokument bezieht</div>.
	 *
	 * @return the in fulfillment ofs
	 */
	public List<Identificator> getInFulfillmentOfOrders() {
		List<Identificator> retVal = new ArrayList<Identificator>();
		for (InFulfillmentOf ifo : getDoc().getInFulfillmentOfs()) {
			for (II id : ifo.getOrder().getIds()) {
				retVal.add(new Identificator(id));
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets all insurances</div> <div class="de">Gibt alle
	 * Versicherungen zurück</div>.
	 *
	 * @return arraylist of organizations
	 */
	public List<Organization> getInsurances() {
		final List<Organization> organizations = new ArrayList<Organization>();
		for (final Participant1 part : getDoc().getParticipants()) {
			if (part.getTypeCode().equals(ParticipationType.COV)) {
				if (part.getAssociatedEntity() != null) {
					if (part.getAssociatedEntity().getClassCode()
							.equals(RoleClassAssociative.PAYOR)) {
						final Organization org = new Organization(
								part.getAssociatedEntity().getScopingOrganization());
						organizations.add(org);
					}
				}
			}
		}
		// ParticipantType.Insurance
		return organizations;
	}

	/**
	 * Gets the language code.
	 *
	 * @return the language code
	 */
	public LanguageCode getLanguageCode() {
		if (getDoc().getLanguageCode() != null) {
			return LanguageCode.getEnum(getDoc().getLanguageCode().getCode());
		}
		return null;
	}

	/**
	 * Gets the legal authenticator of the document <div class="de">Gibt den
	 * juristisch verantwortlichen Unterzeichner des Dokuments zurück</div>.
	 *
	 * @return the legal authenticator
	 */
	public Person getLegalAuthenticator() {
		final LegalAuthenticator la = getDoc().getLegalAuthenticator();

		if (la != null) {
			if ((la.getAssignedEntity() != null)
					&& (la.getAssignedEntity().getAssignedPerson() != null)) {
				final Person p = new Person(la.getAssignedEntity().getAssignedPerson());
				return p;
			}
		}
		return null;
	}

	/**
	 * Gets the legal authenticator of the document <div class="de">Gibt den
	 * juristisch verantwortlichen Unterzeichner des Dokuments als Autor Objekt
	 * zurück</div>.
	 *
	 * @return the legal authenticator as Author object
	 */
	public org.ehealth_connector.common.mdht.Author getLegalAuthenticatorAsAuthor() {
		final LegalAuthenticator la = getDoc().getLegalAuthenticator();

		if (la != null) {
			return new org.ehealth_connector.common.mdht.Author(
					Util.createAuthorFromLegalAuthenticator(la));
		}
		return null;
	}

	/**
	 * Gets the mdht primary recipient.
	 *
	 * @return the mdht primary recipient
	 */
	public InformationRecipient getMdhtPrimaryRecipient() {

		InformationRecipient retVal = null;
		for (InformationRecipient ir : getDoc().getInformationRecipients()) {
			if (ir.getTypeCode() == x_InformationRecipient.PRCP) {
				retVal = ir;
				break;
			}
		}
		return retVal;
	}

	/**
	 * Gets the other recipients.
	 *
	 * @return the other recipients
	 */
	public List<Organization> getOtherRecipients() {

		ArrayList<Organization> retVal = new ArrayList<Organization>();
		for (InformationRecipient ir : getDoc().getInformationRecipients()) {
			if (ir.getTypeCode() != x_InformationRecipient.PRCP) {
				if (ir.getIntendedRecipient() != null) {
					if (ir.getIntendedRecipient().getReceivedOrganization() != null) {
						retVal.add(new Organization(
								ir.getIntendedRecipient().getReceivedOrganization()));
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * Gets the CDA document as ByteArrayOutputStream.
	 *
	 * @return the output stream
	 */
	public OutputStream getOutputStream() {
		final OutputStream baos = new java.io.ByteArrayOutputStream();
		try {
			CDAUtil.save(getDoc(), baos);
		} catch (final Exception e) {
			e.printStackTrace();
		}
		return baos;
	}

	/**
	 * <div class="en">Gets all participating organizations</div>
	 * <div class="de">Gibt alle Teilnehmenden Organisationen zurück</div>.
	 *
	 * @return the arraylist of organizations
	 */
	public List<Organization> getParticipants() {
		final List<Organization> organizations = new ArrayList<Organization>();
		for (final Participant1 part : getDoc().getParticipants()) {
			final Organization org = new Organization(
					part.getAssociatedEntity().getScopingOrganization());
			organizations.add(org);
		}
		return organizations;
	}

	/**
	 * <div class="en">Gets the patient</div> <div class="de">Liefert den
	 * Patienten zurück</div>.
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		final Patient patient = new Patient(getDoc().getRecordTargets().get(0));
		return patient;
	}

	/**
	 * Gets the primary recipient.
	 *
	 * @return the primary recipient
	 */
	public Organization getPrimaryRecipient() {

		Organization retVal = null;
		for (InformationRecipient ir : getDoc().getInformationRecipients()) {
			if (ir.getTypeCode() == x_InformationRecipient.PRCP) {
				if (ir.getIntendedRecipient() != null) {
					if (ir.getIntendedRecipient().getReceivedOrganization() != null) {
						retVal = new Organization(
								ir.getIntendedRecipient().getReceivedOrganization());
						break;
					}
				}
			}
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the set Id</div>.
	 *
	 * @return the set id
	 */
	public Identificator getSetId() {
		if (getDoc().getSetId() != null) {
			return new Identificator(getDoc().getSetId().getRoot(),
					getDoc().getSetId().getExtension());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the timestamp</div>.
	 *
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		if (getDoc().getEffectiveTime() != null) {
			return DateUtilOld.parseDate(getDoc().getEffectiveTime());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the title</div>.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return getDoc().getTitle().getText();
	}

	/**
	 * <div class="en">Gets the version</div>.
	 *
	 * @return the version
	 */
	public int getVersion() {
		if (getDoc().getVersionNumber() != null) {
			return getDoc().getVersionNumber().getValue().intValue();
		}
		return 1;
	}

	/**
	 * <div class="en">Initializes the CdaCh document header defaults</div>.
	 */
	public abstract void initCda();

	/**
	 * Indicates whether narrative text generation is enabled or disabled.
	 *
	 * @return true when enabled; false when disabled
	 */
	public boolean isNarrativeTextGenerationEnabled() {
		return performNarrativeTextGeneration;
	}

	/**
	 * <div class="en">prints the XML representation of the document to the
	 * console</div> <div class="de">Gibt die XML-Repräsentation des Dokuments
	 * auf der Konsole aus</div>.
	 */
	public void printXmlToConsole() {
		try {
			CDAUtil.save(getDoc(), System.out);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <div class="en">Stores the CDA document as XML file</div>
	 * <div class="de">Speichert das CDA Dokument als XML Datei</div>.
	 *
	 * @param fileName
	 *            file name (incl. path)
	 * @throws Exception
	 *             the exception
	 */
	public void saveToFile(String fileName) throws Exception {
		final File yourFile = new File(fileName);
		if (!yourFile.exists()) {
			yourFile.createNewFile();
		}
		OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(yourFile),
				Charsets.UTF_8);

		// create emf resource
		final CDAResource resource = (CDAResource) CDAResource.Factory.INSTANCE
				.createResource(URI.createURI(CDAPackage.eNS_URI));

		// add the document root to the resource
		docRoot.setClinicalDocument(getDoc());
		resource.getContents().add(docRoot);

		// save resource to file
		resource.save(writer, null);
		writer.close();
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		if (code != null)
			getDoc().setCode(code.getCE());
	}

	/**
	 * Sets Confidentially Code.
	 *
	 * @param code
	 *            If null, "N" for "normal" will be set.
	 */
	public void setConfidentialityCode(ConfidentialityCode code) {
		CE confidentialityCode;
		if (code == null) {
			confidentialityCode = ConfidentialityCode.NORMAL.getCE();
		} else {
			confidentialityCode = code.getCE();
		}
		getDoc().setConfidentialityCode(confidentialityCode);
	}

	/**
	 * <div class="en">Sets an organization as the custodian of the
	 * document</div> <div class="de">Weist dem CDA Dokument die verwaltende
	 * Organisation zu</div>.
	 *
	 * @param organization
	 *            <div class="en">custodian organization</div>
	 *            <div class="de">verwaltende Organisation</div>
	 * @return the custodian
	 */
	public Custodian setCustodian(Organization organization) {
		// create and set the mdht Custodian object
		final Custodian mdhtCustodian = CDAFactory.eINSTANCE.createCustodian();
		final AssignedCustodian assCust = CDAFactory.eINSTANCE.createAssignedCustodian();
		assCust.setRepresentedCustodianOrganization(
				Util.createCustodianOrganizationFromOrganization(organization));

		if (organization != null) {
			// Setzt die GLN des Arztes
			if (organization.getMdhtOrganization().getIds().size() > 0) {
				assCust.getRepresentedCustodianOrganization().getIds()
						.addAll(organization.getMdhtOrganization().getIds());
			}
		}

		mdhtCustodian.setAssignedCustodian(assCust);
		getDoc().setCustodian(mdhtCustodian);
		return mdhtCustodian;
	}

	/**
	 * <div class="en">Adds a data enterer</div> <div class="de">Fügt dem CDA
	 * Dokument einen Erfasser hinzu</div>.
	 *
	 * @param dataEnterer
	 *            <div class="en">a person, which delivered content for this
	 *            document</div> <div class="de">Erfasser oder
	 *            Sachbearbeiter/-in, welche(r) das Dokument erstellt oder
	 *            Beiträge dazu geliefert hat.</div>
	 */
	public void setDataEnterer(DataEnterer dataEnterer) {
		getDoc().setDataEnterer(dataEnterer.getMdht());
	}

	/**
	 * <div class="en">Adds a data enterer</div> <div class="de">Fügt dem CDA
	 * Dokument einen Erfasser hinzu</div>.
	 *
	 * @param dataEnterer
	 *            <div class="en">a person, which delivered content for this
	 *            document</div> <div class="de">Erfasser oder
	 *            Sachbearbeiter/-in, welche(r) das Dokument erstellt oder
	 *            Beiträge dazu geliefert hat.</div>
	 */
	public void setDataEnterer(Person dataEnterer) {
		final org.openhealthtools.mdht.uml.cda.DataEnterer enterer = CDAFactory.eINSTANCE
				.createDataEnterer();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		entity.setAssignedPerson(dataEnterer.copyMdhtPerson());
		enterer.setAssignedEntity(entity);

		getDoc().setDataEnterer(enterer);
	}

	/**
	 * Method implementing.
	 *
	 * @param docRoot
	 *            the document root
	 */
	protected void setDoc(DocumentRoot docRoot) {
		this.docRoot = docRoot;
	}

	/**
	 * <div class="en">Specify the document which is replaced by this current
	 * document (see e.g. &lt;CH-VACD-REPL&gt;)</div><div class="de"></div>
	 * <div class="fr"></div>
	 *
	 * @param documentId
	 *            <div class="en">Identificator of replaced document</div>
	 */
	public void setDocumentToReplaceIdentifier(Identificator documentId) {
		this.getMdht().getRelatedDocuments().clear();
		final RelatedDocument relatedDocument = CDAFactory.eINSTANCE.createRelatedDocument();
		relatedDocument.setTypeCode(x_ActRelationshipDocument.RPLC);
		final ParentDocument parentDocument = CDAFactory.eINSTANCE.createParentDocument();
		if (documentId != null)
			parentDocument.getIds().add(documentId.getIi());
		relatedDocument.setParentDocument(parentDocument);
		this.getMdht().getRelatedDocuments().add(relatedDocument);
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		if (id != null) {
			getDoc().setId(id.getIi());
		}
	}

	/**
	 * <div class="en">Sets the in fulfillment of reference other
	 * documents</div> <div class="de">Weist dem Dokument IDs von anderen
	 * Dokumentes zu, auf die es sich bezieht</div>.
	 *
	 * @param ids
	 *            the new in fulfillment of
	 */
	public void setInFulfillmentOf(@SuppressWarnings("rawtypes") Collection ids) {
		final InFulfillmentOf ifo = CDAFactory.eINSTANCE.createInFulfillmentOf();
		final Order o = CDAFactory.eINSTANCE.createOrder();
		for (Object identificator : ids) {
			if (identificator instanceof Identificator)
				o.getIds().add(((Identificator) identificator).getIi());
		}

		ifo.setOrder(o);
		getDoc().getInFulfillmentOfs().clear();
		getDoc().getInFulfillmentOfs().add(ifo);
	}

	/**
	 * <div class="en">Sets the in fulfillment of reference to another
	 * document</div> <div class="de">Weist dem Dokument eine ID eines anderen
	 * Dokumentes zu, auf das es sich bezieht</div>.
	 *
	 * @param id
	 *            of the referenced document
	 */
	public void setInFulfillmentOf(Identificator id) {
		final InFulfillmentOf ifo = CDAFactory.eINSTANCE.createInFulfillmentOf();
		final Order o = CDAFactory.eINSTANCE.createOrder();
		o.getIds().add(id.getIi());

		ifo.setOrder(o);
		getDoc().getInFulfillmentOfs().clear();
		getDoc().getInFulfillmentOfs().add(ifo);
	}

	/**
	 * <div class="en">Sets the in fulfillment of reference other
	 * documents</div> <div class="de">Weist dem Dokument IDs von anderen
	 * Dokumentes zu, auf die es sich bezieht</div>.
	 *
	 * @param ids
	 *            the new in fulfillment of
	 */
	public void setInFulfillmentOf(List<Identificator> ids) {
		final InFulfillmentOf ifo = CDAFactory.eINSTANCE.createInFulfillmentOf();
		final Order o = CDAFactory.eINSTANCE.createOrder();
		for (Identificator identificator : ids) {
			o.getIds().add(identificator.getIi());
		}

		ifo.setOrder(o);
		getDoc().getInFulfillmentOfs().clear();
		getDoc().getInFulfillmentOfs().add(ifo);
	}

	/**
	 * <div class="en">Sets the language of the document</div>
	 * <div class="de">Weist dem document eine Sprache zu</div>.
	 *
	 * @param language
	 *            code for the language
	 */
	public void setLanguageCode(LanguageCode language) {
		// Set language of the document
		getDoc().setLanguageCode(language.getCS());
	}

	/**
	 * <div class="en">Sets the legal authenticator of the document</div>
	 * <div class="de">Weist dem CDA Dokument einen rechtsgültigen Unterzeichner
	 * hinzu</div>.
	 *
	 * @param legalAuthenticator
	 *            <div class="en">legal authenticator</div>
	 *            <div class="de">rechtsgültiger Unterzeichner</div>
	 */
	public void setLegalAuthenticator(org.ehealth_connector.common.mdht.Author legalAuthenticator) {
		getDoc().setLegalAuthenticator(Util.createLegalAuthenticatorFromAuthor(legalAuthenticator));
		getDoc().getLegalAuthenticator()
				.setTime(EcoreUtil.copy(legalAuthenticator.getAuthorMdht().getTime()));
	}

	/**
	 * <div class="en">Adds a patient</div> <div class="de">Weist dem CDA
	 * Dokument einen Patienten zu</div>.
	 *
	 * @param patient
	 *            Patient
	 * @return the MDHT record target
	 */
	public RecordTarget setPatient(Patient patient) {
		if (patient != null) {
			if (patient.isNonHumenSubject()) {
				// Create a record target for a non-human subject
				final RecordTarget rt = CDAFactory.eINSTANCE.createRecordTarget();
				final PatientRole pr = CDAFactory.eINSTANCE.createPatientRole();
				final org.openhealthtools.mdht.uml.cda.Patient p = CDAFactory.eINSTANCE
						.createPatient();

				// Patient
				p.setNullFlavor(NullFlavor.OTH);
				pr.setPatient(p);
				// Patient Role
				pr.setClassCode(RoleClass.PAT);
				if (patient.getIds() != null) {
					if (!patient.getIds().isEmpty()) {
						for (Identificator item : patient.getIds()) {
							pr.getIds().add(item.getIi());
						}
					}
				}
				if (patient.getIds() == null) {
					final II ii = DatatypesFactory.eINSTANCE.createII();
					ii.setNullFlavor(NullFlavor.NA);
					pr.getIds().add(ii);
				}

				rt.setPatientRole(pr);
				// Record Target
				final II tIi = DatatypesFactory.eINSTANCE.createII();
				// IHE Non-Human Subject
				tIi.setRoot("1.3.6.1.4.1.19376.1.3.3.1.2");
				rt.getTemplateIds().add(tIi);
				rt.setTypeCode(ParticipationType.RCT);

				getMdht().getRecordTargets().clear();
				getMdht().getRecordTargets().add(rt);

			} else
				getDoc().getRecordTargets().add(patient.getMdhtRecordTarget());
		}
		return patient.getMdhtRecordTarget();
	}

	/**
	 * Sets the primary recipient.
	 *
	 * @param organization
	 *            the organization
	 * @return the information recipient
	 */
	public InformationRecipient setPrimaryRecipient(Organization organization) {

		InformationRecipient recipient = CDAFactory.eINSTANCE.createInformationRecipient();
		recipient.setTypeCode(x_InformationRecipient.PRCP);
		IntendedRecipient ir = CDAFactory.eINSTANCE.createIntendedRecipient();
		ir.setReceivedOrganization(organization.getMdhtOrganization());
		recipient.setIntendedRecipient(ir);
		getDoc().getInformationRecipients().clear();
		getDoc().getInformationRecipients().add(recipient);
		return recipient;
	}

	/**
	 * Sets the sets the id.
	 *
	 * @param id
	 *            the new sets the id
	 */
	public void setSetId(Identificator id) {
		if (id == null) {
			getDoc().setSetId(EcoreUtil.copy(getDoc().getId()));
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setRoot(id.getRoot());
			ii.setExtension(id.getExtension());
			getDoc().setSetId(ii);
		}
	}

	/**
	 * <div class="en">Sets the timestamp of the document</div>
	 * <div class="de">Weist dem Dokument einen Zeitstempel zu</div>.
	 *
	 * @param date
	 *            the timestamp
	 */
	public void setTimestamp(Date date) {
		if (date == null) {
			getDoc().setEffectiveTime(DateUtilOld.nowAsTS());
		} else {
			try {
				if ("000000".equals(DateUtilOld.createTimeTSFromEuroDate(date).getValue()))
					getDoc().setEffectiveTime(DateUtilOld.createDateTSFromEuroDate(date));
				else
					getDoc().setEffectiveTime(DateUtilOld.createFullTSFromEuroDate(date));
			} catch (final ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Sets the code.
	 *
	 * @param title
	 *            the new title
	 */
	public void setTitle(String title) {
		final ST titleSt = DatatypesFactory.eINSTANCE.createST();
		titleSt.addText(title);
		getDoc().setTitle(titleSt);
	}

	/**
	 * Sets the TypeId to the default value ("2.16.840.1.113883.1.3",
	 * "POCD_HD000040")
	 */
	protected void setTypeId() {
		// Set Type ID
		// Identifies the Type of the xml document
		final InfrastructureRootTypeId typeId = CDAFactory.eINSTANCE
				.createInfrastructureRootTypeId();
		getDoc().setTypeId(typeId);
		typeId.setRoot("2.16.840.1.113883.1.3");
		typeId.setExtension("POCD_HD000040");
	}

	/**
	 * <div class="en">Sets the document set Id and version number</div>
	 * <div class="de">Weist dem Dokument eine Set Id und eine Versionsnummer
	 * zu</div>.
	 *
	 * @param idVersion1
	 *            the set Id (if null, the document ID will be used)
	 * @param version
	 *            the version of the document
	 */
	public void setVersion(Identificator idVersion1, int version) {
		setSetId(idVersion1);
		setVersion(version);
	}

	/**
	 * Sets the version.
	 *
	 * @param number
	 *            the new version
	 */
	protected void setVersion(int number) {
		final INT i = DatatypesFactory.eINSTANCE.createINT();
		i.setValue(number);
		getDoc().setVersionNumber(i);
	}

	/**
	 * Sort xml header.
	 */
	public void sortXmlHeader() {
		// Make sure that the top level XML content always appear in the same
		// order (this simplifies comparison of CDA contents with previous
		// releases)
		docRoot.getMixed().sort(new FeatureMapEntryComparator());
	}
}
