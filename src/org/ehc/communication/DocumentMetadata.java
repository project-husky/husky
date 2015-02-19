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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;

import org.ehc.common.Author;
import org.ehc.common.ConvenienceUtilsEnums.Language;
import org.ehc.common.Patient;
import org.openhealthtools.ihe.atna.auditor.models.rfc3881.ParticipantObjectIdentificationType;
import org.openhealthtools.ihe.common.hl7v2.Hl7v2Factory;
import org.openhealthtools.ihe.common.hl7v2.SourcePatientInfoType;
import org.openhealthtools.ihe.xds.document.DocumentDescriptor;
import org.openhealthtools.ihe.xds.document.XDSDocument;
import org.openhealthtools.ihe.xds.metadata.AuthorType;
import org.openhealthtools.ihe.xds.metadata.DocumentEntryType;
import org.openhealthtools.ihe.xds.metadata.MetadataFactory;
import org.openhealthtools.ihe.xds.metadata.extract.InputStreamDocumentEntryExtractor;
import org.openhealthtools.ihe.xds.metadata.extract.MetadataExtractionException;
import org.openhealthtools.ihe.xds.metadata.extract.cdar2.CDAR2Extractor;
import org.openhealthtools.ihe.xds.source.SubmitTransactionData;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.RecordTarget;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;

/**
 * Metadaten zu einem Dokument (wird für IHE XDS Registry verwendet)
 */
public class DocumentMetadata {
	
	SubmitTransactionData txnData;
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
	
	//Constructor for File Documents
	//If the Document is CDA, the Metadata will be extraced, otherwise it will just be tested, if the file is accessible
	public DocumentMetadata(String filePath, DocumentDescriptor docDesc) throws Exception {
		this();
		File docEntryFile = new File (filePath);
		fis = new FileInputStream(docEntryFile);
		if (DocumentDescriptor.CDA_R2.equals(docDesc)) {
			ClinicalDocument clinicalDocument = CDAUtil.load(fis);
			CDAR2Extractor deExtractor = new CDAR2Extractor(clinicalDocument);
			xDoc = deExtractor.extract();
		}
		fis.close();
	}
	
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
	
	public void setPatient(Patient patient) {
		cda.getRecordTargets().add(patient.getMdhtRecordTarget());
		
		SourcePatientInfoType spi = extractor.extractSourcePatientInfo();
		xDoc.setSourcePatientInfo(spi);
	}
	
	/**
	 * Die Dokumenten-Id wird als Globally Unique Identifier (GUID) angegeben.
	 */
	String documentId;

	/**
	 * Nur anzugeben, wenn es sich nicht um die erste Version des Dokuments
	 * handelt. Die Version ist eine fortlaufende Nummer.
	 */
	String versionId;

	/**
	 * Dieses Feld entspricht im herkömmlichen medizinischen Dokument der
	 * Betreffzeile
	 */
	String title;

	/**
	 * In der Schweiz gebräuchlichen Language Codes gemäss RFC 1766 (ISO-639-1 und
	 * ISO 3166): de-CH, fr-CH, it-CH
	 */
	Language codedLanguage;

	/**
	 * Datum, an dem das Dokument erstellt wurde
	 */
	Calendar dateOfDocumentCreation;

	/**
	 * @param documentId
	 *          Die Dokumenten-Id wird als Globally Unique Identifier (GUID)
	 *          angegeben.
	 * @param title
	 *          Dieses Feld entspricht im herkömmlichen medizinischen Dokument der
	 *          Betreffzeile
	 * @param codedLanguage
	 *          In der Schweiz gebräuchlichen Language Codes gemäss RFC 1766
	 *          (ISO-639-1 und ISO 3166): de-CH, fr-CH, it-CH
	 * @param dateOfDocumentCreation
	 *          Datum, an dem das Dokument erstellt wurde
	 */
	public DocumentMetadata(String documentId, String title,
			Language codedLanguage, Calendar dateOfDocumentCreation) {
		super();
		// this.documentId = documentId;
		// this.versionId = versionId;
		// this.title = title;
		// this.codedLanguage = codedLanguage;
		// this.dateOfDocumentCreation = dateOfDocumentCreation;
	}

	/**
	 * @param documentId
	 *          Die Dokumenten-Id wird als Globally Unique Identifier (GUID)
	 *          angegeben.
	 * @param versionId
	 *          Nur anzugeben, wenn es sich nicht um die erste Version des
	 *          Dokuments handelt. Die Version ist eine fortlaufende Nummer.
	 * @param title
	 *          Dieses Feld entspricht im herkömmlichen medizinischen Dokument der
	 *          Betreffzeile
	 * @param codedLanguage
	 *          In der Schweiz gebräuchlichen Language Codes gemäss RFC 1766
	 *          (ISO-639-1 und ISO 3166): de-CH, fr-CH, it-CH
	 * @param dateOfDocumentCreation
	 *          Datum, an dem das Dokument erstellt wurde
	 */
	public DocumentMetadata(String documentId, String versionId, String title,
			Language codedLanguage, Calendar dateOfDocumentCreation) {
		super();
		this.documentId = documentId;
		this.versionId = versionId;
		this.title = title;
		this.codedLanguage = codedLanguage;
		this.dateOfDocumentCreation = dateOfDocumentCreation;
	}

	public DocumentMetadata(DocumentEntryType documentEntryType) {
		this();
		this.xDoc = documentEntryType;
	}

	/**
	 * @return das codedLanguage Objekt
	 */
	public Language getCodedLanguage() {
		return codedLanguage;
	}

	/**
	 * @return das dateOfDocumentCreation Objekt
	 */
	public Calendar getDateOfDocumentCreation() {
		return dateOfDocumentCreation;
	}

	/**
	 * @return das documentId Objekt
	 */
	public String getDocumentId() {
		return documentId;
	}

	/**
	 * @return das title Objekt
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return das versionId Objekt
	 */
	public String getVersionId() {
		return versionId;
	}

	/**
	 * @param codedLanguage
	 *          das codedLanguage Objekt welches gesetzt wird
	 */
	public void setCodedLanguage(Language codedLanguage) {
		this.codedLanguage = codedLanguage;
	}

	/**
	 * @param dateOfDocumentCreation
	 *          das dateOfDocumentCreation Objekt welches gesetzt wird
	 */
	public void setDateOfDocumentCreation(Calendar dateOfDocumentCreation) {
		this.dateOfDocumentCreation = dateOfDocumentCreation;
	}

	/**
	 * @param documentId
	 *          das documentId Objekt welches gesetzt wird
	 */
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	/**
	 * @param title
	 *          das title Objekt welches gesetzt wird
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param versionId
	 *          das versionId Objekt welches gesetzt wird
	 */
	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}
}
