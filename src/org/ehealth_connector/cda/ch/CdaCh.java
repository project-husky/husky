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

package org.ehealth_connector.cda.ch;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.cda.enums.Confidentiality;
import org.ehealth_connector.cda.enums.ParticipantType;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.EHealthConnectorVersions;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Person;
import org.ehealth_connector.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.AssignedCustodian;
import org.openhealthtools.mdht.uml.cda.AssignedEntity;
import org.openhealthtools.mdht.uml.cda.AssociatedEntity;
import org.openhealthtools.mdht.uml.cda.Authenticator;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.DataEnterer;
import org.openhealthtools.mdht.uml.cda.DocumentRoot;
import org.openhealthtools.mdht.uml.cda.InFulfillmentOf;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.LegalAuthenticator;
import org.openhealthtools.mdht.uml.cda.Order;
import org.openhealthtools.mdht.uml.cda.Participant1;
import org.openhealthtools.mdht.uml.cda.ch.CDACH;
import org.openhealthtools.mdht.uml.cda.internal.resource.CDAResource;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;

/**
 * CDA Dokument, das den Vorgaben der Spezifikation CDA-CH entspricht
 */
public abstract class CdaCh {

	/** main OID for CDA-CH */
	public static final String OID_MAIN = "2.16.756.5.30.1.1.1.1";

	/** OID for CDA-CH V1.* */
	public static final String OID_V1 = "2.16.756.5.30.1.1.1.1.1";

	public static EHealthConnectorVersions currentEhcVersion = EHealthConnectorVersions.EHealthConnectorDev;
	private CDACH doc; // The CDA Document
	private DocumentRoot docRoot; // The OHT-Element that helds the

	// document
	// private Query query;

