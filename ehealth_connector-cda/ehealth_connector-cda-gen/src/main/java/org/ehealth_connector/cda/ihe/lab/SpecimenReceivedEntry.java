package org.ehealth_connector.cda.ihe.lab;

import java.util.Date;
import java.util.List;

import org.ehealth_connector.cda.MdhtEntryActFacade;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;
import org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived;

public class SpecimenReceivedEntry
		extends MdhtEntryActFacade<org.openhealthtools.mdht.uml.cda.ihe.lab.SpecimenReceived> {

	public SpecimenReceivedEntry() {
		super(LABFactory.eINSTANCE.createSpecimenReceived().init());
	}

	// Required Elements
	public SpecimenReceivedEntry(Date effectiveTime) {
		this();
		setEffectiveTime(effectiveTime);
	}

	public SpecimenReceivedEntry(SpecimenReceived mdht) {
		super(mdht);
	}

	public void addId(Identificator id) {
		getMdht().getIds().add(id.getIi());
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
