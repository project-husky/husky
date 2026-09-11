package org.projecthusky.fhir.core.ch.util;

import java.util.UUID;

import org.hl7.fhir.r4.model.Resource;

public class IdUtil {

	public static String generateUrnUuid() {
		return "urn:uuid:" + UUID.randomUUID().toString();
	}

	public static void checkId(Resource resource) {
		if (resource.getId() == null || resource.getId().isEmpty()) {
			resource.setId(generateUrnUuid());
		} else if (!resource.getId().startsWith("http")
				&& !resource.getId().startsWith("urn:uuid:")) {
			resource.setId("urn:uuid:" + resource.getIdElement().getIdPart());
		}

	}

}
