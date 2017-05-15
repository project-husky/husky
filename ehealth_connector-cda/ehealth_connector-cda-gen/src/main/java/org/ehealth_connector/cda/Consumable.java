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

import org.eclipse.emf.common.util.EList;
import org.ehealth_connector.cda.ihe.pharm.ManufacturedMaterial;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

/**
 * <div class="en">A consumable product</div> <div class="de">Ein konsumierbares
 * Produkt</div> <div class="fr"></div> <div class="it"></div>
 */
public class Consumable extends MdhtFacade<org.openhealthtools.mdht.uml.cda.Consumable> {

	/**
	 * <div class="en">Creates an object, which represents a consumable
	 * substance. This constructor will be used, if you want to initialize an
	 * empty object (true) or if you want to code that the substance is unknown
	 * (false).</div> <div class="de"> Erzeugt ein Objekt welches eine Substanz
	 * repräsentiert. Dieser Konstruktor wird verwendet, wenn ein leeres Object
	 * initialisiert werden soll (true) oder codiert werden soll, dass die
	 * Substanz unbekannt ist (false)</div>
	 *
	 * @param consumableKnown
	 *            true: Erstellung eines leeren Objekts, false: Es sind keine
	 *            Impfungen bekannt.
	 */
	public Consumable(boolean consumableKnown) {
		this("");
	}

	public Consumable(org.openhealthtools.mdht.uml.cda.Consumable consumable) {
		super(consumable);
	}

	/**
	 * <div class="en">Creates an object, which represents a consumable
	 * substance.</div><div class="de">Erzeugt ein Objekt welches eine
	 * verabreichende Substanz repräsentiert.</div>
	 *
	 * @param tradeNameOfVaccine
	 *            Handelsname des Impfstoffes
	 */
	public Consumable(String tradeNameOfVaccine) {
		this(tradeNameOfVaccine, null);
	}

	/**
	 * <div class="en">Creates an object, which represents a consumable
	 * substance.</div><div class="de">Erzeugt ein Objekt welches eine
	 * verabreichende Substanz repräsentiert. Dieses Objekt kann einer
	 * ImmunizationRecommendation oder einer Immunization hinzugefügt
	 * werden.</div>
	 *
	 * @param tradeNameOfVaccine
	 *            <div class="en">trade name of vaccine</div>
	 *            <div class="de">Handelsname des Impfstoffes</div>
	 * @param gtin
	 *            <div class="en">GTIN, GLN or swissINDEX.</div>
	 *            <div class="de">Packungs-GTIN, GLN oder swissINDEX. Diese ID
	 *            MUSS ein GTIN, GLN, oder Swiss Index Code sein.</div>
	 *
	 * @see org.ehealth_connector.common.enums.CodeSystems
	 */
	public Consumable(String tradeNameOfVaccine, Code gtin) {
		this(tradeNameOfVaccine, gtin, null);
	}

	/**
	 * <div class="en">Creates an object, which represents a consumable
	 * substance.</div><div class="de">Erzeugt ein Objekt welches eine
	 * verabreichende Substanz repräsentiert. Dieses Objekt kann einer
	 * ImmunizationRecommendation oder einer Immunization hinzugefügt werden.
	 * Wenn der Impfstoff resp. das Produkt nicht bekannt ist (z.B. im Ausland
	 * verabreichte Impfung), dann muss das Antigen mittels WHO ATC angegeben
	 * werden. Wenn in einem Produkt mehrere Antigene enthalten sind, MUSS das
	 * Immunization Element für jedes Antigen je einmal angegeben werden.</div>
	 *
	 * @param tradeNameOfVaccine
	 *            <div class="en">trade name of vaccine</div>
	 *            <div class="de">Handelsname des Impfstoffes</div>
	 * @param gtin
	 *            <div class="en">GTIN, GLN or swissINDEX.</div>
	 *            <div class="de">Packungs-GTIN, GLN oder swissINDEX. Diese ID
	 *            MUSS ein GTIN, GLN, oder Swiss Index Code sein.</div>
	 * @param whoAtcCode
	 *            <div class="en">who atc code</div>
	 */
	public Consumable(String tradeNameOfVaccine, Code gtin, Code whoAtcCode) {

		super(CDAFactory.eINSTANCE.createConsumable());
		this.getMdht().setManufacturedProduct(IHEFactory.eINSTANCE.createProductEntry().init());
		this.getMdht().getManufacturedProduct().setManufacturedMaterial(CDAFactory.eINSTANCE.createMaterial());

		// The WhoAtcCode has to be present as code element, otherwise
		// translations can´t be set
		setManufacturedProductId(Identificator.convertToIdentificator(gtin));
		if (whoAtcCode != null) {
			setWhoAtcCode(whoAtcCode);
		} else {
			setWhoAtcCode(null);
		}
		setTradeName(tradeNameOfVaccine);
		getMdht().setTypeCode(ParticipationType.CSM);
	}

