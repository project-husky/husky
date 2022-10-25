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
import java.util.List;

import org.projecthusky.cda.elga.generated.artdecor.AtcdabbrSectionUebersetzung;
import org.projecthusky.cda.elga.generated.artdecor.enums.ElgaHumanLanguage;
import org.projecthusky.common.hl7cdar2.CS;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.StrucDocText;
import org.projecthusky.common.model.Identificator;

public class Translation {

	private List<PractitionerCdaAt> authors;
	private ZonedDateTime authorTime;
	private ElgaHumanLanguage language;
	private String text;
	private String title;
	private Identificator id;

	public List<PractitionerCdaAt> getAuthors() {
		return authors;
	}

	public void setAuthors(List<PractitionerCdaAt> authors) {
		this.authors = authors;
	}

	public ZonedDateTime getAuthorTime() {
		return authorTime;
	}

	public void setAuthorTime(ZonedDateTime authorTime) {
		this.authorTime = authorTime;
	}

	public ElgaHumanLanguage getLanguage() {
		return language;
	}

	public void setLanguage(ElgaHumanLanguage language) {
		this.language = language;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Identificator getId() {
		return id;
	}

	public void setId(Identificator id) {
		this.id = id;
	}

	public AtcdabbrSectionUebersetzung getAtcdabbrSectionUebersetzung() {
		AtcdabbrSectionUebersetzung translationSection = new AtcdabbrSectionUebersetzung();

		if (this.id != null) {
			translationSection.setHl7Id(this.id.getHl7CdaR2Ii());
		}

		if (this.title != null) {
			ST st = new ST();
			st.setXmlMixed(title);
			translationSection.setTitle(st);
		}

		if (this.text != null) {
			StrucDocText strucDocText = new StrucDocText();
			strucDocText.setXmlMixed(text);
			translationSection.setText(strucDocText);
		}

		if (this.language != null) {
			translationSection.setLanguageCode(new CS(this.language.getCode().getCode()));
		}

		if (this.authors != null && !this.authors.isEmpty()) {
			for (PractitionerCdaAt author : authors) {
				if (author != null) {
					translationSection.addHl7Author(author.getAtcdabbrOtherAuthorBodyEImpfpass(authorTime));
				}
			}
		}

		return translationSection;
	}


}
