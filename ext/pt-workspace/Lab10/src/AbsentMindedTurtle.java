
public class AbsentMindedTurtle extends RaceTurtle{
	int tankSpriddhet;
	
	public AbsentMindedTurtle(RaceWindow w, int nbr, int tankSpriddhet) {
		super(w, nbr);
		
		this.tankSpriddhet = tankSpriddhet;
	}
	
	/**
	 * Låter sköldpaddan gå framåt ett steg. Stegets längd ges av ett
	 * slumptal (heltal) mellan 1 och 6.
	 */
	public void raceStep(){
		if((random.nextInt(101)) > tankSpriddhet){
			super.raceStep();
		}
	}
	
	/**
	 * Returnerar en läsbar representation av denna RaceTurtle,
	 * på formen "Nummer x" där x är sköldpaddans startnummer.
	 */
	public String toString(){
		return super.toString() + " - AbsentMindedTurtle (" + tankSpriddhet + "% frånvarande)";
	}

}