	/**
	 * <div class="en">Adds the manufactured material translation.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param codedId
	 *            das codedId Objekt welches gesetzt wird
	 */
	public void addManufacturedMaterialTranslation(Code codedId) {

		this.getMdht().getManufacturedProduct().getManufacturedMaterial().getCode().getTranslations()
				.add(codedId.getCD());
	}

	/**
	 * Gets the Lot Number (Chargennummer)
	 *
	 * @return the Lot Number
	 */
	public String getLotNr() {
		if ((getMdhtManufacturedMaterial() != null) && (getMdhtManufacturedMaterial().getLotNumberText() != null)) {
			return getMdhtManufacturedMaterial().getLotNumberText().getText();
		}
		return null;
	}

	/**
	 * Gets the manufactured material.
	 *
	 * @return the manufactured material
	 */
	public ManufacturedMaterial getManufacturedMaterial() {
		if (this.getManufacturedProduct() != null && this.getManufacturedProduct().getManufacturedMaterial() != null) {
			return new ManufacturedMaterial(this.getManufacturedProduct().getManufacturedMaterial());
		}
		return null;
	}

	/**
	 * Gets the manufactured material code.
	 *
	 * @return das codedId Objekt
	 */
	public Code getManufacturedMaterialCode() {
		if ((getMdhtManufacturedMaterial() != null) && (getMdhtManufacturedMaterial().getCode() != null)) {
			return new Code(getMdhtManufacturedMaterial().getCode());

		}
		return null;
	}

	/**
	 * Gets the manufactured material translations.
	 *
	 * @return the manufactured material translations
	 */
	public EList<CD> getManufacturedMaterialTranslations() {
		if ((getMdhtManufacturedMaterial() != null) && (getMdhtManufacturedMaterial().getCode() != null)) {
			return getMdhtManufacturedMaterial().getCode().getTranslations();
		}
		return null;
	}

	/**
	 * Gets the manufactured product.
	 *
	 * @return the manufactured product
	 */
	public ManufacturedProduct getManufacturedProduct() {
		return getMdht().getManufacturedProduct();
	}

	/**
	 * Gets the product id from the ManufacturedProduct Ids oder the
	 * ManufacturedMaterial Code or the according translations
	 *
	 * 2017/05/02 According to CDA-CH-II Medications-template, two IDs can be
	 * present: root 1.3.88 --> Product GLN HAS TO BE PRESENT root 1.3.160 -->
	 * Package GTIN HAS TO BE PRESENT IF KNOWN
	 * 
	 * Methods getManufacturedProductProductId() and
	 * getManufacturedProductPackageId() should be used instead (or use the
	 * ihe.pharm.ManufacturedProduct class)
	 * 
	 * @return the gtin or ean or swiss index, null otherwise
	 */
	public Identificator getManufacturedProductId() {
		if (this.getManufacturedProduct() != null)
			for (final II id : getManufacturedProduct().getIds()) {
				if (((id.getRoot() != null) && id.getRoot().equals(CodeSystems.GTIN.getCodeSystemId()))
						|| ((id.getRoot() != null) && id.getRoot().equals(CodeSystems.SwissINDEX.getCodeSystemId()))
						|| ((id.getRoot() != null) && id.getRoot().equals(CodeSystems.GLN.getCodeSystemId()))) {
					final Identificator ide = new Identificator(id);
					return ide;
				}
			}
		return null;
	}

	/**
	 * Gets the product id from the ManufacturedProduct
	 *
	 * @return the swiss index GLN, null otherwise
	 */
	public Identificator getManufacturedProductProductId() {
		for (final II id : getManufacturedProduct().getIds()) {
			if ((id.getRoot() != null) && id.getRoot().equals(CodeSystems.GLN.getCodeSystemId())) {
				final Identificator ide = new Identificator(id);
				return ide;
			}
		}
		return null;
	}

	/**
	 * Gets the package id from the ManufacturedProduct
	 *
	 * @return the swiss index GTIN, null otherwise
	 */
	public Identificator getManufacturedProductPackageId() {
		for (final II id : getManufacturedProduct().getIds()) {
			if ((id.getRoot() != null) && id.getRoot().equals(CodeSystems.GTIN.getCodeSystemId())) {
				final Identificator ide = new Identificator(id);
				return ide;
			}
		}
		return null;
	}

	/**
	 * Gets the Organization that manufactured this product
	 *
	 * @return the organization
	 */
	public Organization getManufacturer() {
		if ((getManufacturedProduct() != null) && (getManufacturedProduct().getManufacturerOrganization() != null)) {
			return new Organization(getManufacturedProduct().getManufacturerOrganization());
		}
		return null;
	}

