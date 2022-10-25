package org.projecthusky.communication.integration;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SelectClasses({ ConvenienceCommunicationSubmitDocumentTest.class, ConvenienceCommunicationQueryDocumentsTest.class,
		ConvenienceCommunicationRetrieveDocumentsTest.class })
@SuiteDisplayName("XDS use cases Test Suite")
public class XdsTestSuite {

}
