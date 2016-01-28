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
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.ehealth_connector.cda.ch.vacd.CdaChVacd;
import org.junit.Before;
import org.junit.Test;
import org.openhealthtools.mdht.uml.cda.ClinicalDocument;
import org.openhealthtools.mdht.uml.cda.DocumentRoot;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;

/**
 *
 * @author roeland
 * @version 1.0
 * @since Jan 28, 2016 1:30:52 PM
 *
 */
public class DocumentProcessorTest {

	private File testFile;

	private InputStream testStream;

	/**
	 * Method implementing
	 *
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		final URL test1Url = this.getClass().getResource("/vacd/vacDoc_Test1.xml");
		testFile = new File(test1Url.getFile());
		testStream = this.getClass().getResourceAsStream("/vacd/vacDoc_Test2.xml");
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.DocumentProcessor#loadFromFile(java.lang.String)}
	 * .
	 *
	 * @throws Exception
	 */
	@Test
	public void testLoadFromFile() throws Exception {
		final CdaChVacd document = DocumentProcessor.loadFromFile(testFile.getAbsolutePath());
		assertNotNull(document);
		final DocumentRoot docRoot = document.getDocRoot();
		assertNotNull(docRoot);
		final ClinicalDocument clinicalDocument = docRoot.getClinicalDocument();
		assertNotNull(clinicalDocument);
		final II clDocId = clinicalDocument.getId();
		assertNotNull(clDocId);
		assertEquals("2.16.756.5.30.1.1.1.1", clDocId.getRoot());
		assertEquals("51bc6c3a-51b8-1950-1c21-fb8d9b73235b", clDocId.getExtension());
	}

	/**
	 * Test method for
	 * {@link org.ehealth_connector.cda.ch.DocumentProcessor#loadFromStream(java.io.InputStream)}
	 * .
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLoadFromStream() throws Exception {
		final CdaChVacd document = DocumentProcessor.loadFromStream(testStream);
		assertNotNull(document);
		final DocumentRoot docRoot = document.getDocRoot();
		assertNotNull(docRoot);
		final ClinicalDocument clinicalDocument = docRoot.getClinicalDocument();
		assertNotNull(clinicalDocument);
		final II clDocId = clinicalDocument.getId();
		assertNotNull(clDocId);
		assertEquals("2.16.756.5.30.1.1.1.1", clDocId.getRoot());
		assertEquals("51c4d94c-51c2-1950-aeba-13b0b1958ec8", clDocId.getExtension());
	}

}
