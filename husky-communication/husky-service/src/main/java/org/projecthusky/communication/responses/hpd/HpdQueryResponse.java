/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.responses.hpd;

import static org.projecthusky.communication.utils.HpdUtils.getValidResponse;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.BatchResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.DsmlAttr;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchResponse;
import org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchResultEntry;

/** Class responsible for creating response from {@link org.openehealth.ipf.commons.ihe.hpd.stub.dsmlv2.SearchRequest} */
public class HpdQueryResponse extends HpdResponse {
  @Override
  public HpdQueryResponse build(BatchResponse response) {
    SearchResponse searchResponse = getValidResponse(response, SearchResponse.class);
    if (Objects.nonNull(searchResponse)) {
      HpdQueryResponse hpdQueryResponse = new HpdQueryResponse();
      hpdQueryResponse.setRequestId(response.getRequestID());

      Map<String, List<String>> attributes = searchResponse.getSearchResultEntry().stream()
          .map(SearchResultEntry::getAttr)
          .flatMap(Collection::stream)
          .collect(Collectors.groupingBy(DsmlAttr::getName,
              Collectors.flatMapping(attr -> attr.getValue().stream().map(Object::toString), Collectors.toList())));

      hpdQueryResponse.setAttributes(attributes);
      return hpdQueryResponse;
    }
    throw new IllegalArgumentException("HpdQueryResponse mapping failed!");
  }
}
