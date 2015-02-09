package org.ehc.cda;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.cda.ch.enums.Pregnancies;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;

public class Pregnancy {
	org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation mPregnancy;

	public Pregnancy() {
		mPregnancy = IHEFactory.eINSTANCE.createPregnancyObservation().init();
		mPregnancy.setClassCode(ActClassObservation.OBS);
		mPregnancy.setMoodCode(x_ActMoodDocumentObservation.EVN);
		mPregnancy.setCode(Pregnancies.DELIVERY_DATE_CLINICAL_ESTIMATE.getCD());
		mPregnancy.setEffectiveTime(DateUtil.createUnknownTime(null));
		setInternalId(null);
	}

	public Pregnancy (Date estimatedBirdDate) {
		this();
		setEstimatedBirthDate(estimatedBirdDate);
	}

	public Pregnancy(org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation pregnancy) {
		mPregnancy = pregnancy;
	}

	public org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation copyMdhtPregnancy() {
		return EcoreUtil.copy(mPregnancy);
	}

	public String getEstimatedBirthdate() {

		if (mPregnancy.getValues().size()>0) {
			TS ts = (TS) copyMdhtPregnancy().getValues().get(0);
			return DateUtil.parseDateToStr(ts);
		}
		else return null;
	}

	public PregnancyObservation getMdhtPregnancy() {
		return mPregnancy;
	}

	public void setEstimatedBirthDate(Date estimatedBirdDate) {
		TS ts = DateUtil.ts(estimatedBirdDate);
		mPregnancy.getValues().add(ts);
	}

	private void setInternalId(String id) {
		II ii = Util.createUuidVacd(id);
		mPregnancy.getIds().add(ii);
	}
}