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
package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.mtps.enums.RouteOfAdministration;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemReferenceEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationFullfillmentInstructionsEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemEntry;
import org.ehealth_connector.cda.ihe.pharm.MedicationTreatmentPlanItemReferenceEntry;
import org.ehealth_connector.cda.ihe.pharm.PatientMedicalInstructionsEntry;
import org.ehealth_connector.cda.ihe.pharm.PharmManufacturedMaterialEntry;
import org.ehealth_connector.cda.ihe.pharm.PharmaceuticalAdviceItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemEntry;
import org.ehealth_connector.cda.ihe.pharm.PrescriptionItemReferenceEntry;
import org.ehealth_connector.cda.ihe.pharm.enums.OrderableDrugFrom;
import org.ehealth_connector.cda.ihe.pharm.enums.PharmaceuticalAdviceStatusList;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.enums.Ucum;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.AssignedAuthor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Component4;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.Observation;
import org.openhealthtools.mdht.uml.cda.Organizer;
import org.openhealthtools.mdht.uml.cda.PharmAsContent;
import org.openhealthtools.mdht.uml.cda.PharmComponent1;
import org.openhealthtools.mdht.uml.cda.PharmIngredient;
import org.openhealthtools.mdht.uml.cda.PharmPackagedMedicine;
import org.openhealthtools.mdht.uml.cda.PharmSubjectOf4;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionMade;
import org.openhealthtools.mdht.uml.cda.PharmSubstitutionPermission;
import org.openhealthtools.mdht.uml.cda.Product;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.SubstanceAdministration;
import org.openhealthtools.mdht.uml.cda.Supply;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.MedicationItemEntry;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.EIVL_event;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_INT;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVXB_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXPR_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClass;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassRoot;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassSupply;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityClassManufacturedMaterial;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityDeterminer;
import org.openhealthtools.mdht.uml.hl7.vocab.EntityDeterminerDetermined;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassManufacturedProduct;
import org.openhealthtools.mdht.uml.hl7.vocab.SetOperator;
import org.openhealthtools.mdht.uml.hl7.vocab.TimingEvent;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryAct;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActClassDocumentEntryOrganizer;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipEntryRelationship;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipExternalReference;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentActMood;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Test cases
 */
public class CdaChMtpsPmlTest extends TestUtils {

	public static Author createDispenseAuthor1() {

		final Name name = new Name("MedecinDispenseur1", "Famille", "Dr.");
		final Author author = new Author(name, "7601000000000");
		final Code functionCode = new Code("2.16.756.5.30.2.1.1.1", "PCP",
				"eCH ParticipationFunction", "Medical doctors");
		author.setFunctionCode(functionCode);
		author.setTime(new Date());

		final AssignedAuthor assignedAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		final II authorID = DatatypesFactory.eINSTANCE.createII("1.3.88", author.getGln());
		assignedAuthor.getIds().add(authorID);
		final Code assignedAuthorCodefunctionCode = new Code("2.16.756.5.30.1.127.3.2.1.5", "50001",
				"Médecin spécialiste en médecine interne générale",
				"EPD_XDS_healthcareFacilityTypeCode");
		assignedAuthor.setCode(assignedAuthorCodefunctionCode.getCE());
		author.setAsAuthor(assignedAuthor);
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41322345567", AddressUse.BUSINESS);
		telecoms.addEMail("medecin.famille@hin.ch", AddressUse.BUSINESS);
		final Organization representedOrganization = new Organization(name.getCompleteName());
		representedOrganization.setTelecoms(telecoms);
		representedOrganization.addId(new Identificator(authorID));
		representedOrganization.addAddress(new Address("Rue des Malades", "13", "1213", "Geneva"));
		author.setOrganization(representedOrganization);
		return author;
	}

	public static Author createDispenseAuthor2() {

		final Name name = new Name("MedecinDispenseur2", "Famille", "Dr.");
		final Author author = new Author(name, "7601000000000");
		final Code functionCode = new Code("2.16.756.5.30.2.1.1.1", "PCP",
				"eCH ParticipationFunction", "Medical doctors");
		author.setFunctionCode(functionCode);
		author.setTime(new Date());

		final AssignedAuthor assignedAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		final II authorID = DatatypesFactory.eINSTANCE.createII("1.3.88", author.getGln());
		assignedAuthor.getIds().add(authorID);
		final Code assignedAuthorCodefunctionCode = new Code("2.16.756.5.30.1.127.3.2.1.5", "50001",
				"Médecin spécialiste en médecine interne générale",
				"EPD_XDS_healthcareFacilityTypeCode");
		assignedAuthor.setCode(assignedAuthorCodefunctionCode.getCE());
		author.setAsAuthor(assignedAuthor);
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41322345567", AddressUse.BUSINESS);
		telecoms.addEMail("medecin.famille@hin.ch", AddressUse.BUSINESS);
		final Organization representedOrganization = new Organization(name.getCompleteName());
		representedOrganization.setTelecoms(telecoms);
		representedOrganization.addId(new Identificator(authorID));
		representedOrganization.addAddress(new Address("Rue des Malades", "13", "1213", "Geneva"));
		author.setOrganization(representedOrganization);
		return author;

	}

	public static Author createPlanificationAuthor() {
		final Name name = new Name("Planifiant", "Professeur", "Dr.");
		final Author author = new Author(name, "7601000000000");
		final Code functionCode = new Code("2.16.756.5.30.2.1.1.1", "PCP",
				"eCH ParticipationFunction", "Medical doctors");
		author.setFunctionCode(functionCode);
		author.setTime(new Date());

		final AssignedAuthor assignedAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		final II authorID = DatatypesFactory.eINSTANCE.createII("1.3.88", author.getGln());
		assignedAuthor.getIds().add(authorID);
		final Code assignedAuthorCodefunctionCode = new Code("2.16.756.5.30.1.127.3.2.1.5", "50001",
				"Médecin spécialiste en médecine interne générale",
				"EPD_XDS_healthcareFacilityTypeCode");
		assignedAuthor.setCode(assignedAuthorCodefunctionCode.getCE());
		author.setAsAuthor(assignedAuthor);
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41322345567", AddressUse.BUSINESS);
		telecoms.addEMail("medecin.famille@hin.ch", AddressUse.BUSINESS);
		final Organization representedOrganization = new Organization(name.getCompleteName());
		representedOrganization.setTelecoms(telecoms);
		representedOrganization.addId(new Identificator(authorID));
		representedOrganization.addAddress(new Address("Rue des Malades", "13", "1213", "Geneva"));
		author.setOrganization(representedOrganization);
		return author;
	}

	public static Author createPrescriptionAuthor() {
		final Name name = new Name("Prescripteur", "Médecin", "Dr.");
		final Author author = new Author(name, "7601000000000");
		final Code functionCode = new Code("2.16.756.5.30.2.1.1.1", "PCP",
				"eCH ParticipationFunction", "Medical doctors");
		author.setFunctionCode(functionCode);
		author.setTime(new Date());

		final AssignedAuthor assignedAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		final II authorID = DatatypesFactory.eINSTANCE.createII("1.3.88", author.getGln());
		assignedAuthor.getIds().add(authorID);
		final Code assignedAuthorCodefunctionCode = new Code("2.16.756.5.30.1.127.3.2.1.5", "50001",
				"Médecin spécialiste en médecine interne générale",
				"EPD_XDS_healthcareFacilityTypeCode");
		assignedAuthor.setCode(assignedAuthorCodefunctionCode.getCE());
		author.setAsAuthor(assignedAuthor);
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41322345567", AddressUse.BUSINESS);
		telecoms.addEMail("medecin.famille@hin.ch", AddressUse.BUSINESS);
		final Organization representedOrganization = new Organization(name.getCompleteName());
		representedOrganization.setTelecoms(telecoms);
		representedOrganization.addId(new Identificator(authorID));
		representedOrganization.addAddress(new Address("Rue des Malades", "13", "1213", "Geneva"));
		author.setOrganization(representedOrganization);
		return author;
	}

	public static Author createPrescriptionAuthor2() {

		final Name name = new Name("Auteur", "Prescription", "Dr.");
		final Author author = new Author(name, "7601000000000");
		final Code functionCode = new Code("2.16.756.5.30.2.1.1.1", "PCP",
				"eCH ParticipationFunction", "Medical doctors");
		author.setFunctionCode(functionCode);
		author.setTime(new Date());

		final AssignedAuthor assignedAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		final II authorID = DatatypesFactory.eINSTANCE.createII("1.3.88", author.getGln());
		assignedAuthor.getIds().add(authorID);
		final Code assignedAuthorCodefunctionCode = new Code("2.16.756.5.30.1.127.3.2.1.5", "50001",
				"Médecin spécialiste en médecine interne générale",
				"EPD_XDS_healthcareFacilityTypeCode");
		assignedAuthor.setCode(assignedAuthorCodefunctionCode.getCE());
		author.setAsAuthor(assignedAuthor);
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41322345567", AddressUse.BUSINESS);
		telecoms.addEMail("medecin.famille@hin.ch", AddressUse.BUSINESS);
		final Organization representedOrganization = new Organization(name.getCompleteName());
		representedOrganization.setTelecoms(telecoms);
		representedOrganization.addId(new Identificator(authorID));
		representedOrganization.addAddress(new Address("Rue des Malades", "13", "1213", "Geneva"));
		author.setOrganization(representedOrganization);
		return author;
	}

	public static Author getLegalAuthenticatorInfo() {
		final Name authenticatorName = new Name("Albus", "Dumbledore", "Prof.");
		final Author authenticator = new Author(authenticatorName, "7601002116763"); //
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41223724567", AddressUse.BUSINESS);
		telecoms.addEMail("albus.dumbledore@hcuge.ch", AddressUse.BUSINESS);
		authenticator.setTelecoms(telecoms);
		return authenticator;
	}

	public static Author getMdInfo() {
		final Name docName = new Name("John", "Doe", "Prof.");
		final Author doc = new Author(docName, "7608888888888"); // G
		final Telecoms docTelecoms = new Telecoms();
		docTelecoms.addPhone("+41322345566", AddressUse.PRIVATE);
		docTelecoms.addFax("+41322345567", AddressUse.BUSINESS);
		doc.setTelecoms(docTelecoms);
		doc.setOrganization(new Organization("HUG", "7608888888888"));

		final Address addr = new Address("rue Gabrielle-Perret-Gentil, 4", "1205", "Geneva",
				AddressUse.BUSINESS);
		addr.setCountry("CH");
		doc.addAddress(addr);
		return doc;
	}

