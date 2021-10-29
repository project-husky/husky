package org.husky.xua.saml2.impl;

import java.util.List;

import org.herasaf.xacml.core.SyntaxException;
import org.herasaf.xacml.core.dataTypeAttribute.impl.AbstractDataTypeAttribute;

public class InteractionDataTypeAttribute extends AbstractDataTypeAttribute<String> {
    public static final String ID = "urn:ihe:2017:record#interaction";
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     * <p>
     * <b>This implementation:</b>
     * <p>
     * Interprets an empty list as an empty {@link String} value.
     */
    @Override
    public String convertTo(List<?> jaxbRepresentation) throws SyntaxException {
        boolean isEmptyList = jaxbRepresentation.isEmpty();
        if (isEmptyList) {
            return "";
        }
		return super.convertTo(jaxbRepresentation);
    }

    /** {@inheritDoc} */
    public String convertTo(String jaxbRepresentation) {
        return jaxbRepresentation;
    }

    /** {@inheritDoc} */
    public String getDatatypeURI() {
        return ID;
    }
}
