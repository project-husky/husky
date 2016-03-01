package org.ehealth_connector.cda.ihe.lab;

import java.text.ParseException;
import java.util.Date;

import org.ehealth_connector.cda.MdhtParticipant1Facade;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.ihe.lab.LABFactory;

public class ReferralOrderingPhysician extends
		MdhtParticipant1Facade<org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician> {

	protected ReferralOrderingPhysician() {
		super(LABFactory.eINSTANCE.createReferralOrderingPhysician().init());
	}

	protected ReferralOrderingPhysician(
			org.openhealthtools.mdht.uml.cda.ihe.lab.ReferralOrderingPhysician mdht) {
		super(mdht);
	}

	/**
	 * Gets the time as Java Date Object
	 *
	 * @return the time
	 */
	public Date getTime() {
		if (getMdht().getTime() != null) {
			return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getTime());
		}
		return null;
	}

	/**
	 * Sets the time as Data object
	 *
	 * @param date
	 *          the date
	 */
	public void setTime(Date date) {
		try {
			getMdht().setTime(DateUtil.createIVL_TSFromEuroDate(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
