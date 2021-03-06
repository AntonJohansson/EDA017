
public class DizzyTurtle extends RaceTurtle{
	int yrsel;

	public DizzyTurtle(RaceWindow w, int nbr, int yrsel) {
		super(w, nbr);
		
		this.yrsel = yrsel;
	}
	
	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	 * slumptal (heltal) mellan 1 och 6.
	 */
	public void raceStep(){
		super.raceStep();
		int r = random.nextInt(yrsel) - yrsel/2;
	
		// Bara så att sköldpaddorna garanteras att nå målet
		if(getY() > 400 && r < 100)r = -r;
		if(getY() < 0 && r > 0)r = -r;
		
		left(r);
	}
	
	/**
	 * Returnerar en läsbar representation av denna RaceTurtle,
	 * på formen "Nummer x" där x är sköldpaddans startnummer.
	 */
	public String toString(){
		return super.toString() + " - DizzyTurtle (Yrsel: " + yrsel + ")";
	}

}
