package cardreader;

public class CardReaderTest {
	public static void main(String[] args){
		CardReaderTest tester = new CardReaderTest();
		
		tester.testUserTable();
	}
	
	public void testUserTable(){
		UserTable utable = new UserTable();
		User u;
		
		if ((u = utable.find(24073)) != null)System.out.printf("Kort 24073 OK: %s\n", u.toString());
		else System.out.println("Fel: Kort 24073 gav ingen användare!");
		
		if ((u = utable.find(24074)) != null)System.out.printf("Kort 24074 OK: %s\n", u.toString());
		else System.out.println("Fel: Kort 24074 gav ingen användare!");
		
		if ((u = utable.findByName("Jens Holmgren")) != null)System.out.printf("Användaren Jens Holmgren OK: %s\n", u.toString());
		else System.out.println("Fel: Användaren Jens Holmgren hittades inte");
	}
}
