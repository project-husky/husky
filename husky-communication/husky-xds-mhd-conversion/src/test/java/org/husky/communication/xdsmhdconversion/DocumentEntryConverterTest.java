package org.husky.communication.xdsmhdconversion;


import org.husky.common.utils.xml.XmlFactories;
import org.husky.communication.xdsmhdconversion.converters.DocumentEntryConverter;
import org.junit.jupiter.api.Test;
import org.openehealth.ipf.commons.ihe.xds.core.ebxml.ebxml30.ProvideAndRegisterDocumentSetRequestType;
import org.openehealth.ipf.commons.ihe.xds.core.requests.ProvideAndRegisterDocumentSet;
import org.openehealth.ipf.platform.camel.ihe.xds.core.converters.EbXML30Converters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

/**
 * Tests of the {@link DocumentEntryConverter} class.
 * @author Ronaldo Loureiro
 */
class DocumentEntryConverterTest {

    private final Class<?> UNMARSHALLED_CLASS = ProvideAndRegisterDocumentSetRequestType.class;
    private final Unmarshaller UNMARSHALLER;

    public DocumentEntryConverterTest() throws JAXBException {
        final var context = JAXBContext.newInstance(UNMARSHALLED_CLASS);
        UNMARSHALLER = context.createUnmarshaller();
    }

    @Test
    void testConvertDocumentEntry() throws Exception {
        final var provideAndRegisterDocumentSet = this.unmarshall("/ProvideAndRegisterDocumentSetRequest/PARDSR_02.xml");

//        provideAndRegisterDocumentSet.getDocuments().get(0).getDocumentEntry();
    }

    private ProvideAndRegisterDocumentSet unmarshall(final String filename) throws Exception {
        final InputStream xmlStream = SubmissionSetConverterTest.class.getResourceAsStream(filename);

        final var document = XmlFactories.newSafeDocumentBuilder().parse(xmlStream);
        final Object root = UNMARSHALLER.unmarshal(document, UNMARSHALLED_CLASS);
        final var provideAndRegisterDocumentSetRequestType = (ProvideAndRegisterDocumentSetRequestType) JAXBIntrospector.getValue(root);
        return EbXML30Converters.convert(provideAndRegisterDocumentSetRequestType);
    }
}
