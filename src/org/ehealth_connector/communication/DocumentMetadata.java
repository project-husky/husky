/********************************************************************************
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
 ********************************************************************************/

package org.ehealth_connector.communication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.enums.LanguageCode;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.XdsUtil;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * Stellt die Metadaten gemäss [IHE ITI TF-3], Table 4.1-5: Document Metadata
 * Attribute Definition bereit
 * */
public class DocumentMetadata {

	/** The x doc. */
	DocumentEntryType xDoc;

	/** The x desc. */
	DocumentDescriptor xDesc;

	/** The cda. */
	ClinicalDocument cda;

	/** The extractor. */
	CDAR2Extractor extractor;

	/**
	 * Instantiates a new document metadata.
	 */
	public DocumentMetadata() {
		xDoc = MetadataFactory.eINSTANCE.createDocumentEntryType();
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
		extractor = new CDAR2Extractor(cda);
	}

	/**
	 * Instantiates a new document metadata.
	 *
	 * @param documentEntryType
	 *            the document entry type
	 */
	public DocumentMetadata(DocumentEntryType documentEntryType) {
		this();
		xDoc = documentEntryType;
	}

	// //Constructor for File Documents
	// //If the Document is CDA, the Metadata will be extraced, otherwise it
	// will just be tested, if the file is accessible
	// public DocumentMetadata(String filePath, DocumentDescriptor docDesc)
	// throws Exception {
	// this();
	// File docEntryFile = new File (filePath);
	// fis = new FileInputStream(docEntryFile);
	// if (DocumentDescriptor.CDA_R2.equals(docDesc)) {
	// ClinicalDocument clinicalDocument = CDAUtil.load(fis);
	// CDAR2Extractor deExtractor = new CDAR2Extractor(clinicalDocument);
	// xDoc = deExtractor.extract();
	// }
	// fis.close();
	// }

	// /**
	// * @param documentId
	// * Die Dokumenten-Id wird als Globally Unique Identifier (GUID)
	// * angegeben.
	// * @param versionId
	// * Nur anzugeben, wenn es sich nicht um die erste Version des
	// * Dokuments handelt. Die Version ist eine fortlaufende Nummer.
	// * @param title
	// * Dieses Feld entspricht im herkömmlichen medizinischen Dokument der
	// * Betreffzeile
	// * @param codedLanguage
	// * In der Schweiz gebräuchlichen Language Codes gemäss RFC 1766
	// * (ISO-639-1 und ISO 3166): de-CH, fr-CH, it-CH
	// * @param dateOfDocumentCreation
	// * Datum, an dem das Dokument erstellt wurde
	// */
	// public DocumentMetadata(String documentId, String versionId, String
	// title,
	// Language codedLanguage, Calendar dateOfDocumentCreation) {
	// // this.documentId = documentId;
	// // this.versionId = versionId;
	// // this.title = title;
	// // this.codedLanguage = codedLanguage;
	// // this.dateOfDocumentCreation = dateOfDocumentCreation;
	// }

	/**
	 * Adds an (optional) author element. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convencience API Author.
	 *
	 * @param author
	 *            the author
	 */
	@SuppressWarnings("unchecked")
	public void addAuthor(Author author) {
		// Workaround for a Bug in the CDAR2Extractor, which causes a
		// NullpointerException, if no Telecom value is interted and
		// logger.Debug is set to true
		if (author.getAuthorMdht().getAssignedAuthor().getTelecoms() == null
				|| author.getAuthorMdht().getAssignedAuthor().getTelecoms()
						.isEmpty()) {
			TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecoms().add(tel);
		}

		cda.getAuthors().add(author.copyMdhtAuthor());

		AuthorType xAuthor = extractor.extractAuthors().get(0);
		xDoc.getAuthors().add(xAuthor);
	}

	/**
	 * Adds the (optional) confidentially code (e.g. 'N' for 'normal')
	 *
	 * @param code
	 *            the code
	 */
	@SuppressWarnings("unchecked")
	public void addConfidentiallyCode(String code) {
		// TODO Consider Enum here
		xDoc.getConfidentialityCode().add(code);
	}

	/**
	 * Copy mdht document entry type.
	 *
	 * @return the document entry type
	 */
	public DocumentEntryType copyMdhtDocumentEntryType() {
		return EcoreUtil.copy(xDoc);
	}

	/**
	 * Gets the mdht document entry type.
	 *
	 * @return the mdht document entry type
	 */
	public DocumentEntryType getMdhtDocumentEntryType() {
		return xDoc;
	}