	private DispenseItemEntry disItem1 = null;

	private IVL_TS effectiveTimePadv1;
	/** The SLF4J logger instance. */

	private final XPathFactory factory = XPathFactory.newInstance();
	private Identificator idDis1;

	private Identificator idMtp1;
	private Identificator idPadv1;
	private Identificator idPre1;
	private LanguageCode languageCode = LanguageCode.ENGLISH;
	protected final Logger log = LoggerFactory.getLogger(getClass());
	private MedicationFullfillmentInstructionsEntry medicationFullfillmentInstructions1;
	private MedicationTreatmentPlanItemEntry mtpItem1 = null;
	private CdaChMtpsMtp mtpMtpsDoc;
	private PharmaceuticalAdviceItemEntry padvItem1 = null;
	private PatientMedicalInstructionsEntry patientMedicalInstructions1;
	private CdaChMtpsPml pmlMtpsDoc;

	private PrescriptionItemEntry preItem1 = null;

	private Reference referenceXcrpt;

	private SubstanceAdministration substanceAdministrationMtp1;

	private final XPath xpath = factory.newXPath();

	public CdaChMtpsPmlTest() {
		super();
	}

	/**
	 * Add each item in doc (medicationlist) create a medication treatment plan
	 * item, must be based on PHARM:MTP MTP: Plan médicamenteux -> chapter
	 * 7.5.5.5 à la page 61. 7.5.1.1 Model
	 */
	private void addBodySections() {

		// Create MTP Items Plan de traitement médicamenteux
		mtpItem1 = createMedicationTreatmentPlanItemEntry1();
		/** REFR to MTPItem **/
		final MedicationTreatmentPlanItemReferenceEntry refToMTP1 = createMtpItemReferenceEntry(
				mtpItem1);
		// add the entries in the document PML section, starting with the

		// test the entry add in Mtp
		final CdaChMtpsMtp cdaMtp = new CdaChMtpsMtp();
		cdaMtp.setMtpEntry(mtpItem1);
		cdaMtp.getMtpEntry();
		// MTPItemEntry
		pmlMtpsDoc.addMtpEntry(mtpItem1);
		// PRE: Prescriptions -> chapitre 7.5.7 à la page 65.
		preItem1 = createPrescriptionItemEntry();
		preItem1.setMedicationTreatmentPlanItemReferenceEntry(refToMTP1);

		// test the entry add in Pre (list of substanceAdmin)
		final CdaChMtpsPre cdaPre = new CdaChMtpsPre();
		cdaPre.addPrescriptionItemEntry(preItem1);
		cdaPre.getPrescriptionItemEntries();

		pmlMtpsDoc.getMedicationListSection().addPrescriptionItemEntry(preItem1);
		// DIS: Dispensations -> chapitre 7.5.8 à la page 69.
		disItem1 = createDispenseItemEntry();
		disItem1.setMedicationTreatmentPlanItemReferenceEntry(refToMTP1);

		// test the entry set in Dis (list of disItems)
		final CdaChMtpsDis cdaDis = new CdaChMtpsDis();
		cdaDis.setDispenseItemEntry(disItem1);
		cdaDis.getDispenseItemEntry();
		pmlMtpsDoc.getMedicationListSection().addDispenseItemEntry(disItem1);
		// PADV: Conseils pharmaceutiques -> chapitre 7.5.9 à la page 72.
		padvItem1 = createPadvItemEntry();

		// Add the references
		padvItem1.setDispenseItemReferenceEntry(createDispenseItemReferenceEntry(disItem1));
		padvItem1.setPrescriptionItemReferenceEntry(createPreItemReferenceEntry(preItem1));
		padvItem1.setMedicationTreatmentPlanItemReferenceEntry(refToMTP1);
		// test the entry add in Padv (list of Padv entries)
		final CdaChMtpsPadv cdaPadv = new CdaChMtpsPadv();
		cdaPadv.setPadvItemEntry(padvItem1);
		cdaPadv.getPadvItemEntry();
		pmlMtpsDoc.getMedicationListSection().addPharmaceuticalAdviceItemEntry(padvItem1);
	}

	private void addBodySectionsMtp() {

		// Create MTP Items Plan de traitement médicamenteux
		mtpMtpsDoc.setId(idMtp1);
		mtpMtpsDoc.setPatientInstructions("humecter uniquement avec du NaCl");
		mtpMtpsDoc.setProfessionalInstructions("découper avant de panser");
		mtpMtpsDoc.setReference(createIdentificator1());
		mtpMtpsDoc.addSubstanceAdministration(getNullFlavorCe(), getNullFlavorCe(),
				getDoseQuantity(), getRateQuantity(), createStartTime(), getConsumable(),
				createAuthor1(), createApproachSiteCode1(), createStartTime(), getEndTime(),
				RouteOfAdministration.PO, createUniqueDailyDose("25.12.2016"),
				getMultipleDailyDoses(), new Double(10), getQtyUnit(), true);
	}

	private Reference assignReference(Identificator idRoot) {

		final Reference ref = CDAFactory.eINSTANCE.createReference();
		ref.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(idRoot);
		ref.setExternalDocument(documentEntry.getMdht());
		return ref;
	}

	private Author createAdviceAuthor1() {

		final Name name = new Name("Conseiller", "Médecin", "Dr.");
		final Author author = new Author(name, "7601000000000");
		final Code functionCode = new Code("2.16.756.5.30.2.1.1.1", "PCP",
				"eCH ParticipationFunction", "Medical doctors");
		author.setFunctionCode(functionCode);
		author.setTime(new Date());

		final AssignedAuthor assignedAuthor = CDAFactory.eINSTANCE.createAssignedAuthor();
		final II authorID = DatatypesFactory.eINSTANCE.createII("1.3.88", author.getGln());
		assignedAuthor.getIds().add(authorID);
		final Code assignedAuthorCodefunctionCode = new Code("2.16.756.5.30.1.127.3.2.1.5", "50001",
				"Médecin spécialiste en médecine interne générale",
				"EPD_XDS_healthcareFacilityTypeCode");
		assignedAuthor.setCode(assignedAuthorCodefunctionCode.getCE());
		author.setAsAuthor(assignedAuthor);
		final Telecoms telecoms = new Telecoms();
		telecoms.addPhone("+41322345567", AddressUse.BUSINESS);
		telecoms.addEMail("medecin.famille@hin.ch", AddressUse.BUSINESS);
		final Organization representedOrganization = new Organization(name.getCompleteName());
		representedOrganization.setTelecoms(telecoms);
		representedOrganization.addId(new Identificator(authorID));
		representedOrganization.addAddress(new Address("Rue des Malades", "13", "1213", "Geneva"));
		author.setOrganization(representedOrganization);
		return author;
	}

	private CD createApproachSiteCode1() {

		final CD approachSiteCode = getNullFlavorCd();
		approachSiteCode.setCodeSystem("(2.16.840.1.113883.6.96");
		approachSiteCode
				.setOriginalText(DatatypesFactory.eINSTANCE.createED("reference value='#...'"));
		return approachSiteCode;
	}

	public DispenseItemEntry createDispenseItemEntry() {
		/** DIS Item Declaration **/
		final DispenseItemEntry disEntry = new DispenseItemEntry(getLanguageCode());

		/** REFR to MTPItem **/
		//
		/** Document ID **/
		disEntry.setId(idDis1);

		/** ExternalDocument MTP **/
		/*
		 * [R2] Identifiant du document duquel cet élément provient lorsque
		 * l’élément se trouve dans un document PML [NP] Lorsque l’élément se
		 * trouve dans un document PRE
		 */

		/** Precondition/Criterion/Text **/
		/*
		 * Préconditions pour l’utilisation du médicament. La référence au texte
		 * correspondant dans la partie lisible pour l’être humain doit être
		 * indiquée au moyen de criterion/text/reference[@value=‘#<valeur de
		 * content[@ID]>‘]
		 */

		/** DispenseItem **/

		// final Supply deliveredProduct = getSupply();
		// disEntry.getMdht().addSupply(deliveredProduct);
		disEntry.getMdht().setClassCode(ActClassSupply.SPLY);
		disEntry.getMdht().setMoodCode(x_DocumentSubstanceMood.RQO);
		disEntry.getMdht().setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		disEntry.getMdht().getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.4", "IHE PHARM").getIi());
		disEntry.getMdht().getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.34", "HL7 CCD").getIi());
		disEntry.getMdht().getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.3", "IHE PCC").getIi());
		disEntry.getMdht().setClassCode(ActClassSupply.SPLY);
		disEntry.getMdht().setMoodCode(x_DocumentSubstanceMood.EVN);
		disEntry.getMdht().setCode(DatatypesFactory.eINSTANCE.createCD("2.16.840.1.113883.5.4",
				CodeSystems.HL7ActCode.getCodeSystemName()));
		final Product product = CDAFactory.eINSTANCE.createProduct();
		product.setManufacturedProduct(getProduct());
		disEntry.getMdht().setProduct(product);
		/** Reference **/
		final Reference referenceXCRPT = CDAFactory.eINSTANCE.createReference();
		referenceXCRPT.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(pmlMtpsDoc.getId());
		referenceXCRPT.setExternalDocument(documentEntry.getMdht());
		disEntry.getMdht().getReferences().add(referenceXCRPT);
		/** OK **/
		// Authors
		disEntry.getMdht().getAuthors().add(createDispenseAuthor1().getAuthorMdht());

		/** OK **/
		// Date de début de prescription
		disEntry.getMdht().getEffectiveTimes().add(createStartTime());

		/** OK **/
		// Date de fin
		disEntry.getMdht().getEffectiveTimes().add(getEndTime());

		// Prescripteur

		// Auteur Prescription
		disEntry.getMdht().getAuthors().add(createPrescriptionAuthor2().getAuthorMdht());

		// Auteur Dispensation

		disEntry.getMdht().getAuthors().add(createDispenseAuthor2().getAuthorMdht());

		/** OK **/
		// Dose journalière
		disEntry.getMdht().getEntryRelationships().add(getDailyDosage());

		/** OK **/
		// Quantité prescrite / à remettre
		disEntry.getMdht().getEntryRelationships().add(getPrescribedQty());

		/** OK **/
		// Raison du traitement
		disEntry.getMdht().addAct(getReasonOfTreatment());

		/** OK **/
		// Substitution autorisée
		final PharmSubstitutionMade substitution = CDAFactory.eINSTANCE
				.createPharmSubstitutionMade();
		substitution.setClassCode(ActClassRoot.SUBST);
		substitution.setMoodCode(ActMood.EVN);
		final CE pharmCode = DatatypesFactory.eINSTANCE.createCE("2.16.840.1.113883.5.1070",
				"HL7 Substance Admin Substitution");
		substitution.setCode(pharmCode);

		final PharmComponent1 component1 = CDAFactory.eINSTANCE.createPharmComponent1();
		component1.setSubstitutionMade(substitution);
		disEntry.getMdht().setComponent1(component1);
		return disEntry;
	}

