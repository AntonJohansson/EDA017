
public class MoleTurtle extends RaceTurtle{

	public MoleTurtle(RaceWindow w, int nbr) {
		super(w, nbr);
	}
	
	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	 * slumptal (heltal) mellan 1 och 6.
	 */
	public void raceStep(){
		super.raceStep();
		
		if(random.nextBoolean())penDown();
		else penUp();
	}
	
	/**
	 * Returnerar en läsbar representation av denna RaceTurtle,
	 * på formen "Nummer x" där x är sköldpaddans startnummer.
	 */
	public String toString(){
		return super.toString() + " - MoleTurtle";
	}

}
