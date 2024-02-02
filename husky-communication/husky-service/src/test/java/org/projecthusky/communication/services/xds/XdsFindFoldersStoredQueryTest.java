package org.projecthusky.communication.services.xds;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URI;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.AvailabilityStatus;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.FindFoldersQuery;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.requests.xds.XdsFindFoldersStoredQuery;
import org.projecthusky.communication.services.HuskyService;
import org.projecthusky.communication.utils.XdsTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class,
    IpfApplicationConfig.class})
public class XdsFindFoldersStoredQueryTest extends XdsTestUtils {
  @Value(value = "${test.xds.xcq.uri:http://ehealthsuisse.ihe-europe.net:8280/xdstools7/sim/epr-testing__for_init_gw_testing/rep/xcq}")
  private String webserviceUri;

  @Autowired
  private HuskyService service;

  @Test
  void testFindFoldersStoredQuery() {
    Destination dest = new Destination();
    dest.setUri(URI.create(webserviceUri));
    dest.setSenderApplicationOid("1.2.3.4");

    XdsFindFoldersStoredQuery query = this.service.createFindFoldersStoredQuery().destination(dest).patientID(patientId)
        .availabilityStatus(List.of(AvailabilityStatus.SUBMITTED)).build();

    assertTrue(query.getIpfQuery() instanceof FindFoldersQuery);

    FindFoldersQuery sqpl = (FindFoldersQuery) query.getIpfQuery();

    assertEquals(patientId.getRoot(), sqpl.getPatientId().getAssigningAuthority().getUniversalId());
    assertEquals(patientId.getExtension(), sqpl.getPatientId().getId());

    assertEquals(availabilityStatus.getQueryOpcode(), sqpl.getStatus().get(0).getQueryOpcode());
  }
}