	/**
	 * Sets the (required, but in principle computable) class code, which
	 * defines the class of the document (e.g. Code for "Consultation")
	 *
	 * @param code
	 *            the new class code
	 */
	public void setClassCode(Code code) {
		xDoc.setClassCode(XdsUtil.convertCode(code));
	}

	/**
	 * Sets the (required) coded language (e.g. "de-CH"). This code can be
	 * extracted from CDA Document automatically.
	 *
	 * @param codedLanguage
	 *            the new language code
	 */
	public void setCodedLanguage(LanguageCode codedLanguage) {
		xDoc.setLanguageCode(codedLanguage.getCodeValue());
	}

	/**
	 * Sets the (required) creation time of the document. If not set, the
	 * current time will be used.
	 *
	 * @param dateAndTime
	 *            the new creation time
	 */
	public void setCreationTime(Date dateAndTime) {
		final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		xDoc.setCreationTime(cdaDateFormatter.format(dateAndTime));
	}

	/**
	 * Sets the (required) format code. If not set, the system will try to
	 * derive it from the Document MimeType.
	 *
	 * @param code
	 *            the new format code
	 */
	public void setFormatCode(Code code) {
		xDoc.setFormatCode(XdsUtil.convertCode(code));
	}

	/**
	 * Sets the (required) healthcare facility type code (e.g. Code for
	 * "Hospital")
	 *
	 * @param code
	 *            the new healthcare facility type code
	 */
	public void setHealthcareFacilityTypeCode(Code code) {
		// TODO Consider Enum here
		xDoc.setHealthCareFacilityTypeCode(XdsUtil.convertCode(code));
	}

	/**
	 * Sets the (required) mime type (e.g. "text/xml")
	 *
	 * @param mimeType
	 *            the new mime type
	 */
	public void setMimeType(String mimeType) {
		xDoc.setMimeType(mimeType);
	}

	/**
	 * Sets the (required) patient. All information relevant for the XDS
	 * Document Metadata will be extracted from the Convencience API Patient.
	 *
	 * @param patient
	 *            the new patient
	 */
	public void setPatient(Patient patient) {
		cda.getRecordTargets().add(patient.getMdhtRecordTarget());

		// Source Patient Info (Adress etc.)
		SourcePatientInfoType spi = extractor.extractSourcePatientInfo();
		xDoc.setSourcePatientInfo(spi);

		// PatientID
		// xDoc.setPatientId(extractor.extractPatientId());

		if (patient.getIds() != null) {
			setPatientId(patient.getIds().get(0));
		}
	}

	/**
	 * Sets the (required) patient id, which is used in the affinity domain
	 * (typically retrieved from a Master Patient Index (MPI))
	 *
	 * @param id
	 *            the new patient id
	 */
	public void setPatientId(Identificator id) {
		xDoc.setPatientId(XdsUtil.convertIdentificator(id));
	}

	/**
	 * Sets the (required) practice setting code. This is the medical speciality
	 * of the practice where the document was produced (e.g. Code for
	 * "General Medicine")
	 *
	 * @param code
	 *            the new practice setting code
	 */
	public void setPracticeSettingCode(Code code) {
		// TODO Consider Enum here
		xDoc.setPracticeSettingCode(XdsUtil.convertCode(code));
	}

	/**
	 * Sets the (required) source patient id. This is the local patient id, e.g.
	 * inside a hospital.
	 *
	 * @param id
	 *            the new source patient id
	 */
	public void setSourcePatientId(Identificator id) {
		xDoc.setSourcePatientId(XdsUtil.convertIdentificator(id));
	}

	/**
	 * Sets the (optional) title.
	 *
	 * @param title
	 *            das title Objekt welches gesetzt wird
	 */
	public void setTitle(String title) {
		xDoc.setTitle(XdsUtil.createInternationalString(title));
	}

	/**
	 * Sets the (required) type code. Specifies the type of the document (like
	 * the class code, but more specific) (e.g. Code for
	 * "Summarization of Episode Note")
	 *
	 * @param code
	 *            the new type code
	 */
	public void setTypeCode(Code code) {
		xDoc.setTypeCode(XdsUtil.convertCode(code));
	}

	/**
	 * Sets the unique id. The UUID of the document. Will be generated, when the
	 * instance of class is retrieved from
	 * ConvenienceCommunication.addDocument()
	 *
	 * @param id
	 *            the new unique id
	 */
	public void setUniqueId(String id) {
		xDoc.setUniqueId(id);
	}
}