	private DispenseItemReferenceEntry createDispenseItemReferenceEntry(DispenseItemEntry mdht) {
		final DispenseItemReferenceEntry referenceEntry = new DispenseItemReferenceEntry();
		/*
		 * referenceEntry.getMdht().getTemplateIds() .add((new
		 * Identificator("1.3.6.1.4.1.19376.1.9.1.3.4", null).getIi()));
		 * referenceEntry.getMdht().getTemplateIds() .add((new
		 * Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.3", null).getIi()));
		 * referenceEntry.getMdht().getTemplateIds() .add((new
		 * Identificator("2.16.840.1.113883.10.20.1.34", null).getIi()));
		 */
		final SubstanceAdministration administration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		administration.getIds().add(mdht.getId().getIi());
		administration.setMoodCode(mdht.getMdht().getMoodCode());
		administration.setCode(mdht.getMdht().getCode());
		administration.setClassCode(ActClass.SPLY);
		final org.openhealthtools.mdht.uml.cda.Consumable consumable = CDAFactory.eINSTANCE
				.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		administration.setConsumable(consumable);
		referenceEntry.getMdht().addSubstanceAdministration(administration);
		return referenceEntry;
	}

	private IVL_TS createEffectiveTimePadv1() {

		final IVL_TS ivlTs1 = DatatypesFactory.eINSTANCE.createIVL_TS();
		ivlTs1.setValue("20161931093000");
		return ivlTs1;
	}

	private CdaChMtpsPml createHeader() {

		final Author md = getMdInfo();
		final Author legalAuthenticator = getLegalAuthenticatorInfo();
		final Organization mdOrganization = new Organization("HUG", "7608888888888");
		final Address mdAddress = new Address("rue Gabrielle-Perret-Gentil, 4", "1205", "Geneva",
				AddressUse.BUSINESS);
		mdAddress.setCountry("CH");

		mdOrganization.addAddress(mdAddress);
		mdOrganization.setTelecoms(md.getTelecoms());

		final Patient patient = createPatientTest("Benjamin", "Castaldi");

		final Identificator mtpsPmlId = createPmlId();

		// Create CDACHMTPSPML (Header)
		final CdaChMtpsPml d = new CdaChMtpsPml();
		d.setTimestamp(new Date());
		d.setLegalAuthenticator(legalAuthenticator);
		d.setCustodian(mdOrganization);
		d.setLanguageCode(getLanguageCode());
		d.addAuthor(md); // author obligatoire
		d.setPatient(patient); // recordTarget obligatoire
		d.setId(mtpsPmlId);
		referenceXcrpt = assignReference(mtpsPmlId);
		return d;
	}

	private CdaChMtpsMtp createHeaderMtp() {

		final Author md = getMdInfo();
		final Author legalAuthenticator = getLegalAuthenticatorInfo();
		final Organization mdOrganization = new Organization("HUG", "7608888888888");
		final Address mdAddress = new Address("rue Gabrielle-Perret-Gentil, 4", "1205", "Geneva",
				AddressUse.BUSINESS);
		mdAddress.setCountry("CH");

		mdOrganization.addAddress(mdAddress);
		mdOrganization.setTelecoms(md.getTelecoms());

		// Patient (recordTarget)
		final Name patientName = new Name("David", "Issom");
		final Patient patient = new Patient(patientName, AdministrativeGender.MALE,
				DateUtil.date("27.10.1987"));
		final Address patientAdresse = new Address("rue Le-Corbusier", "13A", "1208",
				"Genève"/*
						 * , AddressUse.PRIVATE
						 */);
		final Telecoms patientTelecoms = new Telecoms();
		patientTelecoms.addPhone("+41763064535", AddressUse.PRIVATE);
		patient.setTelecoms(patientTelecoms);

		// Adding an id using an OID that is already known by the convenience
		// API (AHV-Nr/No AVS/SSN)
		// patient.addId(new
		// Identificator(CodeSystems.SwissSSNDeprecated.getCodeSystemId(),"123.71.332.115"));

		// Adding an id using an OID that is not known by the convenience API,
		// yet
		patient.addId(new Identificator("8077560000000000000000", "2.16.756.5.30.1.123.100.1.1.1"));
		patient.addAddress(patientAdresse);
		final Identificator mtpsPmlId = createPmlId();

		// Create CDACHMTPSPML (Header)
		final CdaChMtpsMtp d = new CdaChMtpsMtp();
		d.setTimestamp(new Date());
		d.setLegalAuthenticator(legalAuthenticator);
		d.setCustodian(mdOrganization);
		d.setLanguageCode(getLanguageCode());
		d.addAuthor(md); // author obligatoire
		d.setPatient(patient); // recordTarget obligatoire
		d.setId(mtpsPmlId);
		referenceXcrpt = assignReference(mtpsPmlId);
		return d;
	}

	@SuppressWarnings("unused")
	private Identificator createIdentificator(MedicationItemEntry medicationItemEntry) {
		Identificator id = null;
		if ((medicationItemEntry.getIds() != null) && (medicationItemEntry.getIds().size() > 0)) {
			id = new Identificator(medicationItemEntry.getIds().get(0));
		}
		return id;
	}

	private Identificator createIdentificator(String oid, String id) {

		return new Identificator(oid, id);
	}

	/**
	 * Fields uniqueID of the planification code giving complementary
	 * information about substanceAdministration, e.g. "no known medication"
	 * human readable text statuscode => completed author reference
	 */
	public MedicationTreatmentPlanItemEntry createMedicationTreatmentPlanItemEntry1() {
		/** MTP Item Declaration **/
		final MedicationTreatmentPlanItemEntry mtpEntry = new MedicationTreatmentPlanItemEntry(
				getLanguageCode());
		/** ID **/
		mtpEntry.setId(idMtp1);
		/** Instructions pour le patient **/
		mtpEntry.setPatientMedicalInstructions(patientMedicalInstructions1);
		/** Instructions pour les professionnels **/
		mtpEntry.setMedicationFullfillmentInstructions(medicationFullfillmentInstructions1);
		/** Reference **/
		mtpEntry.getMdht().getReferences().add(referenceXcrpt);
		/** SubstanceAdministration **/
		mtpEntry.getMdht().addSubstanceAdministration(substanceAdministrationMtp1);
		return mtpEntry;

	}

	private MedicationTreatmentPlanItemReferenceEntry createMtpItemReferenceEntry(
			MedicationTreatmentPlanItemEntry mtpe) {

		final MedicationTreatmentPlanItemReferenceEntry referenceEntry = new MedicationTreatmentPlanItemReferenceEntry();
		referenceEntry.getMdht().getTemplateIds()
				.add((new Identificator("1.3.6.1.4.1.19376.1.9.1.3.7", null).getIi()));
		final SubstanceAdministration administration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		administration.getIds().add(mtpe.getId().getIi());
		administration.setMoodCode(mtpe.getMdht().getMoodCode());
		administration.setCode(mtpe.getMdht().getCode());
		administration.setClassCode(mtpe.getMdht().getClassCode());
		final org.openhealthtools.mdht.uml.cda.Consumable consumable = CDAFactory.eINSTANCE
				.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		administration.setConsumable(consumable);
		referenceEntry.getMdht().addSubstanceAdministration(administration);

		return referenceEntry;
	}

	@SuppressWarnings("unused")
	private Observation createObservation(II mtpId) {

		final Observation observationPadv = CDAFactory.eINSTANCE.createObservation();
		/** REFR to MTPItem **/
		//
		/*
		 * if (mtpId != null) {
		 * observationPadv.getEntryRelationships().add(getMtpReference(mtpId));
		 * }
		 */
		/** ExternalDocument MTP **/
		/*
		 * [R2] Identifiant du document duquel cet élément provient lorsque
		 * l’élément se trouve dans un document PML [NP] Lorsque l’élément se
		 * trouve dans un document PRE
		 */

		/** Precondition/Criterion/Text **/
		/*
		 * Préconditions pour l’utilisation du médicament. La référence au texte
		 * correspondant dans la partie lisible pour l’être humain doit être
		 * indiquée au moyen de criterion/text/reference[@value=‘#<valeur de
		 * content[@ID]>‘]
		 */

		observationPadv.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.3", "IHE PHARM").getIi());
		observationPadv.setClassCode(ActClassObservation.OBS);
		observationPadv.setMoodCode(x_ActMoodDocumentObservation.EVN);
		observationPadv.setCode(DatatypesFactory.eINSTANCE.createCD("1.3.6.1.4.1.19376.1.9.2.1",
				PharmaceuticalAdviceStatusList.CODE_SYSTEM_NAME));
		observationPadv.setText(DatatypesFactory.eINSTANCE.createED("reference value='#...'"));

		/** OBSERVATION **/
		observationPadv.addSubstanceAdministration(createSubstanceAdministration1());

		/** OK **/
		// Authors

		observationPadv.getAuthors().add(createPlanificationAuthor().getAuthorMdht());

		/** OK **/
		// Nouvelle prescription
		final EntryRelationship newPrescription = CDAFactory.eINSTANCE.createEntryRelationship();
		newPrescription.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		newPrescription.setInversionInd(false);
		final Organizer organizer = CDAFactory.eINSTANCE.createOrganizer();
		organizer.setClassCode(x_ActClassDocumentEntryOrganizer.CLUSTER);
		organizer.setMoodCode(ActMood.EVN);
		final CS statusCodeOrganizer = DatatypesFactory.eINSTANCE.createCS();
		statusCodeOrganizer.setCode(StatusCode.COMPLETED_CODE);
		organizer.setStatusCode(statusCodeOrganizer);
		final Component4 newPrescriptionComponent = CDAFactory.eINSTANCE.createComponent4();
		newPrescriptionComponent.setSeperatableInd(DatatypesFactory.eINSTANCE.createBL(false));
		newPrescriptionComponent.setSubstanceAdministration(createSubstanceAdministration1());
		organizer.getComponents().add(newPrescriptionComponent);
		newPrescription.setOrganizer(organizer);
		observationPadv.getEntryRelationships().add(newPrescription);

		/** OK **/
		// NewPlanification
		final EntryRelationship newPlanification = CDAFactory.eINSTANCE.createEntryRelationship();
		newPlanification.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		newPlanification.setInversionInd(false);
		newPlanification.setSubstanceAdministration(createSubstanceAdministration1());
		observationPadv.getEntryRelationships().add(newPlanification);

		/** OK **/
		// Dosage
		observationPadv.getEntryRelationships().add(getDailyDosage());

		return observationPadv;
	}

