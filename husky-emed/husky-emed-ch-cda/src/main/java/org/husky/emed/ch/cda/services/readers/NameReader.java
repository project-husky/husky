/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.services.readers;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.husky.common.hl7cdar2.*;
import org.husky.common.utils.OptionalUtils;

import javax.xml.bind.JAXBElement;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * A reader for CDA-CH-EMED names.
 *
 * @author Quentin Ligier
 **/
public record NameReader(List<@NonNull PN> names) {

    /**
     * Constructor.
     *
     * @param names The names.
     */
    public NameReader(final List<@NonNull PN> names) {
        this.names = Objects.requireNonNull(names);
    }

    /**
     * Returns the first of the legal family names.
     */
    public String getFirstLegalFamilyName() {
        return Optional.of(this.getLegalFamilyNames()).map(OptionalUtils::getListFirstElement).orElseThrow();
    }

    /**
     * Returns the first of the legal given names.
     */
    public String getFirstLegalGivenName() {
        return Optional.of(this.getLegalGivenNames()).map(OptionalUtils::getListFirstElement).orElseThrow();
    }

    /**
     * Returns the list of legal family names.
     */
    public List<@NonNull String> getLegalFamilyNames() {
        return Optional.of(this.getLegalNames())
                .map(EN::getContent)
                .orElse(Collections.emptyList())
                .stream()
                .filter(JAXBElement.class::isInstance)
                .filter(jaxbElement -> ((JAXBElement<?>) jaxbElement).getValue() instanceof EnFamily)
                .map(jaxbElement -> (EnFamily) ((JAXBElement<?>) jaxbElement).getValue())
                .filter(enFamily -> enFamily.getQualifier(false).isEmpty())
                .map(ANY::getMergedXmlMixed)
                .toList();
    }

    /**
     * Returns the list of legal given names.
     */
    public List<@NonNull String> getLegalGivenNames() {
        return Optional.of(this.getLegalNames())
                .map(EN::getContent)
                .orElse(Collections.emptyList())
                .stream()
                .filter(JAXBElement.class::isInstance)
                .filter(jaxbElement -> ((JAXBElement<?>) jaxbElement).getValue() instanceof EnGiven)
                .map(jaxbElement -> (EnGiven) ((JAXBElement<?>) jaxbElement).getValue())
                .filter(enGiven -> enGiven.getQualifier(false).isEmpty())
                .map(ANY::getMergedXmlMixed)
                .toList();
    }

    /**
     * Returns the list of legal academic titles.
     */
    public List<@NonNull String> getLegalAcademicTitles() {
        return Optional.of(this.getLegalNames())
                .map(EN::getContent)
                .orElse(Collections.emptyList())
                .stream()
                .filter(JAXBElement.class::isInstance)
                .filter(jaxbElement -> ((JAXBElement<?>) jaxbElement).getValue() instanceof EnPrefix)
                .map(jaxbElement -> (EnPrefix) ((JAXBElement<?>) jaxbElement).getValue())
                .filter(enPrefix -> enPrefix.getQualifier(false).size() == 1 && "AC" .equals(enPrefix.getQualifier(false).get(0)))
                .map(ANY::getMergedXmlMixed)
                .toList();
    }

    /**
     * Returns the enclosing legal name object.
     */
    private PN getLegalNames() {
        return this.names.stream()
                .filter(name -> name.getUse().isEmpty() || "L" .equals(name.getUse().get(0)))
                .findAny().orElseThrow();
    }
}


