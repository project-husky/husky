package org.ehealth_connector.xua.validation;

import net.shibboleth.utilities.java.support.resolver.CriteriaSet;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.opensaml.security.credential.Credential;
import org.opensaml.xmlsec.keyinfo.KeyInfoCredentialResolver;

import java.util.Collections;

/**
 * A no-operation {@link KeyInfoCredentialResolver}.
 *
 * @author Quentin Ligier
 */
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