	private PharmaceuticalAdviceItemEntry createPadvItemEntry() {

		/** DIS Item Declaration **/

		final PharmaceuticalAdviceItemEntry padvEntry = new PharmaceuticalAdviceItemEntry(
				getLanguageCode());
		/** Document ID **/
		padvEntry.setId(idPadv1);
		padvEntry.getMdht().getAuthors().add(getLegalAuthenticatorInfo().getAuthorMdht());
		padvEntry.setTextReference("#padv1");
		// final Observation observationPadv = createObservation(mtpId);
		// observationPadv.addObservation(observationPadv);
		/*
		 * if (mtpId != null) {
		 * padvEntry.getMdht().getEntryRelationships().add(getMtpReference(mtpId
		 * )); }
		 */
		/** ExternalDocument MTP **/
		/*
		 * [R2] Identifiant du document duquel cet élément provient lorsque
		 * l’élément se trouve dans un document PML [NP] Lorsque l’élément se
		 * trouve dans un document PRE
		 */

		/** Precondition/Criterion/Text **/
		/*
		 * Préconditions pour l’utilisation du médicament. La référence au texte
		 * correspondant dans la partie lisible pour l’être humain doit être
		 * indiquée au moyen de criterion/text/reference[@value=‘#<valeur de
		 * content[@ID]>‘]
		 */

		/*
		 * padvEntry.getMdht().getTemplateIds() .add(new
		 * Identificator("1.3.6.1.4.1.19376.1.9.1.3.3", "IHE PHARM").getIi());
		 */

		/** OBSERVATION => Nouvelle Planification **/
		// NEED TO BE RETESTED
		// padvEntry.getMdht().addSubstanceAdministration(getSubstanceAdministration1());

		padvEntry.getMdht().setClassCode(ActClassObservation.OBS);
		padvEntry.getMdht().setMoodCode(x_ActMoodDocumentObservation.EVN);
		padvEntry.getMdht().setCode(DatatypesFactory.eINSTANCE.createCD("1.3.6.1.4.1.19376.1.9.2.1",
				PharmaceuticalAdviceStatusList.CODE_SYSTEM_NAME));
		padvEntry.getMdht().setText(DatatypesFactory.eINSTANCE.createED("#padv1"));
		/** Reference **/
		final Reference referenceXCRPT = CDAFactory.eINSTANCE.createReference();
		referenceXCRPT.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(pmlMtpsDoc.getId());
		referenceXCRPT.setExternalDocument(documentEntry.getMdht());
		padvEntry.getMdht().getReferences().add(referenceXCRPT);

		/** EFFECTIVE TIMES **/
		padvEntry.getMdht().setEffectiveTime(effectiveTimePadv1);
		/** OK **/
		// Authors
		padvEntry.getMdht().getAuthors().add(createAdviceAuthor1().getAuthorMdht());

		/** OK **/
		// Nouvelle prescription
		final EntryRelationship newPrescription = CDAFactory.eINSTANCE.createEntryRelationship();
		newPrescription.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		newPrescription.setInversionInd(false);
		final Organizer organizer = CDAFactory.eINSTANCE.createOrganizer();
		organizer.setClassCode(x_ActClassDocumentEntryOrganizer.CLUSTER);
		organizer.setMoodCode(ActMood.EVN);
		final CS statusCodeOrganizer = DatatypesFactory.eINSTANCE.createCS();
		statusCodeOrganizer.setCode(StatusCode.COMPLETED_CODE);
		organizer.setStatusCode(statusCodeOrganizer);
		final Component4 newPrescriptionComponent = CDAFactory.eINSTANCE.createComponent4();
		newPrescriptionComponent.setSeperatableInd(DatatypesFactory.eINSTANCE.createBL(false));
		newPrescriptionComponent.setSubstanceAdministration(createSubstanceAdministration1());
		organizer.getComponents().add(newPrescriptionComponent);
		newPrescription.setOrganizer(organizer);
		padvEntry.getMdht().getEntryRelationships().add(newPrescription);

		/** OK **/
		// NewPlanification
		final EntryRelationship newPlanification = CDAFactory.eINSTANCE.createEntryRelationship();
		newPlanification.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		newPlanification.setInversionInd(false);
		newPlanification.setSubstanceAdministration(createSubstanceAdministration1());
		padvEntry.getMdht().getEntryRelationships().add(newPlanification);

		/** OK **/
		// Dosage
		padvEntry.getMdht().getEntryRelationships().add(getDailyDosage());
		return padvEntry;
	}

	private PatientMedicalInstructionsEntry createPatientMedicalInstructions1(String instructions) {

		final PatientMedicalInstructionsEntry pi = new PatientMedicalInstructionsEntry();
		pi.setTextReference(instructions);
		pi.getMdht().setText(DatatypesFactory.eINSTANCE.createED(instructions));
		return pi;
	}

	private Patient createPatientTest(String firstName, String lastName) {

		final Name patientName = new Name(firstName, lastName);
		final Patient patient = new Patient(patientName, AdministrativeGender.MALE,
				DateUtil.date("27.10.1987"));
		final Address patientAdresse = new Address("rue Le-Corbusier", "13A", "1208",
				"Genève"/*
						 * , AddressUse.PRIVATE
						 */);
		final Telecoms patientTelecoms = new Telecoms();
		patientTelecoms.addPhone("+41763064535", AddressUse.PRIVATE);
		patient.setTelecoms(patientTelecoms); // Patient (recordTarget)

		// Adding an id using an OID that is already known by the convenience
		// API (AHV-Nr/No AVS/SSN)
		// patient.addId(new
		// Identificator(CodeSystems.SwissSSNDeprecated.getCodeSystemId(),"123.71.332.115"));

		// Adding an id using an OID that is not known by the convenience API,
		// yet
		patient.addId(new Identificator("8077560000000000000000", "2.16.756.5.30.1.123.100.1.1.1"));
		patient.addAddress(patientAdresse);
		return patient;
	}

	private Identificator createPmlId() {

		return new Identificator("2.16.756.5.30.4.9.1.1.9000.97005632.20150813083515.1",
				"MTPS-V1-PML-FULL");
	}

	private Identificator createPreIdentificator1() {

		return new Identificator("2.16.756.5.30.4.9.1.1.9000.97005632.20150505140000.1",
				"MTPS-V1-PRE1.1");
	}

	private PrescriptionItemReferenceEntry createPreItemReferenceEntry(PrescriptionItemEntry mdht) {

		final PrescriptionItemReferenceEntry referenceEntry = new PrescriptionItemReferenceEntry();
		referenceEntry.getMdht().getTemplateIds()
				.add((new Identificator("1.3.6.1.4.1.19376.1.9.1.3.2", null).getIi()));
		final SubstanceAdministration administration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		administration.getIds().add(mdht.getId().getIi());
		administration.setMoodCode(mdht.getMdht().getMoodCode());
		administration.setCode(mdht.getMdht().getCode());
		administration.setClassCode(mdht.getMdht().getClassCode());
		final org.openhealthtools.mdht.uml.cda.Consumable consumable = CDAFactory.eINSTANCE
				.createConsumable();
		final ManufacturedProduct manufacturedProduct = CDAFactory.eINSTANCE
				.createManufacturedProduct();
		final Material material = CDAFactory.eINSTANCE.createMaterial();
		material.setNullFlavor(NullFlavor.NA);
		manufacturedProduct.setManufacturedMaterial(material);
		consumable.setManufacturedProduct(manufacturedProduct);
		administration.setConsumable(consumable);
		referenceEntry.getMdht().addSubstanceAdministration(administration);
		return referenceEntry;
	}

