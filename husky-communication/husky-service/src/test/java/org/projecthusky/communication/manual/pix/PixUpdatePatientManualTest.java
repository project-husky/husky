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
package org.projecthusky.communication.manual.pix;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.io.IOException;
import java.net.URI;
import java.text.SimpleDateFormat;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import net.ihe.gazelle.hl7v3.mcciin000002UV01.MCCIIN000002UV01Type;
import org.hl7.fhir.r4.model.HumanName;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Organization;
import org.junit.jupiter.api.Test;
import org.projecthusky.common.communication.Destination;
import org.projecthusky.communication.TestApplication;
import org.projecthusky.communication.config.IpfApplicationConfig;
import org.projecthusky.communication.requests.pix.PixUpdatePatientFeed;
import org.projecthusky.communication.responses.pix.PixAddPatientResponse;
import org.projecthusky.communication.services.HuskyWebServiceClient;
import org.projecthusky.fhir.structures.gen.FhirCommon;
import org.projecthusky.xua.exceptions.SerializeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE, classes = {TestApplication.class, IpfApplicationConfig.class})
public class PixUpdatePatientManualTest {

  @Autowired
  private HuskyWebServiceClient wsClient;

  @Value(value = "${test.pixq.uri:https://ehealthsuisse.ihe-europe.net/PAMSimulator-ejb/PIXManager_Service/PIXManager_PortType}")
  private String pixUri;

  final private String facilityName = null; // "2.16.840.1.113883.3.72.6.1";

  final private String receiverApplicationOid = "1.3.6.1.4.1.12559.11.20.1.10";
  final private String senderApplicationOid = "1.2.3.4";

  final private String homeCommunityOid = "1.3.6.1.4.1.12559.11.20.1";

  final private String spidEprOid = "2.16.756.5.30.1.127.3.10.3";

  private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");

  @Test
  public void whenUpdatedWithUpdateBuilder_andSentWithWSClient_thenUpdatesTheSameWay()
      throws JAXBException, SerializeException, ParserConfigurationException, IOException {
    Destination dest = new Destination();
    dest.setUri(URI.create(pixUri));
    dest.setSenderApplicationOid(senderApplicationOid);
    dest.setReceiverApplicationOid(receiverApplicationOid);

    Organization organization = new Organization().addIdentifier(
        new Identifier().setValue("Husky").setSystem(FhirCommon.addUrnOid(homeCommunityOid)));

    PixUpdatePatientFeed update = PixUpdatePatientFeed.builder().destination(dest)
        .identifier(new Identifier().setValue("1634793774730").setSystem(FhirCommon.addUrnOid(homeCommunityOid)))
        .identifier(new Identifier().setValue("SPID-101").setSystem(spidEprOid))
        .scopingOrganization(organization)
        .patientName(new HumanName().setFamily("Bauer-Maier").addGiven("Anton"))
        .build();

    MCCIIN000002UV01Type response = this.wsClient.sendPixUpdatePatientRequest(update.build().getRootElement(), null,
        update.getDestination().getUri(), "urn:hl7-org:v3:PRPA_IN201302UV02", facilityName);
    PixAddPatientResponse highLevelResponse = new PixAddPatientResponse(response);
    assertFalse(highLevelResponse.hasError());
  }
}
