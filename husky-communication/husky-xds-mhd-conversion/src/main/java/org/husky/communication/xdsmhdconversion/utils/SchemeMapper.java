/*
 * Copyright 2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.husky.communication.xdsmhdconversion.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * mapper for code systems to schemes
 *
 * @author alexander kreutz
 */
public class SchemeMapper {

    Map<String, String> schemeToSystem = new HashMap<>();
    Map<String, String> systemToScheme = new HashMap<>();

    public SchemeMapper() {
        registerSchemeToSystem("2.16.840.1.113883.6.96", "http://snomed.info/sct");
    }

    /**
     * add a scheme to system mapping
     *
     * @param scheme
     * @param system
     */
    public void registerSchemeToSystem(String scheme, String system) {
        schemeToSystem.put(scheme, system);
        systemToScheme.put(system, scheme);
    }

    /**
     * scheme name -> system
     *
     * @param scheme
     * @return
     */
    public String getSystem(String scheme) {
        String system = schemeToSystem.get(scheme);
        if (system != null) return system;
        return "urn:oid:" + scheme;
    }

    /**
     * system -> scheme name
     *
     * @param system
     * @return
     */
    public String getScheme(String system) {
        if (system == null) {
            return null;
        }
        String scheme = systemToScheme.get(system);
        if (scheme != null) return scheme;
        if (system.startsWith("urn:oid:")) {
            system = system.substring(8);
        } else if (system.startsWith("urn:uuid:")) {
            system = system.substring(9);
        }
        return system;
    }
}
