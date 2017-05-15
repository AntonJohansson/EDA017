package pair;

import java.util.Random;

public class PairSequence {
	private int n;
	private Pair[] pairs;
	private static Random rand = new Random();
	
	/** Skapar en sekvens av alla talpar (a,b) sådana att
	    0 <= a < rows  och  0 <= b < cols */
	public PairSequence(int rows, int cols) {
		n = rows * cols;
		pairs = new Pair[n];
		
		int pos = 0;
		for(int r = 0; r < rows; r++){
			for(int c = 0; c < cols; c++){
				pairs[pos] = new Pair(r, c);
				pos++;
			}
		}
	}

	/** Undersöker om det finns fler par i sekvensen. */
	public boolean more() {
		return n > 0;
	}

	/** Hämtar ett slumpmässigt valt talpar ur sekvensen. Sekvensen
    	blir ett element kortare. Om sekvensen är tom returneras null. */
	public Pair pick() {
		
		Pair p = null;

		if(more()){
			int rand = PairSequence.rand.nextInt(n);
			p = pairs[rand];
			pairs[rand] = pairs[n - 1];
			n--;
		}

		
		return p;
	}
}
