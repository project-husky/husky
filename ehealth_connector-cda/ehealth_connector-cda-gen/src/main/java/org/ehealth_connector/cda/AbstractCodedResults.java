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

package org.ehealth_connector.cda;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.openhealthtools.mdht.uml.cda.ihe.CodedResultsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntry;
import org.openhealthtools.mdht.uml.cda.ihe.SimpleObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 * <div class="de">Klasse Gestationsalter. Dies ist der Zeitraum vom 1. Tag der
 * letzten Regelblutung der Mutter bis zur Geburt des Kindes. Hier kann
 * Gestationsalter eines Kindes angegeben werden, sofern das rund um Impfungen
 * am Kind relevant ist. </div> <div class="fr"></div> <div class="it"></div>
 */
public abstract class AbstractCodedResults {

	private CodedResultsSection crs;
	private II mIi;

	public AbstractCodedResults() {
		crs = IHEFactory.eINSTANCE.createCodedResultsSection().init();
	}

	public AbstractCodedResults(CodedResultsSection crsection) {
		crs = crsection;
	}

	/**
	 * Instantiates a new Simple Observation
	 *
	 * @param so
	 *            the simple observation
	 *
	 */
	public AbstractCodedResults(SimpleObservation so) {
		crs.addObservation(so);

		// Create Id
		// mIi = CdaUtil.createUuidIdentificator(null);

		// CreateEmpty Procedure Entry
		// crs.addProcedure(createEmptyProcedureEntry());
	}

	/**
	 * Adds a Simple Observation
	 *
	 * @param so
	 *            the simple observation
	 */
	public void addSimpleObservation(SimpleObservation so) {
		crs.addObservation(so);
	}

	/**
	 * <div class="en">Copy mdht coded results section.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the coded results section
	 */
	public CodedResultsSection copyMdhtCodedResultsSection() {
		return EcoreUtil.copy(crs);
	}

	protected abstract ProcedureEntry createEmptyProcedureEntry();

	/**
	 * Method to get
	 *
	 * @return the crs
	 */
	public CodedResultsSection getCrs() {
		return crs;
	}

	/**
	 * Method to get
	 *
	 * @return the mIi
	 */
	public II getIi() {
		return mIi;
	}

	/**
	 * Method to set
	 *
	 * @param crs
	 *            the crs to set
	 */
	public void setCrs(CodedResultsSection crs) {
		this.crs = crs;
	}

	/**
	 * Method to set
	 *
	 * @param mIi
	 *            the mIi to set
	 */
	public void setIi(II mIi) {
		this.mIi = mIi;
	}
}
