/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://gitlab.com/ehealth-connector/api/wikis/Team/
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
package org.ehealth_connector.xua.saml2.impl;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.herasaf.xacml.core.dataTypeAttribute.DataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.AnyURIDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.Base64BinaryDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.BooleanDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.DateDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.DateTimeDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.DayTimeDurationDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.DnsNameDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.DoubleDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.HexBinaryDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.IntegerDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.IpAddressDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.RFC822NameDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.StringDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.TimeDataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.X500DataTypeAttribute;
import org.herasaf.xacml.core.dataTypeAttribute.impl.YearMonthDurationDataTypeAttribute;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.CvDataTypeAttribute;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.types.IiDataTypeAttribute;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Function building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Function bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class DataTypeAttributeBuilderImpl
		implements SimpleBuilder<DataTypeAttribute<?>>, SecurityObjectBuilder<String, DataTypeAttribute<?>> {

	@Override
	public DataTypeAttribute<?> create(String aInternalObject) {
		DataTypeAttribute<?> function = null;
		if ("http://www.w3.org/2001/XMLSchema#anyURI".equalsIgnoreCase(aInternalObject)) {
			function = new AnyURIDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#base64Binary".equalsIgnoreCase(aInternalObject)) {
			function = new Base64BinaryDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#boolean"
				.equalsIgnoreCase(aInternalObject)) {
			function = new BooleanDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#date".equalsIgnoreCase(aInternalObject)) {
			function = new DateDataTypeAttribute();
		} else if ("http://www.w3.org/TR/xmlschema-2/#dateTime"
				.equalsIgnoreCase(aInternalObject)) {
			function = new DateTimeDataTypeAttribute();
		} else if ("urn:oasis:names:tc:xacml:2.0:data-type:dayTimeDuration"
				.equalsIgnoreCase(aInternalObject)) {
			function = new DayTimeDurationDataTypeAttribute();
		} else if ("urn:oasis:names:tc:xacml:2.0:data-type:dnsName".equalsIgnoreCase(aInternalObject)) {
			function = new DnsNameDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#double"
				.equalsIgnoreCase(aInternalObject)) {
			function = new DoubleDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#hexBinary"
				.equalsIgnoreCase(aInternalObject)) {
			function = new HexBinaryDataTypeAttribute();
		} else if ("urn:hl7-org:v3#CV"
				.equalsIgnoreCase(aInternalObject)) {
			function = new CvDataTypeAttribute();
		} else if ("urn:hl7-org:v3#II".equalsIgnoreCase(aInternalObject)) {
			function = new IiDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#integer"
				.equalsIgnoreCase(aInternalObject)) {
			function = new IntegerDataTypeAttribute();
		} else if ("urn:oasis:names:tc:xacml:2.0:data-type:ipAddress"
				.equalsIgnoreCase(aInternalObject)) {
			function = new IpAddressDataTypeAttribute();
		} else if ("urn:oasis:names:tc:xacml:1.0:data-type:rfc822Name"
				.equalsIgnoreCase(aInternalObject)) {
			function = new RFC822NameDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#string"
				.equalsIgnoreCase(aInternalObject)) {
			function = new StringDataTypeAttribute();
		} else if ("http://www.w3.org/2001/XMLSchema#time".equalsIgnoreCase(aInternalObject)) {
			function = new TimeDataTypeAttribute();
		} else if ("urn:oasis:names:tc:xacml:2.0:data-type:x500Name".equalsIgnoreCase(aInternalObject)) {
			function = new X500DataTypeAttribute();
		} else if ("urn:oasis:names:tc:xacml:2.0:data-type:yearMonthDuration"
				.equalsIgnoreCase(aInternalObject)) {
			function = new YearMonthDurationDataTypeAttribute();
		}

		return function;
	}

	@Override
	public DataTypeAttribute<?> create() {
		return new AnyURIDataTypeAttribute();
	}

	public String create(DataTypeAttribute<?> aInternalObject) {
		String function = null;
		if (aInternalObject instanceof AnyURIDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#anyURI";
		} else if (aInternalObject instanceof Base64BinaryDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#base64Binary";
		} else if (aInternalObject instanceof BooleanDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#boolean";
		} else if (aInternalObject instanceof DateDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#date";
		} else if (aInternalObject instanceof DateTimeDataTypeAttribute) {
			function = "http://www.w3.org/TR/xmlschema-2/#dateTime";
		} else if (aInternalObject instanceof DayTimeDurationDataTypeAttribute) {
			function = "urn:oasis:names:tc:xacml:2.0:data-type:dayTimeDuration";
		} else if (aInternalObject instanceof DnsNameDataTypeAttribute) {
			function = "urn:oasis:names:tc:xacml:2.0:data-type:dnsName";
		} else if (aInternalObject instanceof DoubleDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#double";
		} else if (aInternalObject instanceof HexBinaryDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#hexBinary";
		} else if (aInternalObject instanceof CvDataTypeAttribute) {
			function = "urn:hl7-org:v3#CV";
		} else if (aInternalObject instanceof IiDataTypeAttribute) {
			function = "urn:hl7-org:v3#II";
		} else if (aInternalObject instanceof IntegerDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#integer";
		} else if (aInternalObject instanceof IpAddressDataTypeAttribute) {
			function = "urn:oasis:names:tc:xacml:2.0:data-type:ipAddress";
		} else if (aInternalObject instanceof RFC822NameDataTypeAttribute) {
			function = "urn:oasis:names:tc:xacml:1.0:data-type:rfc822Name";
		} else if (aInternalObject instanceof StringDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#string";
		} else if (aInternalObject instanceof TimeDataTypeAttribute) {
			function = "http://www.w3.org/2001/XMLSchema#time";
		} else if (aInternalObject instanceof X500DataTypeAttribute) {
			function = "urn:oasis:names:tc:xacml:2.0:data-type:x500Name";
		} else if (aInternalObject instanceof YearMonthDurationDataTypeAttribute) {
			function = "urn:oasis:names:tc:xacml:2.0:data-type:yearMonthDuration";
		}

		return function;
	}

}
