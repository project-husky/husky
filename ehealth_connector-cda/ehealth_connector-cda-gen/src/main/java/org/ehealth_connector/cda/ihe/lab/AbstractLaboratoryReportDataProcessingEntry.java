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
package org.ehealth_connector.cda.ihe.lab;

import org.ehealth_connector.cda.MdhtEntryFacade;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

/**
 * The Class AbstractLaboratoryReportDataProcessingEntry.
 */
public abstract class AbstractLaboratoryReportDataProcessingEntry extends
		MdhtEntryFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry> {

	/**
	 * Instantiates a new abstract laboratory report data processing entry.
	 */
	public AbstractLaboratoryReportDataProcessingEntry() {
		super(LABFactory.eINSTANCE.createLaboratoryReportDataProcessingEntry().init());
	}

	/**
	 * Instantiates a new abstract laboratory report data processing entry.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public AbstractLaboratoryReportDataProcessingEntry(
			org.openhealthtools.mdht.uml.cda.ihe.lab.LaboratoryReportDataProcessingEntry mdht) {
		super(mdht);
	}
}
