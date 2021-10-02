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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.ehealth_connector.xua.core.SecurityObjectBuilder;
import org.ehealth_connector.xua.saml2.SimpleBuilder;
import org.herasaf.xacml.core.function.Function;
import org.herasaf.xacml.core.policy.impl.ActionAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ApplyType;
import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.herasaf.xacml.core.policy.impl.ConditionType;
import org.herasaf.xacml.core.policy.impl.EnvironmentAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ResourceAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.SubjectAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.VariableReferenceType;
import org.opensaml.xacml.policy.impl.ApplyTypeImpl;
import org.opensaml.xacml.policy.impl.AttributeDesignatorTypeImpl;
import org.opensaml.xacml.policy.impl.AttributeSelectorTypeImpl;
import org.opensaml.xacml.policy.impl.AttributeValueTypeImpl;
import org.opensaml.xacml.policy.impl.FunctionTypeImpl;
import org.opensaml.xacml.policy.impl.SubjectAttributeDesignatorTypeImpl;
import org.opensaml.xacml.policy.impl.VariableReferenceTypeImpl;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for Condition building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um Conditions bilden zu k&ooml;nnen.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class ConditionXacmlBuilderImpl implements SimpleBuilder<ConditionType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.ConditionType, ConditionType> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.ehealth_connector.xua.core.SecurityObjectBuilder#create(java.lang.Object)
	 */
	@Override
	public ConditionType create(org.opensaml.xacml.policy.ConditionType aInternalObject) {
		var condition = new ConditionType();

		if (aInternalObject.getExpression() != null) {
			condition.setExpression(getJaxbElementForExpression(aInternalObject.getExpression()));
		}

		return condition;
	}

	private JAXBElement<?> getJaxbElementForExpression(org.opensaml.xacml.policy.ExpressionType expType) {
		if (expType instanceof SubjectAttributeDesignatorTypeImpl) {
			SubjectAttributeDesignatorTypeImpl internalObj = (SubjectAttributeDesignatorTypeImpl) expType;
			var subjectAttrDesign = new SubjectAttributeDesignatorType();
			subjectAttrDesign.setAttributeId(internalObj.getAttributeId());
			subjectAttrDesign.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			subjectAttrDesign.setIssuer(internalObj.getIssuer());
			subjectAttrDesign.setMustBePresent(internalObj.getMustBePresent());
			subjectAttrDesign.setSubjectCategory(internalObj.getSubjectCategory());
			return new JAXBElement<>(expType.getElementQName(), SubjectAttributeDesignatorType.class,
					subjectAttrDesign);
		} else if (expType instanceof AttributeSelectorTypeImpl) {
			AttributeSelectorTypeImpl internalObj = (AttributeSelectorTypeImpl) expType;
			var attrSelect = new AttributeSelectorType();
			attrSelect.setDataType(internalObj.getDataType());
			attrSelect.setRequestContextPath(internalObj.getRequestContextPath());
			attrSelect.setMustBePresent(internalObj.getMustBePresent());
			return new JAXBElement<>(expType.getElementQName(), AttributeSelectorType.class, attrSelect);
		} else if (expType instanceof VariableReferenceTypeImpl) {
			VariableReferenceTypeImpl internalObj = (VariableReferenceTypeImpl) expType;
			var varRef = new VariableReferenceType();
			varRef.setVariableId(internalObj.getVariableId());
			return new JAXBElement<>(expType.getElementQName(), VariableReferenceType.class, varRef);
		} else if (expType instanceof AttributeValueTypeImpl) {
			AttributeValueTypeImpl internalObj = (AttributeValueTypeImpl) expType;
			var attrVal = new AttributeValueType();
			attrVal.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			return new JAXBElement<>(expType.getElementQName(), AttributeValueType.class, attrVal);
		} else if (expType instanceof FunctionTypeImpl) {
			FunctionTypeImpl internalObj = (FunctionTypeImpl) expType;
			return new JAXBElement<>(expType.getElementQName(), Function.class,
					new FunctionBuilderImpl().create(internalObj.getFunctionId()));
		} else if (expType instanceof ApplyTypeImpl) {
			var applyType = new ApplyType();
			ApplyTypeImpl aInternalApply = (ApplyTypeImpl) expType;

			applyType.setFunction(new FunctionBuilderImpl().create(aInternalApply.getFunctionId()));

			for (var exp : aInternalApply.getExpressions()) {
				if (exp != null) {
					applyType.getExpressions().add(getJaxbElementForExpression(exp));
				}
			}

			return new JAXBElement<>(expType.getElementQName(), ApplyType.class, applyType);
		} else if (expType instanceof AttributeDesignatorTypeImpl) {
			return getJaxbElementForExpression((AttributeDesignatorTypeImpl) expType, expType.getElementQName());
		}

		return null;

	}

	private JAXBElement<?> getJaxbElementForExpression(AttributeDesignatorTypeImpl internalObj, QName expQName) {
		if ("ActionAttributeDesignator".equalsIgnoreCase(internalObj.getElementQName().getLocalPart())) {
			var attrDesign = new ActionAttributeDesignatorType();
			attrDesign.setAttributeId(internalObj.getAttributeId());
			attrDesign.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			attrDesign.setIssuer(internalObj.getIssuer());
			attrDesign.setMustBePresent(internalObj.getMustBePresent());

			return new JAXBElement<>(expQName, ActionAttributeDesignatorType.class, attrDesign);
		} else if ("EnvironmentAttributeDesignator".equalsIgnoreCase(internalObj.getElementQName().getLocalPart())) {
			var envAttr = new EnvironmentAttributeDesignatorType();
			envAttr.setAttributeId(internalObj.getAttributeId());
			envAttr.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			envAttr.setIssuer(internalObj.getIssuer());
			envAttr.setMustBePresent(internalObj.getMustBePresent());
			return new JAXBElement<>(expQName, EnvironmentAttributeDesignatorType.class, envAttr);
		} else if ("ResourceAttributeDesignator".equalsIgnoreCase(internalObj.getElementQName().getLocalPart())) {
			var resAttr = new ResourceAttributeDesignatorType();
			resAttr.setAttributeId(internalObj.getAttributeId());
			resAttr.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			resAttr.setIssuer(internalObj.getIssuer());
			resAttr.setMustBePresent(internalObj.getMustBePresent());
			return new JAXBElement<>(expQName, ResourceAttributeDesignatorType.class, resAttr);
		} else if ("SubjectAttributeDesignator".equalsIgnoreCase(internalObj.getElementQName().getLocalPart())) {
			var envAttr = new SubjectAttributeDesignatorType();
			envAttr.setAttributeId(internalObj.getAttributeId());
			envAttr.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			envAttr.setIssuer(internalObj.getIssuer());
			envAttr.setMustBePresent(internalObj.getMustBePresent());
			return new JAXBElement<>(expQName, SubjectAttributeDesignatorType.class, envAttr);
		}

		return null;

	}

	@Override
	public ConditionType create() {
		return new ConditionType();
	}

}
