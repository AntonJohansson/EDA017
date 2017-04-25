package cardreader;

public class CardReaderTest {
	public static void main(String[] args){
		CardReaderTest tester = new CardReaderTest();
		
		UserTable utable = new UserTable();
		
		System.out.println("\n\n# Testar find/findByName");
		tester.testUserTable(utable);
		
		/*
		 * UserTable lyckas inte hitta något av kortnummren och hittar inte Jens Holmgren.
		 * Förväntat resultat (från users.txt):
		 * - 24073 ger Lisbeth Hellström
		 * - 24074 ger Birgitta Bergström
		 * - Jens Holmgren borde hittas med kortnummret 97368
		 */
		
		/*
		 * Jens Holmgren hittades inte för att linjärssökningen i findByName var
		 * felimplementerad, den jämförde det första elementet och returnerar
		 * null om det första elementet inte var det sökta.
		 */
		
		/*System.out.println("\n\n## Testar UserTable.print()");
		tester.testPrintTable(utable);*/
		
		/*System.out.println("\n\n## Testar UserTable.print() med testanvändare");
		User u = new User(1234, "TestAnvändare");
		utable.add(u);
		tester.testPrintTable(utable);*/	
		
		/*
		 * metoden UserTable.add(...) används både i detta exempel och av
		 * konstruktorn i UserTable för att lägga till användare, finns något
		 * fel i denna metod.
		 * 
		 * borde ge 20001 användare i systemet
		 * 
		 * Användarna i systemet n uppdaterades inte, så alla 
		 * användares får samma plats (0) och eftersom
		 * print() metoden tror att vetkorn innehåller 0
		 * element så skriver den ej ut något.
		 */
		
		System.out.println("\n\n## testFind()");
		System.out.println("utable.testFind() : " + utable.testFind());
		
		/*
		 * Felet var att low < high användes ist. för low <= hight
		 * detta leder till att fallen då low == high inte undersöks,
		 * dvs. fallen som är "svårast" att hitta och kräver flest
		 * iterationer.
		 */
		

	}
	
	public void testUserTable(UserTable utable){
		User u;
		
		if ((u = utable.find(24073)) != null)System.out.printf("Kort 24073 OK: %s\n", u.toString());
		else System.out.println("Fel: Kort 24073 gav ingen användare!");
		
		if ((u = utable.find(24074)) != null)System.out.printf("Kort 24074 OK: %s\n", u.toString());
		else System.out.println("Fel: Kort 24074 gav ingen användare!");
		
		if ((u = utable.findByName("Jens Holmgren")) != null)System.out.printf("Användaren Jens Holmgren OK: %s\n", u.toString());
		else System.out.println("Fel: Användaren Jens Holmgren hittades inte");
		
		
	}
	
	public void testPrintTable(UserTable utable){
		utable.print();
	}
}
