package cardgame;

import pair.Pair;
import pair.PairSequence;

public class Patiens {
	private static final int NBR_ITERATIONS = 200000;
	
	public static void main(String[] args){
		int solved = 0;
		
		for(int i = 0; i < NBR_ITERATIONS; i++){
			if(runPatiens())solved++;
		}
		
		double probability = ((double)solved)/((double)NBR_ITERATIONS);
		System.out.println("Sannolikheten för att patiensen skall gå ut vid " + NBR_ITERATIONS + "\niterationer uppskattas till " + probability + " %");
	}
	
	/*
	 * Kör en simulering av patiens.
	 * Returnerar true om patiensen gick ut,
	 * annars false
	 */
	
	public static boolean runPatiens(){
		PairSequence deck = new PairSequence(4, 13);
		
		int iteration = 1;
		while(deck.more()){
			Pair card = deck.pick();
			
			int number = (iteration % 3 == 0) ? 3 : iteration % 3;
			
			if(card.second() == number) return false;
			
			iteration++;
		}
		
		return true;
	}
}
