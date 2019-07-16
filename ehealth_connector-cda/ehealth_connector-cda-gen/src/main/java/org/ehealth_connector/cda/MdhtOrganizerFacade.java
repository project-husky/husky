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
package org.ehealth_connector.cda;

import java.util.Date;

import org.ehealth_connector.common.mdht.enums.StatusCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.openhealthtools.mdht.uml.cda.Organizer;

/**
 * The MDHT Facade for Organizers.
 *
 * @param <E>
 *            the element type
 */
public class MdhtOrganizerFacade<E extends Organizer> extends MdhtFacade<E> {

	/**
	 * Instantiates a new instance.
	 *
	 * @param mdht
	 *            the mdht
	 */
	protected MdhtOrganizerFacade(E mdht) {
		super(mdht);
	}

	/**
	 * Gets the effective time.
	 *
	 * @return the effective time
	 */
	public Date getEffectiveTime() {
		if (getMdht() != null && getMdht().getEffectiveTime() != null) {
			return DateUtil.parseIVL_TSVDateTimeValue(getMdht().getEffectiveTime());
		}
		return null;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public StatusCode getStatusCode() {
		if (getMdht() != null && getMdht().getStatusCode() != null) {
			return StatusCode.getEnum(getMdht().getStatusCode().getCode());
		}
		return null;
	}

	/**
	 * Sets the effective time.
	 *
	 * @param date
	 *            the new effective time
	 */
	public void setEffectiveTime(Date date) {
		if (date != null)
			getMdht().setEffectiveTime(DateUtil.convertDateToIvlTsyyyyMMddHHmmssZZZZ(date));
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode
	 *            the new status code
	 */
	public void setStatusCode(StatusCode statusCode) {
		getMdht().setStatusCode(statusCode.getCS());
	}
}
