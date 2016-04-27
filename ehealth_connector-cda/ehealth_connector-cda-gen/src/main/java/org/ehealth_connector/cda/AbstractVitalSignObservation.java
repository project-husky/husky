package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.Date;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehealth_connector.cda.enums.ActSite;
import org.ehealth_connector.cda.enums.VitalSignCodes;
import org.ehealth_connector.cda.utils.CdaUtil;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.enums.LanguageCode;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.CD;
import org.openhealthtools.mdht.uml.hl7.datatypes.CE;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.PQ;
import org.openhealthtools.mdht.uml.hl7.vocab.NullFlavor;

/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by
 * medshare GmbH, Switzerland. All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License
 * v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative
 * Commons Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2016
 *
 *******************************************************************************/

public abstract class AbstractVitalSignObservation extends AbstractObservation {

	/** The m vital sign observation. */
	private org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation mVitalSignObservation;

	/**
	 * Adds the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void addId(Identificator id) {
		final II ii = CdaUtil.createUniqueIiFromIdentificator(id);
		mVitalSignObservation.getIds().add(ii);
	}

	/**
	 * <div class="en">Gets the code of the observation</div>
	 * <div class="de">Gibt den Code der Beobachtung zurück.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the code
	 */
	@Override
	public Code getCode() {
		final Code code = new Code(getVitalSignObservation().getCode());
		return code;
	}

	@Override
	public String getCommentText() {
		return Util.getCommentText(mVitalSignObservation.getEntryRelationships());
	}

