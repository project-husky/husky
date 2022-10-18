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
package org.projecthusky.valueset.api;

import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import org.apache.commons.io.IOUtils;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.projecthusky.common.basetypes.CodeBaseType;
import org.projecthusky.common.basetypes.IdentificatorBaseType;
import org.projecthusky.common.basetypes.NameBaseType;
import org.projecthusky.common.basetypes.OrganizationBaseType;
import org.projecthusky.common.enums.LanguageCode;
import org.projecthusky.common.utils.LangText;
import org.projecthusky.valueset.enums.DesignationType;
import org.projecthusky.valueset.enums.ValueSetEntryType;
import org.projecthusky.valueset.enums.ValueSetStatus;
import org.projecthusky.valueset.model.Designation;
import org.projecthusky.valueset.model.ValueSet;
import org.projecthusky.valueset.model.ValueSetEntry;
import org.projecthusky.valueset.model.Version;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * The value-set manager for FHIR.
 *
 * @author Quentin Ligier
 **/
public class FhirValueSetManager {
    private static final Logger log = LoggerFactory.getLogger(FhirValueSetManager.class);

    /**
     * Loads a value set from the given stream, which is provided in JSON format.
     *
     * @param inputStream the JSON definition of the value set.
     * @return the parsed value set.
     * @throws IOException
     */
    public ValueSet loadValueSetJson(final InputStream inputStream) throws IOException {
        final var jsonContent = IOUtils.toString(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        final var valueSet = new ValueSet();
        final var version = new Version();
        valueSet.setVersion(version);

        Map<String, Object> map = JsonPath.read(jsonContent, "$");
        for (final Map.Entry<String, Object> entry : map.entrySet()) {
            setValueSetMetadata(valueSet, entry.getKey(), entry.getValue());
        }

        map = JsonPath.read(jsonContent, "$.compose.include[0]");
        final var system = (String) map.get("system");
        for (final var object : (JSONArray) map.get("concept")) {
            final var entry = (Map<String, Object>) object;
            valueSet.addValueSetEntry(createEntry(system, entry));
        }

        return valueSet;
    }

    private ValueSetEntry createEntry(final String system,
                                             final Map<String, Object> map) {
        final var entry = new ValueSetEntry();
        entry.setLevel(0);
        entry.setValueSetEntryType(ValueSetEntryType.LEAF);
        entry.setCodeBaseType(CodeBaseType.builder().withCodeSystem(system).build());

        for (final Map.Entry<String, Object> row : map.entrySet()) {
            if ("code".equals(row.getKey())) {
                entry.getCodeBaseType().setCode((String) row.getValue());
            } else if ("display".equals(row.getKey())) {
                entry.getCodeBaseType().setDisplayName((String) row.getValue());
            } else if ("designation".equals(row.getKey()) && row.getValue() instanceof JSONArray jsonArray) {
                for (final Object child : jsonArray) {
                    entry.addDesignation(createDesignation((Map<String, String>) child));
                }
            }
        }

        return entry;
    }

    private Designation createDesignation(final Map<String, String> map) {
        return Designation.builder()
                .withDisplayName(map.get("value"))
                .withLanguageCode(LanguageCode.getEnum(map.get("language")))
                .withType(DesignationType.PREFERRED)
                .build();
    }

    private void setValueSetMetadata(final ValueSet valueSet,
                                     final String key,
                                     @Nullable final Object value) {
        if (value == null) {
            return;
        }

        if ("id".contentEquals(key)) {
            valueSet.setIdentificator(IdentificatorBaseType.builder().withRoot(value.toString()).build());
        } else if ("name".contentEquals(key)) {
            valueSet.setName(value.toString());
        } else if ("title".contentEquals(key)) {
            valueSet.setDisplayName(value.toString());
        } else if ("versionLabel".contentEquals(key)) {
            valueSet.getVersion().setLabel(value.toString());
        } else if ("date".contentEquals(key)) {
            final var dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                valueSet.getVersion().setValidFrom(dateFormat.parse(value.toString()));
            } catch (final ParseException exception) {
                log.warn("Unable to parse the date '{}'", value);
            }

        } else if ("status".contentEquals(key)) {
            valueSet.setStatus(getStatusCode(value.toString()));
        } else if ("description".contentEquals(key)) {
            valueSet.getDescriptionList().add(new LangText(null, value.toString()));
        } else if ("publisher".contentEquals(key)) {
            valueSet.getVersion().setPublishingAuthority(OrganizationBaseType.builder()
                                                                 .withPrimaryName(NameBaseType.builder().withName(value.toString()).build())
                                                                 .build());
        }
    }

    @Nullable
    private ValueSetStatus getStatusCode(final String status) {
        // draft: Value set under development (nascent). Metadata and
        // value set may be incomplete. Entered primarily to encourage
        // other users to be aware of ongoing process.
        if ("draft".equalsIgnoreCase(status))
            return ValueSetStatus.DRAFT;

        // final: Value set has been published by the custodian
        // organization and deemed fit for use. May have associated
        // adoption and annotation metadata
        if ("active".equalsIgnoreCase(status))
            return ValueSetStatus.FINAL;

        // deprecated: Value set retired: No longer fit for use.
        // Information available for historical reference.
        if ("retired".equalsIgnoreCase(status))
            return ValueSetStatus.DEPRECATED;

        return null;
    }
}