	private Material getMdhtManufacturedMaterial() {
		if (this.getManufacturedProduct() != null)
			return this.getManufacturedProduct().getManufacturedMaterial();
		return null;
	}

	/**
	 * Gets the trade name.
	 *
	 * @return das tradeNameOfVaccine Objekt
	 */
	public String getTradeName() {
		if ((getMdhtManufacturedMaterial() != null) && (getMdhtManufacturedMaterial().getName() != null)) {
			return getMdhtManufacturedMaterial().getName().getText();
		}
		return null;
	}

	/**
	 * <div class="en">Gets the who atc code.</div> <div class="de">Liefert den
	 * who atc code.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return Code <div class="en">the who atc code</div>
	 */
	public Code getWhoAtcCode() {
		if (this.getManufacturedMaterialCode() != null) {
			if (this.getManufacturedMaterialCode().getCodeSystem().equals(CodeSystems.WHOATCCode.getCodeSystemId())) {
				return getManufacturedMaterialCode();
			}
		}
		return null;
	}

	/**
	 * Sets the Lot Number (Chargennummer)
	 *
	 * @param text
	 *            the lot number text
	 */
	public void setLotNr(String text) {
		if (!"".equals(text) && (getMdhtManufacturedMaterial() != null)) {
			getMdhtManufacturedMaterial().setLotNumberText(Util.st(text));
		}
	}

	/**
	 * Sets the manufactured product
	 *
	 * @param organization
	 *            the organization
	 */
	public void setManufacturedProduct(org.ehealth_connector.cda.ihe.pharm.ManufacturedProduct manufacturedProduct) {
		if (manufacturedProduct != null) {

			org.ehealth_connector.cda.ihe.pharm.ManufacturedProduct newProduct = new org.ehealth_connector.cda.ihe.pharm.ManufacturedProduct(
					manufacturedProduct.getMdht());
			getMdht().setManufacturedProduct(newProduct.getMdht());
		}
	}

	/**
	 * Sets the manufactured product id. This ID HAS TO BE a GTIN, GLN, or Swiss
	 * Index Code
	 *
	 * @see org.ehealth_connector.common.enums.CodeSystems
	 *
	 * @param gtinOrPharmacodeOrGln
	 *            the new manufactured product id. If null, a NullFlavor.UNK
	 *            will be set instead.
	 */
	public void setManufacturedProductId(Identificator gtinOrPharmacodeOrGln) {
		if (getManufacturedProduct() != null) {
			if (gtinOrPharmacodeOrGln != null) {
				getManufacturedProduct().getIds().clear();
				getManufacturedProduct().getIds().add(gtinOrPharmacodeOrGln.getIi());
			} else {
				final II ii = DatatypesFactory.eINSTANCE.createII();
				ii.setNullFlavor(NullFlavor.UNK);
				getManufacturedProduct().getIds().add(ii);
			}
		}
	}

	/**
	 * Sets the Organization that manufactured this product
	 *
	 * @param organization
	 *            the organization
	 */
	public void setManufacturer(Organization organization) {
		if (this.getManufacturedProduct() != null) {
			getManufacturedProduct().setManufacturerOrganization(organization.copyMdhtOrganization());
		}
	}

	/**
	 * Sets the trade name.
	 *
	 * @param tradeNameOfVaccine
	 *            das tradeNameOfVaccine Objekt welches gesetzt wird
	 */
	public void setTradeName(String tradeNameOfVaccine) {
		if (this.getManufacturedMaterial() != null) {
			final EN en = DatatypesFactory.eINSTANCE.createEN();
			if (tradeNameOfVaccine == null) {
				en.addText("Unknown");
			} else {
				en.addText(tradeNameOfVaccine);
			}
			getMdhtManufacturedMaterial().setName(en);
		}
	}

	/**
	 * Sets the who atc code (Use CodeSystem.WHOATCCode)
	 *
	 * @param whoAtcCode
	 *            das WHOATcCode Objekt welches gesetzt wird
	 */
	public void setWhoAtcCode(Code whoAtcCode) {
		if (this.getManufacturedMaterial() != null) {
			CE ce = DatatypesFactory.eINSTANCE.createCE();
			if (whoAtcCode != null) {
				ce = whoAtcCode.getCE();
			} else {
				ce.setNullFlavor(NullFlavor.UNK);
			}
			getMdhtManufacturedMaterial().setCode(ce);
		}
	}

	/**
	 * Clears the type code
	 * 
	 */
	public void unsetTypeCode() {
		this.getMdht().unsetTypeCode();
	}
}