	public PrescriptionItemEntry createPrescriptionItemEntry() {
		/** PRE Item Declaration **/
		final PrescriptionItemEntry preEntry = new PrescriptionItemEntry(getLanguageCode());
		/** Document ID **/
		preEntry.setId(idPre1);
		/** TEXT REFERENCE **/
		preEntry.setTextReference("#pre.1.1");
		/** Precondition/Criterion/Text IS NOT IMPLEMENTED YET **/
		/*
		 * Préconditions pour l’utilisation du médicament. La référence au texte
		 * correspondant dans la partie lisible pour l’être humain doit être
		 * indiquée au moyen de criterion/text/reference[@value=‘#<valeur de
		 * content[@ID]>‘]
		 */

		/** SubstanceAdministration **/
		final SubstanceAdministration substanceAdministration = createSubstanceAdministration1();
		/** Reference **/
		substanceAdministration.getReferences().add(referenceXcrpt);

		/** OK **/
		// Consumable (Substance(s) active(s) et Produit)
		preEntry.getMdht().setConsumable(getConsumable().getMdht());

		/** OK **/
		// Authors
		preEntry.getMdht().getAuthors().add(createPrescriptionAuthor().getAuthorMdht());

		/** OK **/
		// Site d’administration
		preEntry.getMdht().getApproachSiteCodes().add(createApproachSiteCode1());

		/** OK **/
		// Date de début de prescription
		preEntry.getMdht().getEffectiveTimes().add(createStartTime());

		// Dose journalière- fréquence (prise quotidienne unique)
		preEntry.getMdht().getEffectiveTimes().add(createUniqueDailyDose("10.11.2015"));

		// Dose journalière- fréquence (prise quotidienne multiple)
		preEntry.getMdht().getEffectiveTimes().add(getMultipleDailyDoses());

		// doseQuantity - Quantité unitaire (unit of Quantité [supply] class)
		preEntry.getMdht().setDoseQuantity(getDoseQuantity());

		/** OK **/
		// Date de fin
		preEntry.getMdht().getEffectiveTimes().add(getEndTime());

		/** OK **/
		// Dose journalière- fréquence (prise quotidienne unique)
		preEntry.getMdht().getEffectiveTimes().add(createUniqueDailyDose("04.04.2014"));

		/** OK **/
		// repeatNumber
		preEntry.getMdht().setRepeatNumber(getRepeatNumber());

		/** OK **/
		// rateQuantity
		preEntry.getMdht().setRateQuantity(getRateQuantity());

		/** OK **/
		// Quantité prescrite / à remettre
		preEntry.getMdht().getEntryRelationships().add(getPrescribedQty());

		/** OK **/
		// Raison du traitement
		preEntry.getMdht().addAct(getReasonOfTreatment());

		/** OK **/
		// Substitution autorisée
		preEntry.getMdht().getEntryRelationships().add(getPossibleSubstitution());
		preEntry.getMdht().addSubstanceAdministration(substanceAdministration);

		return preEntry;
	}

	private MedicationFullfillmentInstructionsEntry createProfessionalInstructions1(
			String instructions) {

		final MedicationFullfillmentInstructionsEntry professionnalInstructions = new MedicationFullfillmentInstructionsEntry();
		professionnalInstructions.setTextReference(instructions);
		return professionnalInstructions;
	}

	private SXCM_TS createStartTime() {

		final SXCM_TS startTime = DatatypesFactory.eINSTANCE.createSXCM_TS();
		startTime.setValue(DateUtil.formatDate(new Date(2016, 10, 7, 12, 30)));
		return startTime;
	}

	public SubstanceAdministration createSubstanceAdministration(CE priorityCode, CE routeCode,
			IVL_PQ doseQuantity, IVL_PQ rateQuantity, SXCM_TS planificationTime,
			Consumable consumable, Author author, CD approachSite, SXCM_TS startTime,
			SXCM_TS endTime,
			org.ehealth_connector.cda.ch.mtps.enums.RouteOfAdministration routeOfAdministration,
			SXCM_TS uniqueDailyDoseTime, SXCM_TS multipleDailyDoseTime, Double prescribedQuantity,
			String unitOfPrescribedQuantity, boolean isSubstitionPossible,
			Identificator idReferencedDocument, ArrayList<Identificator> templateIds) {
		final SubstanceAdministration substanceAdministration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		substanceAdministration.setClassCode(ActClass.SBADM);
		substanceAdministration.setMoodCode(x_DocumentSubstanceMood.EVN);

		for (final Identificator identificator : templateIds) {
			substanceAdministration.getTemplateIds().add(identificator.getIi());
		}
		substanceAdministration.getIds().add(DatatypesFactory.eINSTANCE.createII(NullFlavor.NA));
		final Code code = new Code("2.16.840.1.113883.5.4", "DRUG", "Medikamentöse Therapie");
		substanceAdministration.setCode(code.getCD());
		substanceAdministration.setText(Util.createReference("null"));
		substanceAdministration.setStatusCode(getCs("completed"));
		substanceAdministration.setPriorityCode(priorityCode);
		// doseQuantity - Quantité unitaire (unit of Quantité [supply] class)
		substanceAdministration.setDoseQuantity(doseQuantity);
		// rateQuantity
		substanceAdministration.setRateQuantity(rateQuantity);
		substanceAdministration.getEffectiveTimes().add(planificationTime);
		// Consumable (Substance(s) active(s) et Produit)
		substanceAdministration.setConsumable(consumable.getMdht());

		// Authors
		substanceAdministration.getAuthors().add(author.getAuthorMdht());

		// Site d’administration
		substanceAdministration.getApproachSiteCodes().add(approachSite);

		// Date de début -> effectiveTime (planification)
		substanceAdministration.getEffectiveTimes().add(startTime);
		// Date de fin
		substanceAdministration.getEffectiveTimes().add(endTime);

		// Voie d’administration (routeCode)
		substanceAdministration
				.setRouteCode(routeOfAdministration.getCode(this.getLanguageCode()).getCE());
		// mtpEntry.setRouteOfAdministration(getRouteOfAdministration());

		// Dose journalière- fréquence (prise quotidienne unique)
		if (uniqueDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes().add(uniqueDailyDoseTime);
		}
		// Dose journalière- fréquence (prise quotidienne multiple)
		if (multipleDailyDoseTime != null) {
			substanceAdministration.getEffectiveTimes().add(multipleDailyDoseTime);
		}

		// Quantité prescrite / à remettre
		substanceAdministration.getEntryRelationships()
				.add(getPrescribedQty(prescribedQuantity, unitOfPrescribedQuantity));

		// Raison du traitement (see Act -> SetReasonForTreatment)

		// Substitution autorisée
		if (isSubstitionPossible) {
			substanceAdministration.getEntryRelationships().add(getPossibleSubstitution());
		}
		// Reference ID de MTP
		final Reference referenceXCRPTToMTP = CDAFactory.eINSTANCE.createReference();
		referenceXCRPTToMTP.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(idReferencedDocument);
		referenceXCRPTToMTP.setExternalDocument(documentEntry.getMdht());
		substanceAdministration.getReferences().add(referenceXCRPTToMTP);
		return substanceAdministration;
	}

	public SubstanceAdministration createSubstanceAdministration1() {
		final SubstanceAdministration substanceAdministration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		substanceAdministration.setClassCode(ActClass.SBADM);
		substanceAdministration.setMoodCode(x_DocumentSubstanceMood.EVN);

		substanceAdministration.getTemplateIds()
				.add(new Identificator("2.16.756.5.30.1.1.1.1.1", "CDA-CH.Body.MediL3").getIi());
		substanceAdministration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.1", "IHE PHARM").getIi());
		substanceAdministration.getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.24", "HL7 CCD").getIi());
		substanceAdministration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7", "IHE PHARM").getIi());

		substanceAdministration.getIds().add(DatatypesFactory.eINSTANCE.createII(NullFlavor.NA));
		final Code code = new Code("2.16.840.1.113883.5.4", "DRUG", "Medikamentöse Therapie");
		substanceAdministration.setCode(code.getCD());
		substanceAdministration.setText(Util.createReference("null"));
		substanceAdministration.setStatusCode(getCs("completed"));
		substanceAdministration.setPriorityCode(getNullFlavorCe());
		substanceAdministration.setRouteCode(getNullFlavorCe());
		substanceAdministration.setDoseQuantity(getNullFlavorIvlPq());
		substanceAdministration.setRateQuantity(getNullFlavorIvlPq());
		substanceAdministration.getEffectiveTimes().add(getNullFlavorIvlTs());
		// Consumable (Substance(s) active(s) et Produit)
		substanceAdministration.setConsumable(getConsumable().getMdht());

		// Authors
		substanceAdministration.getAuthors().add(createPlanificationAuthor().getAuthorMdht());

		// Site d’administration
		substanceAdministration.getApproachSiteCodes().add(createApproachSiteCode1());

		// Date de début -> effectiveTime (planification)
		substanceAdministration.getEffectiveTimes().add(createStartTime());

		// Date de fin
		substanceAdministration.getEffectiveTimes().add(getEndTime());

		// Voie d’administration (routeCode)
		substanceAdministration.setRouteCode(getRouteOfAdministration().getCE());
		// mtpEntry.setRouteOfAdministration(getRouteOfAdministration());

		// Dose journalière- fréquence (prise quotidienne unique)
		substanceAdministration.getEffectiveTimes().add(createUniqueDailyDose("31.10.2016"));

		// Dose journalière- fréquence (prise quotidienne multiple)
		substanceAdministration.getEffectiveTimes().add(getMultipleDailyDoses());

		// doseQuantity - Quantité unitaire (unit of Quantité [supply] class)
		substanceAdministration.setDoseQuantity(getDoseQuantity());

		// rateQuantity
		substanceAdministration.setRateQuantity(getRateQuantity());

		// Quantité prescrite / à remettre
		substanceAdministration.getEntryRelationships().add(getPrescribedQty());

		// Raison du traitement
		substanceAdministration.addAct(getReasonOfTreatment());

		// Substitution autorisée
		substanceAdministration.getEntryRelationships().add(getPossibleSubstitution());
		// Reference
		final Reference referenceXCRPTToMTP = CDAFactory.eINSTANCE.createReference();
		referenceXCRPTToMTP.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(idMtp1);
		referenceXCRPTToMTP.setExternalDocument(documentEntry.getMdht());
		substanceAdministration.getReferences().add(referenceXCRPTToMTP);
		return substanceAdministration;
	}

	private SXCM_TS createTime(String dateMMDDYYYY) {

		final SXCM_TS startTime = DatatypesFactory.eINSTANCE.createSXCM_TS();
		startTime.setValue(DateUtil.formatDate(DateUtil.date(dateMMDDYYYY)));
		return startTime;
	}

	/**
	 * Fréquence de prise/administration/Dose journalière @7.5.10 ////
	 * Medication Frequency Content Module // Auteur de la planification (PML)
	 * ou pas d'auteur [NP] lors de MTP //// (p.88)
	 **/
	private SXCM_TS createUniqueDailyDose(String dateMMDDYYYY) {

		final SXCM_TS uniqueDosage = DatatypesFactory.eINSTANCE.createSXCM_TS();
		final EIVL_TS tS = DatatypesFactory.eINSTANCE.createEIVL_TS();
		tS.setValue(DateUtil.formatDate(DateUtil.date(dateMMDDYYYY)));
		uniqueDosage.setValue(tS.getValue());
		uniqueDosage.setOperator(SetOperator.A);
		final EIVL_event eventEIVL = DatatypesFactory.eINSTANCE.createEIVL_event();
		final Code eventCode = new Code("2.16.840.1.113883.5.139", TimingEvent.HS.getName());
		eventCode.setCode(eventCode.getCode());
		tS.setEvent(eventEIVL);
		return uniqueDosage;
	}

