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
 * Year of publication: 2014
 *
 *******************************************************************************/

package ch.ehc.cda;

import java.io.File;
import java.io.FileOutputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.ehc.cda.Organization;
import org.ehc.cda.Patient;
import org.ehc.cda.Person;
import org.ehc.cda.ConvenienceUtilsEnums.Language;
import org.ehc.cda.ConvenienceUtilsEnums.ParticipantType;
import org.openhealthtools.mdht.uml.cda.AssignedCustodian;
import org.openhealthtools.mdht.uml.cda.AssociatedEntity;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.CDAPackage;
import org.openhealthtools.mdht.uml.cda.Custodian;
import org.openhealthtools.mdht.uml.cda.DocumentRoot;
import org.openhealthtools.mdht.uml.cda.InfrastructureRootTypeId;
import org.openhealthtools.mdht.uml.cda.Participant1;
import org.openhealthtools.mdht.uml.cda.ch.CDACH;
import org.openhealthtools.mdht.uml.cda.internal.resource.CDAResource;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * CDA Dokument, das den Vorgaben der Spezifikation CDA-CH entspricht
 * 
 */
public abstract class CdaCh {
	
	public static String applicationOidRoot = "2.16.756.5.30.1.139.1.1.1";  // Currently, the Proof of Concept OID. See: http://oid.refdata.ch/
	protected CDACH doc = null;												// The CDA Document
	public DocumentRoot docRoot = null; 									// The OHT-Element that helds the document
	
	/**
	 * Standard Constructor
	 * 
	 * <div class="de">Erstellt ein CdaCh Objekt</div>
	 * <div class="fr"></div>
	 */
	public CdaCh() {
		this.docRoot = CDAFactory.eINSTANCE.createDocumentRoot();
		this.docRoot.setClinicalDocument(doc);
	}
	
	/**
	 * <div class="de">Erstellt ein CdaCh Objekt mittels eines IHE DocumentRoot Objekts</div>
	 * <div class="fr"></div>
	 *
	 * @param root 
	 * 		<div class="de">DocumentRoot</div>
	 *		<div class="fr"></div>
	 */
	public CdaCh(DocumentRoot root) {
		this.docRoot = root;
	}

	/**
	 * Setzt die Metadaten, die für Dokumente der CDA-CH-Spezifikation verwendet werden
	 * (DocumentID, TypeID, Confidentially Code, Language Code, Stylesheet)
	 * 
	 * @param language
	 *          Dokument-Sprache (CDA: /ClinicalDocument/languageCode)
	 * @param stylesheet
	 *          Stylesheet, welches im CDA mittels <?xml-stylesheet> für die
	 *          menschlich Lesbare Darstellung referenziert werden soll.
	 */
	public void setChMetadata(Language language, String stylesheet) {
		// Set language of the document
		doc.setLanguageCode(CdaChUtil.createLanguageCode(language));

		// Set OID of the document
		//TODO this.setId(CdaChUtil.generateDocId(applicationOidRoot));
		//TODO zumindest die Extension muss als fortlaufende Nummer generiert werden (siehe Arztbrief Seite 44)
		II docID = DatatypesFactory.eINSTANCE.createII();
		docID.setRoot(applicationOidRoot);
		docID.setExtension("1817558762");

		// Set Type ID 
		// Identifies the Type of the xml document (fixed)
		InfrastructureRootTypeId typeId = CDAFactory.eINSTANCE.createInfrastructureRootTypeId();
		doc.setTypeId(typeId);
		typeId.setRoot("2.16.840.1.113883.1.3");
		typeId.setExtension("POCD_HD000040");

		// Set Confidentially Code
		// Standard is "N" for "normal". Can be changed through the set method
		CE confidentialityCode = DatatypesFactory.eINSTANCE.createCE();
		doc.setConfidentialityCode(confidentialityCode);
		confidentialityCode.setCode("N");

		// Add the stylesheet processing instructions to the document	root using featuremaputil
		// TODO Erstellen eines Constructors, der ohne übergebenes Stylesheet ein Standard-Stylesheet verwendet.
		FeatureMapUtil.addProcessingInstruction(docRoot.getMixed(),
				"xml-stylesheet", "type=\"text/xsl\" href=\""+stylesheet+"\" " ); 

		// set xml namespace
		docRoot.getXMLNSPrefixMap().put("", CDAPackage.eNS_URI);
	}
	
	

	/**
	 * Fügt dem CDA Dokument einen Unterzeichner hinzu
	 * 
	 * @param authenticator
	 *            Unterzeichner
	 */
	public void addAuthenticator(Person authenticator) {

	}

	/**
	 * Fügt dem CDA Dokument einen Erfasser hinzu
	 * 
	 * @param dataEnterer
	 *            Erfasser oder Sachbearbeiter/-in, welche(r) das Dokument
	 *            erstellt oder Beiträge dazu geliefert hat.
	 */
	public void addDataEnterer(Person dataEnterer) {

	}

