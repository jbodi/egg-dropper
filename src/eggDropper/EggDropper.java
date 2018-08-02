package eggDropper;

public class EggDropper {

	public static void main(String[] args) {
		
		System.out.println("In a 100-floor skyscraper with 100 eggs, the minimun number of attempts of dropping an egg "
							+ "to find out the highest floor that doesn't break the eggs is: " + minEggDropper100());
		
		System.out.println("In a 100-floor skyscraper with 2 eggs, the minimun number of attempts of dropping an egg "
				+ "to find out the highest floor that doesn't break the eggs is: " + minEggDropper2eggs100Floors());
		
		
		int floors 	= 2;
		int eggs	= 0;
		
		System.out.println("In a " + floors + "-floor skyscraper with " + eggs + " eggs, the minimun number of attempts of dropping an egg "
				+ "to find out the highest floor that doesn't break the eggs is: " + minEggDropperCalc(floors, eggs));
	}

	public static int minEggDropper100() {
				
		return minEggDropperCalc(100, 100);
	}
	
	public static int minEggDropper2eggs100Floors() {
		
		return minEggDropperCalc(100, 2);
	}
	
	public static int minEggDropperCalc(int floors, int eggs) {
		
		//The minimum number of egg drops we need to find the criticalFloor, the highest floor we can throw
		//an egg without breaking the egg its minDrops100. To calculate this number we need to calculate
		//all the posible combination that can happen and save for each floor the minimum number of throws.
		//We calculate this dropping the eggs from every floor.

		
		//We are going to use a matrix to save all the different combinations that could happen.
		//This matrix is a matrix of (floors + 1) X (eggs + 1). We add 1 because we need the combination
		//with 0 eggs and 0 floors too.
		int[][] eggDropperMatrix = new int[floors + 1][eggs + 1];
		
		//Firstly, for 0 floors and 0 eggs its will always be a 0:
		eggDropperMatrix[0][0] = 0;
		
		//Then, with 0 eggs you can't throw any eggs. Same with 0 floors:
		for(int i = 1; i <= floors; i++) {
			eggDropperMatrix[i][0] = 0;
		}
		
		for(int i = 1; i <= eggs; i++) {
			eggDropperMatrix[0][i] = 0;
		}
		
		//With only 1 egg, we need to do the same throws as floors
		for(int i = 1; i <= floors; i++) {
			eggDropperMatrix[i][1] = i;
		}
		
		//And with 1 floor we only need 1 throw.
		for(int i = 1; i <= eggs; i++) {
			eggDropperMatrix[1][i] = 1;
		}
		
		//Then is necessary to fill all the other elements of the matrix.
		//Iteration in the matrix. It starts at index 2 in both axis as we had already filled the elements before.
		for(int x = 2; x <= floors; x++) {
			
			for(int y = 2; y <= eggs; y++) {
				
				//We need to save the minimum number of throws so a variable "minimum" its necessary for each
				//element in the matrix. This value is saved in this same element. The default its the maximum
				//possible integer so we can be sure it's going to change.
				eggDropperMatrix[x][y] = Integer.MAX_VALUE;
				
				//As we need to try every combination we are going to "throw" an egg from every floor and then lookup
				//for the maximum value from floor 1 to reach floor 'x'.
				for(int i = 1; i <= x; i++) {
					
					//We need the maximum element for the next throw between the element if the eggs does'nt break
					//(so we have the same number of eggs but we only try with the number of the upper floors)
					//and when it does break (1 egg less and the same floors we are now minus 1). 
					//We add 1 throw more to the result, this "throw".
					int numberOfThrows = 1 + Math.max(eggDropperMatrix[x - i][y], eggDropperMatrix[i - 1][y - 1]);
					
					//As its said before, we need to save the minimum for each element.
					if(numberOfThrows < eggDropperMatrix[x][y]) {
						eggDropperMatrix[x][y] = numberOfThrows;
					}
					
				}
			}
		}
		
		//Finally, we return the element we were looking for
		return eggDropperMatrix[floors][eggs];
	}
	
}
