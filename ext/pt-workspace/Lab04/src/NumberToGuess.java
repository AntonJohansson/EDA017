import java.util.Random;

public class NumberToGuess {
	private int m_random_num;
	private int m_max;
	private int m_min;
	
	/** Skapar ett objekt med ett slumpmässigt valt heltal i 
	    intervallet [min, max]. */
	public NumberToGuess(int min, int max) {
		m_max = max;
		m_min = min;
		
		Random random = new Random();
		// random.nextInt(n) ger [0, n[, därav +1
		m_random_num = random.nextInt(m_max - m_min + 1) + m_min;
	}

	/** Tag reda på minsta möjliga värde talet kan ha. */
	public int getMin() {
		return m_min;
	}

	/** Tag reda på största möjliga värde talet kan ha. */
	public int getMax() {
		return m_max;
	}

	/** Tar reda på om talet är lika med guess. */
	public boolean isEqual(int guess) {
		return (guess == m_random_num);
	}

	/** Tar reda på om talet är större än guess. */
	public boolean isBiggerThan(int guess) {
		return (guess < m_random_num);
	}
}
