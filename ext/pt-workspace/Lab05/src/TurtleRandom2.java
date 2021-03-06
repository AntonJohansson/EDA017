import se.lth.cs.pt.window.SimpleWindow;

import java.awt.Color;
import java.util.Random;

public class TurtleRandom2 {
	private static Random r = new Random();
	
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(600, 600, "TurtleDrawSquare");
		
		Turtle t1 = new Turtle(w, 250, 250);
		Turtle t2 = new Turtle(w, 350, 350);
		t1.penDown();
		t2.penDown();
		w.setLineWidth(2);
		
		double d;
		while((d = distance(t1, t2)) >= 50){
			t1.forward(randomIntIn(1, 10));
			t1.left(randomIntIn(-180, 180));
			t2.forward(randomIntIn(1, 10));
			t2.left(randomIntIn(-180, 180));
			
			Color color = new Color((int)(255 * 50 / d), 0, 0);
			t1.setColor(color);
			t2.setColor(color);
			
			SimpleWindow.delay(10);
		}
	}

	private static double distance(Turtle t1, Turtle t2){
		int dx = t1.getX() - t2.getX();
		int dy = t1.getY() - t2.getY();
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	private static int randomIntIn(int min, int max){
		return r.nextInt(max - min + 1) + min;
	}
}
