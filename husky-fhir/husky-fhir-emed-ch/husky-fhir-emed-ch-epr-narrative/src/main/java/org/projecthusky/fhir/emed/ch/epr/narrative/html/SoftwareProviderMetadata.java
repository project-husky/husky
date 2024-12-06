package org.projecthusky.fhir.emed.ch.epr.narrative.html;

import org.checkerframework.checker.nullness.qual.Nullable;

public record SoftwareProviderMetadata(@Nullable String softwareName,
                                       @Nullable String softwareVersion,
                                       @Nullable String softwareProvider
                                       ) {
    public boolean hasSoftwareName() {return softwareName != null;}
    public boolean hasSoftwareVersion() {return softwareVersion != null;}
    public boolean hasSoftwareProvider() {return softwareProvider != null;}
}
