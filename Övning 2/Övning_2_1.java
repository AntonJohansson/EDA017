import java.util.Scanner;

public class Övning_2_1{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Ange en starttid (h m):\t");

		int start_h = scan.nextInt();
		int start_m = scan.nextInt();

		System.out.print("Ange en sluttid (h m):\t");

		int slut_h = scan.nextInt();
		int slut_m = scan.nextInt();

		// Uträkningar
		int delta_m = (slut_h * 60 + slut_m) - (start_h * 60  + start_m);

		System.out.printf("Mellan tiderna %d:%d och %d:%d är %d minuter\n", start_h, start_m, slut_h, slut_m, delta_m);
	}
}
