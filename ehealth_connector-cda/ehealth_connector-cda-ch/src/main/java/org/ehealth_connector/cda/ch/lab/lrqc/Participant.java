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
 * Year of publication: 2016
 *
 *******************************************************************************/
package org.ehealth_connector.cda.ch.lab.lrqc;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.cda.AssociatedEntity;
import org.ehealth_connector.cda.MdhtFacade;
import org.ehealth_connector.common.enums.CodeSystems;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.cda.Participant1;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.vocab.ParticipationType;

/**
 * The Class Participant. <div class="en">Physicians performing examinations in
 * the given laboratory MAY be added as participants.</div>
 * <div class="de">Ärzte, welche in dem, in <CH-LRQC-CUST> angegebenen Labor
 * Untersuchungen durchführen KÖNNEN als Participant hinzugefügt werden.</div>
 */
public class Participant extends MdhtFacade<Participant1> {

	/**
	 * Instantiates a new participant.
	 */
	public Participant() {
		super(CDAFactory.eINSTANCE.createParticipant1());
		getMdht().setAssociatedEntity(CDAFactory.eINSTANCE.createAssociatedEntity());
	}

	/**
	 * Instantiates a new participant.
	 *
	 * @param mdht
	 *            the mdht
	 */
	public Participant(Participant1 mdht) {
		super(mdht);
	}

	/**
	 * Instantiates the class with the required elements. Use this constructor,
	 * if you don´t want to get refunds from the OKP. The GLN will be added
	 * under participant/associatedEntity/id.
	 *
	 * @param gln
	 *            the GLN id (extension)
	 * @param isPhysician
	 *            true, if the associatedEntity is a physician. false if it is a
	 *            laboratory.
	 */
	public Participant(String gln, boolean isPhysician) {
		this();
		if (isPhysician) {
			getMdht().setTypeCode(ParticipationType.IND);
			// TODO
			// getMdht().getAssociatedEntity().setClassCode();
			// getMdht().getAssociatedEntity().setClassCode(RoleClassAssociati);
		}
		addGlnId(gln);
	}

	/**
	 * Instantiates the class with the required elements. Use this constructor,
	 * if you want to get refunds from the OKP. The GLN (of your laboratory)
	 * will be added under participant/associatedEntity/id. The zsr will be
	 * added under the same element (participant/associatedEntity/id).
	 *
	 * @param gln
	 *            the GLN id (extension)
	 * @param zsr
	 *            the ZSR number (extension)
	 * @param isPhysician
	 *            true, if the associatedEntity is a physician. false if it is a
	 *            laboratory.
	 */
	public Participant(String gln, String zsr, boolean isPhysician) {
		this(gln, isPhysician);
		addZsrId(zsr);
	}

	/**
	 * The extension of the GLN Id.
	 *
	 * @param gln
	 *            the GLN id extension
	 */
	public void addGlnId(String gln) {
		if (gln != null) {
			II ii = DatatypesFactory.eINSTANCE.createII();
			ii.setRoot(CodeSystems.GLN.getCodeSystemId());
			ii.setExtension(gln);
			getMdht().getAssociatedEntity().getIds().add(ii);
		}
	}

	/**
	 * Adds a new ZSR number, which is used if the participant wants to get
	 * refunded.
	 *
	 * @param zsrNumber
	 *            the extension part of the ZSR number. Root will be set
	 *            automatically, according to CdaChLrqc.ZSR_ID_ROOT
	 */
	public void addZsrId(String zsrNumber) {
		II ii = DatatypesFactory.eINSTANCE.createII();
		ii.setRoot(CdaChLrqc.ZSR_ID_ROOT);
		ii.setExtension(zsrNumber);
		getMdht().getAssociatedEntity().getIds().add(ii);
	}

	/**
	 * Gets the AssociatedEntity.
	 *
	 * @return the AssociatedEntity
	 */
	public AssociatedEntity getAssociatedEntity() {
		if (getMdht().getAssociatedEntity() != null) {
			return new AssociatedEntity(getMdht().getAssociatedEntity());
		}
		return null;
	}

	/**
	 * Gets a List of GLN Ids.
	 *
	 * @return the list of GLN Id extensions
	 */
	public List<String> getGlnIds() {
		ArrayList<String> al = new ArrayList<String>();
		for (final II i : getMdht().getAssociatedEntity().getIds()) {
			if (i.getRoot().equals(CodeSystems.GLN.getCodeSystemId())) {
				al.add(i.getExtension());
			}
		}
		return al;
	}

	/**
	 * Gets a list of ZSR numbers, which are used if the participant wants to
	 * get refunded.
	 *
	 * @return the list of ZSR IDs
	 */
	public List<String> getZsrIds() {
		ArrayList<String> zl = new ArrayList<String>();
		for (II ii : getMdht().getAssociatedEntity().getIds()) {
			if (ii.getRoot().equals(CdaChLrqc.ZSR_ID_ROOT)) {
				zl.add(ii.getExtension());
			}
		}
		return zl;
	}

	/**
	 * Sets the AssociatedEntity.
	 *
	 * @param entity
	 *            the AssociatedEntity
	 */
	public void setAssociatedEntity(AssociatedEntity entity) {
		getMdht().setAssociatedEntity(entity.copy());
	}
}
