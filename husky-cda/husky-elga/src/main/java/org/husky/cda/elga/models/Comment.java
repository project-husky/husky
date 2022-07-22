/*
* This code is made available under the terms of the Eclipse Public License v1.0
* in the github project https://github.com/project-husky/husky there you also
* find a list of the contributors and the license information.
*
* This project has been developed further and modified by the joined working group Husky
* on the basis of the eHealth Connector opensource project from June 28, 2021,
* whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
*/
package org.husky.cda.elga.models;

import java.time.ZonedDateTime;
import java.util.List;

import org.husky.cda.elga.generated.artdecor.AtcdabrrEntryComment;
import org.husky.common.hl7cdar2.ED;
import org.husky.common.hl7cdar2.TEL;

public class Comment {

	private List<PractitionerCdaAt> authors;
	private List<Informant> informants;
	private String text;
	private ZonedDateTime authTime;

	public List<PractitionerCdaAt> getAuthors() {
		return authors;
	}

	public void setAuthor(List<PractitionerCdaAt> author) {
		this.authors = author;
	}

	public List<Informant> getInformants() {
		return informants;
	}

	public void setInformant(List<Informant> informant) {
		this.informants = informant;
	}

	public String getText() {
		return text;
	}

	public void setText(String comment) {
		this.text = comment;
	}

	public ZonedDateTime getAuthTime() {
		return authTime;
	}

	public void setAuthTime(ZonedDateTime authTime) {
		this.authTime = authTime;
	}

	public AtcdabrrEntryComment getAtcdabbrEntryComment(int commentIndex) {
		AtcdabrrEntryComment commentEntry = new AtcdabrrEntryComment();
		commentEntry.setText(new ED(null, new TEL("#commentRef-" + commentIndex)));

		if (authors != null) {
			for (PractitionerCdaAt author : authors) {
				if (author != null) {
					commentEntry.getAuthor().add(author.getAtcdabbrOtherAuthorBodyEImpfpass(authTime));
				}
			}
		}

		if (informants != null) {
			for (Informant informant : informants) {
				if (informant != null) {
					commentEntry.getInformant().add(informant.getInformantBodyPs());
				}
			}
		}

		return commentEntry;
	}



}
