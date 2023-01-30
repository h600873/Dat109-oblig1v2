package test;

import spillFiler.Brett;
import spillFiler.Spiller;
import spillFiler.Terning;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class StigespillTest {

	Brett brett;
	Spiller spiller;
	Terning terning;

	@BeforeEach
	void setUp() {
		brett = new Brett();
		spiller = new Spiller("navn", "farge");
		terning = new Terning();
	}

	@Test
	void trillTest() {
		int verdi = terning.trill();
		assertTrue(verdi >= 1 && verdi <= 6);
	}

	@Test
	void trekkTest() {
		assertEquals(1, spiller.getPos());
		spiller.trekk();
		assertNotEquals(1, spiller.getPos());
		spiller.setPos(100);
		spiller.trekk();
		assertEquals(100, spiller.getPos());
	}

	@Test
	void sjekkOmStigeSlangeTest() {
		assertEquals(brett.sjekkOmStigeSlange(1), -1);
		assertEquals(brett.sjekkOmStigeSlange(80), 100);
	}

	@Test
	void sjekkOmVinnerTest() {
		assertFalse(spiller.sjekkOmVinner());
		spiller.setPos(100);
		assertTrue(spiller.sjekkOmVinner());
	}

}