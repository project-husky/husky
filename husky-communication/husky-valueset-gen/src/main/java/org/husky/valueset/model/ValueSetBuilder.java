package org.husky.valueset.model;

import java.util.ArrayList;

import org.husky.common.basetypes.IdentificatorBaseType;

/**
 * Base Builder to build {@link ValueSetPackage} or {@link ValueSet}.
 */
public class ValueSetBuilder {

	protected IdentificatorBaseType identificator;
	protected ArrayList<IdentificatorBaseType> mappingIdentificatorList;
	protected ArrayList<String> mappingNameList;
	protected Version version;

	public ValueSetBuilder withIdentificator(IdentificatorBaseType identificator) {
		this.identificator = identificator;
		return this;
	}

	public ValueSetBuilder withMappingIdentificatorList(ArrayList<IdentificatorBaseType> mappingIdentificatorList) {
		this.mappingIdentificatorList = mappingIdentificatorList;
		return this;
	}

	public ValueSetBuilder withMappingNameList(ArrayList<String> mappingNameList) {
		this.mappingNameList = mappingNameList;
		return this;
	}

	public ValueSetBuilder withVersion(Version version) {
		this.version = version;
		return this;
	}

}
