
public class TestOptimalGuesser {
	public static void main(String[] args){
		OptimalGuesser guesser = new OptimalGuesser();
		NumberToGuess number = new NumberToGuess(0, 100);
		
		int n = guesser.nbrGuesses(number);
		
		System.out.println(n);
	}
}