	/**
	 * Gets the reference to the content element. It is the value of the ID in
	 * the &lt;content ID="xxx"&gt; element prefixed with #.
	 *
	 * @return the content ID reference
	 */
	public String getContentIdReference() {
		if ((getVitalSignObservation().getText() != null)
				&& (getVitalSignObservation().getText().getReference() != null)) {
			return getVitalSignObservation().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Gets the Effective Time
	 *
	 * @return the effective time as date
	 */
	public Date getEffectiveTime() {
		return DateUtil.parseIVL_TSVDateTimeValue(getVitalSignObservation().getEffectiveTime());
	}

	/**
	 * Gets the interpretation of the vital sign observation.
	 *
	 * @return the interpretation as code or null.
	 */
	public Code getInterpretationCode() {
		final EList<CE> codes = getVitalSignObservation().getInterpretationCodes();
		if (!codes.isEmpty()) {
			return new Code(codes.get(0));
		}
		return null;
	}

	/**
	 * <div class="de">Get a copy mdht vital sign observation.</div>
	 * <div class="de">Gibt eine Kopie der mdth vital sign observation
	 * zurück.</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return the org.openhealthtools.mdht.uml.cda.ch. vital sign observation
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation getMdhtCopy() {
		return EcoreUtil.copy(getVitalSignObservation());
	}

	@Override
	public Object getMdhtObservation() {
		return mVitalSignObservation;
	}

	/**
	 * Gets the target site of the vital sign observation.
	 *
	 * @return the target site as code or null.
	 */
	public Code getTargetSiteCode() {
		final EList<CD> codes = getVitalSignObservation().getTargetSiteCodes();
		if (!codes.isEmpty()) {
			return new Code(codes.get(0));
		}
		return null;
	}

	/**
	 * Sets the text of this element.
	 *
	 * @param text
	 *            the new text
	 */
	public String getText(String text) {
		if ((getVitalSignObservation().getText() != null)
				&& (getVitalSignObservation().getText().getText() != null)) {
			return getVitalSignObservation().getText().getText();
		}
		return null;
	}

	/**
	 * Gets the text reference.
	 *
	 * @return the text reference
	 */
	public String getTextReference() {
		if ((getVitalSignObservation().getText() != null)
				&& (getVitalSignObservation().getText().getReference() != null)) {
			return getVitalSignObservation().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Get the (first) problem value. The Value may be a coded or uncoded
	 * String.
	 *
	 * @return the (first) problem value as string.
	 */
	@Override
	public Value getValue() {
		if (!getVitalSignObservation().getValues().isEmpty()
				&& (getVitalSignObservation().getValues().get(0) instanceof PQ)) {
			return new Value(getVitalSignObservation().getValues().get(0));
		}
		return null;
	}

	/**
	 * Method to get
	 *
	 * @return the vitalSignObservation
	 */
	public org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation getVitalSignObservation() {
		return mVitalSignObservation;
	}

	/**
	 * Initialize the MDHT VitalSignObservation model object.
	 */
	protected void initMdht() {
		setVitalSignObservation(IHEFactory.eINSTANCE.createVitalSignObservation().init());
		final CE ceNullFlavourCode = DatatypesFactory.eINSTANCE.createCE();
		ceNullFlavourCode.setNullFlavor(NullFlavor.NA);

		final CD cdNullFlavourCode = DatatypesFactory.eINSTANCE.createCD();
		cdNullFlavourCode.setNullFlavor(NullFlavor.NA);

		getVitalSignObservation().getMethodCodes().add(EcoreUtil.copy(ceNullFlavourCode));
		getVitalSignObservation().getInterpretationCodes().add(EcoreUtil.copy(ceNullFlavourCode));
		getVitalSignObservation().getTargetSiteCodes().add(EcoreUtil.copy(cdNullFlavourCode));

		getVitalSignObservation().setText(Util.createReference("#TODO"));
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(Code code) {
		getVitalSignObservation().setCode(code.getCD());
	}

	/**
	 * Sets the reference to the content element. This is the value of the ID in
	 * the &lt;content ID="xxx"&gt; element. If not provided it will
	 * automatically be prefixed with #.
	 *
	 * @param value
	 *            the content ID reference
	 */
	public void setContentIdReference(String value) {
		if (!value.startsWith("#"))
			value = "#" + value;
		getVitalSignObservation().setText(Util.createReference(value));
	}

	/**
	 * Sets the date time of result.
	 *
	 * @param dateTimeOfResult
	 *            the new date time of result
	 */
	public void setEffectiveTime(Date dateTimeOfResult) {
		try {
			getVitalSignObservation()
					.setEffectiveTime(DateUtil.createIVL_TSFromEuroDateTime(dateTimeOfResult));
		} catch (final ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set a new language code of the vital sign observation, and its codes.
	 *
	 * @param languageCode
	 *            <div class="de">Language code</div> <div class="fr"></div>
	 *            <div class="it"></div>
	 */
	public void setLanguageCode(LanguageCode languageCode) {
		final CD code = getVitalSignObservation().getCode();
		if (code != null) {
			final VitalSignCodes vsCode = VitalSignCodes.getEnum(code.getCode());
			if (vsCode != null) {
				code.setDisplayName(vsCode.getDisplayName(languageCode));
			}
		}
		if (!getVitalSignObservation().getTargetSiteCodes().isEmpty()) {
			final CD tsCode = getVitalSignObservation().getTargetSiteCodes().get(0);
			final ActSite aSite = ActSite.getEnum(tsCode.getCode());
			if (aSite != null) {
				tsCode.setDisplayName(aSite.getDisplayName(languageCode));
			}
		}
	}

	/**
	 * Set a new act site of the vital sign observation.
	 *
	 * @param code
	 *            <div class="de">Anatomische Lage des Resultats</div>
	 *            <div class="fr"></div> <div class="it"></div>
	 */
	@Override
	public void setTargetSite(ActSite code) {
		if (code != null) {
			getVitalSignObservation().getTargetSiteCodes().clear();
			getVitalSignObservation().getTargetSiteCodes().add(code.getCD());
		}
	}

	/**
	 * Sets the text of this element.
	 *
	 * @param text
	 *            the new text
	 */
	public void setText(String text) {
		getVitalSignObservation().setText(Util.createEd(text));
	}

	/**
	 * Creates the reference to the section.
	 *
	 * @param prefix
	 *            the prefix
	 */
	public void setTextReference(String prefix) {
		getVitalSignObservation().setText(Util.createReference(prefix));
	}

	/**
	 * Adds the value.
	 *
	 * @param value
	 *            the new value
	 */
	@Override
	public void setValue(Value value) {
		if (value.isPhysicalQuantity()) {
			getVitalSignObservation().getValues().add(value.copyMdhtPhysicalQuantity());
		}
		if (value.isCode()) {
			getVitalSignObservation().getValues().add(value.copyMdhtCode());
		}
		if (value.isRto()) {
			getVitalSignObservation().getValues().add(value.copyMdhtRto());
		}
	}

	/**
	 * Method to set
	 *
	 * @param vitalSignObservation
	 *            the vitalSignObservation to set
	 */
	public void setVitalSignObservation(
			org.openhealthtools.mdht.uml.cda.ihe.VitalSignObservation vitalSignObservation) {
		mVitalSignObservation = vitalSignObservation;
	}

}
