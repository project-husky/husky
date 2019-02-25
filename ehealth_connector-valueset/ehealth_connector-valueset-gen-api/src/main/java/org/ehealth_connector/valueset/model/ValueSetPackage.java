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

import java.util.List;

import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatusEnum;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface ValueSetPackage {

	public void addMappingIdentificator(IdentificatorBaseType value);

	public void addMappingName(String value);

	public void addValueSet(ValueSet value);

	public String getDecription();

	public IdentificatorBaseType getIdentificator();

	public String getSourceUrl();

	public ValueSetPackageStatusEnum getStatus();

	public Version getVersion();

	public List<IdentificatorBaseType> listMappingIdentificator();

	public List<String> listMappingNames();

	public List<ValueSet> listValueSets();

	public void setDecription(String value);

	public void setIdentificator(IdentificatorBaseType value);

	public void setSourceUrl(String value);

	public void setStatus(ValueSetPackageStatusEnum value);

	public void setVersion(Version value);
}
