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

package org.ehc.cda;

import java.util.Calendar;

import org.ehc.common.ConvenienceUtilsEnums.Language;

/**
 * Metadaten zu einem Dokument (wird für IHE XDS Registry verwendet)
 */
public class DocumentMetadata {
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
