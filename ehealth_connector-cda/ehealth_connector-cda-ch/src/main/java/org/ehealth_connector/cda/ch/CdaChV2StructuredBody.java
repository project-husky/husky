/*
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
package org.ehealth_connector.cda.ch;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.bind.DatatypeConverter;

import org.ehealth_connector.cda.AbstractCda;
import org.ehealth_connector.cda.ObservationMediaEntry;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.Section;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.ST;

/**
 * @formatter:off
 * <div class="en">Implements a CDA document based on the CDA-CH V2 (2017) specification.</div>
 * <div class="de">Implementiert ein CDA-Dokument basierend auf der CDA-CH V2 (2017) Spezifikation.</div>
 * <div class="fr">TODO.</div>
 * @formatter:on
 *
 * @param <EClinicalDocument>
 *            the generic type
 */
public class CdaChV2StructuredBody<EClinicalDocument extends ClinicalDocument>
		extends AbstractCda<EClinicalDocument> {

	public CdaChV2StructuredBody(EClinicalDocument doc) {
		super(doc);
	}

	public CdaChV2StructuredBody(EClinicalDocument doc, LanguageCode languageCode,
			String stylesheet, String css) {
		super(doc, languageCode, stylesheet, css);
	}

	/**
	 * <div class="en">Adds a comment</div> <div class="de">Fügt einen Kommentar
	 * hinzu</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @param comment
	 *            the comment
	 */
	public void addComment(String comment) {

		// // find or create (and add) the Section
		// Section rs = findRemarksSection();
		// if (rs == null) {
		// rs = ChFactory.eINSTANCE.createRemarksSection().init();
		// for (final II ii : rs.getTemplateIds()) {
		// if ("2.16.756.5.30.1.1.1.1.1".equals(ii.getRoot())) {
		// ii.setExtension("CDA-CH.Body.CodedRem");
		// }
		// }
		// rs.setTitle(Util.st(SectionsVacd.REMARKS.getSectionTitle(getDoc().getLanguageCode())));
		// getDoc().addSection(rs);
		// }
		//
		// // create add the MDHT Object to the section
		// final Comment mComment = IHEFactory.eINSTANCE.createComment().init();
		// rs.addAct(mComment);
		//
		// // update the MDHT Object content references to CDA level 1 text
		// SimpleTextBuilder sb = null;
		// if (rs.getText() != null) {
		// final String oldSectionText =
		// Util.extractStringFromNonQuotedStrucDocText(rs.getText());
		// sb = new SimpleTextBuilder(SectionsVacd.REMARKS, comment,
		// oldSectionText);
		// } else {
		// sb = new SimpleTextBuilder(SectionsVacd.REMARKS, comment);
		// }
		//
		// final ED reference = Util.createReference(sb.getNewTextContentIDNr(),
		// SectionsVacd.REMARKS.getContentIdPrefix());
		//
		// // create the CDA level 1 text
		// rs.createStrucDocText(sb.toString());
		// mComment.setText(reference);
	}

	@Override
	public void initCda() {

		// Make sure the document contains all necessary templateIds
		addTemplateIdOnce(new Identificator("2.16.840.1.113883.10.12.1"));
		addTemplateIdOnce(new Identificator("2.16.840.1.113883.10.12.2"));
		addTemplateIdOnce(new Identificator("2.16.756.5.30.1.1.1.1.4"));

		// Type ID
		setTypeId();

		// Set default Swiss EPR confidentiality code of the document (normal)
		setConfidentialityCode(org.ehealth_connector.common.ch.enums.ConfidentialityCode.NORMAL);

		// Set the basic elements of the document as default values
		Identificator id = new Identificator(org.openhealthtools.ihe.utils.UUID.generate());
		setId(id);
		setSetId(id);
		setVersion(id, 1);
		setTimestamp(DateUtil.nowAsDate());

		// // // Fix RealmCode
		// // final CS cs = DatatypesFactory.eINSTANCE.createCS();
		// // cs.setCode(CountryCode.SWITZERLAND.getCodeAlpha3());
		// // getDoc().getRealmCodes().clear();
		// // getDoc().getRealmCodes().add)(cs);
		//
		//
		// // // Set OID of the document
		// // setId(null);
		// // setSetId(null);
		// // setVersion(null, null);
		// //
		//
		// // Set creation time of the document
		//
		//
	}

	/**
	 *
	 * Sets Swiss EPR Confidentially Code
	 *
	 * @param code
	 *            If null, "N" for "normal" will be set.
	 *
	 */
	public void setConfidentialityCode(
			org.ehealth_connector.common.ch.enums.ConfidentialityCode code) {
		CE confidentialityCode;
		if (code == null) {
			confidentialityCode = org.ehealth_connector.common.ch.enums.ConfidentialityCode.NORMAL
					.getCE();
		} else {
			confidentialityCode = code.getCE();
		}
		getDoc().setConfidentialityCode(confidentialityCode);
	}

	/**
	 * <div class="en">Adds the original representation section.</div>
	 *
	 * @param pdf
	 *            <div class="en">the pdf containing the original representation
	 *            in PDF/A format</div>
	 * @throws IOException
	 *             <div class="en">Signals that an I/O exception has
	 *             occurred.</div>
	 */
	public void setOriginalRepresentationSection(byte[] pdf) throws IOException {
		// TODO Add Template ID 2.16.756.5.30.1.1.10.1.14 ( CDA-CH v2.0 -
		// structuredBody enhanced) if it dos not exist
		Section s = CDAFactory.eINSTANCE.createSection();
		final II tIi = DatatypesFactory.eINSTANCE.createII();
		tIi.setRoot("2.16.756.5.30.1.1.10.3.45");
		s.getTemplateIds().add(tIi);

		final CE tCe = DatatypesFactory.eINSTANCE.createCE();
		tCe.setCode("55108-5");
		tCe.setCodeSystem("2.16.840.1.113883.6.1");
		tCe.setCodeSystemName("LOINC");
		tCe.setDisplayName("Clinical presentation");
		s.setCode(tCe);

		final ST tSt = DatatypesFactory.eINSTANCE.createST();
		tSt.addText("Original representation");
		s.setTitle(tSt);

		s.createStrucDocText(
				"Representation of the original view which has been signed by the legal authenticator:\r\n"
						+ "						<renderMultiMedia referencedObject=\"originalrepresentationpdf\"/>\r\n          ");

		ObservationMediaEntry obsMedia = new ObservationMediaEntry();
		obsMedia.setObservationMediaId("originalrepresentationpdf");
		final II tObsIi = DatatypesFactory.eINSTANCE.createII();
		tObsIi.setRoot("2.16.756.5.30.1.1.10.4.83");
		obsMedia.getMdht().getTemplateIds().add(tIi);
		obsMedia.setBase64Object(
				new ByteArrayInputStream(DatatypeConverter.printBase64Binary(pdf).getBytes()),
				"application/pdf");
		s.addObservationMedia(obsMedia.copy());

		// Todo remove the old section if exists
		getDoc().addSection(s);
	}
}
