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

import java.util.List;

import org.herasaf.xacml.core.policy.impl.ActionType;
import org.herasaf.xacml.core.policy.impl.ActionsType;
import org.herasaf.xacml.core.policy.impl.ResourceType;
import org.herasaf.xacml.core.policy.impl.ResourcesType;
import org.herasaf.xacml.core.policy.impl.SubjectType;
import org.herasaf.xacml.core.policy.impl.SubjectsType;
import org.herasaf.xacml.core.policy.impl.TargetType;
import org.projecthusky.xua.core.SecurityObjectBuilder;
import org.projecthusky.xua.saml2.SimpleBuilder;
import org.opensaml.xacml.policy.impl.ActionTypeImplBuilder;
import org.opensaml.xacml.policy.impl.ActionsTypeImplBuilder;
import org.opensaml.xacml.policy.impl.ResourceTypeImplBuilder;
import org.opensaml.xacml.policy.impl.ResourcesTypeImplBuilder;
import org.opensaml.xacml.policy.impl.SubjectTypeImplBuilder;
import org.opensaml.xacml.policy.impl.SubjectsTypeImplBuilder;
import org.opensaml.xacml.policy.impl.TargetTypeImplBuilder;

/**
 * <!-- @formatter:off -->
 * <div class="en">Class implementing the corresponding interface for PolicyType building.</div>
 * <div class="de">Die Klasse implementiert das entsprechende Interface um PolicyType bilden zu können.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public class TargetBuilderImpl
		implements SimpleBuilder<TargetType>, SecurityObjectBuilder<org.opensaml.xacml.policy.TargetType, TargetType> {

	@Override
	public TargetType create(org.opensaml.xacml.policy.TargetType aInternalObject) {
			var targetType = new TargetType();

			if (aInternalObject.getActions() != null && aInternalObject.getActions().getActions() != null) {
				targetType.setActions(createActionsType(aInternalObject.getActions().getActions()));
			}

			if (aInternalObject.getSubjects() != null && aInternalObject.getSubjects().getSubjects() != null) {
				targetType.setSubjects(createSubjectsType(aInternalObject.getSubjects().getSubjects()));
			}

			if (aInternalObject.getResources() != null && aInternalObject.getResources().getResources() != null) {
				targetType.setResources(createResourcesType(aInternalObject.getResources().getResources()));
			}

			return targetType;
	}

	private ActionsType createActionsType(List<org.opensaml.xacml.policy.ActionType> internalObjects) {
		var actionsType = new ActionsType();
		for (var type : internalObjects) {
			var actionType = new ActionType();

			for (var typeMatch : type.getActionMatches()) {
				actionType.getActionMatches().add(new ActionMatchBuilderImpl().create(typeMatch));
			}

			actionsType.getActions().add(actionType);
		}

		return actionsType;
	}

	private ResourcesType createResourcesType(List<org.opensaml.xacml.policy.ResourceType> internalObjects) {
		var resourcesType = new ResourcesType();

		for (var type : internalObjects) {
			var resourceType = new ResourceType();

			for (var typeMatch : type.getResourceMatches()) {
				resourceType.getResourceMatches().add(new ResourceMatchBuilderImpl().create(typeMatch));
			}

			resourcesType.getResources().add(resourceType);
		}
		return resourcesType;
	}

	private SubjectsType createSubjectsType(List<org.opensaml.xacml.policy.SubjectType> internalObjects) {
		var subjectsType = new SubjectsType();

		for (var type : internalObjects) {
			var subjectType = new org.herasaf.xacml.core.policy.impl.SubjectType();

			for (var typeMatch : type.getSubjectMatches()) {
				subjectType.getSubjectMatches().add(new SubjectMatchBuilderImpl().create(typeMatch));
			}

			subjectsType.getSubjects().add(subjectType);
		}
		return subjectsType;
	}

	@Override
	public TargetType create() {
		return new TargetType();
	}

	public org.opensaml.xacml.policy.TargetType create(TargetType aInternalObject) {
		var targetType = new TargetTypeImplBuilder().buildObject();

		if (aInternalObject.getActions() != null && aInternalObject.getActions().getActions() != null) {
			targetType.setActions(createOpensamlActionsType(aInternalObject.getActions().getActions()));
		}

		if (aInternalObject.getSubjects() != null && aInternalObject.getSubjects().getSubjects() != null) {
			targetType.setSubjects(createOpensamlSubjectsType(aInternalObject.getSubjects().getSubjects()));
		}

		if (aInternalObject.getResources() != null && aInternalObject.getResources().getResources() != null) {
			targetType.setResources(createOpensamlResourcesType(aInternalObject.getResources().getResources()));
		}

		return targetType;
	}

	private org.opensaml.xacml.policy.ActionsType createOpensamlActionsType(List<ActionType> internalObjects) {
		var actionsType = new ActionsTypeImplBuilder().buildObject();
		for (var type : internalObjects) {
			var actionType = new ActionTypeImplBuilder().buildObject();

			for (var typeMatch : type.getActionMatches()) {
				actionType.getActionMatches().add(new ActionMatchBuilderImpl().create(typeMatch));
			}

			actionsType.getActions().add(actionType);
		}


		return actionsType;
	}

	private org.opensaml.xacml.policy.ResourcesType createOpensamlResourcesType(List<ResourceType> internalObjects) {
		var resourcesType = new ResourcesTypeImplBuilder().buildObject();

		for (var type : internalObjects) {
			var resourceType = new ResourceTypeImplBuilder().buildObject();

			for (var typeMatch : type.getResourceMatches()) {
				resourceType.getResourceMatches().add(new ResourceMatchBuilderImpl().create(typeMatch));
			}

			resourcesType.getResources().add(resourceType);
		}
		return resourcesType;
	}

	private org.opensaml.xacml.policy.SubjectsType createOpensamlSubjectsType(List<SubjectType> internalObjects) {
		var subjectsType = new SubjectsTypeImplBuilder().buildObject();

		for (var type : internalObjects) {
			var subjectType = new SubjectTypeImplBuilder().buildObject();

			for (var typeMatch : type.getSubjectMatches()) {
				subjectType.getSubjectMatches().add(new SubjectMatchBuilderImpl().create(typeMatch));
			}

			subjectsType.getSubjects().add(subjectType);
		}
		return subjectsType;
	}

}
