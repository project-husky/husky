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

package org.ehc.communication;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.LanguageCode;
import org.ehc.common.Author;
import org.ehc.common.Code;
import org.ehc.common.Identificator;
import org.ehc.common.Patient;
import org.ehc.common.XdsUtil;
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
 * Metadaten zu einem Dokument (wird für IHE XDS Registry verwendet)
 */
public class DocumentMetadata {

	DocumentEntryType xDoc;
	DocumentDescriptor xDesc;
	FileInputStream fis;
	ClinicalDocument cda;
	CDAR2Extractor extractor;

	public DocumentMetadata() {
		xDoc = MetadataFactory.eINSTANCE.createDocumentEntryType();
		cda = CDAFactory.eINSTANCE.createClinicalDocument();
		extractor = new CDAR2Extractor(cda);
	}

	public DocumentMetadata(DocumentEntryType documentEntryType) {
		this();
		xDoc = documentEntryType;
	}

	//	//Constructor for File Documents
	//	//If the Document is CDA, the Metadata will be extraced, otherwise it will just be tested, if the file is accessible
	//	public DocumentMetadata(String filePath, DocumentDescriptor docDesc) throws Exception {
	//		this();
	//		File docEntryFile = new File (filePath);
	//		fis = new FileInputStream(docEntryFile);
	//		if (DocumentDescriptor.CDA_R2.equals(docDesc)) {
	//			ClinicalDocument clinicalDocument = CDAUtil.load(fis);
	//			CDAR2Extractor deExtractor = new CDAR2Extractor(clinicalDocument);
	//			xDoc = deExtractor.extract();
	//		}
	//		fis.close();
	//	}

	//	/**
	//	 * @param documentId
	//	 *          Die Dokumenten-Id wird als Globally Unique Identifier (GUID)
	//	 *          angegeben.
	//	 * @param versionId
	//	 *          Nur anzugeben, wenn es sich nicht um die erste Version des
	//	 *          Dokuments handelt. Die Version ist eine fortlaufende Nummer.
	//	 * @param title
	//	 *          Dieses Feld entspricht im herkömmlichen medizinischen Dokument der
	//	 *          Betreffzeile
	//	 * @param codedLanguage
	//	 *          In der Schweiz gebräuchlichen Language Codes gemäss RFC 1766
	//	 *          (ISO-639-1 und ISO 3166): de-CH, fr-CH, it-CH
	//	 * @param dateOfDocumentCreation
	//	 *          Datum, an dem das Dokument erstellt wurde
	//	 */
	//	public DocumentMetadata(String documentId, String versionId, String title,
	//			Language codedLanguage, Calendar dateOfDocumentCreation) {
	////		this.documentId = documentId;
	////		this.versionId = versionId;
	////		this.title = title;
	////		this.codedLanguage = codedLanguage;
	////		this.dateOfDocumentCreation = dateOfDocumentCreation;
	//	}

	public void addAuthor(Author author) {		
		//Workaround for a Bug in the CDAR2Extractor, which causes a NullpointerException, if no Telecom value is interted and logger.Debug is set to true
		if (author.getAuthorMdht().getAssignedAuthor().getTelecoms()==null || author.getAuthorMdht().getAssignedAuthor().getTelecoms().isEmpty()) {
			TEL tel = DatatypesFactory.eINSTANCE.createTEL();
			author.getAuthorMdht().getAssignedAuthor().getTelecoms().add(tel);
		}

		cda.getAuthors().add(author.copyMdhtAuthor());

		AuthorType xAuthor = extractor.extractAuthors().get(0);
		xDoc.getAuthors().add(xAuthor);
	}

	public void addConfidentiallyCode(String code) {
		//TODO Consider Enum here
		xDoc.getConfidentialityCode().add(code);
	}

	public DocumentEntryType copyMdhtDocumentEntryType() {
		return EcoreUtil.copy(xDoc);
	}

	public DocumentEntryType getMdhtDocumentEntryType() {
		return xDoc;
	}

	public void setClassCode(Code code) {
		xDoc.setClassCode(XdsUtil.convertCode(code));
	}

	/**
	 * @param codedLanguage
	 *          das codedLanguage Objekt welches gesetzt wird
	 */
	public void setCodedLanguage(LanguageCode codedLanguage) {
		xDoc.setLanguageCode(codedLanguage.getCodeValue());
	}

	/**
	 * @param dateOfDocumentCreation
	 *          das dateOfDocumentCreation Objekt welches gesetzt wird
	 */
	public void setCreationTime(Date dateAndTime) {
		final DateFormat cdaDateFormatter = new SimpleDateFormat("yyyyMMddHHmm");
		xDoc.setCreationTime(cdaDateFormatter.format(dateAndTime));
	}

	public void setFormatCode(Code code) {
		xDoc.setFormatCode(XdsUtil.convertCode(code));
	}

	public void setHealthcareFacilityTypeCode(Code code) {
		//TODO Consider Enum here
		xDoc.setHealthCareFacilityTypeCode(XdsUtil.convertCode(code));
	}

	public void setMimeType(String mimeType) {
		xDoc.setMimeType(mimeType);
	}

	public void setPatient(Patient patient) {
		cda.getRecordTargets().add(patient.getMdhtRecordTarget());

		//Source Patient Info (Adress etc.)
		SourcePatientInfoType spi = extractor.extractSourcePatientInfo();
		xDoc.setSourcePatientInfo(spi);

		//PatientID
		//xDoc.setPatientId(extractor.extractPatientId());

		if (patient.getIds() != null) {
			setPatientId(patient.getIds().get(0));
		}
	}

	public void setPatientId(Identificator id) {
		xDoc.setPatientId(XdsUtil.convertIdentificator(id));
	}

	public void setPracticeSettingCode (Code code) {
		//TODO Consider Enum here
		xDoc.setPracticeSettingCode(XdsUtil.convertCode(code));
	}

	public void setSourcePatientId(Identificator id) {
		xDoc.setSourcePatientId(XdsUtil.convertIdentificator(id));
	}

	/**
	 * @param title
	 *          das title Objekt welches gesetzt wird
	 */
	public void setTitle(String title) {
		xDoc.setTitle(XdsUtil.createInternationalString(title));
	}

	public void setTypeCode(Code code) {
		xDoc.setTypeCode(XdsUtil.convertCode(code));
	}

	public void setUniqueId(String id) {
		xDoc.setUniqueId(id);
	}
}
