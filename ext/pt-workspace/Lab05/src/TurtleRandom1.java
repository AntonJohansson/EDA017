import se.lth.cs.pt.window.SimpleWindow;
import java.util.Random;

public class TurtleRandom1 {
	private static Random r = new Random();
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		
		Turtle t = new Turtle(w, 300, 300);
		t.penDown();

		for (int i = 0; i < 1000; i++){
			t.forward(randomIntIn(1, 10));
			t.left(randomIntIn(-180, 180));
			SimpleWindow.delay(10);
		}
	}
	
	private static int randomIntIn(int min, int max){
		return r.nextInt(max - min + 1) + min;
	}
}
