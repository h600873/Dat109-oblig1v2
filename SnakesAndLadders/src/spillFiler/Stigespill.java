package spillFiler;

import java.util.ArrayList;

/**
 * Klasse som simulerer stigespillet
 */
public class Stigespill {
	ArrayList<Spiller> spillerList = Meny.spillerList;
	Brett brett = new Brett();
	boolean vinner = false;

	/**
	 * Initialiserer stigespillet
	 */
	public Stigespill() {
		while (!vinner) {
			spillRunde();
		}
	}

	/**
	 * Starter en runde med stigespill.
	 */
	private void spillRunde() {
		for (Spiller spiller : spillerList) {
			if (!vinner) {
				spillTrekk(spiller);
			}
		}
	}

	/**
	 * Gjør et trekk for en spiller.
	 *
	 * @param spiller spilleren som skal gjøre trekket sitt
	 */
	private void spillTrekk(Spiller spiller) {
		System.out.println("* * * * * * * * * * * * *\n" + spiller.getNavn() + " (" + spiller.getFarge() + ") sin tur");
		int startPos = spiller.getPos();
		int terningkast = spiller.trekk();

		// Oppdaterer spillerens posisjon dersom h*n står på en stige eller slange.
		if (brett.sjekkOmStigeSlange(spiller.getPos()) > 0) {
			spiller.setPos(brett.sjekkOmStigeSlange(spiller.getPos()));
		}

		vinner = spiller.sjekkOmVinner();
		skrivTrekk(spiller, startPos, terningkast);

		// Rekursivt kall dersom spilleren får terningkast 6.
		if (terningkast == 6 && !vinner) {
			System.out.println("Ny tur, siden " + spiller.getNavn() + " fikk terningkast 6!");
			spillTrekk(spiller);
		}
	}

	/**
	 * Skriver ut trekket i konsollen.
	 *
	 * @param spiller     spilleren som skal skrives trekket for
	 * @param startPos    hvor han startet turen sin
	 * @param terningkast terningkastet han fikk
	 */
	private void skrivTrekk(Spiller spiller, int startPos, int terningkast) {

		System.out.println("Terningkast " + terningkast + "!");
		int nyPos = startPos + terningkast;

		// Utskriftshåndtering for flytt over rute 100.
		if (nyPos > 100) {
			System.out.println("Kan ikke flytte lengre enn rute 100...");
			System.out.println("(" + spiller.getFarge() + " forblir på rute " + spiller.getPos() + ")");
		} else {
			System.out.println(spiller.getFarge() + " flyttet seg fra rute " + startPos + " til " + nyPos);

			// Utskriftshåndtering dersom spilleren møtte en stige eller slange.
			int offset = spiller.getPos() - nyPos;
			if (offset > 0) {
				System.out.println("På rute " + nyPos + " er det en stige! " + spiller.getFarge() + " klatret opp "
						+ offset + " steg, til rute " + spiller.getPos() + "!");
			} else if (offset < 0) {
				System.out.println("På rute " + nyPos + " er det en slange! " + spiller.getFarge() + " falt ned "
						+ Math.abs(offset) + " steg, til rute " + spiller.getPos() + "!");
			}
		}
		if (vinner) {
			System.out.println(spiller.getNavn() + " (" + spiller.getFarge() + ") vant! Gratulerer!");
		}
	}
}