package org.projecthusky.fhir.core.ch.resource.r4;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.hl7.fhir.r4.model.ContactPoint;
import org.projecthusky.fhir.core.ch.annotation.ExpectsValidResource;
import org.projecthusky.fhir.core.ch.util.FhirDateTimes;

import java.time.Instant;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * This interface implements common logic to entities that may contain, within their FHIR resource's telecom list,
 * email addresses, phone numbers and/or email addresses as defined by CH Core. This allows, for instance, both
 * ChCoreOrganization and ChCorePatient to use the same code to handle these possible slices of the telecom list.
 */
public interface ChCoreContactPointCarrier {
    ContactPointRankComparator contactPointRankComparator = new ContactPointRankComparator();

    List<@NonNull ContactPoint> getTelecom();
    boolean hasTelecom();

    /**
     * Resolves the entity's email addresses. It can be empty if no email address was specified.
     */
    @ExpectsValidResource
    default List<@NonNull ContactPoint> resolveEmailAddresses() {
        return resolveTelecom(ContactPoint.ContactPointSystem.EMAIL);
    }

    /**
     * Resolves the list of email addresses of the entity and, if it is not empty, it gets the preferred email
     * address from teh list, i.e. the email address contact point with the lowest rank. Should several email addresses
     * in the list share the lowest rank, any among them might be returned by this method. See
     * {@link ContactPointRankComparator} for details on how the preferred email address is determined.
     *
     * @return The preferred email address contact point of this entity, or {@code null} if the entity
     *         resource conveys no email address.
     */
    @ExpectsValidResource
    default @Nullable ContactPoint resolvePreferredEmailAddress() {
        return getSinglePreferredContactPoint(this::resolveEmailAddresses);
    }

    /**
     * Resolves the entity's phone numbers. It can be empty if no phone number was specified.
     */
    @ExpectsValidResource
    default List<@NonNull ContactPoint> resolvePhoneNumbers(){
        return resolveTelecom(ContactPoint.ContactPointSystem.PHONE);
    }

    /**
     * Resolves the list of phone numbers of the entity and, if it is not empty, it gets the preferred phone
     * number from teh list, i.e. the phone number contact point with the lowest rank. Should several phone numbers
     * in the list share the lowest rank, any among them might be returned by this method. See
     * {@link ContactPointRankComparator} for details on how the preferred phone number is determined.
     *
     * @return The preferred phone number contact point of this entity, or {@code null} if the entity
     *         resource conveys no phone number.
     */
    @ExpectsValidResource
    default @Nullable ContactPoint resolvePreferredPhoneNumber() {
        return getSinglePreferredContactPoint(this::resolvePhoneNumbers);
    }

    /**
     * Resolves the entity's internet addresses, i.e. URLs. It can be empty if no internet address was specified.
     */
    @ExpectsValidResource
    default List<@NonNull ContactPoint> resolveInternetAddresses(){
        return resolveTelecom(ContactPoint.ContactPointSystem.URL);
    }

    /**
     * Resolves the list of internet addresses of the entity and, if it is not empty, it gets the preferred internet
     * address from teh list, i.e. the internet address contact point with the lowest rank. Should several internet addresses
     * in the list share the lowest rank, any among them might be returned by this method. See
     * {@link ContactPointRankComparator} for details on how the preferred internet address is determined.
     *
     * @return The preferred internet address contact point of this entity, or {@code null} if the entity
     *         resource conveys no internet address.
     */
    @ExpectsValidResource
    default @Nullable ContactPoint resolvePreferredInternetAddress() {
        return getSinglePreferredContactPoint(this::resolveInternetAddresses);
    }

    /**
     * Resolves the entity's list of telecom entries for the given system. If no telecom entries exist or if there
     * are no entries for the given system, an empty list will be returned.
     *
     * @param system The contact point system for which to fetch telecom entries.
     * @return The list of telecom entries for the given system, empty if no telecom entries exist or if no entries for
     *         the given system were found.
     */
    @ExpectsValidResource
    default List<@NonNull ContactPoint> resolveTelecom(final ContactPoint.ContactPointSystem system) {
        if (this.hasTelecom()) {
            return this.getTelecom().stream()
                    .filter(telecom -> system ==  telecom.getSystem())
                    .toList();
        } else return List.of();
    }

    /**
     * Fetches the list of telecom contact point values for the specified system and optionally checking whether they
     * are valid at the current time.
     *
     * @param system     The contact point system that must match.
     * @param activeOnly Whether to return only contact points for which the current timestamp is within the specified
     *                   boundaries (if any).
     * @return The list of strings with the matching contact points values.
     */
    private List<@NonNull String> resolveTelecomAsStrings(final ContactPoint.ContactPointSystem system,
                                                          boolean activeOnly) {
        return resolveTelecom(system).stream()
                .filter(telecom -> telecom.hasValue() && (!activeOnly || isContactPointActive(telecom)))
                .map(ContactPoint::getValue).toList();
    }

