
public class OptimalGuesser {

	/** Beskriver en spelare som gissar tal på ett optimalt sätt. */
	OptimalGuesser() {

	}

	/**
	 * Gissar tal å ett optimalt sätt tills rätt tal gissats. nbr är det objekt
	 * som håller reda på det tal som ska gissas. Returnerar antal gissningar
	 * som krävdes.
	 */
	int nbrGuesses(NumberToGuess nbr) {
		int min = nbr.getMin();
		int max = nbr.getMax();

		//max = 100; min = 0
		//guess = 50
		//nbr = 75
		
		
		int guess = 0, iterations = 0;

		// om rätt return
		// om > ta intervallet (max - guess)/2
		// om < ta intervallet (guess - min)/2
		// Upprepa

		while (true) {
			guess = (max + min) / 2;
			iterations++;
			
			if (nbr.isEqual(guess)) {
				return iterations;
			} else if (nbr.isBiggerThan(guess)) {
				min = guess;
			} else {
				max = guess;
			}
		}
	}
}
