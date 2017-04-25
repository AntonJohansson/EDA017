package memory;

import pair.Pair;
import pair.PairSequence;

public class MemoryBoard {
	private int size;
	private MemoryCardImage[][] images;
	private boolean[][] cardTurned;
	
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
		cardTurned = new boolean[size][size];
		PairSequence seq = new PairSequence(size, size);
		
		if(frontFileNames.length < size*size/2){
			System.err.println("Gav " + frontFileNames.length + " filnamn (front) till createCards(...). Förväntade " + size*size/2);
			return;
		}

		Pair p1, p2;
		for(int i = 0; i < size*size/2; i++){
			MemoryCardImage image = new MemoryCardImage(frontFileNames[i], backFileName);
			
			p1 = seq.pick();
			images[p1.first()][p1.second()] = image;
			
			p2 = seq.pick();
			images[p2.first()][p2.second()] = image;
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
		cardTurned[r][c] = !cardTurned[r][c];
	}
	
	/** Returnerar true om kortet r, c har framsidan upp. */
	public boolean frontUp(int r, int c) {
		return cardTurned[r][c];
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
				if(!cardTurned[r][c])return false;
			}
		}
		
		return true;
	}	
}
