/*
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
package org.ehealth_connector.valueset.model;

import java.time.LocalDateTime;

import org.ehealth_connector.common.basetypes.OrganizationBaseType;

/**
 * Java Prototype for Value Set Management Concept.
 *
 * Mit Java8 wurde ein neues Date-/Time-API eingeführt. Anstelle von
 * java.util.Date soll ja-va.time.LocalDateTime verwendet werden: LocalDateTime
 * represents a date-time without a time-zone in the ISO-8601 calendar system,
 * such as 2007-12-03T10:15:30
 *
 * Siehe auch
 * https://docs.oracle.com/javase/8/docs/api/java/time/LocalDateTime.html
 *
 */
public interface Version {

	public String getLabel();

	public OrganizationBaseType getPublishingAuthority();

	public LocalDateTime getValidFrom();

	public LocalDateTime getValidTo();

	public void setLabel(String value);

	public void setPublishingAuthority(OrganizationBaseType value);

	public void setValidFrom(LocalDateTime value);

	public void setValidTo(LocalDateTime value);

}
