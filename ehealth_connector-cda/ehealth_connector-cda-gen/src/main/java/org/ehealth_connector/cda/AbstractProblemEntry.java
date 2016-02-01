/*******************************************************************************
 *
 * The authorship of this code and the accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. http://medshare.net
 *
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 *
 * This code is are made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * Year of publication: 2015
 *
 *******************************************************************************/

package org.ehealth_connector.cda;

import java.text.ParseException;
import java.util.Date;

import org.ehealth_connector.cda.enums.AllergiesSpecialConditions;
import org.ehealth_connector.cda.enums.ProblemType;
import org.ehealth_connector.cda.enums.ProblemsSpecialConditions;
import org.ehealth_connector.common.Code;
import org.ehealth_connector.common.Identificator;
import org.ehealth_connector.common.Value;
import org.ehealth_connector.common.utils.DateUtil;
import org.ehealth_connector.common.utils.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.IVL_TS;

/**
 * ProblemEntry convenience functionality for the CDA Body Level 3 -Problem
 */
public class AbstractProblemEntry extends MdhtFacade<org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry> {

	/**
	 * Instantiates a new problem entry.
	 */
	public AbstractProblemEntry() {
		super(IHEFactory.eINSTANCE.createProblemEntry().init());
		// clear default code <code codeSystem="2.16.840.1.113883.6.96"
		// codeSystemName="SNOMEDCT"/>
		this.getMdht().setCode(Util.createCENullFlavorUNK());
		this.setNotOccured(false);
	}

