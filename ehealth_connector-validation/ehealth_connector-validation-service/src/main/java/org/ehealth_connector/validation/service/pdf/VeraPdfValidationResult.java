/*
 *
 * The authorship of this project and accompanying materials is held by medshare GmbH, Switzerland.
 * All rights reserved. https://medshare.net
 *
 * Source code, documentation and other resources have been contributed by various people.
 * Project Team: https://sourceforge.net/p/ehealthconnector/wiki/Team/
 * For exact developer information, please refer to the commit history of the forge.
 *
 * This code is made available under the terms of the Eclipse Public License v1.0.
 *
 * Accompanying materials are made available under the terms of the Creative Commons
 * Attribution-ShareAlike 4.0 License.
 *
 * This line is intended for UTF-8 encoding checks, do not modify/delete: äöüéè
 *
 */

package org.ehealth_connector.validation.service.pdf;

import java.util.ArrayList;
import java.util.List;

public class VeraPdfValidationResult {

	private boolean validationDone = false;
	private boolean isPdfValid = false;

	private final List<VeraPdfValidationResultEntry> results = new ArrayList<VeraPdfValidationResultEntry>();

	public void add(VeraPdfValidationResultEntry entry) {
		results.add(entry);
	}

	public List<VeraPdfValidationResultEntry> getEntries() {
		return results;
	}

	public boolean isDone() {
		return validationDone;
	}

	public boolean isPdfValid() {
		return this.isPdfValid;
	}

	public void setPdfValid(boolean isPdfValid) {
		this.isPdfValid = isPdfValid;
	}

	public void resetIsDone() {
		validationDone = false;
	}

	public void setIsDone() {
		validationDone = true;
	}
}