	private CdaChMtpsPml deserializeCda(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return new CdaChMtpsPml(// BUG: There would be an exception caught here
								// because SXPR_TS has
				// issues, and still has problems of implementation
				(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPml) CDAUtil.load(source));
	}

	private CdaChMtpsPml deserializeCdaDirect(String document) throws Exception {
		final InputStream stream = new ByteArrayInputStream(document.getBytes());
		final ClinicalDocument clinicalDocument = CDAUtil.loadAs(stream,
				CHPackage.eINSTANCE.getCdaChMtpsPml());
		return new CdaChMtpsPml(
				(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsPml) clinicalDocument);
	}

	@Test
	public void deserializeCdaDirectTest() throws Exception {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsPml cdaDeserialized = deserializeCdaDirect(deserialized);
		assertTrue(cdaDeserialized != null);

		final String deserialized2 = this.serializeDocument(cda);
		log.debug(deserialized2);

		assertNotNull(cdaDeserialized.getMedicationListSection());
		assertEquals("Medication List", cdaDeserialized.getMedicationListSection().getTitle());
	}

	@Test
	public void deserializeCdaTest() throws Exception {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsPml cdaDeserialized = deserializeCda(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private ClinicalDocument deserializeClinicalDocument(String document) throws Exception {
		final InputSource source = new InputSource(new StringReader(document));
		return CDAUtil.load(source);
	}

	@Test
	public void deserializeClinicalDocumentTest() throws Exception {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final ClinicalDocument cdaDeserialized = deserializeClinicalDocument(deserialized);
		assertTrue(cdaDeserialized != null);
	}

	private PharmAsContent getBoxDescription() {

		final PharmAsContent boxDescription = CDAFactory.eINSTANCE.createPharmAsContent();
		boxDescription.setClassCode(EntityClassManufacturedMaterial.CONT);
		boxDescription.setAsContainerPackagedMedicine(getPackMedicine());

		return boxDescription;
	}

	private PQ getCapacityQuantity() {

		return DatatypesFactory.eINSTANCE.createPQ(28, "pce");
	}

	private CE getCodeAsContent() {

		final CE codeAsContent = DatatypesFactory.eINSTANCE.createCE();
		codeAsContent.setCode("7680624080126");
		codeAsContent.setCodeSystem(CodeSystems.GTIN.getCodeSystemId());
		codeAsContent.setCodeSystemName(CodeSystems.GTIN.getCodeSystemName());
		codeAsContent.setDisplayName("CANDESARTAN Spirig HC cpr 16 mg 28 pce");

		return codeAsContent;
	}

	private CE getCodeManufacturedMaterial() {

		final CE codeMaterial = DatatypesFactory.eINSTANCE.createCE();
		codeMaterial.setCodeSystem("2.16.840.1.113883.5.85");
		codeMaterial.setCodeSystemName(CodeSystems.WHOATCCode.getCodeSystemName());
		codeMaterial.setCode("C09CA06");
		codeMaterial.setDisplayName("candesartan");
		return codeMaterial;
	}

	private Code getCodeWhoAtc() {

		return new Code("2.16.840.1.113883.6.73", "C09CA06",
				CodeSystems.WHOATCCode.getCodeSystemName());

	}

	/**
	 * Produit Nom (commercial) du médicament (consumable ->
	 * manufacturedProduct) Nom (commercial) de l’emballage Forme de
	 * dispensation Numéro de lot Taille de l’emballage
	 **/
	private Consumable getConsumable() {

		final Consumable consumable = new Consumable("CANDESARTAN Spirig HC cpr 16 mg");
		consumable.setLotNr("lotNr");
		consumable.setManufacturedProductId(getGtin());
		consumable.setWhoAtcCode(getCodeWhoAtc());
		consumable.setManufacturer(getOrganization());
		// Produit
		consumable.getMdht().setManufacturedProduct(getProduct());
		return consumable;
	}

	private CS getCs(String code) {
		final CS cs = DatatypesFactory.eINSTANCE.createCS();
		cs.setCode(code);
		return cs;
	}

	private EntryRelationship getDailyDosage() {

		final EntryRelationship dailyDosage = CDAFactory.eINSTANCE.createEntryRelationship();
		dailyDosage.setTypeCode(x_ActRelationshipEntryRelationship.COMP);

		final SubstanceAdministration administration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		administration.setClassCode(ActClass.SBADM);
		administration.setMoodCode(x_DocumentSubstanceMood.INT);
		administration.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.6", "IHE PHARM").getIi());
		final CD approachSiteCode = createApproachSiteCode1();
		administration.getApproachSiteCodes().add(approachSiteCode);
		administration.setRouteCode(getNullFlavorCe());
		administration.setDoseQuantity(getNullFlavorIvlPq());
		administration.setRateQuantity(getNullFlavorIvlPq());
		administration.getEffectiveTimes().add(getNullFlavorIvlTs());
		final Consumable consumable = getConsumable();
		consumable.getMdht().setNullFlavor(NullFlavor.NA);
		administration.setConsumable(getConsumable().getMdht());
		dailyDosage.setSubstanceAdministration(administration);
		return dailyDosage;
	}

	private IVL_PQ getDoseQuantity() {

		final IVL_PQ doseQuantity = DatatypesFactory.eINSTANCE.createIVL_PQ();
		doseQuantity.setUnit("mg");
		final IVXB_PQ highDose = DatatypesFactory.eINSTANCE.createIVXB_PQ();
		highDose.setValue((double) 16);
		final IVXB_PQ lowDose = DatatypesFactory.eINSTANCE.createIVXB_PQ();
		highDose.setValue((double) 1);
		doseQuantity.setHigh(highDose);
		doseQuantity.setLow(lowDose);
		doseQuantity.setUnit("mg");
		return doseQuantity;

	}

	private SXCM_TS getEndTime() {

		final SXCM_TS endTime = DatatypesFactory.eINSTANCE.createSXCM_TS();
		endTime.setValue(DateUtil.formatDate(DateUtil.date("27.10.2017")));
		return endTime;
	}

	private Identificator getGtin() {

		return new Identificator("1.3.160", "7680006370012"); // GTIN;
	}

	private PharmIngredient getIngredient() {

		// Ingrédients
		// SubstanceActive
		final PharmManufacturedMaterialEntry ingredientEntry = new PharmManufacturedMaterialEntry();
		final Value quantity = new Value(16, 1, Ucum.MilliGram);
		final String brandName = "various";
		ingredientEntry.setWhoAtcCode(getCodeWhoAtc());
		ingredientEntry.setIngredientName(brandName);
		ingredientEntry.setIngredientQuantity(quantity);
		return ingredientEntry.getMdht().getIngredient();
	}

	private LanguageCode getLanguageCode() {

		return languageCode;
	}

	private Material getManufacturedMaterial() {
		// manufacturematerial

		final Material manufacturedMaterial = CDAFactory.eINSTANCE.createMaterial();
		manufacturedMaterial.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.1", "IHE PHARM").getIi());
		manufacturedMaterial.setClassCode(EntityClassManufacturedMaterial.MMAT);
		manufacturedMaterial.setDeterminerCode(EntityDeterminerDetermined.KIND);
		manufacturedMaterial.setLotNumberText(DatatypesFactory.eINSTANCE.createST("lotNumber"));
		manufacturedMaterial.setName(getManufacturedMaterialName());
		manufacturedMaterial.setFormCode(OrderableDrugFrom.TAB.getCode().getCE());
		manufacturedMaterial.setAsContent(getBoxDescription());
		manufacturedMaterial.setCode(getCodeManufacturedMaterial());
		manufacturedMaterial.setIngredient(getIngredient());
		return manufacturedMaterial;
	}

	private EN getManufacturedMaterialName() {

		final EN mMname = DatatypesFactory.eINSTANCE.createEN();
		mMname.addText("CANDESARTAN Spirig");
		return mMname;
	}

	@SuppressWarnings("unused")
	private EntryRelationship getMtpReference(Identificator mtpId) {

		final EntryRelationship refToMtp = CDAFactory.eINSTANCE.createEntryRelationship();
		refToMtp.setTypeCode(x_ActRelationshipEntryRelationship.REFR);
		refToMtp.setSubstanceAdministration(null);
		final CE mtpCode = DatatypesFactory.eINSTANCE.createCE();
		mtpCode.setCodeSystem("1.3.6.1.4.1.19376.1.9.2.2");
		mtpCode.setCodeSystemName("IHE Pharmacy Item Type List’");
		mtpCode.setCode("MTPItem");
		mtpCode.setDisplayName("Medication Treatment Plan Item’");
		final Consumable consumable = new Consumable(false);
		final ManufacturedProduct product = CDAFactory.eINSTANCE.createManufacturedProduct();
		final Material manufacturedMaterial = CDAFactory.eINSTANCE.createMaterial();
		manufacturedMaterial.setNullFlavor(NullFlavor.NA);
		product.setManufacturedMaterial(manufacturedMaterial);
		consumable.getMdht().setManufacturedProduct(product);
		final SubstanceAdministration administration = CDAFactory.eINSTANCE
				.createSubstanceAdministration();
		administration.setClassCode(ActClass.SBADM);
		administration.setMoodCode(x_DocumentSubstanceMood.EVN);
		administration.getTemplateIds().add(mtpId.getIi());
		administration.setCode(mtpCode);
		administration.setClassCode(ActClass.SBADM);
		administration.setMoodCode(x_DocumentSubstanceMood.INT);
		refToMtp.setSubstanceAdministration(administration);
		return refToMtp;
	}

	/**
	 * If one or more effectiveTime elements appear, the first one shall contain
	 * either the time of a single dose in the value element using the TS data
	 * type, or the duration of the dosing regimen in an IVL_TS data type. The
	 * second effectiveTime element should represent the frequency of the dose,
	 * using either the PIVL_TS or the EIVL_TS type.  The PPD_IVL_TS or SXPR_TS
	 * data types may be used to represent more complex dosing regiments.
	 **/
	private SXCM_TS getMultipleDailyDoses() {

		// root of multiple doses
		final SXPR_TS sxcmTs = DatatypesFactory.eINSTANCE.createSXPR_TS();
		sxcmTs.setOperator(SetOperator.A);

		// beginning dose 1
		final SXPR_TS sxcmTsInner1 = DatatypesFactory.eINSTANCE.createSXPR_TS();
		// sxcmTs.getComps().add(sxcmTsInner1);
		final IVL_TS ivlTs1 = DatatypesFactory.eINSTANCE.createIVL_TS();
		final IVXB_TS low1 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		low1.setValue("20120505");
		final IVXB_TS high1 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		high1.setValue("20151105");
		ivlTs1.setLow(low1);
		ivlTs1.setHigh(high1);
		sxcmTsInner1.getComps().add(ivlTs1);

		final EIVL_TS eivlTs = DatatypesFactory.eINSTANCE.createEIVL_TS();
		final EIVL_event event = DatatypesFactory.eINSTANCE.createEIVL_event();
		event.setCode(TimingEvent.ACM.getName());
		eivlTs.setOperator(SetOperator.A);
		eivlTs.setEvent(event);
		sxcmTsInner1.getComps().add(eivlTs);
		// end dose 1

		// beginning dose 2
		final SXPR_TS sxcmTsInner2 = DatatypesFactory.eINSTANCE.createSXPR_TS();
		sxcmTsInner2.setOperator(SetOperator.I);
		sxcmTs.getComps().add(sxcmTsInner2);

		final IVL_TS ivlTs2 = DatatypesFactory.eINSTANCE.createIVL_TS();
		final IVXB_TS low2 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		low2.setValue("20130404");
		final IVXB_TS high2 = DatatypesFactory.eINSTANCE.createIVXB_TS();
		high2.setValue("20161107");
		ivlTs2.setLow(low2);
		ivlTs2.setHigh(high2);
		sxcmTsInner2.getComps().add(ivlTs2);

		final EIVL_TS eivlTs2 = DatatypesFactory.eINSTANCE.createEIVL_TS();
		final EIVL_event event2 = DatatypesFactory.eINSTANCE.createEIVL_event();
		event2.setCode(TimingEvent.ACV.getName());
		eivlTs2.setOperator(SetOperator.A);
		eivlTs2.setEvent(event2);
		sxcmTsInner2.getComps().add(eivlTs2);
		sxcmTs.getComps().add(sxcmTsInner2);
		// end dose 2
		return sxcmTs;
	}

	private CD getNullFlavorCd() {
		final CD cd = DatatypesFactory.eINSTANCE.createCD();
		cd.setNullFlavor(NullFlavor.NA);
		return cd;
	}

	private CE getNullFlavorCe() {
		final CE ce = DatatypesFactory.eINSTANCE.createCE();
		ce.setNullFlavor(NullFlavor.NA);
		return ce;
	}

	private II getNullFlavorIi() {
		return DatatypesFactory.eINSTANCE.createII(NullFlavor.NA);
	}

	private IVL_PQ getNullFlavorIvlPq() {
		final IVL_PQ ivl = DatatypesFactory.eINSTANCE.createIVL_PQ();
		ivl.setNullFlavor(NullFlavor.UNK);
		return ivl;
	}

	private IVL_TS getNullFlavorIvlTs() {
		final IVL_TS time = DatatypesFactory.eINSTANCE.createIVL_TS();
		time.setNullFlavor(NullFlavor.UNK);
		return time;
	}

	private Organization getOrganization() {

		return new Organization("GlaxoSmithKline");
	}

	private PharmPackagedMedicine getPackMedicine() {

		final PharmPackagedMedicine packMedicine = CDAFactory.eINSTANCE
				.createPharmPackagedMedicine();
		packMedicine.setClassCode(EntityClassManufacturedMaterial.CONT);
		packMedicine.setDeterminerCode(EntityDeterminer.INSTANCE);
		packMedicine.setCode(getCodeAsContent());
		packMedicine.setFormCode(OrderableDrugFrom.TAB.getCode().getCE());
		packMedicine.setCapacityQuantity(getCapacityQuantity());
		return packMedicine;
	}

	private EntryRelationship getPossibleSubstitution() {

		final EntryRelationship possibleSubstitution = CDAFactory.eINSTANCE
				.createEntryRelationship();
		possibleSubstitution.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		final Supply substitutionSupply = CDAFactory.eINSTANCE.createSupply();
		substitutionSupply.setClassCode(ActClassSupply.SPLY);
		substitutionSupply.setMoodCode(x_DocumentSubstanceMood.RQO);
		substitutionSupply.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));

		final PharmSubstitutionPermission substitutionPermissionSo4 = CDAFactory.eINSTANCE
				.createPharmSubstitutionPermission();
		substitutionPermissionSo4.setClassCode(ActClassRoot.SUBST);
		substitutionPermissionSo4.setMoodCode(ActMood.PERM);
		final CE pharmCode = DatatypesFactory.eINSTANCE.createCE();
		pharmCode.setCodeSystem("2.16.840.1.113883.5.1070");
		pharmCode.setCodeSystemName("HL7 Substance Admin Substitution");
		pharmCode.setCode("E");
		pharmCode.setDisplayName("equivalent");
		substitutionPermissionSo4.setCode(pharmCode);
		possibleSubstitution.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.9", "").getIi());

		final PharmSubjectOf4 subjectOf4 = CDAFactory.eINSTANCE.createPharmSubjectOf4();
		subjectOf4.setSubstitutionPermission(substitutionPermissionSo4);
		substitutionSupply.setSubjectOf4(subjectOf4);

		possibleSubstitution.setSupply(substitutionSupply);
		return possibleSubstitution;
	}

