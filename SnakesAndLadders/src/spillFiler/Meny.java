package spillFiler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Enkel brukermeny for opprettelse av spillerobjekter, initialiserer
 * stigespillet.
 */
public class Meny {
	private static final int MIN_SPILLERE = 2;
	private static final int MAX_SPILLERE = 4;

	static ArrayList<Spiller> spillerList = new ArrayList<Spiller>();
	static ArrayList<String> fargeList = new ArrayList<>(Arrays.asList("Rød", "Blå", "Grønn", "Gul", "Sort", "Hvit"));

	public static void main(String[] args) {
		boolean gyldig = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Velkommen til stigespillet!");

		for (int i = 1; i <= MAX_SPILLERE && gyldig; i++) {

			String navn;
			// Gir brukeren valget om å avslutte etter hver opprettet spiller, så lenge 2
			// spillere er opprettet.
			if (i > MIN_SPILLERE && i < MAX_SPILLERE) {
				System.out.println("Tast 'q' for å avslutte, eller tast inn navn på ny spiller");
				navn = scanner.nextLine();
				if (navn.toLowerCase().equals("q")) {
					gyldig = false;
				}
			} else {
				System.out.println("Tast inn navn på Spiller " + i);
				navn = scanner.nextLine();
			}

			if (gyldig) {
				// Velger farge
				System.out.println("Velg farge på brikken:");
				String farge = velgFarge(scanner);

				// Oppretter ny spiller som legges inn i spillerlisten
				Spiller spiller = new Spiller(navn, farge);
				spillerList.add(spiller);
				System.out.println("Spiller " + i + ": " + spiller.getNavn() + ", opprettet med " + spiller.getFarge()
						+ " brikke.");
			}
		}
		scanner.close();
		Stigespill stigespill = new Stigespill();
	}

	/**
	 * Lar brukeren velge en farge fra en liste. Ved korrekt input fjernes så fargen
	 * i listen, slik at ingen andre brukere kan velge denne fargen. Inneholder
	 * while-løkker og try/catch for feilsikring.
	 *
	 * @param scanner enkelt passering av scanner som et parameter.
	 * @return fargen brukeren valgte.
	 */
	private static String velgFarge(Scanner scanner) {

		boolean gyldig = false;
		int i = 1;
		String farge = "";

		// Viser tilgjengelige farger og input for å velge gitt farge.
		for (String f : fargeList) {
			System.out.println("Tast " + i + " for " + f);
			i++;
		}

		while (!gyldig) {
			try {
				int f = Integer.parseInt(scanner.nextLine());

				if (f > 0 && f < i) { // Gyldig input.
					farge = fargeList.remove(f - 1);
					gyldig = true;
				} else { // Ugyldig input, tall samsvarer ikke med farge.
					System.out.println(f + " hører ikke til noe farge, prøv igjen.");
				}
			} catch (Exception e) { // Ugyldig input, kan ikke parses.
				System.out.println("Tast inn et tall mellom 1 og " + (i - 1));
			}
		}
		// Dersom gyldig er true, returner farge
		return farge;
	}
}
