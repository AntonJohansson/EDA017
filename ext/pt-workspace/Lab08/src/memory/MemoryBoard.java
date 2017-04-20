package memory;

import java.util.Random;

public class MemoryBoard {
	private int size;
	private MemoryCardImage[][] images;
	private static Random random = new Random();
	
	/** Skapar ett memorybräde med size * size kort. backFileName är filnamnet 
	    för filen med baksidesbilden. Vektorn frontFileNames innehåller filnamnen 
	    för frontbilderna. */
	public MemoryBoard(int size, String backFileName, String[] frontFileNames) {
		this.size = size;
		
		createCards(backFileName, frontFileNames);
	}

	/* Skapar size * size / 2 st memorykortbilder.
	   Placerar ut varje kort på två slumpmässiga ställen på spelplanen. */
	private void createCards(String backFileName, String[] frontFileNames) {
		images = new MemoryCardImage[size][size];
		
		if(frontFileNames.length < size*size/2){
			System.err.println("Gav " + frontFileNames.length + " filnamn (front) till createCards(...). Förväntade " + size*size/2);
			return;
		}
		
		// Använder en annan algoritm, borde vara snabbare eftersom vi inte väljer
		// positioner som redan valts. Borde även vara mer minnesintensiv (?)
		
		String[] copyFileNames = frontFileNames.clone();
		int n = copyFileNames.length;
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				int index = random.nextInt(n);
				images[r][c] = new MemoryCardImage(copyFileNames[index], backFileName);
				
				// byt plats på n och index
				String tmp = copyFileNames[index];
				copyFileNames[index] = copyFileNames[n - 1];
				copyFileNames[n - 1] = tmp;
				
				n--;
				
				// Om vi når slutet så återställ n,
				// därmed placeras varje kort u två ggr.
				if(n == 0)n = copyFileNames.length; 
			}
		}
	}

	/** Tar reda på brädets storlek. */
	public int getSize() {
		return size;
	}
	
	/** Hämtar den tvåsidiga bilden av kortet på rad r, kolonn c.
	    Raderna och kolonnerna numreras från 0 och uppåt. */
	public MemoryCardImage getCard(int r, int c) {
		return images[r][c];
	}

	/** Vänder kortet på rad r, kolonn c. */
	public void turnCard(int r, int c) {
		images[r][c].turnCard();
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return images[r][c].isCardTurned();
	}
	
	/** Returnerar true om det är samma kort på rad r1, kolonn c2 som på rad r2, 
	    kolonn c2. */
	public boolean same(int r1, int c1, int r2, int c2) {
		return (images[r1][c1] == images[r2][c2]);
	}

	/** Returnerar true om alla kort har framsidan upp. */
	public boolean hasWon() {		
		for(int r = 0; r < size; r++){
			for(int c = 0; c < size; c++){
				if(!images[r][c].isCardTurned())return false;
			}
		}
		
		return true;
	}	
}
