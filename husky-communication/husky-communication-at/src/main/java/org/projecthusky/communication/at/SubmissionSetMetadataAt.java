/*
 * This code is made available under the terms of the Eclipse Public License v1.0
 * in the github project https://github.com/project-husky/husky there you also
 * find a list of the contributors and the license information.
 *
 * This project has been developed further and modified by the joined working group Husky
 * on the basis of the eHealth Connector opensource project from June 28, 2021,
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 */
package org.projecthusky.communication.at;

import org.projecthusky.common.at.AuthorAt;
import org.projecthusky.common.communication.SubmissionSetMetadata;
import org.projecthusky.common.model.Author;

/**
 * Represents the metadata for a submission set (which can hold one or more
 * documents)
 */
public class SubmissionSetMetadataAt extends SubmissionSetMetadata {

	@Override
	public void setAuthor(Author author) {
		getIpfSubmissionSet().setAuthor(AuthorAt.getIpfAuthor(author));
	}

}
