/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.requests.hpd;

import java.util.List;
import java.util.Objects;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AttributeDescription;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.AttributeDescriptions;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DsmlMessage;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.Filter;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.FilterSet;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest.DerefAliasesType;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest.SearchScope;
import org.projecthusky.communication.requests.hpd.data.HpdAttributePresentParameters;
import org.projecthusky.communication.requests.hpd.data.HpdExtensibleMatchParameters;
import org.projecthusky.communication.requests.hpd.data.HpdFilterOperation;
import org.projecthusky.communication.requests.hpd.data.HpdOperationParameters;
import org.projecthusky.communication.requests.hpd.data.HpdSimpleParameters;
import org.projecthusky.communication.requests.hpd.data.HpdSubstringParameters;
import org.projecthusky.communication.enums.HpdAttributeName;

/** Class used for creating the HPD library SearchRequest class */
@Getter
@Slf4j
public class HpdSearchQuery extends HpdRequest {
  private static final String NAMESPACE_URI = "urn:oasis:names:tc:DSML:2:0:core";
  private static final String NOT = "not";

  /** isAndRequest and isOrRequest cannot be simultaneously true. Only one operation at a time is supported */
  private final boolean isAndRequest;
  private final boolean isOrRequest;
  private final boolean isNegated;
  @Singular
  private final List<HpdFilterOperation> primitiveFilters;
  /** If list is empty all the existing attribute names will be returned */
  @Singular
  private final List<String> resultAttributeNames;
  private final SearchScope scope;
  private final DerefAliasesType derefAliases;
  private final Long sizeLimit;
  private final Long timeLimit;
  private final Boolean typesOnly;

  @Builder
  public HpdSearchQuery(String distinguishedName, boolean isAndRequest, boolean isOrRequest, boolean isNegated,
      List<HpdFilterOperation> primitiveFilters, List<String> resultAttributeNames, SearchScope scope,
      DerefAliasesType derefAliases, Long sizeLimit, Long timeLimit, Boolean typesOnly) {
    super(distinguishedName);
    this.isAndRequest = isAndRequest;
    this.isOrRequest = isOrRequest;
    this.isNegated = isNegated;
    this.primitiveFilters = primitiveFilters;
    this.resultAttributeNames = resultAttributeNames;
    this.scope = scope;
    this.derefAliases = derefAliases;
    this.sizeLimit = sizeLimit;
    this.timeLimit = timeLimit;
    this.typesOnly = typesOnly;
  }

  public void addResultAttributeName(String name) {
    if (Objects.nonNull(name)) {
      resultAttributeNames.add(name);
    }
  }

  public void addResultAttributeName(HpdAttributeName attributeName) {
    if (Objects.nonNull(attributeName)) {
      resultAttributeNames.add(attributeName.getName());
    }
  }

  @Override
  public DsmlMessage build() {
    SearchRequest request = new SearchRequest();
    request.setFilter(mapFilter());
    request.setAttributes(createAttributeDescriptions(resultAttributeNames));
    request.setDn(getDistinguishedName());
    request.setScope(scope);
    request.setDerefAliases(derefAliases);
    request.setSizeLimit(sizeLimit);
    request.setTimeLimit(timeLimit);
    request.setTypesOnly(typesOnly);

    return request;
  }

  private Filter mapFilter() {
    Filter filter = new Filter();
    FilterSet filterSet = createFilterSet(primitiveFilters);

    if (isAndRequest()) {
      handleAndRequest(filter, filterSet);
    } else if (isOrRequest()) {
      handleOrRequest(filter, filterSet);
    } else {
      handleSimpleRequest(filter);
    }

    if (isNegated()) {
      Filter notFilter = new Filter();
      notFilter.setNot(filter);

      return notFilter;
    }

    return filter;
  }

  private void handleAndRequest(Filter filter, FilterSet filterSet) {
    if (isOrRequest()) {
      log.warn("Request cannot be simultaneously true for andRequest and orRequest operations");
    }
    filter.setAnd(filterSet);
  }

  private void handleOrRequest(Filter filter, FilterSet filterSet) {
    filter.setOr(filterSet);
  }

  private void handleSimpleRequest(Filter filter) {
    HpdFilterOperation filterOperation = primitiveFilters.get(0);
    HpdOperationParameters operation = filterOperation.getOperation();
    switch (filterOperation.getOperationType()) {
      case APPROX_MATCH:
        filter.setApproxMatch(((HpdSimpleParameters) operation).create());
        break;
      case EQUALITY_MATCH:
        filter.setEqualityMatch(((HpdSimpleParameters) operation).create());
        break;
      case GREATER_OR_EQUAL:
        filter.setGreaterOrEqual(((HpdSimpleParameters) operation).create());
        break;
      case LESS_OR_EQUAL:
        filter.setLessOrEqual(((HpdSimpleParameters) operation).create());
        break;
      case EXTENSIBLE_MATCH:
        filter.setExtensibleMatch(((HpdExtensibleMatchParameters) operation).create());
        break;
      case PRESENT:
        filter.setPresent(((HpdAttributePresentParameters) operation).create());
        break;
      case SUBSTRINGS:
        filter.setSubstrings(((HpdSubstringParameters) operation).create());
        break;
    }
  }

  // Added SuppressWarnings annotation to unify all filter operations with the same code
  @SuppressWarnings({"unchecked", "rawtypes"})
  private FilterSet createFilterSet(List<HpdFilterOperation> primitiveFilters) {
    FilterSet filterSet = new FilterSet();

    if (!primitiveFilters.isEmpty()) {
      for (HpdFilterOperation filterOperation : primitiveFilters) {
        Object filterRule = filterOperation.getOperation().create();
        JAXBElement<?> value = new JAXBElement(new QName(NAMESPACE_URI, filterOperation.getOperationType().getValue()),
            filterRule.getClass(), filterRule);

        if (filterOperation.isNegated()) {
          value = new JAXBElement(new QName(NAMESPACE_URI, NOT), value.getClass(), value);
        }
        filterSet.getFilterGroup().add(value);
      }
    }

    return filterSet;
  }

  private AttributeDescriptions createAttributeDescriptions(List<String> attributeNames) {
    AttributeDescriptions attributeDescriptions = new AttributeDescriptions();
    if (Objects.nonNull(attributeNames) && !attributeNames.isEmpty()) {
      attributeNames.forEach(attributeName -> {
        AttributeDescription description = new AttributeDescription();
        description.setName(attributeName);
        attributeDescriptions.getAttribute().add(description);
      });
    }

    return attributeDescriptions;
  }

  @Override
  public boolean isValid() {
    boolean isValid = super.isValid();

    if (Objects.isNull(scope)) {
      log.error("Scope must not be null!");
      isValid = false;
    }

    if (Objects.isNull(derefAliases)) {
      log.error("DerefAliases must not be null!");
      isValid = false;
    }

    if (Objects.isNull(primitiveFilters) || primitiveFilters.isEmpty()) {
      log.error("PrimitiveFilters must not be empty!");
      isValid = false;
    }

    return isValid;
  }
}