	/**
	 * <div class="en">Constructor for CdaCh documents</div> <div
	 * class="de">Erstellt ein CdaCh Objekt</div> <div class="fr"></div>
	 * 
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation
	 */
	public CdaCh(CDACH doc) {
		this.setDoc(doc);
		docRoot = CDAFactory.eINSTANCE.createDocumentRoot();
		// set xml namespace
		docRoot.getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);
		docRoot.setClinicalDocument(doc);
	}

	/**
	 * <div class="en">Constructor that includes a stylesheet and a cascasing
	 * stylesheet into the document processing instructions and initalizes the
	 * standard document attributes.</div> <div class="de">Erzeugt ein CdaCh
	 * Objekt (CDA Header nach schweizer Spezifikation)</div> <div
	 * class="fr"></div>
	 * 
	 * @param doc
	 *            the CDA-CH Object in its MDHT representation
	 * @param stylesheet
	 *            the stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 * @param css
	 *            the Cascasing stylesheet for the document (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl').
	 */
	public CdaCh(CDACH doc, String stylesheet, String css) {
		this.setDoc(doc);
		docRoot = CDAFactory.eINSTANCE.createDocumentRoot();

		if (css != null) {
			addCss(css);
		}
		addStylesheet(stylesheet);
		initCdaCh();

		docRoot.setClinicalDocument(doc);
	}

	/**
	 * <div class="en">Creates a CdaCh Object on the basis of an IHE document
	 * root</div> <div class="de">Erstellt ein CdaCh Objekt mittels eines IHE
	 * DocumentRoot Objekts</div> <div class="fr"></div>
	 * 
	 * @param root
	 *            document root
	 */
	public CdaCh(DocumentRoot root) {
		docRoot = root;
	}

	/**
	 * <div class="en">Adds an authenricator to the CDA document</div> <div
	 * class="de">Fügt dem CDA Dokument einen Unterzeichner hinzu</div>
	 * 
	 * @param authenticator
	 *            Unterzeichner
	 */
	public void addAuthenticator(org.ehealth_connector.common.Author authenticator) {
		final Authenticator auth = CDAFactory.eINSTANCE.createAuthenticator();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		auth.setAssignedEntity(entity);
		entity.setAssignedPerson(authenticator.copyMdhtAuthor().getAssignedAuthor()
				.getAssignedPerson());

		getDoc().getAuthenticators().add(auth);
	}

	/**
	 * <div class="en">Adds an authenticator to the CDA document</div> <div
	 * class="de">Fügt dem CDA Dokument einen Unterzeichner hinzu</div>
	 * 
	 * @param authenticator
	 *            Unterzeichner
	 */
	public void addAuthenticator(Person authenticator) {
		final Authenticator auth = CDAFactory.eINSTANCE.createAuthenticator();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		auth.setAssignedEntity(entity);
		entity.setAssignedPerson(authenticator.copyMdhtPerson());

		getDoc().getAuthenticators().add(auth);
	}

	/**
	 * <div class="en">Adds an author</div> <div class="de">Fügt einen Autoren
	 * hinzu</div>
	 * 
	 * @param author
	 *            the autor
	 */
	public void addAuthor(org.ehealth_connector.common.Author author) {
		final Author docAuthor = author.copyMdhtAuthor();
		getDoc().getAuthors().add(docAuthor);
	}

	/**
	 * <div class="en">Adds a cascading stylesheet (CSS) to the XML processing
	 * instructions</div> <div class="de">Fügt ein Cascading Stylesheet (CSS) zu
	 * den XML Processing Instructions hinzu</div>
	 * 
	 * @param css
	 *            path of the CSS file
	 */
	public void addCss(String css) {
		// Add the stylesheet processing instructions to the document
		FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(), "xml-stylesheet",
				"type=\"text/css\" href=\"" + css + "\"");
	}

	/**
	 * <div class="en">Adds a data enterer</div> <div class="de">Fügt dem CDA
	 * Dokument einen Erfasser hinzu</div>
	 * 
	 * @param dataEnterer
	 *            <div class="en">a person, which delivered content for this
	 *            document</div> <div class="de">Erfasser oder
	 *            Sachbearbeiter/-in, welche(r) das Dokument erstellt oder
	 *            Beiträge dazu geliefert hat.</div>
	 */
	public void addDataEnterer(Person dataEnterer) {
		final DataEnterer enterer = CDAFactory.eINSTANCE.createDataEnterer();
		final AssignedEntity entity = CDAFactory.eINSTANCE.createAssignedEntity();

		enterer.setAssignedEntity(entity);
		entity.setAssignedPerson(dataEnterer.copyMdhtPerson());

		getDoc().getDataEnterer().setAssignedEntity(entity);
	}

	/**
	 * <div class="en">Adds a insurance organization</div> <div class="de">Fügt
	 * eine Versicherung hinzu</div>
	 * 
	 * @param versicherung
	 *            the insurance organization
	 */
	public void addInsurance(Organization versicherung) {
		addParticipant(versicherung, ParticipantType.Insurance);
	}

	/**
	 * <div class="en">Adds a participant</div> <div class="de">Fügt dem CDA
	 * Dokument einen Teilnehmer hinzu</div>
	 * 
	 * @param organization
	 *            Organisation
	 * @param participantType
	 *            <div class="en">Kind of participation (e.g. insurance)</div>
	 *            <div class="de">Art der Partizipation (z.B.
	 *            Versicherung)</div>
	 */
	public void addParticipant(Organization organization, ParticipantType participantType) {
		// Set the given organization as Participant of this document.
		final Participant1 participant = CDAFactory.eINSTANCE.createParticipant1();
		getDoc().getParticipants().add(participant);
		final AssociatedEntity assEnt = CDAFactory.eINSTANCE.createAssociatedEntity();
		participant.setAssociatedEntity(assEnt);

		// org.openhealthtools.mdht.uml.cda.Organization docOrganization =
		// CDAFactory.eINSTANCE.createOrganization();
		final org.openhealthtools.mdht.uml.cda.Organization docOrganization = organization
				.getMdhtOrganization();
		assEnt.setScopingOrganization(docOrganization);
	}

	/**
	 * <div class="en">Adds a stylesheet to the XML processing
	 * instructions</div> <div class="de">Fügt ein Stylesheet zu den XML
	 * Processing Instructions hinzu</div>
	 * 
	 * @param stylesheet
	 *            Path to the stylesheet (e.g.
	 *            '../../../../stylesheets/HL7.ch/CDA-CH/v1.2/cda-ch.xsl')
	 */
	public void addStylesheet(String stylesheet) {
		if (stylesheet != null) {
			// Add the stylesheet processing instructions to the document
			FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(), "xml-stylesheet",
					"type=\"text/xsl\" href=\"" + stylesheet + "\"");
		}
	}

	/**
	 * <div class="en">Returns a list of authenticators of this document</div>
	 * <div class="de">Gibt alle Unterzeichner des Dokuments zurück</div>
	 * 
	 * @return <div class="en">the authenticators</div> <div class="de">die
	 *         Unterzeichner</div>
	 */
	public List<org.ehealth_connector.common.Person> getAuthenticators() {
		final List<org.ehealth_connector.common.Person> persons = new ArrayList<org.ehealth_connector.common.Person>();
		for (Authenticator mAutor : getDoc().getAuthenticators()) {
			final org.ehealth_connector.common.Person person = new org.ehealth_connector.common.Person(
					mAutor.getAssignedEntity().getAssignedPerson());
			persons.add(person);
		}
		return persons;
	}

	/**
	 * <div class="en">Returns the (first) author of the document</div> <div
	 * class="de">Gibt den (ersten) Autor des Dokuments zurück</div>
	 * 
	 * @return the author
	 */
	public org.ehealth_connector.common.Author getAuthor() {
		final org.ehealth_connector.common.Author author = new org.ehealth_connector.common.Author(
				getDoc().getAuthors().get(0));
		return author;
	}

	/**
	 * <div class="en">Returns all authors of the document</div> <div
	 * class="de">Gibt alle Autoren des Dokuments zurück</div>
	 * 
	 * @return list of authors
	 */
	public List<org.ehealth_connector.common.Author> getAuthors() {
		final List<org.ehealth_connector.common.Author> authors = new ArrayList<org.ehealth_connector.common.Author>();
		for (Author mAutor : getDoc().getAuthors()) {
			final org.ehealth_connector.common.Author author = new org.ehealth_connector.common.Author(
					mAutor);
			authors.add(author);
		}
		return authors;
	}

	/**
	 * <div class="en">Gets the Confidentially Code</div> <div class="de"></div>
	 * 
	 * @return code
	 */
	public Confidentiality getConfidentialityCode() {
		if (getDoc().getConfidentialityCode() != null) {
			return Confidentiality.getEnum(getDoc().getConfidentialityCode().getCode());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the custodian</div> <div class="de">Gibt den
	 * Verantwortlichen für das Dokument zurück</div>
	 * 
	 * @return das openHealthTools Custodian Objekt
	 */
	public Custodian getCustodian() {
		return getDoc().getCustodian();
	}

	/**
	 * <div class="en">Gets all authors of the document</div> <div
	 * class="de">Gibt alle Autoren des Dokuments zurück</div>
	 * 
	 * @return das eHealthConnector Author Objekt
	 */
	public org.ehealth_connector.common.Person getDataEnterer() {
		if (getDoc().getDataEnterer() != null) {
			if (getDoc().getDataEnterer().getAssignedEntity() != null) {
				if (getDoc().getDataEnterer().getAssignedEntity().getAssignedPerson() != null) {
					final org.ehealth_connector.common.Person person = new org.ehealth_connector.common.Person(
							getDoc().getDataEnterer().getAssignedEntity().getAssignedPerson());
					return person;
				}
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the document root (which helds the cda
	 * document)</div>
	 * 
	 * @return the document root
	 */
	public DocumentRoot getDocRoot() {
		return this.docRoot;
	}

	public Identificator getId() {
		if (getDoc().getId() != null) {
			return new Identificator(getDoc().getId());
		}
		return null;
	}

	/**
	 * <div class="en">Gets all insurances</div> <div class="de">Gibt alle
	 * Versicherungen zurück</div>
	 * 
	 * @return arraylist of organizations
	 */
	public List<Organization> getInsurances() {
		final List<Organization> organizations = new ArrayList<Organization>();
		for (Participant1 part : getDoc().getParticipants()) {
			if (part.getTypeCode().equals(ParticipantType.Insurance)) {
				final Organization org = new Organization(part.getAssociatedEntity()
						.getScopingOrganization());
				organizations.add(org);
			}
		}
		return organizations;
	}

	/**
	 * <div class="en">Gets the language code</div> <div class="de">Gibt die
	 * Sprache des Dokuments zurück</div>
	 * 
	 * @return language code
	 */
	public CS getLanuageCode() {
		if (getDoc().getLanguageCode() != null) {
			return getDoc().getLanguageCode();
		}
		return null;
	}

	/**
	 * Gets the legal authenticator of the document <div class="de">Gibt den
	 * juristisch verantwortlichen Unterzeichner des Dokuments zurück</div>
	 * 
	 * @return the legal authenticator
	 */
	public Person getLegalAuthenticator() {
		final LegalAuthenticator la = getDoc().getLegalAuthenticator();
		final Person p = new Person(la.getAssignedEntity().getAssignedPerson());
		return p;
	}

	/**
	 * Gets the CDA document as ByteArrayOutputStream
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
	 * <div class="en">Gets all participating organizations</div> <div
	 * class="de">Gibt alle Teilnehmenden Organisationen zurück</div>
	 * 
	 * @return the arraylist of organizations
	 */
	public List<Organization> getParticipants() {
		final List<Organization> organizations = new ArrayList<Organization>();
		for (Participant1 part : getDoc().getParticipants()) {
			final Organization org = new Organization(part.getAssociatedEntity()
					.getScopingOrganization());
			organizations.add(org);
		}
		return organizations;
	}

	/**
	 * <div class="en">Gets the patient</div> <div class="de">Liefert den
	 * Patienten zurück</div>
	 * 
	 * @return the patient
	 */
	public Patient getPatient() {
		final Patient patient = new Patient(getDoc().getRecordTargets().get(0));
		return patient;
	}

	/**
	 * <div class="en">Gets the set Id</div>
	 * 
	 * @return the set id
	 */
	public Identificator getSetId() {
		if (getDoc().getSetId() != null) {
			return new Identificator(getDoc().getSetId().getRoot(), getDoc().getSetId()
					.getExtension());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the timestamp</div>
	 * 
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		if (getDoc().getEffectiveTime() != null) {
			return DateUtil.parseDate(getDoc().getEffectiveTime());
		}
		return null;
	}

	/**
	 * <div class="en">Gets the title</div>
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return getDoc().getTitle().getText();
	}

	/**
	 * <div class="en">Gets the version</div>
	 * 
	 * @return the version
	 */
	public Integer getVersion() {
		if (getDoc().getVersionNumber() != null) {
			return getDoc().getVersionNumber().getValue().intValue();
		}
		return null;
	}

	/**
	 * <div class="en">Initializes the CdaCh document header defaults</div>
	 */
	public void initCdaCh() {
		// Set the eHealthConnector comment
		FeatureMapUtil.addComment(docRoot.getMixed(),
				"Document based on CDA R2 generated by " + currentEhcVersion.getSystemVersionName()
						+ ", Release Date " + currentEhcVersion.getReleaseDate());

		// Add the stylesheet processing instructions to the document root using
		// featuremaputil
		// set xml namespace
		docRoot.getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);

		// Set OID of the document
		setId(null);
		setVersion(null, null);

		setConfidentialityCode(null);

		// Set creation time of the document
		setTimestamp(null);

		// Fix RealmCode
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode("CH");
		getDoc().getRealmCodes().clear();
		getDoc().getRealmCodes().add(cs);

		// Type ID
		setTypeId();
	}

	/**
	 * <div class="en">prints the XML representation of the document to the
	 * console</div> <div class="de">Gibt die XML-Repräsentation des Dokuments
	 * auf der Konsole aus</div>
	 */
	public void printXmlToConsole() {
		try {
			CDAUtil.save(getDoc(), System.out);
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * <div class="en">Stores the CDA document as XML file</div> <div
	 * class="de">Speichert das CDA Dokument als XML Datei</div>
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
		final FileOutputStream oFile = new FileOutputStream(yourFile, false);

		// create emf resource
		final CDAResource resource = (CDAResource) CDAResource.Factory.INSTANCE.createResource(URI
				.createURI(CDAPackage.eNS_URI));

		// add the document root to the resource
		docRoot.setClinicalDocument(getDoc());
		resource.getContents().add(docRoot);

		// save resource to console
		resource.save(oFile, null);
	}

	/**
	 * Sets Confidentially Code
	 * 
	 * @param code
	 *            If null, "N" for "normal" will be set.
	 */
	public void setConfidentialityCode(Confidentiality code) {
		CE confidentialityCode;
		if (code == null) {
			confidentialityCode = Confidentiality.NORMAL.getCE();
		} else {
			confidentialityCode = code.getCE();
		}
		getDoc().setConfidentialityCode(confidentialityCode);
	}

	/**
	 * <div class="en">Sets an organization as the custodian of the
	 * document</div> <div class="de">Weist dem CDA Dokument die verwaltende
	 * Organisation zu</div>
	 * 
	 * @param organization
	 *            <div class="en">custodian organization</div> <div
	 *            class="de">verwaltende Organisation</div>
	 */
	public void setCustodian(Organization organization) {
		// create and set the mdht Custodian object
		final Custodian mdhtCustodian = CDAFactory.eINSTANCE.createCustodian();
		getDoc().setCustodian(mdhtCustodian);

		final AssignedCustodian assCust = CDAFactory.eINSTANCE.createAssignedCustodian();
		mdhtCustodian.setAssignedCustodian(assCust);

		mdhtCustodian.getAssignedCustodian().setRepresentedCustodianOrganization(
				Util.createCustodianOrganizationFromOrganization(organization));

		// Setzt die GLN des Arztes
		II id = DatatypesFactory.eINSTANCE.createII();
		if (organization.getMdhtOrganization().getIds().size() > 0) {
			id = organization.getMdhtOrganization().getIds().get(0);
		}
		mdhtCustodian.getAssignedCustodian().getRepresentedCustodianOrganization().getIds().add(id);
	}

	/**
	 * <div class="en">Sets the id of the document</div> <div class="de">Weist
	 * dem CDA Dokument eine id zu</div>
	 * 
	 * @param id
	 *            the id
	 */
	public void setId(Identificator id) {
		if (id == null) {
			final II docID = DatatypesFactory.eINSTANCE.createII();
			docID.setRoot(CdaCh.OID_MAIN);
			docID.setExtension(UUID.generate());
			getDoc().setId(docID);
		} else {
			getDoc().setId(id.getIi());
		}
	}

	/**
	 * <div class="en">Sets the in fulfillment of reference to another
	 * document</div> <div class="de">Weist dem Dokument eine ID eines anderen
	 * Dokumentes zu, auf das es sich bezieht</div>
	 * 
	 * @param id
	 *            of the referenced document
	 */
	public void setInFulfillmentOf(Identificator id) {
		final InFulfillmentOf ifo = CDAFactory.eINSTANCE.createInFulfillmentOf();
		final Order o = CDAFactory.eINSTANCE.createOrder();
		o.getIds().add(id.getIi());

		ifo.setOrder(o);
		getDoc().getInFulfillmentOfs().add(ifo);
	}

	/**
	 * <div class="en">Sets the language of the document</div> <div
	 * class="de">Weist dem document eine Sprache zu</div>
	 * 
	 * @param language
	 *            code for the language
	 */
	public void setLanguageCode(LanguageCode language) {
		// Set language of the document
		getDoc().setLanguageCode(language.getCS());
	}

	/**
	 * <div class="en">Sets the legal authenticator of the document</div> <div
	 * class="de">Weist dem CDA Dokument einen rechtsgültigen Unterzeichner
	 * hinzu</div>
	 * 
	 * @param legalAuthenticator
	 *            <div class="en">legal authenticator</div> <div
	 *            class="de">rechtsgültiger Unterzeichner</div>
	 */
	public void setLegalAuthenticator(org.ehealth_connector.common.Author legalAuthenticator) {
		getDoc().setLegalAuthenticator(Util.createLagalAuthenticatorFromAuthor(legalAuthenticator));
	}

	/**
	 * <div class="en">Adds a patient</div> <div class="de">Weist dem CDA
	 * Dokument einen Patienten zu</div>
	 * 
	 * @param patient
	 *            Patient
	 */
	public void setPatient(Patient patient) {
		getDoc().getRecordTargets().add(patient.getMdhtRecordTarget());
	}

	/**
	 * <div class="en">Sets the timestamp of the document</div> <div
	 * class="de">Weist dem Dokument einen Zeitstempel zu</div>
	 * 
	 * @param date
	 *            the timestamp
	 */
	public void setTimestamp(Date date) {
		if (date == null) {
			getDoc().setEffectiveTime(DateUtil.nowAsTS());
		} else {
			try {
				getDoc().setEffectiveTime(DateUtil.createTSFromEuroDate(date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * <div class="en">Sets the document set Id and version number</div> <div
	 * class="de">Weist dem Dokument eine Set Id und eine Versionsnummer
	 * zu</div>
	 * 
	 * @param guidVersion1
	 *            the set Id (if null, the document ID will be used)
	 * @param version
	 *            the version of the document
	 */
	public void setVersion(String guidVersion1, Integer version) {
		setSetId(guidVersion1);
		setVersionNumber(version);
	}

	protected void setSetId(String id) {
		if (id == null) {
			getDoc().setSetId(EcoreUtil.copy(getDoc().getId()));
		} else {
			final II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setRoot(CdaCh.OID_MAIN);
			ii.setExtension(id);
			getDoc().setSetId(ii);
		}
	}

	protected void setTitle(String title) {
		final ST titleSt = DatatypesFactory.eINSTANCE.createST();
		titleSt.addText(title);
		getDoc().setTitle(titleSt);
	}

	protected void setVersionNumber(Integer number) {
		final INT i = DatatypesFactory.eINSTANCE.createINT();
		if (number == null) {
			i.setValue(1);
		} else {
			i.setValue(number);
		}
		getDoc().setVersionNumber(i);
	}

	/**
	 * Sets the TypeId to the default value ("2.16.840.1.113883.1.3",
	 * "POCD_HD000040")
	 */
	private void setTypeId() {
		// Set Type ID
		// Identifies the Type of the xml document
		final InfrastructureRootTypeId typeId = CDAFactory.eINSTANCE
				.createInfrastructureRootTypeId();
		getDoc().setTypeId(typeId);
		typeId.setRoot("2.16.840.1.113883.1.3");
		typeId.setExtension("POCD_HD000040");
	}

	/**
	 * Method to get
	 * 
	 * @return the doc
	 */
	public CDACH getDoc() {
		return doc;
	}

	/**
	 * Method to set
	 * 
	 * @param doc
	 *            the doc to set
	 */
	public void setDoc(CDACH doc) {
		this.doc = doc;
	}
}
