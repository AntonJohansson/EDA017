import java.util.ArrayList;

public class TurtleRace {
	private static int NBR_OF_TURTLES = 8;
	
	public static void main(String[] args){
		RaceWindow w = new RaceWindow();
		
		ArrayList<RaceTurtle> turtleList = new ArrayList<RaceTurtle>();
		ArrayList<RaceTurtle> goalList = new ArrayList<RaceTurtle>();
		
		for(int i = 0; i < NBR_OF_TURTLES; i++){
			turtleList.add(new RaceTurtle(w, (i + 1)));
		}
		
		RaceTurtle t;
		while(turtleList.size() > 0){
			for(int i = 0; i < turtleList.size(); i++){
				t = turtleList.get(i);
				if(t.getX() < RaceWindow.X_END_POS){
					t.raceStep();	
				}else{
					goalList.add(t);
					turtleList.remove(t);
				}
			}
			
			RaceWindow.delay(10);
		}
		
		for(int i = 0; i < 3; i++){
			System.out.println("På plats " + (i + 1) + ":\t" + goalList.get(i));
		}
		
		/*
		 * Loppet kommer gynna sköldpaddor med lägre startnummer i.o.m.
		 * att vi loopar från lägre till högre startnummer, paddor med lägre
		 * nummer kommer få sin position updaterad först och jämförelsen med
		 * mållinjen görs tidigare.
		 * 
		 * Ett sätt att fixa detta skulle vara att först uppdatera positonen av
		 * alla sköldpaddor och sedan kolla vilka som passerat mållinjen,
		 * då måste man dock ta hänsyn till delade platser.
		 */
	}
}
