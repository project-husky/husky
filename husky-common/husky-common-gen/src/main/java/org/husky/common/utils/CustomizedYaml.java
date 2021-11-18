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
package org.husky.common.utils;

import java.util.Calendar;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

/**
 * The Class CustomizedYaml is just used internally in order to simplify and
 * harmonize YAML dumps and loads.
 */
public class CustomizedYaml extends Yaml {

	/**
	 * Gets the customized yaml.
	 *
	 * @return the customized yaml
	 */
	public static Yaml getCustomizedYaml() {

		DumperOptions options = new DumperOptions();
		options.setTimeZone(Calendar.getInstance().getTimeZone());

		Representer representer = new Representer() {
			@Override
			protected NodeTuple representJavaBeanProperty(Object javaBean, Property property,
					Object propertyValue, Tag customTag) {
				// if value of property is null, ignore it.
				if (propertyValue == null) {
					return null;
				} else {
					return super.representJavaBeanProperty(javaBean, property, propertyValue,
							customTag);
				}
			}
		};

		return new Yaml(representer, options);

	}
}
