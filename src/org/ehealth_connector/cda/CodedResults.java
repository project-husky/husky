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

package org.ehealth_connector.cda;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.StatusCode;
import org.ehealth_connector.common.DateUtil;
import org.ehealth_connector.common.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ch.CodedResultsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntry;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntryProcedureActivityProcedure;
import org.openhealthtools.mdht.uml.cda.ihe.SimpleObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * <div class="de">Klasse Gestationsalter. Dies ist der Zeitraum vom 1. Tag der
 * letzten Regelblutung der Mutter bis zur Geburt des Kindes. Hier kann
 * Gestationsalter eines Kindes angegeben werden, sofern das rund um Impfungen
 * am Kind relevant ist. </div>\n <div class="fr"></div> <div class="it"></div>
 */
public class CodedResults {

	CodedResultsSection crs;
	II mIi;

	public CodedResults() {
	  crs = CHFactory.eINSTANCE.createCodedResultsSection().init();
	}
	
	public CodedResults(CodedResultsSection crsection) {
	  crs = crsection;
	}
	
	/**
	 * Instantiates a new Simple Observation
	 *
	 */
	public CodedResults(SimpleObservation so) {
		this();
		crs.addObservation(so);

		// Create Id
		mIi = Util.createUuidVacdIdentificator(null);

		// CreateEmpty Procedure Entry
		//crs.addProcedure(createEmptyProcedureEntry());
	}

	public void addSimpleObservation(SimpleObservation so) {
	  crs.addObservation(so);
	}
	
	/**
	 * <div class="de">Copy mdht coded results section.</div> <div
	 * class="fr"></div> <div class="it"></div>
	 *
	 * @return the coded results section
	 */
	public CodedResultsSection copyMdhtCodedResultsSection() {
		return EcoreUtil.copy(crs);
	}

	private ProcedureEntry createEmptyProcedureEntry() {
		// Create and add an empty procedureEntry
		ProcedureEntryProcedureActivityProcedure pe = IHEFactory.eINSTANCE
				.createProcedureEntryProcedureActivityProcedure().init();
		pe.getIds().add(Util.createUuidVacd(null));
		pe.setCode(Util.createCodeNullFlavorNA());

		// Create NullFlavor Reference
		ED text = DatatypesFactory.eINSTANCE.createED();
		TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.NA);
		text.setReference(tel);

		pe.setText(text);
		pe.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
		pe.setStatusCode(StatusCode.COMPLETED.getCS());
		return pe;
	}
}
