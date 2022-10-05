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

import java.util.List;

import org.projecthusky.cda.elga.generated.artdecor.base.Beilagen;
import org.projecthusky.cda.elga.narrative.AppendixNarrativeTextGenerator;
import org.projecthusky.common.hl7cdar2.POCDMT000040Component3;
import org.projecthusky.common.hl7cdar2.POCDMT000040Section;
import org.projecthusky.common.hl7cdar2.ST;
import org.projecthusky.common.hl7cdar2.StrucDocText;

public class BaseDocument  {

	protected POCDMT000040Component3 createComp3FreeText(POCDMT000040Section section, String text, String titleText) {
		POCDMT000040Component3 comp3 = new POCDMT000040Component3();
		StrucDocText structext = new StrucDocText();
		structext.setMediaType("text/plain");
		structext.getContent().add(text);
		section.setText(structext);

		ST stTitle = new ST();
		stTitle.setXmlMixed(titleText);
		section.setTitle(stTitle);
		comp3.setSection(section);
		return comp3;
	}

	protected Beilagen getAppendixSection(List<Appendix> appendices, String contentPrefix) {
		Beilagen appendix = new Beilagen();

		ST stTitle = new ST();
		stTitle.setXmlMixed("Beilagen");
		appendix.setHl7Title(stTitle);

		int index = 0;
		for (Appendix appendixDoc : appendices) {
			appendix.addHl7Entry(appendixDoc.getHl7CdaR2AppendixEntry(contentPrefix, index));
			index++;
		}

		StrucDocText text = new StrucDocText();
		AppendixNarrativeTextGenerator textbuilder = new AppendixNarrativeTextGenerator(appendix.getEntry(),
				appendices);
		text.getContent().add(textbuilder.toString());
		appendix.setHl7Text(text);

		return appendix;
	}

}
