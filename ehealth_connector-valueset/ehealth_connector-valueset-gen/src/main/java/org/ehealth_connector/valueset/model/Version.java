/*
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */
package org.ehealth_connector.valueset.model;

import java.util.Date;

import javax.annotation.Generated;

import org.ehealth_connector.common.basetypes.OrganizationBaseType;

/**
 * <div class="en">The Class Version contains all information describing a
 * specific version of a value set.
 */
public class Version {

	/**
	 * See getter/setter for more details to the class members.
	 */

	/**
	 * Builder to build {@link Version}.
	 */
	@Generated("SparkTools")
	public static final class Builder {

		/** The label. */
		private String label;

		/** The publishing authority. */
		private OrganizationBaseType publishingAuthority;

		/** The valid from. */
		private Date validFrom;

		/** The valid to. */
		private Date validTo;

		/**
		 * Instantiates a new builder.
		 */
		private Builder() {
		}

		/**
		 * Builds the.
		 *
		 * @return the version
		 */
		public Version build() {
			return new Version(this);
		}

		/**
		 * With label.
		 *
		 * @param label
		 *            the label
		 * @return the builder
		 */
		public Builder withLabel(String label) {
			this.label = label;
			return this;
		}

		/**
		 * With publishing authority.
		 *
		 * @param publishingAuthority
		 *            the publishing authority
		 * @return the builder
		 */
		public Builder withPublishingAuthority(OrganizationBaseType publishingAuthority) {
			this.publishingAuthority = publishingAuthority;
			return this;
		}

		/**
		 * With valid from.
		 *
		 * @param validFrom
		 *            the valid from
		 * @return the builder
		 */
		public Builder withValidFrom(Date validFrom) {
			this.validFrom = validFrom;
			return this;
		}

		/**
		 * With valid to.
		 *
		 * @param validTo
		 *            the valid to
		 * @return the builder
		 */
		public Builder withValidTo(Date validTo) {
			this.validTo = validTo;
			return this;
		}
	}

	/**
	 * Creates builder to build {@link Version}.
	 *
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/** The label. */
	private String label;

	/** The publishing authority. */
	private OrganizationBaseType publishingAuthority;

	/** The valid from. */
	private Date validFrom;

	/** The valid to. */
	private Date validTo;

	/**
	 * <div class="en">Instantiates a new Version. Default constructor.</div>
	 *
	 * <div class="de">Instanziiert eine neue Version.
	 * Standardkonstruktor.</div>
	 */
	public Version() {
	}

	/**
	 * Instantiates a new version.
	 *
	 * @param builder
	 *            the builder
	 */
	@Generated("SparkTools")
	private Version(Builder builder) {
		this.label = builder.label;
		this.publishingAuthority = builder.publishingAuthority;
		this.validFrom = builder.validFrom;
		this.validTo = builder.validTo;
	}

	/**
	 * <div class="en">Checks whether the two objects are equal (based on their
	 * content).</div>
	 *
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf
	 * ihrem Inhalt).</div>
	 *
	 * @param obj
	 *            the Version to compare
	 * @return true, if equal; false otherwise.
	 */
	public boolean equals(Version obj) {
		boolean retVal = true;
		if (retVal) {
			if (this.label == null)
				retVal = (obj.getLabel() == null);
			else
				retVal = this.label.equals(obj.getLabel());
		}
		if (retVal) {
			if (this.publishingAuthority == null)
				retVal = (obj.getPublishingAuthority() == null);
			else
				retVal = this.publishingAuthority.equals(obj.getPublishingAuthority());
		}
		if (retVal) {
			if (this.validFrom == null)
				retVal = (obj.getValidFrom() == null);
			else
				retVal = this.validFrom.equals(obj.getValidFrom());
		}
		if (retVal) {
			if (this.validTo == null)
				retVal = (obj.getValidTo() == null);
			else
				retVal = this.validTo.equals(obj.getValidTo());
		}
		return retVal;
	}

	/**
	 * <div class="en">Gets the version label (e.g. '1.0').</div>
	 *
	 * <div class="de">Ruft die Versionsbezeichnung ab (z. B. '1.0').</div>
	 *
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * <div class="en">Gets the publishing authority (responsible
	 * organization).</div>
	 *
	 * <div class="de">Ruft die Veröffentlichungsbehörde (verantwortliche
	 * Organisation) ab.</div>
	 *
	 * @return the publishing authority
	 */
	public OrganizationBaseType getPublishingAuthority() {
		return publishingAuthority;
	}

	/**
	 * <div class="en">Gets the valid from date.</div>
	 *
	 * <div class="de">Ruft das 'Gültig ab' Datum ab.</div>
	 *
	 * @return the valid from
	 */
	public Date getValidFrom() {
		return validFrom;
	}

	/**
	 * <div class="en">Gets the valid to date.</div>
	 *
	 * <div class="de">Ruft das 'Gültig bis' Datum ab.</div>
	 *
	 * @return the valid to
	 */
	public Date getValidTo() {
		return validTo;
	}

	/**
	 * <div class="en">Sets the version label (e.g. '1.0').</div>
	 *
	 * <div class="de">Legt die Versionsbezeichnung fest (z. B. '1.0').</div>
	 *
	 * @param label
	 *            the new label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * <div class="en">Sets the publishing authority (responsible
	 * organization).</div>
	 *
	 * <div class="de">Legt die Veröffentlichungsbehörde (verantwortliche
	 * Organisation) fest.</div>
	 *
	 * @param publishingAuthority
	 *            the new publishing authority
	 */
	public void setPublishingAuthority(OrganizationBaseType publishingAuthority) {
		this.publishingAuthority = publishingAuthority;
	}

	/**
	 * <div class="en">Sets the valid from date.</div>
	 *
	 * <div class="de">Legt das 'Gültig ab' Datum fest.</div>
	 *
	 * @param validFrom
	 *            the new valid from
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * <div class="en">Sets the valid to date.</div>
	 *
	 * <div class="de">Legt das 'Gültig bis' Datum fest.</div>
	 *
	 * @param validTo
	 *            the new valid to
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}
}
