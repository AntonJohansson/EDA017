import java.util.Scanner;

public class Övning_1_4{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		System.out.println("Skriv in värdet på variablerna a och b.");

		System.out.print("a = ");
		int a = scan.nextInt();
		System.out.print("b = ");
		int b = scan.nextInt();

		scan.close();

		int tmp = a;
		a = b;
		b = tmp;

		System.out.println("Swapped inputs: a = " + a + "; b = " + b);
	}
}
