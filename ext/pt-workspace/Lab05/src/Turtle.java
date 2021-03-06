import java.awt.Color;

import se.lth.cs.pt.window.SimpleWindow;

public class Turtle {
	private SimpleWindow w;
	private double x;
	private double y;
	private int alpha; // riktning i grader med avseende på +x-axeln.
	private boolean isPenDown;
	private Color color; // färg på linjen som ritas
	
	/** Skapar en sköldpadda som ritar i ritfönstret w. Från början 
	    befinner sig sköldpaddan i punkten x, y med pennan lyft och 
	    huvudet pekande rakt uppåt i fönstret (i negativ y-riktning). */
	public Turtle(SimpleWindow w, int x, int y) {
		this.w = w;
		this.isPenDown = false;
		this.color = Color.BLACK;
		
		turnNorth();
		jumpTo(x, y);
	}

	/** Konvertera vinkeln theta från grader till radianer **/
	private double toRadians(int theta){
		return theta * 2 * Math.PI / 360;
	}
	
	/** Sänker pennan. */
	public void penDown() {
		isPenDown = true;
	}
	
	/** Lyfter pennan. */
	public void penUp() {
		isPenDown = false;
	}
	
	/** Går rakt framåt n pixlar i den riktning huvudet pekar. */
	public void forward(int n) {
		w.moveTo(getX(), getY());
		w.setLineColor(color);

		double alphaRad = toRadians(alpha);
		x += n * Math.cos(alphaRad);
		y -= n * Math.sin(alphaRad);
		
		if (isPenDown){
			w.lineTo(getX(), getY());
		}
	}

	/** Vrider phi grader åt vänster runt pennan. */
	public void left(int beta) {
		alpha += beta;
	}

	/** Går till punkten newX, newY utan att rita. Pennans läge (sänkt
	    eller lyft) och huvudets riktning påverkas inte. */
	public void jumpTo(int newX, int newY) {
		x = newX;
		y = newY;
	}

	/** Återställer huvudriktningen till den ursprungliga. */
	public void turnNorth() {
		alpha = 90;
	}

	/** Ändra sköldpaddans färg **/
	public void setColor(Color color){
		this.color = color;
	}
	
	/** Tar reda på x-koordinaten för sköldpaddans aktuella position. */
	public int getX() {
		return (int) Math.round(x);
	}

 	/** Tar reda på y-koordinaten för sköldpaddans aktuella position. */
	public int getY() {
		return (int) Math.round(y);
	}
  
	/** Tar reda på sköldpaddans riktning, i grader från den positiva X-axeln. */
 	public int getDirection() {
 		return alpha;
	}
 	
 	/** Tar reda på sköldpaddans linjefärg **/
 	public Color getColor() {
 		return color;
 	}
}
