import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String[] args){
		System.out.print("Skriv in min- och maxvärde för inverallet (format: min max): ");
		Scanner scanner = new Scanner(System.in);
		
		int min = scanner.nextInt();
		int max = scanner.nextInt();
		
		NumberToGuess number_gen = new NumberToGuess(min, max);
		
		System.out.printf("Datorn har valt ett värde i intervallet [%d, %d]\n", min, max);
		
		int guess = 0, iterations = 0;
		boolean answer_found = false;
		
		while(!answer_found){
			System.out.print("Gissa på ett tal: ");
			guess = scanner.nextInt();
			
			if (number_gen.isEqual(guess)){
				System.out.printf("\tGrattis! Du har gissat rätt efter %d förösk\n", iterations);
				answer_found = true;
			}else if (number_gen.isBiggerThan(guess)){
				System.out.println("\tDet gissade talet är för litet!");
			}else{
				System.out.println("\tDet gissade talet är för Stort!");
			}
			
			iterations++;
		}
		
		scanner.close();
	}
}
