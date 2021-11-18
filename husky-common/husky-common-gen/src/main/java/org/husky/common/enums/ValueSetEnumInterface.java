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

package org.husky.common.enums;

import org.husky.common.hl7cdar2.CE;
import org.husky.common.model.Code;
import org.husky.common.utils.datatypes.Hl7v25;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.LocalizedString;

import java.util.Collection;
import java.util.Objects;

/**
 * <div class="en">Interface for all dynamically created/updated value
 * sets.</div> <div class="de">Interface für alle dynamisch
 * erstellten/aktualisierten Valuesets.</div>
 */
public interface ValueSetEnumInterface extends CodedMetadataEnumInterface {

    /**
     * <div class="en">Gets the Code of this Enum.</div>
     * <div class="de">Liefert den Code dieses Enum.</div>
     *
     * @return <div class="en">The MDHT Code</div>
     */
    default CE getCE() {
        final CE ce = new CE();
        ce.setCodeSystem(getCodeSystemId());
        ce.setCode(getCodeValue());
        ce.setCodeSystemName(getCodeSystemName());
        ce.setDisplayName(getDisplayName());
        return ce;
    }

    /**
     * <div class="en">Gets the ehealthconnector Code Object</div>
     * <div class="de">Liefert das ehealthconnector Code Objekt</div>
     *
     * @return <div class="en">the code</div>
     */
    default Code getCode() {
        return new Code(getCodeValue(), getCodeSystemId(), getDisplayName());
    }

    /**
     * <div class="en">Gets the OHT CodedMetadataType Object</div>
     * <div class="de">Liefert das OHT CodedMetadataType Objekt</div>
     *
     * @return <div class="en">the codedMetadataType</div>
     */
    @Override
    default org.openehealth.ipf.commons.ihe.xds.core.metadata.Code getIpfCode() {
		return new org.openehealth.ipf.commons.ihe.xds.core.metadata.Code(
				this.getCodeValue(),
				new LocalizedString(this.getDisplayName(), LanguageCode.ENGLISH_CODE, "UTF-8"),
				this.getCodeSystemId()
		);
    }

    /**
     * Verifies if the current instance and a {@link org.openehealth.ipf.commons.ihe.xds.core.metadata.Code} are coding
     * the same value in the same system.
     *
     * @param code The code to compare.
     * @return {@code true} if they are equal, {@code false} otherwise.
     */
    @Override
    default boolean isEqualTo(final org.openehealth.ipf.commons.ihe.xds.core.metadata.Code code) {
        return this.getCodeSystemId().equals(Objects.requireNonNull(code).getSchemeName())
                && this.getCodeValue().equals(code.getCode());
    }

    /**
     * Checks whether a collection of codes contains a particular value set code.
     *
     * @param codes The collection of codes.
     * @return {@code true} if the collection contains the value set code, {@code false} otherwise.
     */
    @Override
    default boolean isContainedIn(final Collection<org.openehealth.ipf.commons.ihe.xds.core.metadata.Code> codes) {
        return Objects.requireNonNull(codes).stream().anyMatch(this::isEqualTo);
    }

    /**
     * Encodes an eHC value set code to an IHE Coded String, as defined in ITI TF-3 Table 4.2.3.1.7-2. It is mostly an
     * HL7 V2.5 CX field. The code is escaped, the code system ID shall be an OID so escaping it shouldn't be needed.
     *
     * @return the encoded IHE Coded String.
     */
    @Override
    default String getCodedString() {
        return String.format(
                "%s^^^&%s&ISO",
                Hl7v25.encodeSt(this.getCodeValue()),
                this.getCodeSystemId()
        );
    }

    /**
     * <div class="en">Gets the code system id.</div> <div class="de">Liefert
     * die code system id.</div>
     *
     * @return <div class="en">the code system id</div>
     */
    String getCodeSystemId();

    /**
     * <div class="en">Gets the code system name.</div> <div class="de">Liefert
     * den code system Namen.</div>
     *
     * @return <div class="en">the code system id</div>
     */
    String getCodeSystemName();

    /**
     * <div class="en">Gets the actual Code as string</div>
     * <div class="de">Liefert den eigentlichen Code als String</div>
     *
     * @return <div class="en">the code</div>
     */
    String getCodeValue();

    /**
     * <div class="en">Gets the display name.</div> <div class="de">Liefert
     * display name.</div>
     *
     * @return <div class="en">the display name</div>
     */
    default String getDisplayName() {
        return getDisplayName(null);
    }

    /**
     * <div class="en">Gets the display name defined by the language param. If
     * language is unknow, german name is returned</div> <div class="de">Liefert
     * display name gemäss Parameter, falls die Sprache unbekannt ist, wird
     * standartmässig deutsch geliefert.</div>
     *
     * @param languageCode the language code to get the display name for
     * @return returns the display name in the desired language. if language not found, display name in german will
     * man will returned
     */
    String getDisplayName(LanguageCode languageCode);

    /**
     * <div class="en">Gets the value set identifier.</div>
     * <div class="de">Liefert den Value Set Identifikator.</div>
     *
     * @return <div class="en">the value set identifier</div>
     */
    String getValueSetId();

    /**
     * <div class="en">Gets the value set name.</div> <div class="de">Liefert
     * den Value Set Namen.</div>
     *
     * @return <div class="en">the value set name</div>
     */
    String getValueSetName();

}
