/*
 * 
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

package org.ehealth_connector.validation.service.schematron;

/*
 * The original RuleSet implementation is a concrete class which depends on
 * the RuleSetType class coming from the XML configuration.
 */
import java.io.File;

public interface RuleSet {

	String getDescription();

	String getDisplayName();

	String getId();

	File getPath();

	String getTemplateId();

	boolean isCacheable();

	boolean isPersistable();

	void setPath(File path);

}
