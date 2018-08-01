package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import eggDropper.EggDropper;

class EggDropperTest {
	


	@Test
	void testMinEggDropper1FloorXEgg() {
		ArrayList<Integer> floor = new ArrayList<Integer>();
		floor.add(1);
		int minDrops = EggDropper.minEggDropperRec(floor, 1);
		
		assertEquals(1, minDrops);
	}

	@Test
	void testMinEggDropper5Floors1Egg() {
		ArrayList<Integer> floors = new ArrayList<Integer>();
		floors.add(1);
		floors.add(2);
		floors.add(3);
		floors.add(4);
		floors.add(5);
		int minDrops = EggDropper.minEggDropperRec(floors, 1);
		
		assertEquals(5, minDrops);
	}
	
}
