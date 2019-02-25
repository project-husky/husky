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
package org.ehealth_connector.valueset.config;

import org.ehealth_connector.valueset.enums.SourceFormatTypeEnum;
import org.ehealth_connector.valueset.enums.SourceSystemTypeEnum;

/**
 * Java Prototype for Value Set Management Concept.
 */
public interface ValueSetConfig {
	public String getClassName();

	public String getProjectFolder();

	public SourceFormatTypeEnum getSourceFormatType();

	public SourceSystemTypeEnum getSourceSystemType();

	public String getSourceUrl();

	public void setClassName(String value);

	public void setProjectFolder(String value);

	public void setSourceFormatType(SourceFormatTypeEnum value);

	public void setSourceSystemType(SourceSystemTypeEnum value);

	public void setSourceUrl(String value);

}
