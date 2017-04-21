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
