/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.xua.saml2.impl;

import org.herasaf.xacml.core.function.Function;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateBagFunction;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateBagSizeFunction;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateIsInFunction;
import org.herasaf.xacml.core.function.impl.bagFunctions.DateOneAndOnlyFunction;
import org.herasaf.xacml.core.function.impl.dateAndTimeArithmeticFunctions.DateAddYearMonthDurationFunction;
import org.herasaf.xacml.core.function.impl.dateAndTimeArithmeticFunctions.DateSubtractYearMonthDurationFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.AnyURIEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.Base64BinaryEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.BooleanEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.DateEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.DoubleEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.IntegerEqualFunction;
import org.herasaf.xacml.core.function.impl.equalityPredicates.StringEqualFunction;
import org.herasaf.xacml.core.function.impl.higherOrderBagFunctions.AllOfAllFunction;
import org.herasaf.xacml.core.function.impl.higherOrderBagFunctions.AllOfAnyFunction;
import org.herasaf.xacml.core.function.impl.higherOrderBagFunctions.AllOfFunction;
import org.herasaf.xacml.core.function.impl.higherOrderBagFunctions.AnyOfAllFunction;
import org.herasaf.xacml.core.function.impl.higherOrderBagFunctions.AnyOfAnyFunction;
import org.herasaf.xacml.core.function.impl.higherOrderBagFunctions.AnyOfFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateGreaterThanFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateGreaterThanOrEqualFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateLessThanFunction;
import org.herasaf.xacml.core.function.impl.nonNumericComparisonFunctions.DateLessThanOrEqualFunction;
import org.herasaf.xacml.core.function.impl.regularExpressionBasedFunctions.AnyURIRegexpMatchFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateAtLeastOneMemberOfFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateIntersectionFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateSetEqualsFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateSubsetFunction;
import org.herasaf.xacml.core.function.impl.setFunction.DateUnionFunction;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.functions.CvEqualFunction;
import org.openehealth.ipf.commons.ihe.xacml20.herasaf.functions.IiEqualFunction;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Function building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Function bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class FunctionBuilderImpl
		implements SimpleBuilder<Function>, SecurityObjectBuilder<String, Function> {

	@Override
	/* simple function for comparing namespaces amm creating an object based on namespace, reducing complexity not necessary */
	@SuppressWarnings("java:S3776")
	public Function create(String aInternalObject) {
		Function function = null;
		if ("urn:hl7-org:v3:function:CV-equal".equalsIgnoreCase(aInternalObject)) {
			function = new CvEqualFunction();
		} else if ("urn:hl7-org:v3:function:II-equal".equalsIgnoreCase(aInternalObject)) {
			function = new IiEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:string-equal"
				.equalsIgnoreCase(aInternalObject)) {
			function = new StringEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:anyURI-equal"
				.equalsIgnoreCase(aInternalObject)) {
			function = new AnyURIEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:2.0:function:anyURI-regexp-match".equalsIgnoreCase(aInternalObject)) {
			function = new AnyURIRegexpMatchFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:all-of-all".equalsIgnoreCase(aInternalObject)) {
			function = new AllOfAllFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:all-of-any".equalsIgnoreCase(aInternalObject)) {
			function = new AllOfAnyFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:all-of".equalsIgnoreCase(aInternalObject)) {
			function = new AllOfFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:any-of-all".equalsIgnoreCase(aInternalObject)) {
			function = new AnyOfAllFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:any-of-any".equalsIgnoreCase(aInternalObject)) {
			function = new AnyOfAnyFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:any-of".equalsIgnoreCase(aInternalObject)) {
			function = new AnyOfFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:boolean-equal".equalsIgnoreCase(aInternalObject)) {
			function = new BooleanEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:base64Binary-equal".equalsIgnoreCase(aInternalObject)) {
			function = new Base64BinaryEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:double-equal".equalsIgnoreCase(aInternalObject)) {
			function = new DoubleEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:integer-equal".equalsIgnoreCase(aInternalObject)) {
			function = new IntegerEqualFunction();
		} else if ("urn:ihe:2017:record:function:interactedPreviously".equalsIgnoreCase(aInternalObject)) {
			function = new FunctionInteractedPreviously();
		} else if (aInternalObject.contains("date")) {
			function = getDateFunction(aInternalObject);
		}

		return function;
	}
    
	/* simple function for comparing namespaces and get a Date function based on namespace, reducing complexity not necessary */
	@SuppressWarnings("java:S3776")
	private Function getDateFunction(String aInternalObject) {
		if ("urn:oasis:names:tc:xacml:1.0:function:date-equal".equalsIgnoreCase(aInternalObject)) {
			return new DateEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-greater-than".equalsIgnoreCase(aInternalObject)) {
			return new DateGreaterThanFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-at-least-one-member-of"
				.equalsIgnoreCase(aInternalObject)) {
			return new DateAtLeastOneMemberOfFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-bag".equalsIgnoreCase(aInternalObject)) {
			return new DateBagFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-bag-size".equalsIgnoreCase(aInternalObject)) {
			return new DateBagSizeFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-greater-than-or-equal"
				.equalsIgnoreCase(aInternalObject)) {
			return new DateGreaterThanOrEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-intersection".equalsIgnoreCase(aInternalObject)) {
			return new DateIntersectionFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-is-in".equalsIgnoreCase(aInternalObject)) {
			return new DateIsInFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-less-than".equalsIgnoreCase(aInternalObject)) {
			return new DateLessThanFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-less-than-or-equal".equalsIgnoreCase(aInternalObject)) {
			return new DateLessThanOrEqualFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-one-and-only".equalsIgnoreCase(aInternalObject)) {
			return new DateOneAndOnlyFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-set-equals".equalsIgnoreCase(aInternalObject)) {
			return new DateSetEqualsFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-subset".equalsIgnoreCase(aInternalObject)) {
			return new DateSubsetFunction();
		} else if ("urn:oasis:names:tc:xacml:1.0:function:date-union".equalsIgnoreCase(aInternalObject)) {
			return new DateUnionFunction();
		} else if ("urn:oasis:names:tc:xacml:3.0:function:date-add-yearMonthDuration"
				.equalsIgnoreCase(aInternalObject)) {
			return new DateAddYearMonthDurationFunction();
		} else if ("urn:oasis:names:tc:xacml:3.0:function:date-subtract-yearMonthDuration"
				.equalsIgnoreCase(aInternalObject)) {
			return new DateSubtractYearMonthDurationFunction();
		}

		return null;
	}

	@Override
	public Function create() {
		return new AnyURIEqualFunction();
	}

}
