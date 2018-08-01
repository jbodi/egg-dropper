package eggDropper;

import java.util.ArrayList;
import java.util.List;

public class EggDropper {

	public static void main(String[] args) {
		int floors 	= 100;
		int eggs 	= 100;
		
		System.out.println("In a " + floors + "-floor skyscraper with " + eggs + " eggs, the minimun number of attempts of dropping an egg "
							+ "to find out the highest floor that doesn't break the eggs is: " + minEggDropper100(floors, eggs));
	}

	public static int minEggDropper100(int totalFloors, int eggs) {
		
		List<Integer> floors;
		
		//
		floors = new ArrayList<Integer>();
		for(int i = 1; i <= totalFloors; i++) {
			floors.add(i);
		}
		
		System.out.println(floors.size());
		
		
		return minEggDropperRec(floors, eggs);
	}
	
	public static int minEggDropperRec(List<Integer> floors, int eggs) {
		int tryFloor 	= (floors.size() / 2);
		int min 		= Integer.MAX_VALUE;
		int res			= 0;
		
		
		
		while(floors.size() != 0) {
			
			if(floors.size() == 1) {
				return 1;
			}
			
			if(eggs == 1) {
				return floors.size();
			}
			
			List<Integer> floorsAbove = new ArrayList<Integer>(); 
			floorsAbove.addAll(floors.subList(tryFloor, floors.size()));
			
			List<Integer> floorsBelow = new ArrayList<Integer>(); 
			floorsBelow.addAll(floors.subList(0, tryFloor));
			
			floors.removeAll(floorsAbove);
			floors.removeAll(floorsBelow);
			
			res = 1 + Math.max(minEggDropperRec(floorsAbove, eggs), minEggDropperRec(floorsBelow, eggs - 1));
			
//			System.out.println("huevos = " + eggs + "|| pisos = " + floors.size() );
//			System.out.println("res = " + res);
			
//			if(res < min) {
//				min = res;
//			}
			
		}
		
		return res;
	}
	
}
