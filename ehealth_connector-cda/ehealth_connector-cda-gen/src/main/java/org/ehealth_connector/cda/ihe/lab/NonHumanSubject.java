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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Code;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * The Class NonHumanSubject. When the subject of the observations in the report
 * is a sample exclusively taken from a non-human subject, such as an animal, a
 * lake, soil or other environmental element, the following SHALL be present.
 */
public class NonHumanSubject
		extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.NonHumanSubject> {

	/**
	 * Instantiates a new non human subject.
	 */
	public NonHumanSubject() {
		super(LABFactory.eINSTANCE.createNonHumanSubject().init());
		getMdht().setRelatedSubject(CDAFactory.eINSTANCE.createRelatedSubject());
	}

	/**
	 * Instantiates the class with the required elements.
	 * /subject/relatedSubject/code will be set to NullFlavor.UNK.
	 *
	 * @param adress
	 *            Address of the non-human subject
	 */
	public NonHumanSubject(Address adress) {
		this();
		setCode(null);
		setAdress(adress);
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param code
	 *            Code characterizing the non-human subject (animal species,
	 *            material...).
	 * @param adress
	 *            Address of the non-human subject
	 */
	public NonHumanSubject(Code code, Address adress) {
		this();
		setCode(code);
		setAdress(adress);
	}

	/**
	 * Instantiates a new non human subject.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public NonHumanSubject(org.openhealthtools.mdht.uml.cda.ihe.lab.NonHumanSubject mdht) {
		super(mdht);
	}

	/**
	 * Gets the adress.
	 *
	 * @return the adress
	 */
	public Address getAdress() {
		if ((getMdht().getRelatedSubject() != null)
				&& !getMdht().getRelatedSubject().getAddrs().isEmpty()) {
			return new Address(getMdht().getRelatedSubject().getAddrs().get(0));
		}
		return null;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public Code getCode() {
		if ((getMdht().getRelatedSubject() != null)
				&& (getMdht().getRelatedSubject().getCode() != null)) {
			return new Code(getMdht().getRelatedSubject().getCode());
		}
		return null;
	}

	/**
	 * Sets the adress.
	 *
	 * @param adress
	 *            Address of the non-human subject
	 */
	public void setAdress(Address adress) {
		getMdht().getRelatedSubject().getAddrs().add(adress.copyMdhtAdress());
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            Code characterizing the non-human subject (animal species,
	 *            material...). If null, /subject/relatedSubject/code will be
	 *            set to NullFlavor.UNK.
	 */
	public void setCode(Code code) {
		if (code == null) {
			final CE ce = DatatypesFactory.eINSTANCE.createCE();
			ce.setNullFlavor(NullFlavor.UNK);
			getMdht().getRelatedSubject().setCode(ce);
		} else {
			getMdht().getRelatedSubject().setCode(code.getCE());
		}
	}

}
