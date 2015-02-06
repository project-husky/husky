package org.ehc.cda.converter;

import org.ehc.cda.Medication;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Consumable;
import org.openhealthtools.mdht.uml.cda.ManufacturedProduct;
import org.openhealthtools.mdht.uml.cda.Material;
import org.openhealthtools.mdht.uml.cda.Subject;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CS;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.EN;
import org.openhealthtools.mdht.uml.hl7.datatypes.SXCM_TS;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;


/**
 * Converts an eHC Medication class into a IHE Immunization.
 * 
 * @author gsc
 */
public class MedicationConverter {

	private Medication convertee;

	/**
	 * Converter.
	 * 
	 * @param medication
	 */
	public MedicationConverter(Medication medication) {
		convertee = medication;
	}

	/**
	 * Performs the conversion.
	 * 
	 * @return {@link org.openhealthtools.mdht.uml.cda.ihe.Immunization}
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.Immunization convert() {
		org.openhealthtools.mdht.uml.cda.ihe.Immunization immunization = IHEFactory.eINSTANCE.createImmunization().init();
		immunization.setStatusCode(createStatus("completed"));
		immunization.setConsumable(createConsumable());
		immunization.setSubject(createSubject());
		immunization.getEffectiveTimes().add(createTime());

		return immunization;
	}

	private Consumable createConsumable() {
		Consumable consumable = CDAFactory.eINSTANCE.createConsumable();

		consumable.setManufacturedProduct(createManufacturedProduct());

		return consumable;
	}

	private Material createManufacturedMaterial() {
		Material material = CDAFactory.eINSTANCE.createMaterial();
		EN name = DatatypesFactory.eINSTANCE.createEN();
		name.addText(convertee.getName());
		material.setName(name);
		return material;
	}

	private ManufacturedProduct createManufacturedProduct() {
		ManufacturedProduct product = CDAFactory.eINSTANCE.createManufacturedProduct();
		product.setManufacturedMaterial(createManufacturedMaterial());
		return product;
	}	

	private CS createStatus(String code) {
		CS status = DatatypesFactory.eINSTANCE.createCS();
		status.setCode(code);
		return status;
	}

	private Subject createSubject() {
		Subject subject = CDAFactory.eINSTANCE.createSubject();
		return subject;
	}

	private SXCM_TS createTime() {
		SXCM_TS timestamp = DatatypesFactory.eINSTANCE.createSXCM_TS();
		timestamp.setNullFlavor(NullFlavor.NA);
		return timestamp;
	}
}
