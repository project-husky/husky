package org.ehealth_connector.cda;

import java.util.ArrayList;
import java.util.List;

import org.ehealth_connector.common.Name;
import org.openhealthtools.mdht.uml.cda.CDAFactory;
import org.openhealthtools.mdht.uml.hl7.datatypes.PN;

public class Person extends MdhtPersonFacade<org.openhealthtools.mdht.uml.cda.Person> {

	protected Person() {
		super(CDAFactory.eINSTANCE.createPerson());
	}

	/**
	 * Created a person with the given name
	 * 
	 * @param name
	 */
	public Person(Name name) {
		this();
		addName(name);
	}

	protected Person(org.openhealthtools.mdht.uml.cda.Person mdht) {
		super(mdht);
	}

	/**
	 * <div class="en">Adds the name.</div> <div class="de"></div>
	 * <div class="fr"></div> <div class="it"></div>
	 *
	 * @param name
	 *          name
	 */
	public void addName(Name name) {
		getMdht().getNames().add(name.getMdhtPn());
	}

	/**
	 * <div class="en">Gets the names.</div> <div class="de">Liefert alle
	 * Namen</div> <div class="fr"></div> <div class="it"></div>
	 *
	 * @return <div class="en">the names</div>
	 */
	@Override
	public List<Name> getNames() {
		final List<Name> nl = new ArrayList<Name>();
		for (final PN mName : getMdht().getNames()) {
			final Name name = new Name(mName);
			nl.add(name);
		}
		return nl;
	}
}
