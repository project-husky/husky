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

import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.herasaf.xacml.core.function.Function;
import org.herasaf.xacml.core.policy.impl.ActionAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ApplyType;
import org.herasaf.xacml.core.policy.impl.AttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.AttributeSelectorType;
import org.herasaf.xacml.core.policy.impl.AttributeValueType;
import org.herasaf.xacml.core.policy.impl.ConditionType;
import org.herasaf.xacml.core.policy.impl.EnvironmentAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.ResourceAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.SubjectAttributeDesignatorType;
import org.herasaf.xacml.core.policy.impl.VariableReferenceType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.ApplyTypeImpl;
import org.opensaml.xacml.policy.impl.AttributeDesignatorTypeImpl;
import org.opensaml.xacml.policy.impl.AttributeDesignatorTypeImplBuilder;
import org.opensaml.xacml.policy.impl.AttributeSelectorTypeImpl;
import org.opensaml.xacml.policy.impl.AttributeValueTypeImpl;
import org.opensaml.xacml.policy.impl.ConditionTypeImplBuilder;
import org.opensaml.xacml.policy.impl.FunctionTypeImpl;
import org.opensaml.xacml.policy.impl.SubjectAttributeDesignatorTypeImpl;
import org.opensaml.xacml.policy.impl.VariableReferenceTypeImpl;

/**
 * Class implementing the corresponding interface for Condition building.
 */
public class ConditionXacmlBuilderImpl implements SimpleBuilder<ConditionType>,
		SecurityObjectBuilder<org.opensaml.xacml.policy.ConditionType, ConditionType> {

	/**
	 *
	 * {@inheritDoc}
	 *
	 * @see org.projecthusky.xua.core.SecurityObjectBuilder#create(java.lang.Object)
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
		if (expType instanceof SubjectAttributeDesignatorTypeImpl internalObj) {
			var subjectAttrDesign = new SubjectAttributeDesignatorType();
			subjectAttrDesign.setAttributeId(internalObj.getAttributeId());
			subjectAttrDesign.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			subjectAttrDesign.setIssuer(internalObj.getIssuer());
			subjectAttrDesign.setMustBePresent(internalObj.getMustBePresent());
			subjectAttrDesign.setSubjectCategory(internalObj.getSubjectCategory());
			return new JAXBElement<>(expType.getElementQName(), SubjectAttributeDesignatorType.class,
					subjectAttrDesign);
		} else if (expType instanceof AttributeSelectorTypeImpl internalObj) {
			var attrSelect = new AttributeSelectorType();
			attrSelect.setDataType(internalObj.getDataType());
			attrSelect.setRequestContextPath(internalObj.getRequestContextPath());
			attrSelect.setMustBePresent(internalObj.getMustBePresent());
			return new JAXBElement<>(expType.getElementQName(), AttributeSelectorType.class, attrSelect);
		} else if (expType instanceof VariableReferenceTypeImpl internalObj) {
			var varRef = new VariableReferenceType();
			varRef.setVariableId(internalObj.getVariableId());
			return new JAXBElement<>(expType.getElementQName(), VariableReferenceType.class, varRef);
		} else if (expType instanceof AttributeValueTypeImpl internalObj) {
			var attrVal = new AttributeValueType();
			attrVal.setDataType(new DataTypeAttributeBuilderImpl().create(internalObj.getDataType()));
			return new JAXBElement<>(expType.getElementQName(), AttributeValueType.class, attrVal);
		} else if (expType instanceof FunctionTypeImpl internalObj) {
			return new JAXBElement<>(expType.getElementQName(), Function.class,
					new FunctionBuilderImpl().create(internalObj.getFunctionId()));
		} else if (expType instanceof ApplyTypeImpl aInternalApply) {
			var applyType = new ApplyType();

			applyType.setFunction(new FunctionBuilderImpl().create(aInternalApply.getFunctionId()));

			for (var exp : aInternalApply.getExpressions()) {
				if (exp != null) {
					applyType.getExpressions().add(getJaxbElementForExpression(exp));
				}
			}

			return new JAXBElement<>(expType.getElementQName(), ApplyType.class, applyType);
		} else if (expType instanceof AttributeDesignatorTypeImpl internalObj) {
			return getJaxbElementForExpression(internalObj, expType.getElementQName());
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

	/**
	 * method to create the ConditionType.
	 * 
	 * @param aInternalObject to be set
	 * @return the created opensaml equivalent
	 */
	public org.opensaml.xacml.policy.ConditionType create(ConditionType aInternalObject) {
		var condition = new ConditionTypeImplBuilder().buildObject();

		if (aInternalObject.getExpression() != null) {
			var expression = new AttributeDesignatorTypeImplBuilder().buildObject();

			if (aInternalObject.getExpression().getValue() instanceof AttributeDesignatorType) {
				var attrDesign = (AttributeDesignatorType) aInternalObject.getExpression().getValue();
				expression.setAttributeId(attrDesign.getAttributeId());
				expression.setDataType(attrDesign.getDataType().getDatatypeURI());
				expression.setIssuer(attrDesign.getIssuer());
				expression.setMustBePresent(attrDesign.isMustBePresent());
			}

			condition.setExpression(expression);
		}

		return condition;
	}

	@Override
	public ConditionType create() {
		return new ConditionType();
	}

}
