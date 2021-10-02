package org.ehealth_connector.common.utils.datatypes;

import java.util.regex.Pattern;

/**
 * Helpers related to RUIDs (HL7 Reserved Identifier Scheme).
 * <p>
 * HL7 reserved identifiers are strings consisting only of (US-ASCII) letters, digits and hyphens, where the first
 * character must be a letter. HL7 may assign these reserved identifiers as mnemonic identifiers for major concepts
 * of interest to HL7.
 *
 * @author Quentin Ligier
 */
public class Ruids {

    /**
     * This class is not instantiable.
     */
    private Ruids() {}

    /**
     * Pattern that matches a RUID.
     */
    public static final Pattern PATTERN = Pattern.compile("^[A-Za-z][A-Za-z0-9\\-]*$");
}
