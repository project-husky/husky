/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.husky.emed.ch.cda.utils.readers;

import org.husky.common.hl7cdar2.TEL;
import org.husky.common.hl7cdar2.URL;
import org.husky.emed.ch.models.common.TelecomDigest;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * A reader for CDA-CH-EMED telecoms.
 *
 * @author Quentin Ligier
 */
public class TelecomReader {

    private final List<TEL> telecoms;

    public TelecomReader(final List<TEL> telecoms) {
        this.telecoms = Objects.requireNonNull(telecoms);
    }

    /**
     * Gets the phone numbers.
     */
    public List<String> getPhoneNumbers() {
        return this.telecoms.stream()
                .map(URL::getValue)
                .filter(Objects::nonNull)
                .filter(url -> url.startsWith("tel:"))
                .toList();
    }

    /**
     * Gets the fax numbers.
     */
    public List<String> getFaxNumbers() {
        return this.telecoms.stream()
                .map(URL::getValue)
                .filter(Objects::nonNull)
                .filter(url -> url.startsWith("fax:"))
                .toList();
    }

    /**
     * Gets the mail addresses.
     */
    public List<String> getMailAddresses() {
        return this.telecoms.stream()
                .map(URL::getValue)
                .filter(Objects::nonNull)
                .filter(url -> url.startsWith("mailto:"))
                .toList();
    }

    /**
     * Gets the website addresses.
     */
    public List<String> getWebsiteAddresses() {
        return this.telecoms.stream()
                .map(URL::getValue)
                .filter(Objects::nonNull)
                .filter(url -> url.startsWith("http://") || url.startsWith("https://"))
                .toList();
    }

    /**
     * Gets other telecoms.
     */
    public List<String> getOtherTelecoms() {
        final var others = this.telecoms.stream()
                .map(URL::getValue)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        others.removeAll(this.getPhoneNumbers());
        others.removeAll(this.getFaxNumbers());
        others.removeAll(this.getMailAddresses());
        others.removeAll(this.getWebsiteAddresses());
        return others;
    }

    /**
     * Creates and fills a {@link TelecomDigest}.
     */
    public TelecomDigest toDigest() {
        return new TelecomDigest(
                this.getMailAddresses(),
                this.getPhoneNumbers(),
                this.getFaxNumbers(),
                this.getWebsiteAddresses(),
                this.getOtherTelecoms()
        );
    }
}
