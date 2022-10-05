/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.xua.validation;

import net.shibboleth.utilities.java.support.resolver.CriteriaSet;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.opensaml.security.credential.Credential;
import org.opensaml.xmlsec.keyinfo.KeyInfoCredentialResolver;

import javax.annotation.concurrent.ThreadSafe;
import java.util.Collections;

/**
 * A no-operation {@link KeyInfoCredentialResolver}.
 *
 * @author Quentin Ligier
 */
@ThreadSafe
public class NoopKeyInfoCredentialResolver implements KeyInfoCredentialResolver {

    /**
     * Process the specified criteria and return the resulting instances of the product type which satisfy the
     * criteria.
     *
     * @param criteria the criteria to evaluate or process.
     * @return instances which satisfy the criteria.
     */
    @NonNull
    @Override
    public Iterable<Credential> resolve(@Nullable CriteriaSet criteria) {
        return Collections.emptyList();
    }

    /**
     * Process the specified criteria and return a single instance of the product type which satisfies the criteria.
     * <p>
     * If multiple items satisfy the criteria, the choice of which single item to return is implementation-dependent.
     *
     * @param criteria the criteria to evaluate or process.
     * @return a single instance satisfying the criteria, or null.
     */
    @Nullable
    @Override
    public Credential resolveSingle(@Nullable CriteriaSet criteria) {
        return null;
    }
}