	/**
	 * Instantiates a new problem entry.
	 */
	protected AbstractProblemEntry(org.openhealthtools.mdht.uml.cda.ihe.ProblemEntry entry) {
		super(entry);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof AbstractProblemEntry)) {
			return false;
		}
		final AbstractProblemEntry other = (AbstractProblemEntry) obj;

		final Identificator id = this.getId();
		if (((id != null) && !id.equals(other.getId())) || ((id == null) && (other.getId() != null))) {
			return false;
		}

		if (getProblemNotOccured() != other.getProblemNotOccured()) {
			return false;
		}

		if (((getStartDate() != null) && !getStartDate().equals(other.getStartDate()))
				|| ((getStartDate() == null) && (other.getStartDate() != null))) {
			return false;
		}

		if (((getEndDate() != null) && !getEndDate().equals(other.getEndDate()))
				|| ((getEndDate() == null) && (other.getEndDate() != null))) {
			return false;
		}

		if (((getCode() != null) && !getCode().equals(other.getCode())) || ((getCode() == null) && (other.getCode() != null))) {
			return false;
		}
		if (getValue() != null) {
			if (!this.getValue().isCode() || (other.getValue() == null) || !other.getValue().isCode()) {
				return false;
			}
			if (!getValue().getCode().equals(other.getValue().getCode())) {
				return false;
			}
		}
		if ((getValue() == null) && (other.getValue() != null)) {
			return false;
		}

		return true;
	}

	/**
	 * Gets the allergie special condition.
	 * 
	 * @return the allergie special condition
	 */
	public AllergiesSpecialConditions getAllergySpecialCondition() {
		final Value value = this.getValue();
		if (value != null) {
			final Code code = value.getCode();
			if ((code != null) && AllergiesSpecialConditions.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return AllergiesSpecialConditions.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the code of the problem</div> <div class="de">Gibt
	 * den Code des Problems zurück.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @return the codedProblem object
	 */
	public org.ehealth_connector.common.Code getCode() {
		final org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(getMdht().getCode());
		return code;
	}

	/**
	 * <div class="en">Gets the point in time, since the problem is
	 * terminated</div> <div class="de">Gibt das Zeitpunkt zurück, seitdem das
	 * Problems beendet ist</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the endOfProblem Object
	 */
	public Date getEndDate() {
		if (getMdht().getEffectiveTime() != null) {
			if (getMdht().getEffectiveTime().getHigh() != null) {
				return DateUtil.parseDate(getMdht().getEffectiveTime().getHigh());
			}
		}
		return null;
	}

	/**
	 * one id can be provided for retraceability (evacdoc 7.5.2.5)
	 * 
	 * @return the id
	 */
	public Identificator getId() {
		Identificator id = null;
		if ((getMdht().getIds() != null) && (getMdht().getIds().size() > 0)) {
			id = new Identificator(getMdht().getIds().get(0));
		}
		return id;
	}

	/**
	 * <div class="en">gets the information, if the problem is not occured</div>
	 * <div class="de">Gibt zurück, ob das Problem nicht aufgetreten ist.</div>
	 * <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the problemNotOccured Object
	 */
	public boolean getProblemNotOccured() {
		if (this.getMdht().getNegationInd() != null) {
			return this.getMdht().getNegationInd();
		}
		return false;
	}

	/**
	 * Gets the allergie special condition.
	 * 
	 * @return the allergie special condition
	 */
	public ProblemsSpecialConditions getProblemSpecialCondition() {
		final Value value = this.getValue();
		if (value != null) {
			final Code code = value.getCode();
			if ((code != null) && ProblemsSpecialConditions.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
				return ProblemsSpecialConditions.getEnum(code.getCode());
			}
		}
		return null;
	}

	/**
	 * <div class="en">Gets the code of the problem</div> <div class="de">Gibt
	 * den Code des Problems zurück.</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @return the codedProblem object
	 */
	public ProblemType getProblemType() {
		final org.ehealth_connector.common.Code code = new org.ehealth_connector.common.Code(getMdht().getCode());
		if ((code != null) && ProblemType.CODE_SYSTEM_OID.equals(code.getCodeSystem())) {
			return ProblemType.getEnum(code.getCode());
		}
		return null;
	}

	/**
	 * <div class="en">gets the point in time, when the problem started</div>
	 * <div class="de">Gibt den Zeitpunkt zurück, seit das Problems angefangen
	 * hat</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @return the startOfProblem Object
	 */
	public Date getStartDate() {
		if (getMdht().getEffectiveTime() != null) {
			if (getMdht().getEffectiveTime().getLow() != null) {
				return DateUtil.parseDate(getMdht().getEffectiveTime().getLow());
			}
		}
		return null;
	}

	/**
	 * Gets the text reference.
	 * 
	 * @return the text reference
	 */
	public String getTextReference() {
		if ((this.getMdht().getText() != null) && (this.getMdht().getText().getReference() != null)) {
			return this.getMdht().getText().getReference().getValue();
		}
		return null;
	}

	/**
	 * Gets the problem value. The Value may be a coded or uncoded String.
	 * 
	 * @return the (first) problem value as string.
	 */
	public Value getValue() {
		if (this.getMdht().getValues().size() > 0) {
			return new Value(getMdht().getValues().get(0));
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + (this.getId() != null ? this.getId().hashCode() : 0);
		result = (prime * result) + (this.getProblemNotOccured() ? 1 : 0);
		result = (prime * result) + (this.getStartDate() != null ? getStartDate().hashCode() : 0);
		result = (prime * result) + (this.getEndDate() != null ? getEndDate().hashCode() : 0);
		result = (prime * result) + (this.getCode() != null ? getCode().hashCode() : 0);
		result = (prime * result) + ((this.getValue() != null) && this.getValue().isCode() ? getValue().getCode().hashCode() : 0);
		return result;
	}

	/**
	 * Sets the allergies special condition.
	 * 
	 * @param condition
	 *            the new allergies special condition
	 */
	public void setAllergySpecialCondition(AllergiesSpecialConditions condition) {
		setValue(new Value(condition.getCode()));
	}

	/**
	 * Sets the code.
	 * 
	 * @param codedProblem
	 *            the codedProblem Object which will be set
	 */
	public void setCode(org.ehealth_connector.common.Code codedProblem) {
		getMdht().setCode(codedProblem.getCD());
	}

	/**
	 * <div class="en">sets the point in time, when the problem had ended</div>
	 * <div class="de">Setzt den Zeitpunkt, seitdem das Problems beendet
	 * ist</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param endOfProblem
	 *            the endOfProblem Object which will be set
	 */
	public void setEndDate(Date endOfProblem) {
		if (this.getMdht().getEffectiveTime() == null) {
			final IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			this.getMdht().setEffectiveTime(interval);
		}
		getMdht().getEffectiveTime().setHigh(DateUtil.createIVXB_TSFromDate(endOfProblem));
	}

	/**
	 * one id can be provided for retraceability (evacdoc 7.5.2.5)
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Identificator id) {
		this.getMdht().getIds().clear();
		if (id != null) {
			this.getMdht().getIds().add(id.getIi());
		}
	}

	/**
	 * <div class="en">true, if the problem is not occured (negationInd), false
	 * otherwise</div> <div class="de">true, wenn das Problem nicht aufgetreten
	 * ist, false sonst (negationInd)</div> <div class="fr"></div>
	 * <div class="it"></div>
	 * 
	 * @param problemNotOccured
	 *            the problemNotOccured Object which will be set
	 */
	public void setNotOccured(boolean problemNotOccured) {
		this.getMdht().setNegationInd(problemNotOccured);
	}

	/**
	 * Sets the problem special condition.
	 * 
	 * @param condition
	 *            the new problem special condition
	 */
	public void setProblemSpecialCondition(ProblemsSpecialConditions condition) {
		setValue(new Value(condition.getCode()));
	}

	/**
	 * Sets the code.
	 * 
	 * @param kindOfProblem
	 *            the new code
	 */
	public void setProblemType(ProblemType kindOfProblem) {
		getMdht().setCode(kindOfProblem.getCD());
	}

	/**
	 * <div class="en">point in time, when the problem started</div>
	 * <div class="de">Setzt den Zeitpunkt, an dem das Problems angefangen
	 * hat</div> <div class="fr"></div> <div class="it"></div>
	 * 
	 * @param startOfProblem
	 *            the startOfProblem Object which will be set
	 */
	public void setStartDate(Date startOfProblem) {
		if (this.getMdht().getEffectiveTime() == null) {
			final IVL_TS interval = DatatypesFactory.eINSTANCE.createIVL_TS();
			this.getMdht().setEffectiveTime(interval);
		}
		this.getMdht().getEffectiveTime().setLow(DateUtil.createIVXB_TSFromDate(startOfProblem));
	}

	/**
	 * Sets the text reference.
	 * 
	 * @param value
	 *            the new text reference, # for local reference has to be
	 *            included
	 */
	public void setTextReference(String value) {
		this.getMdht().setText(Util.createReference(value));
	}

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the new value
	 */
	public void setValue(Value value) {
		getMdht().getValues().clear();
		getMdht().getValues().add(value.getValue());
	}

}
