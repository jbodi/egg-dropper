package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import eggDropper.EggDropper;

class EggDropperTest {
	


	@Test
	void testMinEggDropper1FloorXEgg() {

		int minDrops = EggDropper.minEggDropperCalc(1, 20);
		
		assertEquals(1, minDrops);
	}

	@Test
	void testMinEggDropper5Floors1Egg() {

		int minDrops = EggDropper.minEggDropperCalc(5, 1);
		
		assertEquals(5, minDrops);
	}
	
}
