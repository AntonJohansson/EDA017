import java.util.Random;

public class RaceTurtle extends Turtle{
	protected static Random random = new Random();
	private int nbr;
	/**
	 * Skapar ene sköldpadda som ska springa i fönstret w och som har start-
	 * nummret nbr. Sköldpaddan startar med pennan nere och nosen vänd åt höger.
	 */
	public RaceTurtle(RaceWindow w, int nbr) {
		super(w, RaceWindow.getStartXPos(nbr), RaceWindow.getStartYPos(nbr));
		this.nbr = nbr;
		left(-90); // vrid så att sköldpaddan pekar åt höger
		penDown();
	}
	
	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	 * slumptal (heltal) mellan 1 och 6.
	 */
	public void raceStep(){
		forward(random.nextInt(6) + 1); // random nummer [1,6]
	}
	
	/**
	 * Returnerar en läsbar representation av denna RaceTurtle,
	 * på formen "Nummer x" där x är sköldpaddans startnummer.
	 */
	public String toString(){
		return "Nummer " + nbr;
	}

}
