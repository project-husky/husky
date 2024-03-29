/*
 * This code is made available under the terms of the Eclipse Public License v1.0 
 * in the github project https://github.com/project-husky/husky there you also 
 * find a list of the contributors and the license information.
 * 
 * This project has been developed further and modified by the joined working group Husky 
 * on the basis of the eHealth Connector opensource project from June 28, 2021, 
 * whereas medshare GmbH is the initial and main contributor/author of the eHealth Connector.
 *
 */
package org.projecthusky.xua.saml2;

import java.util.List;

import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectConfirmationType;
import org.openehealth.ipf.commons.ihe.xacml20.stub.saml20.assertion.SubjectType;

/**
 * <!-- @formatter:off -->
 * <div class="en">Interface describing the methods of the SubjectBuilder.</div>
 * <div class="de">Interface welches die Methoden des SubjectBuilders beschreibt.</div>
 * <div class="fr"></div>
 * <div class="it"></div>
 * <!-- @formatter:on -->
 */
public interface SubjectBuilder extends SimpleBuilder<SubjectType> {
	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to add a SubjectConfirmation to the Subject to be build.</div>
	 * <div class="de">Methode um ein SubjectConfirmation dem zu buildenden Subject hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSubjectConfirmation
	 *  <div class="en">a {@link java.util.List} of {@link org.projecthusky.xua.saml2.SubjectConfirmation} to be set</div>
	 * 	<div class="de">eine {@link java.util.List} von {@link org.projecthusky.xua.saml2.SubjectConfirmation} die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectBuilder addSubjectConfirmations(SubjectConfirmationType aSubjectConfirmation);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the NameID.Format on the Subject.</div>
	 * <div class="de">Bildet das NameID.Format im Subject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNameIDFormat
	 *  <div class="en">the NameID.Format to be set</div>
	 * 	<div class="de">das NameID.Format welches gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	SubjectBuilder nameIDFormat(String aNameIDFormat);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the NameID.NameQualifier on the Subject.</div>
	 * <div class="de">Bildet das NameID.NameQualifier im Subject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNameIDNameQualifier
	 *  <div class="en">the NameID.NameQualifier to be set</div>
	 * 	<div class="de">das NameID.NameQualifier welches gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	SubjectBuilder nameIDNameQualifier(String aNameIDNameQualifier);

	/**
	 *
	 * <!-- @formatter:off -->
	 * <div class="en">Builds the NameID.Value on the Subject.</div>
	 * <div class="de">Bildet das NameID.Value im Subject.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aNameIDValue
	 *  <div class="en">the NameID.Value to be set</div>
	 * 	<div class="de">das NameID.Value welches gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 *  <!-- @formatter:on -->
	 */
	SubjectBuilder nameIDValue(String aNameIDValue);

	/**
	 * <!-- @formatter:off -->
	 * <div class="en">Method to set a list {@link org.projecthusky.xua.saml2.SubjectConfirmation}s of the SubjectConfirmation to be build.</div>
	 * <div class="de">Methode um eine liste von {@link org.projecthusky.xua.saml2.SubjectConfirmation} dem SubjectConfirmation hinzuzufügen.</div>
	 * <div class="fr"></div>
	 * <div class="it"></div>
	 *
	 * @param aSubjectConfirmations
	 *  <div class="en">a {@link java.util.List} of {@link org.projecthusky.xua.saml2.SubjectConfirmation} to be set</div>
	 * 	<div class="de">eine {@link java.util.List} von {@link org.projecthusky.xua.saml2.SubjectConfirmation} die gesetzt werden soll</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * @return
	 *  <div class="en">the actual instance of this builder</div>
	 *  <div class="de">die aktuelle Instanz des Builders</div>
	 *  <div class="fr"></div>
	 *  <div class="it"></div>
	 * <!-- @formatter:on -->
	 */
	SubjectBuilder subjectConfirmations(List<SubjectConfirmationType> aSubjectConfirmations);

}
