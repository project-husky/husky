/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AddRequest;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DsmlAttr;
import org.projecthusky.communication.enums.HpdAttributeName;

@Slf4j
public class HpdUtils {

  public static void addHpdAttribute(AddRequest addRequest, HpdAttributeName attributeName, String value) {
    addRequest.getAttr().add(createDsmlAttr(attributeName, value));
  }

  public static void addHpdAttributes(AddRequest addRequest, HpdAttributeName attributeName, List<String> values) {
    addRequest.getAttr().add(createDsmlAttr(attributeName, values));
  }

  public static void addHpdAttributes(AddRequest addRequest, String attributeName, List<String> values) {
    addRequest.getAttr().add(createDsmlAttr(attributeName, values));
  }

  public static void setOptionalAttributes(AddRequest addRequest, Map<HpdAttributeName, List<String>> optionalAttributes) {
    if (Objects.nonNull(optionalAttributes) && !optionalAttributes.isEmpty()) {
      optionalAttributes.forEach((key, value) -> addHpdAttributes(addRequest, key, value));
    }
  }

  private static DsmlAttr createDsmlAttr(HpdAttributeName attributeName, String value) {
    DsmlAttr attr = new DsmlAttr();
    attr.setName(attributeName.getName());
    attr.getValue().add(value);
    return attr;
  }

  private static DsmlAttr createDsmlAttr(HpdAttributeName attributeName, List<String> values) {
    return createDsmlAttr(attributeName.getName(), values);
  }

  private static DsmlAttr createDsmlAttr(String attributeName, List<String> values) {
    DsmlAttr attr = new DsmlAttr();
    attr.setName(attributeName);
    values.forEach(value -> attr.getValue().add(value));

    return attr;
  }

  public static boolean hasNullOrBlank(Object... objects) {
    return Stream.of(objects).anyMatch(obj -> obj == null || (obj instanceof String && ((String) obj).trim().isEmpty()));
  }

  public static <T> T getValidResponse(BatchResponse response, Class<T> clazz) {
    if (Objects.nonNull(response)
        && Objects.nonNull(response.getBatchResponses())
        && !response.getBatchResponses().isEmpty()
        && Objects.nonNull(response.getBatchResponses().get(0))
        && clazz.isInstance(response.getBatchResponses().get(0).getValue())) {
      return clazz.cast(response.getBatchResponses().get(0).getValue());
    }
    return null;
  }
}