    /**
     * Fetches the list of email addresses values. It does not check their period.
     * @return The list of email addresses values.
     */
    default List<@NonNull String> resolveEmailAddressesAsStrings() {
        return resolveEmailAddressesAsStrings(false);
    }

    /**
     * Fetches the list of email address values, optionally checking if the period is valid at the moment.
     * @param activeOnly If true, the method will filter out email address for which the current timestamp is not within
     *                   the period boundaries, if defined.
     * @return The list of matching email addresses, as strings.
     */
    default List<@NonNull String> resolveEmailAddressesAsStrings(boolean activeOnly) {
        return resolveTelecomAsStrings(ContactPoint.ContactPointSystem.EMAIL, activeOnly);
    }

    /**
     * Fetches the list of phone number values. It does not check their period.
     * @return The list of phone number values as strings.
     */
    default List<@NonNull String> resolvePhoneNumbersAsStrings() {
        return resolvePhoneNumbersAsStrings(false);
    }

    /**
     * Fetches the list of email address values, optionally checking if the period is valid at the moment.
     * @param activeOnly If true, the method will filter out phone numbers for which the current timestamp is not within
     *                   the period boundaries, if defined.
     * @return The list of matching email addresses, as strings.
     */
    default List<@NonNull String> resolvePhoneNumbersAsStrings(boolean activeOnly) {
        return resolveTelecomAsStrings(ContactPoint.ContactPointSystem.PHONE, activeOnly);
    }

    /**
     * Selects and returns a single contact point from the list of contact points returned by the given supplier.
     * <p>
     * The method will return the <i>preferred</i> contact point of the list, following these criteria:
     * <ul>
     *     <li>Only active contact point entries at the current time are considered.</li>
     *     <li>If the list of active contact points is empty, the result shall be {@code null}.</li>
     *     <li>The order of preference is determined by using the {@link ContactPointRankComparator}.</li>
     *     <li>Should several active contact points share the lowest preference, one among them (any), will be returned.</li>
     * </ul>
     * </p>
     * @param contactPointsSupplier The supplier of the contact points list from which to select a single one.
     * @return A single selected contact point if the supplied list of contact points is not empty; otherwise {@code null}.
     */
    private @Nullable ContactPoint getSinglePreferredContactPoint(final Supplier<@NonNull List<@NonNull ContactPoint>> contactPointsSupplier) {
        return contactPointsSupplier.get().stream()
                .filter(ChCoreContactPointCarrier::isContactPointActive)
                .min(contactPointRankComparator).orElse(null);
    }

    /**
     * Determines whether a contact point is considered to be active at the current date and time.
     */
    private static boolean isContactPointActive(final ContactPoint contactPoint) {
        if (contactPoint.hasPeriod() && (contactPoint.getPeriod().hasStart() || contactPoint.getPeriod().hasEnd())) {
            if (contactPoint.getPeriod().hasStart() && contactPoint.getPeriod().getStartElement().getValueAsCalendar().after(Calendar.getInstance()))
                return false;
            if (contactPoint.getPeriod().hasEnd() && FhirDateTimes.completeToLatestInstant(contactPoint.getPeriod().getEndElement()).isBefore(Instant.now()))
                return false;
        }
        return true;
    }

    /**
     * Comparator of contact points based on their conveyed rank. The compare function will sort contact points this way:
     * <ul>
     *     <li>If both contact points A and B have a specified rank, the difference if rank is returned.
     *         This means that if a contact point A has a lower rank (higher priority) than contact point B, the
     *         difference is returned as a negative number. If A has a higher rank, the difference is returned as a
     *         positive number. If they share the same rank, 0 is returned.
     *     </li>
     *     <li>If one contact point has a specified rank and the other one does not, it is assumed the contact point
     *         conveying a rank has higher priority and hence it should be sorted before the one without a rank.
     *     </li>
     *     <li>If both contact points do not convey a rank, 0 is returned since their priority is considered to be equal.
     *     </li>
     * </ul>
     */
     class ContactPointRankComparator implements Comparator<@NonNull ContactPoint> {
        @Override
        public int compare(final @NonNull ContactPoint o1, final @NonNull ContactPoint o2) {
            if (Objects.requireNonNull(o1).hasRank() && Objects.requireNonNull(o2).hasRank())
                return o1.getRank() - o2.getRank();
            if (o1.hasRank()) return -1;
            if (o2.hasRank()) return 1;
            return 0;
        }
    }
}
