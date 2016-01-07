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
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch;

import java.net.URL;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.ch.vacd.MedicationTargetEntry;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.ExternalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CDACHBodyExtRef;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassDocument;
import org.openhealthtools.mdht.uml.hl7.vocab.ActMood;

/**
 * @deprecated replaced by MedicationTargetEntry
 */
@Deprecated
public class Reason extends MedicationTargetEntry {

	private CDACHBodyExtRef mExtRef = null;

	/**
	 * Standard constructor
	 */
	public Reason() {
	}

	/**
	 * Instantiates a Reason object with a code
	 * 
	 * @param code
	 *            the code
	 */
	public Reason(Code code) {
		this();
		setCode(code);
	}

	/**
	 * Instantiates a Reason with a given code, a reference and an ID
	 * 
	 * @param code
	 *            the code
	 * @param reference
	 *            the reference
	 * @param id
	 *            the id. If null, an ID will be generated
	 */
	public Reason(Code code, URL reference, String id) {
		this(code);
		initExtRef();
		setReference(reference);
		setReferenceId(id);
	}

	/**
	 * Instantiates a new reason.
	 * 
	 * @param entry
	 *            the entry
	 */
	protected Reason(org.openhealthtools.mdht.uml.cda.ch.MedicationTargetEntry entry) {
		super(entry);
	}

	/**
	 * Gets a copy of the mdht CDACHBodyExtRef object
	 * 
	 * @return the CDACHBodyExtRef
	 */
	public CDACHBodyExtRef copyMdhtCDACHBodyExtRef() {
		return EcoreUtil.copy(mExtRef);
	}

	/**
	 * Gets the code
	 * 
	 * @return the code
	 */
	public Code getCode() {
		return super.getImmunizationTargetCode();
	}

	/**
	 * Gets the CDACHBodyExtRef
	 * 
	 * @return the CDACHBodyExtRef
	 */
	public CDACHBodyExtRef getMdhtCDACHBodyExtRef() {
		return mExtRef;
	}

	/**
	 * Gets the Reference to an external object as string
	 * 
	 * @return the reference
	 */
	public String getReference() {
		if ((mExtRef != null) && (mExtRef.getExternalDocument() != null)
				&& (mExtRef.getExternalDocument().getText() != null)) {
			return mExtRef.getExternalDocument().getText().getReference().getValue();
		} else
			return null;
	}

	/**
	 * Gets the id of the reference as string
	 * 
	 * @return the reference id
	 */
	public String getReferenceId() {
		if ((mExtRef != null) && (mExtRef.getExternalDocument() != null)
				&& (mExtRef.getExternalDocument().getText() != null)
				&& (mExtRef.getExternalDocument().getIds().get(0) != null)) {
			return mExtRef.getExternalDocument().getIds().get(0).getExtension();
		} else {
			return null;
		}
	}

	public void setCode(Code code) {
		super.setImmunizationTargetCode(code);
	}

	/**
	 * Sets a reference to an external Document.
	 * 
	 * @param reference
	 *            The Reference URL (e.g.
	 *            'http://www.bag.admin.ch/ekif/04423/04428/index.html?lang=de')
	 */
	public void setReference(URL reference) {
		if (mExtRef == null) {
			initExtRef();
		}

		mExtRef.getExternalDocument().setText(Util.createReference(reference.toString()));
	}

	/**
	 * Sets the reference id
	 * 
	 * @param id
	 *            the if of the reference (if null, an id will be generated)
	 */
	public void setReferenceId(String id) {
		if (mExtRef == null) {
			initExtRef();
		}

		// Set the id or generate if null
		final II docIi = DatatypesFactory.eINSTANCE.createII();
		docIi.setRoot("2.16.756.5.30.1.1.1.1.3.6.21");
		if (id == null) {
			docIi.setExtension(org.openhealthtools.ihe.utils.UUID.generate());
		} else {
			docIi.setExtension(id);
		}
		mExtRef.getExternalDocument().getIds().clear();
		mExtRef.getExternalDocument().getIds().add(docIi);
	}

	private void initExtRef() {
		mExtRef = CHFactory.eINSTANCE.createCDACHBodyExtRef().init();
		final ExternalDocument e = CDAFactory.eINSTANCE.createExternalDocument();
		mExtRef.setExternalDocument(e);

		// Fix Template ID
		mExtRef.getTemplateIds().clear();
		final II ii = DatatypesFactory.eINSTANCE.createII(AbstractCdaCh.OID_V1, "CDA-CH.Body.ExtRef");
		mExtRef.getTemplateIds().add(ii);

		// Set attributes
		e.setClassCode(ActClassDocument.DOC);
		e.setMoodCode(ActMood.EVN);
		setReferenceId(null);
	}
}
