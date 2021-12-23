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
package org.husky.common.model;

import java.util.ArrayList;
import java.util.List;

import org.husky.common.basetypes.IdentificatorBaseType;
import org.husky.common.enums.NullFlavor;
import org.husky.common.hl7cdar2.II;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.Identifiable;

/**
 * The class Identificator contains all necessary fields for an id. This class also provides mapping methods to other
 * data types.
 */
public class Identificator extends IdentificatorBaseType {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 6963042793314704003L;

    /**
     * Instantiates a new identificator. Default constructor.
     */
    public Identificator() {

    }

    /**
     * Instantiates a new instance from the given base type.
     *
     * @param baseType the base type
     */
    public Identificator(IdentificatorBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Instantiates a new instance from the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type
     */
    public Identificator(org.husky.common.hl7cdar2.II hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

    /**
     * Instantiates a new instance from the given root.
     *
     * @param root the root
     */
    public Identificator(String root) {
        super.setRoot(root);
    }

    /**
     * Instantiates a new instance from the given root and extension.
     *
     * @param root      the root
     * @param extension the extension
     */
    public Identificator(String root, String extension) {
        super.setRoot(root);
        super.setExtension(extension);
    }

    public Identificator(Identifiable id) {
        if (id != null) {
            super.setExtension(id.getId());
            if (id.getAssigningAuthority() != null) {
                super.setRoot(id.getAssigningAuthority().getUniversalId());
            }
        }
    }

    /**
     * Creates the HL7 CDA R2 data type from the given base type.
     *
     * @param baseType the base type
     * @return the HL7 CDA R2 data typed value
     */
    public static org.husky.common.hl7cdar2.II createHl7CdaR2Ii(
            IdentificatorBaseType baseType) {

        org.husky.common.hl7cdar2.II retVal = null;

        if (baseType != null) {
            retVal = new org.husky.common.hl7cdar2.II();
            String value;

            var nf = baseType.getNullFlavor();
            if (nf != null) {
                if (retVal.nullFlavor == null)
                    retVal.nullFlavor = new ArrayList<String>();
                retVal.nullFlavor.add(nf.getCodeValue());
            } else {

                value = baseType.getAssigningAuthorityName();
                if (value != null) {
                    retVal.setAssigningAuthorityName(value);
                }

                Boolean bValue = baseType.isDisplayable();
                if (bValue != null) {
                    retVal.setDisplayable(bValue);
                }

                value = baseType.getExtension();
                if (value != null) {
                    retVal.setExtension(value);
                }

                value = baseType.getRoot();
                if (value != null) {
                    retVal.setRoot(value);
                }
            }
        }

        return retVal;

    }

    /**
     * Creates the base type from the given HL7 CDA R2 value.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 value
     * @return the base type
     */
    public static IdentificatorBaseType createIdentificatorBaseType(
            org.husky.common.hl7cdar2.II hl7CdaR2Value) {
        var retVal = new IdentificatorBaseType();

        if (hl7CdaR2Value != null) {
            String nullFlavor = null;
            if (hl7CdaR2Value.nullFlavor != null && !hl7CdaR2Value.nullFlavor.isEmpty())
                nullFlavor = hl7CdaR2Value.nullFlavor.get(0);
            if (nullFlavor != null)
                retVal.setNullFlavor(NullFlavor.getEnum(nullFlavor));

            retVal.setAssigningAuthorityName(hl7CdaR2Value.getAssigningAuthorityName());
            if (hl7CdaR2Value.isDisplayable() != null)
                retVal.setDisplayable(hl7CdaR2Value.isDisplayable());
            retVal.setExtension(hl7CdaR2Value.getExtension());
            retVal.setRoot(hl7CdaR2Value.getRoot());
        } else
            retVal.setNullFlavor(NullFlavor.NOT_AVAILABLE);

        return retVal;

    }

    /**
     * Gets the identificator with the given root id from a list of ids.
     *
     * @param iiList ii list
     * @param root   root
     * @return the identificator
     */
    public static Identificator getIdentificator(List<II> iiList, String root) {
        for (final II i : iiList) {
            if (i.getRoot().equals(root)) {
                return new Identificator(i);
            }
        }
        return null;
    }

	/**
	 * Gets a list of identificators from a list of ids.
	 *
	 * @param iiList ii list
	 * @return the list of identificator
	 */
	public static List<Identificator> getIdentificatorList(List<II> iiList) {
		final List<Identificator> il = new ArrayList<>();
		for (final org.husky.common.hl7cdar2.II mId : iiList) {
			il.add(new Identificator(mId));
		}
		return il;
	}

    /**
     * Gets the HL7 CDA R2 data type from the current instance.
     *
     * @return the HL7 CDA R2 data type
     */
    public org.husky.common.hl7cdar2.II getHl7CdaR2Ii() {
        return createHl7CdaR2Ii(this);
    }

    /**
     * Inits from the base type.
     *
     * @param baseType the base type
     */
    private void initFromBaseType(IdentificatorBaseType baseType) {
        if (baseType != null) {
            setAssigningAuthorityName(baseType.getAssigningAuthorityName());
            setDisplayable(baseType.isDisplayable());
            setExtension(baseType.getExtension());
            setRoot(baseType.getRoot());
            setNullFlavor(baseType.getNullFlavor());
        } else
            setNullFlavor(NullFlavor.NOT_AVAILABLE);
    }

    /**
     * Inits from the HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data type value
     */
    private void initFromHl7CdaR2(org.husky.common.hl7cdar2.II hl7CdaR2Value) {
        initFromBaseType(createIdentificatorBaseType(hl7CdaR2Value));
    }

    /**
     * Sets the fields of the current instance by the given base type.
     *
     * @param baseType the base type
     */
    public void set(IdentificatorBaseType baseType) {
        initFromBaseType(baseType);
    }

    /**
     * Sets the fields of the current instance by the given HL7 CDA R2 data type.
     *
     * @param hl7CdaR2Value the HL7 CDA R2 data typed value
     */
    public void set(org.husky.common.hl7cdar2.II hl7CdaR2Value) {
        initFromHl7CdaR2(hl7CdaR2Value);
    }

}
