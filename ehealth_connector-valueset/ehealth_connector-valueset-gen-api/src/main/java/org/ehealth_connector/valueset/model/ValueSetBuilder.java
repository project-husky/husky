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

import java.util.Date;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.enums.ValueSetStatusEnum;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface ValueSetBuilder {

	public ValueSetBuilder addMappingIdentificator(IdentificatorBaseType value);

	public ValueSetBuilder addMappingName(String value);

	public ValueSetBuilder addValueSetEntry(ValueSetEntry value);

	public ValueSet createValueSet();

	public ValueSetBuilder decription(String value);

	public ValueSetBuilder displayName(String value);

	public ValueSetBuilder effectiveDate(Date value);

	public ValueSetBuilder identificator(IdentificatorBaseType value);

	public ValueSetBuilder name(String value);

	public ValueSetBuilder status(ValueSetStatusEnum value);

	public ValueSetBuilder version(Version value);
}
