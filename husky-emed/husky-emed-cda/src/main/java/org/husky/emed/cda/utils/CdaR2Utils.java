package org.husky.emed.cda.utils;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.checkerframework.dataflow.qual.SideEffectFree;
import org.husky.emed.cda.generated.hl7cdar2.*;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Utils around CDA R2 classes.
 *
 * @author Quentin Ligier
 */
public class CdaR2Utils {

    /**
     * This class is not instantiable.
     */
    private CdaR2Utils() {}

    /**
     * Returns the single non-blank string of the {@code xmlMixed} parameter of an {@link ANY} instance. If no string
     * or more than one strings are present, the method throws an exception.
     *
     * @param any The {@link ANY} instance.
     * @return the single non-blank string from {@code xmlMixed}.
     * @throws IllegalArgumentException if there is zero or more than one {@code xmlMixed} value.
     */
    public String getSingleNonNullMixedOrThrow(final ANY any) {
        final List<String> mixed = any.getXmlMixed();
        if (mixed.size() != 1) {
            throw new IllegalArgumentException("");
        }
        return mixed.get(0);
    }

    /**
     * Returns the single non-blank string of the {@code xmlMixed} parameter of an {@link ANY} instance. If no string
     * is present, {@code null} is returned and if more than one strings are present, the method throws an exception.
     *
     * @param any The {@link ANY} instance.
     * @return the single non-blank string from {@code xmlMixed} or {@code null}.
     * @throws IllegalArgumentException if there is more than one {@code xmlMixed} value.
     */
    @Nullable
    public static String getSingleNullableMixedOrThrow(final ANY any) {
        final List<String> mixed = any.getXmlMixed();
        if (mixed.isEmpty()) {
            return null;
        } else if (mixed.size() > 1) {
            throw new IllegalArgumentException("");
        } else {
            return mixed.get(0);
        }
    }

    /**
     * Returns the content section (that contains the item entries).
     *
     * @return the content section.
     */
    @SideEffectFree
    public static Optional<POCDMT000040Section> getContentSection(final POCDMT000040ClinicalDocument cce) {
        return Optional.ofNullable(Objects.requireNonNull(cce).getComponent())
                .map(POCDMT000040Component2::getStructuredBody)
                .map(POCDMT000040StructuredBody::getComponent)
                .orElse(Collections.emptyList())
                .stream()
                .map(POCDMT000040Component3::getSection)
                .filter(Objects::nonNull)
                .filter(section -> TemplateIds.hasAllIds(TemplateIds.MTP_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PRE_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.DIS_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PADV_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PML_SECTION, section.getTemplateId())
                        || TemplateIds.hasAllIds(TemplateIds.PMLC_SECTION, section.getTemplateId()))
                .findAny();
    }


    /**
     * Converts the given value to a HL7 CDA R2 INT.
     *
     * @param value The value.
     * @return the int.
     */
    public static INT createInt(final BigInteger value) {
        final var retVal = new INT();
        retVal.setValue(value);
        return retVal;
    }

    /**
     * Converts the given value to a HL7 CDA R2 INT.
     *
     * @param value The value.
     * @return the int.
     */
    public static INT createInt(final Integer value) {
        return createInt(BigInteger.valueOf(value));
    }
}