	/**
	 * Weist dem CDA Dokument den Patienten zu
	 * 
	 * @param patient
	 *            Patient
	 */
	public void setPatient(Patient patient) {
		doc.getRecordTargets().add(patient.getRecordTarget());
	}

	/**
	 * Fügt einen Autoren hinzu.
	 * 
	 * @param author
	 *            Der Autor
	 */
	public void addAuthor(org.ehc.cda.Author author) {
		// create a new (!) MDHT author Objekt.
		Author docAuthor = CDAFactory.eINSTANCE.createAuthor();
		docAuthor = author.getAuthorMdht();

		doc.getAuthors().add(docAuthor);
	}

	/**
	 * Gibt den Autor des Dokuments zurück
	 * 
	 * @return das eHealthConnector Author Objekt
	 */
	public org.ehc.cda.Author getAuthor() {
		org.ehc.cda.Author author = new org.ehc.cda.Author(
				doc.getAuthors().get(0));
		return author;
	}

	/**
	 * Weist dem CDA Dokument die verwaltende Organisation zu
	 * 
	 * @param organization
	 *            verwaltende Organisation
	 */
	public void setCustodian(Organization organization) {
		// create and set the mdht Custodian object
		final Custodian mdhtCustodian = CDAFactory.eINSTANCE.createCustodian();
		doc.setCustodian(mdhtCustodian);

		final AssignedCustodian assCust = CDAFactory.eINSTANCE
				.createAssignedCustodian();
		mdhtCustodian.setAssignedCustodian(assCust);

		mdhtCustodian
				.getAssignedCustodian()
				.setRepresentedCustodianOrganization(
						CdaChUtil
								.createCustodianOrganizationFromOrganization(organization));
	}

	/**
	 * Gibt den Verantwortlichen für das Dokument zurück
	 * 
	 * @return das openHealthTools Custodian Objekt
	 */
	public Custodian getCustodian() {
		return doc.getCustodian();
	}

	/**
	 * Weist dem CDA Dokument einen rechtsgültigen Unterzeichner hinzu
	 * 
	 * @param legalAuthenticator
	 *            rechtsgültiger Unterzeichner
	 */
	public void setLegalAuthenticator(
			org.ehc.cda.Author legalAuthenticator) {
		doc.setLegalAuthenticator(CdaChUtil
				.createLagalAuthenticatorFromAuthor(legalAuthenticator));
	}

	/**
	 * Fügt eine Versicherung hinzu
	 * 
	 * @param versicherung
	 *            Die Versicherung als Organization Objekt
	 */
	public void addInsurance(Organization versicherung) {
		this.addParticipant(versicherung, ParticipantType.Insurance);
	}
	
	/**
	 * Liefert das Patientenobjekt zurück
	 *
	 * @return the patient
	 */
	public Patient getPatient() {
		return (Patient) doc.getRecordTargets().get(0).getPatientRole()
				.getPatient();
	}

	/**
	 * Fügt dem CDA Dokument eine Partizipation hinzu
	 * 
	 * @param organization
	 *            Organisation
	 * @param participantType
	 *            Art der Partizipation (z.B. Versicherung)
	 */
	public void addParticipant(Organization organization,
			ParticipantType participantType) {
		// Set the given organization as Participant of this document.
		final Participant1 participant = CDAFactory.eINSTANCE
				.createParticipant1();
		doc.getParticipants().add(participant);
		final AssociatedEntity assEnt = CDAFactory.eINSTANCE
				.createAssociatedEntity();
		participant.setAssociatedEntity(assEnt);

		org.openhealthtools.mdht.uml.cda.Organization docOrganization = CDAFactory.eINSTANCE
				.createOrganization();
		docOrganization = organization.getOrganization();
		assEnt.setScopingOrganization(docOrganization);
	}
	
	/**
	 * Gibt die XML-Repräsentation des Dokuments auf der Konsole aus
	 */
	public void printXmlToConsole() {
		try {
			CDAUtil.save(doc, System.out);
		} catch (final Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Speichert das CDA Dokument als XML Datei
	 * 
	 * @param fileName
	 *            Dateiname (inkl. Pfadangaben)
	 * @throws Exception
	 */
	public void saveToFile(String fileName) throws Exception {
		File yourFile = new File(fileName);
		if (!yourFile.exists()) {
			yourFile.createNewFile();
		}
		FileOutputStream oFile = new FileOutputStream(yourFile, false);

		// create emf resource
		CDAResource resource = (CDAResource) CDAResource.Factory.INSTANCE
				.createResource(URI.createURI(CDAPackage.eNS_URI));

		// add the document root to the resource
		docRoot.setClinicalDocument(doc);
		resource.getContents().add(docRoot);

		// save resource to console
		resource.save(oFile, null);
	}
}
