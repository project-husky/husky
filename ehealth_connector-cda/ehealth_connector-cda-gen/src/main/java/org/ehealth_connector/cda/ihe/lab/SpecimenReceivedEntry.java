package org.ehealth_connector.cda.ihe.lab;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtEntryActFacade;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

public class SpecimenReceivedEntry
		extends MdhtEntryActFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived> {

	public SpecimenReceivedEntry() {
		super(LABFactory.eINSTANCE.createSpecimenReceived().init());
	}

	/**
	 * Instantiates the class with the required elements.
	 *
	 * @param effectiveTime
	 */
	public SpecimenReceivedEntry(Date effectiveTime) {
		this();
		setEffectiveTime(effectiveTime);
	}

	/**
	 * Instantiates the class with the required elements for LRQC.
	 *
	 * @param effectiveTime
	 *          the effectiveTime
	 * @param id
	 *          the id. If null, it will be set to NullFlavor.UNK
	 */
	public SpecimenReceivedEntry(Date effectiveTime, Identificator id) {
		this();
		setEffectiveTime(effectiveTime);
		addId(id);
	}

	public SpecimenReceivedEntry(SpecimenReceived mdht) {
		super(mdht);
	}

	public void addId(Identificator id) {
		if (id != null) {
			getMdht().getIds().add(id.getIi());
		} else {
			II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setNullFlavor(NullFlavor.UNK);
			getMdht().getIds().add(ii);
		}
	}

	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
	}

	public List<Identificator> getIds() {
		return Util.convertIds(getMdht().getIds());
	}

	public void setEffectiveTime(Date effectiveTime) {
		getMdht().setEffectiveTime(DateUtil.convertDateyyyyMMddHHmmssZZZZ(effectiveTime));
	}
}
