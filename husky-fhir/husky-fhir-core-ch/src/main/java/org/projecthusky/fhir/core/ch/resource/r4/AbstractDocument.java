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
package org.projecthusky.fhir.core.ch.resource.r4;

import java.util.List;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.Bundle;

/**	
 * 
 * @author <a href="roeland.luykx@raly.ch">Roeland Luykx</a>
 */
public abstract class AbstractDocument extends Bundle {

	@Nullable
	public <T> T getEntryByResourceType(final Class<T> resourceType) {
		return this.getEntry().stream()
				.filter(entry -> resourceType.isInstance(entry.getResource()))
				.map(BundleEntryComponent::getResource).map(resourceType::cast).findAny()
				.orElse(null);
	}

	/**
	 * Gets the resources in the package entries by the specified resource type.
	 *
	 * @param resourceType
	 *            The type of the resource.
	 * @return the list with the resource.
	 */
	public <T> List<T> getEntryResourceByResourceType(final Class<T> resourceType) {
		return this.getEntry().stream().map(BundleEntryComponent::getResource)
				.filter(resourceType::isInstance).map(resourceType::cast).toList();
	}
}
