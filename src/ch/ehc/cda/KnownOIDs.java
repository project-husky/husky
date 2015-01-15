package ch.ehc.cda;

/**
 * Bekannte und häufig gebrauchte Identifikationsdomänen
 * <ul>
 * <li>Global Location Number (GLN): 1.3.88</li>
 * <li>Global Trade Item Number (GTIN): 1.3.160</li>
 * </ul>
 */
public enum KnownOIDs {

		/**
		 * OID: 2.16.756.5.30.1.127.3.1.20080401.1 <div class="de">Krankheiten
		 * und Unfallfolgen (VVK-EDI, Kapitel 2.1.1)</div> <div
		 * class="fr">Désignation de la maladie ou de la séquelle d’accident
		 * (OCA-DFI, chapitre 2.1.1)</div>
		 */
		IcrDha080401Disease ("1.3.88"),
		/**
		 * OID: 1.3.88 <div class="en">Global Location Number</div>
		 */
		GLN ("1.3.88"),
		/**
		 * OID: 1.3.160 <div class="en">Global Trade Item Number</div>
		 */
		GTIN ("1.3.160"),
		/**
		 * OID: 2.16.756.5.32 <div class="de">AHV Nummer (die Neue)</div> <div
		 * class="fr">No AVS (le nouveaux)</div>
		 */
		SwissSSN ("2.16.756.5.32"),
		/**
		 * OID: 2.16.756.5.31 <div class="de">AHV Nummer (die Alte)</div> <div
		 * class="fr">No AVS (le vieil)</div>
		 */
		SwissSSNDeprecated ("2.16.756.5.31"),
		/**
		 * OID: 2.16.756.5.31 <div class="de">eHealth Connector V1</div> <div
		 * class="fr">eHealth Connector V1</div>
		 */
		EHealthConnectorV1 ("2.16.756.5.30.1.139.1.1.1");
	
	private String knownOID;
	
	KnownOIDs(String oid) {
		this.knownOID = oid;
	}
	
	public String get() {
		return this.knownOID;
	}

	public String knownOID(ch.ehc.cda.KnownOIDs gln) {
		switch (gln) {
		case IcrDha080401Disease:
			return "2.16.756.5.30.1.127.3.1.20080401.1";
		case GLN:
			return "1.3.88";
		case GTIN:
			return "1.3.160";
		case SwissSSN:
			return "2.16.756.5.32";
		case SwissSSNDeprecated:
			return "2.16.756.5.31";
		case EHealthConnectorV1:
			return "2.16.756.5.30.1.139.1.1.1";
		default:
			return "undefined";
		}
	}
}
