/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.mtps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.StringReader;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehealth_connector.cda.AbstractAllergyConcern;
import org.ehealth_connector.cda.AbstractAllergyProblem;
import org.ehealth_connector.cda.AbstractPregnancyHistory;
import org.ehealth_connector.cda.Consumable;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.cda.Problem;
import org.ehealth_connector.cda.SectionAnnotationCommentEntry;
import org.ehealth_connector.cda.ch.ActiveProblemConcern;
import org.ehealth_connector.cda.ch.AllergyConcern;
import org.ehealth_connector.cda.ch.AllergyProblem;
import org.ehealth_connector.cda.ch.PastProblemConcern;
import org.ehealth_connector.cda.ch.PregnancyHistory;
import org.ehealth_connector.cda.ch.enums.RouteOfAdministration;
import org.ehealth_connector.cda.ch.vacd.enums.SectionsVACD;
import org.ehealth_connector.cda.enums.AllergiesAndIntolerances;
import org.ehealth_connector.cda.enums.LanguageCode;
import org.ehealth_connector.cda.enums.ProblemConcernStatusCode;
import org.ehealth_connector.cda.testhelper.TestUtils;
import org.ehealth_connector.common.Address;
import org.ehealth_connector.common.Author;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Name;
import org.ehealth_connector.common.Organization;
import org.ehealth_connector.common.Patient;
import org.ehealth_connector.common.Telecoms;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.AddressUse;
import org.ehealth_connector.common.enums.AdministrativeGender;
import org.ehealth_connector.common.enums.CodeSystems;
import org.ehealth_connector.common.enums.ObservationInterpretation;
import org.ehealth_connector.common.utils.DateUtil;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.ch.CHPackage;
import org.openhealthtools.mdht.uml.cda.ch.VACD;
import org.openhealthtools.mdht.uml.cda.util.CDAUtil;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * 
 *
 */
public class IheMedicalDocumentTest extends TestUtils {

	private final Log log = LogFactory.getLog(MdhtFacade.class);

	private XPathFactory xpathFactory = XPathFactory.newInstance();
	private XPath xpath = xpathFactory.newXPath();


	public IheMedicalDocumentTest() {
		super();
	}



	@Test
	public void testDocumentReplaceIdentifier() throws Exception {
		final IheMedicalDocument vacd = new IheMedicalDocument();
		assertEquals(null, vacd.getDocumentToReplaceIdentifier());
		final Identificator identificator = new Identificator("root", "ext");
		vacd.setDocumentToReplaceIdentifier(identificator);
		assertEquals(identificator, vacd.getDocumentToReplaceIdentifier());

		final Document document = vacd.getDocument();
		final XPathExpression expr = xpath
				.compile("clinicaldocument/relatedDocument[@typeCode='RPLC']/parentDocument/id[@root='root' and @extension='ext']");
		final NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
		assertEquals(1, nodes.getLength());

	}


}