	private EntryRelationship getPrescribedQty() {

		final EntryRelationship prescribedQty = CDAFactory.eINSTANCE.createEntryRelationship();
		prescribedQty.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		final Supply prescribedQuantity = CDAFactory.eINSTANCE.createSupply();
		prescribedQuantity.setClassCode(ActClassSupply.SPLY);
		prescribedQuantity.setMoodCode(x_DocumentSubstanceMood.RQO);
		prescribedQuantity.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		final Double value = new Double(10);
		prescribedQuantity.setQuantity(
				DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), value.toString()));
		prescribedQuantity.setText(DatatypesFactory.eINSTANCE.createED(value + getQtyUnit()));
		prescribedQty.setSupply(prescribedQuantity);
		return prescribedQty;
	}

	private EntryRelationship getPrescribedQty(Double value, String unit) {

		final EntryRelationship prescribedQty = CDAFactory.eINSTANCE.createEntryRelationship();
		prescribedQty.setTypeCode(x_ActRelationshipEntryRelationship.COMP);
		final Supply prescribedQuantity = CDAFactory.eINSTANCE.createSupply();
		prescribedQuantity.setClassCode(ActClassSupply.SPLY);
		prescribedQuantity.setMoodCode(x_DocumentSubstanceMood.RQO);
		prescribedQuantity.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		prescribedQuantity.setQuantity(
				DatatypesFactory.eINSTANCE.createPQ(value.doubleValue(), value.toString()));
		prescribedQuantity.setText(DatatypesFactory.eINSTANCE.createED(value + " " + unit));
		prescribedQty.setSupply(prescribedQuantity);
		return prescribedQty;
	}

	private ManufacturedProduct getProduct() {

		final ManufacturedProduct product = CDAFactory.eINSTANCE.createManufacturedProduct();
		product.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.2", "IHE PHARM").getIi());
		product.getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.53", "HL7 CCD").getIi());
		product.getIds().add(getNullFlavorIi());
		product.setClassCode(RoleClassManufacturedProduct.MANU);
		product.setManufacturerOrganization(getOrganization().getMdhtOrganization());
		product.setManufacturedMaterial(getManufacturedMaterial());
		return product;
	}

	private String getQtyUnit() {

		return " comprimés";
	}

	private IVL_PQ getRateQuantity() {

		final IVL_PQ rateQuantity = DatatypesFactory.eINSTANCE.createIVL_PQ();
		final IVXB_PQ highRate = DatatypesFactory.eINSTANCE.createIVXB_PQ();

		highRate.setValue((double) 7);
		final IVXB_PQ lowRate = DatatypesFactory.eINSTANCE.createIVXB_PQ();
		highRate.setValue((double) 1);
		rateQuantity.setHigh(highRate);
		rateQuantity.setLow(lowRate);
		return rateQuantity;
	}

	private Act getReasonOfTreatment() {

		final Act reasonOfTreatment = CDAFactory.eINSTANCE.createAct();
		reasonOfTreatment.setClassCode(x_ActClassDocumentEntryAct.ACT);
		reasonOfTreatment.setMoodCode(x_DocumentActMood.EVN);
		reasonOfTreatment.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.4.1", "IHE PHARM").getIi());
		// prendre la référence de l'élément indiquant la raison dans le doc
		reasonOfTreatment.getIds().add(createIdentificator("REASON_OID", "REASON_ID").getIi());
		reasonOfTreatment.setStatusCode(StatusCode.COMPLETED.getCS());
		final EntryRelationship reason = CDAFactory.eINSTANCE.createEntryRelationship();
		reason.setTypeCode(x_ActRelationshipEntryRelationship.RSON);
		reason.setInversionInd(false);
		reason.setAct(reasonOfTreatment);
		reasonOfTreatment.getEntryRelationships().add(reason);
		return reasonOfTreatment;
	}

	private IVL_INT getRepeatNumber() {

		final IVL_INT repeatNumber = DatatypesFactory.eINSTANCE.createIVL_INT();
		repeatNumber.setValue(0);
		return repeatNumber;
	}

	private Code getRouteOfAdministration() {

		return RouteOfAdministration.PO.getCode(getLanguageCode());
	}

	@SuppressWarnings("unused")
	private Supply getSupply() {

		final Supply deliveredProduct = CDAFactory.eINSTANCE.createSupply();
		deliveredProduct.setClassCode(ActClassSupply.SPLY);
		deliveredProduct.setMoodCode(x_DocumentSubstanceMood.RQO);
		deliveredProduct.setIndependentInd(DatatypesFactory.eINSTANCE.createBL(false));
		deliveredProduct.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.9.1.3.4", "IHE PHARM").getIi());
		deliveredProduct.getTemplateIds()
				.add(new Identificator("2.16.840.1.113883.10.20.1.34", "HL7 CCD").getIi());
		deliveredProduct.getTemplateIds()
				.add(new Identificator("1.3.6.1.4.1.19376.1.5.3.1.4.7.3", "IHE PCC").getIi());
		deliveredProduct.setClassCode(ActClassSupply.SPLY);
		deliveredProduct.setMoodCode(x_DocumentSubstanceMood.EVN);
		deliveredProduct.setCode(DatatypesFactory.eINSTANCE.createCD("2.16.840.1.113883.5.4",
				CodeSystems.HL7ActCode.getCodeSystemName()));
		final Product product = CDAFactory.eINSTANCE.createProduct();
		product.setManufacturedProduct(getProduct());
		deliveredProduct.setProduct(product);

		/** OK **/
		deliveredProduct.getAuthors().add(createPlanificationAuthor().getAuthorMdht());

		/** OK **/
		// Date de début de prescription
		deliveredProduct.getEffectiveTimes().add(createTime("10.11.2016"));

		/** OK **/
		// Date de fin
		deliveredProduct.getEffectiveTimes().add(createTime("10.12.2016"));

		// Prescripteur

		// Auteur Prescription
		deliveredProduct.getAuthors().add(createPrescriptionAuthor().getAuthorMdht());

		// Auteur Dispensation
		deliveredProduct.getAuthors().add(createPrescriptionAuthor2().getAuthorMdht());

		/** OK **/
		// Dose journalière
		deliveredProduct.getEntryRelationships().add(getDailyDosage());

		/** OK **/
		// Quantité prescrite / à remettre
		deliveredProduct.getEntryRelationships().add(getPrescribedQty());

		/** OK **/
		// Raison du traitement
		deliveredProduct.addAct(getReasonOfTreatment());

		/** OK **/
		// Substitution autorisée
		final PharmSubstitutionMade substitution = CDAFactory.eINSTANCE
				.createPharmSubstitutionMade();
		substitution.setClassCode(ActClassRoot.SUBST);
		substitution.setMoodCode(ActMood.EVN);
		final CE pharmCode = DatatypesFactory.eINSTANCE.createCE("2.16.840.1.113883.5.1070",
				"HL7 Substance Admin Substitution");
		substitution.setCode(pharmCode);

		final PharmComponent1 component1 = CDAFactory.eINSTANCE.createPharmComponent1();
		component1.setSubstitutionMade(substitution);
		deliveredProduct.setComponent1(component1);

		return deliveredProduct;
	}

	public Consumable initConsumable() {
		final Consumable c = new Consumable(ts1,
				new Code(CodeSystems.GTIN.getCodeSystemId(), numS1), code1);
		return c;
	}

	@Before
	public void initTestData() {

		final String medicationinstructions = "Check compliance regularly";
		final String patientinstructions = "Should be taken during meal";
		final String strMtpOid1 = "2.16.756.5.30.4.9.1.1.9000.97005632.20150505140000.1";
		final String strMtpId1 = "MTPS-V1-MTP1.1.1";
		final String strPadvOid1 = "2.16.756.5.30.4.9.1.1.9000.97005632.20150630093000.1";
		final String strPadvId1 = "MTPS-V1-PADV2.1";
		final String strPREOid1 = "2.16.756.5.30.4.9.1.1.9000.97005632.20150505140000.1";
		final String strPREId1 = "MTPS-V1-PRE1.1";
		final String strDISOid1 = "2.16.756.5.30.4.9.1.1.9000.97005632.20150505160000.1";
		final String strDISId1 = "MTPS-V1-DIS1.1";
		final String strTemplateIdSubstance1Oid = "2.16.756.5.30.1.1.1.1.1";
		final String strTemplateIdSubstance1Id = "CDA-CH.Body.MediL3";
		final String strTemplateIdSubstance2Oid = "1.3.6.1.4.1.19376.1.5.3.1.4.7.1";
		final String strTemplateIdSubstance2Id = "IHE PHARM";
		final String strTemplateIdSubstance3Oid = "2.16.840.1.113883.10.20.1.24";
		final String strTemplateIdSubstance3Id = "HL7 CCD";
		final String strTemplateIdSubstance4Oid = "1.3.6.1.4.1.19376.1.5.3.1.4.7";
		final String strTemplateIdSubstance4Id = "IHE PHARM";
		final Double doseQuantity = new Double(10);
		final RouteOfAdministration rOa = RouteOfAdministration.PO;
		final boolean isSubstituable = true;
		// Convenience API Types
		idMtp1 = createIdentificator(strMtpOid1, strMtpId1);
		idPadv1 = createIdentificator(strPadvOid1, strPadvId1);
		idPre1 = createIdentificator(strPREOid1, strPREId1);
		idDis1 = createIdentificator(strDISOid1, strDISId1);
		final Identificator templateIdSubstance1 = createIdentificator(strTemplateIdSubstance1Oid,
				strTemplateIdSubstance1Id);
		final Identificator templateIdSubstance2 = createIdentificator(strTemplateIdSubstance2Oid,
				strTemplateIdSubstance2Id);
		final Identificator templateIdSubstance3 = createIdentificator(strTemplateIdSubstance3Oid,
				strTemplateIdSubstance3Id);
		final Identificator templateIdSubstance4 = createIdentificator(strTemplateIdSubstance4Oid,
				strTemplateIdSubstance4Id);
		final ArrayList<Identificator> templateIds = new ArrayList<Identificator>();
		templateIds.add(templateIdSubstance1);
		templateIds.add(templateIdSubstance2);
		templateIds.add(templateIdSubstance3);
		templateIds.add(templateIdSubstance4);

		substanceAdministrationMtp1 = createSubstanceAdministration(getNullFlavorCe(),
				getNullFlavorCe(), getDoseQuantity(), getRateQuantity(), createTime("09.09.2016"),
				getConsumable(), createAuthor1(), createApproachSiteCode1(),
				createTime("10.10.2016"), createTime("12.04.2017"), rOa,
				createUniqueDailyDose("09.12.2016"), getMultipleDailyDoses(), doseQuantity,
				getQtyUnit(), isSubstituable, idMtp1, templateIds);
		medicationFullfillmentInstructions1 = createProfessionalInstructions1(
				medicationinstructions);
		patientMedicalInstructions1 = createPatientMedicalInstructions1(patientinstructions);
		// advice time, not yet modeled in convenience API
		effectiveTimePadv1 = createEffectiveTimePadv1();
	}

	private String serializeDocument(CdaChMtpsPml doc) throws Exception {
		final ByteArrayOutputStream boas = new ByteArrayOutputStream();
		CDAUtil.save(doc.getDoc(), boas);
		return boas.toString();
	}

	public void setLanguageCode(LanguageCode languageCode) {
		this.languageCode = languageCode;
	}

	@Test
	public void testCdaChMtpsPml() {

		// Set Language
		setLanguageCode(LanguageCode.FRENCH);
		// Create Header Section and PML Structure (MedicationList)
		pmlMtpsDoc = createHeader();
		// Create Body Section (Add entries suchs a MTP, PRE, DIS and PADV into
		addBodySections();
		// print
		pmlMtpsDoc.printXmlToConsole();

	}

	@Test
	public void testDocumenHeader() throws XPathExpressionException {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final Document document = cda.getDocument();

		// realmCode
		XPathExpression expr = xpath.compile("//realmCode[@code='CHE']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// typeId
		expr = xpath
				.compile("//typeId[@root='2.16.840.1.113883.1.3' and @extension='POCD_HD000040']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// CH PML
		expr = xpath.compile("//templateId[@root='2.16.756.5.30.1.1.1.1.3.8.1.14']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.5.3.1.1.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// ihe pharm pml
		expr = xpath.compile("//templateId[@root='1.3.6.1.4.1.19376.1.9.1.1.5']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		// ihe pharm dis code
		expr = xpath.compile("//code[@code='56445-0']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());
	}

	@Test
	public void testDocumentSection() throws XPathExpressionException {
		final CdaChMtpsPml cda = new CdaChMtpsPml();
		final Document document = cda.getDocument();

		XPathExpression expr = xpath
				.compile("//*/section/templateId[@root='1.3.6.1.4.1.19376.1.9.1.2.5']");
		NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		expr = xpath.compile("//*/code[@code='10160-0' and @codeSystem='2.16.840.1.113883.6.1']");
		nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

		assertNotNull(cda.getMedicationListSection());
		assertEquals("Medication List", cda.getMedicationListSection().getTitle());
	}

	@Test
	public void testDocumentSectionDeserializeWithEntries() throws Exception {

		final CdaChMtpsPml cda = new CdaChMtpsPml();

		final MedicationTreatmentPlanItemEntry mtpEntry = new MedicationTreatmentPlanItemEntry();
		mtpEntry.setTextReference("#mtp");
		cda.getMedicationListSection().addMedicationTreatmentPlanItemEntry(mtpEntry);

		final PrescriptionItemEntry preEntry = new PrescriptionItemEntry();
		preEntry.setTextReference("#pre");
		cda.getMedicationListSection().addPrescriptionItemEntry(preEntry);

		final DispenseItemEntry disEntry = new DispenseItemEntry();
		disEntry.setTextReference("#dis");
		cda.getMedicationListSection().addDispenseItemEntry(disEntry);

		final PharmaceuticalAdviceItemEntry padvEntry = new PharmaceuticalAdviceItemEntry();
		padvEntry.setTextReference("#padv");
		cda.getMedicationListSection().addPharmaceuticalAdviceItemEntry(padvEntry);

		final String deserialized = this.serializeDocument(cda);
		log.debug(deserialized);
		final CdaChMtpsPml cdaDeserialized = deserializeCda(deserialized);

		assertTrue(cdaDeserialized != null);

		assertEquals("#mtp", cdaDeserialized.getMedicationListSection()
				.getMedicationTreatmentPlanItemEntries().get(0).getTextReference());
		assertEquals("#pre", cdaDeserialized.getMedicationListSection().getPrescriptionItemEntries()
				.get(0).getTextReference());
		assertEquals("#dis", cdaDeserialized.getMedicationListSection().getDispenseItemEntries()
				.get(0).getTextReference());
		assertEquals("#padv", cdaDeserialized.getMedicationListSection()
				.getPharmaceuticalAdviceItemEntries().get(0).getTextReference());

	}

}
