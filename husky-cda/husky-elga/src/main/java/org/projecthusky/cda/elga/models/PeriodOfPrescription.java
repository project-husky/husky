/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.projecthusky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.xml.XMLConstants;
import jakarta.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.emed.Einnahmedauer;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.PQ;
import org.projecthusky.common.hl7cdar2.QTY;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.utils.time.DateTimes;

public class PeriodOfPrescription  {

	private Code frequence;
	private double quantitiy;
	private ZonedDateTime startIntake;
	private ZonedDateTime stopIntake;
	
	public PeriodOfPrescription(IVLTS time) {
		if(time != null) {
			PQ element = getPqElement(time).get("width");
			if(element != null) {
				this.quantitiy = Double.parseDouble(element.getValue());
				this.frequence = new Code(element.getUnit(), null, null);
			}
		}
	}
	
	public PeriodOfPrescription() {
		
	}

	public Code getFrequence() {
		return frequence;
	}

	public double getQuantitiy() {
		return quantitiy;
	}

	public ZonedDateTime getStartIntake() {
		return startIntake;
	}

	public ZonedDateTime getStopIntake() {
		return stopIntake;
	}

	public void setFrequence(Code frequence) {
		this.frequence = frequence;
	}

	public void setQuantitiy(double quantitiy) {
		this.quantitiy = quantitiy;
	}

	public void setStartIntake(ZonedDateTime startIntake) {
		this.startIntake = startIntake;
	}

	public void setStopIntake(ZonedDateTime stopIntake) {
		this.stopIntake = stopIntake;
	}

	public Einnahmedauer getEinnahmedauer() {
		if (this.frequence != null && this.quantitiy > 0.0) {
			return getFrequenceEffectiveTime(this.quantitiy, this.frequence.getCode());
		} else if(this.startIntake != null && this.stopIntake != null) {
			Einnahmedauer time = new Einnahmedauer();
			time.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(this.startIntake)));
			time.getRest()
					.add(new JAXBElement<>(
							new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX), TS.class,
							DateTimes.toDateTs(this.stopIntake)));

			return time;
		}
		return null;
	}

	private Einnahmedauer getFrequenceEffectiveTime(Double width, String unit) {
		Einnahmedauer takeInDuration = new Einnahmedauer();
		PQ pq = new PQ();
		pq.setUnit(unit);
		pq.setValue(String.valueOf(width));

		takeInDuration.getRest().add(new JAXBElement<>(
				new QName("urn:hl7-org:v3", "width", XMLConstants.DEFAULT_NS_PREFIX), PQ.class, pq));
		return takeInDuration;
	}
	
	protected Map<String, PQ> getPqElement(IVLTS time) {
		Map<String, PQ> pqElements = new HashMap<>();
		if (time != null) {
			for (JAXBElement<? extends QTY> pq : time.getRest()) {
				PQ value = new PQ();
				String elementName = "";
				if (pq != null && PQ.class.equals(pq.getDeclaredType()) && pq.getValue() != null) {
					value = (PQ) pq.getValue();
				}

				if (pq != null && pq.getName() != null) {
					elementName = pq.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					pqElements.put(elementName, value);
				}
			}
		}

		return pqElements;
	}

}
