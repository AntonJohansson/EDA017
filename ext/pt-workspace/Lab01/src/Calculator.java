import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		System.out.println("Skriv två tal");
		Scanner scan = new Scanner(System.in);
		
		double nbr1 = scan.nextDouble();
		double nbr2 = scan.nextDouble();
		
		scan.close();
		
		double sum 		= nbr1 + nbr2;
		double diff 	= nbr1 - nbr2;
		double prod		= nbr1 * nbr2;
		double ratio	= nbr1 / nbr2;
		
		System.out.print(	"Summan av talen är\t\t" + sum +
							"\nSkillnaden mellan talen är\t" + diff + 
							"\nProdukten av talen är\t\t" + prod + 
							"\nKvoten mellan talen är\t\t" + ratio);
	}
}
