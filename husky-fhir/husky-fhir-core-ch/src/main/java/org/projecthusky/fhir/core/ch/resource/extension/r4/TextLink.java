package org.projecthusky.fhir.core.ch.resource.extension.r4;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.DatatypeDef;
import ca.uhn.fhir.model.api.annotation.Extension;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.instance.model.api.IBaseDatatype;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.UriType;
import org.projecthusky.fhir.core.ch.exceptions.InvalidContentException;

import java.util.ArrayList;
import java.util.List;

import static ca.uhn.fhir.model.api.annotation.Child.MAX_UNLIMITED;

/**
 * Extension of the {@link org.hl7.fhir.r4.model.Extension} (sic) to model the
 * <a href="https://build.fhir.org/ig/HL7/fhir-extensions/StructureDefinition-textLink.html">TextLink</a> extension that
 * should be used for original representation sections as per
 * <a href="https://fhir.ch/ig/ch-core/readable-representation-epr-docs.html">CH Core guidance</a>, but that it is not
 * explicitly part of the Swiss base profiles. Thus, an instance of this class can be added to a section's extension
 * list simply by calling the addExtension method and passing such instance. Hence, this class was not designed with the
 * purpose of being embedded as a backbone element in one of the CH Core classes.
 */
@DatatypeDef(name = "TextLink", isSpecialization = true)
@Getter @Setter
public class TextLink extends org.hl7.fhir.r4.model.Extension {
    @Child(name = "htmlid", min = 1, max = MAX_UNLIMITED)
    @Extension(url = "htmlid", definedLocally = false)
    protected List<@NonNull StringType> htmlid;

    @Child(name = "data", min = 1, max = 1)
    @Extension(url = "data", definedLocally = false)
    protected UriType data;

    @Child(name = "selector", min = 0, max = 1)
    @Extension(url = "selector",  definedLocally = false)
    @Nullable
    protected StringType selector;

    @Override
    public org.hl7.fhir.r4.model.Extension setUrl(final String value) {
        return this;
    }

    @Override
    public org.hl7.fhir.r4.model.Extension setValue(final Type value) {
        return this;
    }

    @Override
    public org.hl7.fhir.r4.model.Extension setValue(final IBaseDatatype value) {
        return this;
    }

    public TextLink() {
        url = new UriType("http://hl7.org/fhir/StructureDefinition/textLink");
    }

    public TextLink(final String htmlId, final UriType data) {
        this();
        if (htmlId == null || htmlId.isBlank()) throw new InvalidContentException("htmlid cannot be null");
        if (data == null) throw new InvalidContentException("data cannot be null");
        this.htmlid = List.of(new StringType(htmlId));
        this.data = data;
    }

    public TextLink(final List<@NonNull StringType> htmlIds, final UriType data, final @Nullable StringType selector) {
        this();
        if (htmlIds == null || htmlIds.isEmpty()) throw new InvalidContentException("htmlid cannot be null or empty");
        if (data == null) throw new InvalidContentException("data cannot be null");
        this.htmlid = htmlIds;
        this.data = data;
        this.selector = selector;
    }

    @Override
    public TextLink copy() {
        final var copy = new TextLink();
        copyValues(copy);
        return copy;
    }

    public void copyValues(org.hl7.fhir.r4.model.Extension dst) {
        super.copyValues(dst);
        if (dst instanceof final TextLink textLink) {
            textLink.htmlid = new ArrayList<>(textLink.htmlid);
            textLink.data = this.data.copy();
        }
    }
}
