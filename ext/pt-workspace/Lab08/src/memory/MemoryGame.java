package memory;

public class MemoryGame {
	public static void main(String[] args) {
		String[] frontFileNames = {"can.jpg", "flopsy_mopsy_cottontail.jpg",
				"friends.jpg", "mother_ladybird.jpg", "mr_mcgregor.jpg",
				"mrs_rabbit.jpg", "mrs_tittlemouse.jpg", "radishes.jpg" };
		
		MemoryBoard board = new MemoryBoard(4, "back.jpg", frontFileNames);
		MemoryWindow window = new MemoryWindow(board);
		
		window.drawBoard();
		
		int r1, c1, r2, c2, iterations = 0;
		while(!board.hasWon()){
			window.waitForMouseClick();
			r1 = window.getMouseRow();
			c1 = window.getMouseCol();
			
			board.turnCard(r1, c1);
			window.drawCard(r1, c1);
			
			window.waitForMouseClick();
			r2 = window.getMouseRow();
			c2 = window.getMouseCol();
			
			board.turnCard(r2, c2);
			window.drawCard(r2, c2);
			
			
			if(!board.same(r1, c1, r2, c2)){
				MemoryWindow.delay(1000);
				board.turnCard(r1, c1);
				board.turnCard(r2, c2);
				window.drawCard(r1, c1);
				window.drawCard(r2, c2);
			}
			
			iterations++;
		}
		
		System.out.println("Grattis! Det tog " + iterations + " försök!");
	}
}
