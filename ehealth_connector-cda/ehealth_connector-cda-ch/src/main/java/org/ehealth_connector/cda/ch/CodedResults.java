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

import org.ehealth_connector.cda.AbstractCodedResults;
import org.ehealth_connector.cda.ch.utils.CdaChUtil;
import org.ehealth_connector.common.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ch.CHFactory;
import org.openhealthtools.mdht.uml.cda.ihe.CodedResultsSection;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntry;
import org.openhealthtools.mdht.uml.cda.ihe.ProcedureEntryProcedureActivityProcedure;
import org.openhealthtools.mdht.uml.cda.ihe.SimpleObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.ED;
import org.openhealthtools.mdht.uml.hl7.datatypes.TEL;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/**
 * <div class="de">Klasse Gestationsalter. Dies ist der Zeitraum vom 1. Tag der
 * letzten Regelblutung der Mutter bis zur Geburt des Kindes. Hier kann
 * Gestationsalter eines Kindes angegeben werden, sofern das rund um Impfungen
 * am Kind relevant ist. </div> <div class="fr"></div> <div class="it"></div>
 */
public class CodedResults extends AbstractCodedResults {

	public CodedResults() {
		super(CHFactory.eINSTANCE.createCodedResultsSection().init());
	}

	public CodedResults(CodedResultsSection crsection) {
		super(crsection);
	}

	/**
	 * Instantiates a new Simple Observation
	 *
	 * @param so
	 *          the simple observation
	 *
	 */
	public CodedResults(SimpleObservation so) {
		super(so);

		// Create Id
		setIi(CdaChUtil.createUuidVacdIdentificator(null));
	}

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.cda.AbstractCodedResults#createEmptyProcedureEntry()
	 */
	@Override
	protected ProcedureEntry createEmptyProcedureEntry() {
		// Create and add an empty procedureEntry
		final ProcedureEntryProcedureActivityProcedure pe = IHEFactory.eINSTANCE
				.createProcedureEntryProcedureActivityProcedure().init();
		pe.getIds().add(CdaChUtil.createUuidVacd(null));
		pe.setCode(Util.createCodeNullFlavorNA());

		// Create NullFlavor Reference
		final ED text = DatatypesFactory.eINSTANCE.createED();
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.NA);
		text.setReference(tel);

		pe.setText(text);
		pe.setEffectiveTime(DateUtil.createUnknownTime(NullFlavor.NA));
		pe.setStatusCode(StatusCode.COMPLETED.getCS());
		return pe;
	}

}
