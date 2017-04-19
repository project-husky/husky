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
 * Year of publication: 2016
 *
 *******************************************************************************/

package org.ehealth_connector.cda.ch.mtps;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.ExternalDocumentEntry;
import org.ehealth_connector.cda.ch.AbstractCdaCh;
import org.ehealth_connector.cda.ihe.pharm.DispenseItemEntry;
import org.ehealth_connector.cda.ihe.pharm.DispenseSection;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.Author;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.EntryRelationship;
import org.openhealthtools.mdht.uml.cda.Product;
import org.openhealthtools.mdht.uml.cda.Reference;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassSupply;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActRelationshipExternalReference;
import org.openhealthtools.mdht.uml.hl7.vocab.x_DocumentSubstanceMood;

/**
 * The Class CdaChMtpsDis. see also CDA CH MTPS 7.4.2.5
 */
public class CdaChMtpsDis extends AbstractCdaCh<org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis> {

	/**
	 * Instantiates a new cda ch mtps dis.
	 */
	public CdaChMtpsDis() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new cda ch mtps dis.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public CdaChMtpsDis(LanguageCode languageCode) {
		super(CHFactory.eINSTANCE.createCdaChMtpsDis().init());
		this.setLanguageCode(languageCode);
		super.initCda();
		switch (this.getLanguageCode()) {
		case FRENCH:
			setTitle("Dispensation des médicaments"); // CDA CH MTPS 7.4.2.5
			break;
		case GERMAN:
			this.setTitle("Abgabe von Medikamenten"); // CDA CH MTPS 7.4.2.5
			break;
		case ITALIAN:
			setTitle("Dispensazioni di farmaci"); // CDA CH MTPS 7.4.2.5
			break;
		case ENGLISH:
			setTitle("Medication dispensed"); // IHE PHARM DIS L350
			break;
		}
		final DispenseSection dispenseSection = new DispenseSection(languageCode);
		this.getDoc().addSection(dispenseSection.getMdht());
	}

	/**
	 * Instantiates a new cda ch mtps dis.
	 *
	 * @param doc
	 *            mdht model document
	 */
	public CdaChMtpsDis(org.openhealthtools.mdht.uml.cda.ch.CdaChMtpsDis doc) {
		super(doc);
	}

	public DispenseItemEntry createDispenseItemEntry(
			org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry entry) {
		/** DIS Item Declaration **/
		final DispenseItemEntry disEntry = new DispenseItemEntry(getLanguageCode());

		/** REFR to MTPItem **/
		//
		/** Document ID **/
		disEntry.setId(new Identificator(entry.getClinicalDocument().getId()));

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
		product.setManufacturedProduct(entry.getProduct().getManufacturedProduct());
		disEntry.getMdht().setProduct(product);
		/** Reference **/
		final Reference referenceXCRPT = CDAFactory.eINSTANCE.createReference();
		referenceXCRPT.setTypeCode(x_ActRelationshipExternalReference.XCRPT);
		final ExternalDocumentEntry documentEntry = new ExternalDocumentEntry();
		documentEntry.setId(new Identificator(entry.getClinicalDocument().getId()));
		referenceXCRPT.setExternalDocument(documentEntry.getMdht());
		disEntry.getMdht().getReferences().add(referenceXCRPT);
		/** OK **/
		// Authors
		final EList<Author> authors = entry.getAuthors();
		for (final Iterator<Author> iterator = authors.iterator(); iterator.hasNext();) {
			final Author author = iterator.next();
			iterator.remove();
			disEntry.getMdht().getAuthors().add(author);
		}
		// Dates
		final EList<SXCM_TS> effectiveTimes = entry.getEffectiveTimes();
		for (final SXCM_TS sxcm_TS : effectiveTimes) {
			disEntry.getMdht().getEffectiveTimes().add(sxcm_TS);
		}

		/** OK **/
		// entryRelationships
		final EList<EntryRelationship> entryRelationships = entry.getEntryRelationships();
		for (final Iterator<EntryRelationship> iterator = entryRelationships.iterator(); iterator
				.hasNext();) {
			final EntryRelationship entryRelationship = iterator.next();

			iterator.remove();
			disEntry.getMdht().getEntryRelationships().add(entryRelationship);

		}
		/** OK **/
		// Acts
		final EList<Act> acts = entry.getActs();
		for (final Act act : acts) {
			disEntry.getMdht().addAct(act);
		}

		/** OK **/
		// Substitution authorised
		disEntry.getMdht().setComponent1(entry.getComponent1());
		return disEntry;
	}

	public DispenseItemEntry getDispenseItemEntry() {
		final org.openhealthtools.mdht.uml.cda.ihe.pharm.DispenseItemEntry entry = this.getMdht()
				.getDispenseSection().getDispenseItemEntry();

		final DispenseItemEntry disEntry = createDispenseItemEntry(entry);
		return disEntry;
	}

	/**
	 * Gets the dispense section.
	 *
	 * @return the dispense section
	 */
	public DispenseSection getDispenseSection() {
		return new DispenseSection(this.getMdht().getDispenseSection());
	}

	public void setDispenseItemEntry(DispenseItemEntry entry) {
		// TODO Auto-generated method stub
		if (entry != null) {
			// todo: add into a list of disEntries [deliveredProduct = supply]
			this.getMdht().getDispenseSection().addSupply(entry.getMdht());
		}
	}
}
