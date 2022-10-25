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

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabrrEntryComment;
import org.projecthusky.cda.elga.generated.artdecor.EimpfEntryImpfrelevanteErkrankungProblemEntry;
import org.projecthusky.cda.elga.generated.artdecor.EimpfEntryImpfrelevanteErkrankungenProblemConcern;
import org.projecthusky.cda.elga.generated.artdecor.ps.GesundheitsproblemBedenkenEntry;
import org.projecthusky.cda.elga.generated.artdecor.ps.ProblemEntryGesundheitsproblem;
import org.projecthusky.cda.elga.utils.NamespaceUtils;
import org.projecthusky.common.enums.NullFlavor;
import org.projecthusky.common.hl7cdar2.ANY;
import org.projecthusky.common.hl7cdar2.CD;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.ED;
import org.projecthusky.common.hl7cdar2.II;
import org.projecthusky.common.hl7cdar2.IVLTS;
import org.projecthusky.common.hl7cdar2.IVXBTS;
import org.projecthusky.common.hl7cdar2.POCDMT000040Entry;
import org.projecthusky.common.hl7cdar2.POCDMT000040EntryRelationship;
import org.projecthusky.common.hl7cdar2.POCDMT000040Reference;
import org.projecthusky.common.hl7cdar2.QTY;
import org.projecthusky.common.hl7cdar2.TEL;
import org.projecthusky.common.hl7cdar2.TS;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntry;
import org.projecthusky.common.hl7cdar2.XActRelationshipEntryRelationship;
import org.projecthusky.common.hl7cdar2.XActRelationshipExternalReference;
import org.projecthusky.common.model.Code;
import org.projecthusky.common.model.Identificator;
import org.projecthusky.common.utils.time.DateTimes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Disease {

	private static final Logger LOGGER = LoggerFactory.getLogger(Disease.class);

	private Identificator id;
	private boolean active;
	private Code problem;
	private ZonedDateTime start;
	private ZonedDateTime stop;
	private List<Comment> comments;
	private PractitionerCdaAt author;
	private ZonedDateTime authorTime;
	private Appendix originalDoc;
	private List<Translation> translations;

	public Disease() {

	}

	public Disease(POCDMT000040Entry entry) {
		if (entry != null && entry.getAct() != null) {
			if (entry.getAct().getStatusCode() != null) {
				this.active = "active".equalsIgnoreCase(entry.getAct().getStatusCode().getCode());
			}

			if (entry.getAct().getEffectiveTime() != null) {
				Map<String, TS> timeMap = getTsElement(entry.getAct().getEffectiveTime());
				try {
					this.start = DateTimes.toLocalDate(timeMap.get("low")).atStartOfDay(ZoneId.systemDefault());
				} catch (Exception e) {
					LOGGER.error("{}: {}", e.getMessage(), timeMap.get("low").getValue());
				}

				try {
					this.stop = DateTimes.toLocalDate(timeMap.get("high")).atStartOfDay(ZoneId.systemDefault());
				} catch (Exception e) {
					LOGGER.error("{}: {}", e.getMessage(), timeMap.get("high"));
				}
			}

			extractDiseaseCode(entry);
		}

	}

	public Code getProblem() {
		return problem;
	}

	public ZonedDateTime getStart() {
		return start;
	}

	public ZonedDateTime getStop() {
		return stop;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setProblem(Code problem) {
		this.problem = problem;
	}

	public void setStart(ZonedDateTime start) {
		this.start = start;
	}

	public void setStop(ZonedDateTime stop) {
		this.stop = stop;
	}

	public List<Comment> getComment() {
		return comments;
	}

	public void setComment(List<Comment> comment) {
		this.comments = comment;
	}

	public List<Translation> getTranslations() {
		return translations;
	}

	public void setTranslations(List<Translation> translations) {
		this.translations = translations;
	}

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public PractitionerCdaAt getAuthor() {
		return author;
	}

	public void setAuthor(PractitionerCdaAt author) {
		this.author = author;
	}

	public ZonedDateTime getAuthorTime() {
		return authorTime;
	}

	public void setAuthorTime(ZonedDateTime authorTime) {
		this.authorTime = authorTime;
	}

	public Appendix getOriginalDoc() {
		return originalDoc;
	}

	public void setOriginalDoc(Appendix originalDoc) {
		this.originalDoc = originalDoc;
	}

	private void extractDiseaseCode(POCDMT000040Entry entry) {
		for (POCDMT000040EntryRelationship entryRel : entry.getAct().getEntryRelationship()) {
			if (entryRel != null && entryRel.getObservation() != null) {
				for (ANY any : entryRel.getObservation().getValue()) {
					if (any instanceof CD cd) {
						this.problem = new Code(cd);
					}
				}
			}
		}
	}

	public POCDMT000040Entry getGesundheitsProblemEntry(int referenceIndex) {
		POCDMT000040Entry entry = new POCDMT000040Entry();
		entry.setTypeCode(XActRelationshipEntry.DRIV);
		GesundheitsproblemBedenkenEntry act = new GesundheitsproblemBedenkenEntry();
		II problemId = new II();
		problemId.getNullFlavor().add(NullFlavor.UNKNOWN_L1_CODE);
		act.getId().add(problemId);

		if (!active) {
			act.setStatusCode(new CS("completed"));
		}

		IVLTS time = new IVLTS();
		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(start)));
		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(stop)));
		act.setHl7EffectiveTime(time);

		POCDMT000040EntryRelationship entryRel = act.getEntryRelationship().get(0);
		entryRel.setObservation(getProblemEntryGesundheitsproblem(referenceIndex, problemId));
		entry.setAct(act);
		return entry;
	}

	protected ProblemEntryGesundheitsproblem getProblemEntryGesundheitsproblem(int referenceIndex, II problemId) {
		ProblemEntryGesundheitsproblem observation = new ProblemEntryGesundheitsproblem();
		observation.getId().add(problemId);

		CD cd = new CD();
		cd.getNullFlavor().add(NullFlavor.UNKNOWN_L1_CODE);
		observation.setCode(cd);

		if (this.problem != null) {
			CD problemCD = this.problem.getHl7CdaR2Cd();
			problemCD.setOriginalText(new ED(null, new TEL("#classification-" + referenceIndex)));
			observation.setHl7Value(problemCD);
		}

		return observation;
	}

	protected EimpfEntryImpfrelevanteErkrankungProblemEntry getEimpfEntryImpfrelevanteErkrankungProblemEntry(
			int referenceIndex) {
		EimpfEntryImpfrelevanteErkrankungProblemEntry observation = new EimpfEntryImpfrelevanteErkrankungProblemEntry();

		IVLTS time = new IVLTS();
		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(start)));
		time.getRest()
				.add(new JAXBElement<>(new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
						TS.class, DateTimes.toDateTs(stop)));
		observation.setHl7EffectiveTime(time);

		if (id != null) {
			observation.getId().clear();
			II problemId = id.getHl7CdaR2Ii();
			problemId.setExtension(problemId.getExtension() + "_" + referenceIndex);
			observation.getId().add(id.getHl7CdaR2Ii());
		}

		if (this.problem != null) {
			CD problemCD = this.problem.getHl7CdaR2Cd();
			problemCD.setOriginalText(new ED(null, new TEL("#relevanteDisease-" + referenceIndex)));
			observation.setHl7Value(problemCD);
		}

		observation.setHl7Text(new ED(null, new TEL("#relevanteDisease-" + referenceIndex)));

		observation.getEntryRelationship().clear();
		if (this.comments != null && !this.comments.isEmpty()) {
			setComments(observation, referenceIndex);
		}

		return observation;
	}

	private void setComments(EimpfEntryImpfrelevanteErkrankungProblemEntry observation, int referenceIndex) {
		for (Comment comment : this.comments) {
			if (comment != null) {
				POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
				entryRel.setTypeCode(XActRelationshipEntryRelationship.COMP);
				entryRel.setContextConductionInd(true);
				AtcdabrrEntryComment entryComment = comment.getAtcdabbrEntryComment(referenceIndex);
				entryComment.setText(new ED(null, new TEL("#relevantDiseases-comment-" + referenceIndex)));
				entryRel.setAct(entryComment);
				observation.getEntryRelationship().add(entryRel);
			}
		}
	}

	public EimpfEntryImpfrelevanteErkrankungenProblemConcern getEimpfEntryImpfrelevanteErkrankungenProblemConcern(
			int referenceIndex) {
		EimpfEntryImpfrelevanteErkrankungenProblemConcern problemConcernAct = new EimpfEntryImpfrelevanteErkrankungenProblemConcern();

		if (active) {
			problemConcernAct.setHl7StatusCode(new CS("active"));
			if (start != null) {
				IVLTS time = new IVLTS();
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(start)));
				problemConcernAct.setEffectiveTime(time);
			}
		} else {
			problemConcernAct.setHl7StatusCode(new CS("completed"));
			if (start != null && stop != null) {
				IVLTS time = new IVLTS();
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "low", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(start)));
				time.getRest()
						.add(new JAXBElement<>(
								new QName(NamespaceUtils.HL7_NAMESPACE, "high", XMLConstants.DEFAULT_NS_PREFIX),
								TS.class, DateTimes.toDateTs(stop)));
				problemConcernAct.setEffectiveTime(time);
			}
		}

		if (author != null) {
			problemConcernAct.getHl7Author().add(author.getAuthorBodyPs(authorTime));
		}

		if (id != null) {
			problemConcernAct.getId().clear();
			problemConcernAct.getId().add(id.getHl7CdaR2Ii());
		}

		problemConcernAct.getEntryRelationship().clear();
		if (problem != null) {
			POCDMT000040EntryRelationship entryRel = new POCDMT000040EntryRelationship();
			entryRel.setTypeCode(XActRelationshipEntryRelationship.SUBJ);
			entryRel.setInversionInd(false);
			entryRel.setContextConductionInd(true);
			entryRel.setObservation(getEimpfEntryImpfrelevanteErkrankungProblemEntry(referenceIndex));
			problemConcernAct.getEntryRelationship().add(entryRel);
		}

		if (originalDoc != null) {
			POCDMT000040Reference reference = new POCDMT000040Reference();
			reference.setTypeCode(XActRelationshipExternalReference.REFR);
			reference.setExternalDocument(originalDoc.getAtcdabbrEntryExternalDocument(referenceIndex));
			problemConcernAct.setHl7Reference(reference);
		}

		return problemConcernAct;
	}

	protected Map<String, TS> getTsElement(IVLTS time) {
		Map<String, TS> tsElements = new HashMap<>();
		if (time != null) {
			for (JAXBElement<? extends QTY> ts : time.getRest()) {
				TS value = null;
				String elementName = "";
				if (ts != null && IVXBTS.class.equals(ts.getDeclaredType()) && ts.getValue() != null) {
					value = ((IVXBTS) ts.getValue());
				}

				if (ts != null && ts.getName() != null) {
					elementName = ts.getName().getLocalPart();
				}

				if (value != null && elementName != null) {
					tsElements.put(elementName, value);
				}
			}
		}

		return tsElements;
	}


}
