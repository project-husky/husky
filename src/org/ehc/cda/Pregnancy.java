package org.ehc.cda;

import java.util.Date;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.ehc.common.DateUtil;
import org.ehc.common.Util;
import org.openhealthtools.ihe.utils.UUID;
import org.openhealthtools.mdht.uml.cda.Act;
import org.openhealthtools.mdht.uml.cda.ihe.IHEFactory;
import org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation;
import org.openhealthtools.mdht.uml.hl7.datatypes.DatatypesFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.II;
import org.openhealthtools.mdht.uml.hl7.datatypes.TS;
import org.openhealthtools.mdht.uml.hl7.vocab.ActClassObservation;
import org.openhealthtools.mdht.uml.hl7.vocab.x_ActMoodDocumentObservation;

import ch.ehc.cda.enums.Pregnancies;

public class Pregnancy {
	org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation mPregnancy;

	public Pregnancy (Date estimatedBirdDate) {
		this.mPregnancy = IHEFactory.eINSTANCE.createPregnancyObservation().init();
		this.setEstimatedBirthDate(estimatedBirdDate);
		this.mPregnancy.setClassCode(ActClassObservation.OBS);
		this.mPregnancy.setMoodCode(x_ActMoodDocumentObservation.EVN);
		this.setInternalId(null);
		this.mPregnancy.setCode(Pregnancies.DELIVERY_DATE_CLINICAL_ESTIMATE.getCD());
		this.mPregnancy.setEffectiveTime(DateUtil.createUnknownTime(null));
	}

	public void setEstimatedBirthDate(Date estimatedBirdDate) {
		TS ts = DateUtil.ts(estimatedBirdDate);
		this.mPregnancy.getValues().add(ts);
	}

	public org.openhealthtools.mdht.uml.cda.ihe.PregnancyObservation copyMdhtPregnancy() {
		return EcoreUtil.copy(this.mPregnancy);
	}

	public String getEstimatedBirthdate() {

		if (this.mPregnancy.getValues().size()>0) {
			TS ts = (TS) this.copyMdhtPregnancy().getValues().get(0);
			return DateUtil.parseDateToStr(ts);
		}
		else return null;
	}
	
    private void setInternalId(String id) {
        II ii = Util.createUuidVacd(id);
        mPregnancy.getIds().add(ii);
      }

	public PregnancyObservation getMdhtPregnancy() {
		return mPregnancy;
	}
}