import se.lth.cs.pt.window.SimpleWindow;

public class LineDrawing {
	public static void main(String[] args) {
		SimpleWindow w = new SimpleWindow(500, 500, "LineDrawing");
		
		w.waitForMouseClick();
		w.moveTo(w.getMouseX(), w.getMouseY());
		
		while (true) {
			w.waitForMouseClick();
			w.lineTo(w.getMouseX(), w.getMouseY());
		}
	}
}
