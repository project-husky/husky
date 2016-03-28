/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package ehealth_connector.validation.service.schematron;

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

}
