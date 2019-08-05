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

package org.ehealth_connector.cda.ch;

import org.ehealth_connector.cda.AbstractCodedResults;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtilOld;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ch.ChFactory;
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

	/**
	 * Instantiates a new instance
	 */
	public CodedResults() {
		super(ChFactory.eINSTANCE.createCodedResultsSection().init());
	}

	/**
	 * Instantiates a new instance.
	 *
	 * @param crsection
	 *            the section
	 */
	public CodedResults(CodedResultsSection crsection) {
		super(crsection);
	}

	/**
	 * Instantiates a new instance.
	 *
	 * @param so
	 *            the simple observation
	 */
	public CodedResults(SimpleObservation so) {
		super(so);

		// Create Id
		setIi(CdaUtil.createUniqueIi());
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
		pe.getIds().add(CdaUtil.createUniqueIi());
		pe.setCode(Util.createCodeNullFlavorNA());

		// Create NullFlavor Reference
		final ED text = DatatypesFactory.eINSTANCE.createED();
		final TEL tel = DatatypesFactory.eINSTANCE.createTEL();
		tel.setNullFlavor(NullFlavor.NA);
		text.setReference(tel);

		pe.setText(text);
		pe.setEffectiveTime(DateUtilOld.createUnknownTime(NullFlavor.NA));
		pe.setStatusCode(StatusCode.COMPLETED.getCS());
		return pe;
	}

}
