/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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

package org.ehealth_connector.cda.ihe.pharm;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.mdht.Identificator;
import org.ehealth_connector.common.mdht.Organization;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.ihe.pharm.PHARMFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;
import org.openhealthtools.mdht.uml.hl7.vocab.RoleClassManufacturedProduct;

/**
 * The Class CdaChMtpsMtp. see also CDA CH MTPS 7.4.2.3
 */
public class ManufacturedProduct
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ManufacturedProduct> {

	/**
	 * Instantiates a new cda ch mtps mtp.
	 */
	public ManufacturedProduct() {
		this(LanguageCode.ENGLISH);
	}

	/**
	 * Instantiates a new manufactured product item entry.
	 *
	 * @param languageCode
	 *            the language code
	 */
	public ManufacturedProduct(LanguageCode languageCode) {
		super(PHARMFactory.eINSTANCE.createPharmManufacturedProductEntry().init());

		org.openhealthtools.mdht.uml.cda.ManufacturedProduct product = this.getMdht();
		product.setClassCode(RoleClassManufacturedProduct.MANU);
	}

	/**
	 * Instantiates a new manufactured product item entry.
	 *
	 * @param mdht
	 */
	public ManufacturedProduct(org.openhealthtools.mdht.uml.cda.ManufacturedProduct mdht) {
		super(mdht);
	}

	/**
	 * Adds the manufactured product id. This ID HAS TO BE a GTIN, GLN, or Swiss
	 * Index Code
	 *
	 * @see org.ehealth_connector.common.enums.CodeSystems
	 *
	 *      2017/05/02 According to CDA-CH-II Medications-template, two IDs can
	 *      be present: root 1.3.88 --> Product GLN HAS TO BE PRESENT root
	 *      1.3.160 --> Package GTIN HAS TO BE PRESENT IF KNOWN --> several ids
	 *      may be present
	 *
	 * @param gtinOrPharmacodeOrGln
	 *            the new manufactured product id. If null, a NullFlavor.NA will
	 *            be set instead and all others will be removed
	 */
	public void addManufacturedProductId(Identificator gtinOrPharmacodeOrGln) {
		if (gtinOrPharmacodeOrGln != null) {
			getMdht().getIds().add(gtinOrPharmacodeOrGln.getIi());
		} else {
			this.getMdht().getIds().clear();
			this.getMdht().getIds()
					.add(CdaUtil.getMdhtDatatypesFactoryInstance().createII(NullFlavor.NA));
		}
	}

	/**
	 * Clears the Manufactured Product in order to make a null flavored
	 * manufactured product (required for references to MTP and PRE items)
	 *
	 */
	public void emptyManufacturedProduct() {
		this.getMdht().getTemplateIds().clear();
		this.setManufacturedMaterial(null);
		this.getMdht().getIds().clear();
		this.getMdht().unsetClassCode();
	}

	/**
	 * Gets the manufactured material.
	 *
	 * @return the manufactured material
	 */
	public ManufacturedMaterial getManufacturedMaterial() {
		if (this.getMdht().getManufacturedMaterial() != null)
			return new ManufacturedMaterial(this.getMdht().getManufacturedMaterial());
		return null;
	}

	/**
	 * Gets the manufactured product package id.
	 *
	 * @return the manufactured product package id (swiss index GTIN) or null.
	 */
	public Identificator getManufacturedProductPackageId() {
		for (final II id : getMdht().getIds()) {
			if ((id.getRoot() != null) && id.getRoot().equals(CodeSystems.GTIN.getCodeSystemId())) {
				final Identificator ide = new Identificator(id);
				return ide;
			}
		}
		return null;
	}

	/**
	 * Gets the pharmacode (SwissInedx) id from the ManufacturedProduct
	 *
	 * @return the swiss index GTIN, null otherwise
	 */
	public Identificator getManufacturedProductPharmacodeId() {
		for (final II id : getMdht().getIds()) {
			if ((id.getRoot() != null)
					&& id.getRoot().equals(CodeSystems.SwissINDEX.getCodeSystemId())) {
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
		for (final II id : getMdht().getIds()) {
			if ((id.getRoot() != null) && id.getRoot().equals(CodeSystems.GLN.getCodeSystemId())) {
				final Identificator ide = new Identificator(id);
				return ide;
			}
		}
		return null;
	}

	/**
	 * Gets the manufacturer organization.
	 *
	 * @return the manufacturer organization
	 */
	public Organization getManufacturerOrganization() {
		if (this.getMdht().getManufacturerOrganization() != null)
			return new Organization(this.getMdht().getManufacturerOrganization());
		return null;
	}

	/**
	 * Sets the manufactured material
	 *
	 * @param manufacturedMaterial
	 *            Manufactured material - if null, a NullFlavor.NA material is
	 *            generated
	 *
	 */
	public void setManufacturedMaterial(ManufacturedMaterial manufacturedMaterial) {
		if (manufacturedMaterial != null) {
			ManufacturedMaterial material = new ManufacturedMaterial(
					manufacturedMaterial.getMdht());
			this.getMdht().setManufacturedMaterial(material.getMdht());
		} else {
			final Material material = CdaUtil.getMdhtCdaFactoryInstance().createMaterial();
			material.setNullFlavor(NullFlavor.NA);
			material.getTemplateIds().clear();
			this.getMdht().setManufacturedMaterial(material);
		}
	}

	/**
	 * Sets the manufacturer organization
	 *
	 * @param manufacturerOrganization
	 *            Manufacturer organization
	 *
	 */
	public void setManufacturerOrganization(Organization manufacturerOrganization) {
		if (manufacturerOrganization != null) {
			Organization newOrg = new Organization(manufacturerOrganization.getMdhtOrganization());
			this.getMdht().setManufacturerOrganization(newOrg.getMdhtOrganization());
		}
	}

}
