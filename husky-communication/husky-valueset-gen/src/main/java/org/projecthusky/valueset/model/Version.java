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
package org.projecthusky.valueset.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.processing.Generated;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.projecthusky.common.basetypes.OrganizationBaseType;

/**
 * <div class="en">The Class Version contains all information describing a
 * specific version of a value set.</div>
 *
 * <div class="de">Die Klasse Version enthält alle Informationen, die eine
 * bestimmte Version eines Wertesatzes beschreiben.</div>
 */
public class Version implements Serializable {

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
		 * @param label the label
		 * @return the builder
		 */
		public Builder withLabel(String label) {
			this.label = label;
			return this;
		}

		/**
		 * With publishing authority.
		 *
		 * @param publishingAuthority the publishing authority
		 * @return the builder
		 */
		public Builder withPublishingAuthority(OrganizationBaseType publishingAuthority) {
			this.publishingAuthority = publishingAuthority;
			return this;
		}

		/**
		 * With valid from.
		 *
		 * @param validFrom the valid from
		 * @return the builder
		 */
		public Builder withValidFrom(Date validFrom) {
			this.validFrom = validFrom;
			return this;
		}

		/**
		 * With valid to.
		 *
		 * @param validTo the valid to
		 * @return the builder
		 */
		public Builder withValidTo(Date validTo) {
			this.validTo = validTo;
			return this;
		}
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -9119362988623580841L;

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
	 * <div class="de">Instanziiert eine neue Version. Standardkonstruktor.</div>
	 */
	public Version() {
	}

	/**
	 * Instantiates a new version.
	 *
	 * @param builder the builder
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
	 * <div class="de">Prüft, ob die beiden Objekte gleich sind (basierend auf ihrem
	 * Inhalt).</div>
	 *
	 * @param obj the Version to compare
	 * @return true, if equal; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		var retVal = true;
		if (obj == null)
			return false;

		if (!(obj instanceof Version))
			return false;

		if (this.label == null)
			retVal = (((Version) obj).getLabel() == null);
		else
			retVal = this.label.equals(((Version) obj).getLabel());

		if (retVal) {
			retVal = compareDate(this.validFrom, ((Version) obj).getValidFrom());
		}
		if (retVal) {
			retVal = compareDate(this.validTo, ((Version) obj).getValidTo());
		}
		return retVal;
	}

	private boolean compareDate(Date valid, Date valid2) {
		var retVal = true;
		if (valid == null) {
			retVal = (valid2 == null);
		} else {
			retVal = valid.equals(valid2);
			if (!retVal) {
				DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
				String validStr = dateFormat.format(valid);
				String validStr2 = dateFormat.format(valid2);
				retVal = validStr.equals(validStr2);
			}
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

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37).append(this.label).append(this.validFrom).append(this.validTo).toHashCode();
	}

	/**
	 * <div class="en">Sets the version label (e.g. '1.0').</div>
	 *
	 * <div class="de">Legt die Versionsbezeichnung fest (z. B. '1.0').</div>
	 *
	 * @param label the new label
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
	 * @param publishingAuthority the new publishing authority
	 */
	public void setPublishingAuthority(OrganizationBaseType publishingAuthority) {
		this.publishingAuthority = publishingAuthority;
	}

	/**
	 * <div class="en">Sets the valid from date.</div>
	 *
	 * <div class="de">Legt das 'Gültig ab' Datum fest.</div>
	 *
	 * @param validFrom the new valid from
	 */
	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	/**
	 * <div class="en">Sets the valid to date.</div>
	 *
	 * <div class="de">Legt das 'Gültig bis' Datum fest.</div>
	 *
	 * @param validTo the new valid to
	 */
	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	/**
	 * <div class="en">Builds a string of the version.</div>
	 *
	 * <div class="de">Erstellt einen String der Version.</div>
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return getLabel();
	}
}
