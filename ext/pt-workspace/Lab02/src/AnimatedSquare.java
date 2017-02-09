import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.square.Square;

public class AnimatedSquare {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "DrawSquaresOnClick");

		Square sq = new Square(225, 225, 50);

		sq.draw(w);

		while (true) {
			w.waitForMouseClick();

			int n = 10;
			int dx = w.getMouseX() - sq.getX();
			int dy = w.getMouseY() - sq.getY();

			for (int i = 1; i <= n; i++) {
				sq.erase(w);
				sq.move(dx / n, dy / n);

				sq.draw(w);
				SimpleWindow.delay(10);
			}
		}
	}
}
