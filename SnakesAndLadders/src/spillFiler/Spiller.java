package spillFiler;

/**
 * Klasse for opprettelse av spiller.
 */
public class Spiller {

	private String navn;
	private String farge;
	private int pos;

	/**
	 * Oppretter et spillerobjekt og setter posisjonen lik 1.
	 *
	 * @param navn
	 * @param farge
	 */
	public Spiller(String navn, String farge) {
		this.navn = navn;
		this.farge = farge;
		this.pos = 1;
	}

	/**
	 * Gjør et trekk for en spiller. Sjekker om ny posisjon overskrider 100, for å
	 * så sjekke om spilleren landet på en stige eller slange.
	 *
	 * @return verdi av terningkastet
	 */
	public int trekk() {

		Terning terning = new Terning();
		int verdi = terning.trill();
		int nyPos = verdi + pos;

		// Oppdaterer kun posisjon dersom den ikke overskrider 100.
		if (nyPos <= 100) {
			pos += verdi;
		}
		return verdi;
	}

	/**
	 * Sjekker om spilleren er på rute 100.
	 *
	 * @return true dersom spilleren er på rute 100, false ellers.
	 */
	public boolean sjekkOmVinner() {
		return pos == 100;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getFarge() {
		return farge;
	}

	public void setFarge(String farge) {
		this.farge = farge;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}