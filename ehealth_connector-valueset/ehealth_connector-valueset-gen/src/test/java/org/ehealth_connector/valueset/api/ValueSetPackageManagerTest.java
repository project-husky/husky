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
package org.ehealth_connector.valueset.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.ehealth_connector.common.basetypes.IdentificatorBaseType;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.FileUtil;
import org.ehealth_connector.common.utils.Util;
import org.ehealth_connector.valueset.config.ValueSetPackageConfig;
import org.ehealth_connector.valueset.enums.ValueSetPackageStatus;
import org.ehealth_connector.valueset.model.Version;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

/**
 * The Test Class for ValueSetPackageManager.
 */
public class ValueSetPackageManagerTest {

	public static HashMap<String, String> getHasMap(Object obj)
			throws InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		HashMap<String, String> myObjectAsDict = new HashMap<>();
		Field[] allFields = obj.getClass().getDeclaredFields();
		for (Field field : allFields) {
			java.lang.reflect.Method method;
			String methodName = field.getName();
			if (methodName.contains("List")) {
				methodName = methodName.substring(0, 1).toUpperCase()
						+ field.getName().substring(1, methodName.length());
				methodName = methodName.replace("List", "");
				methodName = "list" + methodName;
			} else if (field.getType() == boolean.class)
				methodName = "is" + methodName.substring(0, 1).toUpperCase()
						+ field.getName().substring(1, methodName.length());
			else if (field.getType() == Boolean.class)
				methodName = null;
			else
				methodName = "get" + methodName.substring(0, 1).toUpperCase()
						+ field.getName().substring(1, methodName.length());

			if (methodName == null) {
				// myObjectAsDict.put(field.getName(), field.toString());
			} else {
				method = obj.getClass().getMethod(methodName);
				Object value = method.invoke(obj);
				if (value == null)
					myObjectAsDict.put(field.getName(), null);
				else {
					if (value.getClass() != String.class)
						if ((value.getClass() == Boolean.class) || (value.getClass() == Date.class)
								|| (value.getClass() == URL.class) || (value.getClass().isEnum()))
							myObjectAsDict.put(field.getName(), value.toString());
						else if (value.getClass() == ArrayList.class)
							myObjectAsDict.put(field.getName(), value.toString());
						else
							myObjectAsDict.put(field.getName(), getHasMap(value).toString());
					else
						myObjectAsDict.put(field.getName(), (String) value);
				}
			}
		}
		return myObjectAsDict;
	}

	public static HashMap<String, String> load(File saveLocation) {
		Yaml yaml = new Yaml();
		HashMap<String, String> yourMap = null;
		try {
			yourMap = yaml.load(new FileReader(saveLocation));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return yourMap;
	}

	public static void save(HashMap<String, String> yourMap, File saveLocation) {
		Yaml yaml = new Yaml();
		try {
			yaml.dump(yourMap, new FileWriter(saveLocation));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String testValueSetPackageConfigFileName = Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "testValueSetPackageConfig.yaml";

	private String yamlSaveLoadTestFileName = Util.getTempDirectory()
			+ FileUtil.getPlatformSpecificPathSeparator() + "yamlSaveLoadTest.yaml";

	// @Test
	// public void saveLoadTest() {
	//
	// ValueSetPackageManager valueSetPackageManager = new
	// ValueSetPackageManager();
	// try {
	//
	// // Save a config
	// ValueSetPackageConfig valueSetPackageConfig1 =
	// createValueSetPackageConfig();
	// assertNotNull(valueSetPackageConfig1);
	// valueSetPackageManager.saveValueSetPackageConfig(valueSetPackageConfig1,
	// testValueSetPackageConfigFileName);
	//
	// // load the saved config
	// ValueSetPackageManager valueSetPackageManager2 = new
	// ValueSetPackageManager();
	// valueSetPackageManager2.loadValueSetPackageConfig(testValueSetPackageConfigFileName);
	//
	// assertEquals(valueSetPackageConfig1.getDescription(),
	// valueSetPackageManager2.getLatestValueSetPackageConfig().getDescription());
	// assertTrue(valueSetPackageConfig1.getIdentificator().equals(
	// valueSetPackageManager2.getLatestValueSetPackageConfig().getIdentificator()));
	// assertTrue(valueSetPackageConfig1.getSourceUrl().equals(
	// valueSetPackageManager2.getLatestValueSetPackageConfig().getSourceUrl()));
	// assertEquals(valueSetPackageConfig1.getSourceUrlString(),
	// valueSetPackageManager2.getLatestValueSetPackageConfig().getSourceUrlString());
	// assertEquals(valueSetPackageConfig1.getStatus(),
	// valueSetPackageManager2.getLatestValueSetPackageConfig().getStatus());
	// assertTrue(valueSetPackageConfig1.getVersion()
	// .equals(valueSetPackageManager2.getLatestValueSetPackageConfig()));
	//
	// } catch (IOException e) {
	// fail("saveLoadTest: IOException");
	// }
	//
	// // TODO delete file in order to clean up the building system
	// }

	private ValueSetPackageConfig createValueSetPackageConfig() {
		ValueSetPackageConfig retVal = null;
		String sourceUrl;
		sourceUrl = "file://" + testValueSetPackageConfigFileName;
		Date validFrom = DateUtil.date("11.06.2019 00:00:00");

		Version version = Version.builder().withLabel("0.9").withValidFrom(validFrom).build();
		IdentificatorBaseType identificator = IdentificatorBaseType.builder().withRoot("2.999")
				.build();
		retVal = ValueSetPackageConfig.builder()
				.withDescription("This is a test package configuration")
				.withIdentificator(identificator).withSourceUrl(sourceUrl)
				.withStatus(ValueSetPackageStatus.ACTIVE).withVersion(version).build();
		return retVal;
	}

	private void initFromMap(Object obj, HashMap<String, String> testMap)
			throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, MalformedURLException,
			InstantiationException {
		Field[] allFields = obj.getClass().getDeclaredFields();
		for (Field field : allFields) {

			java.lang.reflect.Method method;

			String methodName = field.getName();
			if (methodName.contains("List")) {
				methodName = methodName.substring(0, 1).toUpperCase()
						+ field.getName().substring(1, methodName.length());
				methodName = methodName.replace("List", "");
				methodName = "add" + methodName;
			} else {

				methodName = "set" + methodName.substring(0, 1).toUpperCase()
						+ field.getName().substring(1, methodName.length());
			}

			if (field.getType() == boolean.class) {
				method = obj.getClass().getMethod(methodName, field.getType());
				method.invoke(obj, Boolean.getBoolean(testMap.get(field.getName())));
			} else {
				if (field.getType() != String.class) {
					if (field.getType() == Boolean.class) {
						method = obj.getClass().getMethod(methodName, field.getType());
						method.invoke(obj, Boolean.getBoolean(testMap.get(field.getName())));

					} else if (field.getType() == Date.class) {
						String fieldValue = testMap.get(field.getName());
						if (fieldValue != null) {
							method = obj.getClass().getMethod(methodName, field.getType());
							method.invoke(obj, DateUtil.date(fieldValue));
						}
					} else if (field.getType() == URL.class) {
						method = obj.getClass().getMethod(methodName, field.getType());
						method.invoke(obj, new URL(testMap.get(field.getName())));

					} else if (field.getType().isEnum()) {
						java.lang.reflect.Method valueOfMethod = field.getType()
								.getMethod("valueOf", String.class);
						Object enumValue = valueOfMethod.invoke(field.getType(),
								testMap.get(field.getName()));
						method = obj.getClass().getMethod(methodName, field.getType());
						method.invoke(obj, enumValue);

					} else if (field.getType() == ArrayList.class) {
						// TODO init object
						System.out.println("TODO: Implement " + field.getType().toString()
								+ " from '" + testMap.get(field.getName()) + "'");
					} else {
						String nestedMapString = testMap.get(field.getName());
						if (nestedMapString != null) {
							Yaml yaml = new Yaml();
							HashMap<String, String> nestedMap = yaml.load(nestedMapString);
							Object nestedObj = field.getType().newInstance();
							initFromMap(nestedObj, nestedMap);
							method = obj.getClass().getMethod(methodName, field.getType());
							method.invoke(obj, nestedObj);
						}
					}
				} else {
					method = obj.getClass().getMethod(methodName, String.class);
					method.invoke(obj, testMap.get(field.getName()));
				}
			}
		}
	}

	@Test
	public void yamlSaveLoadTest() throws IOException {
		try {
			save(getHasMap(createValueSetPackageConfig()),
					new File(testValueSetPackageConfigFileName));
		} catch (InstantiationException | IllegalAccessException | NoSuchMethodException
				| SecurityException | IllegalArgumentException | InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HashMap<String, String> testMap = load(new File(testValueSetPackageConfigFileName));
		ValueSetPackageConfig obj = new ValueSetPackageConfig();
		try {
			initFromMap(obj, testMap);
			System.out.println("***yamlSaveLoadTest***");
			Yaml yaml = new Yaml();
			System.out.println(yaml.dump(obj));
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void yamlSaveLoadTest4() throws IOException {
		Yaml yaml = new Yaml();
		FileUtils.writeByteArrayToFile(new File(testValueSetPackageConfigFileName),
				yaml.dump(createValueSetPackageConfig()).getBytes(Charsets.UTF_8));

		InputStreamReader reader = new InputStreamReader(
				new FileInputStream(testValueSetPackageConfigFileName), Charsets.UTF_8);
		ValueSetPackageConfig test = yaml.loadAs(reader, ValueSetPackageConfig.class);
	}
}
